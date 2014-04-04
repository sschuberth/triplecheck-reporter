
import java.io.File;
import java.util.Date;
import script.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: Apache.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under the Apache 
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
public class Apache implements License {
    
    // the list of id's that we can use to identify a license
    // identifiers are always in lower case to ease processing speed
    String[] list = {
        "apache License, version 2.0",
        "apache v2",
        "apache 2.0"
    };
    
    /**
     * Verifies if the provided text applies to the triggers that
     * included on this license.
     * @param text Text to be analysed
     * @return 
     */
    @Override
    public Boolean isApplicable(String text){
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
    public String getQuickSummary() {
        return  " ### Sublicensing:\n"
                + " You can distribute modified or unmodified, both source & "
                + "object versions, under a different license if the license "
                + "complies with Apache 2.0\n"
                + " \n"
                + " ### Distributing;\n"
                + " 1) provide a copy of the license; \n"
                + " 2) document modifications in files \n"
                + " 3) if you make a derivative of the code licensed, keep it "
                + "in source code form\n"
                + " \n"
                + " ### Patent Grants:\n" 
                + " Broad patent license to claims that are necessarily "
                + "infringed by Contribution, or a Contribution combined "
                + "with the Work to which such Contribution was submitted.\n"
                + " Can't sue: You cannot claim patent infringement over "
                + "your contributions or derivated changes\n";
    }
    
    @Override
    public String getQuickSummaryLink() {
        return "http://www.tldrlegal.com/license/apache-license-2.0-%28apache-2.0%29";
    }
    

    @Override
    public String getFullName() {
        return "Apache License 2.0";
    }
    
    @Override
    public String getResult() {
        return LicenseInfoInFile + getShortIdentifier();
    }
}