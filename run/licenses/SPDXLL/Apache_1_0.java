package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:26Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Apache_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Apache_1_0 extends License{
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
        return "Apache-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Apache License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Copyright (c) 1995-1999 The Apache Group.  All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without modification,"
        + " are permitted provided that the following conditions are met:\n"
        + " \n"
        + "1. Redistributions of source code must retain the above copyright notice, this l"
        + "ist of conditions and the following disclaimer. \n"
        + " \n"
        + "2. Redistributions in binary form must reproduce the above copyright notice, thi"
        + "s list of conditions and the following disclaimer in the documentation and/or ot"
        + "her materials provided with the distribution.\n"
        + "\n"
        + "3. All advertising materials mentioning features or use of this software must di"
        + "splay the following acknowledgment:\n"
        + "\"This product includes software developed by the Apache Group for use in the Apa"
        + "che HTTP server project (http://www.apache.org/).\"\n"
        + " \n"
        + "4. The names \"Apache Server\" and \"Apache Group\" must not be used to endorse or p"
        + "romote products derived from this software without prior written permission. For"
        + " written permission, please contact apache@apache.org.\n"
        + " \n"
        + "5. Products derived from this software may not be called \"Apache\" nor may \"Apach"
        + "e\" appear in their names without prior written permission of the Apache Group.\n"
        + "\n"
        + "6. Redistributions of any form whatsoever must retain the following acknowledgme"
        + "nt:\n"
        + "\"This product includes software developed by the Apache Group for use in the Apa"
        + "che HTTP server project (http://www.apache.org/).\"\n"
        + " \n"
        + "THIS SOFTWARE IS PROVIDED BY THE APACHE GROUP ``AS IS'' AND ANY EXPRESSED OR IMP"
        + "LIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHA"
        + "NTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHAL"
        + "L THE APACHE GROUP OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCID"
        + "ENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED "
        + "TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; "
        + "OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER"
        + " IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARIS"
        + "ING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILI"
        + "TY OF SUCH DAMAGE.\n"
        + "\n"
        + "This software consists of voluntary contributions made by many individuals on be"
        + "half of the Apache Group and was originally based on public domain software writ"
        + "ten at the National Center for Supercomputing Applications, University of Illino"
        + "is, Urbana-Champaign. For more information on the Apache Group and the Apache HT"
        + "TP server project, please see http://www.apache.org/.\n"
        + " \n"
; // the license text
    }
 
    
}
