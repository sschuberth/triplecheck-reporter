package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:37Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: PostgreSQL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class PostgreSQL extends License{
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
        return "PostgreSQL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "PostgreSQL License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "PostgreSQL Database Management System\n"
        + "(formerly known as Postgres, then as Postgres95)\n"
        + "\n"
        + "Portions Copyright (c) 1996-2010, The PostgreSQL Global Development Group\n"
        + "\n"
        + "Portions Copyright (c) 1994, The Regents of the University of California\n"
        + "\n"
        + "Permission to use, copy, modify, and distribute this software and its documentat"
        + "ion for any purpose, without fee, and without a written agreement is hereby gran"
        + "ted, provided that the above copyright notice and this paragraph and the followi"
        + "ng two paragraphs appear in all copies.\n"
        + "\n"
        + "IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT"
        + ", INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFIT"
        + "S, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UN"
        + "IVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n"
        + "\n"
        + "THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, B"
        + "UT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A P"
        + "ARTICULAR PURPOSE. THE SOFTWARE PROVIDED HEREUNDER IS ON AN \"AS IS\" BASIS, AND T"
        + "HE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT, "
        + "UPDATES, ENHANCEMENTS, OR MODIFICATIONS.\n"
; // the license text
    }
 
    
}
