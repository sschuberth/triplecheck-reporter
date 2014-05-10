/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-27T10:03:22Z
 * LicenseName: EUPL-1.1-without-appendix
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
import script.log;
import spdxlib.SPDXfile;


/**
 *
 * @author Nuno Brito, 27th of April 2014 in the highway to North sea, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class ReportsControl {

    private ArrayList<SPDXfile> list = new ArrayList<SPDXfile>();
    
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
             
//            String pathName = folder.getCanonicalPath();
//            
//            pathName = "." 
//                    + pathName.replace(core.getWorkFolder().getCanonicalPath(), "");
            
            log.write(is.INFO, "Found and processed %1 reports", 
                counter + "");
                
            } catch (IOException ex) {
                Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-100);
            }
       
        return thisList;
    }

    /**
     * Refresh the contents about a given SPDX document that was modified
     * on disk
     * @param path      the spdx file on disk
     * @return          have we succeeded in refreshing an SPDX or not?
     */
    public boolean refresh(String path) {
        for(SPDXfile spdx : list){
            if(spdx.file.getAbsolutePath().equals(path)){
                spdx.refresh();
                return true;
            }
        }
        // no refeshing occured
        return false;
    }

    /**
     * When provided a given File, it will return the associated report
     * @param what      An SPDX file on disk
     * @return      An SPDX object when or null when not found
     */
    public SPDXfile get(File what){
        String path = what.getAbsolutePath();
        for(SPDXfile spdx : list){
                if(spdx.file.getAbsolutePath().equals(path)){
                    spdx.refresh();
                    return spdx;
                }
        }    
        return null;
    }
    
    /**
     * Deletes a given report from our list and disk
     * @param file      the SPDX report to delete
     * @return          true when the file was deleted and removed from our list
     */
    public boolean delete(File file) {
        if(file.exists() == false){
            log.write(is.ERROR, "RC137 - SPDX file doesn't exit: %1", 
                    file.getAbsolutePath());
            return false;
        }
        // get the SPDX object
        SPDXfile spdx = get(file);
         // do the deletion
        file.delete();
        // remove from our list
        if(spdx != null){
            list.remove(spdx);
        }
        
        // retun success when the file no longer exists
        return file.exists() == false;
    }

    
       
    

    /**
     * Given an SPDX file, we will process and add it up to our list
     * @param file  the SPDX report on disk
     * @return      null if something fails or else provides the new SPDX object
     */
    public SPDXfile add(File file) {
        SPDXfile spdxFile = null;
        try {
            spdxFile = new SPDXfile(file.getCanonicalFile());
            list.add(spdxFile);
        } catch (IOException ex) {
            Logger.getLogger(ReportsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        // all done
        return spdxFile;
    }

    /**
     * Gets the list of SPDX documents that we have indexed
     * @return 
     */
    public ArrayList<SPDXfile> getList() {
        return list;
    }

    
}
