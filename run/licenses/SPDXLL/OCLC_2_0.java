package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:22Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OCLC_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OCLC_2_0 extends License{
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
        return "OCLC-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "OCLC Research Public License 2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "OCLC Research Public License 2.0\n"
        + "Terms & Conditions Of Use\n"
        + "May, 2002\n"
        + "Copyright © 2002. OCLC Online Computer Library Center, Inc. All Rights Reserved\n"
        + "\n"
        + "PLEASE READ THIS DOCUMENT CAREFULLY. BY DOWNLOADING OR USING THE CODE BASE AND/O"
        + "R DOCUMENTATION ACCOMPANYING THIS LICENSE (THE \"License\"), YOU AGREE TO THE FOLL"
        + "OWING TERMS AND CONDITIONS OF THIS LICENSE.\n"
        + "\n"
        + "Section 1. Your Rights\n"
        + "\n"
        + "Subject to these terms and conditions of this License, the OCLC Office of Resear"
        + "ch (the \"Original Contributor\") and each subsequent contributor (collectively wi"
        + "th the Original Contributor, the \"Contributors\") hereby grant you a non-exclusiv"
        + "e, worldwide, no-charge, transferable license to execute, prepare derivative wor"
        + "ks of, and distribute (internally and externally), for commercial and noncommerc"
        + "ial purposes, the original code contributed by Original Contributor and all Modi"
        + "fications (collectively called the \"Program\").\n"
        + "\n"
        + "Section 2. Definitions\n"
        + "\n"
        + "A \"Modification\" to the Program is any addition to or deletion from the contents"
        + " of any file of the Program and any new file that contains any part of the Progr"
        + "am. If you make a Modification and distribute the Program externally you are a \""
        + "Contributor.\" The distribution of the Program must be under the terms of this li"
        + "cense including those in Section 3 below.\n"
        + "\n"
        + "A \"Combined Work\" results from combining and integrating all or parts of the Pro"
        + "gram with other code. A Combined Work may be thought of as having multiple paren"
        + "ts or being result of multiple lines of code development.\n"
        + "\n"
        + "Section 3. Distribution Licensing Terms\n"
        + "\n"
        + "A. General Requirements\n"
        + "Except as necessary to recognize third-party rights or third-party restriction ("
        + "see below), a distribution of the Program in any of the forms listed below must "
        + "not put any further restrictions on the recipient’s exercise of the rights grant"
        + "ed herein.\n"
        + "\n"
        + "As a Contributor, you represent that your Modification(s) are your original crea"
        + "tion(s) and, to the best of your knowledge, no third party has any claim (includ"
        + "ing but not limited to intellectual property claims) relating to your Modificati"
        + "on(s). You represent that each of your Modifications includes complete details o"
        + "f any third-party right or other third-party restriction associated with any par"
        + "t of your Modification (including a copy of any applicable license agreement).\n"
        + "\n"
        + "The Program must be distributed without charge beyond the costs of physically tr"
        + "ansferring the files to the recipient.\n"
        + "\n"
        + "This Warranty Disclaimer/Limitation of Liability must be prominently displayed w"
        + "ith every distribution of the Program in any form:\n"
        + "\n"
        + "YOU AGREE THAT THE PROGRAM IS PROVIDED AS-IS, WITHOUT WARRANTY OF ANY KIND (EITH"
        + "ER EXPRESS OR IMPLIED). ACCORDINGLY, OCLC MAKES NO WARRANTIES, REPRESENTATIONS O"
        + "R GUARANTEES, EITHER EXPRESS OR IMPLIED, AND DISCLAIMS ALL SUCH WARRANTIES, REPR"
        + "ESENTATIONS OR GUARANTEES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTIES"
        + " OF MERCHANTABILITY AND FITNESS FOR ANY PARTICULAR PURPOSE, AS TO: (A) THE FUNCT"
        + "IONALITY OR NONINFRINGEMENT OF PROGRAM, ANY MODIFICATION, A COMBINED WORK OR AN "
        + "AGGREGATE WORK; OR (B) THE RESULTS OF ANY PROJECT UNDERTAKEN USING THE PROGRAM, "
        + "ANY MODIFICATION, A COMBINED WORK OR AN AGGREGATE WORK. IN NO EVENT SHALL THE CO"
        + "NTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, C"
        + "ONSEQUENTIAL OR ANY OTHER DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF"
        + " SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERR"
        + "UPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRI"
        + "CT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT"
        + " OF THE USE OF THE PROGRAM, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. "
        + "YOU HEREBY WAIVE ANY CLAIMS FOR DAMAGES OF ANY KIND AGAINST CONTRIBUTORS WHICH M"
        + "AY RESULT FROM YOUR USE OF THE PROGRAM.\n"
        + "\n"
        + "B. Requirements for a Distribution of Modifiable Code\n"
        + "If you distribute the Program in a form to which the recipient can make Modifica"
        + "tions (e.g. source code), the terms of this license apply to use by recipient. I"
        + "n addition, each source and data file of the Program and any Modification you di"
        + "stribute must contain the following notice:\n"
        + "\n"
        + "\"Copyright (c) 2000- (insert then current year) OCLC Online Computer Library Cen"
        + "ter, Inc. and other contributors. All rights reserved. The contents of this file"
        + ", as updated from time to time by the OCLC Office of Research, are subject to OC"
        + "LC Research Public License Version 2.0 (the \"License\"); you may not use this fil"
        + "e except in compliance with the License. You may obtain a current copy of the Li"
        + "cense at http://purl.oclc.org/oclc/research/ORPL/. Software distributed under th"
        + "e License is distributed on an \"AS IS\" basis, WITHOUT WARRANTY OF ANY KIND, eith"
        + "er express or implied. See the License for the specific language governing right"
        + "s and limitations under the License. This software consists of voluntary contrib"
        + "utions made by many individuals on behalf of OCLC Research. For more information"
        + " on OCLC Research, please see http://www.oclc.org/research/. The Original Code i"
        + "s ______________________________. The Initial Developer of the Original Code is "
        + "________________________. Portions created by ______________________ are Copyrig"
        + "ht (C) _____ _______________________. All Rights Reserved. Contributor(s): _____"
        + "_________________________________.\"\n"
        + "\n"
        + "C. Requirements for a Distribution of Non-modifiable Code\n"
        + "If you distribute the Program in a form to which the recipient cannot make Modif"
        + "ications (e.g. object code), the terms of this license apply to use by recipient"
        + " and you must include the following statement in appropriate and conspicuous loc"
        + "ations:\n"
        + "\n"
        + "\"Copyright (c) 2000- (insert then current year) OCLC Online Computer Library Cen"
        + "ter, Inc. and other contributors. All rights reserved.\"\n"
        + "\n"
        + "In addition, the source code must be included with the object code distribution "
        + "or the distributor must provide the source code to the recipient upon request.\n"
        + "\n"
        + "D. Requirements for a Combined Work Distribution\n"
        + "Distributions of Combined Works are subject to the terms of this license and mus"
        + "t be made at no charge to the recipient beyond the costs of physically transferr"
        + "ing the files to recipient.\n"
        + "\n"
        + "A Combined Work may be distributed as either modifiable or non-modifiable code. "
        + "The requirements of Section 3.B or 3.C above (as appropriate) apply to such dist"
        + "ributions.\n"
        + "\n"
        + "An \"Aggregate Work\" is when the Program exists, without integration, with other "
        + "programs on a storage medium. This License does not apply to portions of an Aggr"
        + "egate Work which are not covered by the definition of \"Program\" provided in this"
        + " License. You are not forbidden from selling an Aggregate Work. However, the Pro"
        + "gram contained in an Aggregate Work is subject to this License. Also, should the"
        + " Program be extracted from an Aggregate Work, this License applies to any use of"
        + " the Program apart from the Aggregate Work.\n"
        + "\n"
        + "Section 4. License Grant\n"
        + "\n"
        + "For purposes of permitting use of your Modifications by OCLC and other licensees"
        + " hereunder, you hereby grant to OCLC and such other licensees the non-exclusive,"
        + " worldwide, royalty-free, transferable, sublicenseable license to execute, copy,"
        + " alter, delete, modify, adapt, change, revise, enhance, develop, publicly displa"
        + "y, distribute (internally and externally) and/or create derivative works based o"
        + "n your Modifications (and derivative works thereof) in accordance with these Ter"
        + "ms. This Section 4 shall survive termination of this License for any reason.\n"
        + "\n"
        + "Section 5. Termination of Rights\n"
        + "\n"
        + "This non-exclusive license (with respect to the grant from a particular Contribu"
        + "tor) automatically terminates for any entity that initiates legal action for int"
        + "ellectual property infringement (with respect to the Program) against such Contr"
        + "ibutor as of the initiation of such action.\n"
        + "\n"
        + "If you fail to comply with this License, your rights (but not your obligations) "
        + "under this License shall terminate automatically unless you cure such breach wit"
        + "hin thirty (30) days of becoming aware of the noncompliance. All sublicenses gra"
        + "nted by you which preexist such termination and are properly granted shall survi"
        + "ve such termination.\n"
        + "\n"
        + "Section 6. Other Terms\n"
        + "\n"
        + "Except for the copyright notices required above, you may not use any trademark o"
        + "f any of the Contributors without the prior written consent of the relevant Cont"
        + "ributor. You agree not to remove, alter or obscure any copyright or other propri"
        + "etary rights notice contained in the Program.\n"
        + "\n"
        + "All transfers of the Program or any part thereof shall be made in compliance wit"
        + "h U.S. import/export regulations or other restrictions of the U.S. Department of"
        + " Commerce, as well as other similar trade or commerce restrictions which might a"
        + "pply.\n"
        + "\n"
        + "Any patent obtained by any party covering the Program or any part thereof must i"
        + "nclude a provision providing for the free, perpetual and unrestricted commercial"
        + " and noncommercial use by any third party.\n"
        + "\n"
        + "If, as a consequence of a court judgment or settlement relating to intellectual "
        + "property infringement or any other cause of action, conditions are imposed on yo"
        + "u that contradict the conditions of this License, such conditions do not excuse "
        + "you from compliance with this License. If you cannot distribute the Program so a"
        + "s to simultaneously satisfy your obligations under this License and such other c"
        + "onditions, you may not distribute the Program at all. For example, if a patent l"
        + "icense would not permit royalty-free redistribution of the Program by all those "
        + "who receive copies directly or indirectly through you, you could not satisfy bot"
        + "h the patent license and this License, and you would be required to refrain enti"
        + "rely from distribution of the Program.\n"
        + "\n"
        + "If you learn of a third party claim or other restriction relating to a Program y"
        + "ou have already distributed you shall promptly redo your Program to address the "
        + "issue and take all reasonable steps to inform those who may have received the Pr"
        + "ogram at issue. An example of an appropriate reasonable step to inform would be "
        + "posting an announcement on an appropriate web bulletin board.\n"
        + "\n"
        + "The provisions of this License are deemed to be severable, and the invalidity or"
        + " unenforceability of any provision shall not affect or impair the remaining prov"
        + "isions which shall continue in full force and effect. In substitution for any pr"
        + "ovision held unlawful, there shall be substituted a provision of similar import "
        + "reflecting the original intent of the parties hereto to the extent permissible u"
        + "nder law.\n"
        + "\n"
        + "The Original Contributor from time to time may change this License, and the amen"
        + "ded license will apply to all copies of the Program downloaded after the new lic"
        + "ense is posted. This License grants only the rights expressly stated herein and "
        + "provides you with no implied rights or licenses to the intellectual property of "
        + "any Contributor.\n"
        + "\n"
        + "This License is the complete and exclusive statement of the agreement between th"
        + "e parties concerning the subject matter hereof and may not be amended except by "
        + "the written agreement of the parties. This License shall be governed by and cons"
        + "trued in accordance with the laws of the State of Ohio and the United States of "
        + "America, without regard to principles of conflicts of law.\n"
; // the license text
    }
 
    
}
