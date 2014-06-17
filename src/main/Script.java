/*
 * This class allows running custom scripts using Beanshell as interpreter for
 * the commands. The goal is to provide direct access to most of the features
 * within the builder without need to implement them manually.
 */
package main;

import bsh.EvalError;
import bsh.Interpreter;
import definitions.is;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import script.Plugin;

//import script.log;


/**
 *
 * @author Nuno Brito, 21st of December 2012 in Darmstadt, Germany.
 */
public class Script {
    
    // general place to hold to retrieve settings
    HashMap<String, Object> settings = new HashMap<String, Object>();

   // StudioUI2 UI = core.studio;
    
    public Script(Properties settings){
    }

    public Script() {
    }
    
    
    /**
     * Runs a script from the disk, the script must be based on Beanshell
     * syntax
     * @param scriptFile File that contains the script instructions
     * @param what Method that will be run inside the script
     * @param className The type class that is expected on the script
     */
    public void run(File scriptFile, String what, String className){
        // is this a java-like beanshell?
        if(scriptFile.getName().contains(".java")){
            runJava(scriptFile, what, className);
            return;
        }
        
        // shall we interpret this file?
        if(scriptFile.exists()==false){
            script.log.write(is.NOTFOUND, "Couldn't find the mentioned script"
                    + " at %1", scriptFile.getAbsolutePath());
            return;
        }
            try {// let's start
            // the bean shell instance with our settings
            Interpreter runScript = new Interpreter();
            // prepare the interpreted script with our imports and settings
            addDefinitions(runScript, scriptFile);
            
            // Interpret the settings file
            runScript.source(scriptFile.getAbsolutePath());
            
            // get the objects back from running
            settings = (HashMap<String, Object>) runScript.get("settings");
            //log = (Log) runScript.get("result");
            
            // run the referred method at the settings file
            if(what != null){
                runScript.eval(what + "();");
            }
            } catch (EvalError e){
                script.log.write(is.ERROR, "Error while interpreting %1, the "
                        + "error message is: %2"
                        , scriptFile.getAbsolutePath(), e.getLocalizedMessage());
               // e.printStackTrace();
            } catch (IOException e) {
                script.log.write(is.ERROR, "Error while interpreting %1, the "
                        + "error message is: %2"
                        , scriptFile.getAbsolutePath(), e.getLocalizedMessage());
                // e.printStackTrace();
        }
        // all done.
        
            // all done.
   }      
    
    /**
     * Run the beanshell script without specifying a method
     */
//    public void run(File Script){
//        run(Script, null);
//    }
    
    
    /**
     * Get the general properties object. Useful for overriding the default
     * settings with values added on the script
     * @return 
     */
    public HashMap<String, Object> getSettings() {
        return settings;
    }

    public void setSettings(HashMap<String, Object> settings) {
        this.settings = settings;
    }
    
    
    void addDefinitions(Interpreter runScript, File scriptFile) 
            throws EvalError{
    // inject our parameters object
            //runScript.set("log", log);
            runScript.set("temp", core.temp);
            runScript.set("settings", settings);
            runScript.set("thisFile", scriptFile);
            runScript.set("thisDir", scriptFile.getParentFile());
            //runScript.set("list", core.studio.getList());
            
            runScript.eval(
                      "import main.core;"
                    + "import script.log;"
                    + "import definitions.is;"
                    + "import definitions.Messages;"
                    + "import java.io.File;"
                    + "import javax.swing.JEditorPane;"
                    + "import javax.swing.JList;"
                    + "import javax.swing.JTree;"
                    + "import utils.SortedListModel;"
                    + "import GUI.plugins;"
                    + "import GUI.ListItem;"
                    + "import GUI.swingUtils;"
                    + "import GUI.StudioUI2;"
                    + "import GUI.Actions;"
                    + "import www.WebRequest;"
                    );
    }

    /**
     * A beanshell script adapted for being edited like a Java file 
     * @param scriptFile The file where the beanshell script is located
     * @param methodName The method that we want to run
     * @param className Java-like type of class used by the script
     */
    public void runJava(File scriptFile, String methodName, String className) {
        // shall we interpret this file?
        if(scriptFile.exists()==false){
            script.log.write(is.NOTFOUND, "SC23 - Couldn't find script file"
                    + " %1", scriptFile.getAbsolutePath());
            return;
        }
        
        // read the text file
        String rawText = utils.files.readAsString(scriptFile);
        String[] lines = rawText.split("\n");
        String codeText = "";
        
        boolean // used for speeding up line interpretation
                noPackage = true,
                noClass = true;
        
        // iterate each line
        for(String line : lines){
//            if(line.contains("//<---")){
//                continue;
//            }
            // overrides are not accepted by beanshell language
            if(line.contains("@Override")){
                codeText = codeText.concat("\n");
                continue;
            }
            
            if(noPackage)
            if(line.startsWith("package ")){
                noPackage = false;
                codeText = codeText.concat("\n");
                continue;
            }
            
            // replace the class statement with an object statement
            if(noClass){
                if((line.startsWith("public class "))){
                    line = 
                       className +" plugin = new " + className + "(){"
                     + "File thisFile = global.thisFile;"
                     + "File thisFolder = global.thisFolder;"                        
                        ;
                
                    noClass = false;
                }
                }
                // add this line, along with a line break since they were removed
                codeText = codeText.concat(line + "\n");
            
        }
            
        // need to add a ; in the end of this plugin object
        codeText = codeText + ";";
            try {// let's start
                
            // the bean shell instance with our settings
            Interpreter runScript = new Interpreter();
            
            //core.thisFile = scriptFile;
            addDefinitions(runScript, scriptFile);
            
            runScript.set("global.thisFile", scriptFile);
            runScript.set("global.thisFolder", scriptFile.getParentFile());
            
            runScript.set("temp", core.temp);
            runScript.set("settings", settings);
            
            // do the interpretation of our script
            doInterpretation
                    (codeText, className, scriptFile, methodName, runScript);

            } catch (Exception e){
                script.log.write(is.ERROR, "SC224 Error interpreting %2() on "
                        + "%1"
                        , scriptFile.getAbsolutePath(), methodName);
                e.printStackTrace();
                //System.err.println(codeText);
            }
            // all done.
    }
    
    /**
     * This method is used by runJava() to ease the processing between different
 types of plugin, triggers and whatever else comes in the future
     * @param className The type of class that we are processing
     * @param runScript The instance of the script
     */
    void doInterpretation(String sourceCode, String className, 
            File scriptFile, String methodName, Interpreter runScript) throws Exception{
            // run the code        
            runScript.eval(sourceCode);
            
            // react to the case that this is a normal plugin
            if(className.equals(is.plugin)){
                // extract the plugin object from the script
                Plugin plugin = (Plugin) runScript.get("plugin");
                // if no method is specified, run the initial method
                if(methodName == null){
                    plugin.startup();
                    return;
                }
                // special consideration for special commands
                if(methodName.contains("=")){
                    // run whatever is requested here
                    runScript.eval(methodName);
                }
                else{
                // otherwise, just run the requested method
                runScript.eval("plugin." + methodName + "();");
                // no need to continue
                }
            }
            // all done
    }
    
}
