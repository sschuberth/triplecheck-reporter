package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:37Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: BSD_2_Clause_NetBSD.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class BSD_2_Clause_NetBSD extends License{
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
        return "BSD-2-Clause-NetBSD"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "BSD 2-clause NetBSD License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "NetBSD License\n"
        + "\n"
        + "Copyright (c) 2008 The NetBSD Foundation, Inc.\n"
        + "All rights reserved.\n"
        + "  \n"
        + "This code is derived from software contributed to The NetBSD Foundation by \n"
        + "  \n"
        + "Redistribution and use in source and binary forms, with or without modification,"
        + " are permitted provided that the following conditions are met:\n"
        + "\n"
        + "1. Redistributions of source code must retain the above copyright notice, this l"
        + "ist of conditions and the following disclaimer.\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce the above copyright notice, thi"
        + "s list of conditions and the following disclaimer in the documentation and/or ot"
        + "her materials provided with the distribution.\n"
        + "  \n"
        + "THIS SOFTWARE IS PROVIDED BY THE NETBSD FOUNDATION, INC. AND CONTRIBUTORS ``AS I"
        + "S'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IM"
        + "PLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DIS"
        + "CLAIMED.  IN NO EVENT SHALL THE FOUNDATION OR CONTRIBUTORS BE LIABLE FOR ANY DIR"
        + "ECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDI"
        + "NG, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE"
        + ", DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY O"
        + "F LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENC"
        + "E OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVI"
        + "SED OF THE POSSIBILITY OF SUCH DAMAGE.\n"
        + " \n"
; // the license text
    }
 
    
}
