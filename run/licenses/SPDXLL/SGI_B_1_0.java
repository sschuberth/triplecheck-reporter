package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:45Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SGI_B_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class SGI_B_1_0 extends License{
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
        return "SGI-B-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "SGI Free Software License B v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "SGI FREE SOFTWARE LICENSE B \n"
        + "(Version 1.0 1/25/2000)\n"
        + "\n"
        + "1. Definitions.\n"
        + "1.1 \"Additional Notice Provisions\" means such additional provisions as appear i"
        + "n the Notice in Original Code under the heading \"Additional Notice Provisions.\"\n"
        + "1.2\"API\" means an application programming interface established by SGI in conju"
        + "nction with the Original Code.\n"
        + "1.3\"Covered Code\" means the Original Code or Modifications or the combination o"
        + "f the Original Code and Modifications, in each case including portions thereof.\n"
        + "1.4 \"Hardware\" means any physical device that accepts input, processes input, s"
        + "tores the results of processing, and/or provides output.\n"
        + "1.5\"Larger Work\" means a work which combines Covered Code or portions thereof "
        + "with code not governed by the terms of this License.\n"
        + "1.6\"Licensable\" means having the right to grant, to the maximum extent possibl"
        + "e, whether at the time of the initial grant or subsequently acquired, any and al"
        + "l of the rights conveyed herein.\n"
        + "1.7\"License\" means this document.\n"
        + "1.8\"Modifications\" means any addition to the substance or structure of the Ori"
        + "ginal Code and/or any addition to or deletion from previous Modifications. When "
        + "Covered Code is released as a series of files, a Modification is:\n"
        + "A.Any addition to the contents of a file containing Original Code and/or any "
        + "addition to or deletion from previous Modifications.\n"
        + "B.Any new file that contains any part of the Original Code or previous Modifi"
        + "cations.\n"
        + "1.9\"Notice\" means any notice in Original Code or Covered Code, as required by "
        + "and in compliance with this License.\n"
        + "1.10\"Original Code\" means source code of computer software code which is descr"
        + "ibed in the source code Notice required by Exhibit A as Original Code, and updat"
        + "es and error corrections specifically thereto.\n"
        + "1.11\"Recipient\" means an individual or a legal entity exercising rights under,"
        + " and complying with all of the terms of, this License or a future version of thi"
        + "s License issued under Section 8. For legal entities, \"Recipient\" includes any e"
        + "ntity which controls, is controlled by, or is under common control with Recipien"
        + "t. For purposes of this definition, \"control\" of an entity means (a) the power, "
        + "direct or indirect, to direct or manage such entity, or (b) ownership of fifty p"
        + "ercent (50%) or more of the outstanding shares or beneficial ownership of such e"
        + "ntity.\n"
        + "1.12\"SGI\" means Silicon Graphics, Inc.\n"
        + "\n"
        + "2. License Grant and Restrictions.\n"
        + "2.1License Grant. Subject to the provisions of this License and any third part"
        + "y intellectual property claims, for the duration of intellectual property protec"
        + "tions inherent in the Original Code, SGI hereby grants Recipient a worldwide, ro"
        + "yalty-free, non-exclusive license, to do the following: (i) under copyrights Lic"
        + "ensable by SGI, to reproduce, distribute, create derivative works from, and, to "
        + "the extent applicable, display and perform the Original Code alone and/or as par"
        + "t of a Larger Work; and (ii) under any patent claims Licensable by SGI and embod"
        + "ied in the Original Code, to make, have made, use, practice, sell, and offer for"
        + " sale, and/or otherwise dispose of the Original Code. Recipient accepts the term"
        + "s and conditions of this License by undertaking any of the aforementioned action"
        + "s.\n"
        + "2.2Restriction on Patent License. Notwithstanding the provisions of Section 2."
        + "1(ii), no patent license is granted: 1) separate from the Original Code; nor 2) "
        + "for infringements caused by (i) modification of the Original Code, or (ii) the c"
        + "ombination of the Original Code with other software or Hardware.\n"
        + "2.3No License For Hardware Implementations. The licenses granted in Section 2."
        + "1 are not applicable to implementation in Hardware of the algorithms embodied in"
        + " the Original Code.\n"
        + "2.4Modifications License and API Compliance. Modifications are only licensed u"
        + "nder Section 2.1(i) to the extent such Modifications are fully compliant with an"
        + "y API as may be identified in Additional Notice Provisions as appear in the Orig"
        + "inal Code.\n"
        + "\n"
        + "3. Redistributions.\n"
        + "A.Retention of Notice/Copy of License. The Notice set forth in Exhibit A, bel"
        + "ow, must be conspicuously retained or included in any and all redistributions of"
        + " Covered Code. For distributions of the Covered Code in source code form, the No"
        + "tice must appear in every file that can include a text comments field; in execut"
        + "able form, the Notice and a copy of this License must appear in related document"
        + "ation or collateral where the Recipient’s rights relating to Covered Code are de"
        + "scribed. Any Additional Notice Provisions which actually appears in the Original"
        + " Code must also be retained or included in any and all redistributions of Covere"
        + "d Code.\n"
        + "B.Alternative License. Provided that Recipient is in compliance with the term"
        + "s of this License, Recipient may distribute the source code and/or executable ve"
        + "rsion(s) of Covered Code under (1) this License; (2) a license identical to this"
        + " License but for only such changes as are necessary in order to clarify Recipien"
        + "t’s role as licensor of Modifications, without derogation of any of SGI’s rights"
        + "; and/or (3) a license of Recipient’s choosing, containing terms different from "
        + "this License, provided that the license terms include this Section 3 and Section"
        + "s 4, 6, 7, 10, 12, and 13, which terms may not be modified or superseded by any "
        + "other terms of such license. If Recipient elects to use any license other than t"
        + "his License, Recipient must make it absolutely clear that any of its terms which"
        + " differ from this License are offered by Recipient alone, and not by SGI.\n"
        + "C.Indemnity. Recipient hereby agrees to indemnify SGI for any liability incur"
        + "red by SGI as a result of any such alternative license terms Recipient offers.\n"
        + "\n"
        + "4. Termination. This License and the rights granted hereunder will terminate aut"
        + "omatically if Recipient breaches any term herein and fails to cure such breach w"
        + "ithin 30 days thereof. Any sublicense to the Covered Code that is properly grant"
        + "ed shall survive any termination of this License, absent termination by the term"
        + "s of such sublicense. Provisions that, by their nature, must remain in effect be"
        + "yond the termination of this License, shall survive.\n"
        + "\n"
        + "5. No Trademark Or Other Rights. This License does not grant any rights to: (i) "
        + "any software apart from the Covered Code, nor shall any other rights or licenses"
        + " not expressly granted hereunder arise by implication, estoppel or otherwise wit"
        + "h respect to the Covered Code; (ii) any trade name, trademark or service mark wh"
        + "atsoever, including without limitation any related right for purposes of endorse"
        + "ment or promotion of products derived from the Covered Code, without prior writt"
        + "en permission of SGI; or (iii) any title to or ownership of the Original Code, w"
        + "hich shall at all times remains with SGI. All rights in the Original Code not ex"
        + "pressly granted under this License are reserved.\n"
        + "\n"
        + "6. Compliance with Laws; Non-Infringement. Recipient hereby assures that it shal"
        + "l comply with all applicable laws, regulations, and executive orders, in connect"
        + "ion with any and all dispositions of Covered Code, including but not limited to,"
        + " all export, re-export, and import control laws, regulations, and executive orde"
        + "rs, of the U.S. government and other countries. Recipient may not distribute Cov"
        + "ered Code that (i) in any way infringes (directly or contributorily) the rights "
        + "(including patent, copyright, trade secret, trademark or other intellectual prop"
        + "erty rights of any kind) of any other person or entity or (ii) breaches any repr"
        + "esentation or warranty, express, implied or statutory, to which, under any appli"
        + "cable law, it might be deemed to have been subject.\n"
        + "\n"
        + "7. Claims of Infringement. If Recipient learns of any third party claim that any"
        + " disposition of Covered Code and/or functionality wholly or partially infringes "
        + "the third party's intellectual property rights, Recipient will promptly notify S"
        + "GI of such claim.\n"
        + "\n"
        + "8. Versions of the License. SGI may publish revised and/or new versions of the L"
        + "icense from time to time, each with a distinguishing version number. Once Covere"
        + "d Code has been published under a particular version of the License, Recipient m"
        + "ay, for the duration of the license, continue to use it under the terms of that "
        + "version, or choose to use such Covered Code under the terms of any subsequent ve"
        + "rsion published by SGI. Subject to the provisions of Sections 3 and 4 of this Li"
        + "cense, only SGI may modify the terms applicable to Covered Code created under th"
        + "is License.\n"
        + "\n"
        + "9. DISCLAIMER OF WARRANTY. COVERED CODE IS PROVIDED \"AS IS.\" ALL EXPRESS AND IMP"
        + "LIED WARRANTIES AND CONDITIONS ARE DISCLAIMED, INCLUDING, WITHOUT LIMITATION, AN"
        + "Y IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILITY, SATISFACTORY QUALITY, FI"
        + "TNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT. SGI ASSUMES NO RISK AS TO "
        + "THE QUALITY AND PERFORMANCE OF THE SOFTWARE. SHOULD THE SOFTWARE PROVE DEFECTIVE"
        + " IN ANY RESPECT, SGI ASSUMES NO COST OR LIABILITY FOR SERVICING, REPAIR OR CORRE"
        + "CTION. THIS DISCLAIMER OF WARRANTY IS AN ESSENTIAL PART OF THIS LICENSE. NO USE "
        + "OF ANY COVERED CODE IS AUTHORIZED HEREUNDER EXCEPT SUBJECT TO THIS DISCLAIMER.\n"
        + "\n"
        + "10. LIMITATION OF LIABILITY. UNDER NO CIRCUMSTANCES NOR LEGAL THEORY, WHETHER TO"
        + "RT (INCLUDING, WITHOUT LIMITATION, NEGLIGENCE OR STRICT LIABILITY), CONTRACT, OR"
        + " OTHERWISE, SHALL SGI OR ANY SGI LICENSOR BE LIABLE FOR ANY DIRECT, INDIRECT, SP"
        + "ECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES OF ANY CHARACTER INCLUDING, WITHOUT "
        + "LIMITATION, DAMAGES FOR LOSS OF GOODWILL, WORK STOPPAGE, LOSS OF DATA, COMPUTER "
        + "FAILURE OR MALFUNCTION, OR ANY AND ALL OTHER COMMERCIAL DAMAGES OR LOSSES, EVEN "
        + "IF SUCH PARTY SHALL HAVE BEEN INFORMED OF THE POSSIBILITY OF SUCH DAMAGES. THIS "
        + "LIMITATION OF LIABILITY SHALL NOT APPLY TO LIABILITY FOR DEATH OR PERSONAL INJUR"
        + "Y RESULTING FROM SGI's NEGLIGENCE TO THE EXTENT APPLICABLE LAW PROHIBITS SUCH LI"
        + "MITATION. SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OR LIMITATION OF INCIDEN"
        + "TAL OR CONSEQUENTIAL DAMAGES, SO THAT EXCLUSION AND LIMITATION MAY NOT APPLY TO "
        + "RECIPIENT.\n"
        + "\n"
        + "11. Indemnity. Recipient shall be solely responsible for damages arising, direct"
        + "ly or indirectly, out of its utilization of rights under this License. Recipient"
        + " will defend, indemnify and hold harmless Silicon Graphics, Inc. from and agains"
        + "t any loss, liability, damages, costs or expenses (including the payment of reas"
        + "onable attorneys fees) arising out of Recipient's use, modification, reproductio"
        + "n and distribution of the Covered Code or out of any representation or warranty "
        + "made by Recipient.\n"
        + "\n"
        + "12. U.S. Government End Users. The Covered Code is a \"commercial item\" consistin"
        + "g of \"commercial computer software\" as such terms are defined in title 48 of the"
        + " Code of Federal Regulations and all U.S. Government End Users acquire only the "
        + "rights set forth in this License and are subject to the terms of this License.\n"
        + "\n"
        + "13. Miscellaneous. This License represents the complete agreement concerning the"
        + " its subject matter. If any provision of this License is held to be unenforceabl"
        + "e, such provision shall be reformed so as to achieve as nearly as possible the s"
        + "ame legal and economic effect as the original provision and the remainder of thi"
        + "s License will remain in effect. This License shall be governed by and construed"
        + " in accordance with the laws of the United States and the State of California as"
        + " applied to agreements entered into and to be performed entirely within Californ"
        + "ia between California residents. Any litigation relating to this License shall b"
        + "e subject to the exclusive jurisdiction of the Federal Courts of the Northern Di"
        + "strict of California (or, absent subject matter jurisdiction in such courts, the"
        + " courts of the State of California), with venue lying exclusively in Santa Clara"
        + " County, California, with the losing party responsible for costs, including with"
        + "out limitation, court costs and reasonable attorneys fees and expenses. The appl"
        + "ication of the United Nations Convention on Contracts for the International Sale"
        + " of Goods is expressly excluded. Any law or regulation which provides that the l"
        + "anguage of a contract shall be construed against the drafter shall not apply to "
        + "this License.\n"
        + "\n"
        + "Exhibit A\n"
        + "\n"
        + "License Applicability. Except to the extent portions of this file are made subje"
        + "ct to an alternative license as permitted in the SGI Free Software License B, Ve"
        + "rsion 1.0 (the \"License\"), the contents of this file are subject only to the pro"
        + "visions of the License. You may not use this file except in compliance with the "
        + "License. You may obtain a copy of the License at Silicon Graphics, Inc., attn: L"
        + "egal Services, 1600 Ampitheatre Parkway, Mountain View, CA 94043-1351, or at:\n"
        + "\n"
        + "http://oss.sgi.com/projects/FreeB\n"
        + "\n"
        + "Note that, as provided in the License, the Software is distributed on an \"AS IS\""
        + " basis, with ALL EXPRESS AND IMPLIED WARRANTIES AND CONDITIONS DISCLAIMED, INCLU"
        + "DING, WITHOUT LIMITATION, ANY IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILI"
        + "TY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT"
        + ".\n"
        + "\n"
        + "Original Code. The Original Code is: [name of software, version number, and rele"
        + "ase date], developed by Silicon Graphics, Inc. The Original Code is Copyright (c"
        + ") [dates of first publication, as appearing in the Notice in the Original Code] "
        + "Silicon Graphics, Inc. Copyright in any portions created by third parties is as "
        + "indicated elsewhere herein. All Rights Reserved.\n"
        + "\n"
        + "Additional Notice Provisions: [such additional provisions, if any, as appear in "
        + "the Notice in the Original Code under the heading \"Additional Notice Provisions\""
        + "]\n"
; // the license text
    }
 
    
}
