package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:56Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: XFree86_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class XFree86_1_1 extends License{
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
        return "XFree86-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "XFree86 License 1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "XFree86 License (version 1.1)\n"
        + "\n"
        + "Copyright (C) 1994-2006 The XFree86 Project, Inc.\n"
        + "All rights reserved.\n"
        + "\n"
        + "Permission is hereby granted, free of charge, to any person obtaining a copy of "
        + "this software and associated documentation files (the \"Software\"), to deal in th"
        + "e Software without restriction, including without limitation the rights to use, "
        + "copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the "
        + "Software, and to permit persons to whom the Software is furnished to do so, subj"
        + "ect to the following conditions:\n"
        + "\n"
        + "1. Redistributions of source code must retain the above copyright notice, this l"
        + "ist of conditions, and the following disclaimer.\n"
        + "\n"
        + "2. Redistributions in binary form must reproduce the above copyright notice, thi"
        + "s list of conditions and the following disclaimer in the documentation and/or ot"
        + "her materials provided with the distribution, and in the same place and form as "
        + "other copyright, license and disclaimer information.\n"
        + "\n"
        + "3. The end-user documentation included with the redistribution, if any, must inc"
        + "lude the following acknowledgment: \"This product includes software developed by "
        + "The XFree86 Project, Inc (http://www.xfree86.org/) and its contributors\", in the"
        + " same place and form as other third-party acknowledgments. Alternately, this ack"
        + "nowledgment may appear in the software itself, in the same form and location as "
        + "other such third-party acknowledgments.\n"
        + "\n"
        + "4. Except as contained in this notice, the name of The XFree86 Project, Inc shal"
        + "l not be used in advertising or otherwise to promote the sale, use or other deal"
        + "ings in this Software without prior written authorization from The XFree86 Proje"
        + "ct, Inc.\n"
        + "\n"
        + "THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INC"
        + "LUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNES"
        + "S FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE XFREE86 PROJECT"
        + ", INC OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIA"
        + "L, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREME"
        + "NT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS I"
        + "NTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,"
        + " STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WA"
        + "Y OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DA"
        + "MAGE.\n"
; // the license text
    }
 
    
}
