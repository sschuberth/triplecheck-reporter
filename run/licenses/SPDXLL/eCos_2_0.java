package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:15Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: eCos_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class eCos_2_0 extends License{
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
        return "eCos-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "eCos license version 2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The eCos license version 2.0\n"
        + "\n"
        + "This file is part of eCos, the Embedded Configurable Operating System. Copyright"
        + " (C) 1998, 1999, 2000, 2001, 2002 Red Hat, Inc.\n"
        + "\n"
        + "eCos is free software; you can redistribute it and/or modify it under the terms "
        + "of the GNU General Public License as published by the Free Software Foundation; "
        + "either version 2 or (at your option) any later version.\n"
        + "\n"
        + "eCos is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY"
        + "; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICUL"
        + "AR PURPOSE. See the GNU General Public License for more details.\n"
        + "\n"
        + "You should have received a copy of the GNU General Public License along with eCo"
        + "s; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Fl"
        + "oor, Boston, MA 02110-1301 USA.\n"
        + "\n"
        + "As a special exception, if other files instantiate templates or use macros or in"
        + "line functions from this file, or you compile this file and link it with other w"
        + "orks to produce a work based on this file, this file does not by itself cause th"
        + "e resulting work to be covered by the GNU General Public License. However the so"
        + "urce code for this file must still be made available in accordance with section "
        + "(3) of the GNU General Public License.\n"
        + "\n"
        + "This exception does not invalidate any other reasons why a work based on this fi"
        + "le might be covered by the GNU General Public License.\n"
        + "\n"
        + "Alternative licenses for eCos may be arranged by contacting Red Hat, Inc. at htt"
        + "p://sources.redhat.com/ecos/ecos-license/ --------------------------------------"
        + "-----\n"
        + "\n"
        + "####ECOSGPLCOPYRIGHTEND####\n"
; // the license text
    }
 
    
}
