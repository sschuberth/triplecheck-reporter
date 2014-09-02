package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:39Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL_2_0_with_GCC_exception.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class GPL_2_0_with_GCC_exception extends License{
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
        return "GPL-2.0-with-GCC-exception"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU General Public License v2.0 w/GCC Runtime Library exception"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "insert GPL v2 text here\n"
        + "\n"
        + "GCC Linking Exception\n"
        + "In addition to the permissions in the GNU General Public License, the Free Softw"
        + "are Foundation gives you unlimited permission to link the compiled version of th"
        + "is file into combinations with other programs, and to distribute those combinati"
        + "ons without any restriction coming from the use of this file. (The General Publi"
        + "c License restrictions do apply in other respects; for example, they cover modif"
        + "ication of the file, and distribution when not linked into a combine executable."
        + ")\n"
; // the license text
    }
 
    
}
