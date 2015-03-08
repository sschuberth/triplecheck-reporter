/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-01T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: engine.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A static class used as Singleton to keep a single
 *  instance of specific services such as log messages working synchronized
 *  </text> 
 */

package main;

import GUI.KeyStroke;
import GUI.LicensePopularity;
import GUI.StudioUI4;
import comp.ComponentControl;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import script.RunningTask;
import definitions.structure.ReportsControl;


public class coreGUI {

    public static String version = engine.version;
    
    // default color used as background on the tool
    public static final Color backgroundColor = new Color(0xf8f8f8);
    
    public static StudioUI4 studio = null;
    
    public static KeyStroke key = new KeyStroke();
   
    public static final String toggleScore = "toggleScore";
            
    
    static public boolean 
            searchBoxActive = false,
            textWasModified; // relates to the main text box
    
    // a placeholder to launch searches and share the keywords securely
    public static String searchTerm = "";
 
    public static ReportsControl
            reports; // = new ReportsControl();
   
    public static LicensePopularity
            popularity = new LicensePopularity();
   
    public static ComponentControl components = new ComponentControl();
    
    public static ArrayList<RunningTask> 
            runningTasks = new ArrayList();
    
    
    
     /**
     * Where are all the github related files placed?
     * @return 
     */
    public File getGithubFolder(){
        File result = new File(engine.getMiscFolder(),"github");
        // if the folder doesn't exist, create one
        if(result.exists() == false){
            utils.files.mkdirs(result);
        }
        return result;
    }
    
}
