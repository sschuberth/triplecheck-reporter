/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-10T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: start.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The file that launches the software into action.</text> 
 */
package main;

import GUI.StartupScreen;
import GUI.StudioUI4;
import definitions.is;
import main.script.log;

/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public class start {

     public static StartupScreen startupScreen = null;
        
    /**
     * The method that we need to call in order to initialize the license
     * and file extension detection. Basically, finding all the dynamic
     * scripts and loading them up to memory.
     * @param args Original args from command line
     */
    public static void basicStart(String[] args){
        // express that third-party projects need to initialize as libraries
        System.setProperty(is.methodStartUp, is.library);
        
        // shall we create a start screen?
        if(args.length == 0){
             // show the startup screen
            startupScreen = new StartupScreen();
            log.write(is.CREDITS, "TripleCheck (c) %1, "
                    + "http://triplecheck.net", utils.time.getCurrentYear());
            startupScreen.kickoff();
        }
        
        // get the engine running
        engine.warmUp();
        
    }
    
    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        CmdLine cmd = new CmdLine();
        
        // do the basic start
        basicStart(args);
        // watch out for the case when we launch the command line version
        if(cmd.isCommandLineUsed(args)){
            return;
        }
        
        try{
            coreGUI.studio = new StudioUI4();
            coreGUI.studio.doSettings();

            // remove the startup screen
            if(startupScreen != null){
                startupScreen.dispose();
            }
            
            coreGUI.studio.setVisible(true);
            coreGUI.studio.hasFocus();
        }catch (Exception e){
            log.write(is.ERROR, "ST60 - Exception occurred: %1", e.getLocalizedMessage());
            e.printStackTrace();
            System.exit(-1981);
        }
    }

}
