
import definitions.TriggerType;
import java.io.File;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LGPL.java  
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
 */


/**
 *
 * @author Nuno Brito, 14th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class LGPL implements Trigger {
    
    // the list of id's that we can use to identify a license
    String[] list = {
        "gnu lesser general public license",
        "lgpl",
        "gnu library general public license",
        "gnu lesser gpl",
        "LGPL 2.0",
        "LGPL v2.0",
        "LGPL 2.1",
        "LGPL v2.1",
        "LGPL-2.1", // spdx id
        "LGPL 3.0",
        "LGPL v3.0",
        "LGPL-3.0"  // spdx id
    };
    
    // list of supported id's
    final String
            idLGPL2_0 = "LGPL-2.0",
            idLGPL2_1 = "LGPL-2.1",
            idLGPL3_0 = "LGPL-3.0",
            titleLGPL2_0 = "GNU Library General Public License v2.0",
            titleLGPL2_1 = "GNU Library General Public License v2.1",
            titleLGPL3_0 = "GNU Lesser General Public License v3.0";
    
    // handle the cases of only this license version or above
    final String
            only = " only",
            later = " or later";
    
    // define the default values
    String 
            defaultId = idLGPL3_0,
            defaultTitle = titleLGPL3_0;
    
    
    /**
     * Detects which kind of LGPL license we are referring to. When no specific
     * information is available, we assume the most recent edition as default.
     * @param id    which trigger detected the license?
     * @param text  full source code text
     * @return      true when the license is confirmed, false when discarded
     */
    private Boolean detectLicenseVersion(String id, String text) {
        // detect the supported versions
        if(hasVersion("2.1", text)){
            defaultId = idLGPL2_1;
            defaultTitle = titleLGPL2_1;
        }else
        if(hasVersion("3.0", text)){
            defaultId = idLGPL3_0;
            defaultTitle = titleLGPL3_0;
        }else
         if(hasVersion("2.0", text)){
            defaultId = idLGPL2_0;
            defaultTitle = titleLGPL2_0;
        }
        
        // detect the only or later situation
        if(hasLaterClause(text)){
            defaultTitle += later; // used on the textual description
            defaultId += "+"; // used on the SPDX id
        }else{
            defaultTitle += only;
        }
        
        return true;
    }
    
    
    /**
     * Verifies the type of version that is referred inside the source code
     * @param version   version to be detected
     * @param text      source code
     * @return          true if we have match, false if nothing was found
     */
    private boolean hasLaterClause(String text){
        return     text.contains(" or later (the") // detect "or later" text
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
        return    text.contains("LGPL " + version)
                ||text.contains("LGPL-"+version)
                ||text.contains("License v"+version);
    }
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
        String test = text.toLowerCase();
        // iterate all our ids
        for(String id : list){
            if(test.contains(id)){
                return detectLicenseVersion(id, text);
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