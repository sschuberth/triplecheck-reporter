package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:55Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: ISC.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class ISC extends License{
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
        return "ISC"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "ISC License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "ISC License:\n"
        + "\n"
        + "Copyright (c) 2004-2010 by Internet Systems Consortium, Inc. (\"ISC\")\n"
        + "Copyright (c) 1995-2003 by Internet Software Consortium\n"
        + "\n"
        + "Permission to use, copy, modify, and/or distribute this software for any purpose"
        + " with or without fee is hereby granted, provided that the above copyright notice"
        + " and this permission notice appear in all copies.\n"
        + "\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\" AND ISC DISCLAIMS ALL WARRANTIES WITH REGARD TO"
        + " THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. "
        + "IN NO EVENT SHALL ISC BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENT"
        + "IAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFIT"
        + "S, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISIN"
        + "G OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.\n"
; // the license text
    }
 
    
}
