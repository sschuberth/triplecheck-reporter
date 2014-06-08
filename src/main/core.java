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
import GUI.StartupScreen;
import GUI.StudioUI4;
import comp.ComponentControl;
import definitions.folder;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import script.RunningTask;
import structure.LicenseControl;
import structure.LicensePopularity;
import structure.ReportsControl;
import structure.TriggerControl;
import utils.Settings;


public class core {

    public static String version = "0.9";
    
    public static 
            Script script = new Script();
    
    public static
            Settings settings = new Settings(new File("settings.xml"), "");
    
    
    // where we keep our shared objects
    public static HashMap
            temp = new HashMap<String, Object>();
    
    //public static StudioUI2 studio2 = null;
    public static StudioUI4 studio = null;
    
    public static StartupScreen startupScreen = new StartupScreen();
    
    public static utils.KeyStroke key = new utils.KeyStroke();
    
    public static File thisFile;
    
    static public boolean 
            searchBoxActive = false,
            textWasModified; // relates to the main text box
    
    // a placeholder to launch searches and share the keywords securely
    public static String searchTerm = "";


    public static ExtensionControl
            extensions = new ExtensionControl();

    public static TriggerControl
            triggers = new TriggerControl();
   
    public static ReportsControl
            reports = new ReportsControl();
   
    // find the licenses available on disk
    public static LicenseControl
            licenses = new LicenseControl();
    
    public static LicensePopularity
            popularity = new LicensePopularity();
   
    public static ComponentControl components = new ComponentControl();
    
    public static ArrayList<RunningTask> 
            runningTasks = new ArrayList();
    
    // define the icon used on the tree view
    public static final Icon
            // this might seem an overwhelming wall of text but it important
            // to cache up these icons to avoid re-reading them in the future
        iconTEXT = new ImageIcon(getIcon("document-list.png").getAbsolutePath()),
        iconSOURCE = new ImageIcon(getIcon("document-code.png").getAbsolutePath()),
        iconDOCUMENT = new ImageIcon(getIcon("document-word.png").getAbsolutePath()),
        iconINTERNET = new ImageIcon(getIcon("document-globe.png").getAbsolutePath()),
        iconSCRIPT = new ImageIcon(getIcon("script-code.png").getAbsolutePath()),
        iconSCHEMA = new ImageIcon(getIcon("document-xaml.png").getAbsolutePath()),
        iconCONFIG = new ImageIcon(getIcon("document--pencil.png").getAbsolutePath()),
        iconVERSIONING = new ImageIcon(getIcon("document-clock.png").getAbsolutePath()),
        iconEXECUTABLE = new ImageIcon(getIcon("compile.png").getAbsolutePath()),
        iconFONT = new ImageIcon(getIcon("document.png").getAbsolutePath()),
        iconARCHIVE = new ImageIcon(getIcon("box.png").getAbsolutePath()),
        iconBINARY = new ImageIcon(getIcon("document-binary.png").getAbsolutePath()),
        iconDATABASE = new ImageIcon(getIcon("database.png").getAbsolutePath()),
        iconIMAGE = new ImageIcon(getIcon("document-image.png").getAbsolutePath()),
        iconVIDEO = new ImageIcon(getIcon("document-film.png").getAbsolutePath()),
        iconSOUND = new ImageIcon(getIcon("document-music.png").getAbsolutePath()),
        iconMUSIC = new ImageIcon(getIcon("document-music.png").getAbsolutePath()),
        iconOTHER = new ImageIcon(getIcon("document-xaml.png").getAbsolutePath()),
        iconTEMP = new ImageIcon(getIcon("document-clock.png").getAbsolutePath()),
        iconUNKNOWN = new ImageIcon(getIcon("document.png").getAbsolutePath()),
        iconCOMPONENTS = new ImageIcon(getIcon("blue-document-node.png").getAbsolutePath()),
        iconEXPORT = new ImageIcon(getIcon("application-dock-270.png").getAbsolutePath()),
        iconFolderClosed = new ImageIcon(getIcon("folder-horizontal.png").getAbsolutePath()),
        iconFolderOpen = new ImageIcon(getIcon("folder-horizontal-open.png").getAbsolutePath()),
        iconFiles = new ImageIcon(getIcon("documents-stack.png").getAbsolutePath()),

        iconFingerprint = new ImageIcon(getIcon("fingerprint.png").getAbsolutePath());

    /**
     * Gets the folder where we are running
     * @return The folder from where the main application is running
     */
    public static File getWorkFolder(){
            return new File(".").getAbsoluteFile().getParentFile();
    }
    
    /**
     * Gets the folder where misc settings are placed
     * @return The folder from where the main application is running
     */
    public static File getMiscFolder(){
        File result = new File(getWorkFolder(), "misc");
        // if the folder doesn't exist, create one
        if(result.exists() == false){
            utils.files.mkdirs(result);
        }
        return result;
    }
    
       /**
     * Gets the folder where misc settings are placed
     * @return The folder from where the main application is running
     */
    public static File getFolderExport(){
        File result = new File(getWorkFolder(), "export");
        // if the folder doesn't exist, create one
        if(result.exists() == false){
            utils.files.mkdirs(result);
        }
        return result;
    }

    
     /**
     * Where are all the github related files placed?
     * @return 
     */
    public File getGithubFolder(){
        File result = new File(core.getMiscFolder(),"github");
        // if the folder doesn't exist, create one
        if(result.exists() == false){
            utils.files.mkdirs(result);
        }
        return result;
    }
    /**
     * Gets an Icon file from the icon archive
     * @param filename The icon name inside our archive
     * @return A file pointer to the icon
     */
    public static File getIcon(final String filename){
        File iconFolder = new File(getMiscFolder(), is.iconFolder);
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
    
    public static File getComponentFolder(){
        return new File(getWorkFolder(), "components");
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
    
    
//    /**
//     * Send out a warning that our SPDX's have been modified somehow
//     */
//    public static void refreshSPDX(){
//        // find all SPDX files inside our archive
//        reports.index();
//        // send a message to the world, warning that things changed
//        log.write(is.INFO, Messages.RefreshSPDX);
//    }
    
   
    
    
}
