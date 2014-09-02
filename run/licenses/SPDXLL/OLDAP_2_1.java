package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:28Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OLDAP_2_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OLDAP_2_1 extends License{
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
        return "OLDAP-2.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Open LDAP Public License v2.1"; // full text title
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
        + "\n"
        + "  Version 2.1, 29 February 2000\n"
        + "  Copyright 1999-2000, The OpenLDAP Foundation, Redwood City, California, USA.\n"
        + "  All Rights Reserved.\n"
        + "\n"
        + "Redistribution and use of this software and associated documentation\n"
        + "(\"Software\"), with or without modification, are permitted provided\n"
        + "that the following conditions are met:\n"
        + "\n"
        + "1. Redistributions of source code must retain copyright\n"
        + "statements and notices.  Redistributions must also contain a\n"
        + "copy of this document.\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce the\n"
        + "above copyright notice, this list of conditions and the\n"
        + "following disclaimer in the documentation and/or other\n"
        + "materials provided with the distribution.\n"
        + "\n"
        + "3. The name \"OpenLDAP\" must not be used to endorse or promote\n"
        + "products derived from this Software without prior written\n"
        + "permission of the OpenLDAP Foundation.  For written permission,\n"
        + "please contact foundation@openldap.org.\n"
        + "\n"
        + "4. Products derived from this Software may not be called \"OpenLDAP\"\n"
        + "nor may \"OpenLDAP\" appear in their names without prior written\n"
        + "permission of the OpenLDAP Foundation.  OpenLDAP is a trademark\n"
        + "of the OpenLDAP Foundation.\n"
        + "\n"
        + "5. Due credit should be given to the OpenLDAP Project\n"
        + "(http://www.openldap.org/).\n"
        + "\n"
        + "6. The OpenLDAP Foundation may revise this license from time to\n"
        + "time.  Each revision is distinguished by a version number.  You\n"
        + "may use the Software under terms of this license revision or under\n"
        + "the terms of any subsequent license revision.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE OPENLDAP FOUNDATION AND CONTRIBUTORS\n"
        + "``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT\n"
        + "NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND\n"
        + "FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL\n"
        + "THE OPENLDAP FOUNDATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,\n"
        + "INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES\n"
        + "(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR\n"
        + "SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)\n"
        + "HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,\n"
        + "STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)\n"
        + "ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED\n"
        + "OF THE POSSIBILITY OF SUCH DAMAGE.\n"
; // the license text
    }
 
    
}
