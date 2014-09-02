package others;


import definitions.TriggerType;
import java.io.File;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-16T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: PublicDomain.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under Public Domain.
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
public class PublicDomain implements Trigger {
    
    // the list of id's that we can use to identify a license
    String[] list = {
        "public domain"
    };
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(final String text, final String textLowerCase){
        String lowerCaseText = text.toLowerCase();
        // iterate all our ids
        for(String id : list){
            return verify(id, text, lowerCaseText);
        }
        return false;
    }

    // instead of generic "Public Domain"
    
    /**
     * Verifies if everything matches and if this trigger is applicable
     * @param text  the source code to verify
     * @return      true if applicable, false if not applicable
     */
    private boolean verify(String id, String text, String lowerCaseText){
        // detect a case where the public domain is listed but not applicable
        if(lowerCaseText.contains("instead of generic \"public domain\"")){
                return false;
        }
        if(lowerCaseText.contains(id)){
                return true;
        }
        // not enough reasons to consider applicable
        return false;
    }
    
    @Override
    public Boolean isApplicable(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getShortIdentifier() {
        return "Public Domain";
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
        return "Public Domain";
    }

    @Override
    public String getResult() {
        return LicenseInfoInFile + getShortIdentifier();
    }
    
    @Override
    public String getTriggerTitle() {
        return "Public Domain finder";
    }
}