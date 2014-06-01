package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:55Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Xnet.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Xnet extends License{
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
        return "Xnet"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "X.Net License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The X.Net, Inc. License\n"
        + "\n"
        + "Copyright (c) 2000-2001 X.Net, Inc. Lafayette, California, USA\n"
        + "\n"
        + "Permission is hereby granted, free of charge, to any person obtaining a copy\n"
        + "of this software and associated documentation files (the \"Software\"), to deal\n"
        + "in the Software without restriction, including without limitation the rights\n"
        + "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
        + "copies of the Software, and to permit persons to whom the Software is\n"
        + "furnished to do so, subject to the following conditions:\n"
        + "\n"
        + "The above copyright notice and this permission notice shall be included in\n"
        + "all copies or substantial portions of the Software.\n"
        + "\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
        + "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
        + "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n"
        + "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"
        + "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
        + "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\n"
        + "THE SOFTWARE.\n"
        + "\n"
        + "This agreement shall be governed in all respects by the laws of the State of\n"
        + "California and by the laws of the United States of America.\n"
; // the license text
    }
 
    
}
