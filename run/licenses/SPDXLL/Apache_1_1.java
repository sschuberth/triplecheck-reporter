package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:27Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Apache_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Apache_1_1 extends License{
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
        return "Apache-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Apache License 1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Apache Software License, Version 1.1\n"
        + "\n"
        + "Copyright (c) 2000 The Apache Software Foundation.  All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without modification,"
        + " are permitted provided that the following conditions are met:\n"
        + "\n"
        + "1. Redistributions of source code must retain the above copyright notice, this l"
        + "ist of conditions and the following disclaimer.\n"
        + " \n"
        + "2. Redistributions in binary form must reproduce the above copyright notice, thi"
        + "s list of conditions and the following disclaimer in the documentation and/or ot"
        + "her materials provided with the distribution.\n"
        + " \n"
        + "3. The end-user documentation included with the redistribution, if any, must inc"
        + "lude the following acknowledgment:\n"
        + " \"This product includes software developed by the Apache Software Foundation (ht"
        + "tp://www.apache.org/).\"\n"
        + " Alternately, this acknowledgment may appear in the software itself, if and wher"
        + "ever such third-party acknowledgments normally appear.\n"
        + "  \n"
        + "4. The names \"Apache\" and \"Apache Software Foundation\" must not be used to endor"
        + "se or promote products derived from this software without prior written permissi"
        + "on. For written permission, please contact apache@apache.org.\n"
        + " \n"
        + "5. Products derived from this software may not be called \"Apache\", nor may \"Apac"
        + "he\" appear in their name, without prior written permission of the Apache Softwar"
        + "e Foundation.\n"
        + " \n"
        + "THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INC"
        + "LUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNES"
        + "S FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWAR"
        + "E FOUNDATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,"
        + " SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PR"
        + "OCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUS"
        + "INESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CO"
        + "NTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN"
        + " ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF "
        + "SUCH DAMAGE.\n"
        + " \n"
        + "This software consists of voluntary contributions made by many individuals on be"
        + "half of the Apache Software Foundation.  For more information on the Apache Soft"
        + "ware Foundation, please see http://www.apache.org/. Portions of this software ar"
        + "e based upon public domain software originally written at the National Center fo"
        + "r Supercomputing Applications, University of Illinois, Urbana-Champaign.\n"
; // the license text
    }
 
    
}
