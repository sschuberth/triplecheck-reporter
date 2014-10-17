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
import spdxlib.SPDXfile2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.engine;
import script.log;


/**
 *
 * @author Nuno Brito, 27th of April 2014 in the highway to North sea, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class ReportsControl {

    private final ArrayList<SPDXfile2> list = new ArrayList<SPDXfile2>();
    
    //private final MapDB_SPDX list = new utils.db.MapDB_SPDX(false);
    
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
        findSPDX();
    }
    
    
    /**
     * Find all files within a given folder, return the respective
     * details such as hashes and other details relevant for SPDX processing
     * @param folder The folder location where we will look for SPDX files
     * @return 
     */
    private void findSPDX(){
        File folder = new File(engine.getWorkFolder(), is.reports);
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
            // read the file
            readSPDXfile(file);
        }
        log.write(is.INFO, "Found and processed %1 reports", 
        counter + "");
    }

    /**
     * Refresh the contents about a given SPDX document that was modified
     * on disk
     * @param path      the spdx file on disk
     * @return          have we succeeded in refreshing an SPDX or not?
     */
    public boolean refresh(String path) {
        int index = 0;
        for(SPDXfile2 spdx : list){
            if(spdx.file.getAbsolutePath().equals(path)){
                spdx.refresh();
                // update the spdx on the database
                list.set(index, spdx);
                return true;
            }
            // next spdx on our list
            index++;
        }
        // no refeshing occured
        return false;
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
        SPDXfile2 spdx = get(file);
        // if it exists, remove from our list
        if(spdx != null){
            list.remove(spdx);
            file.delete();
        }
        // retun success when the file no longer exists
        return file.exists() == false;
    }

    
       
    

    /**
     * Given an SPDX file, we will process and add it up to our list
     * @param file  the SPDX report on disk
     * @param spdxFile  An SPDX object to be added on our list
     */
    public void add(File file, SPDXfile2 spdxFile) {
        SPDXfile2 temp = get(file);
        // this file didn't existed before, add it up
        if(temp == null){
            list.add(spdxFile);
            return;
        }
        // this spdx already exists, update
        int index = 0;
        // go through all listed spdx reports
        for(SPDXfile2 spdx : list){
            // do we have a match for the directory?
            if(spdx.file.getAbsolutePath().equals(file.getAbsolutePath())){
                // yes we do, update with a new value
                list.set(index, spdxFile);
                return;
            }
            // increase the counter, move to next spdx in list
            index++;
        }
        
    }

    /**
     * Gets the list of SPDX documents that we have indexed
     * @return 
     */
    public ArrayList<SPDXfile2> getList() {
        return list;
    }

    /**
     * Reads the SPDX file into memory
     * @param file  A file on disk
     */
    private void readSPDXfile(File file) {
        try {
            // read the SPDX file
            SPDXfile2 spdxFile = new SPDXfile2(file.getCanonicalFile());
            // place the file on our list
            add(file, spdxFile);
        } catch (IOException ex) {
            System.err.println("RC180 - Failed to read: " + file.getAbsolutePath());
            Logger.getLogger(ReportsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Do we have a specific file already indexed?
     * @param file
     * @return 
     */
    private boolean has(File file) {
        // go through all the files
        for(SPDXfile2 spdx : list){
            // if we have a match
            if(file.getAbsolutePath().equals(spdx.file.getAbsolutePath())){
                return true;
            }
        }
        // all done
        return false;
    }
    
    /**
     * When provided a given File, it will return the associated report
     * @param file      An SPDX file on disk
     * @return          An SPDX object when or null when not found
     */
    public SPDXfile2 get(File file){
        // go through all the files
        for(SPDXfile2 spdx : list){
            // if we have a match
            if(file.getAbsolutePath().equals(spdx.file.getAbsolutePath())){
                return spdx;
            }
        }
        // all done
        return null;
    }
    
}
