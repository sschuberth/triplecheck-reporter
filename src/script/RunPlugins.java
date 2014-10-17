/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-19T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: RunPlugins.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Methods to handle RunPlugins files and to integrate them
 *  with the user interface. </text> 
 */

package script;

import GUI.ListItem;
import definitions.Messages;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import main.engine;
import main.coreGUI;


/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public class RunPlugins {

    public static ArrayList<ListItem> menu = new ArrayList();
    
    /**
     * Find all RunPlugins within our plugin folder
     * @param what A piece of text that has to be present in the file name
     * @return a list of plugin files
     */
    public static ArrayList<File> findPluginFiles(String what){
        File folder = engine.getPluginsFolder();
        // pre-flight check
        if(folder.exists() == false){
            // folder doesn't exist, let's create a folder just in case
            utils.files.mkdirs(folder);
            return null;
        }
        // find all RunPlugins available
        ArrayList<File> foundFiles = utils.files.findFiles(folder);
        // filter the ones that we don't want
        ArrayList<File> files = new ArrayList();
        for(File file : foundFiles){
            String filename = file.getAbsolutePath();
            // svn folder are a known problem
            if(filename.contains(".svn")){
                continue;
            }
            // we only want beanshell files
            if(filename.endsWith(what) == false){
                continue;
            }
            // all is good now, add up this file
            files.add(file);
        }
        
        //core.temp.put("pluginFiles", files);
        return files;
    }
    
  
    
  /**
     * Adds the RunPlugins 
     */
    public static void listPlugins(){
        // remove all previously installed plugins
        log.hooks.removeAll();
        // get our available plugin files
        ArrayList<File> pluginFiles = findPluginFiles(".bsh");
        for(File file : pluginFiles){
           processPlugin(file);
        }

        // process the java-like RunPlugins
        ArrayList<File> pluginJava = findPluginFiles(".java");
        for(File file : pluginJava){
            engine.script.runJava(file, is.methodStartUp, is.plugin);
            log.write(is.INFO, Messages.AddedPlugin, file.getName());
        }
    }
    
    

    
    /**
     * Process each script with instructions
     */
    static void processPlugin(File file){
         engine.script.run(file, "startup", "Plugin");
         log.write(is.INFO, Messages.AddedPlugin, file.getName());
    }    
   
   
}
