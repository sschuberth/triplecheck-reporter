package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:39Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: BSD_4_Clause_UC.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class BSD_4_Clause_UC extends License{
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
        return "BSD-4-Clause-UC"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "BSD-4-Clause (University of California-Specific)"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "BSD-4-Clause (University of California-Specific)Copyright [various years] The "
        + "Regents of the University of California. All rights reserved. Redistribution a"
        + "nd use in source and binary forms, with or without modification, are permitted p"
        + "rovided that the following conditions are met: 1. Redistributions of source co"
        + "de must retain the above copyright notice, this list of conditions and the follo"
        + "wing disclaimer. 2. Redistributions in binary form must reproduce the above co"
        + "pyright notice, this list of conditions and the following disclaimer in the docu"
        + "mentation and/or other materials provided with the distribution. 3. All advert"
        + "ising materials mentioning features or use of this software must display the fol"
        + "lowing acknowledgement: This product includes software developed by the Universi"
        + "ty of California, Berkeley and its contributors.4. Neither the name of the Uni"
        + "versity nor the names of its contributors may be used to endorse or promote prod"
        + "ucts derived from this software without specific prior written permission. THI"
        + "S SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS"
        + " OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF"
        + " MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVEN"
        + "T SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENT"
        + "AL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,"
        + " PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR "
        + "BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN"
        + " CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING"
        + " IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY "
        + "OF SUCH DAMAGE.\n"
; // the license text
    }
 
    
}
