package licenses;


import definitions.TriggerType;
import java.io.File;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-09-18T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: EUPL.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under the EUPL 
 *  license and which version when possible.
 * </text> 
 */


/**
 *
 * @author Nuno Brito, 18th of September 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class EUPL implements Trigger {
    
    // the list of id's that we can use to identify a license
    // identifiers are always in lower case to ease processing speed
    String[] list = {
        "eupl v.1.",
        "eupl-1.",
        "european union public licence v. 1."
    };
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(final String text, final String textLowerCase){
       // String lowerCaseText = text.toLowerCase();
        // iterate all our ids
        for(String id : list){
            if(textLowerCase.contains(id)){
                return true;
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
        return "EUPL-1.1";
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
        return "European Union Public License 1.1";
    }
    
    @Override
    public String getResult() {
        return LicenseInfoInFile + getShortIdentifier();
    }

    @Override
    public TriggerType getType(){
        return TriggerType.LICENSE;
    }
    
    @Override
    public String getTriggerTitle() {
        return "EUPL";
    }
    
}