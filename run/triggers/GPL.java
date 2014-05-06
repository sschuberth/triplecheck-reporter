
import definitions.TriggerType;
import java.io.File;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under the GPL 
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
public class GPL implements Trigger {
    
    // the list of id's that we can use to identify a license
    String[] list = {
        "GNU General Public License",
        "licenses/gpl-",
        " GPLv",
        "GPL 1.0",
        "GPL 2.0",
        "GPL 3.0",
        "GPL v1 ",
        "GPL v2 ",
        "GPL v3 ",
        "GPL-1.0",  // spdx id
        "GPL-2.0",  // spdx id
        "GPL-3.0"  // spdx id
    };
    
    // list of supported id's
    final String
            idGPL1_0 = "GPL-2.0",
            idGPL2_0 = "GPL-2.0",
            idGPL3_0 = "GPL-3.0",
            titleGPL1_0 = "GNU General Public License v1.0",
            titleGPL2_0 = "GNU General Public License v2.0",
            titleGPL3_0 = "GNU General Public License v3.0";
    
    // handle the cases of only this license version or above
    final String
            only = " only",
            later = " or later";
    
    // define the default values
    String 
            defaultId = idGPL3_0,
            defaultTitle = titleGPL3_0;
    
    
    /**
     * Detects which kind of LGPL license we are referring to. When no specific
     * information is available, we assume the most recent edition as default.
     * @param id    which trigger detected the license?
     * @param text  full source code text
     * @return      true when the license is confirmed, false when discarded
     */
    private Boolean detectLicenseVersion(String text) {
        String
                resultId = idGPL3_0,
                resultTitle = titleGPL3_0;
        // detect the supported versions
        if(hasVersion("1", text)){
            resultId = idGPL1_0;
            resultTitle = titleGPL1_0;
        }else
        if(hasVersion("2", text)){
            resultId = idGPL2_0;
            resultTitle = titleGPL2_0;
        }else
         if(hasVersion("3", text)){
            resultId = idGPL3_0;
            resultTitle = titleGPL3_0;
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
        return isNotBlackListed(text);
    }
    
      /**
     * Only accepts an entry that passes the triggers if it hasn't been somehow
     * blacklisted in the past.
     * @param text  the source code
     * @return      true if permitted to be added, false if it should be discarded
     */
    private Boolean isNotBlackListed(String text) {
        // cover the specific case of the GPL terms that include LGPL in text:
        /**
         *   The GNU General Public License does not permit incorporating your program
         * into proprietary programs.  If your program is a subroutine library, you
         * may consider it more useful to permit linking proprietary applications with
         * the library.  If this is what you want to do, use the GNU Lesser General
         * Public License instead of this License.  But first, please read
         * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
         */
        return !text.contains("why-not-lgpl.html");
    }
    
    
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
        return    text.contains("GPL " + version + ".0")
                ||text.contains("GPL-"+version + ".0")
                ||text.contains("GNU General Public License, version "+version+ ".0")
                ||text.contains("GPLv"+version)
                ||text.contains("License v"+version + ".0");
    }
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
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
    public String getURL() {
        return "http://spdx.org/licenses/" 
                + getShortIdentifier() + "#licenseText";
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
  
}