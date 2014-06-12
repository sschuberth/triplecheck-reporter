package licenses;


import definitions.TriggerType;
import java.io.File;
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
    
    @Override
    public Boolean isApplicable(String content, String contentLowerCase) {
        // iterate all our ids
        for(String keyword : keywordsFirstFilter){
            if(contentLowerCase.contains(keyword)){
                return detectLicenseTerms(contentLowerCase);
            }
        }
        return false;
    }

    
    /**
     * Attempts to detect any applicable license terms
     * @param contentLowerCase
     * @return 
     */
    Boolean detectLicenseTerms(final String contentLowerCase){
        
        return false;
    }
    
    @Override
    public Boolean isApplicable(File file) {
        return false;
    }

    @Override
    public String getShortIdentifier() {
        return "N/A";
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
        return "Result: N/A";
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
    final String id, title;

    public LicenseGNU(final String assignedID, final String assignedTitle){
        this.id = assignedID;
        this.title = assignedTitle;
    }
    
}