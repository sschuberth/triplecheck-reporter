package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:16Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Naumen.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Naumen extends License{
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
        return "Naumen"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Naumen Public License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "NAUMEN Public License\n"
        + "This software is Copyright (c) NAUMEN (tm) and Contributors.\n"
        + "All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or\n"
        + "without modification, are permitted provided that the following\n"
        + "conditions are met:\n"
        + "\n"
        + "1. Redistributions in source code must retain the above\n"
        + "copyright notice, this list of conditions, and the following\n"
        + "disclaimer.\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce the above\n"
        + "copyright notice, this list of conditions, and the following\n"
        + "disclaimer in the documentation and/or other materials\n"
        + "provided with the distribution.\n"
        + "\n"
        + "3. The name NAUMEN (tm) must not be used to\n"
        + "endorse or promote products derived from this software without prior\n"
        + "written permission from NAUMEN.\n"
        + "\n"
        + "4. The right to distribute this software or to use it for any\n"
        + "purpose does not give you the right to use Servicemarks (sm)\n"
        + "or Trademarks (tm) of NAUMEN.\n"
        + "\n"
        + "5. If any files originating from NAUMEN or Contributors are modified, you must\n"
        + "cause the modified files to carry prominent notices stating\n"
        + "that you changed the files and the date of any change.\n"
        + "\n"
        + "Disclaimer:\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY NAUMEN \"AS IS\" AND ANY EXPRESSED\n"
        + "OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE\n"
        + "IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A\n"
        + "PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL NAUMEN\n"
        + "OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,\n"
        + "INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES\n"
        + "(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE\n"
        + "GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS\n"
        + "INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,\n"
        + "WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING\n"
        + "NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF\n"
        + "THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH\n"
        + "DAMAGE.\n"
        + "\n"
        + "This software consists of contributions made by NAUMEN\n"
        + "and Contributors. Specific attributions are listed in the\n"
        + "accompanying credits file.\n"
; // the license text
    }
 
    
}
