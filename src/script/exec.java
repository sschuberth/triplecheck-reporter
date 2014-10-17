/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-14T15:32:15Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: exec.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> 
 * This class allows running custom scripts using Beanshell as interpreter for
 * the commands. The goal is to provide direct access to most of the features
 * within the builder without need to implement them manually.</text> 
 */


package script;

import main.*;
import bsh.EvalError;
import bsh.Interpreter;
import definitions.is;
import java.io.File;

/**
 *
 * @author Nuno Brito, 21st of December 2012 in Darmstadt, Germany.
 * @rewritten Nuno Brito on 14th of May 2014 in Darmstadt, Germany.
 */
public class exec {
   
    private static void addDefinitions(Interpreter runScript, File scriptFile) 
            throws EvalError{
            // inject our parameters object
            runScript.set("temp", engine.temp);
            runScript.set("settings", engine.settings);
            runScript.set("thisFile", scriptFile);
            runScript.set("thisDir", scriptFile.getParentFile());
            // define what we want to include by default
            final String definitions = 
                      "import main.core;"
                    + "import script.log;"
                    + "import definitions.is;"
                    + "import definitions.Messages;";
            // get this code inside the interpreter
            runScript.eval(definitions);
    }

    /**
     * A beanshell script adapted for being edited like a Java file 
     * @param scriptFile The file where the beanshell script is located
     * @param className Java-like type of class used by the script
     * @return      The plugin object that is represented as "plugin"
     */
    public static Object runJava(File scriptFile,String className) {

        
        // read the text file
        String rawText = utils.files.readAsString(scriptFile);
        String[] lines = rawText.split("\n");
        String codeText = "";
        
        boolean // used for speeding up line interpretation
                noPackage = true,
                noClass = true;
        
        // iterate each line
        for(String line : lines){
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
        codeText = codeText.concat(";");
        
        
        try {// let's start

            // the bean shell instance with our settings
            Interpreter runScript = new Interpreter();
            addDefinitions(runScript, scriptFile);
            runScript.set("global.thisFile", scriptFile);
            runScript.set("global.thisFolder", scriptFile.getParentFile());

            // run the code        
            runScript.eval(codeText);
            // deliver back the object
            return runScript.get("plugin");

        } catch (EvalError e){
            script.log.write(is.ERROR, "EXEC118 Error interpreting %1"
                    , scriptFile.getName());
            e.printStackTrace();
        }
            
        // all done.
        return null;        
    }
    
  
}
