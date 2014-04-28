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
import spdxlib.License;
import spdxlib.SPDXfile;
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
    // where we map licenses to their value
    private Map<String,Integer> popularityList;
    
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
    private void doIndex() {
        // get the list of reports
        ArrayList<SPDXfile> reports = core.reports.list;
        log.write(is.CREATING, "Generating the license popularity list");
        
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
     * our own counter
     * @param fileInfo 
     */
    private void processFileInfo(FileInfo fileInfo){
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
   
    
    
}
