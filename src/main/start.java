/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.StudioUI4;
import definitions.is;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        
        // kickstart our screen
        core.startupScreen.setVisible(true);

                // enable translations
                core.startupScreen.setProgress("Starting up", 10);
                
                log.EnableTranslator("EN", "English (US)");
                log.write(is.CREDITS, "TripleCheck (c) %1, "
                        + "http://triplecheck.de", utils.time.getCurrentYear());
                log.write(is.RUNNING, "Version %1 %2", core.version,
                        getDate());
                // add our triggers
                core.startupScreen.setProgress("Adding licenses", 20);
                actions.addLicenses();
                // now add the known file extensions
                core.startupScreen.setProgress("Adding extensions", 40);
                core.extensions.addExtensions();
                // do the startup
                Thread thread = new Thread(){
                @Override
                public void run(){
                     doStartup();
                     
                    }};
                thread.start();
            
                
                try{
                    core.studio = new StudioUI4();
                    core.studio.doSettings();
                    
                    // remove the startup screen
                    core.startupScreen.dispose();
                    
                    core.studio.setVisible(true);
                    core.studio.hasFocus();
                }catch (Exception e){
                    System.err.println("ST60 - Exception occurred");
//                    log.write(is.ERROR,
//                            e.getMessage());
                    System.exit(-1981);
                }
    }
    
    
    private static void doStartup() {
        // find all SPDX documents that we have available
        core.startupScreen.setProgress("Loading reports",60);
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
            return;
        }
        // run our script
        core.startupScreen.setProgress("Adding plugins",80);
        core.script.runJava(startSettings, "start", is.plugin);
   }

     
    
   public static String getDate(){
       String result = "";
        try {
            Date date = getCompileTimeStamp(start.class);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            result = "from " + df.format(date);
        } catch (IOException ex) {
        }
       
       return result;
   } 
    
/**
 * get date a class was compiled by looking at the corresponding class file in the jar.
 * @author Zig
 * @origin http://mindprod.com/jgloss/compiletimestamp.html
 * @retrieved in 2013-11-17 by Nuno Brito
     * @param cls   Class that we want to evaluate the time stamp
     * @return      The time/date result
     * @throws java.io.IOException
 */
public static Date getCompileTimeStamp( Class<?> cls ) throws IOException
{
   ClassLoader loader = cls.getClassLoader();
   String filename = cls.getName().replace('.', '/') + ".class";
   // get the corresponding class file as a Resource.
   URL resource=( loader!=null ) ?
                loader.getResource( filename ) :
                ClassLoader.getSystemResource( filename );
   URLConnection connection = resource.openConnection();
   // Note, we are using Connection.getLastModified not File.lastModifed.
   // This will then work both or members of jars or standalone class files.
   long time = connection.getLastModified();
   return( time != 0L ) ? new Date( time ) : null;
}
}
