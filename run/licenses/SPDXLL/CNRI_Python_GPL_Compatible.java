package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:45Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: CNRI_Python_GPL_Compatible.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class CNRI_Python_GPL_Compatible extends License{
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
        return "CNRI-Python-GPL-Compatible"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "CNRI Python Open Source GPL Compatible License Agreement"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "CNRI OPEN SOURCE GPL-COMPATIBLE LICENSE AGREEMENT\n"
        + "\n"
        + "IMPORTANT: PLEASE READ THE FOLLOWING AGREEMENT CAREFULLY.\n"
        + "\n"
        + "BY CLICKING ON \"ACCEPT\" WHERE INDICATED BELOW, OR BY COPYING, INSTALLING OR OTHE"
        + "RWISE USING PYTHON 1.6.1 SOFTWARE, YOU ARE DEEMED TO HAVE AGREED TO THE TERMS AN"
        + "D CONDITIONS OF THIS LICENSE AGREEMENT.\n"
        + "\n"
        + "1. This LICENSE AGREEMENT is between the Corporation for National Research Initi"
        + "atives, having an office at 1895 Preston White Drive, Reston, VA 20191 (\"CNRI\"),"
        + " and the Individual or Organization (\"Licensee\") accessing and otherwise using P"
        + "ython 1.6.1 software in source or binary form and its associated documentation.\n"
        + "\n"
        + "2. Subject to the terms and conditions of this License Agreement, CNRI hereby gr"
        + "ants Licensee a nonexclusive, royalty-free, world-wide license to reproduce, ana"
        + "lyze, test, perform and/or display publicly, prepare derivative works, distribut"
        + "e, and otherwise use Python 1.6.1 alone or in any derivative version, provided, "
        + "however, that CNRI's License Agreement and CNRI's notice of copyright, i.e., \"Co"
        + "pyright © 1995-2001 Corporation for National Research Initiatives; All Rights Re"
        + "served\" are retained in Python 1.6.1 alone or in any derivative version prepared"
        + " by Licensee. Alternately, in lieu of CNRI's License Agreement, Licensee may sub"
        + "stitute the following text (omitting the quotes): \"Python 1.6.1 is made availabl"
        + "e subject to the terms and conditions in CNRI's License Agreement. This Agreemen"
        + "t together with Python 1.6.1 may be located on the Internet using the following "
        + "unique, persistent identifier (known as a handle): 1895.22/1013. This Agreement "
        + "may also be obtained from a proxy server on the Internet using the following URL"
        + ": http://hdl.handle.net/1895.22/1013\".\n"
        + "\n"
        + "3. In the event Licensee prepares a derivative work that is based on or incorpor"
        + "ates Python 1.6.1 or any part thereof, and wants to make the derivative work ava"
        + "ilable to others as provided herein, then Licensee hereby agrees to include in a"
        + "ny such work a brief summary of the changes made to Python 1.6.1.\n"
        + "\n"
        + "4. CNRI is making Python 1.6.1 available to Licensee on an \"AS IS\" basis. CNRI M"
        + "AKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED. BY WAY OF EXAMPLE, BU"
        + "T NOT LIMITATION, CNRI MAKES NO AND DISCLAIMS ANY REPRESENTATION OR WARRANTY OF "
        + "MERCHANTABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF PYTHON "
        + "1.6.1 WILL NOT INFRINGE ANY THIRD PARTY RIGHTS.\n"
        + "\n"
        + "5. CNRI SHALL NOT BE LIABLE TO LICENSEE OR ANY OTHER USERS OF PYTHON 1.6.1 FOR A"
        + "NY INCIDENTAL, SPECIAL, OR CONSEQUENTIAL DAMAGES OR LOSS AS A RESULT OF MODIFYIN"
        + "G, DISTRIBUTING, OR OTHERWISE USING PYTHON 1.6.1, OR ANY DERIVATIVE THEREOF, EVE"
        + "N IF ADVISED OF THE POSSIBILITY THEREOF.\n"
        + "\n"
        + "6. This License Agreement will automatically terminate upon a material breach of"
        + " its terms and conditions.\n"
        + "\n"
        + "7. This License Agreement shall be governed by the federal intellectual property"
        + " law of the United States, including without limitation the federal copyright la"
        + "w, and, to the extent such U.S. federal law does not apply, by the law of the Co"
        + "mmonwealth of Virginia, excluding Virginia's conflict of law provisions. Notwith"
        + "standing the foregoing, with regard to derivative works based on Python 1.6.1 th"
        + "at incorporate non-separable material that was previously distributed under the "
        + "GNU General Public License (GPL), the law of the Commonwealth of Virginia shall "
        + "govern this License Agreement only as to issues arising under or with respect to"
        + " Paragraphs 4, 5, and 7 of this License Agreement. Nothing in this License Agree"
        + "ment shall be deemed to create any relationship of agency, partnership, or joint"
        + " venture between CNRI and Licensee. This License Agreement does not grant permis"
        + "sion to use CNRI trademarks or trade name in a trademark sense to endorse or pro"
        + "mote products or services of Licensee, or any third party.\n"
        + "\n"
        + "8. By clicking on the \"ACCEPT\" button where indicated, or by copying, installing"
        + " or otherwise using Python 1.6.1, Licensee agrees to be bound by the terms and c"
        + "onditions of this License Agreement.\n"
        + "\n"
        + "ACCEPT\n"
; // the license text
    }
 
    
}
