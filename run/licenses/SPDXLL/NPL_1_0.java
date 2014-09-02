package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:19Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: NPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class NPL_1_0 extends License{
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
        return "NPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Netscape Public License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "NETSCAPE PUBLIC LICENSE Version 1.0\n"
        + "\n"
        + "1. Definitions.\n"
        + "1.1. ``Contributor'' means each entity that creates or contributes to the creat"
        + "ion of Modifications.\n"
        + "1.2. ``Contributor Version'' means the combination of the Original Code, prior "
        + "Modifications used by a Contributor, and the Modifications made by that particul"
        + "ar Contributor. 1.3. ``Covered Code'' means the Original Code or Modifications "
        + "or the combination of the Original Code and Modifications, in each case includin"
        + "g portions thereof. 1.4. ``Electronic Distribution Mechanism'' means a mechanis"
        + "m generally accepted in the software development community for the electronic tr"
        + "ansfer of data. 1.5. ``Executable'' means Covered Code in any form other than S"
        + "ource Code. 1.6. ``Initial Developer'' means the individual or entity identifie"
        + "d as the Initial Developer in the Source Code notice required byExhibit A. 1.7."
        + " ``Larger Work'' means a work which combines Covered Code or portions thereof wi"
        + "th code not governed by the terms of this License. 1.8. ``License'' means this "
        + "document. 1.9. ``Modifications'' means any addition to or deletion from the sub"
        + "stance or structure of either the Original Code or any previous Modifications. W"
        + "hen Covered Code is released as a series of files, a Modification is:\n"
        + "A. Any addition to or deletion from the contents of a file containing Original"
        + " Code or previous Modifications. B. Any new file that contains any part of the"
        + " Original Code or previous Modifications.\n"
        + "1.10. ``Original Code'' means Source Code of computer software code which is de"
        + "scribed in the Source Code notice required byExhibit A as Original Code, and whi"
        + "ch, at the time of its release under this License is not already Covered Code go"
        + "verned by this License. 1.11. ``Source Code'' means the preferred form of the C"
        + "overed Code for making modifications to it, including all modules it contains, p"
        + "lus any associated interface definition files, scripts used to control compilati"
        + "on and installation of an Executable, or a list of source code differential comp"
        + "arisons against either the Original Code or another well known, available Covere"
        + "d Code of the Contributor's choice. The Source Code can be in a compressed or ar"
        + "chival form, provided the appropriate decompression or de-archiving software is "
        + "widely available for no charge. 1.12. ``You'' means an individual or a legal en"
        + "tity exercising rights under, and complying with all of the terms of, this Licen"
        + "se or a future version of this License issued under Section 6.1. For legal entit"
        + "ies, ``You'' includes any entity which controls, is controlled by, or is under c"
        + "ommon control with You. For purposes of this definition, ``control'' means (a) t"
        + "he power, direct or indirect, to cause the direction or management of such entit"
        + "y, whether by contract or otherwise, or (b) ownership of fifty percent (50%) or "
        + "more of the outstanding shares or beneficial ownership of such entity.\n"
        + "\n"
        + "2. Source Code License.\n"
        + "2.1. The Initial Developer Grant. The Initial Developer hereby grants You a wor"
        + "ld-wide, royalty-free, non-exclusive license, subject to third party intellectua"
        + "l property claims:\n"
        + "a) to use, reproduce, modify, display, perform, sublicense and distribute the "
        + "Original Code (or portions thereof) with or without Modifications, or as part of"
        + " a Larger Work; and (b) under patents now or hereafter owned or controlled by "
        + "Initial Developer, to make, have made, use and sell (``Utilize'') the Original C"
        + "ode (or portions thereof), but solely to the extent that any such patent is reas"
        + "onably necessary to enable You to Utilize the Original Code (or portions thereof"
        + ") and not to any greater extent that may be necessary to Utilize further Modific"
        + "ations or combinations.\n"
        + "2.2. Contributor Grant.  Each Contributor hereby grants You a world-wide, royal"
        + "ty-free, non-exclusive license, subject to third party intellectual property cla"
        + "ims:\n"
        + "(a) to use, reproduce, modify, display, perform, sublicense and distribute the"
        + " Modifications created by such Contributor (or portions thereof) either on an un"
        + "modified basis, with other Modifications, as Covered Code or as part of a Larger"
        + " Work; and (b) under patents now or hereafter owned or controlled by Contribut"
        + "or, to Utilize the Contributor Version (or portions thereof), but solely to the "
        + "extent that any such patent is reasonably necessary to enable You to Utilize the"
        + " Contributor Version (or portions thereof), and not to any greater extent that m"
        + "ay be necessary to Utilize further Modifications or combinations.\n"
        + "\n"
        + "3. Distribution Obligations.\n"
        + "3.1. Application of License. The Modifications which You create or to which You"
        + " contribute are governed by the terms of this License, including without limitat"
        + "ion Section 2.2. The Source Code version of Covered Code may be distributed only"
        + " under the terms of this License or a future version of this License released un"
        + "der Section 6.1, and You must include a copy of this License with every copy of "
        + "the Source Code You distribute. You may not offer or impose any terms on any Sou"
        + "rce Code version that alters or restricts the applicable version of this License"
        + " or the recipients' rights hereunder. However, You may include an additional doc"
        + "ument offering the additional rights described in Section 3.5.\n"
        + "\n"
        + "3.2. Availability of Source Code. Any Modification which You create or to which"
        + " You contribute must be made available in Source Code form under the terms of th"
        + "is License either on the same media as an Executable version or via an accepted "
        + "Electronic Distribution Mechanism to anyone to whom you made an Executable versi"
        + "on available; and if made available via Electronic Distribution Mechanism, must "
        + "remain available for at least twelve (12) months after the date it initially bec"
        + "ame available, or at least six (6) months after a subsequent version of that par"
        + "ticular Modification has been made available to such recipients. You are respons"
        + "ible for ensuring that the Source Code version remains available even if the Ele"
        + "ctronic Distribution Mechanism is maintained by a third party. \n"
        + "3.3. Description of Modifications. You must cause all Covered Code to which you"
        + " contribute to contain a file documenting the changes You made to create that Co"
        + "vered Code and the date of any change. You must include a prominent statement th"
        + "at the Modification is derived, directly or indirectly, from Original Code provi"
        + "ded by the Initial Developer and including the name of the Initial Developer in "
        + "(a) the Source Code, and (b) in any notice in an Executable version or related d"
        + "ocumentation in which You describe the origin or ownership of the Covered Code. \n"
        + "3.4. Intellectual Property Matters\n"
        + "(a) Third Party Claims. If You have knowledge that a party claims an intellect"
        + "ual property right in particular functionality or code (or its utilization under"
        + " this License), you must include a text file with the source code distribution t"
        + "itled ``LEGAL'' which describes the claim and the party making the claim in suff"
        + "icient detail that a recipient will know whom to contact. If you obtain such kno"
        + "wledge after You make Your Modification available as described in Section 3.2, Y"
        + "ou shall promptly modify the LEGAL file in all copies You make available thereaf"
        + "ter and shall take other steps (such as notifying appropriate mailing lists or n"
        + "ewsgroups) reasonably calculated to inform those who received the Covered Code t"
        + "hat new knowledge has been obtained. (b) Contributor APIs. If Your Modification"
        + " is an application programming interface and You own or control patents which ar"
        + "e reasonably necessary to implement that API, you must also include this informa"
        + "tion in the LEGAL file.\n"
        + "\n"
        + "3.5. Required Notices. You must duplicate the notice in Exhibit A in each file "
        + "of the Source Code, and this License in any documentation for the Source Code, w"
        + "here You describe recipients' rights relating to Covered Code. If You created on"
        + "e or more Modification(s), You may add your name as a Contributor to the notice "
        + "described in Exhibit A. If it is not possible to put such notice in a particular"
        + " Source Code file due to its structure, then you must include such notice in a l"
        + "ocation (such as a relevant directory file) where a user would be likely to look"
        + " for such a notice. You may choose to offer, and to charge a fee for, warranty, "
        + "support, indemnity or liability obligations to one or more recipients of Covered"
        + " Code. However, You may do so only on Your own behalf, and not on behalf of the "
        + "Initial Developer or any Contributor. You must make it absolutely clear than any"
        + " such warranty, support, indemnity or liability obligation is offered by You alo"
        + "ne, and You hereby agree to indemnify the Initial Developer and every Contributo"
        + "r for any liability incurred by the Initial Developer or such Contributor as a r"
        + "esult of warranty, support, indemnity or liability terms You offer. \n"
        + "3.6. Distribution of Executable Versions. You may distribute Covered Code in Ex"
        + "ecutable form only if the requirements of Section 3.1-3.5 have been met for that"
        + " Covered Code, and if You include a notice stating that the Source Code version "
        + "of the Covered Code is available under the terms of this License, including a de"
        + "scription of how and where You have fulfilled the obligations of Section 3.2. Th"
        + "e notice must be conspicuously included in any notice in an Executable version, "
        + "related documentation or collateral in which You describe recipients' rights rel"
        + "ating to the Covered Code. You may distribute the Executable version of Covered "
        + "Code under a license of Your choice, which may contain terms different from this"
        + " License, provided that You are in compliance with the terms of this License and"
        + " that the license for the Executable version does not attempt to limit or alter "
        + "the recipient's rights in the Source Code version from the rights set forth in t"
        + "his License. If You distribute the Executable version under a different license "
        + "You must make it absolutely clear that any terms which differ from this License "
        + "are offered by You alone, not by the Initial Developer or any Contributor. You h"
        + "ereby agree to indemnify the Initial Developer and every Contributor for any lia"
        + "bility incurred by the Initial Developer or such Contributor as a result of any "
        + "such terms You offer. \n"
        + "3.7. Larger Works. You may create a Larger Work by combining Covered Code with "
        + "other code not governed by the terms of this License and distribute the Larger W"
        + "ork as a single product. In such a case, You must make sure the requirements of "
        + "this License are fulfilled for the Covered Code.\n"
        + "\n"
        + "4. Inability to Comply Due to Statute or Regulation.\n"
        + "If it is impossible for You to comply with any of the terms of this License with"
        + " respect to some or all of the Covered Code due to statute or regulation then Yo"
        + "u must: (a) comply with the terms of this License to the maximum extent possible"
        + "; and (b) describe the limitations and the code they affect. Such description mu"
        + "st be included in the LEGAL file described in Section 3.4 and must be included w"
        + "ith all distributions of the Source Code. Except to the extent prohibited by sta"
        + "tute or regulation, such description must be sufficiently detailed for a recipie"
        + "nt of ordinary skill to be able to understand it.\n"
        + "\n"
        + "5. Application of this License.\n"
        + "This License applies to code to which the Initial Developer has attached the not"
        + "ice in Exhibit A, and to related Covered Code.\n"
        + "\n"
        + "6. Versions of the License.\n"
        + "6.1. New Versions. Netscape Communications Corporation (``Netscape'') may publi"
        + "sh revised and/or new versions of the License from time to time. Each version wi"
        + "ll be given a distinguishing version number.\n"
        + "\n"
        + "6.2. Effect of New Versions.  Once Covered Code has been published under a part"
        + "icular version of the License, You may always continue to use it under the terms"
        + " of that version. You may also choose to use such Covered Code under the terms o"
        + "f any subsequent version of the License published by Netscape. No one other than"
        + " Netscape has the right to modify the terms applicable to Covered Code created u"
        + "nder this License. \n"
        + "6.3. Derivative Works. If you create or use a modified version of this License "
        + "(which you may only do in order to apply it to code which is not already Covered"
        + " Code governed by this License), you must (a) rename Your license so that the ph"
        + "rases ``Mozilla'', ``MOZILLAPL'', ``MOZPL'', ``Netscape'', ``NPL'' or any confus"
        + "ingly similar phrase do not appear anywhere in your license and (b) otherwise ma"
        + "ke it clear that your version of the license contains terms which differ from th"
        + "e Mozilla Public License and Netscape Public License. (Filling in the name of th"
        + "e Initial Developer, Original Code or Contributor in the notice described in Exh"
        + "ibit A shall not of themselves be deemed to be modifications of this License.)\n"
        + "\n"
        + "7. DISCLAIMER OF WARRANTY.\n"
        + "COVERED CODE IS PROVIDED UNDER THIS LICENSE ON AN ``AS IS'' BASIS, WITHOUT WARRA"
        + "NTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WAR"
        + "RANTIES THAT THE COVERED CODE IS FREE OF DEFECTS, MERCHANTABLE, FIT FOR A PARTIC"
        + "ULAR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANC"
        + "E OF THE COVERED CODE IS WITH YOU. SHOULD ANY COVERED CODE PROVE DEFECTIVE IN AN"
        + "Y RESPECT, YOU (NOT THE INITIAL DEVELOPER OR ANY OTHER CONTRIBUTOR) ASSUME THE C"
        + "OST OF ANY NECESSARY SERVICING, REPAIR OR CORRECTION. THIS DISCLAIMER OF WARRANT"
        + "Y CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE. NO USE OF ANY COVERED CODE IS A"
        + "UTHORIZED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "8. TERMINATION.\n"
        + "This License and the rights granted hereunder will terminate automatically if Yo"
        + "u fail to comply with terms herein and fail to cure such breach within 30 days o"
        + "f becoming aware of the breach. All sublicenses to the Covered Code which are pr"
        + "operly granted shall survive any termination of this License. Provisions which, "
        + "by their nature, must remain in effect beyond the termination of this License sh"
        + "all survive.\n"
        + "\n"
        + "9. LIMITATION OF LIABILITY.\n"
        + "UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL THEORY, WHETHER TORT (INCLUDING NEGLIG"
        + "ENCE), CONTRACT, OR OTHERWISE, SHALL THE INITIAL DEVELOPER, ANY OTHER CONTRIBUTO"
        + "R, OR ANY DISTRIBUTOR OF COVERED CODE, OR ANY SUPPLIER OF ANY OF SUCH PARTIES, B"
        + "E LIABLE TO YOU OR ANY OTHER PERSON FOR ANY INDIRECT, SPECIAL, INCIDENTAL, OR CO"
        + "NSEQUENTIAL DAMAGES OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, DAMAGES FOR "
        + "LOSS OF GOODWILL, WORK STOPPAGE, COMPUTER FAILURE OR MALFUNCTION, OR ANY AND ALL"
        + " OTHER COMMERCIAL DAMAGES OR LOSSES, EVEN IF SUCH PARTY SHALL HAVE BEEN INFORMED"
        + " OF THE POSSIBILITY OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SHALL NOT APPL"
        + "Y TO LIABILITY FOR DEATH OR PERSONAL INJURY RESULTING FROM SUCH PARTY'S NEGLIGEN"
        + "CE TO THE EXTENT APPLICABLE LAW PROHIBITS SUCH LIMITATION. SOME JURISDICTIONS DO"
        + " NOT ALLOW THE EXCLUSION OR LIMITATION OF INCIDENTAL OR CONSEQUENTIAL DAMAGES, S"
        + "O THAT EXCLUSION AND LIMITATION MAY NOT APPLY TO YOU.\n"
        + "\n"
        + "10. U.S. GOVERNMENT END USERS.\n"
        + "The Covered Code is a ``commercial item,'' as that term is defined in 48 C.F.R. "
        + "2.101 (Oct. 1995), consisting of ``commercial computer software'' and ``commerci"
        + "al computer software documentation,'' as such terms are used in 48 C.F.R. 12.212"
        + " (Sept. 1995). Consistent with 48 C.F.R. 12.212 and 48 C.F.R. 227.7202-1 through"
        + " 227.7202-4 (June 1995), all U.S. Government End Users acquire Covered Code with"
        + " only those rights set forth herein.\n"
        + "\n"
        + "11. MISCELLANEOUS.\n"
        + "This License represents the complete agreement concerning subject matter hereof."
        + " If any provision of this License is held to be unenforceable, such provision sh"
        + "all be reformed only to the extent necessary to make it enforceable. This Licens"
        + "e shall be governed by California law provisions (except to the extent applicabl"
        + "e law, if any, provides otherwise), excluding its conflict-of-law provisions. Wi"
        + "th respect to disputes in which at least one party is a citizen of, or an entity"
        + " chartered or registered to do business in, the United States of America: (a) un"
        + "less otherwise agreed in writing, all disputes relating to this License (excepti"
        + "ng any dispute relating to intellectual property rights) shall be subject to fin"
        + "al and binding arbitration, with the losing party paying all costs of arbitratio"
        + "n; (b) any arbitration relating to this Agreement shall be held in Santa Clara C"
        + "ounty, California, under the auspices of JAMS/EndDispute; and (c) any litigation"
        + " relating to this Agreement shall be subject to the jurisdiction of the Federal "
        + "Courts of the Northern District of California, with venue lying in Santa Clara C"
        + "ounty, California, with the losing party responsible for costs, including withou"
        + "t limitation, court costs and reasonable attorneys fees and expenses. The applic"
        + "ation of the United Nations Convention on Contracts for the International Sale o"
        + "f Goods is expressly excluded. Any law or regulation which provides that the lan"
        + "guage of a contract shall be construed against the drafter shall not apply to th"
        + "is License.\n"
        + "\n"
        + "12. RESPONSIBILITY FOR CLAIMS.\n"
        + "Except in cases where another Contributor has failed to comply with Section 3.4,"
        + " You are responsible for damages arising, directly or indirectly, out of Your ut"
        + "ilization of rights under this License, based on the number of copies of Covered"
        + " Code you made available, the revenues you received from utilizing such rights, "
        + "and other relevant factors. You agree to work with affected parties to distribut"
        + "e responsibility on an equitable basis.\n"
        + "A\n"
        + "MENDMENTS\n"
        + "Additional Terms applicable to the Netscape Public License.\n"
        + "I. Effect.  These additional terms described in this Netscape Public License -- "
        + "Amendments shall apply to the Mozilla Communicator client code and to all Covere"
        + "d Code under this License. \n"
        + "II. ``Netscape's Branded Code'' means Covered Code that Netscape distributes and"
        + "/or permits others to distribute under one or more trademark(s) which are contro"
        + "lled by Netscape but which are not licensed for use under this License. \n"
        + "III. Netscape and logo.  This License does not grant any rights to use the trade"
        + "mark ``Netscape'', the ``Netscape N and horizon'' logo or the Netscape lighthous"
        + "e logo, even if such marks are included in the Original Code. \n"
        + "IV. Inability to Comply Due to Contractual Obligation.  Prior to licensing the O"
        + "riginal Code under this License, Netscape has licensed third party code for use "
        + "in Netscape's Branded Code. To the extent that Netscape is limited contractually"
        + " from making such third party code available under this License, Netscape may ch"
        + "oose to reintegrate such code into Covered Code without being required to distri"
        + "bute such code in \n"
        + "Source Code form, even if such code would otherwise be considered ``Modification"
        + "s'' under this License. \n"
        + "V. Use of Modifications and Covered Code by Initial Developer.\n"
        + "V.1. In General. The obligations of Section 3 apply to Netscape, except to the "
        + "extent specified in this Amendment, Section V.2 and V.3. V.2. Other Products. N"
        + "etscape may include Covered Code in products other than the Netscape's Branded C"
        + "ode which are released by Netscape during the two (2) years following the releas"
        + "e date of the Original Code, without such additional products becoming subject t"
        + "o the terms of this License, and may license such additional products on differe"
        + "nt terms from those contained in this License. V.3. Alternative Licensing. Nets"
        + "cape may license the Source Code of Netscape's Branded Code, including Modificat"
        + "ions incorporated therein, without such additional products becoming subject to "
        + "the terms of this License, and may license such additional products on different"
        + " terms from those contained in this License.\n"
        + "\n"
        + "VI. Arbitration and Litigation.  Notwithstanding the limitations of Section 11 a"
        + "bove, the provisions regarding arbitration and litigation in Section 11(a), (b) "
        + "and (c) of the License shall apply to all disputes relating to this License.\n"
        + "\n"
        + "EXHIBIT A.\n"
        + "\n"
        + "``The contents of this file are subject to the Netscape Public License Version 1"
        + ".0 (the \"License\"); you may not use this file except in compliance with the Lice"
        + "nse. You may obtain a copy of the License at http://www.mozilla.org/NPL/Software"
        + " distributed under the License is distributed on an \"AS IS\" basis, WITHOUT WARRA"
        + "NTY OF ANY KIND, either express or implied. See the License for the specific lan"
        + "guage governing rights and limitations under the License. The Original Code is M"
        + "ozilla Communicator client code, released March 31, 1998. The Initial Developer "
        + "of the Original Code is Netscape Communications Corporation. Portions created by"
        + " Netscape are Copyright (C) 1998 Netscape Communications Corporation. All Rights"
        + " Reserved. Contributor(s): ______________________________________.''   [NOTE: Th"
        + "e text of this Exhibit A may differ slightly from the text of the notices in the"
        + " Source Code files of the Original Code. This is due to time constraints encount"
        + "ered in simultaneously finalizing the License and in preparing the Original Code"
        + " for release. You should use the text of this Exhibit A rather than the text fou"
        + "nd in the Original Code Source Code for Your Modifications.]\n"
; // the license text
    }
 
    
}
