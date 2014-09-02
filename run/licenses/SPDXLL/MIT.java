package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:08Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: MIT.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class MIT extends License{
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
        return "MIT"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "MIT License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "MIT License\n"
        + "\n"
        + "Copyright (c) <year> <copyright holders>\n"
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
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
        + "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
        + "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n"
        + "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"
        + "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
        + "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\n"
        + "THE SOFTWARE.\n"
; // the license text
    }
 
    
}
