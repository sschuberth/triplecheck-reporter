package licenses;


import definitions.TriggerType;
import java.io.File;
import java.util.ArrayList;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-12T12:15:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GNU.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Let's try to identify if a given content is related
   license terms published by the Free Software Foundation.</text> 
 */


/**
 *
 * @author Nuno Brito, 12th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class GNU implements Trigger {

        
    // the list of keywords that we use to identify a possible license match
    String[] keywordsFirstFilter = {
        "gpl",
        "general public license"
    };
    
    String[] 
            keywordsAGPL = {"agpl", "affero"},
            keywordsLGPL = {"lesser general public license", ""};
    
    
    // list the available licenses available
    LicenseGNU GPL1_0, GPL2_0, GPL3_0, LGPL2_0, LGPL2_1, LGPL3_0, AGPL3_0;
    
    // to list all the different GNU variants that we might find.
    ArrayList<String> licenses;
    
    boolean 
            isGPL, 
            isLGPL, 
            isAGPL,
            isTermsAGPL,
            isTermsLGPL;

    
    // public constructor
    public GNU(){
        GPL1_0 = new LicenseGNU("GPL-1.0", "GNU General Public License v1.0");
        GPL2_0 = new LicenseGNU("GPL-2.0", "GNU General Public License v2.0");
        GPL3_0 = new LicenseGNU("GPL-3.0", "GNU General Public License v3.0");
   
        LGPL2_0 = new LicenseGNU("LGPL-2.0", "GNU Library General Public License v2.0");
        LGPL2_1 = new LicenseGNU("LGPL-2.1", "GNU Library General Public License v2.1");
        LGPL3_0 = new LicenseGNU("LGPL-3.0", "GNU Lesser General Public License v3.0");
   
        AGPL3_0 = new LicenseGNU("AGPL-3.0", "GNU Affero General Public License v3.0");
    }
    
    
    @Override
    public Boolean isApplicable(String content, String contentLowerCase) {
        // reset the detection variables
        preFlightCheck();
        // iterate all our keywords
        for(String keyword : keywordsFirstFilter){
            if(contentLowerCase.contains(keyword)){
                return detectLicenseTerms(contentLowerCase);
            }
        }
        // can only return true when either licenses were detected
        return false;
    }

    
    /**
     * initialize the singleton variables
     * back to default values
     */
    private void preFlightCheck(){
        isGPL = false; 
        isLGPL = false;
        isAGPL = false;
        isTermsAGPL = false;
        isTermsLGPL = false;
        licenses = new ArrayList();
    }
    
    /**
     * Attempts to detect any applicable license terms
     * @param contentLowerCase
     * @return 
     */
    private Boolean detectLicenseTerms(final String contentLowerCase){
        // go through each possible type of license
        checkAGPL(contentLowerCase);
        checkLGPL(contentLowerCase);
        
        return isGPL || isLGPL || isAGPL;
    }
    
    /**
     * Check if AGPL content is present
     * @param contentLowerCase 
     */
     private void checkAGPL(final String contentLowerCase){
        // iterate all our keywords
        for(String keyword : keywordsAGPL){
            // do we have a match inside the content?
            if(contentLowerCase.contains(keyword)){
                isAGPL = true;
                containsTermsAGPL(contentLowerCase);
                addLicense(AGPL3_0);
                break;
            }
        }
     }
    
    /**
     * Check if LGPL content is present
     * @param contentLowerCase 
     */
     private void checkLGPL(final String contentLowerCase){
          // iterate all our keywords
        for(String keyword : keywordsLGPL){
            // do we have a match inside the content?
            if(contentLowerCase.contains(keyword)){
                containsTermsLGPL(contentLowerCase);
                if(isTermsLGPL){
                    isLGPL = true;
                    System.out.println("Yupii");
                    addLicense(LGPL2_1);
                }
                break;
            }
        }
     }
    
     
     /**
      * Verifies if this file is just mentioning the AGPL or if this is the
      * license text. We use a specific term that is only found on this context.
      */
     void containsTermsAGPL(final String contentLowerCase){
         isTermsAGPL = contentLowerCase.contains
        ("patent license was granted, prior to 28 march 2007");
     }
     
      /**
      * Verifies if this file is just mentioning the LGPL or if this is the
      * license text. We use a specific term that is only found on this context.
      */
     void containsTermsLGPL(final String contentLowerCase){
         isTermsLGPL = contentLowerCase.contains
        ("we call this license the \"lesser\" general public license");
     }
     
     
    
      
     /**
      * Adds a new license to list if not added before
      * @param license  A valid LicenseGNU object
      */
     private void addLicense(final LicenseGNU newLicense){
         for(final String license : licenses){
             if(utils.text.equals(license, newLicense.getId())){
                 return;
             }
         }
         // no duplicates, add it up
         licenses.add(newLicense.getId());
     }
     
            
             
    @Override
    public Boolean isApplicable(File file) {
        return false;
    }

    @Override
    public String getShortIdentifier() {
        return "GNU";
    }

    @Override
    public TriggerType getType() {
        return TriggerType.LICENSE;
    }

    @Override
    public Boolean supportsBinaries() {
        return false;
    }

    @Override
    public Boolean supportsTextFiles() {
        return true;
    }

    @Override
    public String getFullName() {
        return "Detect possible matches with GNU license terms";
    }

    @Override
    public String getResult() {
        String result = "";
         // list the detected licenses
        for(String license : licenses){
            result = result.concat(LicenseInfoInFile.concat(license));
        }
        if(licenses.size() > 1){
            result = result.replace(LicenseInfoInFile, "\n" + LicenseInfoInFile).substring(1);
        }
        // all done
        return result;
    }

    @Override
    public String getTriggerTitle() {
        return "GNU license terms";
    }
    
}

/**
 * Define the identifiers specific to each GNU license
 */
class LicenseGNU{
    private final String id, title;
    private boolean 
            hasException = false,
            orLater = false;

    public String getId() {
        if(orLater){
            return id + "+";
        }
        return id;
    }

    public void reset(){
        hasException = false;
        orLater = false;
    }
    
    public void setOrLater(){
        orLater = true;
    }
    
    public String getTitle() {
        return title;
    }
    
    public LicenseGNU(final String assignedID, final String assignedTitle){
        this.id = assignedID;
        this.title = assignedTitle;
    }

    public boolean isHasException() {
        return hasException;
    }

    public void setHasException(boolean hasException) {
        this.hasException = hasException;
    }
    
    
    
}