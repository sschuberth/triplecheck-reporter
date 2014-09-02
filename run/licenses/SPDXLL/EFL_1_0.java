package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:18Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: EFL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class EFL_1_0 extends License{
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
        return "EFL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Eiffel Forum License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Eiffel Forum License, version 1\n"
        + "\n"
        + "Permission is hereby granted to use, copy, modify and/or distribute\n"
        + "this package, provided that:\n"
        + "\n"
        + "  - copyright notices are retained unchanged\n"
        + "\n"
        + "  - any distribution of this package, whether modified or not,\n"
        + "    includes this file\n"
        + "\n"
        + "Permission is hereby also granted to distribute binary programs which\n"
        + "depend on this package, provided that:\n"
        + "\n"
        + "  - if the binary program depends on a modified version of this\n"
        + "    package, you must publicly release the modified version of this\n"
        + "    package\n"
        + "\n"
        + "THIS PACKAGE IS PROVIDED \"AS IS\" AND WITHOUT WARRANTY. ANY EXPRESS OR\n"
        + "IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED\n"
        + "WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE\n"
        + "DISCLAIMED. IN NO EVENT SHALL THE AUTHORS BE LIABLE TO ANY PARTY FOR\n"
        + "ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL\n"
        + "DAMAGES ARISING IN ANY WAY OUT OF THE USE OF THIS PACKAGE.\n"
; // the license text
    }
 
    
}
