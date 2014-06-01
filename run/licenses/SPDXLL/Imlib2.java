package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:53Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Imlib2.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Imlib2 extends License{
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
        return "Imlib2"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Imlib2 License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Imlib2 License\n"
        + "\n"
        + "Permission is hereby granted, free of charge, to any person obtaining a copy\n"
        + "of this software and associated documentation files (the \"Software\"), to\n"
        + "deal in the Software without restriction, including without limitation the\n"
        + "rights to use, copy, modify, merge, publish, distribute, sublicense, and/or\n"
        + "sell copies of the Software, and to permit persons to whom the Software is\n"
        + "furnished to do so, subject to the following conditions:\n"
        + "\n"
        + "The above copyright notice and this permission notice shall be included in\n"
        + "all copies of the Software and its Copyright notices. In addition publicly\n"
        + "documented acknowledgment must be given that this software has been used if no\n"
        + "source code of this software is made available publicly. Making the source\n"
        + "available publicly means including the source for this software with the\n"
        + "distribution, or a method to get this software via some reasonable mechanism\n"
        + "(electronic transfer via a network or media) as well as making an offer to\n"
        + "supply the source on request. This Copyright notice serves as an offer to\n"
        + "supply the source on on request as well. Instead of this, supplying\n"
        + "acknowledgments of use of this software in either Copyright notices, Manuals,\n"
        + "Publicity and Marketing documents or any documentation provided with any\n"
        + "product containing this software. This License does not apply to any software\n"
        + "that links to the libraries provided by this software (statically or\n"
        + "dynamically), but only to the software provided.\n"
        + "\n"
        + "Please see the COPYING-PLAIN for a plain-english explanation of this notice\n"
        + "and its intent.\n"
        + "\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
        + "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
        + "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL\n"
        + "THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER\n"
        + "IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN\n"
        + "CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n"
; // the license text
    }
 
    
}
