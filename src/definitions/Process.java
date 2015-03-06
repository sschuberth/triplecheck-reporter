/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-15T00:00:00Z
 *
 * LicenseName: AGPL-3.0+
 *
 * FileName: Process.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> Helps to know which part of the SPDX document is 
 * currently being processed </text> 
 */

package definitions;


public class Process {

    public static final int
       nothing = 0,
       header = 1,
       packageData = 2,
       files = 3,
       review = 4;     
}
