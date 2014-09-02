package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:36Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: BSD_2_Clause_FreeBSD.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class BSD_2_Clause_FreeBSD extends License{
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
        return "BSD-2-Clause-FreeBSD"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "BSD 2-clause FreeBSD License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The FreeBSD Copyright\n"
        + "\n"
        + "Copyright 1992-2012 The FreeBSD Project. All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without modification,"
        + " are permitted provided that the following conditions are met:\n"
        + "\n"
        + "1. Redistributions of source code must retain the above copyright notice, this l"
        + "ist of conditions and the following disclaimer.\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce the above copyright notice, thi"
        + "s list of conditions and the following disclaimer in the documentation and/or ot"
        + "her materials provided with the distribution.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE FREEBSD PROJECT ``AS IS'' AND ANY EXPRESS OR IM"
        + "PLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCH"
        + "ANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHAL"
        + "L THE FREEBSD PROJECT OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDE"
        + "NTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED T"
        + "O, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; O"
        + "R BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER "
        + "IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISI"
        + "NG IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILIT"
        + "Y OF SUCH DAMAGE.\n"
        + "\n"
        + "The views and conclusions contained in the software and documentation are those "
        + "of the authors and should not be interpreted as representing official policies, "
        + "either expressed or implied, of the FreeBSD Project.\n"
; // the license text
    }
 
    
}
