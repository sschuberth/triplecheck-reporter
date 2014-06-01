package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:16Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: ECL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class ECL_1_0 extends License{
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
        return "ECL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Educational Community License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Educational Community License\n"
        + "\n"
        + "This Educational Community License (the \"License\") applies\n"
        + "to any original work of authorship (the \"Original Work\") whose owner\n"
        + "(the \"Licensor\") has placed the following notice immediately following\n"
        + "the copyright notice for the Original Work:\n"
        + "\n"
        + "Copyright (c) <year> <copyright holders>\n"
        + "\n"
        + "Licensed under the Educational Community License version 1.0\n"
        + "\n"
        + "This Original Work, including software, source code, documents,\n"
        + "or other related items, is being provided by the copyright holder(s)\n"
        + "subject to the terms of the Educational Community License. By\n"
        + "obtaining, using and/or copying this Original Work, you agree that you\n"
        + "have read, understand, and will comply with the following terms and\n"
        + "conditions of the Educational Community License:\n"
        + "\n"
        + "Permission to use, copy, modify, merge, publish, distribute, and\n"
        + "sublicense this Original Work and its documentation, with or without\n"
        + "modification, for any purpose, and without fee or royalty to the\n"
        + "copyright holder(s) is hereby granted, provided that you include the\n"
        + "following on ALL copies of the Original Work or portions thereof,\n"
        + "including modifications or derivatives, that you make:\n"
        + "\n"
        + "\n"
        + "The full text of the Educational Community License in a location viewable to\n"
        + "users of the redistributed or derivative work.\n"
        + "\n"
        + "\n"
        + "Any pre-existing intellectual property disclaimers, notices, or terms and\n"
        + "conditions.\n"
        + "\n"
        + "\n"
        + "\n"
        + "Notice of any changes or modifications to the Original Work, including the\n"
        + "date the changes were made.\n"
        + "\n"
        + "\n"
        + "Any modifications of the Original Work must be distributed in such a manner as\n"
        + "to avoid any confusion with the Original Work of the copyright holders.\n"
        + "\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n"
        + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n"
        + "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.\n"
        + "IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY\n"
        + "CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,\n"
        + "TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE\n"
        + "SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n"
        + "\n"
        + "The name and trademarks of copyright holder(s) may NOT be used\n"
        + "in advertising or publicity pertaining to the Original or Derivative\n"
        + "Works without specific, written prior permission. Title to copyright in\n"
        + "the Original Work and any associated documentation will at all times\n"
        + "remain with the copyright holders.\n"
; // the license text
    }
 
    
}
