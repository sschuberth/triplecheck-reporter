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
import main.core;
import script.log;
import spdxlib.SPDXfile;
import utils.db.MapDB_SPDX;


/**
 *
 * @author Nuno Brito, 27th of April 2014 in the highway to North sea, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class ReportsControl {

    //private ArrayList<SPDXfile> list1 = new ArrayList<SPDXfile>();
    
    private final MapDB_SPDX list = new utils.db.MapDB_SPDX(false);
    
    /**
     * Instantiate our default constructor for this class
     */
    public ReportsControl(){
        // if no reports are listed, get them
        //TODO we need to check for changes that happened on disk
        if(list.map().isEmpty()){
            index();
        }
    }
    
      
    /**
     * Send out a warning that our SPDX's have been modified somehow
     */
    public void index(){
        findSPDX();
    }
    
    
    
    /**
     * Find all files within a given folder, return the respective
     * details such as hashes and other details relevant for SPDX processing
     * @param folder The folder location where we will look for SPDX files
     * @return 
     */
    private void findSPDX(){
        File baseFolder = new File(".");
        File folder = new File(baseFolder, is.reports);
        // only find the SPDX documents with .SPDX extension
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".spdx", 25);
        int counter = 0;
        // go through all the files that were found
        for(File file: files){
            String filePath = file.getAbsolutePath();
            // ignore SVN folders of any kind
            if(filePath.contains(".svn")){
                continue;
            }
            // increase the counter
            counter++;

            // have we indexed this file in the past?
            if(list.map().containsKey(file)){
                // we have a match, but was the file on disk modified?
                // get the file that is cached
                SPDXfile spdx = list.map().get(file);
                // are the file sizes equal?
                if(spdx.file.length() == file.length()){
                    // no need to index, it is the same file. Use the cache.
                    System.err.println("RC82 - Using cached version of: " 
                        + file.getAbsolutePath());
                    continue;
                }
            }
            // file is not indexed (or had changes on disk), load it up
            System.err.println("DBG-RC64 Adding SPDX: " + file.getName());
            log.write(is.OPENING, "Adding SPDX: %1", file.getName());
            // read the file
            readSPDXfile(file);
        }
        list.commit();
        log.write(is.INFO, "Found and processed %1 reports", 
        counter + "");
        //return thisList;
    }

    /**
     * Refresh the contents about a given SPDX document that was modified
     * on disk
     * @param path      the spdx file on disk
     * @return          have we succeeded in refreshing an SPDX or not?
     */
    public boolean refresh(String path) {
        for(SPDXfile spdx : list.map().values()){
            if(spdx.file.getAbsolutePath().equals(path)){
                spdx.refresh();
                // update the spdx on the database
                list.map().put(spdx.file, spdx);
                return true;
            }
        }
        // no refeshing occured
        return false;
    }

    /**
     * When provided a given File, it will return the associated report
     * @param file      An SPDX file on disk
     * @return          An SPDX object when or null when not found
     */
    public SPDXfile get(File file){
        //String path = what.getAbsolutePath();
        SPDXfile result = list.map().get(file);
        
        // if there is no SPDX but the file exists, read it up
        if(result == null && file.exists()){
            // read the file
            readSPDXfile(file);
            // commit the changes
            list.commit();
            // return the object
            result = list.map().get(file);
        }
        // all done
        return result;
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
        //SPDXfile spdx = get(file);
         // do the deletion
        file.delete();
        // remove from our list
        //if(spdx != null){
        list.map().remove(file);
        //}
        
        // retun success when the file no longer exists
        return file.exists() == false;
    }

    
       
    

    /**
     * Given an SPDX file, we will process and add it up to our list
     * @param file  the SPDX report on disk
     * @param spdxFile
     */
    public void add(File file, SPDXfile spdxFile) {
//        SPDXfile spdxFile = null;
         list.map().put(file, spdxFile);
         list.commit();
         
//        try {
//            spdxFile = new SPDXfile(file.getCanonicalFile());
//            list.map().put(file, spdxFile);
//            list.commit();
//        } catch (IOException ex) {
//            Logger.getLogger(ReportsControl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // all done
//        return spdxFile;
    }

    /**
     * Gets the list of SPDX documents that we have indexed
     * @return 
     */
    public ArrayList<SPDXfile> getList() {
        // not an efficient method, just here for retro-compatibility
        ArrayList<SPDXfile> result = new ArrayList();
        for(SPDXfile spdx : list.map().values()){
            result.add(spdx);
        }
        return result;
    }

    /**
     * Reads the SPDX file into memory
     * @param file  A file on disk
     */
    private void readSPDXfile(File file) {
        try {
            // read the SPDX file
            SPDXfile spdxFile = new SPDXfile(file.getCanonicalFile());
            // place the file on our db
            list.map().put(file, spdxFile);
            // don't do commit, let the calling function do this
        } catch (IOException ex) {
            Logger.getLogger(ReportsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    /**
     * First test trying to digest somewhat larger files
     */
    public void test(){
        // get the pointer to a 20Mb spdx document
        File file = new File (core.getMiscFolder(), "linux-coreos.spdx");
        readSPDXfile(file);
        System.err.println("All done!");
        //System.err.println(file.getAbsolutePath());
    }
    
}
