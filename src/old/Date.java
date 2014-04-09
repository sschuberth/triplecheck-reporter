  /*
   * SPDXVersion: SPDX-1.1
   * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
   * Creator: Organization: TripleCheck (contact@triplecheck.de)
   * Date: 2013-08-29T00:00:00Z
   * LicenseName: EUPL-1.1-without-appendix
   * FileName: Date.java  
   * FileType: SOURCE
   * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
   * FileComment: <text>Class to manipulate the SPDX "Date" field correctly
   * </text> 
   */

package old;



public class Date {

    // this string needs to output date in the ISO 8601 standard
    String output; // for e.g.  2013-08-29T00:00:00Z
    
    int
            YYYY, // year
            MM, // month
            DD, // day
            hh, // hour
            mm, // minutes
            ss; // seconds
    
}
