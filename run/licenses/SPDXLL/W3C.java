package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:54Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: W3C.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class W3C extends License{
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
        return "W3C"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "W3C Software Notice and License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "W3C SOFTWARE NOTICE AND LICENSE\n"
        + "\n"
        + "This work (and included software, documentation such as READMEs, or other relate"
        + "d items) is being provided by the copyright holders under the following license.\n"
        + "\n"
        + "License\n"
        + "\n"
        + "By obtaining, using and/or copying this work, you (the licensee) agree that you "
        + "have read, understood, and will comply with the following terms and conditions.\n"
        + "\n"
        + "Permission to copy, modify, and distribute this software and its documentation, "
        + "with or without modification, for any purpose and without fee or royalty is here"
        + "by granted, provided that you include the following on ALL copies of the softwar"
        + "e and documentation or portions thereof, including modifications:\n"
        + "The full text of this NOTICE in a location viewable to users of the redistribute"
        + "d or derivative work.\n"
        + "Any pre-existing intellectual property disclaimers, notices, or terms and condit"
        + "ions. If none exist, the W3C Software Short Notice should be included (hypertext"
        + " is preferred, text is permitted) within the body of any redistributed or deriva"
        + "tive code.\n"
        + "Notice of any changes or modifications to the files, including the date changes "
        + "were made. (We recommend you provide URIs to the location from which the code is"
        + " derived.)\n"
        + "\n"
        + "Disclaimers\n"
        + "\n"
        + "THIS SOFTWARE AND DOCUMENTATION IS PROVIDED \"AS IS,\" AND COPYRIGHT HOLDERS MAKE "
        + "NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED "
        + "TO, WARRANTIES OF MERCHANTABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT "
        + "THE USE OF THE SOFTWARE OR DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY PATEN"
        + "TS, COPYRIGHTS, TRADEMARKS OR OTHER RIGHTS.\n"
        + "\n"
        + "COPYRIGHT HOLDERS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, SPECIAL OR CONSEQ"
        + "UENTIAL DAMAGES ARISING OUT OF ANY USE OF THE SOFTWARE OR DOCUMENTATION.\n"
        + "\n"
        + "The name and trademarks of copyright holders may NOT be used in advertising or p"
        + "ublicity pertaining to the software without specific, written prior permission. "
        + "Title to copyright in this software and any associated documentation will at all"
        + " times remain with copyright holders.\n"
        + "\n"
        + "Notes\n"
        + "This version: http://www.w3.org/Consortium/Legal/2002/copyright-software-2002123"
        + "1\n"
        + "\n"
        + "This formulation of W3C's notice and license became active on December 31 2002. "
        + "This version removes the copyright ownership notice such that this license can b"
        + "e used with materials other than those owned by the W3C, reflects that ERCIM is "
        + "now a host of the W3C, includes references to this specific dated version of the"
        + " license, and removes the ambiguous grant of \"use\". Otherwise, this version is t"
        + "he same as the previous version and is written so as to preserve the Free Softwa"
        + "re Foundation's assessment of GPL compatibility and OSI's certification under th"
        + "e Open Source Definition.\n"
; // the license text
    }
 
    
}
