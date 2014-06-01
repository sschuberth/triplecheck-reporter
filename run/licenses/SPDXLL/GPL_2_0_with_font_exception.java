package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:37Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL_2_0_with_font_exception.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class GPL_2_0_with_font_exception extends License{
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
        return "GPL-2.0-with-font-exception"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU General Public License v2.0 w/Font exception"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "﻿insert GPL v2 text here\n"
        + "\n"
        + "Font Exception\n"
        + "\n"
        + "As a special exception, if you create a document which uses this font, and embed"
        + " this font or unaltered portions of this font into the document, this font does "
        + "not by itself cause the resulting document to be covered by the GNU General Publ"
        + "ic License. This exception does not however invalidate any other reasons why the"
        + " document might be covered by the GNU General Public License. If you modify this"
        + " font, you may extend this exception to your version of the font, but you are no"
        + "t obligated to do so. If you do not wish to do so, delete this exception stateme"
        + "nt from your version.\n"
; // the license text
    }
 
    
}
