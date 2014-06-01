package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:46Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL_3_0_with_GCC_exception.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class GPL_3_0_with_GCC_exception extends License{
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
        return "GPL-3.0-with-GCC-exception"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU General Public License v3.0 w/GCC Runtime Library exception"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "﻿insert GPL v3 text here\n"
        + "\n"
        + "GCC RUNTIME LIBRARY EXCEPTION\n"
        + "Version 3.1, 31 March 2009\n"
        + "\n"
        + "General information:\n"
        + "http://www.gnu.org/licenses/gcc-exception.html\n"
        + "Copyright (C) 2009 Free Software Foundation, Inc. <http://fsf.org/>\n"
        + "\n"
        + "Everyone is permitted to copy and distribute verbatim copies of this license doc"
        + "ument, but changing it is not allowed.\n"
        + "This GCC Runtime Library Exception (\"Exception\") is an additional permission und"
        + "er section 7 of the GNU General Public License, version 3 (\"GPLv3\"). It applies "
        + "to a given file (the \"Runtime Library\") that bears a notice placed by the copyri"
        + "ght holder of the file stating that the file is governed by GPLv3 along with thi"
        + "s Exception.\n"
        + "\n"
        + "When you use GCC to compile a program, GCC may combine portions of certain GCC h"
        + "eader files and runtime libraries with the compiled program. The purpose of this"
        + " Exception is to allow compilation of non-GPL (including proprietary) programs t"
        + "o use, in this way, the header files and runtime libraries covered by this Excep"
        + "tion.\n"
        + "\n"
        + "0. Definitions.\n"
        + "A file is an \"Independent Module\" if it either requires the Runtime Library for "
        + "execution after a Compilation Process, or makes use of an interface provided by "
        + "the Runtime Library, but is not otherwise based on the Runtime Library.\n"
        + "\"GCC\" means a version of the GNU Compiler Collection, with or without modificati"
        + "ons, governed by version 3 (or a specified later version) of the GNU General Pub"
        + "lic License (GPL) with the option of using any subsequent versions published by "
        + "the FSF.\n"
        + "\"GPL-compatible Software\" is software whose conditions of propagation, modificat"
        + "ion and use would permit combination with GCC in accord with the license of GCC.\n"
        + "\n"
        + "\"Target Code\" refers to output from any compiler for a real or virtual target pr"
        + "ocessor architecture, in executable form or suitable for input to an assembler, "
        + "loader, linker and/or execution phase. Notwithstanding that, Target Code does no"
        + "t include data in any format that is used as a compiler intermediate representat"
        + "ion, or used for producing a compiler intermediate representation.\n"
        + "The \"Compilation Process\" transforms code entirely represented in non-intermedia"
        + "te languages designed for human-written code, and/or in Java Virtual Machine byt"
        + "e code, into Target Code. Thus, for example, use of source code generators and p"
        + "reprocessors need not be considered part of the Compilation Process, since the C"
        + "ompilation Process can be understood as starting with the output of the generato"
        + "rs or preprocessors.\n"
        + "\n"
        + "A Compilation Process is \"Eligible\" if it is done using GCC, alone or with other"
        + " GPL-compatible software, or if it is done without using any work based on GCC. "
        + "For example, using non-GPL-compatible Software to optimize any GCC intermediate "
        + "representations would not qualify as an Eligible Compilation Process.\n"
        + "\n"
        + "1. Grant of Additional Permission.\n"
        + "You have permission to propagate a work of Target Code formed by combining the R"
        + "untime Library with Independent Modules, even if such propagation would otherwis"
        + "e violate the terms of GPLv3, provided that all Target Code was generated by Eli"
        + "gible Compilation Processes. You may then convey such a combination under terms "
        + "of your choice, consistent with the licensing of the Independent Modules.\n"
        + "\n"
        + "2. No Weakening of GCC Copyleft.\n"
        + "The availability of this Exception does not imply any general presumption that t"
        + "hird-party software is unaffected by the copyleft requirements of the license of"
        + " GCC.\n"
; // the license text
    }
 
    
}
