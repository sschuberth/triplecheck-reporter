/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-10T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: start.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The file that launches the software into action.</text> 
 */
package main;

import FileExtension.ExtensionControl;
import GUI.StartupScreen;
import GUI.StudioUI4;
import definitions.is;
import script.log;
import structure.LicenseControl;
import structure.ReportsControl;
import structure.TriggerControl;

/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public class start {

    /**
     * The method that we need to call in order to initialize the license
     * and file extension detection. Basically, finding all the dynamic
     * scripts and loading them up to memory.
     */
    public static void basicStart(){
        core.extensions = new ExtensionControl();
        core.triggers = new TriggerControl();
        core.reports = new ReportsControl();
        core.licenses = new LicenseControl();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        // do the basic start
        basicStart();
        
        // watch out for the case when we launch the command line version
        if(cmdLine.isCommandLineUsed(args)){
            return;
        }
        
       // show the startup screen
        StartupScreen startupScreen = new StartupScreen();
    
        startupScreen.kickoff();
        log.write(is.CREDITS, "TripleCheck (c) %1, "
                + "http://triplecheck.de", utils.time.getCurrentYear());
        log.write(is.RUNNING, "Version %1 %2", core.version,
                utils.misc.getDate(start.class));
        
        // do the startup
        settings.doStartup();
        
        try{
            core.studio = new StudioUI4();
            core.studio.doSettings();

            // remove the startup screen
            startupScreen.dispose();

            core.studio.setVisible(true);
            core.studio.hasFocus();
        }catch (Exception e){
            log.write(is.ERROR, "ST60 - Exception occurred: %1", e.getLocalizedMessage());
            System.exit(-1981);
        }
    }

    
    
    

}
