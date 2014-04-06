
import java.io.File;
import java.util.Date;
import script.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-06T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: BSD3ClauseClear.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a text file, try to identify portions of text
 *  that allows us to distinguish if the file is covered under a specific 
 *  license and which version is applicable when possible.</text> 
 */


/**
 *
 * @author Nuno Brito, 6th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class BSD3ClauseClear implements License {
    
    // the list of id's that we can use to identify a license
    String[] list = {
        "* Redistributions in binary form must reproduce the above"
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
        return "BSD-3-Clause-Clear";
    }

    @Override
    public String getURL() {
        return "http://spdx.org/licenses/BSD-3-Clause-Clear";
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
        return null;
    }

    @Override
    public String getQuickSummary() {
        return  "";
    }
    
    @Override
    public String getQuickSummaryLink() {
        return "";
    }
    

    @Override
    public String getFullName() {
        return "BSD 3-clause Clear License";
    }

    @Override
    public String getResult() {
        return LicenseInfoInFile + getShortIdentifier();
    }
    
}