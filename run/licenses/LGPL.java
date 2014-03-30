
import java.io.File;
import java.util.Date;
import script.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-14T00:00:00Z
 * LicenseName: NOASSERTION
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
public class LGPL implements License {
    
    // the list of id's that we can use to identify a license
    String[] list = {
        "gnu lesser general public license",
        "lgpl",
        "gnu library general public license",
        "gnu lesser gpl"
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
        return "LGPL-2.1";
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
    public Date getDatePublished() {
        return utils.time.getDate(2004, 02, 01);
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
        return "GNU Library General Public License v2.1 only";
    }

}