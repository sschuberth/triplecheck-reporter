package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:14Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: WTFPL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class WTFPL extends License{
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
        return "WTFPL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Do What The F*ck You Want To Public License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE\n"
        + "                    Version 2, December 2004\n"
        + "\n"
        + " Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>\n"
        + "\n"
        + " Everyone is permitted to copy and distribute verbatim or modified\n"
        + " copies of this license document, and changing it is allowed as long\n"
        + " as the name is changed.\n"
        + "\n"
        + "            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE\n"
        + "   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION\n"
        + "\n"
        + "  0. You just DO WHAT THE FUCK YOU WANT TO.\n"
; // the license text
    }
 
    
}
