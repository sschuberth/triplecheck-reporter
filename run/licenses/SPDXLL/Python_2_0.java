package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:38Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Python_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Python_2_0 extends License{
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
        return "Python-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Python License 2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "PYTHON SOFTWARE FOUNDATION LICENSE VERSION 2\n"
        + "--------------------------------------------\n"
        + "\n"
        + "1. This LICENSE AGREEMENT is between the Python Software Foundation\n"
        + "(\"PSF\"), and the Individual or Organization (\"Licensee\") accessing and\n"
        + "otherwise using this software (\"Python\") in source or binary form and\n"
        + "its associated documentation.\n"
        + "\n"
        + "2. Subject to the terms and conditions of this License Agreement, PSF\n"
        + "hereby grants Licensee a nonexclusive, royalty-free, world-wide\n"
        + "license to reproduce, analyze, test, perform and/or display publicly,\n"
        + "prepare derivative works, distribute, and otherwise use Python\n"
        + "alone or in any derivative version, provided, however, that PSF's\n"
        + "License Agreement and PSF's notice of copyright, i.e., \"Copyright (c)\n"
        + "2001, 2002, 2003, 2004, 2005, 2006 Python Software Foundation; All Rights\n"
        + "Reserved\" are retained in Python alone or in any derivative version\n"
        + "prepared by Licensee.\n"
        + "\n"
        + "3. In the event Licensee prepares a derivative work that is based on\n"
        + "or incorporates Python or any part thereof, and wants to make\n"
        + "the derivative work available to others as provided herein, then\n"
        + "Licensee hereby agrees to include in any such work a brief summary of\n"
        + "the changes made to Python.\n"
        + "\n"
        + "4. PSF is making Python available to Licensee on an \"AS IS\"\n"
        + "basis. PSF MAKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR\n"
        + "IMPLIED. BY WAY OF EXAMPLE, BUT NOT LIMITATION, PSF MAKES NO AND\n"
        + "DISCLAIMS ANY REPRESENTATION OR WARRANTY OF MERCHANTABILITY OR FITNESS\n"
        + "FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF PYTHON WILL NOT\n"
        + "INFRINGE ANY THIRD PARTY RIGHTS.\n"
        + "\n"
        + "5. PSF SHALL NOT BE LIABLE TO LICENSEE OR ANY OTHER USERS OF PYTHON\n"
        + "FOR ANY INCIDENTAL, SPECIAL, OR CONSEQUENTIAL DAMAGES OR LOSS AS\n"
        + "A RESULT OF MODIFYING, DISTRIBUTING, OR OTHERWISE USING PYTHON,\n"
        + "OR ANY DERIVATIVE THEREOF, EVEN IF ADVISED OF THE POSSIBILITY THEREOF.\n"
        + "\n"
        + "6. This License Agreement will automatically terminate upon a material\n"
        + "breach of its terms and conditions.\n"
        + "\n"
        + "7. Nothing in this License Agreement shall be deemed to create any\n"
        + "relationship of agency, partnership, or joint venture between PSF and\n"
        + "Licensee. This License Agreement does not grant permission to use PSF\n"
        + "trademarks or trade name in a trademark sense to endorse or promote\n"
        + "products or services of Licensee, or any third party.\n"
        + "\n"
        + "8. By copying, installing or otherwise using Python, Licensee\n"
        + "agrees to be bound by the terms and conditions of this License\n"
        + "Agreement.\n"
        + "\n"
        + "BEOPEN.COM LICENSE AGREEMENT FOR PYTHON 2.0\n"
        + "-------------------------------------------\n"
        + "\n"
        + "BEOPEN PYTHON OPEN SOURCE LICENSE AGREEMENT VERSION 1\n"
        + "\n"
        + "1. This LICENSE AGREEMENT is between BeOpen.com (\"BeOpen\"), having an\n"
        + "office at 160 Saratoga Avenue, Santa Clara, CA 95051, and the\n"
        + "Individual or Organization (\"Licensee\") accessing and otherwise using\n"
        + "this software in source or binary form and its associated\n"
        + "documentation (\"the Software\").\n"
        + "\n"
        + "2. Subject to the terms and conditions of this BeOpen Python License\n"
        + "Agreement, BeOpen hereby grants Licensee a non-exclusive,\n"
        + "royalty-free, world-wide license to reproduce, analyze, test, perform\n"
        + "and/or display publicly, prepare derivative works, distribute, and\n"
        + "otherwise use the Software alone or in any derivative version,\n"
        + "provided, however, that the BeOpen Python License is retained in the\n"
        + "Software, alone or in any derivative version prepared by Licensee.\n"
        + "\n"
        + "3. BeOpen is making the Software available to Licensee on an \"AS IS\"\n"
        + "basis. BEOPEN MAKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR\n"
        + "IMPLIED. BY WAY OF EXAMPLE, BUT NOT LIMITATION, BEOPEN MAKES NO AND\n"
        + "DISCLAIMS ANY REPRESENTATION OR WARRANTY OF MERCHANTABILITY OR FITNESS\n"
        + "FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF THE SOFTWARE WILL NOT\n"
        + "INFRINGE ANY THIRD PARTY RIGHTS.\n"
        + "\n"
        + "4. BEOPEN SHALL NOT BE LIABLE TO LICENSEE OR ANY OTHER USERS OF THE\n"
        + "SOFTWARE FOR ANY INCIDENTAL, SPECIAL, OR CONSEQUENTIAL DAMAGES OR LOSS\n"
        + "AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THE SOFTWARE, OR ANY\n"
        + "DERIVATIVE THEREOF, EVEN IF ADVISED OF THE POSSIBILITY THEREOF.\n"
        + "\n"
        + "5. This License Agreement will automatically terminate upon a material\n"
        + "breach of its terms and conditions.\n"
        + "\n"
        + "6. This License Agreement shall be governed by and interpreted in all\n"
        + "respects by the law of the State of California, excluding conflict of\n"
        + "law provisions. Nothing in this License Agreement shall be deemed to\n"
        + "create any relationship of agency, partnership, or joint venture\n"
        + "between BeOpen and Licensee. This License Agreement does not grant\n"
        + "permission to use BeOpen trademarks or trade names in a trademark\n"
        + "sense to endorse or promote products or services of Licensee, or any\n"
        + "third party. As an exception, the \"BeOpen Python\" logos available at\n"
        + "http://www.pythonlabs.com/logos.html may be used according to the\n"
        + "permissions granted on that web page.\n"
        + "\n"
        + "7. By copying, installing or otherwise using the software, Licensee\n"
        + "agrees to be bound by the terms and conditions of this License\n"
        + "Agreement.\n"
        + "\n"
        + "CNRI OPEN SOURCE LICENSE AGREEMENT (for Python 1.6b1)\n"
        + "--------------------------------------------------\n"
        + "\n"
        + "IMPORTANT: PLEASE READ THE FOLLOWING AGREEMENT CAREFULLY.\n"
        + "\n"
        + "BY CLICKING ON \"ACCEPT\" WHERE INDICATED BELOW, OR BY COPYING,\n"
        + "INSTALLING OR OTHERWISE USING PYTHON 1.6, beta 1 SOFTWARE, YOU ARE\n"
        + "DEEMED TO HAVE AGREED TO THE TERMS AND CONDITIONS OF THIS LICENSE\n"
        + "AGREEMENT.\n"
        + "\n"
        + "1. This LICENSE AGREEMENT is between the Corporation for National\n"
        + "Research Initiatives, having an office at 1895 Preston White Drive,\n"
        + "Reston, VA 20191 (\"CNRI\"), and the Individual or Organization\n"
        + "(\"Licensee\") accessing and otherwise using Python 1.6, beta 1\n"
        + "software in source or binary form and its associated documentation,\n"
        + "as released at the www.python.org Internet site on August 4, 2000\n"
        + "(\"Python 1.6b1\").\n"
        + "\n"
        + "2. Subject to the terms and conditions of this License Agreement, CNRI\n"
        + "hereby grants Licensee a non-exclusive, royalty-free, world-wide\n"
        + "license to reproduce, analyze, test, perform and/or display\n"
        + "publicly, prepare derivative works, distribute, and otherwise use\n"
        + "Python 1.6b1 alone or in any derivative version, provided, however,\n"
        + "that CNRIs License Agreement is retained in Python 1.6b1, alone or\n"
        + "in any derivative version prepared by Licensee.\n"
        + "\n"
        + "Alternately, in lieu of CNRIs License Agreement, Licensee may\n"
        + "substitute the following text (omitting the quotes): \"Python 1.6,\n"
        + "beta 1, is made available subject to the terms and conditions in\n"
        + "CNRIs License Agreement. This Agreement may be located on the\n"
        + "Internet using the following unique, persistent identifier (known\n"
        + "as a handle): 1895.22/1011. This Agreement may also be obtained\n"
        + "from a proxy server on the Internet using the\n"
        + "URL:http://hdl.handle.net/1895.22/1011\".\n"
        + "\n"
        + "3. In the event Licensee prepares a derivative work that is based on\n"
        + "or incorporates Python 1.6b1 or any part thereof, and wants to make\n"
        + "the derivative work available to the public as provided herein,\n"
        + "then Licensee hereby agrees to indicate in any such work the nature\n"
        + "of the modifications made to Python 1.6b1.\n"
        + "\n"
        + "4. CNRI is making Python 1.6b1 available to Licensee on an \"AS IS\"\n"
        + "basis. CNRI MAKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR\n"
        + "IMPLIED. BY WAY OF EXAMPLE, BUT NOT LIMITATION, CNRI MAKES NO AND\n"
        + "DISCLAIMS ANY REPRESENTATION OR WARRANTY OF MERCHANTABILITY OR\n"
        + "FITNESS FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF PYTHON 1.6b1\n"
        + "WILL NOT INFRINGE ANY THIRD PARTY RIGHTS.\n"
        + "\n"
        + "5. CNRI SHALL NOT BE LIABLE TO LICENSEE OR ANY OTHER USERS OF THE\n"
        + "SOFTWARE FOR ANY INCIDENTAL, SPECIAL, OR CONSEQUENTIAL DAMAGES OR\n"
        + "LOSS AS A RESULT OF USING, MODIFYING OR DISTRIBUTING PYTHON 1.6b1,\n"
        + "OR ANY DERIVATIVE THEREOF, EVEN IF ADVISED OF THE POSSIBILITY\n"
        + "THEREOF.\n"
        + "\n"
        + "6. This License Agreement will automatically terminate upon a material\n"
        + "breach of its terms and conditions.\n"
        + "\n"
        + "7. This License Agreement shall be governed by and interpreted in all\n"
        + "respects by the law of the State of Virginia, excluding conflict of\n"
        + "law provisions. Nothing in this License Agreement shall be deemed\n"
        + "to create any relationship of agency, partnership, or joint venture\n"
        + "between CNRI and Licensee. This License Agreement does not grant\n"
        + "permission to use CNRI trademarks or trade name in a trademark\n"
        + "sense to endorse or promote products or services of Licensee, or\n"
        + "any third party.\n"
        + "\n"
        + "8. By clicking on the \"ACCEPT\" button where indicated, or by copying,\n"
        + "installing or otherwise using Python 1.6b1, Licensee agrees to be\n"
        + "bound by the terms and conditions of this License Agreement.\n"
        + "\n"
        + "ACCEPT\n"
        + "\n"
        + "CWI LICENSE AGREEMENT FOR PYTHON 0.9.0 THROUGH 1.2\n"
        + "--------------------------------------------------\n"
        + "\n"
        + "Copyright (c) 1991 - 1995, Stichting Mathematisch Centrum Amsterdam,\n"
        + "The Netherlands. All rights reserved.\n"
        + "\n"
        + "Permission to use, copy, modify, and distribute this software and its\n"
        + "documentation for any purpose and without fee is hereby granted,\n"
        + "provided that the above copyright notice appear in all copies and that\n"
        + "both that copyright notice and this permission notice appear in\n"
        + "supporting documentation, and that the name of Stichting Mathematisch\n"
        + "Centrum or CWI not be used in advertising or publicity pertaining to\n"
        + "distribution of the software without specific, written prior\n"
        + "permission.\n"
        + "\n"
        + "STICHTING MATHEMATISCH CENTRUM DISCLAIMS ALL WARRANTIES WITH REGARD TO\n"
        + "THIS SOFTWARE, INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND\n"
        + "FITNESS, IN NO EVENT SHALL STICHTING MATHEMATISCH CENTRUM BE LIABLE\n"
        + "FOR ANY SPECIAL, INDIRECT OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES\n"
        + "WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN\n"
        + "ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT\n"
        + "OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.\n"
; // the license text
    }
 
    
}
