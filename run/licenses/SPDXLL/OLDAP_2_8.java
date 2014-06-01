package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:35Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OLDAP_2_8.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OLDAP_2_8 extends License{
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
        return "OLDAP-2.8"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "OpenLDAP Public License v2.8"; // full text title
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
        + "  Version 2.8, 17 August 2003\n"
        + "\n"
        + "Redistribution and use of this software and associated documentation\n"
        + "(\"Software\"), with or without modification, are permitted provided\n"
        + "that the following conditions are met:\n"
        + "\n"
        + "1. Redistributions in source form must retain copyright statements\n"
        + "   and notices,\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce applicable copyright\n"
        + "   statements and notices, this list of conditions, and the following\n"
        + "   disclaimer in the documentation and/or other materials provided\n"
        + "   with the distribution, and\n"
        + "\n"
        + "3. Redistributions must contain a verbatim copy of this document.\n"
        + "\n"
        + "The OpenLDAP Foundation may revise this license from time to time.\n"
        + "Each revision is distinguished by a version number.  You may use\n"
        + "this Software under terms of this license revision or under the\n"
        + "terms of any subsequent revision of the license.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE OPENLDAP FOUNDATION AND ITS\n"
        + "CONTRIBUTORS ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,\n"
        + "INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY\n"
        + "AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT\n"
        + "SHALL THE OPENLDAP FOUNDATION, ITS CONTRIBUTORS, OR THE AUTHOR(S)\n"
        + "OR OWNER(S) OF THE SOFTWARE BE LIABLE FOR ANY DIRECT, INDIRECT,\n"
        + "INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,\n"
        + "BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;\n"
        + "LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER\n"
        + "CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT\n"
        + "LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN\n"
        + "ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE\n"
        + "POSSIBILITY OF SUCH DAMAGE.\n"
        + "\n"
        + "The names of the authors and copyright holders must not be used in\n"
        + "advertising or otherwise to promote the sale, use or other dealing\n"
        + "in this Software without specific, written prior permission.  Title\n"
        + "to copyright in this Software shall at all times remain with copyright\n"
        + "holders.\n"
        + "\n"
        + "OpenLDAP is a registered trademark of the OpenLDAP Foundation.\n"
        + "\n"
        + "Copyright 1999-2003 The OpenLDAP Foundation, Redwood City,\n"
        + "California, USA.  All Rights Reserved.  Permission to copy and\n"
        + "distribute verbatim copies of this document is granted.\n"
; // the license text
    }
 
    
}
