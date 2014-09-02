package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:30:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: ZPL_2_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class ZPL_2_1 extends License{
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
        return "ZPL-2.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Zope Public License 2.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Zope Public License (ZPL) Version 2.1\n"
        + "\n"
        + "A copyright notice accompanies this license document that identifies the copyrig"
        + "ht holders.\n"
        + "\n"
        + "This license has been certified as open source. It has also been designated as G"
        + "PL compatible by the Free Software Foundation (FSF).\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without modification,"
        + " are permitted provided that the following conditions are met:\n"
        + "\n"
        + "1.  Redistributions in source code must retain the accompanying copyright notice"
        + ", this list of conditions, and the following disclaimer.\n"
        + "\n"
        + "2.  Redistributions in binary form must reproduce the accompanying copyright not"
        + "ice, this list of conditions, and the following disclaimer in the documentation "
        + "and/or other materials provided with the distribution.\n"
        + "\n"
        + "3.  Names of the copyright holders must not be used to endorse or promote produc"
        + "ts derived from this software without prior written permission from the copyrigh"
        + "t holders.\n"
        + "\n"
        + "4.  The right to distribute this software or to use it for any purpose does not "
        + "give you the right to use Servicemarks (sm) or Trademarks (tm) of the copyright "
        + "holders. Use of them is covered by separate agreement with the copyright holders"
        + ".\n"
        + "\n"
        + "5.  If any files are modified, you must cause the modified files to carry promin"
        + "ent notices stating that you changed the files and the date of any change.\n"
        + "\n"
        + "Disclaimer\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS ``AS IS'' AND ANY EXPRESSED O"
        + "R IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF M"
        + "ERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT "
        + "SHALL THE COPYRIGHT HOLDERS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPEC"
        + "IAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCURE"
        + "MENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS"
        + " INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRAC"
        + "T, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY "
        + "WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH "
        + "DAMAGE.\n"
; // the license text
    }
 
    
}
