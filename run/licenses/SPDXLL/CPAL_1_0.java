package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:31:58Z
 * LicenseName: Apache-2.0
 * FileName: CPAL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class CPAL_1_0 extends License{
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
        return "CPAL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Common Public Attribution License 1.0 "; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Common Public Attribution License Version 1.0 (CPAL)\n"
        + "\n"
        + "1. “Definitions”\n"
        + "\n"
        + "1.0.1 “Commercial Use” means distribution or otherwise making the Covered Code a"
        + "vailable to a third party.\n"
        + "\n"
        + "1.1 “Contributor” means each entity that creates or contributes to the creation "
        + "of Modifications.\n"
        + "\n"
        + "1.2 “Contributor Version” means the combination of the Original Code, prior Modi"
        + "fications used by a Contributor, and the Modifications made by that particular C"
        + "ontributor.\n"
        + "\n"
        + "1.3 “Covered Code” means the Original Code or Modifications or the combination o"
        + "f the Original Code and Modifications, in each case including portions thereof.\n"
        + "\n"
        + "1.4 “Electronic Distribution Mechanism” means a mechanism generally accepted in "
        + "the software development community for the electronic transfer of data.\n"
        + "\n"
        + "1.5 “Executable” means Covered Code in any form other than Source Code.\n"
        + "\n"
        + "1.6 “Initial Developer” means the individual or entity identified as the Initial"
        + " Developer in the Source Code notice required by Exhibit A.\n"
        + "\n"
        + "1.7 “Larger Work” means a work which combines Covered Code or portions thereof w"
        + "ith code not governed by the terms of this License.\n"
        + "\n"
        + "1.8 “License” means this document.\n"
        + "\n"
        + "1.8.1 “Licensable” means having the right to grant, to the maximum extent possib"
        + "le, whether at the time of the initial grant or subsequently acquired, any and a"
        + "ll of the rights conveyed herein.\n"
        + "\n"
        + "1.9 “Modifications” means any addition to or deletion from the substance or stru"
        + "cture of either the Original Code or any previous Modifications. When Covered Co"
        + "de is released as a series of files, a Modification is:\n"
        + "\n"
        + "A. Any addition to or deletion from the contents of a file containing Original C"
        + "ode or previous Modifications.\n"
        + "\n"
        + "B. Any new file that contains any part of the Original Code or previous Modifica"
        + "tions.\n"
        + "\n"
        + "1.10 “Original Code” means Source Code of computer software code which is descri"
        + "bed in the Source Code notice required by Exhibit A as Original Code, and which,"
        + " at the time of its release under this License is not already Covered Code gover"
        + "ned by this License.\n"
        + "\n"
        + "1.10.1 “Patent Claims” means any patent claim(s), now owned or hereafter acquire"
        + "d, including without limitation, method, process, and apparatus claims, in any p"
        + "atent Licensable by grantor.\n"
        + "\n"
        + "1.11 “Source Code” means the preferred form of the Covered Code for making modif"
        + "ications to it, including all modules it contains, plus any associated interface"
        + " definition files, scripts used to control compilation and installation of an Ex"
        + "ecutable, or source code differential comparisons against either the Original Co"
        + "de or another well known, available Covered Code of the Contributor’s choice. Th"
        + "e Source Code can be in a compressed or archival form, provided the appropriate "
        + "decompression or de-archiving software is widely available for no charge.\n"
        + "\n"
        + "1.12 “You” (or “Your”) means an individual or a legal entity exercising rights u"
        + "nder, and complying with all of the terms of, this License or a future version o"
        + "f this License issued under Section 6.1. For legal entities, “You” includes any "
        + "entity which controls, is controlled by, or is under common control with You. Fo"
        + "r purposes of this definition, “control” means (a) the power, direct or indirect"
        + ", to cause the direction or management of such entity, whether by contract or ot"
        + "herwise, or (b) ownership of more than fifty percent (50%) of the outstanding sh"
        + "ares or beneficial ownership of such entity.\n"
        + "\n"
        + "2. Source Code License.\n"
        + "\n"
        + "2.1 The Initial Developer Grant.\n"
        + "The Initial Developer hereby grants You a world-wide, royalty-free, non-exclusiv"
        + "e license, subject to third party intellectual property claims:\n"
        + "\n"
        + "(a) under intellectual property rights (other than patent or trademark) Licensab"
        + "le by Initial Developer to use, reproduce, modify, display, perform, sublicense "
        + "and distribute the Original Code (or portions thereof) with or without Modificat"
        + "ions, and/or as part of a Larger Work; and\n"
        + "\n"
        + "(b) under Patents Claims infringed by the making, using or selling of Original C"
        + "ode, to make, have made, use, practice, sell, and offer for sale, and/or otherwi"
        + "se dispose of the Original Code (or portions thereof).\n"
        + "\n"
        + "(c) the licenses granted in this Section 2.1(a) and (b) are effective on the dat"
        + "e Initial Developer first distributes Original Code under the terms of this Lice"
        + "nse.\n"
        + "\n"
        + "(d) Notwithstanding Section 2.1(b) above, no patent license is granted: 1) for c"
        + "ode that You delete from the Original Code; 2) separate from the Original Code; "
        + "or 3) for infringements caused by: i) the modification of the Original Code or i"
        + "i) the combination of the Original Code with other software or devices.\n"
        + "\n"
        + "2.2 Contributor Grant.\n"
        + "Subject to third party intellectual property claims, each Contributor hereby gra"
        + "nts You a world-wide, royalty-free, non-exclusive license\n"
        + "\n"
        + "(a) under intellectual property rights (other than patent or trademark) Licensab"
        + "le by Contributor, to use, reproduce, modify, display, perform, sublicense and d"
        + "istribute the Modifications created by such Contributor (or portions thereof) ei"
        + "ther on an unmodified basis, with other Modifications, as Covered Code and/or as"
        + " part of a Larger Work; and\n"
        + "\n"
        + "(b) under Patent Claims infringed by the making, using, or selling of Modificati"
        + "ons made by that Contributor either alone and/or in combination with its Contrib"
        + "utor Version (or portions of such combination), to make, use, sell, offer for sa"
        + "le, have made, and/or otherwise dispose of: 1) Modifications made by that Contri"
        + "butor (or portions thereof); and 2) the combination of Modifications made by tha"
        + "t Contributor with its Contributor Version (or portions of such combination).\n"
        + "\n"
        + "(c) the licenses granted in Sections 2.2(a) and 2.2(b) are effective on the date"
        + " Contributor first makes Commercial Use of the Covered Code.\n"
        + "\n"
        + "(d) Notwithstanding Section 2.2(b) above, no patent license is granted: 1) for a"
        + "ny code that Contributor has deleted from the Contributor Version; 2) separate f"
        + "rom the Contributor Version; 3) for infringements caused by: i) third party modi"
        + "fications of Contributor Version or ii) the combination of Modifications made by"
        + " that Contributor with other software (except as part of the Contributor Version"
        + ") or other devices; or 4) under Patent Claims infringed by Covered Code in the a"
        + "bsence of Modifications made by that Contributor.\n"
        + "\n"
        + "3. Distribution Obligations.\n"
        + "\n"
        + "3.1 Application of License.\n"
        + "The Modifications which You create or to which You contribute are governed by th"
        + "e terms of this License, including without limitation Section 2.2. The Source Co"
        + "de version of Covered Code may be distributed only under the terms of this Licen"
        + "se or a future version of this License released under Section 6.1, and You must "
        + "include a copy of this License with every copy of the Source Code You distribute"
        + ". You may not offer or impose any terms on any Source Code version that alters o"
        + "r restricts the applicable version of this License or the recipients’ rights her"
        + "eunder. However, You may include an additional document offering the additional "
        + "rights described in Section 3.5.\n"
        + "\n"
        + "3.2 Availability of Source Code.\n"
        + "Any Modification which You create or to which You contribute must be made availa"
        + "ble in Source Code form under the terms of this License either on the same media"
        + " as an Executable version or via an accepted Electronic Distribution Mechanism t"
        + "o anyone to whom you made an Executable version available; and if made available"
        + " via Electronic Distribution Mechanism, must remain available for at least twelv"
        + "e (12) months after the date it initially became available, or at least six (6) "
        + "months after a subsequent version of that particular Modification has been made "
        + "available to such recipients. You are responsible for ensuring that the Source C"
        + "ode version remains available even if the Electronic Distribution Mechanism is m"
        + "aintained by a third party.\n"
        + "\n"
        + "3.3 Description of Modifications.\n"
        + "You must cause all Covered Code to which You contribute to contain a file docume"
        + "nting the changes You made to create that Covered Code and the date of any chang"
        + "e. You must include a prominent statement that the Modification is derived, dire"
        + "ctly or indirectly, from Original Code provided by the Initial Developer and inc"
        + "luding the name of the Initial Developer in (a) the Source Code, and (b) in any "
        + "notice in an Executable version or related documentation in which You describe t"
        + "he origin or ownership of the Covered Code.\n"
        + "\n"
        + "3.4 Intellectual Property Matters\n"
        + "\n"
        + "(a) Third Party Claims.\n"
        + "If Contributor has knowledge that a license under a third party’s intellectual p"
        + "roperty rights is required to exercise the rights granted by such Contributor un"
        + "der Sections 2.1 or 2.2, Contributor must include a text file with the Source Co"
        + "de distribution titled “LEGAL” which describes the claim and the party making th"
        + "e claim in sufficient detail that a recipient will know whom to contact. If Cont"
        + "ributor obtains such knowledge after the Modification is made available as descr"
        + "ibed in Section 3.2, Contributor shall promptly modify the LEGAL file in all cop"
        + "ies Contributor makes available thereafter and shall take other steps (such as n"
        + "otifying appropriate mailing lists or newsgroups) reasonably calculated to infor"
        + "m those who received the Covered Code that new knowledge has been obtained.\n"
        + "\n"
        + "(b) Contributor APIs.\n"
        + "If Contributor’s Modifications include an application programming interface and "
        + "Contributor has knowledge of patent licenses which are reasonably necessary to i"
        + "mplement that API, Contributor must also include this information in the LEGAL f"
        + "ile.\n"
        + "\n"
        + "(c) Representations.\n"
        + "Contributor represents that, except as disclosed pursuant to Section 3.4(a) abov"
        + "e, Contributor believes that Contributor’s Modifications are Contributor’s origi"
        + "nal creation(s) and/or Contributor has sufficient rights to grant the rights con"
        + "veyed by this License.\n"
        + "\n"
        + "3.5 Required Notices.\n"
        + "You must duplicate the notice in Exhibit A in each file of the Source Code. If i"
        + "t is not possible to put such notice in a particular Source Code file due to its"
        + " structure, then You must include such notice in a location (such as a relevant "
        + "directory) where a user would be likely to look for such a notice. If You create"
        + "d one or more Modification(s) You may add your name as a Contributor to the noti"
        + "ce described in Exhibit A. You must also duplicate this License in any documenta"
        + "tion for the Source Code where You describe recipients’ rights or ownership righ"
        + "ts relating to Covered Code. You may choose to offer, and to charge a fee for, w"
        + "arranty, support, indemnity or liability obligations to one or more recipients o"
        + "f Covered Code. However, You may do so only on Your own behalf, and not on behal"
        + "f of the Initial Developer or any Contributor. You must make it absolutely clear"
        + " than any such warranty, support, indemnity or liability obligation is offered b"
        + "y You alone, and You hereby agree to indemnify the Initial Developer and every C"
        + "ontributor for any liability incurred by the Initial Developer or such Contribut"
        + "or as a result of warranty, support, indemnity or liability terms You offer.\n"
        + "\n"
        + "3.6 Distribution of Executable Versions.\n"
        + "You may distribute Covered Code in Executable form only if the requirements of S"
        + "ection 3.1-3.5 have been met for that Covered Code, and if You include a notice "
        + "stating that the Source Code version of the Covered Code is available under the "
        + "terms of this License, including a description of how and where You have fulfill"
        + "ed the obligations of Section 3.2. The notice must be conspicuously included in "
        + "any notice in an Executable version, related documentation or collateral in whic"
        + "h You describe recipients’ rights relating to the Covered Code. You may distribu"
        + "te the Executable version of Covered Code or ownership rights under a license of"
        + " Your choice, which may contain terms different from this License, provided that"
        + " You are in compliance with the terms of this License and that the license for t"
        + "he Executable version does not attempt to limit or alter the recipient’s rights "
        + "in the Source Code version from the rights set forth in this License. If You dis"
        + "tribute the Executable version under a different license You must make it absolu"
        + "tely clear that any terms which differ from this License are offered by You alon"
        + "e, not by the Initial Developer, Original Developer or any Contributor. You here"
        + "by agree to indemnify the Initial Developer, Original Developer and every Contri"
        + "butor for any liability incurred by the Initial Developer, Original Developer or"
        + " such Contributor as a result of any such terms You offer.\n"
        + "\n"
        + "3.7 Larger Works.\n"
        + "You may create a Larger Work by combining Covered Code with other code not gover"
        + "ned by the terms of this License and distribute the Larger Work as a single prod"
        + "uct. In such a case, You must make sure the requirements of this License are ful"
        + "filled for the Covered Code.\n"
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
        + "\n"
        + "6.1 New Versions.\n"
        + "Socialtext, Inc. (“Socialtext”) may publish revised and/or new versions of the L"
        + "icense from time to time. Each version will be given a distinguishing version nu"
        + "mber.\n"
        + "\n"
        + "6.2 Effect of New Versions.\n"
        + "Once Covered Code has been published under a particular version of the License, "
        + "You may always continue to use it under the terms of that version. You may also "
        + "choose to use such Covered Code under the terms of any subsequent version of the"
        + " License published by Socialtext. No one other than Socialtext has the right to "
        + "modify the terms applicable to Covered Code created under this License.\n"
        + "\n"
        + "6.3 Derivative Works.\n"
        + "If You create or use a modified version of this License (which you may only do i"
        + "n order to apply it to code which is not already Covered Code governed by this L"
        + "icense), You must (a) rename Your license so that the phrases “Socialtext”, “CPA"
        + "L” or any confusingly similar phrase do not appear in your license (except to no"
        + "te that your license differs from this License) and (b) otherwise make it clear "
        + "that Your version of the license contains terms which differ from the CPAL. (Fil"
        + "ling in the name of the Initial Developer, Original Developer, Original Code or "
        + "Contributor in the notice described in Exhibit A shall not of themselves be deem"
        + "ed to be modifications of this License.)\n"
        + "\n"
        + "7. DISCLAIMER OF WARRANTY.\n"
        + "COVERED CODE IS PROVIDED UNDER THIS LICENSE ON AN “AS IS” BASIS, WITHOUT WARRANT"
        + "Y OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRA"
        + "NTIES THAT THE COVERED CODE IS FREE OF DEFECTS, MERCHANTABLE, FIT FOR A PARTICUL"
        + "AR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE "
        + "OF THE COVERED CODE IS WITH YOU. SHOULD ANY COVERED CODE PROVE DEFECTIVE IN ANY "
        + "RESPECT, YOU (NOT THE INITIAL DEVELOPER, ORIGINAL DEVELOPER OR ANY OTHER CONTRIB"
        + "UTOR) ASSUME THE COST OF ANY NECESSARY SERVICING, REPAIR OR CORRECTION. THIS DIS"
        + "CLAIMER OF WARRANTY CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE. NO USE OF ANY"
        + " COVERED CODE IS AUTHORIZED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "8. TERMINATION.\n"
        + "\n"
        + "8.1 This License and the rights granted hereunder will terminate automatically i"
        + "f You fail to comply with terms herein and fail to cure such breach within 30 da"
        + "ys of becoming aware of the breach. All sublicenses to the Covered Code which ar"
        + "e properly granted shall survive any termination of this License. Provisions whi"
        + "ch, by their nature, must remain in effect beyond the termination of this Licens"
        + "e shall survive.\n"
        + "\n"
        + "8.2 If You initiate litigation by asserting a patent infringement claim (excludi"
        + "ng declatory judgment actions) against Initial Developer, Original Developer or "
        + "a Contributor (the Initial Developer, Original Developer or Contributor against "
        + "whom You file such action is referred to as “Participant”) alleging that:\n"
        + "\n"
        + "(a) such Participant’s Contributor Version directly or indirectly infringes any "
        + "patent, then any and all rights granted by such Participant to You under Section"
        + "s 2.1 and/or 2.2 of this License shall, upon 60 days notice from Participant ter"
        + "minate prospectively, unless if within 60 days after receipt of notice You eithe"
        + "r: (i) agree in writing to pay Participant a mutually agreeable reasonable royal"
        + "ty for Your past and future use of Modifications made by such Participant, or (i"
        + "i) withdraw Your litigation claim with respect to the Contributor Version agains"
        + "t such Participant. If within 60 days of notice, a reasonable royalty and paymen"
        + "t arrangement are not mutually agreed upon in writing by the parties or the liti"
        + "gation claim is not withdrawn, the rights granted by Participant to You under Se"
        + "ctions 2.1 and/or 2.2 automatically terminate at the expiration of the 60 day no"
        + "tice period specified above.\n"
        + "\n"
        + "(b) any software, hardware, or device, other than such Participant’s Contributor"
        + " Version, directly or indirectly infringes any patent, then any rights granted t"
        + "o You by such Participant under Sections 2.1(b) and 2.2(b) are revoked effective"
        + " as of the date You first made, used, sold, distributed, or had made, Modificati"
        + "ons made by that Participant.\n"
        + "\n"
        + "8.3 If You assert a patent infringement claim against Participant alleging that "
        + "such Participant’s Contributor Version directly or indirectly infringes any pate"
        + "nt where such claim is resolved (such as by license or settlement) prior to the "
        + "initiation of patent infringement litigation, then the reasonable value of the l"
        + "icenses granted by such Participant under Sections 2.1 or 2.2 shall be taken int"
        + "o account in determining the amount or value of any payment or license.\n"
        + "\n"
        + "8.4 In the event of termination under Sections 8.1 or 8.2 above, all end user li"
        + "cense agreements (excluding distributors and resellers) which have been validly "
        + "granted by You or any distributor hereunder prior to termination shall survive t"
        + "ermination.\n"
        + "\n"
        + "9. LIMITATION OF LIABILITY.\n"
        + "UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL THEORY, WHETHER TORT (INCLUDING NEGLIG"
        + "ENCE), CONTRACT, OR OTHERWISE, SHALL YOU, THE INITIAL DEVELOPER, ORIGINAL DEVELO"
        + "PER, ANY OTHER CONTRIBUTOR, OR ANY DISTRIBUTOR OF COVERED CODE, OR ANY SUPPLIER "
        + "OF ANY OF SUCH PARTIES, BE LIABLE TO ANY PERSON FOR ANY INDIRECT, SPECIAL, INCID"
        + "ENTAL, OR CONSEQUENTIAL DAMAGES OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, "
        + "DAMAGES FOR LOSS OF GOODWILL, WORK STOPPAGE, COMPUTER FAILURE OR MALFUNCTION, OR"
        + " ANY AND ALL OTHER COMMERCIAL DAMAGES OR LOSSES, EVEN IF SUCH PARTY SHALL HAVE B"
        + "EEN INFORMED OF THE POSSIBILITY OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SH"
        + "ALL NOT APPLY TO LIABILITY FOR DEATH OR PERSONAL INJURY RESULTING FROM SUCH PART"
        + "Y’S NEGLIGENCE TO THE EXTENT APPLICABLE LAW PROHIBITS SUCH LIMITATION. SOME JURI"
        + "SDICTIONS DO NOT ALLOW THE EXCLUSION OR LIMITATION OF INCIDENTAL OR CONSEQUENTIA"
        + "L DAMAGES, SO THIS EXCLUSION AND LIMITATION MAY NOT APPLY TO YOU.\n"
        + "\n"
        + "10. U.S. GOVERNMENT END USERS.\n"
        + "The Covered Code is a “commercial item,” as that term is defined in 48 C.F.R. 2."
        + "101 (Oct. 1995), consisting of “commercial computer software” and “commercial co"
        + "mputer software documentation,” as such terms are used in 48 C.F.R. 12.212 (Sept"
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
        + "ithout limitation, court costs and reasonable attorneys’ fees and expenses. The "
        + "application of the United Nations Convention on Contracts for the International "
        + "Sale of Goods is expressly excluded. Any law or regulation which provides that t"
        + "he language of a contract shall be construed against the drafter shall not apply"
        + " to this License.\n"
        + "\n"
        + "12. RESPONSIBILITY FOR CLAIMS.\n"
        + "As between Initial Developer, Original Developer and the Contributors, each part"
        + "y is responsible for claims and damages arising, directly or indirectly, out of "
        + "its utilization of rights under this License and You agree to work with Initial "
        + "Developer, Original Developer and Contributors to distribute such responsibility"
        + " on an equitable basis. Nothing herein is intended or shall be deemed to constit"
        + "ute any admission of liability.\n"
        + "\n"
        + "13. MULTIPLE-LICENSED CODE.\n"
        + "Initial Developer may designate portions of the Covered Code as Multiple-License"
        + "d. Multiple-Licensed means that the Initial Developer permits you to utilize por"
        + "tions of the Covered Code under Your choice of the CPAL or the alternative licen"
        + "ses, if any, specified by the Initial Developer in the file described in Exhibit"
        + " A.\n"
        + "\n"
        + "14. ADDITIONAL TERM: ATTRIBUTION\n"
        + "\n"
        + "(a) As a modest attribution to the organizer of the development of the Original "
        + "Code (“Original Developer”), in the hope that its promotional value may help jus"
        + "tify the time, money and effort invested in writing the Original Code, the Origi"
        + "nal Developer may include in Exhibit B (“Attribution Information”) a requirement"
        + " that each time an Executable and Source Code or a Larger Work is launched or in"
        + "itially run (which includes initiating a session), a prominent display of the Or"
        + "iginal Developer’s Attribution Information (as defined below) must occur on the "
        + "graphic user interface employed by the end user to access such Covered Code (whi"
        + "ch may include display on a splash screen), if any. The size of the graphic imag"
        + "e should be consistent with the size of the other elements of the Attribution In"
        + "formation. If the access by the end user to the Executable and Source Code does "
        + "not create a graphic user interface for access to the Covered Code, this obligat"
        + "ion shall not apply. If the Original Code displays such Attribution Information "
        + "in a particular form (such as in the form of a splash screen, notice at login, a"
        + "n “about” display, or dedicated attribution area on user interface screens), con"
        + "tinued use of such form for that Attribution Information is one way of meeting t"
        + "his requirement for notice.\n"
        + "\n"
        + "(b) Attribution information may only include a copyright notice, a brief phrase,"
        + " graphic image and a URL (“Attribution Information”) and is subject to the Attri"
        + "bution Limits as defined below. For these purposes, prominent shall mean display"
        + " for sufficient duration to give reasonable notice to the user of the identity o"
        + "f the Original Developer and that if You include Attribution Information or simi"
        + "lar information for other parties, You must ensure that the Attribution Informat"
        + "ion for the Original Developer shall be no less prominent than such Attribution "
        + "Information or similar information for the other party. For greater certainty, t"
        + "he Original Developer may choose to specify in Exhibit B below that the above at"
        + "tribution requirement only applies to an Executable and Source Code resulting fr"
        + "om the Original Code or any Modification, but not a Larger Work. The intent is t"
        + "o provide for reasonably modest attribution, therefore the Original Developer ca"
        + "nnot require that You display, at any time, more than the following information "
        + "as Attribution Information: (a) a copyright notice including the name of the Ori"
        + "ginal Developer; (b) a word or one phrase (not exceeding 10 words); (c) one grap"
        + "hic image provided by the Original Developer; and (d) a URL (collectively, the “"
        + "Attribution Limits”).\n"
        + "\n"
        + "(c) If Exhibit B does not include any Attribution Information, then there are no"
        + " requirements for You to display any Attribution Information of the Original Dev"
        + "eloper.\n"
        + "\n"
        + "(d) You acknowledge that all trademarks, service marks and/or trade names contai"
        + "ned within the Attribution Information distributed with the Covered Code are the"
        + " exclusive property of their owners and may only be used with the permission of "
        + "their owners, or under circumstances otherwise permitted by law or as expressly "
        + "set out in this License.\n"
        + "\n"
        + "15. ADDITIONAL TERM: NETWORK USE.\n"
        + "The term “External Deployment” means the use, distribution, or communication of "
        + "the Original Code or Modifications in any way such that the Original Code or Mod"
        + "ifications may be used by anyone other than You, whether those works are distrib"
        + "uted or communicated to those persons or made available as an application intend"
        + "ed for use over a network. As an express condition for the grants of license her"
        + "eunder, You must treat any External Deployment by You of the Original Code or Mo"
        + "difications as a distribution under section 3.1 and make Source Code available u"
        + "nder Section 3.2.\n"
        + "\n"
        + "EXHIBIT A. Common Public Attribution License Version 1.0.\n"
        + "\n"
        + "“The contents of this file are subject to the Common Public Attribution License "
        + "Version 1.0 (the “License”); you may not use this file except in compliance with"
        + " the License. You may obtain a copy of the License at _____________. The License"
        + " is based on the Mozilla Public License Version 1.1 but Sections 14 and 15 have "
        + "been added to cover use of software over a computer network and provide for limi"
        + "ted attribution for the Original Developer. In addition, Exhibit A has been modi"
        + "fied to be consistent with Exhibit B.\n"
        + "Software distributed under the License is distributed on an “AS IS” basis, WITHO"
        + "UT WARRANTY OF ANY KIND, either express or implied. See the License for the spec"
        + "ific language governing rights and limitations under the License.\n"
        + "The Original Code is______________________.\n"
        + "The Original Developer is not the Initial Developer and is __________. If left b"
        + "lank, the Original Developer is the Initial Developer.\n"
        + "The Initial Developer of the Original Code is ____________. All portions of the "
        + "code written by ___________ are Copyright (c) _____. All Rights Reserved.\n"
        + "Contributor ______________________.\n"
        + "Alternatively, the contents of this file may be used under the terms of the ____"
        + "_ license (the [___] License), in which case the provisions of [______] License "
        + "are applicable instead of those above.\n"
        + "If you wish to allow use of your version of this file only under the terms of th"
        + "e [____] License and not to allow others to use your version of this file under "
        + "the CPAL, indicate your decision by deleting the provisions above and replace th"
        + "em with the notice and other provisions required by the [___] License. If you do"
        + " not delete the provisions above, a recipient may use your version of this file "
        + "under either the CPAL or the [___] License.”\n"
        + "\n"
        + "[NOTE: The text of this Exhibit A may differ slightly from the text of the notic"
        + "es in the Source Code files of the Original Code. You should use the text of thi"
        + "s Exhibit A rather than the text found in the Original Code Source Code for Your"
        + " Modifications.]\n"
        + "\n"
        + "EXHIBIT B. Attribution Information\n"
        + "\n"
        + "Attribution Copyright Notice: _______________________\n"
        + "Attribution Phrase (not exceeding 10 words): _______________________\n"
        + "Attribution URL: _______________________\n"
        + "Graphic Image as provided in the Covered Code, if any.\n"
        + "Display of Attribution Information is [required/not required] in Larger Works wh"
        + "ich are defined in the CPAL as a work which combines Covered Code or portions th"
        + "ereof with code not governed by the terms of the CPAL.\n"
; // the license text
    }
 
    
}
