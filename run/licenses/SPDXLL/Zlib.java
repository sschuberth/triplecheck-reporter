package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:58Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Zlib.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Zlib extends License{
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
        return "Zlib"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "zlib License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "zlib License\n"
        + "\n"
        + "\n"
        + "  This software is provided 'as-is', without any express or implied\n"
        + "  warranty.  In no event will the authors be held liable for any damages\n"
        + "  arising from the use of this software.\n"
        + "\n"
        + "  Permission is granted to anyone to use this software for any purpose,\n"
        + "  including commercial applications, and to alter it and redistribute it\n"
        + "  freely, subject to the following restrictions:\n"
        + "\n"
        + "  1. The origin of this software must not be misrepresented; you must not\n"
        + "     claim that you wrote the original software. If you use this software\n"
        + "     in a product, an acknowledgment in the product documentation would be\n"
        + "     appreciated but is not required.\n"
        + "  2. Altered source versions must be plainly marked as such, and must not be\n"
        + "     misrepresented as being the original software.\n"
        + "  3. This notice may not be removed or altered from any source distribution.\n"
; // the license text
    }
 
    
}
