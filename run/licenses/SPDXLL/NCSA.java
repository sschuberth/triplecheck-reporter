package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:53Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: NCSA.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class NCSA extends License{
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
        return "NCSA"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "University of Illinois/NCSA Open Source License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "University of Illinois/NCSA Open Source License\n"
        + "Copyright (c) <Year> <Owner Organization Name> \n"
        + "All rights reserved.\n"
        + "\n"
        + "Developed by:   <Name of Development Group>\n"
        + "                       <Name of Institution>\n"
        + "                        <URL for Development Group/Institution>\n"
        + "Permission is hereby granted, free of charge, to any person obtaining a\n"
        + "copy of this software and associated documentation files (the\n"
        + "\"Software\"), to deal with the Software without restriction, including\n"
        + "without limitation the rights to use, copy, modify, merge, publish,\n"
        + "distribute, sublicense, and/or sell copies of the Software, and to\n"
        + "permit persons to whom the Software is furnished to do so, subject to\n"
        + "the following conditions:\n"
        + "\n"
        + "Redistributions of source code must retain the above copyright\n"
        + "notice, this list of conditions and the following disclaimers.\n"
        + "Redistributions in binary form must reproduce the above\n"
        + "copyright notice, this list of conditions and the following disclaimers\n"
        + "in the documentation and/or other materials provided with the\n"
        + "distribution.\n"
        + "Neither the names of <Name of Development Group, Name of\n"
        + "Institution>, nor the names of its contributors may be used to endorse\n"
        + "or promote products derived from this Software without specific prior\n"
        + "written permission.\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS\n"
        + "OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n"
        + "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.\n"
        + "IN NO EVENT SHALL THE CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR\n"
        + "ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,\n"
        + "TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE\n"
        + "SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE SOFTWARE.\n"
; // the license text
    }
 
    
}
