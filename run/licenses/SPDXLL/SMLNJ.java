package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:48Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SMLNJ.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class SMLNJ extends License{
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
        return "SMLNJ"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Standard ML of New Jersey License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "STANDARD ML OF NEW JERSEY COPYRIGHT NOTICE, LICENSE AND DISCLAIMER.\n"
        + "\n"
        + "Copyright (c) 2001-2011 by The Fellowship of SML/NJ Copyright (c) 1989-2001 by L"
        + "ucent Technologies\n"
        + "\n"
        + "Permission to use, copy, modify, and distribute this software and its documentat"
        + "ion for any purpose and without fee is hereby granted, provided that the above c"
        + "opyright notice appear in all copies and that both the copyright notice and this"
        + " permission notice and warranty disclaimer appear in supporting documentation, a"
        + "nd that the name of Lucent Technologies, Bell Labs or any Lucent entity not be u"
        + "sed in advertising or publicity pertaining to distribution of the software witho"
        + "ut specific, written prior permission.\n"
        + "\n"
        + "Lucent disclaims all warranties with regard to this software, including all impl"
        + "ied warranties of merchantability and fitness. In no event shall Lucent be liabl"
        + "e for any special, indirect or consequential damages or any damages whatsoever r"
        + "esulting from loss of use, data or profits, whether in an action of contract, ne"
        + "gligence or other tortious action, arising out of or in connection with the use "
        + "or performance of this software. \n"
; // the license text
    }
 
    
}
