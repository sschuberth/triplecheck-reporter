package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:36Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: PHP_3_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class PHP_3_0 extends License{
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
        return "PHP-3.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "PHP License v3.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "-------------------------------------------------------------------- \n"
        + "                  The PHP License, version 3.0\n"
        + "Copyright (c) 1999 - 2006 The PHP Group. All rights reserved.\n"
        + "-------------------------------------------------------------------- \n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without\n"
        + "modification, is permitted provided that the following conditions\n"
        + "are met:\n"
        + "\n"
        + "  1. Redistributions of source code must retain the above copyright\n"
        + "     notice, this list of conditions and the following disclaimer.\n"
        + " \n"
        + "  2. Redistributions in binary form must reproduce the above copyright\n"
        + "     notice, this list of conditions and the following disclaimer in\n"
        + "     the documentation and/or other materials provided with the\n"
        + "     distribution.\n"
        + " \n"
        + "  3. The name \"PHP\" must not be used to endorse or promote products\n"
        + "     derived from this software without prior written permission. For\n"
        + "     written permission, please contact group@php.net.\n"
        + "  \n"
        + "  4. Products derived from this software may not be called \"PHP\", nor\n"
        + "     may \"PHP\" appear in their name, without prior written permission\n"
        + "     from group@php.net.  You may indicate that your software works in\n"
        + "     conjunction with PHP by saying \"Foo for PHP\" instead of calling\n"
        + "     it \"PHP Foo\" or \"phpfoo\"\n"
        + " \n"
        + "  5. The PHP Group may publish revised and/or new versions of the\n"
        + "     license from time to time. Each version will be given a\n"
        + "     distinguishing version number.\n"
        + "     Once covered code has been published under a particular version\n"
        + "     of the license, you may always continue to use it under the terms\n"
        + "     of that version. You may also choose to use such covered code\n"
        + "     under the terms of any subsequent version of the license\n"
        + "     published by the PHP Group. No one other than the PHP Group has\n"
        + "     the right to modify the terms applicable to covered code created\n"
        + "     under this License.\n"
        + "\n"
        + "  6. Redistributions of any form whatsoever must retain the following\n"
        + "     acknowledgment:\n"
        + "     \"This product includes PHP, freely available from\n"
        + "     <http://www.php.net/>\".\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED BY THE PHP DEVELOPMENT TEAM ``AS IS'' AND \n"
        + "ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,\n"
        + "THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A \n"
        + "PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE PHP\n"
        + "DEVELOPMENT TEAM OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \n"
        + "INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES \n"
        + "(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR \n"
        + "SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)\n"
        + "HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,\n"
        + "STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)\n"
        + "ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED\n"
        + "OF THE POSSIBILITY OF SUCH DAMAGE.\n"
        + "\n"
        + "-------------------------------------------------------------------- \n"
        + "\n"
        + "This software consists of voluntary contributions made by many\n"
        + "individuals on behalf of the PHP Group.\n"
        + "\n"
        + "The PHP Group can be contacted via Email at group@php.net.\n"
        + "\n"
        + "For more information on the PHP Group and the PHP project, \n"
        + "please see <http://www.php.net>.\n"
        + "\n"
        + "This product includes the Zend Engine, freely available at\n"
        + "<http://www.zend.com>.\n"
; // the license text
    }
 
    
}
