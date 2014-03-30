
import java.io.File;
import java.util.Date;
import script.License;
import script.LicenseID;
import utils.time;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-16T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: GPL.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under the LGPL 
 *  terms and which version when possible.
 * 
 * When looking at other tools detecting licenses, I note that exists a 
 * tendency to create a catalogue separate for each type of license and its 
 * variation. Here, the goal is different. We are grouping as much as possible 
 * all the related licenses under a single class. In the end, this helps us to 
 * accomodate in a much more sensible manner all the existent variations.
 * </text> 
 * 
 * GPL detection needs to be seriously improved..
 */


/**
 *
 * @author Nuno Brito, 16th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class GPL implements License {
    
    // the initial trigger before we dig deeper into the source code
    String[] initialTrigger = {
        "gnu general public license",
        "gnu gpl",
        "gpl"
    };
    
    // default values for our short identifier and full name
//    private String shortIdentifier = "GPL";
//    private String fullName = "GNU General Public License";
    
    
    LicenseID gplv2_only = new LicenseID();
    LicenseID gplv2_plus = new LicenseID();
    
    // set the default ID when asked
    LicenseID defaultLicense; 
    
    
    LicenseID[] pool = {
        gplv2_only, 
        gplv2_plus
    };
    
    /**
     * Constructor
     */
    public GPL(){
        // how can we identify the different license variants?
        
        gplv2_only.shortID = "GPL-2.0";
        gplv2_only.longID = "GNU General Public License v2.0 only";
        gplv2_only.URL = "http://spdx.org/licenses/GPL-2.0";
        gplv2_plus.datePublished = time.getDate(1991, 6, 01);
        
        gplv2_plus.shortID = "GPL-2.0+";
        gplv2_plus.longID = "GNU General Public License v2.0 or later";
        gplv2_plus.URL = "http://spdx.org/licenses/GPL-2.0+";
        gplv2_plus.datePublished = time.getDate(1991, 6, 01);
        gplv2_plus.identifiers = new String[]{
            "either version 2 of the License",
            "Version 2, June 1991"
            };
        
        
         // set the default ID when asked
        defaultLicense = gplv2_only;
    }
    
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
        // iterate all our ids to see if something triggers further interest
        for(String trigger : initialTrigger){
            if(text.contains(trigger)){
                investigateLicense(text);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isApplicable(File file) {
        return null;
    }

    @Override
    public String getShortIdentifier() {
        return defaultLicense.shortID;
    }

    @Override
    public String getURL() {
        return defaultLicense.URL;
    }

    @Override
    public Boolean supportsBinaries() {
        // are we able to detect a license text inside binary files?
        return false;
    }

    @Override
    public Boolean supportsTextFiles() {
        return true;
    }

   
    @Override
    public Date getDatePublished() {
        return defaultLicense.datePublished; //utils.time.getDate(2004, 02, 01);
    }

    @Override
    public String getQuickSummary() {
        return  "";
    }
    
    @Override
    public String getQuickSummaryLink() {
        return "";
    }
    

    @Override
    public String getFullName() {
        return defaultLicense.longID;
    }

    /**
     * Looks better into the provided text and tries to determinate which
     * specific type of license is being applied
     * @param text 
     */
    private void investigateLicense(String text) {
        for(LicenseID thisId: pool){
            if(thisId.hasId(text)){
                defaultLicense = thisId;
                return;
            }
        }
        
       
    }

}