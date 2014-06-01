package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:52Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: IBM_pibs.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class IBM_pibs extends License{
   /**
     * Was this license approved by the OSI?
     * @return  True if the license is listed as approved   
     */
    @Override
    public Boolean approvedOSI(){
        return false; // was this license OSI approved or not?
    }
    
    /**
     * The SPDX identifier
     * @return  The unique identifier for this license
     */
    @Override
    public String getId(){
        return "IBM-pibs"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "IBM PowerPC Initialization and Boot Software "; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "This source code has been made available to you by IBM on an AS-IS basis.  Anyon"
        + "e receiving this source is licensed under IBM copyrights to use it in any way he"
        + " or she deems fit, including copying it, modifying it, compiling it, and redistr"
        + "ibuting it either with or without modifications.  No license under IBM patents o"
        + "r patent applications is to be implied by the copyright license.\n"
        + "\n"
        + "Any user of this software should understand that IBM cannot provide technical su"
        + "pport for this software and will not be responsible for any consequences resulti"
        + "ng from the use of this software.\n"
        + "\n"
        + "Any person who transfers this source code or any derivative work must include th"
        + "e IBM copyright notice, this paragraph, and the preceding two paragraphs in the "
        + "transferred software.\n"
        + "\n"
        + "COPYRIGHT   I B M   CORPORATION 2002\n"
        + "LICENSED MATERIAL  -  PROGRAM PROPERTY OF I B M\n"
; // the license text
    }
 
    
}
