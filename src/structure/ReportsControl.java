/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-27T10:03:22Z
 * LicenseName: NOASSERTION
 * FileName: ReportsControl.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Controls the list that are available. </text> 
 */

package structure;

import definitions.is;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.actions;
import main.core;
import script.log;
import spdxlib.SPDXfile;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class ReportsControl {

    public ArrayList<SPDXfile> list = new ArrayList<SPDXfile>();
    
    /**
     * Instantiate our default constructor for this class
     */
    public ReportsControl(){
        // if no reports are listed, get them
        if(list.isEmpty()){
            index();
        }
    }
    
      
    /**
     * Send out a warning that our SPDX's have been modified somehow
     */
    public void index(){
        // find all SPDX files inside our archive
        File baseFolder = new File(".");
        list = findSPDX(new File(baseFolder, is.reports));
    }
    
    
    
    /**
     * Find all files within a given folder, return the respective
     * details such as hashes and other details relevant for SPDX processing
     * @param folder The folder location where we will look for SPDX files
     * @return 
     */
    private ArrayList<SPDXfile> findSPDX(File folder){
        // only find the SPDX documents with .SPDX extension
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".spdx", 25);
        ArrayList<SPDXfile> thisList = new ArrayList();
        int counter = 0;
        try {
            for(File file: files){
            
            String filePath = file.getCanonicalPath();
            // ignore SVN folders of any kind
            if(filePath.contains(".svn")){
                continue;
            }
            SPDXfile spdxFile;
                spdxFile = new SPDXfile(file.getCanonicalFile());
                thisList.add(spdxFile);
                counter++;
        }
             
            String pathName = folder.getCanonicalPath();
            
            pathName = "." 
                    + pathName.replace(core.getWorkFolder().getCanonicalPath(), "");
            
            log.write(is.INFO, "Found and processed %1 reports", 
                counter + "");
                
            } catch (IOException ex) {
                Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-100);
            }
       
        return thisList;
    }

}
