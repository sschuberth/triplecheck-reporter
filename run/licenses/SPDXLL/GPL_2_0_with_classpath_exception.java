package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:36Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: GPL_2_0_with_classpath_exception.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class GPL_2_0_with_classpath_exception extends License{
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
        return "GPL-2.0-with-classpath-exception"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU General Public License v2.0 w/Classpath exception"; // full text title
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
        + "Class Path Exception\n"
        + "\n"
        + "Linking this library statically or dynamically with other modules is making a co"
        + "mbined work based on this library. Thus, the terms and conditions of the GNU Gen"
        + "eral Public License cover the whole combination.\n"
        + "\n"
        + "As a special exception, the copyright holders of this library give you permissio"
        + "n to link this library with independent modules to produce an executable, regard"
        + "less of the license terms of these independent modules, and to copy and distribu"
        + "te the resulting executable under terms of your choice, provided that you also m"
        + "eet, for each linked independent module, the terms and conditions of the license"
        + " of that module. An independent module is a module which is not derived from or "
        + "based on this library. If you modify this library, you may extend this exception"
        + " to your version of the library, but you are not obligated to do so. If you do n"
        + "ot wish to do so, delete this exception statement from your version.\n"
; // the license text
    }
 
    
}
