package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:38Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: QPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class QPL_1_0 extends License{
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
        return "QPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Q Public License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "THE Q PUBLIC LICENSE version 1.0\n"
        + "\n"
        + "Copyright (C) 1999-2005 Trolltech AS, Norway.\n"
        + "Everyone is permitted to copy and distribute this license document.\n"
        + "\n"
        + "The intent of this license is to establish freedom to share and change the softw"
        + "are regulated by this license under the open source model.\n"
        + "\n"
        + "This license applies to any software containing a notice placed by the copyright"
        + " holder saying that it may be distributed under the terms of the Q Public Licens"
        + "e version 1.0. Such software is herein referred to as the Software. This license"
        + " covers modification and distribution of the Software, use of third-party applic"
        + "ation programs based on the Software, and development of free software which use"
        + "s the Software.\n"
        + "\n"
        + "Granted Rights\n"
        + "\n"
        + "1. You are granted the non-exclusive rights set forth in this license provided y"
        + "ou agree to and comply with any and all conditions in this license. Whole or par"
        + "tial distribution of the Software, or software items that link with the Software"
        + ", in any form signifies acceptance of this license.\n"
        + "\n"
        + "2. You may copy and distribute the Software in unmodified form provided that the"
        + " entire package, including - but not restricted to - copyright, trademark notice"
        + "s and disclaimers, as released by the initial developer of the Software, is dist"
        + "ributed.\n"
        + "\n"
        + "3. You may make modifications to the Software and distribute your modifications,"
        + " in a form that is separate from the Software, such as patches. The following re"
        + "strictions apply to modifications:\n"
        + "\n"
        + "a. Modifications must not alter or remove any copyright notices in the Software.\n"
        + "b. When modifications to the Software are released under this license, a non-exc"
        + "lusive royalty-free right is granted to the initial developer of the Software to"
        + " distribute your modification in future versions of the Software provided such v"
        + "ersions remain available under these terms in addition to any other license(s) o"
        + "f the initial developer.\n"
        + "\n"
        + "4. You may distribute machine-executable forms of the Software or machine-execut"
        + "able forms of modified versions of the Software, provided that you meet these re"
        + "strictions:\n"
        + "\n"
        + "a. You must include this license document in the distribution.\n"
        + "b. You must ensure that all recipients of the machine-executable forms are also "
        + "able to receive the complete machine-readable source code to the distributed Sof"
        + "tware, including all modifications, without any charge beyond the costs of data "
        + "transfer, and place prominent notices in the distribution explaining this.\n"
        + "c. You must ensure that all modifications included in the machine-executable for"
        + "ms are available under the terms of this license.\n"
        + "\n"
        + "5. You may use the original or modified versions of the Software to compile, lin"
        + "k and run application programs legally developed by you or by others.\n"
        + "\n"
        + "6. You may develop application programs, reusable components and other software "
        + "items that link with the original or modified versions of the Software. These it"
        + "ems, when distributed, are subject to the following requirements:\n"
        + "\n"
        + "a. You must ensure that all recipients of machine-executable forms of these item"
        + "s are also able to receive and use the complete machine-readable source code to "
        + "the items without any charge beyond the costs of data transfer.\n"
        + "b. You must explicitly license all recipients of your items to use and re-distri"
        + "bute original and modified versions of the items in both machine-executable and "
        + "source code forms. The recipients must be able to do so without any charges what"
        + "soever, and they must be able to re-distribute to anyone they choose.\n"
        + "c. If the items are not available to the general public, and the initial develop"
        + "er of the Software requests a copy of the items, then you must supply one.\n"
        + "\n"
        + "Limitations of Liability\n"
        + "\n"
        + "In no event shall the initial developers or copyright holders be liable for any "
        + "damages whatsoever, including - but not restricted to - lost revenue or profits "
        + "or other direct, indirect, special, incidental or consequential damages, even if"
        + " they have been advised of the possibility of such damages, except to the extent"
        + " invariable law, if any, provides otherwise.\n"
        + "\n"
        + "No Warranty\n"
        + "\n"
        + "The Software and this license document are provided AS IS with NO WARRANTY OF AN"
        + "Y KIND, INCLUDING THE WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PART"
        + "ICULAR PURPOSE.\n"
        + "\n"
        + "Choice of Law\n"
        + "\n"
        + "This license is governed by the Laws of Norway. Disputes shall be settled by Osl"
        + "o City Court.\n"
; // the license text
    }
 
    
}
