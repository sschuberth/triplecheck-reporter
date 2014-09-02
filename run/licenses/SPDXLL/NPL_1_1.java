package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:20Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: NPL_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class NPL_1_1 extends License{
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
        return "NPL-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Netscape Public License v1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Netscape Public LIcense version 1.1\n"
        + "\"\n"
        + "AMENDMENTS\n"
        + "\n"
        + "The Netscape Public License Version 1.1 (\"NPL\") consists of the Mozilla Public L"
        + "icense Version 1.1 with the following Amendments, including Exhibit A-Netscape P"
        + "ublic License.  Files identified with \"Exhibit A-Netscape Public License\" are go"
        + "verned by the Netscape Public License Version 1.1.\n"
        + "Additional Terms applicable to the Netscape Public License.\n"
        + "I. Effect. \n"
        + "These additional terms described in this Netscape Public License -- Amendments "
        + "shall apply to the Mozilla Communicator client code and to all Covered Code unde"
        + "r this License.\n"
        + "\n"
        + "II. \"Netscape's Branded Code\" means Covered Code that Netscape distributes and/"
        + "or permits others to distribute under one or more trademark(s) which are control"
        + "led by Netscape but which are not licensed for use under this License. \n"
        + "III. Netscape and logo.  This License does not grant any rights to use the tra"
        + "demarks \"Netscape\", the \"Netscape N and horizon\" logo or the \"Netscape lighthous"
        + "e\" logo, \"Netcenter\", \"Gecko\", \"Java\" or \"JavaScript\", \"Smart Browsing\" even if "
        + "such marks are included in the Original Code or Modifications. \n"
        + "IV. Inability to Comply Due to Contractual Obligation.  Prior to licensing the"
        + " Original Code under this License, Netscape has licensed third party code for us"
        + "e in Netscape's Branded Code. To the extent that Netscape is limited contractual"
        + "ly from making such third party code available under this License, Netscape may "
        + "choose to reintegrate such code into Covered Code without being required to dist"
        + "ribute such code in Source Code form, even if such code would otherwise be consi"
        + "dered \"Modifications\" under this License. \n"
        + "V. Use of Modifications and Covered Code by Initial Developer.\n"
        + "\n"
        + "V.1. In General. \n"
        + "The obligations of Section 3 apply to Netscape, except to the extent specified"
        + " in this Amendment, Section V.2 and V.3.\n"
        + "V.2. Other Products.  Netscape may include Covered Code in products other than"
        + " the Netscape's Branded Code which are released by Netscape during the two (2) y"
        + "ears following the release date of the Original Code, without such additional pr"
        + "oducts becoming subject to the terms of this License, and may license such addit"
        + "ional products on different terms from those contained in this License. V.3. A"
        + "lternative Licensing.  Netscape may license the Source Code of Netscape's Bran"
        + "ded Code, including Modifications incorporated therein, without such Netscape Br"
        + "anded Code becoming subject to the terms of this License, and may license such N"
        + "etscape Branded Code on different terms from those contained in this License.   \n"
        + "VI. Litigation. \n"
        + "Notwithstanding the limitations of Section 11 above, the provisions regarding l"
        + "itigation in Section 11(a), (b) and (c) of the License shall apply to all disput"
        + "es relating to this License.\n"
        + " EXHIBIT A-Netscape Public License.\n"
        + "  \n"
        + "\"The contents of this file are subject to the Netscape Public License Version 1."
        + "1 (the \"License\"); you may not use this file except in compliance with the Licen"
        + "se. You may obtain a copy of the License at http://www.mozilla.org/NPL/\n"
        + "\n"
        + "Software distributed under the License is distributed on an \"AS IS\" basis, WITHO"
        + "UT WARRANTY OF ANY KIND, either express or implied. See the License for the spec"
        + "ific language governing rights and limitations under the License. \n"
        + "The Original Code is Mozilla Communicator client code, released March 31, 1998. \n"
        + "The Initial Developer of the Original Code is Netscape Communications Corporatio"
        + "n. Portions created by Netscape are Copyright (C) 1998-1999 Netscape Communicati"
        + "ons Corporation. All Rights Reserved. Contributor(s): __________________________"
        + "____________.\n"
        + "  \n"
        + "Alternatively, the contents of this file may be used under the terms of the ____"
        + "_ license (the  \"[___] License\"), in which case the provisions of [______] Licen"
        + "se are applicable  instead of those above.  If you wish to allow use of your ver"
        + "sion of this file only under the terms of the [____] License and not to allow ot"
        + "hers to use your version of this file under the NPL, indicate your decision by d"
        + "eleting  the provisions above and replace  them with the notice and other provis"
        + "ions required by the [___] License.  If you do not delete the provisions above, "
        + "a recipient may use your version of this file under either the NPL or the [___] "
        + "License.\"\n"
        + "\n"
        + "\n"
        + "MOZILLA PUBLIC LICENSE \n"
        + "Version 1.1\n"
        + "\n"
        + "1. Definitions.\n"
        + "1.0.1. \"Commercial Use\" means distribution or otherwise making the Covered Code"
        + " available to a third party.1.1. \"Contributor\" means each entity that creates o"
        + "r contributes to the creation of Modifications. 1.2. \"Contributor Version\" mean"
        + "s the combination of the Original Code, prior Modifications used by a Contributo"
        + "r, and the Modifications made by that particular Contributor. 1.3. \"Covered Cod"
        + "e\" means the Original Code or Modifications or the combination of the Original C"
        + "ode and Modifications, in each case including portions thereof. 1.4. \"Electroni"
        + "c Distribution Mechanism\" means a mechanism generally accepted in the software d"
        + "evelopment community for the electronic transfer of data. 1.5. \"Executable\" mea"
        + "ns Covered Code in any form other than Source Code. 1.6. \"Initial Developer\" me"
        + "ans the individual or entity identified as the Initial Developer in the Source C"
        + "ode notice required by Exhibit A. 1.7. \"Larger Work\" means a work which combine"
        + "s Covered Code or portions thereof with code not governed by the terms of this L"
        + "icense. 1.8. \"License\" means this document. 1.8.1. \"Licensable\" means having th"
        + "e right to grant, to the maximum extent possible, whether at the time of the ini"
        + "tial grant or subsequently acquired, any and all of the rights conveyed herein. "
        + "1.9. \"Modifications\" means any addition to or deletion from the substance or st"
        + "ructure of either the Original Code or any previous Modifications. When Covered "
        + "Code is released as a series of files, a Modification is:\n"
        + "A. Any addition to or deletion from the contents of a file containing Original"
        + " Code or previous Modifications.\n"
        + "B. Any new file that contains any part of the Original Code or previous Modifi"
        + "cations.   \n"
        + "1.10. \"Original Code\" means Source Code of computer software code which is desc"
        + "ribed in the Source Code notice required by Exhibit A as Original Code, and whic"
        + "h, at the time of its release under this License is not already Covered Code gov"
        + "erned by this License.1.10.1. \"Patent Claims\" means any patent claim(s), now own"
        + "ed or hereafter acquired, including without limitation,  method, process, and ap"
        + "paratus claims, in any patent Licensable by grantor. 1.11. \"Source Code\" means "
        + "the preferred form of the Covered Code for making modifications to it, including"
        + " all modules it contains, plus any associated interface definition files, script"
        + "s used to control compilation and installation of an Executable, or source code "
        + "differential comparisons against either the Original Code or another well known,"
        + " available Covered Code of the Contributor's choice. The Source Code can be in a"
        + " compressed or archival form, provided the appropriate decompression or de-archi"
        + "ving software is widely available for no charge. 1.12. \"You\" (or \"Your\")  means"
        + " an individual or a legal entity exercising rights under, and complying with all"
        + " of the terms of, this License or a future version of this License issued under "
        + "Section 6.1. For legal entities, \"You\" includes any entity which controls, is co"
        + "ntrolled by, or is under common control with You. For purposes of this definitio"
        + "n, \"control\" means (a) the power, direct or indirect, to cause the direction or "
        + "management of such entity, whether by contract or otherwise, or (b) ownership of"
        + " more than fifty percent (50%) of the outstanding shares or beneficial ownership"
        + " of such entity.\n"
        + "\n"
        + "2. Source Code License.\n"
        + "2.1. The Initial Developer Grant. \n"
        + "The Initial Developer hereby grants You a world-wide, royalty-free, non-exclusi"
        + "ve license, subject to third party intellectual property claims:\n"
        + "(a)  under intellectual property rights (other than patent or trademark) Licen"
        + "sable by Initial Developer to use, reproduce, modify, display, perform, sublicen"
        + "se and distribute the Original Code (or portions thereof) with or without Modifi"
        + "cations, and/or as part of a Larger Work; and\n"
        + "(b) under Patents Claims infringed by the making, using or selling of Original"
        + " Code, to make, have made, use, practice, sell, and offer for sale, and/or other"
        + "wise dispose of the Original Code (or portions thereof). \n"
        + "(c) the licenses granted in this Section 2.1(a) and (b) are effective on the d"
        + "ate Initial Developer first distributes Original Code under the terms of this Li"
        + "cense.\n"
        + "(d) Notwithstanding Section 2.1(b) above, no patent license is granted: 1) for"
        + " code that You delete from the Original Code; 2) separate from the Original Code"
        + ";  or 3) for infringements caused by: i) the modification of the Original Code o"
        + "r ii) the combination of the Original Code with other software or devices.   \n"
        + "2.2. Contributor Grant. \n"
        + "Subject to third party intellectual property claims, each Contributor hereby gr"
        + "ants You a world-wide, royalty-free, non-exclusive license\n"
        + "(a)  under intellectual property rights (other than patent or trademark) Licen"
        + "sable by Contributor, to use, reproduce, modify, display, perform, sublicense an"
        + "d distribute the Modifications created by such Contributor (or portions thereof)"
        + " either on an unmodified basis, with other Modifications, as Covered Code and/or"
        + " as part of a Larger Work; and\n"
        + "(b) under Patent Claims infringed by the making, using, or selling of  Modific"
        + "ations made by that Contributor either alone and/or in combination with its Cont"
        + "ributor Version (or portions of such combination), to make, use, sell, offer for"
        + " sale, have made, and/or otherwise dispose of: 1) Modifications made by that Con"
        + "tributor (or portions thereof); and 2) the combination of  Modifications made by"
        + " that Contributor with its Contributor Version (or portions of such combination)"
        + ". (c) the licenses granted in Sections 2.2(a) and 2.2(b) are effective on the "
        + "date Contributor first makes Commercial Use of the Covered Code. (d)    Notwit"
        + "hstanding Section 2.2(b) above, no patent license is granted: 1) for any code th"
        + "at Contributor has deleted from the Contributor Version; 2)  separate from the C"
        + "ontributor Version;  3)  for infringements caused by: i) third party modificatio"
        + "ns of Contributor Version or ii)  the combination of Modifications made by that "
        + "Contributor with other software  (except as part of the Contributor Version) or "
        + "other devices; or 4) under Patent Claims infringed by Covered Code in the absenc"
        + "e of Modifications made by that Contributor.\n"
        + " 3. Distribution Obligations.\n"
        + "3.1. Application of License. \n"
        + "The Modifications which You create or to which You contribute are governed by t"
        + "he terms of this License, including without limitation Section 2.2. The Source C"
        + "ode version of Covered Code may be distributed only under the terms of this Lice"
        + "nse or a future version of this License released under Section 6.1, and You must"
        + " include a copy of this License with every copy of the Source Code You distribut"
        + "e. You may not offer or impose any terms on any Source Code version that alters "
        + "or restricts the applicable version of this License or the recipients' rights he"
        + "reunder. However, You may include an additional document offering the additional"
        + " rights described in Section 3.5.\n"
        + "\n"
        + "3.2. Availability of Source Code.  Any Modification which You create or to whi"
        + "ch You contribute must be made available in Source Code form under the terms of "
        + "this License either on the same media as an Executable version or via an accepte"
        + "d Electronic Distribution Mechanism to anyone to whom you made an Executable ver"
        + "sion available; and if made available via Electronic Distribution Mechanism, mus"
        + "t remain available for at least twelve (12) months after the date it initially b"
        + "ecame available, or at least six (6) months after a subsequent version of that p"
        + "articular Modification has been made available to such recipients. You are respo"
        + "nsible for ensuring that the Source Code version remains available even if the E"
        + "lectronic Distribution Mechanism is maintained by a third party. \n"
        + "3.3. Description of Modifications.  You must cause all Covered Code to which Y"
        + "ou contribute to contain a file documenting the changes You made to create that "
        + "Covered Code and the date of any change. You must include a prominent statement "
        + "that the Modification is derived, directly or indirectly, from Original Code pro"
        + "vided by the Initial Developer and including the name of the Initial Developer i"
        + "n (a) the Source Code, and (b) in any notice in an Executable version or related"
        + " documentation in which You describe the origin or ownership of the Covered Code"
        + ". \n"
        + "3.4. Intellectual Property Matters\n"
        + "(a) Third Party Claims. \n"
        + "If Contributor has knowledge that a license under a third party's intellectual"
        + " property rights is required to exercise the rights granted by such Contributor "
        + "under Sections 2.1 or 2.2, Contributor must include a text file with the Source "
        + "Code distribution titled \"LEGAL\" which describes the claim and the party making "
        + "the claim in sufficient detail that a recipient will know whom to contact. If Co"
        + "ntributor obtains such knowledge after the Modification is made available as des"
        + "cribed in Section 3.2, Contributor shall promptly modify the LEGAL file in all c"
        + "opies Contributor makes available thereafter and shall take other steps (such as"
        + " notifying appropriate mailing lists or newsgroups) reasonably calculated to inf"
        + "orm those who received the Covered Code that new knowledge has been obtained.\n"
        + "(b) Contributor APIs.  If Contributor's Modifications include an application"
        + " programming interface and Contributor has knowledge of patent licenses which ar"
        + "e reasonably necessary to implement that API, Contributor must also include this"
        + " information in the LEGAL file.   (c)    Representations.\n"
        + "Contributor represents that, except as disclosed pursuant to Section 3.4(a) ab"
        + "ove, Contributor believes that Contributor's Modifications are Contributor's ori"
        + "ginal creation(s) and/or Contributor has sufficient rights to grant the rights c"
        + "onveyed by this License.\n"
        + " 3.5. Required Notices.  You must duplicate the notice in Exhibit A in each "
        + "file of the Source Code.  If it is not possible to put such notice in a particul"
        + "ar Source Code file due to its structure, then You must include such notice in a"
        + " location (such as a relevant directory) where a user would be likely to look fo"
        + "r such a notice.  If You created one or more Modification(s) You may add your na"
        + "me as a Contributor to the notice described in Exhibit A.  You must also duplica"
        + "te this License in any documentation for the Source Code where You describe reci"
        + "pients' rights or ownership rights relating to Covered Code.  You may choose to "
        + "offer, and to charge a fee for, warranty, support, indemnity or liability obliga"
        + "tions to one or more recipients of Covered Code. However, You may do so only on "
        + "Your own behalf, and not on behalf of the Initial Developer or any Contributor. "
        + "You must make it absolutely clear than any such warranty, support, indemnity or "
        + "liability obligation is offered by You alone, and You hereby agree to indemnify "
        + "the Initial Developer and every Contributor for any liability incurred by the In"
        + "itial Developer or such Contributor as a result of warranty, support, indemnity "
        + "or liability terms You offer. \n"
        + "3.6. Distribution of Executable Versions.  You may distribute Covered Code in "
        + "Executable form only if the requirements of Section 3.1-3.5 have been met for th"
        + "at Covered Code, and if You include a notice stating that the Source Code versio"
        + "n of the Covered Code is available under the terms of this License, including a "
        + "description of how and where You have fulfilled the obligations of Section 3.2. "
        + "The notice must be conspicuously included in any notice in an Executable version"
        + ", related documentation or collateral in which You describe recipients' rights r"
        + "elating to the Covered Code. You may distribute the Executable version of Covere"
        + "d Code or ownership rights under a license of Your choice, which may contain ter"
        + "ms different from this License, provided that You are in compliance with the ter"
        + "ms of this License and that the license for the Executable version does not atte"
        + "mpt to limit or alter the recipient's rights in the Source Code version from the"
        + " rights set forth in this License. If You distribute the Executable version unde"
        + "r a different license You must make it absolutely clear that any terms which dif"
        + "fer from this License are offered by You alone, not by the Initial Developer or "
        + "any Contributor. You hereby agree to indemnify the Initial Developer and every C"
        + "ontributor for any liability incurred by the Initial Developer or such Contribut"
        + "or as a result of any such terms You offer. \n"
        + "3.7. Larger Works.  You may create a Larger Work by combining Covered Code wit"
        + "h other code not governed by the terms of this License and distribute the Larger"
        + " Work as a single product. In such a case, You must make sure the requirements o"
        + "f this License are fulfilled for the Covered Code.\n"
        + "\n"
        + "4. Inability to Comply Due to Statute or Regulation.\n"
        + "If it is impossible for You to comply with any of the terms of this License with"
        + " respect to some or all of the Covered Code due to statute, judicial order, or r"
        + "egulation then You must: (a) comply with the terms of this License to the maximu"
        + "m extent possible; and (b) describe the limitations and the code they affect. Su"
        + "ch description must be included in the LEGAL file described in Section 3.4 and m"
        + "ust be included with all distributions of the Source Code. Except to the extent "
        + "prohibited by statute or regulation, such description must be sufficiently detai"
        + "led for a recipient of ordinary skill to be able to understand it.\n"
        + "\n"
        + "5. Application of this License.\n"
        + "This License applies to code to which the Initial Developer has attached the not"
        + "ice in Exhibit A and to related Covered Code.\n"
        + "\n"
        + "6. Versions of the License.\n"
        + "6.1. New Versions. \n"
        + "Netscape Communications Corporation (\"Netscape\") may publish revised and/or new"
        + " versions of the License from time to time. Each version will be given a disting"
        + "uishing version number.\n"
        + "\n"
        + "6.2. Effect of New Versions.  Once Covered Code has been published under a par"
        + "ticular version of the License, You may always continue to use it under the term"
        + "s of that version. You may also choose to use such Covered Code under the terms "
        + "of any subsequent version of the License published by Netscape. No one other tha"
        + "n Netscape has the right to modify the terms applicable to Covered Code created "
        + "under this License. \n"
        + "6.3. Derivative Works.  If You create or use a modified version of this Licens"
        + "e (which you may only do in order to apply it to code which is not already Cover"
        + "ed Code governed by this License), You must (a) rename Your license so that the "
        + "phrases \"Mozilla\", \"MOZILLAPL\", \"MOZPL\", \"Netscape\", \"MPL\", \"NPL\" or any confusi"
        + "ngly similar phrase do not appear in your license (except to note that your lice"
        + "nse differs from this License) and (b) otherwise make it clear that Your version"
        + " of the license contains terms which differ from the Mozilla Public License and "
        + "Netscape Public License. (Filling in the name of the Initial Developer, Original"
        + " Code or Contributor in the notice described in Exhibit A shall not of themselve"
        + "s be deemed to be modifications of this License.)\n"
        + "\n"
        + "7. DISCLAIMER OF WARRANTY.\n"
        + "COVERED CODE IS PROVIDED UNDER THIS LICENSE ON AN \"AS IS\" BASIS, WITHOUT WARRANT"
        + "Y OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRA"
        + "NTIES THAT THE COVERED CODE IS FREE OF DEFECTS, MERCHANTABLE, FIT FOR A PARTICUL"
        + "AR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE "
        + "OF THE COVERED CODE IS WITH YOU. SHOULD ANY COVERED CODE PROVE DEFECTIVE IN ANY "
        + "RESPECT, YOU (NOT THE INITIAL DEVELOPER OR ANY OTHER CONTRIBUTOR) ASSUME THE COS"
        + "T OF ANY NECESSARY SERVICING, REPAIR OR CORRECTION. THIS DISCLAIMER OF WARRANTY "
        + "CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE. NO USE OF ANY COVERED CODE IS AUT"
        + "HORIZED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "8. TERMINATION.\n"
        + "8.1.  This License and the rights granted hereunder will terminate automaticall"
        + "y if You fail to comply with terms herein and fail to cure such breach within 30"
        + " days of becoming aware of the breach. All sublicenses to the Covered Code which"
        + " are properly granted shall survive any termination of this License. Provisions "
        + "which, by their nature, must remain in effect beyond the termination of this Lic"
        + "ense shall survive.\n"
        + "\n"
        + "8.2.  If You initiate litigation by asserting a patent infringement claim (excl"
        + "uding declatory judgment actions) against Initial Developer or a Contributor (th"
        + "e Initial Developer or Contributor against whom You file such action is referred"
        + " to as \"Participant\")  alleging that: (a)  such Participant's Contributor Vers"
        + "ion directly or indirectly infringes any patent, then any and all rights granted"
        + " by such Participant to You under Sections 2.1 and/or 2.2 of this License shall,"
        + " upon 60 days notice from Participant terminate prospectively, unless if within "
        + "60 days after receipt of notice You either: (i)  agree in writing to pay Partici"
        + "pant a mutually agreeable reasonable royalty for Your past and future use of Mod"
        + "ifications made by such Participant, or (ii) withdraw Your litigation claim with"
        + " respect to the Contributor Version against such Participant.  If within 60 days"
        + " of notice, a reasonable royalty and payment arrangement are not mutually agreed"
        + " upon in writing by the parties or the litigation claim is not withdrawn, the ri"
        + "ghts granted by Participant to You under Sections 2.1 and/or 2.2 automatically t"
        + "erminate at the expiration of the 60 day notice period specified above. (b)  a"
        + "ny software, hardware, or device, other than such Participant's Contributor Vers"
        + "ion, directly or indirectly infringes any patent, then any rights granted to You"
        + " by such Participant under Sections 2.1(b) and 2.2(b) are revoked effective as o"
        + "f the date You first made, used, sold, distributed, or had made, Modifications m"
        + "ade by that Participant. \n"
        + "8.3.  If You assert a patent infringement claim against Participant alleging th"
        + "at such Participant's Contributor Version directly or indirectly infringes any p"
        + "atent where such claim is resolved (such as by license or settlement) prior to t"
        + "he initiation of patent infringement litigation, then the reasonable value of th"
        + "e licenses granted by such Participant under Sections 2.1 or 2.2 shall be taken "
        + "into account in determining the amount or value of any payment or license. \n"
        + "8.4.  In the event of termination under Sections 8.1 or 8.2 above,  all end use"
        + "r license agreements (excluding distributors and resellers) which have been vali"
        + "dly granted by You or any distributor hereunder prior to termination shall survi"
        + "ve termination.\n"
        + "\n"
        + "9. LIMITATION OF LIABILITY.\n"
        + "UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL THEORY, WHETHER TORT (INCLUDING NEGLIG"
        + "ENCE), CONTRACT, OR OTHERWISE, SHALL YOU, THE INITIAL DEVELOPER, ANY OTHER CONTR"
        + "IBUTOR, OR ANY DISTRIBUTOR OF COVERED CODE, OR ANY SUPPLIER OF ANY OF SUCH PARTI"
        + "ES, BE LIABLE TO ANY PERSON FOR ANY INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENT"
        + "IAL DAMAGES OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF "
        + "GOODWILL, WORK STOPPAGE, COMPUTER FAILURE OR MALFUNCTION, OR ANY AND ALL OTHER C"
        + "OMMERCIAL DAMAGES OR LOSSES, EVEN IF SUCH PARTY SHALL HAVE BEEN INFORMED OF THE "
        + "POSSIBILITY OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SHALL NOT APPLY TO LIA"
        + "BILITY FOR DEATH OR PERSONAL INJURY RESULTING FROM SUCH PARTY'S NEGLIGENCE TO TH"
        + "E EXTENT APPLICABLE LAW PROHIBITS SUCH LIMITATION. SOME JURISDICTIONS DO NOT ALL"
        + "OW THE EXCLUSION OR LIMITATION OF INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO THIS E"
        + "XCLUSION AND LIMITATION MAY NOT APPLY TO YOU.\n"
        + "\n"
        + "10. U.S. GOVERNMENT END USERS.\n"
        + "The Covered Code is a \"commercial item,\" as that term is defined in 48 C.F.R. 2."
        + "101 (Oct. 1995), consisting of \"commercial computer software\" and \"commercial co"
        + "mputer software documentation,\" as such terms are used in 48 C.F.R. 12.212 (Sept"
        + ". 1995). Consistent with 48 C.F.R. 12.212 and 48 C.F.R. 227.7202-1 through 227.7"
        + "202-4 (June 1995), all U.S. Government End Users acquire Covered Code with only "
        + "those rights set forth herein.\n"
        + "\n"
        + "11. MISCELLANEOUS.\n"
        + "This License represents the complete agreement concerning subject matter hereof."
        + " If any provision of this License is held to be unenforceable, such provision sh"
        + "all be reformed only to the extent necessary to make it enforceable. This Licens"
        + "e shall be governed by California law provisions (except to the extent applicabl"
        + "e law, if any, provides otherwise), excluding its conflict-of-law provisions. Wi"
        + "th respect to disputes in which at least one party is a citizen of, or an entity"
        + " chartered or registered to do business in the United States of America, any lit"
        + "igation relating to this License shall be subject to the jurisdiction of the Fed"
        + "eral Courts of the Northern District of California, with venue lying in Santa Cl"
        + "ara County, California, with the losing party responsible for costs, including w"
        + "ithout limitation, court costs and reasonable attorneys' fees and expenses. The "
        + "application of the United Nations Convention on Contracts for the International "
        + "Sale of Goods is expressly excluded. Any law or regulation which provides that t"
        + "he language of a contract shall be construed against the drafter shall not apply"
        + " to this License.\n"
        + "\n"
        + "12. RESPONSIBILITY FOR CLAIMS.\n"
        + "As between Initial Developer and the Contributors, each party is responsible for"
        + " claims and damages arising, directly or indirectly, out of its utilization of r"
        + "ights under this License and You agree to work with Initial Developer and Contri"
        + "butors to distribute such responsibility on an equitable basis. Nothing herein i"
        + "s intended or shall be deemed to constitute any admission of liability.\n"
        + "\n"
        + "13. MULTIPLE-LICENSED CODE.\n"
        + "Initial Developer may designate portions of the Covered Code as \"Multiple-Licens"
        + "ed\".  \"Multiple-Licensed\" means that the Initial Developer permits you to utiliz"
        + "e portions of the Covered Code under Your choice of the NPL or the alternative l"
        + "icenses, if any, specified by the Initial Developer in the file described in Exh"
        + "ibit A.\n"
        + " EXHIBIT A -Mozilla Public License.\n"
        + "\"The contents of this file are subject to the Mozilla Public License Version 1.1"
        + " (the \"License\"); you may not use this file except in compliance with the Licens"
        + "e. You may obtain a copy of the License at http://www.mozilla.org/MPL/\n"
        + "\n"
        + "Software distributed under the License is distributed on an \"AS IS\" basis, WITHO"
        + "UT WARRANTY OF  ANY KIND, either express or implied. See the License for the spe"
        + "cific language governing rights and  limitations under the License. \n"
        + "The Original Code is ______________________________________. \n"
        + "The Initial Developer of the Original Code is ________________________. Portions"
        + " created by   ______________________ are Copyright (C) ______ __________________"
        + "_____. All Rights  Reserved. \n"
        + "Contributor(s): ______________________________________. \n"
        + "Alternatively, the contents of this file may be used under the terms of the ____"
        + "_ license (the  \"[___] License\"), in which case the provisions of [______] Licen"
        + "se are applicable  instead of those above.  If you wish to allow use of your ver"
        + "sion of this file only under the terms of the [____] License and not to allow ot"
        + "hers to use your version of this file under the MPL, indicate your decision by d"
        + "eleting  the provisions above and replace  them with the notice and other provis"
        + "ions required by the [___] License.  If you do not delete the provisions above, "
        + "a recipient may use your version of this file under either the MPL or the [___] "
        + "License.\" \n"
        + "[NOTE: The text of this Exhibit A may differ slightly from the text of the notic"
        + "es in the Source Code files of the Original Code. You should use the text of thi"
        + "s Exhibit A rather than the text found in the Original Code Source Code for Your"
        + " Modifications.]\n"
; // the license text
    }
 
    
}
