package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:45Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL_3_0_with_autoconf_exception.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class GPL_3_0_with_autoconf_exception extends License{
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
        return "GPL-3.0-with-autoconf-exception"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU General Public License v3.0 w/Autoconf exception"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "insert GPL v3 text here\n"
        + "\n"
        + "AUTOCONF CONFIGURE SCRIPT EXCEPTION\n"
        + "\n"
        + "Version 3.0, 18 August 2009\n"
        + "\n"
        + "Copyright © 2009 Free Software Foundation, Inc. <http://fsf.org/>\n"
        + "\n"
        + "Everyone is permitted to copy and distribute verbatim copies of this license doc"
        + "ument, but changing it is not allowed.\n"
        + "\n"
        + "This Exception is an additional permission under section 7 of the GNU General Pu"
        + "blic License, version 3 (\"GPLv3\"). It applies to a given file that bears a notic"
        + "e placed by the copyright holder of the file stating that the file is governed b"
        + "y GPLv3 along with this Exception.\n"
        + "\n"
        + "The purpose of this Exception is to allow distribution of Autoconf's typical out"
        + "put under terms of the recipient's choice (including proprietary).\n"
        + "\n"
        + "0. Definitions.\n"
        + "\"Covered Code\" is the source or object code of a version of Autoconf that is a c"
        + "overed work under this License.\n"
        + "\n"
        + "\"Normally Copied Code\" for a version of Autoconf means all parts of its Covered "
        + "Code which that version can copy from its code (i.e., not from its input file) i"
        + "nto its minimally verbose, non-debugging and non-tracing output.\n"
        + "\n"
        + "\"Ineligible Code\" is Covered Code that is not Normally Copied Code.\n"
        + "\n"
        + "1. Grant of Additional Permission.\n"
        + "You have permission to propagate output of Autoconf, even if such propagation wo"
        + "uld otherwise violate the terms of GPLv3. However, if by modifying Autoconf you "
        + "cause any Ineligible Code of the version you received to become Normally Copied "
        + "Code of your modified version, then you void this Exception for the resulting co"
        + "vered work. If you convey that resulting covered work, you must remove this Exce"
        + "ption in accordance with the second paragraph of Section 7 of GPLv3.\n"
        + "\n"
        + "2. No Weakening of Autoconf Copyleft.\n"
        + "The availability of this Exception does not imply any general presumption that t"
        + "hird-party software is unaffected by the copyleft requirements of the license of"
        + " Autoconf.\n"
; // the license text
    }
 
    
}
