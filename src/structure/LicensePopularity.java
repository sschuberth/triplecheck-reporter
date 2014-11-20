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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import main.coreGUI;
import main.engine;
import spdxlib.FileInfo;
import spdxlib.License;
import spdxlib.LicenseType;
import spdxlib.SPDXfile;
import utils.www.html;


/**
 *
 * @author Nuno Brito, 27th of April 2014 in the highway to North sea, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public final class LicensePopularity {
    
    // the place where we keep our ranking score for each license
    private HashMap<LicenseType, Integer> listLicense = new HashMap();
    // where we map licenses to their value
    private Map<LicenseType,Integer> popularityList;
    
    /**
     * Process the licenses inside a given SPDX report 
     * @param report
     * @param title
     * @param link
     * @return 
     */
    public String processReport(SPDXfile report, 
            final String title, final String link){
        String result = "";
        
        listLicense = new HashMap();
        
        if(popularityList != null){
            popularityList = null;
        }
        // iterate through each file on this report
        for(FileInfo fileInfo : report.getFiles()){
            // get the licenses within
            processFileInfo(fileInfo);
        }
        
        // index all the licenses according to popularity
        popularityList = ThirdParty.MiscMethods.sortByComparator(listLicense);
        
        // no need to continue for empty results
        if(popularityList.isEmpty()){
            return "";
        }
        
        result += html.h3("Licenses used in this project");
        
        if(popularityList.isEmpty() == false){
        for(LicenseType licenseType : popularityList.keySet()){
            try{
            int popValue = popularityList.get(licenseType);
            License license = engine.licenses.getAsTitle(licenseType.toTitle());
            result += 
                    "(" + popValue + ") "
                    + license.getPrettyText(title, link + license.getId());
            }catch(Exception e){
                System.err.println("LP79 - Invalid license: " + licenseType.toId());
            }
        }
        }
        // all done
        result += html.br;
        
        return result;
    }
    
    /**
     * Get inside the file info to get the licenses and place them inside
     * our own counter. This method has now been expanded to include the
     * counting of original files.
     * @param fileInfo 
     */
    private void processFileInfo(FileInfo fileInfo){
        // get the list of licenses
        ArrayList<LicenseType> licList = new ArrayList();
        
        // we can't assign the arraylist directly or else we change the original
        for(LicenseType thisLicense : fileInfo.getLicenseInfoInFile()){
            licList.add(thisLicense);
        }
        
        // do we have a license defined as well?
        if(fileInfo.hasLicenseConcluded()){
            licList.add(fileInfo.getLicenseConcluded());
        }
        
        // iterate through each license that was found
        for(LicenseType license : licList){
            int counter;
            // have we found this license before? If so, get the counter
            if(listLicense.containsKey(license)){
                counter = listLicense.get(license);
                // add up another notch
                counter++;
            }else{
                // not found before, add it for the first time
                counter = 1;
            }
            // all done, place it back in place
            listLicense.put(license, counter);
        }
    }
    
    /**
     * Provides a summary of the licenses found in the project
     * @return 
     */
    public String getPopularitySummary(){
        String result = "";
        
        // do we have a popular list to show in the first place?
        if(coreGUI.popularity.getList().size() >0){
            String temp = "";
            int counter = 0;
            for(LicenseType licenseId : coreGUI.popularity.getList().keySet()){
              License license = engine.licenses.get(licenseId.toId());
              // might be a license but was not indexed, skip this one
              if(license == null){
                  continue;
              }
              
              int popValue = coreGUI.popularity.getValue(licenseId);
              
              // this license is valid, add it up
              temp +=  "(" + popValue + ") "
                      + license.getPrettyText("Choose", licenseId.toId())
                      ;
              counter++;
              // place a limit on 10 licenses on the list
              if(counter > 10){
                  break;
              }
            }
            // should we list this value on the first search ranking?
            if(counter > 0){
                result += html.h3("Licensing terms being used")
                        + temp;
            }
        }
        
      
        return result;
    }
    
    /**
     * Returns a list with the more popular licenses found on the reports
     * indexed previously.
     * @return 
     */
    public Map<LicenseType, Integer> getList() {
        return popularityList;
    }

    /**
     * How many times has this license been seen?
     * @param license   SPDX identifier
     * @return the number of times we've indexed this license
     */
    public int getValue(LicenseType license) {
        return popularityList.get(license);
    }
}
