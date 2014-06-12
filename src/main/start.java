/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.StudioUI4;
import definitions.is;
import script.log;

/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public class start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // show the startup screen
        core.startupScreen.kickoff();
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
            core.startupScreen.dispose();

            core.studio.setVisible(true);
            core.studio.hasFocus();
        }catch (Exception e){
            log.write(is.ERROR, "ST60 - Exception occurred: %1", e.getLocalizedMessage());
            System.exit(-1981);
        }
    }
    
    
    

}
