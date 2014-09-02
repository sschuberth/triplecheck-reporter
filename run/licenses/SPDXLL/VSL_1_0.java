package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:54Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: VSL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class VSL_1_0 extends License{
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
        return "VSL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Vovida Software License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Vovida Software License v. 1.0\n"
        + "\n"
        + "This license applies to all software incorporated in the \"Vovida\n"
        + "Open Communication Application Library\" except for those portions\n"
        + "incorporating third party software specifically identified as being\n"
        + "licensed under separate license.\n"
        + "\n"
        + "The Vovida Software License, Version 1.0\n"
        + "Copyright (c) 2000 Vovida Networks, Inc. All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without\n"
        + "modification, are permitted provided that the following conditions\n"
        + "are met:\n"
        + "\n"
        + "1. Redistributions of source code must retain the above copyright\n"
        + "notice, this list of conditions and the following disclaimer.\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce the above copyright\n"
        + "notice, this list of conditions and the following disclaimer in\n"
        + "the documentation and/or other materials provided with the\n"
        + "distribution.\n"
        + "\n"
        + "3. The names \"VOCAL\", \"Vovida Open Communication Application Library\",\n"
        + "and \"Vovida Open Communication Application Library (VOCAL)\" must\n"
        + "not be used to endorse or promote products derived from this\n"
        + "software without prior written permission. For written\n"
        + "permission, please contact vocal@vovida.org.\n"
        + "\n"
        + "4. Products derived from this software may not be called \"VOCAL\", nor\n"
        + "may \"VOCAL\" appear in their name, without prior written\n"
        + "permission.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED \"AS IS\" AND ANY EXPRESSED OR IMPLIED\n"
        + "WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES\n"
        + "OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE AND\n"
        + "NON-INFRINGEMENT ARE DISCLAIMED. IN NO EVENT SHALL VOVIDA\n"
        + "NETWORKS, INC. OR ITS CONTRIBUTORS BE LIABLE FOR ANY DAMAGES\n"
        + "IN EXCESS OF $1,000, NOR FOR ANY INDIRECT, INCIDENTAL, SPECIAL,\n"
        + "EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,\n"
        + "PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR\n"
        + "PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY\n"
        + "OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT\n"
        + "(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE\n"
        + "USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH\n"
        + "DAMAGE.\n"
; // the license text
    }
 
    
}
