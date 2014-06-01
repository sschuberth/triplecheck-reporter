package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:36Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL_2_0_with_bison_exception.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class GPL_2_0_with_bison_exception extends License{
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
        return "GPL-2.0-with-bison-exception"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU General Public License v2.0 w/Bison exception"; // full text title
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
        + "Bison Exception\n"
        + "\n"
        + "As a special exception, you may create a larger work that contains part or all o"
        + "f the Bison parser skeleton and distribute that work under terms of your choice,"
        + " so long as that work isn't itself a parser generator using the skeleton or a mo"
        + "dified version thereof as a parser skeleton. Alternatively, if you modify or red"
        + "istribute the parser skeleton itself, you may (at your option) remove this speci"
        + "al exception, which will cause the skeleton and the resulting Bison output files"
        + " to be licensed under the GNU General Public License without this special except"
        + "ion.\n"
        + "\n"
        + "This special exception was added by the Free Software Foundation in version 2.2 "
        + "of Bison.\n"
; // the license text
    }
 
    
}
