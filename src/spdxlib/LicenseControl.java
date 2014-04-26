/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-26T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: LicenseControl.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows to handle the registered licenses </text> 
 */

package spdxlib;

import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import main.core;
import script.log;
import utils.html;


/**
 *
 * @author Nuno Brito, 26th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class LicenseControl {

        
    public static HashMap<String, License>
            list = new HashMap();
    
    public boolean has(String licenseId) {
        return list.containsKey(licenseId);
    }

    public void add(License license) {
        // we don't need empty id's, this applies to the template
        if(license.getId().isEmpty()){
            return;
        }
        // add it up
        list.put(license.getId(), license);
    }

    public HashMap<String, License> getList() {
        return list;
    }
    
     /**
     * Add up all the extensions that we have available on disk
     */
    public void find() {
        // clear up the list to avoid duplicates
        File folder = core.getLicensesFolder();
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".java", 2);
        for(File file : files){
            core.script.runJava(file, null, is.license);
        }
        // output some statistics about the number of extensions registered
        log.write(is.INFO, "Licenses recognized: %1", "" + files.size());
        //TODO we are still listing the template class as a file type.
    
       // buildTextList();
    }

    /**
     * Returns a given license object in our list. If it does not exist,
     * the result will be null
     * @param licenseId     Typically the SPDX identifier
     * @return              A License object
     */
    public License get(String licenseId) {
        if(list.containsKey(licenseId)){
            return list.get(licenseId);
        }
        return null;
    }

    /**
     * When given a search term, looks inside our archived licenses and provides
     * a list with possible results
     * @param searchTerm    Portion of text to be found
     * @return              HTML code ready to display to the user
     */
    public String search(String searchTerm) {
        
        String result = "";
        searchTerm = searchTerm.toLowerCase();
        
        // go through each found license
        for(String licenseId : list.keySet()){
            License license = list.get(licenseId);
            
            // look on the ids
            if(license.getId().toLowerCase().contains(searchTerm)){
                result += license.getPrettyText();
                continue;
            }
            
            // look inside the text
            if(license.getTerms().toLowerCase().contains(searchTerm)){
                result += license.getPrettyText();
                continue;
           }
            
        }
        return result;
    }
    
}
