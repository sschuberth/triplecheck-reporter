package licenses;


import definitions.TriggerType;
import java.io.File;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: MPL.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under the MPL 
 *  terms and which version when possible.
 * 
 * When looking at other tools detecting licenses, I note that exists a 
 * tendency to create a catalogue separate for each type of license and its 
 * variation. Here, the goal is different. We are grouping as much as possible 
 * all the related licenses under a single class. In the end, this helps us to 
 * accomodate in a much more sensible manner all the existent variations.
 * </text> 
 */


/**
 *
 * @author Nuno Brito, 30th of April 2014 in Amrum, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class MPL implements Trigger {
    
    // the list of id's that we can use to identify a license
    String[] list = {
        "Mozilla Public License",
        "http://www.mozilla.org/MPL",
        //"MPL",
        "MPL 1.0",
        "MPL 1.1",
        "MPL 2.0",
        "MPL v1 ",
        "MPL v2 ",
        "MPL v3 ",
        "MPL-1.0",  // spdx id
        "MPL-1.1",  // spdx id
        "MPL-2.0"   // spdx id
    };
    
    // list of supported id's
    final String
            idMPL1_0 = "MPL-1.0",
            idMPL1_1 = "MPL-1.1",
            idMPL2_0 = "MPL-2.0",
            title = "Mozilla Public License";
    
    // handle the cases of only this license version or above
    final String
            only = " only",
            later = " or later";
    
    // define the default values
    String 
            defaultId = idMPL2_0,
            defaultTitle = title;
    
    
    /**
     * Detects which kind of LGPL license we are referring to. When no specific
     * information is available, we assume the most recent edition as default.
     * @param id    which trigger detected the license?
     * @param text  full source code text
     * @return      true when the license is confirmed, false when discarded
     */
    private Boolean detectLicenseVersion(String textOriginal) {
        String
                resultId = idMPL2_0,
                resultTitle = title;
        
        // reduce issues due to break lines
        String text = normalizeText(textOriginal);
               
        
        // detect the supported versions
        if(hasVersion("1.0", text)){
            resultId = idMPL1_0;
            resultTitle = title + " 1.0";
        }else
        if(hasVersion("1.1", text)){
            resultId = idMPL1_1;
            resultTitle = title + " 1.1";
        }else
         if(hasVersion("2.0", text)){
            resultId = idMPL2_0;
            resultTitle = title + " 2.0";
        }
        
        // detect the only or later situation
        if(hasLaterClause(text)){
            resultId += "+"; // used on the SPDX id
            resultTitle += later; // used on the textual description
        }else{
            resultTitle += only;
        }
        
        // mark the license description
        defaultId = resultId;
        defaultTitle = resultTitle;
        return true;
                //isNotBlackListed(text);
    }
    
    
     /**
     * This method permits to remove comments and other text characters
     * that change the meaning of the given trigger to be identified
     * @param text  the source code
     * @return      the source code after removing non-wanted characters
     */
    private String normalizeText(String text){
        String result = text.replace("\n", "");
            result = result.replace("\r", "");
        return result;
    }
    
//      /**
//     * Only accepts an entry that passes the triggers if it hasn't been somehow
//     * blacklisted in the past.
//     * @param text  the source code
//     * @return      true if permitted to be added, false if it should be discarded
//     */
//    private Boolean isNotBlackListed(String text) {
//        // cover the specific case of the GPL terms that include LGPL in text:
//        /**
//         *   The GNU General Public License does not permit incorporating your program
//         * into proprietary programs.  If your program is a subroutine library, you
//         * may consider it more useful to permit linking proprietary applications with
//         * the library.  If this is what you want to do, use the GNU Lesser General
//         * Public License instead of this License.  But first, please read
//         * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
//         */
//        return !text.contains("why-not-lgpl.html");
//    }
    
    
    /**
     * Verifies the type of version that is referred inside the source code
     * @param version   version to be detected
     * @param text      source code
     * @return          true if we have match, false if nothing was found
     */
    private boolean hasLaterClause(String text){
        return     text.contains(" or later (the") // detect "or later" text
                || text.contains(" or later;") // detect "or later" text
                || text.contains("option) any later version.") // LGPL 3.0+
                || text.contains( defaultId + "+"); // detect SPDX id tag
    }
    
    /**
     * Verifies the type of version that is referred inside the source code
     * @param version   version to be detected
     * @param text      source code
     * @return          true if we have match, false if nothing was found
     */
    private boolean hasVersion(String version, String text){
        return    text.contains("MPL " + version)
                ||text.contains("MPL-"+version)
                ||text.contains("Mozilla Public License, version "+version)
                // we need to find a way of removing these exceptions
                ||text.contains("Mozilla Public License  Version "+version)
                ||text.contains("MPLv"+version)
                ||text.contains("Mozilla Public License v"+version);
    }
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(final String text, final String textLowerCase){
        //String test = text.toLowerCase();
        // iterate all our ids
        for(String id : list){
            if(text.contains(id)){
                return detectLicenseVersion(text);
            }
        }
        return false;
    }

    @Override
    public Boolean isApplicable(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getShortIdentifier() {
        return defaultId;
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
    public TriggerType getType(){
        return TriggerType.LICENSE;
    }

    @Override
    public String getFullName() {
        return defaultTitle;
    }

    @Override
    public String getResult() {
        return LicenseInfoInFile + getShortIdentifier();
    }
  
    @Override
    public String getTriggerTitle() {
        return "MPL";
    }
}