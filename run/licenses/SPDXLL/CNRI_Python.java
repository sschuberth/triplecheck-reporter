package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:44Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: CNRI_Python.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class CNRI_Python extends License{
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
        return "CNRI-Python"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "CNRI Python License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "CNRI OPEN SOURCE LICENSE AGREEMENT\n"
        + "\n"
        + "IMPORTANT: PLEASE READ THE FOLLOWING AGREEMENT CAREFULLY.\n"
        + "\n"
        + "BY CLICKING ON \"ACCEPT\" WHERE INDICATED BELOW, OR BY COPYING, INSTALLING OR OTHE"
        + "RWISE USING PYTHON 1.6, beta 1 SOFTWARE, YOU ARE DEEMED TO HAVE AGREED TO THE TE"
        + "RMS AND CONDITIONS OF THIS LICENSE AGREEMENT.\n"
        + "\n"
        + "1. This LICENSE AGREEMENT is between the Corporation for National Research Initi"
        + "atives, having an office at 1895 Preston White Drive, Reston, VA 20191 (\"CNRI\"),"
        + " and the Individual or Organization (\"Licensee\") accessing and otherwise using P"
        + "ython 1.6, beta 1 software in source or binary form and its associated documenta"
        + "tion, as released at the www.python.org Internet site on August 4, 2000 (\"Python"
        + " 1.6b1\").\n"
        + "\n"
        + "2. Subject to the terms and conditions of this License Agreement, CNRI hereby gr"
        + "ants Licensee a non-exclusive, royalty-free, world-wide license to reproduce, an"
        + "alyze, test, perform and/or display publicly, prepare derivative works, distribu"
        + "te, and otherwise use Python 1.6b1 alone or in any derivative version, provided,"
        + " however, that CNRIs License Agreement is retained in Python 1.6b1, alone or in "
        + "any derivative version prepared by Licensee.\n"
        + "\n"
        + "Alternately, in lieu of CNRIs License Agreement, Licensee may substitute the fol"
        + "lowing text (omitting the quotes): \"Python 1.6, beta 1, is made available subjec"
        + "t to the terms and conditions in CNRIs License Agreement. This Agreement may be "
        + "located on the Internet using the following unique, persistent identifier (known"
        + " as a handle): 1895.22/1011. This Agreement may also be obtained from a proxy se"
        + "rver on the Internet using the URL:http://hdl.handle.net/1895.22/1011\".\n"
        + "\n"
        + "3. In the event Licensee prepares a derivative work that is based on or incorpor"
        + "ates Python 1.6b1 or any part thereof, and wants to make the derivative work ava"
        + "ilable to the public as provided herein, then Licensee hereby agrees to indicate"
        + " in any such work the nature of the modifications made to Python 1.6b1.\n"
        + "\n"
        + "4. CNRI is making Python 1.6b1 available to Licensee on an \"AS IS\" basis. CNRI M"
        + "AKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED. BY WAY OF EXAMPLE, BU"
        + "T NOT LIMITATION, CNRI MAKES NO AND DISCLAIMS ANY REPRESENTATION OR WARRANTY OF "
        + "MERCHANTABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF PYTHON "
        + "1.6b1 WILL NOT INFRINGE ANY THIRD PARTY RIGHTS.\n"
        + "\n"
        + "5. CNRI SHALL NOT BE LIABLE TO LICENSEE OR ANY OTHER USERS OF THE SOFTWARE FOR A"
        + "NY INCIDENTAL, SPECIAL, OR CONSEQUENTIAL DAMAGES OR LOSS AS A RESULT OF USING, M"
        + "ODIFYING OR DISTRIBUTING PYTHON 1.6b1, OR ANY DERIVATIVE THEREOF, EVEN IF ADVISE"
        + "D OF THE POSSIBILITY THEREOF.\n"
        + "\n"
        + "6. This License Agreement will automatically terminate upon a material breach of"
        + " its terms and conditions.\n"
        + "\n"
        + "7. This License Agreement shall be governed by and interpreted in all respects b"
        + "y the law of the State of Virginia, excluding conflict of law provisions. Nothin"
        + "g in this License Agreement shall be deemed to create any relationship of agency"
        + ", partnership, or joint venture between CNRI and Licensee. This License Agreemen"
        + "t does not grant permission to use CNRI trademarks or trade name in a trademark "
        + "sense to endorse or promote products or services of Licensee, or any third party"
        + ".\n"
        + "\n"
        + "8. By clicking on the \"ACCEPT\" button where indicated, or by copying, installing"
        + " or otherwise using Python 1.6b1, Licensee agrees to be bound by the terms and c"
        + "onditions of this License Agreement.\n"
        + "\n"
        + "ACCEPT\n"
; // the license text
    }
 
    
}
