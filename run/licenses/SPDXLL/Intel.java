package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:54Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Intel.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Intel extends License{
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
        return "Intel"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Intel Open Source License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Intel Open Source License\n"
        + "\n"
        + "\n"
        + "Copyright (c) 1996-2000 Intel Corporation All rights reserved. \n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without modification,"
        + " are permitted provided that the following conditions are met:\n"
        + "•Redistributions of source code must retain the above copyright notice, this l"
        + "ist of conditions and the following disclaimer.\n"
        + "•Redistributions in binary form must reproduce the above copyright notice, thi"
        + "s list of conditions and the following disclaimer in the documentation and/or ot"
        + "her materials provided with the distribution.\n"
        + "•Neither the name of the Intel Corporation nor the names of its contributors m"
        + "ay be used to endorse or promote products derived from this software without spe"
        + "cific prior written permission.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND "
        + "ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WA"
        + "RRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED."
        + " IN NO EVENT SHALL THE INTEL OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,"
        + " INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LI"
        + "MITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PRO"
        + "FITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, W"
        + "HETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE"
        + ") ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POS"
        + "SIBILITY OF SUCH DAMAGE. EXPORT LAWS: THIS LICENSE ADDS NO RESTRICTIONS TO THE E"
        + "XPORT LAWS OF YOUR JURISDICTION. It is licensee's responsibility to comply with "
        + "any export regulations applicable in licensee's jurisdiction. Under CURRENT (May"
        + " 2000) U.S. export regulations this software is eligible for export from the U.S"
        + ". and can be downloaded by or otherwise exported or reexported worldwide EXCEPT "
        + "to U.S. embargoed destinations which include Cuba, Iraq, Libya, North Korea, Ira"
        + "n, Syria, Sudan, Afghanistan and any other country to which the U.S. has embargo"
        + "ed goods and services.\n"
; // the license text
    }
 
    
}
