/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-27T09:54:38Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LicensePopularity.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class helps to discover which licenses matter
 * to the end-user. We measure the most used licenses across the available
 * reports and track the licenses most recently used. The end goal is present
 * to the user the most relevant license as a top-list.</text> 
 */

package structure;

import definitions.is;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import main.core;
import script.log;
import spdxlib.FileInfo;
import spdxlib.FileOrigin;
import spdxlib.License;
import spdxlib.SPDXfile;
import utils.html;
import static utils.misc.sortByComparator;


/**
 *
 * @author Nuno Brito, 27th of April 2014 in the highway to North sea, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class LicensePopularity {
    
    boolean hasNotIndexed = true;
    // the place where we keep our ranking score for each license
    private final HashMap<String, Integer> list = new HashMap();
    private final HashMap<FileOrigin, Integer> listOrigin = new HashMap();
    // where we map licenses to their value
    private Map<String,Integer> popularityList;
    // how many files were counted?
    private int numberOfFiles = 0;
    
    /**
     * The default constructor
     */
    public LicensePopularity(){
        if(hasNotIndexed){
            doIndex();
        }
    }

    /**
     * Based on the licenses currently indexed, discover the licenses used on
     * each report
     */
    public void doIndex() {
        // clean up the variables to account for repeated calls
        list.clear();
        listOrigin.clear();
        numberOfFiles = 0;
        popularityList = null;
        
        // get the list of reports
        ArrayList<SPDXfile> reports = core.reports.list;
        log.write(is.CREATING, "Generating the popularity indexes");
        
        // go through each report to index the licenses
        for(SPDXfile report : reports){
            processReport(report);
        }
        
        // ok, we processed all the reports. Give some feedback on what we got.
        log.write(is.INFO, "Computed popularity index of %1 different licenses", list.size() + "");

        // index all the licenses according to popularity
        popularityList = sortByComparator(list);
        
        //print();
    // all done
    }

    /**
     * Process the licenses inside a given SPDX report
     * @param spdx 
     */
    private void processReport(SPDXfile report){
        // iterate through each file on this report
        for(FileInfo fileInfo : report.fileSection.files){
            // get the licenses within
            processFileInfo(fileInfo);
        }
    }
    
    /**
     * Get inside the file info to get the licenses and place them inside
     * our own counter. This method has now been expanded to include the
     * counting of original files.
     * @param fileInfo 
     */
    private void processFileInfo(FileInfo fileInfo){
        // start by increasing the number of detected files
        numberOfFiles++;
        // get the list of licenses
        ArrayList<String> licList = fileInfo.getLicenses();
        // iterate through each license that was found
        for(String license : licList){
            int counter;
            // have we found this license before? If so, get the counter
            if(list.containsKey(license)){
                counter = list.get(license);
                // add up another notch
                counter++;
            }else{
                // not found before, add it for the first time
                counter = 1;
            }
            // all done, place it back in place
            list.put(license, counter);
        }
        
         // process the authorship details
        FileOrigin origin = fileInfo.getFileOrigin();
        
        // null value? Default to unknown
        if(origin == null){
            origin = FileOrigin.UNKNOWN;
        }
        
        int countOrigin;
        // was the author details of this file added before?
        if(listOrigin.containsKey(origin)){
            countOrigin = listOrigin.get(origin);
            countOrigin++;
        }else{
            countOrigin = 1;
        }
        // place this value back into the counter
        listOrigin.put(origin, countOrigin);
        
        
    }
    
    
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //LicensePopularity popLic = new LicensePopularity();
      //  core.popularity
        core.popularity.print();
        System.exit(1981);        
    }

     /**
     * Provides a summary of the licenses found in the project
     * @return 
     */
    public String getPopularitySummary(){
        String result = "";
        
        // do we have a popular list to show in the first place?
        if(core.popularity.getList().size() >0){
            String temp = "";
            int counter = 0;
            for(String licenseId : core.popularity.getList().keySet()){
              License license = core.licenses.get(licenseId);
              // might be a license but was not indexed, skip this one
              if(license == null){
                  continue;
              }
              
              int popValue = core.popularity.getValue(licenseId);
              
              // this license is valid, add it up
              temp +=  "(" + popValue + ") "
                      + license.getPrettyText("", licenseId)
                      
                      ;
              counter++;
              // place a limit on 10 licenses on the list
              if(counter > 10){
                  break;
              }
            }
            // should we list this value on the first search ranking?
            if(counter > 0){
                result += html.h3("Licensing terms adopted")
                        + temp;
            }
        }
        
      
        return result;
    }
    
     
    
    /**
     * Print the results of what we got
     */
    private void print() {
        int rank = 0;
        for(String license : popularityList.keySet()){
            int value = popularityList.get(license);
            rank++;
            System.out.println("#" + rank + " " + license + " (" + value + ")");
        }
    }

    /**
     * Returns a list with the more popular licenses found on the reports
     * indexed previously.
     * @return 
     */
    public Map<String, Integer> getList() {
        return popularityList;
    }

    /**
     * How many times has this license been seen?
     * @param license   SPDX identifier
     * @return the number of times we've indexed this license
     */
    public int getValue(String license) {
        return popularityList.get(license);
    }

    /**
     * How many files have been accounted?
     * @return  An integer with the total number of files
     */
    public int getNumberOfFiles() {
        return numberOfFiles;
    }
    
    
    
    /**
     * Provides information about the files that were authored, mixed and
     * automatically generated.
     * @return  HTML code ready for presentation to the end-user
     */
    public String getAuthorStatsSummary(){
        String result = "";
        // sort the results
        Map<FileOrigin, Integer> sorted = utils.misc.sortByComparator(listOrigin);
        
        
        
        // go through the list of auhored files
        for(FileOrigin origin : sorted.keySet()){
            int counter = listOrigin.get(origin);
            result += ""
                    + utils.misc.getPercentage(counter, numberOfFiles)
                    + "% "
                    + origin.getFullText() 
                    + html.textGrey(
                         " (" 
                        + origin.getLowercase()
                        + ", "         
                        + utils.text.pluralize(counter, "file")
                        + ") ")
                    + html.br;
        }
        
        // do we have results?
        if(result.isEmpty() == false){
            result = html.br
                    + html.h3("File origin")
                    + result
                    ;
        }
        
        
        return result;
    }
   
  

   
    
    
}
