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

        
    // how big is the default GPL header across different reincarnations?
    final int headerSize = 150;
    
    // the list of keywords that we use to identify a possible license match
    String[] 
            keywordsFirstFilter = {
                "gpl",
                "general public license",
                "gnu general"
            },
            keywordsAGPL = {"agpl", "affero"},
            keywordsLGPL = {"lgpl", "lesser general", "library public license"},
            keywordsGPL = {"gpl", "gnu general public license", "gnu general"},
            listEvidenceLGPL = {
                "under lgpl license",
                "lgpl/",
                "/lgpl"
                },
            listEvidenceGPL = {
                " gpl",
                "/gpl"
                },
            listVersionVariations = {
                " ",
                "-",
                " v",
                "v"
                };
    
    
    // list the available licenses available
    LicenseGNU 
            GPL, GPL1_0, GPL2_0, GPL3_0, 
            LGPL, LGPL2_0, LGPL2_1, LGPL3_0, 
            AGPL3_0;
    
    // to list all the different GNU variants that we might find.
    ArrayList<String> licenses;
    
    boolean 
            isGPL, 
            isLGPL, 
            isAGPL,
            isTermsAGPL,
            isTermsLGPL,
            isTermsGPL;

    // public constructor
    public GNU(){
        GPL = new LicenseGNU("GPL", "GNU General Public License");
        GPL1_0 = new LicenseGNU("GPL-1.0", "GNU General Public License v1.0");
        GPL2_0 = new LicenseGNU("GPL-2.0", "GNU General Public License v2.0");
        GPL3_0 = new LicenseGNU("GPL-3.0", "GNU General Public License v3.0");
   
        LGPL = new LicenseGNU("LGPL", "GNU Library General Public License");
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
        isTermsGPL = false;
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
        checkGPL(contentLowerCase);
        // it is applicable when either one of these indicators is true
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
                // did we found a license file with the AGPL terms?
                if(checkForTermsAGPL(contentLowerCase)){
                    // no need to continue
                    break;
                }
                // proceed, let's see if find some AGPL evidence
                checkForEvidenceAndVersionAGPL(contentLowerCase);
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
        for(final String keyword : keywordsLGPL){
            // do we have a match inside the content?
            if(contentLowerCase.contains(keyword)){
                checkForTermsLGPL(contentLowerCase);
                checkForEvidenceAndVersionLGPL(contentLowerCase);
                break;
            }
        }
     }
   

    /**
     * Check if GPL content is present. This is the most trickiest value to
     * detect accurately. It is easy to confuse this license with either
     * LGPL or AGPL simply because of "GPL". Our strategy is to first detect
     * the other two license types, if any of them were detected before then
     * we have a better idea about how to prepare. Still, there might be cases
     * of false negatives when someone includes a file as dual licensed under
     * LGPL and GPL. In either case, our accuracy is still precise and it would
     * at most report the file as LGPL, which isn't necessarily a drama.
     * @param contentLowerCase 
     */
     private void checkGPL(final String contentLowerCase){
          // iterate all our keywords
        for(final String keyword : keywordsGPL){
            // do we have a match inside the content?
            if(contentLowerCase.contains(keyword)){
                checkForTermsGPL(contentLowerCase);
                checkForDefaultHeaderGPL(contentLowerCase);
                checkForEvidenceAndVersionGPL(contentLowerCase);
                break;
            }
        }
     }
     
     /**
      * Verifies if this file is just mentioning the AGPL or if this is the
      * license text. We use a specific term that is only found on this context.
      */
     boolean checkForTermsAGPL(final String contentLowerCase){
         isTermsAGPL = contentLowerCase.contains
        ("patent license was granted, prior to 28 march 2007");
         
         // avoid the GPL license terms which are similar
         if(contentLowerCase.contains("13. use with the gnu affero general public license.")){
             isTermsAGPL = false;
         }
         
         
         // not an AGPL license file
         if(isTermsAGPL == false){
             return false;
         }
         
         isAGPL = true;
         addLicense(AGPL3_0);
         return true;
     }
     
     /**
      * Verifies if this file is just mentioning the LGPL or if this is the
      * license text. We use a specific term that is only found on this context.
      */
     void checkForTermsLGPL(final String contentLowerCase){
         // version 2.0 of the LGPL?
         if(contentLowerCase.contains("copyright (c) 1991 free software foundation")){
             isTermsLGPL = true;
             isLGPL = true;
             addLicense(LGPL2_0);
         }
         // version 2.1 of the LGPL?
         if(contentLowerCase.contains("copyright (c) 1991, 1999 free software foundation")){
             isTermsLGPL = true;
             isLGPL = true;
             addLicense(LGPL2_1);
         }
         // version 3.0 of the LGPL?
         if(contentLowerCase.contains("1. exception to section 3 of the gnu gpl.")){
             isTermsLGPL = true;
             isLGPL = true;
             addLicense(LGPL3_0);
         }
     }
     
     /**
      * Verifies if this file is just mentioning the LGPL or if this is the
      * license text. We use a specific term that is only found on this context.
      */
     void checkForTermsGPL(final String contentLowerCase){
         // version 1.0 of the GPL?
         if(contentLowerCase.contains("version 1, february 1989")){
             isGPL = true;
             isTermsGPL = true;
             addLicense(GPL1_0);
         }
         // version 2.0 of the GPL?
         if(contentLowerCase.contains("copyright (c) 1989, 1991 free software foundation")){
             isGPL = true;
             isTermsGPL = true;
             addLicense(GPL2_0);
         }
         // version 3.0 of the GPL?
         if(contentLowerCase.contains("the gpl, as needed to protect")){
             isGPL = true;
             isTermsGPL = true;
             addLicense(GPL3_0);
         }
     }
     
     
     /**
      * Looks for the default GPL headers placed on source code 
      * @param contentLowerCase     The content to analyse
      */
     void checkForDefaultHeaderGPL(final String contentLowerCase){
         // for the moment we won't proceed if another license was already here
         if(isGPL || isAGPL || isLGPL){
             return;
         }
 
         // let's find the header license attribution (sometimes not on top)
         //final String anchorText = "this program is free software";
         final String anchorText = " free software";
         int anchorId = contentLowerCase.indexOf(anchorText);
         
         // wasn't found, no need to proceed
         if(anchorId == -1){
             // give it a second try
             anchorId = contentLowerCase.indexOf("gnu general");
             if(anchorId == -1){
                 return;
             }
//             return;
         }
         
         // is the header big enough to get a sample?
         if((anchorId + headerSize) > contentLowerCase.length()){
             return;
         }
         
         // since we have some content big enough, let's extract the header lines
         final String header = contentLowerCase.substring(anchorId, anchorId +headerSize);
         
         // now let's look for matches, are we on the right track?
         if(header.contains("gnu general")==false){
             // doesn't seem that way, exit here
             return;
         }
         
         // now let's fetch the version and the "or later" part
         String result;
         if(header.contains("either version 1")){
             result = GPL1_0 + "+";
         }else
         if(header.contains("either version 2")){
             result = GPL2_0 + "+";
         }else
         if(header.contains("either version 3")){
             result = GPL3_0 + "+";
         }else
         // now iterate for single GPL (no automatic upgrade)
         if(header.contains("version 1")){
             result = GPL1_0.getId() + "";
         }else
         if(header.contains("version 2")){
             result = GPL2_0.getId() + "";
         }else
         if(header.contains("version 3")){
             result = GPL3_0.getId() + "";
         }
         else{
             result =GPL.getId();
         }
         
         // check for exception declarations
         if(header.contains("exception, the respective autoconf")){
             // replace the "plus" and add the autoconf exception attribute
             result = result.replace("+", "") +  "-with-autoconf-exception";
             isGPL = true;
         }
         
         // add the license as detected
         addLicense(result);
         isGPL = true;
     };
     
    /**
     * We call this method after determining if the content are the license
     * terms of LGPL. Now our concern is to attempt discovering file fragments
     * that might indicate a declaration of LGPL. This is not a bullet-proof
     * detection. In some cases no LGPL version is indicated, needs to be
     * manually concluded by an auditor or analysed in the context of the
     * component to where it belongs.
     * @param contentLowerCase 
     */ 
    private void checkForEvidenceAndVersionLGPL(final String contentLowerCase){
        // certain definitions for each LGPL edition
        if(checkForLicense("LGPL", "lgpl", "2", ".0", contentLowerCase)){
             isLGPL = true;
        }
        if(checkForLicense("LGPL", "lgpl", "2", ".1", contentLowerCase)){
             isLGPL = true;
        }
        if(checkForLicense("LGPL", "lgpl", "3", ".0", contentLowerCase)){
             isLGPL = true;
        }
        // non-conclusive definitions. There is no prescription in SPDX
        // for LGPL without a version declared. Yet, we do have a solid
        // indication that LGPL can be applicable and this should be brought
        // up to attention. Would be nice if the SPDX license list would
        // not be strict to the point of disallowing non-listed license types.
        for(final String evidence : listEvidenceLGPL){
            if(contentLowerCase.contains(evidence)){
                isLGPL = true;
                addLicense(LGPL);
            }
        }
    } 


    /**
     * This method is scary. Needs to find possible hints where authors
     * declare the GPL as applicable and somehow avoid mixing it with
     * any of the other GNU licenses that coincidentally uses the same
     * abbreviations.
     * @param contentLowerCase      The content to be analysed
     */
    private void checkForEvidenceAndVersionGPL(final String contentLowerCase){
        // no need to proceed if a former test was done on this file
        if(isGPL){
            return;
        }
        
        // define the gpl keyword in its most complete manner
        String keyword = "gpl";

        // if we have a LGPL or AGPL inside the content, decrease
        // our accuracy but still try to fish some valid results.
        if(isLGPL || isAGPL){
            // we add a space, helps a bit to avoid false positives
            // but increases false negatives too.
            keyword = " gpl";
            //return;
        }
        
            if(checkForLicense("GPL", keyword, "1", ".0", contentLowerCase)){
                 isGPL = true;
            }
            if(checkForLicense("GPL", keyword, "2", ".0", contentLowerCase)){
                 isGPL = true;
            }
            if(checkForLicense("GPL", keyword, "3", ".0", contentLowerCase)){
                 isGPL = true;
            }
        
        // now go for the non-conclusive evidence that some GPL exists
        // this is only permitted if neither GPL, LGPL nor AGPL were detected before
        if(!isGPL && !isLGPL && !isAGPL){
            for(final String evidence : listEvidenceGPL){
                if(contentLowerCase.contains(evidence)){
                    isGPL = true;
                    addLicense(GPL);
                }
            }
        }
        
    }

    
    
    
    /**
     * Try to pinpoint which license version is being used when only a part
     * of the license designation is provided.
     * @param version           The version we want to pinpoint
     * @param contentLowerCase  The content where we look for this info
     */
    private boolean checkForLicense(final String licenseUpperCase, final String licenseAbbreviation, 
            final String versionMajor, final String versionMinor, 
            final String contentLowerCase){
        
        // it is difficult to spot SPDX cases such as GPL-2.0+ declared
        // inside the source code so we need to find at this specific point
        final String spdxID = licenseUpperCase
                + "-" + versionMajor + versionMinor;
        
        if(contentLowerCase.contains(spdxID + "+")){
            addLicense(spdxID + "+");
            return true;
        }

        // iterate some commons variations of how people list licenses
        for(final String variation : listVersionVariations){
            // now build the keyword using the license abbreviation and version
            final String keyword = licenseAbbreviation + variation 
                    + versionMajor + versionMinor;
            if(contentLowerCase.contains(keyword)){
                // we have a match
               addLicense(spdxID);
               return true;
           }
        }
        // second round, using only the major versions without the minor version
        for(final String variation : listVersionVariations){
            // now build the keyword using the license abbreviation and version
            final String keyword = licenseAbbreviation + variation 
                    + versionMajor;
            if(contentLowerCase.contains(keyword)){
                // we have a match
               addLicense(spdxID);
               return true;
           }
        }
        // nothing to return 
      return false;  
    }
    
    
     /**
      * Adds a new license to list if not added before
      * @param license  A valid LicenseGNU object
      */
     private void addLicense(final String newLicense){
         for(final String license : licenses){
             if(utils.text.equals(license, newLicense)){
                 return;
             }
         }
         // no duplicates, add it up
         licenses.add(newLicense);
     }
     
     private void addLicense(final LicenseGNU newLicense){
         addLicense(newLicense.getId());
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
        for(final String license : licenses){
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

    /**
     * Verify if we have some evidence that the content being analysed contains
     * something that resembles AGPL.
     * @param contentLowerCase The content to be analysed
     */
    private void checkForEvidenceAndVersionAGPL(final String contentLowerCase) {
        for(final String evidence : keywordsAGPL){
            if(contentLowerCase.contains(evidence)){
                isAGPL = true;
                // only one mainstream AGPL version to consider at this moment
                addLicense(AGPL3_0);
            }
        }
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
    
    @Override
    public String toString(){
        return id;
    }
    
}