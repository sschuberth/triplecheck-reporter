package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:44Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Ruby.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Ruby extends License{
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
        return "Ruby"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Ruby License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Ruby is copyrighted free software by Yukihiro Matsumoto <matz@netlab.co.jp>. \n"
        + "You can redistribute it and/or modify it under either the terms of the GPL  (see"
        + " COPYING.txt file), or the conditions below: \n"
        + "\n"
        + "1. You may make and give away verbatim copies of the source form of the  softwar"
        + "e without restriction, provided that you duplicate all of the original copyright"
        + " notices and associated disclaimers. \n"
        + "\n"
        + "2. You may modify your copy of the software in any way, provided that  you do at"
        + " least ONE of the following: \n"
        + "\n"
        + "a) place your modifications in the Public Domain or otherwise make them Freely A"
        + "vailable, such as by posting said modifications to Usenet or an equivalent mediu"
        + "m, or by allowing the author to include your modifications in the software. \n"
        + "\n"
        + "b) use the modified software only within your corporation or organization. \n"
        + "\n"
        + "c) rename any non-standard executables so the names do not conflict with standar"
        + "d executables, which must also be provided. \n"
        + "\n"
        + "d) make other distribution arrangements with the author. \n"
        + "\n"
        + "3. You may distribute the software in object code or executable form, provided t"
        + "hat you do at least ONE of the following: \n"
        + "\n"
        + "a) distribute the executables and library files of the software, together with i"
        + "nstructions (in the manual page or equivalent) on where to get the original dist"
        + "ribution. \n"
        + "\n"
        + "b) accompany the distribution with the machine-readable source of the software. \n"
        + "\n"
        + "c) give non-standard executables non-standard names, with instructions on where "
        + "to get the original software distribution. \n"
        + "\n"
        + "d) make other distribution arrangements with the author. \n"
        + "\n"
        + "4. You may modify and include the part of the software into any other software ("
        + "possibly commercial). But some files in the distribution are not written by the "
        + "author, so that they are not under this terms. \n"
        + "\n"
        + "They are gc.c(partly), utils.c(partly), regex.[ch], st.[ch] and some files under"
        + " the ./missing directory. See each file for the copying condition. \n"
        + "\n"
        + "5. The scripts and library files supplied as input to or produced as output from"
        + " the software do not automatically fall under the copyright of the software, but"
        + " belong to whomever generated them, and may be sold commercially, and may be agg"
        + "regated with this software. \n"
        + "\n"
        + "6. THIS SOFTWARE IS PROVIDED \"AS IS\" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTI"
        + "ES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND"
        + " FITNESS FOR A PARTICULAR PURPOSE.\n"
; // the license text
    }
 
    
}
