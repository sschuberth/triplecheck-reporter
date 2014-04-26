package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:45:13Z
 * LicenseName: Apache-2.0
 * FileName: RSCPL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class RSCPL extends License{
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
        return "RSCPL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Ricoh Source Code Public License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Ricoh Source Code Public License\n"
        + "\n"
        + "Version 1.0\n"
        + "\n"
        + "\n"
        + "1. Definitions.\n"
        + "\n"
        + "\n"
        + "1.1. \"Contributor\" means each entity that creates or contributes to the creation"
        + " of Modifications.\n"
        + "\n"
        + "\n"
        + "1.2. \"Contributor Version\" means the combination of the Original Code, prior Mod"
        + "ifications used by a Contributor, and the Modifications made by that particular "
        + "Contributor.\n"
        + "\n"
        + "\n"
        + "1.3. \"Electronic Distribution Mechanism\" means a website or any other mechanism "
        + "generally accepted in the software development community for the electronic tran"
        + "sfer of data.\n"
        + "\n"
        + "\n"
        + "1.4. \"Executable Code\" means Governed Code in any form other than Source Code.\n"
        + "\n"
        + "\n"
        + "1.5. \"Governed Code\" means the Original Code or Modifications or the combination"
        + " of the Original Code and Modifications, in each case including portions thereof"
        + ".\n"
        + "\n"
        + "\n"
        + "1.6. \"Larger Work\" means a work which combines Governed Code or portions thereof"
        + " with code not governed by the terms of this License.\n"
        + "\n"
        + "\n"
        + "1.7. \"Licensable\" means the right to grant, to the maximum extent possible, whet"
        + "her at the time of the initial grant or subsequently acquired, any and all of th"
        + "e rights conveyed herein.\n"
        + "\n"
        + "\n"
        + "1.8. \"License\" means this document.\n"
        + "\n"
        + "\n"
        + "1.9. \"Modifications\" means any addition to or deletion from the substance or str"
        + "ucture of either the Original Code or any previous Modifications. When Governed "
        + "Code is released as a series of files, a Modification is:\n"
        + "\n"
        + "\n"
        + "(a) Any addition to or deletion from the contents of a file containing Original "
        + "Code or previous Modifications.\n"
        + "\n"
        + "(b) Any new file that contains any part of the Original Code or previous Modific"
        + "ations.\n"
        + "\n"
        + "\n"
        + "\n"
        + "1.10. \"Original Code\" means the \"Platform for Information Applications\" Source C"
        + "ode as released under this License by RSV.\n"
        + "\n"
        + "\n"
        + "1.11 \"Patent Claims\" means any patent claim(s), now owned or hereafter acquired,"
        + " including without limitation, method, process, and apparatus claims, in any pat"
        + "ent Licensable by the grantor of a license thereto.\n"
        + "\n"
        + "1.12. \"RSV\" means Ricoh Silicon Valley, Inc., a California corporation with offi"
        + "ces at 2882 Sand Hill Road, Suite 115, Menlo Park, CA 94025-7022.\n"
        + "\n"
        + "1.13. \"Source Code\" means the preferred form of the Governed Code for making mod"
        + "ifications to it, including all modules it contains, plus any associated interfa"
        + "ce definition files, scripts used to control compilation and installation of Exe"
        + "cutable Code, or a list of source code differential comparisons against either t"
        + "he Original Code or another well known, available Governed Code of the Contribut"
        + "or's choice. The Source Code can be in a compressed or archival form, provided t"
        + "he appropriate decompression or de-archiving software is widely available for no"
        + " charge.\n"
        + "\n"
        + "\n"
        + "1.14. \"You\" means an individual or a legal entity exercising rights under, and c"
        + "omplying with all of the terms of, this License or a future version of this Lice"
        + "nse issued under Section 6.1. For legal entities, \"You\" includes any entity whic"
        + "h controls, is controlled by, or is under common control with You. For purposes "
        + "of this definition, \"control\" means (a) the power, direct or indirect, to cause "
        + "the direction or management of such entity, whether by contract or otherwise, or"
        + " (b) ownership of fifty percent (50%) or more of the outstanding shares or benef"
        + "icial ownership of such entity.\n"
        + "\n"
        + "\n"
        + "\n"
        + "2. Source Code License.\n"
        + "\n"
        + "2.1. Grant from RSV. RSV hereby grants You a worldwide, royalty-free, non-exclus"
        + "ive license, subject to third party intellectual property claims:\n"
        + "\n"
        + "\n"
        + "(a) to use, reproduce, modify, create derivative works of, display, perform, sub"
        + "license and distribute the Original Code (or portions thereof) with or without M"
        + "odifications, or as part of a Larger Work; and\n"
        + "\n"
        + "(b) under Patent Claims infringed by the making, using or selling of Original Co"
        + "de, to make, have made, use, practice, sell, and offer for sale, and/or otherwis"
        + "e dispose of the Original Code (or portions thereof).\n"
        + "\n"
        + "\n"
        + "\n"
        + "2.2. Contributor Grant. Each Contributor hereby grants You a worldwide, royalty-"
        + "free, non-exclusive license, subject to third party intellectual property claims"
        + ":\n"
        + "\n"
        + "\n"
        + "(a) to use, reproduce, modify, create derivative works of, display, perform, sub"
        + "license and distribute the Modifications created by such Contributor (or portion"
        + "s thereof) either on an unmodified basis, with other Modifications, as Governed "
        + "Code or as part of a Larger Work; and\n"
        + "\n"
        + "(b) under Patent Claims infringed by the making, using, or selling of Modificati"
        + "ons made by that Contributor either alone and/or in combination with its Contrib"
        + "utor Version (or portions of such combination), to make, use, sell, offer for sa"
        + "le, have made, and/or otherwise dispose of: (i) Modifications made by that Contr"
        + "ibutor (or portions thereof); and (ii) the combination of Modifications made by "
        + "that Contributor with its Contributor Version (or portions of such combination).\n"
        + "\n"
        + "\n"
        + "\n"
        + "3. Distribution Obligations.\n"
        + "\n"
        + "\n"
        + "\n"
        + "3.1. Application of License. The Modifications which You create or to which You "
        + "contribute are governed by the terms of this License, including without limitati"
        + "on Section 2.2. The Source Code version of Governed Code may be distributed only"
        + " under the terms of this License or a future version of this License released un"
        + "der Section 6.1, and You must include a copy of this License with every copy of "
        + "the Source Code You distribute. You may not offer or impose any terms on any Sou"
        + "rce Code version that alters or restricts the applicable version of this License"
        + " or the recipients' rights hereunder. However, You may include an additional doc"
        + "ument offering the additional rights described in Section 3.5.\n"
        + "\n"
        + "\n"
        + "3.2. Availability of Source Code. Any Modification which You create or to which "
        + "You contribute must be made available in Source Code form under the terms of thi"
        + "s License either on the same media as an Executable Code version or via an Elect"
        + "ronic Distribution Mechanism to anyone to whom you made an Executable Code versi"
        + "on available; and if made available via an Electronic Distribution Mechanism, mu"
        + "st remain available for at least twelve (12) months after the date it initially "
        + "became available, or at least six (6) months after a subsequent version of that "
        + "particular Modification has been made available to such recipients. You are resp"
        + "onsible for ensuring that the Source Code version remains available even if the "
        + "Electronic Distribution Mechanism is maintained by a third party.\n"
        + "\n"
        + "\n"
        + "3.3. Description of Modifications. You must cause all Governed Code to which you"
        + " contribute to contain a file documenting the changes You made to create that Go"
        + "verned Code and the date of any change. You must include a prominent statement t"
        + "hat the Modification is derived, directly or indirectly, from Original Code prov"
        + "ided by RSV and including the name of RSV in (a) the Source Code, and (b) in any"
        + " notice in an Executable Code version or related documentation in which You desc"
        + "ribe the origin or ownership of the Governed Code.\n"
        + "\n"
        + "\n"
        + "3.4. Intellectual Property Matters.\n"
        + "\n"
        + "3.4.1. Third Party Claims. If You have knowledge that a party claims an intellec"
        + "tual property right in particular functionality or code (or its utilization unde"
        + "r this License), you must include a text file with the source code distribution "
        + "titled \"LEGAL\" which describes the claim and the party making the claim in suffi"
        + "cient detail that a recipient will know whom to contact. If you obtain such know"
        + "ledge after You make Your Modification available as described in Section 3.2, Yo"
        + "u shall promptly modify the LEGAL file in all copies You make available thereaft"
        + "er and shall take other steps (such as notifying RSV and appropriate mailing lis"
        + "ts or newsgroups) reasonably calculated to inform those who received the Governe"
        + "d Code that new knowledge has been obtained. In the event that You are a Contrib"
        + "utor, You represent that, except as disclosed in the LEGAL file, your Modificati"
        + "ons are your original creations and, to the best of your knowledge, no third par"
        + "ty has any claim (including but not limited to intellectual property claims) rel"
        + "ating to your Modifications. You represent that the LEGAL file includes complete"
        + " details of any license or other restriction associated with any part of your Mo"
        + "difications.\n"
        + "\n"
        + "3.4.2. Contributor APIs. If Your Modification is an application programming inte"
        + "rface and You own or control patents which are reasonably necessary to implement"
        + " that API, you must also include this information in the LEGAL file.\n"
        + "\n"
        + "\n"
        + "3.5. Required Notices. You must duplicate the notice in Exhibit A in each file o"
        + "f the Source Code, and this License in any documentation for the Source Code, wh"
        + "ere You describe recipients' rights relating to Governed Code. If You created on"
        + "e or more Modification(s), You may add your name as a Contributor to the notice "
        + "described in Exhibit A. If it is not possible to put such notice in a particular"
        + " Source Code file due to its structure, then you must include such notice in a l"
        + "ocation (such as a relevant directory file) where a user would be likely to look"
        + " for such a notice. You may choose to offer, and to charge a fee for, warranty, "
        + "support, indemnity or liability obligations to one or more recipients of Governe"
        + "d Code. However, You may do so only on Your own behalf, and not on behalf of RSV"
        + " or any Contributor. You must make it absolutely clear than any such warranty, s"
        + "upport, indemnity or liability obligation is offered by You alone, and You hereb"
        + "y agree to indemnify RSV and every Contributor for any liability incurred by RSV"
        + " or such Contributor as a result of warranty, support, indemnity or liability te"
        + "rms You offer.\n"
        + "\n"
        + "\n"
        + "3.6. Distribution of Executable Code Versions. You may distribute Governed Code "
        + "in Executable Code form only if the requirements of Section 3.1-3.5 have been me"
        + "t for that Governed Code, and if You include a prominent notice stating that the"
        + " Source Code version of the Governed Code is available under the terms of this L"
        + "icense, including a description of how and where You have fulfilled the obligati"
        + "ons of Section 3.2. The notice must be conspicuously included in any notice in a"
        + "n Executable Code version, related documentation or collateral in which You desc"
        + "ribe recipients' rights relating to the Governed Code. You may distribute the Ex"
        + "ecutable Code version of Governed Code under a license of Your choice, which may"
        + " contain terms different from this License, provided that You are in compliance "
        + "with the terms of this License and that the license for the Executable Code vers"
        + "ion does not attempt to limit or alter the recipient's rights in the Source Code"
        + " version from the rights set forth in this License. If You distribute the Execut"
        + "able Code version under a different license You must make it absolutely clear th"
        + "at any terms which differ from this License are offered by You alone, not by RSV"
        + " or any Contributor. You hereby agree to indemnify RSV and every Contributor for"
        + " any liability incurred by RSV or such Contributor as a result of any such terms"
        + " You offer.\n"
        + "\n"
        + "\n"
        + "3.7. Larger Works. You may create a Larger Work by combining Governed Code with "
        + "other code not governed by the terms of this License and distribute the Larger W"
        + "ork as a single product. In such a case, You must make sure the requirements of "
        + "this License are fulfilled for the Governed Code.\n"
        + "\n"
        + "\n"
        + "4. Inability to Comply Due to Statute or Regulation.\n"
        + "\n"
        + "If it is impossible for You to comply with any of theterms of this License with "
        + "respect to some or all of the Governed Code due to statute or regulation then Yo"
        + "u must: (a) comply with the terms of this License to the maximum extent possible"
        + "; and (b) describe the limitations and the code they affect. Such description mu"
        + "st be included in the LEGAL file described in Section 3.4 and must be included w"
        + "ith all distributions of the Source Code. Except to the extent prohibited by sta"
        + "tute or regulation, such description must be sufficiently detailed for a recipie"
        + "nt of ordinary skill to be able to understand it.\n"
        + "\n"
        + "\n"
        + "5. Trademark Usage.\n"
        + "\n"
        + "\n"
        + "\n"
        + "5.1. Advertising Materials. All advertising materials mentioning features or use"
        + " of the Governed Code must display the following acknowledgement: \"This product "
        + "includes software developed by Ricoh Silicon Valley, Inc.\"\n"
        + "\n"
        + "\n"
        + "5.2. Endorsements. The names \"Ricoh,\" \"Ricoh Silicon Valley,\" and \"RSV\" must not"
        + " be used to endorse or promote Contributor Versions or Larger Works without the "
        + "prior written permission of RSV.\n"
        + "\n"
        + "\n"
        + "5.3. Product Names. Contributor Versions and Larger Works may not be called \"Ric"
        + "oh\" nor may the word \"Ricoh\" appear in their names without the prior written per"
        + "mission of RSV.\n"
        + "\n"
        + "\n"
        + "6. Versions of the License.\n"
        + "\n"
        + "\n"
        + "\n"
        + "6.1. New Versions. RSV may publish revised and/or new versions of the License fr"
        + "om time to time. Each version will be given a distinguishing version number.\n"
        + "\n"
        + "\n"
        + "6.2. Effect of New Versions. Once Governed Code has been published under a parti"
        + "cular version of the License, You may always continue to use it under the terms "
        + "of that version. You may also choose to use such Governed Code under the terms o"
        + "f any subsequent version of the License published by RSV. No one other than RSV "
        + "has the right to modify the terms applicable to Governed Code created under this"
        + " License.\n"
        + "\n"
        + "\n"
        + "7. Disclaimer of Warranty.\n"
        + "\n"
        + "GOVERNED CODE IS PROVIDED UNDER THIS LICENSE ON AN \"AS IS\" BASIS, WITHOUT WARRAN"
        + "TY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARR"
        + "ANTIES THAT THE GOVERNED CODE IS FREE OF DEFECTS, MERCHANTABLE, FIT FOR A PARTIC"
        + "ULAR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANC"
        + "E OF THE GOVERNED CODE IS WITH YOU. SHOULD ANY GOVERNED CODE PROVE DEFECTIVE IN "
        + "ANY RESPECT, YOU (NOT RSV OR ANY OTHER CONTRIBUTOR) ASSUME THE COST OF ANY NECES"
        + "SARY SERVICING, REPAIR OR CORRECTION. THIS DISCLAIMER OF WARRANTY CONSTITUTES AN"
        + " ESSENTIAL PART OF THIS LICENSE. NO USE OF ANY GOVERNED CODE IS AUTHORIZED HEREU"
        + "NDER EXCEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "\n"
        + "8. Termination.\n"
        + "\n"
        + "\n"
        + "\n"
        + "8.1. This License and the rights granted hereunder will terminate automatically "
        + "if You fail to comply with terms herein and fail to cure such breach within 30 d"
        + "ays of becoming aware of the breach. All sublicenses to the Governed Code which "
        + "are properly granted shall survive any termination of this License. Provisions w"
        + "hich, by their nature, must remain in effect beyond the termination of this Lice"
        + "nse shall survive.\n"
        + "\n"
        + "\n"
        + "8.2. If You initiate patent infringement litigation against RSV or a Contributor"
        + " (RSV or the Contributor against whom You file such action is referred to as \"Pa"
        + "rticipant\") alleging that:\n"
        + "\n"
        + "\n"
        + "(a) such Participant's Original Code or Contributor Version directly or indirect"
        + "ly infringes any patent, then any and all rights granted by such Participant to "
        + "You under Sections 2.1 and/or 2.2 of this License shall, upon 60 days notice fro"
        + "m Participant terminate prospectively, unless if within 60 days after receipt of"
        + " notice You either: (i) agree in writing to pay Participant a mutually agreeable"
        + " reasonable royalty for Your past and future use of the Original Code or the Mod"
        + "ifications made by such Participant, or (ii) withdraw Your litigation claim with"
        + " respect to the Original Code or the Contributor Version against such Participan"
        + "t. If within 60 days of notice, a reasonable royalty and payment arrangement are"
        + " not mutually agreed upon in writing by the parties or the litigation claim is n"
        + "ot withdrawn, the rights granted by Participant to You under Sections 2.1 and/or"
        + " 2.2 automatically terminate at the expiration of the 60 day notice period speci"
        + "fied above.\n"
        + "\n"
        + "(b) any software, hardware, or device provided to You by the Participant, other "
        + "than such Participant's Original Code or Contributor Version, directly or indire"
        + "ctly infringes any patent, then any rights granted to You by such Participant un"
        + "der Sections 2.1(b) and 2.2(b) are revoked effective as of the date You first ma"
        + "de, used, sold, distributed, or had made, Original Code or the Modifications mad"
        + "e by that Participant.\n"
        + "\n"
        + "\n"
        + "\n"
        + "8.3. If You assert a patent infringement claim against Participant alleging that"
        + " such Participant's Original Code or Contributor Version directly or indirectly "
        + "infringes any patent where such claim is resolved (such as by license or settlem"
        + "ent) prior to the initiation of patent infringement litigation, then the reasona"
        + "ble value of the licenses granted by such Participant under Sections 2.1 or 2.2 "
        + "shall be taken into account in determining the amount or value of any payment or"
        + " license.\n"
        + "\n"
        + "\n"
        + "8.4. In the event of termination under Sections 8.1 or 8.2 above, all end user l"
        + "icense agreements (excluding distributors and resellers) which have been validly"
        + " granted by You or any distributor hereunder prior to termination shall survive "
        + "termination.\n"
        + "\n"
        + "\n"
        + "9. Limitation of Liability.\n"
        + "\n"
        + "UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL THEORY, WHETHER TORT (INCLUDING NEGLIG"
        + "ENCE), CONTRACT, OR OTHERWISE, SHALL RSV, ANY CONTRIBUTOR, OR ANY DISTRIBUTOR OF"
        + " GOVERNED CODE, OR ANY SUPPLIER OF ANY OF SUCH PARTIES, BE LIABLE TO YOU OR ANY "
        + "OTHER PERSON FOR ANY DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAM"
        + "AGES OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF GOODWIL"
        + "L, WORK STOPPAGE, COMPUTER FAILURE OR MALFUNCTION, OR ANY AND ALL OTHER COMMERCI"
        + "AL DAMAGES OR LOSSES, EVEN IF SUCH PARTY SHALL HAVE BEEN INFORMED OF THE POSSIBI"
        + "LITY OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SHALL NOT APPLY TO LIABILITY "
        + "FOR DEATH OR PERSONAL INJURY RESULTING FROM SUCH PARTY'S NEGLIGENCE TO THE EXTEN"
        + "T APPLICABLE LAW PROHIBITS SUCH LIMITATION. SOME JURISDICTIONS DO NOT ALLOW THE "
        + "EXCLUSION OR LIMITATION OF INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO THAT EXCLUSIO"
        + "N AND LIMITATION MAY NOT APPLY TO YOU. TO THE EXTENT THAT ANY EXCLUSION OF DAMAG"
        + "ES ABOVE IS NOT VALID, YOU AGREE THAT IN NO EVENT WILL RSVS LIABILITY UNDER OR R"
        + "ELATED TO THIS AGREEMENT EXCEED FIVE THOUSAND DOLLARS ($5,000). THE GOVERNED COD"
        + "E IS NOT INTENDED FOR USE IN CONNECTION WITH ANY NUCLER, AVIATION, MASS TRANSIT "
        + "OR MEDICAL APPLICATION OR ANY OTHER INHERENTLY DANGEROUS APPLICATION THAT COULD "
        + "RESULT IN DEATH, PERSONAL INJURY, CATASTROPHIC DAMAGE OR MASS DESTRUCTION, AND Y"
        + "OU AGREE THAT NEITHER RSV NOR ANY CONTRIBUTOR SHALL HAVE ANY LIABILITY OF ANY NA"
        + "TURE AS A RESULT OF ANY SUCH USE OF THE GOVERNED CODE.\n"
        + "\n"
        + "\n"
        + "10. U.S. Government End Users.\n"
        + "\n"
        + "The Governed Code is a \"commercial item,\" as that term is defined in 48 C.F.R. 2"
        + ".101 (Oct. 1995), consisting of \"commercial computer software\" and \"commercial c"
        + "omputer software documentation,\" as such terms are used in 48 C.F.R. 12.212 (Sep"
        + "t. 1995). Consistent with 48 C.F.R. 12.212 and 48 C.F.R. 227.7202-1 through 227."
        + "7202-4 (June 1995), all U.S. Government End Users acquire Governed Code with onl"
        + "y those rights set forth herein.\n"
        + "\n"
        + "\n"
        + "11. Miscellaneous.\n"
        + "\n"
        + "This License represents the complete agreement concerning subject matter hereof."
        + " If any provision of this License is held to be unenforceable, such provision sh"
        + "all be reformed only to the extent necessary to make it enforceable. This Licens"
        + "e shall be governed by California law provisions (except to the extent applicabl"
        + "e law, if any, provides otherwise), excluding its conflict-of-law provisions. Th"
        + "e parties submit to personal jurisdiction in California and further agree that a"
        + "ny cause of action arising under or related to this Agreement shall be brought i"
        + "n the Federal Courts of the Northern District of California, with venue lying in"
        + " Santa Clara County, California. The losing party shall be responsible for costs"
        + ", including without limitation, court costs and reasonable attorneys fees and ex"
        + "penses. Notwithstanding anything to the contrary herein, RSV may seek injunctive"
        + " relief related to a breach of this Agreement in any court of competent jurisdic"
        + "tion. The application of the United Nations Convention on Contracts for the Inte"
        + "rnational Sale of Goods is expressly excluded. Any law or regulation which provi"
        + "des that the language of a contract shall be construed against the drafter shall"
        + " not apply to this License.\n"
        + "\n"
        + "\n"
        + "12. Responsibility for Claims.\n"
        + "\n"
        + "Except in cases where another Contributor has failed to comply with Section 3.4,"
        + " You are responsible for damages arising, directly or indirectly, out of Your ut"
        + "ilization of rights under this License, based on the number of copies of Governe"
        + "d Code you made available, the revenues you received from utilizing such rights,"
        + " and other relevant factors. You agree to work with affected parties to distribu"
        + "te responsibility on an equitable basis.\n"
        + "\n"
        + "\n"
        + "\n"
        + " \n"
        + "\n"
        + "EXHIBIT A\n"
        + "\n"
        + "\"The contents of this file are subject to the Ricoh Source Code Public License V"
        + "ersion 1.0 (the \"License\"); you may not use this file except in compliance with "
        + "the License. You may obtain a copy of the License at http://www.risource.org/RPL\n"
        + "\n"
        + "Software distributed under the License is distributed on an \"AS IS\" basis, WITHO"
        + "UT WARRANTY OF ANY KIND, either express or implied. See the License for the spec"
        + "ific language governing rights and limitations under the License.\n"
        + "\n"
        + "This code was initially developed by Ricoh Silicon Valley, Inc. Portions created"
        + " by Ricoh Silicon Valley, Inc. are Copyright (C) 1995-1999. All Rights Reserved.\n"
        + "\n"
        + "Contributor(s): ______________________________________.\"\n"
; // the license text
    }
 
    
}
