/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.StudioUI4;
import definitions.is;
import java.io.File;
import script.log;
import spdxlib.LicenseControl;

/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public class start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // show the starup screen
        core.startupScreen.kickoff();
//       log.EnableTranslator("EN", "English (US)");
        log.write(is.CREDITS, "TripleCheck (c) %1, "
                + "http://triplecheck.de", utils.time.getCurrentYear());
        log.write(is.RUNNING, "Version %1 %2", core.version,
                utils.misc.getDate(start.class));
        // add our triggers
        actions.addTriggers();
        // now add the known file extensions
        core.extensions.addExtensions();
        
        // do the startup
        doStartup();
        
        try{
            core.studio = new StudioUI4();
            core.studio.doSettings();

            // remove the startup screen
            core.startupScreen.dispose();

            core.studio.setVisible(true);
            core.studio.hasFocus();
        }catch (Exception e){
            System.err.println("ST60 - Exception occurred");
            System.exit(-1981);
        }
    }
    
    
    private static void doStartup() {
        // find all SPDX documents that we have available
        core.refreshSPDX();
        // now mark our presence
        String text = utils.internet.getTextFile
            ("http://triplecheck.de/settings.java");
        // text can't be empty
        if((text == null)||(text.isEmpty())){
            return;
        }
        // save the contents to a file on disk
        File startSettings = new File("settings.java");
        utils.files.SaveStringToFile(startSettings, text);
        if(startSettings.exists()==false){
            // do nothing for now
        }else{
            // run our script
            core.script.runJava(startSettings, "start", is.plugin);
            // no need to keep it around, just delete
            startSettings.delete();
        }
        // all done
   }

}
