package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:56Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: X11.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class X11 extends License{
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
        return "X11"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "X11 License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "X11 License\n"
        + "\n"
        + "Copyright (C) 1996 X Consortium\n"
        + "\n"
        + "Permission is hereby granted, free of charge, to any person obtaining a copy of "
        + "this software and associated documentation files (the \"Software\"), to deal in th"
        + "e Software without restriction, including without limitation the rights to use, "
        + "copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the "
        + "Software, and to permit persons to whom the Software is furnished to do so, subj"
        + "ect to the following conditions:\n"
        + "\n"
        + "The above copyright notice and this permission notice shall be included in all c"
        + "opies or substantial portions of the Software.\n"
        + "\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLI"
        + "ED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR "
        + "A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE X CONSORTIUM BE "
        + "LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRA"
        + "CT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE O"
        + "R THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n"
        + "\n"
        + "Except as contained in this notice, the name of the X Consortium shall not be us"
        + "ed in advertising or otherwise to promote the sale, use or other dealings in thi"
        + "s Software without prior written authorization from the X Consortium.\n"
        + "\n"
        + "X Window System is a trademark of X Consortium, Inc.\n"
; // the license text
    }
 
    
}
