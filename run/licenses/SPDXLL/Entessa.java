package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:19Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Entessa.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Entessa extends License{
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
        return "Entessa"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Entessa Public License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Entessa Public License Version. 1.0\n"
        + "Copyright (c) 2003 Entessa, LLC. All rights reserved.\n"
        + "\n"
        + "Redistribution and use in source and binary forms, with or without modification,"
        + " are permitted provided that the following conditions are met:\n"
        + "\n"
        + "1.  Redistributions of source code must retain the above copyright notice, this "
        + "list of conditions and the following disclaimer.\n"
        + "\n"
        + "2.  Redistributions in binary form must reproduce the above copyright notice, th"
        + "is list of conditions and the following disclaimer in the documentation and/or o"
        + "ther materials provided with the distribution.\n"
        + "\n"
        + "3.  The end-user documentation included with the redistribution, if any, must in"
        + "clude the following acknowledgment: \n"
        + " \n"
        + "  \"This product includes open source software developed by openSEAL (http://www."
        + "openseal.org/).\"\n"
        + "\n"
        + "   Alternately, this acknowledgment may appear in the software itself, if and wh"
        + "erever such third-party acknowledgments normally appear.\n"
        + "\n"
        + "4.  The names \"openSEAL\" and \"Entessa\" must not be used to endorse or promote pr"
        + "oducts derived from this software without prior written permission. For written "
        + "permission, please contact epl@entessa.com.\n"
        + "\n"
        + "5.  Products derived from this software may not be called \"openSEAL\", nor may \"o"
        + "penSEAL\" appear in their name, without prior written permission of Entessa.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INC"
        + "LUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNES"
        + "S FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL ENTESSA, LLC, OPENS"
        + "EAL OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,"
        + " EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT"
        + " OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INT"
        + "ERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, S"
        + "TRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY "
        + "OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMA"
        + "GE.\n"
        + "\n"
        + "This software consists of voluntary contributions made by many individuals on be"
        + "half of openSEAL and was originally based on software contributed by Entessa, LL"
        + "C, http://www.entessa.com. For more information on the openSEAL, please see <htt"
        + "p://www.openseal.org/>.\n"
; // the license text
    }
 
    
}
