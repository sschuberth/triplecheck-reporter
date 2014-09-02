/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-01-25T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LicenseID.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines a specific license  </text> 
 */

package script;

import java.util.Date;

/**
 *
 * @author Nuno Brito, 21st of December 2013 in Darsmtadt, Germany
 */
public class LicenseID {

    public String 
            shortID,
            longID,
            URL;
    
    public Date
            datePublished;
    
    // the list of id's that we can use to identify a license
    public String[] identifiers = {
        "gnu general public license",
        "gnu gpl",
        "gplv2 or later"
    };
    
            
    /**
     * Verifies if any of the ids for this license is inside the text
     * of source code that was provided
     * @param text the source code text
     * @return 
     */
    public boolean hasId(String text){
        for(String id : identifiers){
            if(text.contains(id)){
                return true;
            }
        }
        return false;
    }
            
    
}
