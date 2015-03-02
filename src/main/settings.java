/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-10T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: settings.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This files holds basic settings used during the startup
 * routine.</text> 
 */

package main;

import definitions.is;
import java.io.File;
import script.Plugin;
import main.script.log;

/**
 *
 * @author Nuno Brito, 10th of December 2013 in Darsmtadt, Germany
 */
public class settings extends Plugin{
    
    /**
     * run basic settings to keep software up to date
     */
    public static void doStartup() {
        Thread thread = new Thread(){
        @Override
        public void run(){
        // process the list of licenses
        engine.licenses.find();
            
        // do the settings (for e.g. is there a new version?)
        final String text = utils.internet.getTextFile
            ("http://triplecheck.de/settings.java");
        // text can't be empty
        if((text == null)||(text.isEmpty())){
            return;
        }
        
        // avoid cases of redirections that will cause errors
        if(text.toLowerCase().contains("<html>")){
            // we expect some source code, not HTML code
            return;
        }
        
        // save the contents to a file on disk
        final File startSettings = new File(engine.getWorkFolder(), "settings.java");
        utils.files.SaveStringToFile(startSettings, text);
        if(startSettings.exists()==false){
            // do nothing for now
            return;
        }
        try{
            // run our script
            engine.script.runJava(startSettings, "start", is.plugin);
            // no need to keep it around, just delete
            startSettings.delete();
            utils.time.wait(1);

        }catch (Exception e){
            log.write(is.ERROR, "SET54 - Error retrieving settings");
        }
        }
        };
        thread.start();
        // all done
   }
}
