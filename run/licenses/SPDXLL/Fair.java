package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:32:21Z
 * LicenseName: Apache-2.0
 * FileName: Fair.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class Fair extends License{
   /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    @Override
    public Boolean approvedOSI(){
        return true; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    @Override
    public String getId(){
        return "Fair"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Fair License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Fair License\n"
        + "\n"
        + "<Copyright Information>\n"
        + "\n"
        + "Usage of the works is permitted provided that this instrument is retained with t"
        + "he works, so that any entity that uses the works is notified of this instrument.\n"
        + "\n"
        + "DISCLAIMER: THE WORKS ARE WITHOUT WARRANTY.\n"
        + "\n"
        + "[2004, Fair License: rhid.com/fair (this URL no longer works)]\n"
; // the license text
    }
 
    
}
