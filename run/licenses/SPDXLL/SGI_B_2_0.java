package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:46Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SGI_B_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class SGI_B_2_0 extends License{
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
        return "SGI-B-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "SGI Free Software License B v2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "SGI FREE SOFTWARE LICENSE B \n"
        + "(Version 2.0, Sept. 18, 2008) \n"
        + "\n"
        + "Copyright (C) [dates of first publication] Silicon Graphics, Inc. All Rights Res"
        + "erved.\n"
        + "\n"
        + "Permission is hereby granted, free of charge, to any person obtaining a copy of "
        + "this software and associated documentation files (the \"Software\"), to deal in th"
        + "e Software without restriction, including without limitation the rights to use, "
        + "copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the "
        + "Software, and to permit persons to whom the Software is furnished to do so, subj"
        + "ect to the following conditions:\n"
        + "\n"
        + "The above copyright notice including the dates of first publication and either t"
        + "his permission notice or a reference to  HYPERLINK \"http://oss.sgi.com/projects/"
        + "FreeB/\"http://oss.sgi.com/projects/FreeB/ shall be included in all copies or sub"
        + "stantial portions of the Software. \n"
        + "\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLI"
        + "ED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR "
        + "A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL SILICON GRAPHICS, IN"
        + "C. BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF "
        + "CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFT"
        + "WARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n"
        + "\n"
        + "Except as contained in this notice, the name of Silicon Graphics, Inc. shall not"
        + " be used in advertising or otherwise to promote the sale, use or other dealings "
        + "in this Software without prior written authorization from Silicon Graphics, Inc.\n"
; // the license text
    }
 
    
}
