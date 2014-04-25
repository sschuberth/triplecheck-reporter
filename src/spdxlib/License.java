/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-25T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: License.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the template for License files </text> 
 */

package spdxlib;


/**
 *
 * @author Nuno Brito, 25th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class License {

    /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    public Boolean approvedOSI(){
        return false; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    public String getId(){
        return ""; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    public String getTitle(){
        return ""; // full text title
    }
}
