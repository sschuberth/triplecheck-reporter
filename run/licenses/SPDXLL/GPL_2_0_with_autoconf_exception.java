package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:35Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL_2_0_with_autoconf_exception.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class GPL_2_0_with_autoconf_exception extends License{
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
        return "GPL-2.0-with-autoconf-exception"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU General Public License v2.0 w/Autoconf exception"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "﻿insert GPL v2 license text here\n"
        + "\n"
        + "Autoconf Exception\n"
        + "\n"
        + "As a special exception, the Free Software Foundation gives unlimited permission "
        + "to copy, distribute and modify the configure scripts that are the output of Auto"
        + "conf. You need not follow the terms of the GNU General Public License when using"
        + " or distributing such scripts, even though portions of the text of Autoconf appe"
        + "ar in them. The GNU General Public License (GPL) does govern all other use of th"
        + "e material that constitutes the Autoconf program.\n"
        + "\n"
        + "Certain portions of the Autoconf source text are designed to be copied (in certa"
        + "in cases, depending on the input) into the output of Autoconf. We call these the"
        + " \"data\" portions. The rest of the Autoconf source text consists of comments plus"
        + " executable code that decides which of the data portions to output in any given "
        + "case. We call these comments and executable code the \"non-data\" portions. Autoco"
        + "nf never copies any of the non-data portions into its output.\n"
        + "\n"
        + "This special exception to the GPL applies to versions of Autoconf released by th"
        + "e Free Software Foundation. When you make and distribute a modified version of A"
        + "utoconf, you may extend this special exception to the GPL to apply to your modif"
        + "ied version as well, *unless* your modified version has the potential to copy in"
        + "to its output some of the text that was the non-data portion of the version that"
        + " you started with. (In other words, unless your change moves or copies text from"
        + " the non-data portions to the data portions.) If your modification has such pote"
        + "ntial, you must delete any notice of this special exception to the GPL from your"
        + " modified version.\n"
; // the license text
    }
 
    
}
