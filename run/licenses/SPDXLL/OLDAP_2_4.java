package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:45:03Z
 * LicenseName: Apache-2.0
 * FileName: OLDAP_2_4.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class OLDAP_2_4 extends License{
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
        return "OLDAP-2.4"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Open LDAP Public License v2.4"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The OpenLDAP Public License\n"
        + "  Version 2.4, 8 December 2000\n"
        + "\n"
        + "Redistribution and use of this software and associated documentation\n"
        + "(\"Software\"), with or without modification, are permitted provided\n"
        + "that the following conditions are met:\n"
        + "\n"
        + "1. Redistributions of source code must retain copyright statements\n"
        + "and notices.\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce applicable copyright\n"
        + "statements and notices, this list of conditions, and the following\n"
        + "disclaimer in the documentation and/or other materials provided\n"
        + "with the distribution.\n"
        + "\n"
        + "3. Redistributions must contain a verbatim copy of this document.\n"
        + "\n"
        + "4. The names and trademarks of the authors and copyright holders\n"
        + "must not be used in advertising or otherwise to promote the sale,\n"
        + "use or other dealing in this Software without specific, written\n"
        + "prior permission.\n"
        + "\n"
        + "5. Due credit should be given to the OpenLDAP Project.\n"
        + "\n"
        + "6. The OpenLDAP Foundation may revise this license from time to\n"
        + "time.  Each revision is distinguished by a version number.  You\n"
        + "may use the Software under terms of this license revision or under\n"
        + "the terms of any subsequent revision of the license.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE OPENLDAP FOUNDATION AND CONTRIBUTORS\n"
        + "``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT\n"
        + "NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND\n"
        + "FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL\n"
        + "THE OPENLDAP FOUNDATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY\n"
        + "DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL\n"
        + "DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE\n"
        + "GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS\n"
        + "INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER\n"
        + "IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR\n"
        + "OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN\n"
        + "IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n"
        + "\n"
        + "OpenLDAP is a trademark of the OpenLDAP Foundation.\n"
        + "\n"
        + "Copyright 1999-2000 The OpenLDAP Foundation, Redwood City,\n"
        + "California, USA.  All Rights Reserved.  Permission to copy and\n"
        + "distributed verbatim copies of this document is granted.\n"
; // the license text
    }
 
    
}
