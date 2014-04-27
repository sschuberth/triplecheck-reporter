/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: core.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A static class used as Singleton to keep a single
 *  instance of specific services such as log messages working synchronized
 *  </text> 
 */

package main;

import FileExtension.ExtensionControl;
import GUI.StudioUI4;
import definitions.Messages;
import definitions.folder;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import script.RunningTask;
import script.Trigger;
import script.log;
import spdxlib.LicenseControl;
import structure.LicensePopularity;
import structure.ReportsControl;
import utils.Settings;


public class core {

    public static String version = "0.6";
    
    public static 
            Script script = new Script();
    
    public static
            Settings settings = new Settings(new File("settings.xml"), "");
    
    
    // where we keep our shared objects
    public static HashMap
            temp = new HashMap<String, Object>();
    
    //public static StudioUI2 studio2 = null;
    public static StudioUI4 studio = null;
    
    public static utils.KeyStroke key = 
            new utils.KeyStroke(Messages.SearchBoxPressedKey);
    
    public static File thisFile;
    
    static public boolean 
            searchBoxActive = false,
            textWasModified; // relates to the main text box
    
    // a placeholder to launch searches and share the keywords securely
    public static String searchTerm = "";
    
    public static ArrayList<Trigger> 
            triggers = new ArrayList();
    
    public static ExtensionControl
            extensions = new ExtensionControl();
   
    public static ReportsControl
            reports = new ReportsControl();
   
    public static LicenseControl
            licenses = new LicenseControl();
    
    public static LicensePopularity
            popularity = new LicensePopularity();
   
    public static ArrayList<RunningTask> 
            runningTasks = new ArrayList();
     
    
    /**
     * Gets the folder where we are running
     * @return The folder from where the main application is running
     */
    public static File getWorkFolder(){
            return new File(".").getAbsoluteFile().getParentFile();
    }
    
    /**
     * Gets an Icon file from the icon archive
     * @param filename The icon name inside our archive
     * @return A file pointer to the icon
     */
    public static File getIcon(String filename){
        File iconFolder = new File(getWorkFolder(), is.iconFolder);
            return new File(iconFolder, filename);
    }
    
    
    /**
     * where the plugins are located
     * @return 
     */
    public static File getPluginsFolder(){
        return new File(getWorkFolder(), "plugins");
    }
    
    public static File getLibraryFolder(){
        return new File(getWorkFolder(), "library");
    }
    
    public static File getProductsFolder(){
        return new File(getWorkFolder(), folder.reports);
    }
    
    public static File getReportsFolder(){
        return new File(getWorkFolder(), folder.triggers);
    }
    
    public static File getLicensesFolder(){
        return new File(getWorkFolder(), folder.licenses);
    }
    
    public static File getExtensionsFolder(){
        return new File(getWorkFolder(), folder.extensions);
    }
    
    public static File getExtensionsUnknown(){
        return new File(getExtensionsFolder(), "unknown");
    }
    
    
    /**
     * Send out a warning that our SPDX's have been modified somehow
     */
    public static void refreshSPDX(){
        // find all SPDX files inside our archive
        reports.index();
        // send a message to the world, warning that things changed
        log.write(is.INFO, Messages.RefreshSPDX);
    }
    
}
