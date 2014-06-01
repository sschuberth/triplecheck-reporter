package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:55Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: WXwindows.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class WXwindows extends License{
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
        return "WXwindows"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "wxWindows Library License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "                wxWindows Library Licence, Version 3.1\n"
        + "                ======================================\n"
        + "\n"
        + "  Copyright (C) 1998-2005 Julian Smart, Robert Roebling et al\n"
        + "\n"
        + "  Everyone is permitted to copy and distribute verbatim copies\n"
        + "  of this licence document, but changing it is not allowed.\n"
        + "\n"
        + "                       WXWINDOWS LIBRARY LICENCE\n"
        + "     TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION\n"
        + "  \n"
        + "  This library is free software; you can redistribute it and/or modify it\n"
        + "  under the terms of the GNU Library General Public Licence as published by\n"
        + "  the Free Software Foundation; either version 2 of the Licence, or (at\n"
        + "  your option) any later version.\n"
        + "  \n"
        + "  This library is distributed in the hope that it will be useful, but\n"
        + "  WITHOUT ANY WARRANTY; without even the implied warranty of\n"
        + "  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library\n"
        + "  General Public Licence for more details.\n"
        + "\n"
        + "  You should have received a copy of the GNU Library General Public Licence\n"
        + "  along with this software, usually in a file named COPYING.LIB.  If not,\n"
        + "  write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,\n"
        + "  Boston, MA 02111-1307 USA.\n"
        + "\n"
        + "  EXCEPTION NOTICE\n"
        + "\n"
        + "  1. As a special exception, the copyright holders of this library give\n"
        + "  permission for additional uses of the text contained in this release of\n"
        + "  the library as licenced under the wxWindows Library Licence, applying\n"
        + "  either version 3.1 of the Licence, or (at your option) any later version of\n"
        + "  the Licence as published by the copyright holders of version\n"
        + "  3.1 of the Licence document.\n"
        + "\n"
        + "  2. The exception is that you may use, copy, link, modify and distribute\n"
        + "  under your own terms, binary object code versions of works based\n"
        + "  on the Library.\n"
        + "\n"
        + "  3. If you copy code from files distributed under the terms of the GNU\n"
        + "  General Public Licence or the GNU Library General Public Licence into a\n"
        + "  copy of this library, as this licence permits, the exception does not\n"
        + "  apply to the code that you add in this way.  To avoid misleading anyone as\n"
        + "  to the status of such modified files, you must delete this exception\n"
        + "  notice from such code and/or adjust the licensing conditions notice\n"
        + "  accordingly.\n"
        + "\n"
        + "  4. If you write modifications of your own for this library, it is your\n"
        + "  choice whether to permit this exception to apply to your modifications. \n"
        + "  If you do not wish that, you must delete the exception notice from such\n"
        + "  code and/or adjust the licensing conditions notice accordingly.\n"
; // the license text
    }
 
    
}
