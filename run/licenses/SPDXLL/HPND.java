package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:52Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: HPND.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class HPND extends License{
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
        return "HPND"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Historic Permission Notice and Disclaimer"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Historical Permission Notice and Disclaimer\n"
        + "\n"
        + "<copyright notice>\n"
        + "\n"
        + "Permission to use, copy, modify and distribute this software and its documentati"
        + "on for any purpose and without fee is hereby granted, provided that the above co"
        + "pyright notice appear in all copies[,] [and] that both [that] [the] copyright no"
        + "tice and this permission notice appear in supporting documentation[, and that th"
        + "e name [of] <copyright holder> [or <related entities>] not be used in advertisin"
        + "g or publicity pertaining to distribution of the software without specific, writ"
        + "ten prior permission]. [<copyright holder> makes no representations about the su"
        + "itability of this software for any purpose. It is provided \"as is\" without expre"
        + "ss or implied warranty.]\n"
        + "\n"
        + "[<copyright holder> DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE, INCLU"
        + "DING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS[,][.] IN NO EVENT SHA"
        + "LL <copyright holder> BE LIABLE FOR ANY SPECIAL, INDIRECT OR CONSEQUENTIAL DAMAG"
        + "ES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHE"
        + "R IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF "
        + "OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.]\n"
; // the license text
    }
 
    
}
