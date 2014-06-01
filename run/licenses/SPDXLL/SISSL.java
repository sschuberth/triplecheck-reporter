package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:50Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SISSL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class SISSL extends License{
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
        return "SISSL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Sun Industry Standards Source License v1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Sun Industry Standards Source License - Version 1.1\n"
        + "\n"
        + "1.0 DEFINITIONS\n"
        + "\n"
        + "1.1 \"Commercial Use\" means distribution or otherwise making the Original Code av"
        + "ailable to a third party.\n"
        + "\n"
        + "1.2 \"Contributor Version\" means the combination of the Original Code, and the Mo"
        + "difications made by that particular Contributor.\n"
        + "\n"
        + "1.3 \"Electronic Distribution Mechanism\" means a mechanism generally accepted in "
        + "the software development community for the electronic transfer of data.\n"
        + "\n"
        + "1.4 \"Executable\" means Original Code in any form other than Source Code.\n"
        + "\n"
        + "1.5 \"Initial Developer\" means the individual or entity identified as the Initial"
        + " Developer in the Source Code notice required by Exhibit A.\n"
        + "\n"
        + "1.6 \"Larger Work\" means a work which combines Original Code or portions thereof "
        + "with code not governed by the terms of this License.\n"
        + "\n"
        + "1.7 \"License\" means this document.\n"
        + "\n"
        + "1.8 \"Licensable\" means having the right to grant, to the maximum extent possible"
        + ", whether at the time of the initial grant or subsequently acquired, any and all"
        + " of the rights conveyed herein.\n"
        + "\n"
        + "1.9 \"Modifications\" means any addition to or deletion from the substance or stru"
        + "cture of either the Original Code or any previous Modifications. A Modification "
        + "is:\n"
        + "A. Any addition to or deletion from the contents of a file containing Original "
        + "Code or previous Modifications.\n"
        + "B. Any new file that contains any part of the Original Code or previous Modific"
        + "ations.\n"
        + "\n"
        + "1.10 \"Original Code\" means Source Code of computer software code which is descri"
        + "bed in the Source Code notice required by Exhibit A as Original Code.\n"
        + "\n"
        + "1.11 \"Patent Claims\" means any patent claim(s), now owned or hereafter acquired,"
        + " including without limitation, method, process, and apparatus claims, in any pat"
        + "ent Licensable by grantor.\n"
        + "\n"
        + "1.12 \"Source Code\" means the preferred form of the Original Code for making modi"
        + "fications to it, including all modules it contains, plus any associated interfac"
        + "e definition files, or scripts used to control compilation and installation of a"
        + "n Executable.\n"
        + "\n"
        + "1.13 \"Standards\" means the standards identified in Exhibit B.\n"
        + "\n"
        + "1.14 \"You\" (or \"Your\") means an individual or a legal entity exercising rights u"
        + "nder, and complying with all of the terms of, this License or a future version o"
        + "f this License issued under Section 6.1. For legal entities, \"You'' includes any"
        + " entity which controls, is controlled by, or is under common control with You. F"
        + "or purposes of this definition, \"control'' means (a) the power, direct or indire"
        + "ct, to cause the direction or management of such entity, whether by contract or "
        + "otherwise, or (b) ownership of more than fifty percent (50%) of the outstanding "
        + "shares or beneficial ownership of such entity.\n"
        + "\n"
        + "2.0 SOURCE CODE LICENSE\n"
        + "\n"
        + "2.1 The Initial Developer Grant  The Initial Developer hereby grants You a world"
        + "-wide, royalty-free, non-exclusive license, subject to third party intellectual "
        + "property claims: \n"
        + "(a) under intellectual property rights (other than patent or trademark) Licensa"
        + "ble by Initial Developer to use, reproduce, modify, display, perform, sublicense"
        + " and distribute the Original Code (or portions thereof) with or without Modifica"
        + "tions, and/or as part of a Larger Work; and\n"
        + "(b) under Patents Claims infringed by the making, using or selling of Original "
        + "Code, to make, have made, use, practice, sell, and offer for sale, and/or otherw"
        + "ise dispose of the Original Code (or portions thereof). (c) the licenses grante"
        + "d in this Section 2.1(a) and (b) are effective on the date Initial Developer fir"
        + "st distributes Original Code under the terms of this License. (d) Notwithstandi"
        + "ng Section 2.1(b) above, no patent license is granted: 1) for code that You dele"
        + "te from the Original Code; 2) separate from the Original Code; or 3) for infring"
        + "ements caused by: i) the modification of the Original Code or ii) the combinatio"
        + "n of the Original Code with other software or devices, including but not limited"
        + " to Modifications. \n"
        + "\n"
        + "3.0 DISTRIBUTION OBLIGATIONS\n"
        + "\n"
        + "3.1 Application of License.  The Source Code version of Original Code may be dis"
        + "tributed only under the terms of this License or a future version of this Licens"
        + "e released under Section 6.1, and You must include a copy of this License with e"
        + "very copy of the Source Code You distribute. You may not offer or impose any ter"
        + "ms on any Source Code version that alters or restricts the applicable version of"
        + " this License or the recipients' rights hereunder. Your license for shipment of "
        + "the Contributor Version is conditioned upon Your full compliance with this Secti"
        + "on. The Modifications which You create must comply with all requirements set out"
        + " by the Standards body in effect one hundred twenty (120) days before You ship t"
        + "he Contributor Version. In the event that the Modifications do not meet such req"
        + "uirements, You agree to publish either (i) any deviation from the Standards prot"
        + "ocol resulting from implementation of Your Modifications and a reference impleme"
        + "ntation of Your Modifications or (ii) Your Modifications in Source Code form, an"
        + "d to make any such deviation and reference implementation or Modifications avail"
        + "able to all third parties under the same terms as this license on a royalty free"
        + " basis within thirty (30) days of Your first customer shipment of Your Modificat"
        + "ions.\n"
        + "\n"
        + "3.2 Required Notices.  You must duplicate the notice in Exhibit A in each file o"
        + "f the Source Code. If it is not possible to put such notice in a particular Sour"
        + "ce Code file due to its structure, then You must include such notice in a locati"
        + "on (such as a relevant directory) where a user would be likely to look for such "
        + "a notice. If You created one or more Modification(s) You may add Your name as a "
        + "Contributor to the notice described in Exhibit A. You must also duplicate this L"
        + "icense in any documentation for the Source Code where You describe recipients' r"
        + "ights or ownership rights relating to Initial Code. You may choose to offer, and"
        + " to charge a fee for, warranty, support, indemnity or liability obligations to o"
        + "ne or more recipients of Your version of the Code. However, You may do so only o"
        + "n Your own behalf, and not on behalf of the Initial Developer. You must make it "
        + "absolutely clear than any such warranty, support, indemnity or liability obligat"
        + "ion is offered by You alone, and You hereby agree to indemnify the Initial Devel"
        + "oper for any liability incurred by the Initial Developer as a result of warranty"
        + ", support, indemnity or liability terms You offer.\n"
        + "\n"
        + "3.3 Distribution of Executable Versions.  You may distribute Original Code in Ex"
        + "ecutable and Source form only if the requirements of Sections 3.1 and 3.2 have b"
        + "een met for that Original Code, and if You include a notice stating that the Sou"
        + "rce Code version of the Original Code is available under the terms of this Licen"
        + "se. The notice must be conspicuously included in any notice in an Executable or "
        + "Source versions, related documentation or collateral in which You describe recip"
        + "ients' rights relating to the Original Code. You may distribute the Executable a"
        + "nd Source versions of Your version of the Code or ownership rights under a licen"
        + "se of Your choice, which may contain terms different from this License, provided"
        + " that You are in compliance with the terms of this License. If You distribute th"
        + "e Executable and Source versions under a different license You must make it abso"
        + "lutely clear that any terms which differ from this License are offered by You al"
        + "one, not by the Initial Developer. You hereby agree to indemnify the Initial Dev"
        + "eloper for any liability incurred by the Initial Developer as a result of any su"
        + "ch terms You offer.\n"
        + "\n"
        + "3.4 Larger Works.  You may create a Larger Work by combining Original Code with "
        + "other code not governed by the terms of this License and distribute the Larger W"
        + "ork as a single product. In such a case, You must make sure the requirements of "
        + "this License are fulfilled for the Original Code.\n"
        + "\n"
        + "4.0 INABILITY TO COMPLY DUE TO STATUTE OR REGULATION\n"
        + "If it is impossible for You to comply with any of the terms of this License with"
        + " respect to some or all of the Original Code due to statute, judicial order, or "
        + "regulation then You must: (a) comply with the terms of this License to the maxim"
        + "um extent possible; and (b) describe the limitations and the code they affect. S"
        + "uch description must be included in the LEGAL file described in Section 3.2 and "
        + "must be included with all distributions of the Source Code. Except to the extent"
        + " prohibited by statute or regulation, such description must be sufficiently deta"
        + "iled for a recipient of ordinary skill to be able to understand it.\n"
        + "\n"
        + "5.0 APPLICATION OF THIS LICENSE\n"
        + "This License applies to code to which the Initial Developer has attached the not"
        + "ice in Exhibit A and to related Modifications as set out in Section 3.1.\n"
        + "\n"
        + "6.0 VERSIONS OF THE LICENSE\n"
        + "\n"
        + "6.1 New Versions.  Sun may publish revised and/or new versions of the License fr"
        + "om time to time. Each version will be given a distinguishing version number.\n"
        + "\n"
        + "6.2 Effect of New Versions.  Once Original Code has been published under a parti"
        + "cular version of the License, You may always continue to use it under the terms "
        + "of that version. You may also choose to use such Original Code under the terms o"
        + "f any subsequent version of the License published by Sun. No one other than Sun "
        + "has the right to modify the terms applicable to Original Code.\n"
        + "\n"
        + "7.0 DISCLAIMER OF WARRANTY\n"
        + "ORIGINAL CODE IS PROVIDED UNDER THIS LICENSE ON AN \"AS IS\" BASIS, WITHOUT WARRAN"
        + "TY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARR"
        + "ANTIES THAT THE ORIGINAL CODE IS FREE OF DEFECTS, MERCHANTABLE, FIT FOR A PARTIC"
        + "ULAR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANC"
        + "E OF THE ORIGINAL CODE IS WITH YOU. SHOULD ANY ORIGINAL CODE PROVE DEFECTIVE IN "
        + "ANY RESPECT, YOU (NOT THE INITIAL DEVELOPER) ASSUME THE COST OF ANY NECESSARY SE"
        + "RVICING, REPAIR OR CORRECTION. THIS DISCLAIMER OF WARRANTY CONSTITUTES AN ESSENT"
        + "IAL PART OF THIS LICENSE. NO USE OF ANY ORIGINAL CODE IS AUTHORIZED HEREUNDER EX"
        + "CEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "8.0 TERMINATION\n"
        + "\n"
        + "8.1 This License and the rights granted hereunder will terminate automatically i"
        + "f You fail to comply with terms herein and fail to cure such breach within 30 da"
        + "ys of becoming aware of the breach. All sublicenses to the Original Code which a"
        + "re properly granted shall survive any termination of this License. Provisions wh"
        + "ich, by their nature, must remain in effect beyond the termination of this Licen"
        + "se shall survive.\n"
        + "\n"
        + "8.2 In the event of termination under Section 8.1 above, all end user license ag"
        + "reements (excluding distributors and resellers) which have been validly granted "
        + "by You or any distributor hereunder prior to termination shall survive terminati"
        + "on.\n"
        + "\n"
        + "9.0 LIMIT OF LIABILITY\n"
        + "UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL THEORY, WHETHER TORT (INCLUDING NEGLIG"
        + "ENCE), CONTRACT, OR OTHERWISE, SHALL YOU, THE INITIAL DEVELOPER, ANY OTHER CONTR"
        + "IBUTOR, OR ANY DISTRIBUTOR OF ORIGINAL CODE, OR ANY SUPPLIER OF ANY OF SUCH PART"
        + "IES, BE LIABLE TO ANY PERSON FOR ANY INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUEN"
        + "TIAL DAMAGES OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF"
        + " GOODWILL, WORK STOPPAGE, COMPUTER FAILURE OR MALFUNCTION, OR ANY AND ALL OTHER "
        + "COMMERCIAL DAMAGES OR LOSSES, EVEN IF SUCH PARTY SHALL HAVE BEEN INFORMED OF THE"
        + " POSSIBILITY OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SHALL NOT APPLY TO LI"
        + "ABILITY FOR DEATH OR PERSONAL INJURY RESULTING FROM SUCH PARTY'S NEGLIGENCE TO T"
        + "HE EXTENT APPLICABLE LAW PROHIBITS SUCH LIMITATION. SOME JURISDICTIONS DO NOT AL"
        + "LOW THE EXCLUSION OR LIMITATION OF INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO THIS "
        + "EXCLUSION AND LIMITATION MAY NOT APPLY TO YOU.\n"
        + "\n"
        + "10.0 U.S. GOVERNMENT END USERS\n"
        + "U.S. Government: If this Software is being acquired by or on behalf of the U.S. "
        + "Government or by a U.S. Government prime contractor or subcontractor (at any tie"
        + "r), then the Government's rights in the Software and accompanying documentation "
        + "shall be only as set forth in this license; this is in accordance with 48 C.F.R."
        + " 227.7201 through 227.7202-4 (for Department of Defense (DoD) acquisitions) and "
        + "with 48 C.F.R. 2.101 and 12.212 (for non-DoD acquisitions).\n"
        + "\n"
        + "11.0 MISCELLANEOUS\n"
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
        + "EXHIBIT A - Sun Standards License\n"
        + "\n"
        + "\"The contents of this file are subject to the Sun Standards\n"
        + "License Version 1.1 (the \"License\");\n"
        + "You may not use this file except in compliance with the \n"
        + "License. You may obtain a copy of the\n"
        + "License at _______________________________.\n"
        + "\n"
        + "Software distributed under the License is distributed on \n"
        + "an \"AS IS\" basis, WITHOUT WARRANTY OF ANY KIND, either \n"
        + "express or implied. See the License for the specific\n"
        + "language governing rights and limitations under the License.\n"
        + "\n"
        + "The Original Code is ______________________________________.\n"
        + "\n"
        + "The Initial Developer of the Original Code is: \n"
        + "Sun Microsystems, Inc..\n"
        + "\n"
        + "Portions created by: _______________________________________\n"
        + "\n"
        + "are Copyright (C): _______________________________________\n"
        + "\n"
        + "All Rights Reserved.\n"
        + "\n"
        + "Contributor(s): _______________________________________\n"
        + " EXHIBIT B - Standards\n"
        + "\n"
        + "The Standard is defined as the following:\n"
        + "OpenOffice.org XML File Format Specification, located at http://xml.openoffice.o"
        + "rg\n"
        + "OpenOffice.org Application Programming Interface Specification, located at  http"
        + "://api.openoffice.org\n"
; // the license text
    }
 
    
}
