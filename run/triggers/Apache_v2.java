
import definitions.TriggerType;
import java.io.File;
import java.util.Date;
import script.Trigger;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Apache_v2.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under the Apache_v2 
 *  license and which version when possible.
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
public class Apache_v2 implements Trigger {
    
    // the list of id's that we can use to identify a license
    // identifiers are always in lower case to ease processing speed
    String[] list = {
        "Apache License, Version 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0",
        "Apache License Version 2.0",
    };
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
       // String lowerCaseText = text.toLowerCase();
        // iterate all our ids
        for(String id : list){
            if(text.contains(id)){
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
        return "Apache-2.0";
    }

    @Override
    public String getURL() {
        return "http://spdx.org/licenses/Apache-2.0#licenseText";
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
    public Date getDatePublished() {
        return utils.time.getDate(2004, 02, 01);
    }

    @Override
    public String getFullName() {
        return "Apache License 2.0";
    }
    
    @Override
    public String getResult() {
        return LicenseInfoInFile + getShortIdentifier();
    }

    @Override
    public TriggerType getType(){
        return TriggerType.LICENSE;
    }
}