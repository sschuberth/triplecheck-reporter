package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:43:45Z
 * LicenseName: Apache-2.0
 * FileName: APSL_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class APSL_2_0 extends License{
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
        return "APSL-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Apple Public Source License 2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "APPLE PUBLIC SOURCE LICENSE\n"
        + "Version 2.0 -  August 6, 2003\n"
        + "\n"
        + "Please read this License carefully before downloading this software.  By downloa"
        + "ding or using this software, you are agreeing to be bound by the terms of this L"
        + "icense.  If you do not or cannot agree to the terms of this License, please do n"
        + "ot download or use the software.\n"
        + "\n"
        + "Apple Note:  In January 2007, Apple changed its corporate name from \"Apple Compu"
        + "ter, Inc.\" to \"Apple Inc.\"  This change has been reflected below and copyright y"
        + "ears updated, but no other changes have been made to the APSL 2.0.\n"
        + "\n"
        + "1. General; Definitions.  This License applies to any program or other work whic"
        + "h Apple Inc. (\"Apple\") makes publicly available and which contains a notice plac"
        + "ed by Apple identifying such program or work as \"Original Code\" and stating that"
        + " it is subject to the terms of this Apple Public Source License version 2.0 (\"Li"
        + "cense\").  As used in this License:\n"
        + "\n"
        + "1.1  \"Applicable Patent Rights\" mean:  (a) in the case where Apple is the granto"
        + "r of rights, (i) claims of patents that are now or hereafter acquired, owned by "
        + "or assigned to Apple and (ii) that cover subject matter contained in the Origina"
        + "l Code, but only to the extent necessary to use, reproduce and/or distribute the"
        + " Original Code without infringement; and (b) in the case where You are the grant"
        + "or of rights, (i) claims of patents that are now or hereafter acquired, owned by"
        + " or assigned to You and (ii) that cover subject matter in Your Modifications, ta"
        + "ken alone or in combination with Original Code.\n"
        + "\n"
        + "1.2 \"Contributor\" means any person or entity that creates or contributes to the "
        + "creation of Modifications.\n"
        + "\n"
        + "1.3  \"Covered Code\" means the Original Code, Modifications, the combination of O"
        + "riginal Code and any Modifications, and/or any respective portions thereof.\n"
        + "\n"
        + "1.4 \"Externally Deploy\" means: (a) to sublicense, distribute or otherwise make C"
        + "overed Code available, directly or indirectly, to anyone other than You; and/or "
        + "(b) to use Covered Code, alone or as part of a Larger Work, in any way to provid"
        + "e a service, including but not limited to delivery of content, through electroni"
        + "c communication with a client other than You.\n"
        + "\n"
        + "1.5 \"Larger Work\" means a work which combines Covered Code or portions thereof w"
        + "ith code not governed by the terms of this License.\n"
        + "\n"
        + "1.6 \"Modifications\" mean any addition to, deletion from, and/or change to, the s"
        + "ubstance and/or structure of the Original Code, any previous Modifications, the "
        + "combination of Original Code and any previous Modifications, and/or any respecti"
        + "ve portions thereof.  When code is released as a series of files, a Modification"
        + " is:  (a) any addition to or deletion from the contents of a file containing Cov"
        + "ered Code; and/or (b) any new file or other representation of computer program s"
        + "tatements that contains any part of Covered Code. \n"
        + "\n"
        + "1.7 \"Original Code\" means (a) the Source Code of a program or other work as orig"
        + "inally made available by Apple under this License, including the Source Code of "
        + "any updates or upgrades to such programs or works made available by Apple under "
        + "this License, and that has been expressly identified by Apple as such in the hea"
        + "der file(s) of such work; and (b) the object code compiled from such Source Code"
        + " and originally made available by Apple under this License\n"
        + "\n"
        + "1.8 \"Source Code\" means the human readable form of a program or other work that "
        + "is suitable for making modifications to it, including all modules it contains, p"
        + "lus any associated interface definition files, scripts used to control compilati"
        + "on and installation of an executable (object code).\n"
        + "\n"
        + "1.9 \"You\" or \"Your\" means an individual or a legal entity exercising rights unde"
        + "r this License.  For legal entities, \"You\" or \"Your\" includes any entity which c"
        + "ontrols, is controlled by, or is under common control with, You, where \"control\""
        + " means (a) the power, direct or indirect, to cause the direction or management o"
        + "f such entity, whether by contract or otherwise, or (b) ownership of fifty perce"
        + "nt (50%) or more of the outstanding shares or beneficial ownership of such entit"
        + "y.\n"
        + "\n"
        + "2. Permitted Uses; Conditions & Restrictions.   Subject to the terms and conditi"
        + "ons of this License, Apple hereby grants You, effective on the date You accept t"
        + "his License and download the Original Code, a world-wide, royalty-free, non-excl"
        + "usive license, to the extent of Apple's Applicable Patent Rights and copyrights "
        + "covering the Original Code, to do the following:\n"
        + "\n"
        + "2.1 Unmodified Code.  You may use, reproduce, display, perform, internally distr"
        + "ibute within Your organization, and Externally Deploy verbatim, unmodified copie"
        + "s of the Original Code, for commercial or non-commercial purposes, provided that"
        + " in each instance:\n"
        + "\n"
        + "(a) You must retain and reproduce in all copies of Original Code the copyright a"
        + "nd other proprietary notices and disclaimers of Apple as they appear in the Orig"
        + "inal Code, and keep intact all notices in the Original Code that refer to this L"
        + "icense; and\n"
        + "\n"
        + "(b)  You must include a copy of this License with every copy of Source Code of C"
        + "overed Code and documentation You distribute or Externally Deploy, and You may n"
        + "ot offer or impose any terms on such Source Code that alter or restrict this Lic"
        + "ense or the recipients' rights hereunder, except as permitted under Section 6.\n"
        + "\n"
        + "2.2 Modified Code.  You may modify Covered Code and use, reproduce, display, per"
        + "form, internally distribute within Your organization, and Externally Deploy Your"
        + " Modifications and Covered Code, for commercial or non-commercial purposes, prov"
        + "ided that in each instance You also meet all of these conditions:\n"
        + "\n"
        + "(a) You must satisfy all the conditions of Section 2.1 with respect to the Sourc"
        + "e Code of the Covered Code; \n"
        + "\n"
        + "(b) You must duplicate, to the extent it does not already exist, the notice in E"
        + "xhibit A in each file of the Source Code of all Your Modifications, and cause th"
        + "e modified files to carry prominent notices stating that You changed the files a"
        + "nd the date of any change; and\n"
        + "\n"
        + "(c) If You Externally Deploy Your Modifications, You must make Source Code of al"
        + "l Your Externally Deployed Modifications either available to those to whom You h"
        + "ave Externally Deployed Your Modifications, or publicly available.  Source Code "
        + "of Your Externally Deployed Modifications must be released under the terms set f"
        + "orth in this License, including the license grants set forth in Section 3 below,"
        + " for as long as you Externally Deploy the Covered Code or twelve (12) months fro"
        + "m the date of initial External Deployment, whichever is longer. You should prefe"
        + "rably distribute the Source Code of Your Externally Deployed Modifications elect"
        + "ronically (e.g. download from a web site).\n"
        + "\n"
        + "2.3 Distribution of Executable Versions.  In addition, if You Externally Deploy "
        + "Covered Code (Original Code and/or Modifications) in object code, executable for"
        + "m only, You must include a prominent notice, in the code itself as well as in re"
        + "lated documentation, stating that Source Code of the Covered Code is available u"
        + "nder the terms of this License with information on how and where to obtain such "
        + "Source Code.  \n"
        + "\n"
        + "2.4 Third Party Rights.  You expressly acknowledge and agree that although Apple"
        + " and each Contributor grants the licenses to their respective portions of the Co"
        + "vered Code set forth herein, no assurances are provided by Apple or any Contribu"
        + "tor that the Covered Code does not infringe the patent or other intellectual pro"
        + "perty rights of any other entity. Apple and each Contributor disclaim any liabil"
        + "ity to You for claims brought by any other entity based on infringement of intel"
        + "lectual property rights or otherwise. As a condition to exercising the rights an"
        + "d licenses granted hereunder, You hereby assume sole responsibility to secure an"
        + "y other intellectual property rights needed, if any. For example, if a third par"
        + "ty patent license is required to allow You to distribute the Covered Code, it is"
        + " Your responsibility to acquire that license before distributing the Covered Cod"
        + "e.\n"
        + "\n"
        + "3. Your Grants.  In consideration of, and as a condition to, the licenses grante"
        + "d to You under this License, You hereby grant to any person or entity receiving "
        + "or distributing Covered Code under this License a non-exclusive, royalty-free, p"
        + "erpetual, irrevocable license, under Your Applicable Patent Rights and other int"
        + "ellectual property rights (other than patent) owned or controlled by You, to use"
        + ", reproduce, display, perform, modify, sublicense, distribute and Externally Dep"
        + "loy Your Modifications of the same scope and extent as Apple's licenses under Se"
        + "ctions 2.1 and 2.2 above.  \n"
        + "\n"
        + "4. Larger Works.  You may create a Larger Work by combining Covered Code with ot"
        + "her code not governed by the terms of this License and distribute the Larger Wor"
        + "k as a single product.  In each such instance, You must make sure the requiremen"
        + "ts of this License are fulfilled for the Covered Code or any portion thereof. \n"
        + "\n"
        + "5. Limitations on Patent License.   Except as expressly stated in Section 2, no "
        + "other patent rights, express or implied, are granted by Apple herein.  Modificat"
        + "ions and/or Larger Works may require additional patent licenses from Apple which"
        + " Apple may grant in its sole discretion.  \n"
        + "\n"
        + "6. Additional Terms.  You may choose to offer, and to charge a fee for, warranty"
        + ", support, indemnity or liability obligations and/or other rights consistent wit"
        + "h the scope of the license granted herein (\"Additional Terms\") to one or more re"
        + "cipients of Covered Code. However, You may do so only on Your own behalf and as "
        + "Your sole responsibility, and not on behalf of Apple or any Contributor. You mus"
        + "t obtain the recipient's agreement that any such Additional Terms are offered by"
        + " You alone, and You hereby agree to indemnify, defend and hold Apple and every C"
        + "ontributor harmless for any liability incurred by or claims asserted against App"
        + "le or such Contributor by reason of any such Additional Terms. \n"
        + "\n"
        + "7. Versions of the License.  Apple may publish revised and/or new versions of th"
        + "is License from time to time.  Each version will be given a distinguishing versi"
        + "on number.  Once Original Code has been published under a particular version of "
        + "this License, You may continue to use it under the terms of that version. You ma"
        + "y also choose to use such Original Code under the terms of any subsequent versio"
        + "n of this License published by Apple.  No one other than Apple has the right to "
        + "modify the terms applicable to Covered Code created under this License.  \n"
        + "\n"
        + "8. NO WARRANTY OR SUPPORT.  The Covered Code may contain in whole or in part pre"
        + "-release, untested, or not fully tested works.  The Covered Code may contain err"
        + "ors that could cause failures or loss of data, and may be incomplete or contain "
        + "inaccuracies.  You expressly acknowledge and agree that use of the Covered Code,"
        + " or any portion thereof, is at Your sole and entire risk.  THE COVERED CODE IS P"
        + "ROVIDED \"AS IS\" AND WITHOUT WARRANTY, UPGRADES OR SUPPORT OF ANY KIND AND APPLE "
        + "AND APPLE'S LICENSOR(S) (COLLECTIVELY REFERRED TO AS \"APPLE\" FOR THE PURPOSES OF"
        + " SECTIONS 8 AND 9) AND ALL CONTRIBUTORS EXPRESSLY DISCLAIM ALL WARRANTIES AND/OR"
        + " CONDITIONS, EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARR"
        + "ANTIES AND/OR CONDITIONS OF MERCHANTABILITY, OF SATISFACTORY QUALITY, OF FITNESS"
        + " FOR A PARTICULAR PURPOSE, OF ACCURACY, OF QUIET ENJOYMENT, AND NONINFRINGEMENT "
        + "OF THIRD PARTY RIGHTS.  APPLE AND EACH CONTRIBUTOR DOES NOT WARRANT AGAINST INTE"
        + "RFERENCE WITH YOUR ENJOYMENT OF THE COVERED CODE, THAT THE FUNCTIONS CONTAINED I"
        + "N THE COVERED CODE WILL MEET YOUR REQUIREMENTS, THAT THE OPERATION OF THE COVERE"
        + "D CODE WILL BE UNINTERRUPTED OR ERROR-FREE, OR THAT DEFECTS IN THE COVERED CODE "
        + "WILL BE CORRECTED.  NO ORAL OR WRITTEN INFORMATION OR ADVICE GIVEN BY APPLE, AN "
        + "APPLE AUTHORIZED REPRESENTATIVE OR ANY CONTRIBUTOR SHALL CREATE A WARRANTY.  You"
        + " acknowledge that the Covered Code is not intended for use in the operation of n"
        + "uclear facilities, aircraft navigation, communication systems, or air traffic co"
        + "ntrol machines in which case the failure of the Covered Code could lead to death"
        + ", personal injury, or severe physical or environmental damage.\n"
        + "\n"
        + "9. LIMITATION OF LIABILITY. TO THE EXTENT NOT PROHIBITED BY LAW, IN NO EVENT SHA"
        + "LL APPLE OR ANY CONTRIBUTOR BE LIABLE FOR ANY INCIDENTAL, SPECIAL, INDIRECT OR C"
        + "ONSEQUENTIAL DAMAGES ARISING OUT OF OR RELATING TO THIS LICENSE OR YOUR USE OR I"
        + "NABILITY TO USE THE COVERED CODE, OR ANY PORTION THEREOF, WHETHER UNDER A THEORY"
        + " OF CONTRACT, WARRANTY, TORT (INCLUDING NEGLIGENCE), PRODUCTS LIABILITY OR OTHER"
        + "WISE, EVEN IF APPLE OR SUCH CONTRIBUTOR HAS BEEN ADVISED OF THE POSSIBILITY OF S"
        + "UCH DAMAGES AND NOTWITHSTANDING THE FAILURE OF ESSENTIAL PURPOSE OF ANY REMEDY. "
        + "SOME JURISDICTIONS DO NOT ALLOW THE LIMITATION OF LIABILITY OF INCIDENTAL OR CON"
        + "SEQUENTIAL DAMAGES, SO THIS LIMITATION MAY NOT APPLY TO YOU. In no event shall A"
        + "pple's total liability to You for all damages (other than as may be required by "
        + "applicable law) under this License exceed the amount of fifty dollars ($50.00).\n"
        + "\n"
        + "10. Trademarks.  This License does not grant any rights to use the trademarks or"
        + " trade names  \"Apple\", \"Mac\", \"Mac OS\", \"QuickTime\", \"QuickTime Streaming Server"
        + "\" or any other trademarks, service marks, logos or trade names belonging to Appl"
        + "e (collectively \"Apple Marks\") or to any trademark, service mark, logo or trade "
        + "name belonging to any Contributor.  You agree not to use any Apple Marks in or a"
        + "s part of the name of products derived from the Original Code or to endorse or p"
        + "romote products derived from the Original Code other than as expressly permitted"
        + " by and in strict compliance at all times with Apple's third party trademark usa"
        + "ge guidelines which are posted at http://www.apple.com/legal/guidelinesfor3rdpar"
        + "ties.html.  \n"
        + "\n"
        + "11. Ownership. Subject to the licenses granted under this License, each Contribu"
        + "tor retains all rights, title and interest in and to any Modifications made by s"
        + "uch Contributor.  Apple retains all rights, title and interest in and to the Ori"
        + "ginal Code and any Modifications made by or on behalf of Apple (\"Apple Modificat"
        + "ions\"), and such Apple Modifications will not be automatically subject to this L"
        + "icense.  Apple may, at its sole discretion, choose to license such Apple Modific"
        + "ations under this License, or on different terms from those contained in this Li"
        + "cense or may choose not to license them at all.  \n"
        + "\n"
        + "12. Termination.  \n"
        + "\n"
        + "12.1 Termination.  This License and the rights granted hereunder will terminate:\n"
        + "\n"
        + "(a) automatically without notice from Apple if You fail to comply with any term("
        + "s) of this License and fail to cure such breach within 30 days of becoming aware"
        + " of such breach;\n"
        + "(b) immediately in the event of the circumstances described in Section 13.5(b); "
        + "or\n"
        + "(c) automatically without notice from Apple if You, at any time during the term "
        + "of this License, commence an action for patent infringement against Apple; provi"
        + "ded that Apple did not first commence an action for patent infringement against "
        + "You in that instance.\n"
        + "\n"
        + "12.2 Effect of Termination.  Upon termination, You agree to immediately stop any"
        + " further use, reproduction, modification, sublicensing and distribution of the C"
        + "overed Code.  All sublicenses to the Covered Code which have been properly grant"
        + "ed prior to termination shall survive any termination of this License.  Provisio"
        + "ns which, by their nature, should remain in effect beyond the termination of thi"
        + "s License shall survive, including but not limited to Sections 3, 5, 8, 9, 10, 1"
        + "1, 12.2 and 13.  No party will be liable to any other for compensation, indemnit"
        + "y or damages of any sort solely as a result of terminating this License in accor"
        + "dance with its terms, and termination of this License will be without prejudice "
        + "to any other right or remedy of any party.\n"
        + "\n"
        + "13.  Miscellaneous.\n"
        + "\n"
        + "13.1 Government End Users.   The Covered Code is a \"commercial item\" as defined "
        + "in FAR 2.101.  Government software and technical data rights in the Covered Code"
        + " include only those rights customarily provided to the public as defined in this"
        + " License. This customary commercial license in technical data and software is pr"
        + "ovided in accordance with FAR 12.211 (Technical Data) and 12.212 (Computer Softw"
        + "are) and, for Department of Defense purchases, DFAR 252.227-7015 (Technical Data"
        + " -- Commercial Items) and 227.7202-3 (Rights in Commercial Computer Software or "
        + "Computer Software Documentation).  Accordingly, all U.S. Government End Users ac"
        + "quire Covered Code with only those rights set forth herein.\n"
        + "\n"
        + "13.2 Relationship of Parties.  This License will not be construed as creating an"
        + " agency, partnership, joint venture or any other form of legal association betwe"
        + "en or among You, Apple or any Contributor, and You will not represent to the con"
        + "trary, whether expressly, by implication, appearance or otherwise.\n"
        + "\n"
        + "13.3 Independent Development.   Nothing in this License will impair Apple's righ"
        + "t to acquire, license, develop, have others develop for it, market and/or distri"
        + "bute technology or products that perform the same or similar functions as, or ot"
        + "herwise compete with, Modifications, Larger Works, technology or products that Y"
        + "ou may develop, produce, market or distribute.\n"
        + "\n"
        + "13.4 Waiver; Construction.  Failure by Apple or any Contributor to enforce any p"
        + "rovision of this License will not be deemed a waiver of future enforcement of th"
        + "at or any other provision.  Any law or regulation which provides that the langua"
        + "ge of a contract shall be construed against the drafter will not apply to this L"
        + "icense.\n"
        + "\n"
        + "13.5 Severability.  (a) If for any reason a court of competent jurisdiction find"
        + "s any provision of this License, or portion thereof, to be unenforceable, that p"
        + "rovision of the License will be enforced to the maximum extent permissible so as"
        + " to effect the economic benefits and intent of the parties, and the remainder of"
        + " this License will continue in full force and effect.  (b) Notwithstanding the f"
        + "oregoing, if applicable law prohibits or restricts You from fully and/or specifi"
        + "cally complying with Sections 2 and/or 3 or prevents the enforceability of eithe"
        + "r of those Sections, this License will immediately terminate and You must immedi"
        + "ately discontinue any use of the Covered Code and destroy all copies of it that "
        + "are in your possession or control.\n"
        + "\n"
        + "13.6 Dispute Resolution.  Any litigation or other dispute resolution between You"
        + " and Apple relating to this License shall take place in the Northern District of"
        + " California, and You and Apple hereby consent to the personal jurisdiction of, a"
        + "nd venue in, the state and federal courts within that District with respect to t"
        + "his License. The application of the United Nations Convention on Contracts for t"
        + "he International Sale of Goods is expressly excluded.\n"
        + "\n"
        + "13.7 Entire Agreement; Governing Law.  This License constitutes the entire agree"
        + "ment between the parties with respect to the subject matter hereof.  This Licens"
        + "e shall be governed by the laws of the United States and the State of California"
        + ", except that body of California law concerning conflicts of law. \n"
        + "\n"
        + "Where You are located in the province of Quebec, Canada, the following clause ap"
        + "plies:  The parties hereby confirm that they have requested that this License an"
        + "d all related documents be drafted in English.  Les parties ont exigé que le pré"
        + "sent contrat et tous les documents connexes soient rédigés en anglais.\n"
        + "\n"
        + "EXHIBIT A. \n"
        + "\n"
        + "\"Portions Copyright (c) 1999-2007 Apple Inc.  All Rights Reserved.\n"
        + "\n"
        + "This file contains Original Code and/or Modifications of Original Code as define"
        + "d in and that are subject to the Apple Public Source License Version 2.0 (the 'L"
        + "icense').  You may not use this file except in compliance with the License.  Ple"
        + "ase obtain a copy of the License at http://www.opensource.apple.com/apsl/ and re"
        + "ad it before using this file.\n"
        + "\n"
        + "The Original Code and all software distributed under the License are distributed"
        + " on an 'AS IS' basis, WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS OR IMPLIED, A"
        + "ND APPLE HEREBY DISCLAIMS ALL SUCH WARRANTIES, INCLUDING WITHOUT LIMITATION, ANY"
        + " WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, QUIET ENJOYMEN"
        + "T OR NON-INFRINGEMENT.  Please see the License for the specific language governi"
        + "ng rights and limitations under the License.\" \n"
; // the license text
    }
 
    
}
