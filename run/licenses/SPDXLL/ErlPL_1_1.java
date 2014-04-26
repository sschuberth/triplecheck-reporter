package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:44:20Z
 * LicenseName: Apache-2.0
 * FileName: ErlPL_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class ErlPL_1_1 extends License{
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
        return "ErlPL-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Erlang Public License v1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "ERLANG PUBLIC LICENSE\n"
        + "Version 1.1\n"
        + "\n"
        + "1. Definitions.\n"
        + "\n"
        + "1.1. ``Contributor'' means each entity that creates or contributes to\n"
        + "the creation of Modifications.\n"
        + "\n"
        + "1.2. ``Contributor Version'' means the combination of the Original\n"
        + "Code, prior Modifications used by a Contributor, and the Modifications\n"
        + "made by that particular Contributor.\n"
        + "\n"
        + "1.3. ``Covered Code'' means the Original Code or Modifications or the\n"
        + "combination of the Original Code and Modifications, in each case\n"
        + "including portions thereof.\n"
        + "\n"
        + "1.4. ``Electronic Distribution Mechanism'' means a mechanism generally\n"
        + "accepted in the software development community for the electronic\n"
        + "transfer of data.\n"
        + "\n"
        + "1.5. ``Executable'' means Covered Code in any form other than Source\n"
        + "Code.\n"
        + "\n"
        + "1.6. ``Initial Developer'' means the individual or entity identified\n"
        + "as the Initial Developer in the Source Code notice required by Exhibit\n"
        + "A.\n"
        + "\n"
        + "1.7. ``Larger Work'' means a work which combines Covered Code or\n"
        + "portions thereof with code not governed by the terms of this License.\n"
        + "\n"
        + "1.8. ``License'' means this document.\n"
        + "\n"
        + "1.9. ``Modifications'' means any addition to or deletion from the\n"
        + "substance or structure of either the Original Code or any previous\n"
        + "Modifications. When Covered Code is released as a series of files, a\n"
        + "Modification is:\n"
        + "\n"
        + "A. Any addition to or deletion from the contents of a file containing\n"
        + "   Original Code or previous Modifications. \n"
        + "\n"
        + "B. Any new file that contains any part of the Original Code or\n"
        + "   previous Modifications. \n"
        + "\n"
        + "1.10. ``Original Code'' means Source Code of computer software code\n"
        + "which is described in the Source Code notice required by Exhibit A as\n"
        + "Original Code, and which, at the time of its release under this\n"
        + "License is not already Covered Code governed by this License.\n"
        + "\n"
        + "1.11. ``Source Code'' means the preferred form of the Covered Code for\n"
        + "making modifications to it, including all modules it contains, plus\n"
        + "any associated interface definition files, scripts used to control\n"
        + "compilation and installation of an Executable, or a list of source\n"
        + "code differential comparisons against either the Original Code or\n"
        + "another well known, available Covered Code of the Contributor's\n"
        + "choice. The Source Code can be in a compressed or archival form,\n"
        + "provided the appropriate decompression or de-archiving software is\n"
        + "widely available for no charge.\n"
        + "\n"
        + "1.12. ``You'' means an individual or a legal entity exercising rights\n"
        + "under, and complying with all of the terms of, this License. For legal\n"
        + "entities,``You'' includes any entity which controls, is controlled by,\n"
        + "or is under common control with You. For purposes of this definition,\n"
        + "``control'' means (a) the power, direct or indirect, to cause the\n"
        + "direction or management of such entity, whether by contract or\n"
        + "otherwise, or (b) ownership of fifty percent (50%) or more of the\n"
        + "outstanding shares or beneficial ownership of such entity.\n"
        + "\n"
        + "2. Source Code License.\n"
        + "\n"
        + "2.1. The Initial Developer Grant.\n"
        + "The Initial Developer hereby grants You a world-wide, royalty-free,\n"
        + "non-exclusive license, subject to third party intellectual property\n"
        + "claims:\n"
        + "\n"
        + "(a) to use, reproduce, modify, display, perform, sublicense and\n"
        + "    distribute the Original Code (or portions thereof) with or without\n"
        + "    Modifications, or as part of a Larger Work; and \n"
        + "\n"
        + "(b) under patents now or hereafter owned or controlled by Initial\n"
        + "    Developer, to make, have made, use and sell (``Utilize'') the\n"
        + "    Original Code (or portions thereof), but solely to the extent that\n"
        + "    any such patent is reasonably necessary to enable You to Utilize\n"
        + "    the Original Code (or portions thereof) and not to any greater\n"
        + "    extent that may be necessary to Utilize further Modifications or\n"
        + "    combinations. \n"
        + "\n"
        + "2.2. Contributor Grant.\n"
        + "Each Contributor hereby grants You a world-wide, royalty-free,\n"
        + "non-exclusive license, subject to third party intellectual property\n"
        + "claims:\n"
        + "\n"
        + "(a) to use, reproduce, modify, display, perform, sublicense and\n"
        + "    distribute the Modifications created by such Contributor (or\n"
        + "    portions thereof) either on an unmodified basis, with other\n"
        + "    Modifications, as Covered Code or as part of a Larger Work; and \n"
        + "\n"
        + "(b) under patents now or hereafter owned or controlled by Contributor,\n"
        + "    to Utilize the Contributor Version (or portions thereof), but\n"
        + "    solely to the extent that any such patent is reasonably necessary\n"
        + "    to enable You to Utilize the Contributor Version (or portions\n"
        + "    thereof), and not to any greater extent that may be necessary to\n"
        + "    Utilize further Modifications or combinations. \n"
        + "\n"
        + "3. Distribution Obligations.\n"
        + "\n"
        + "3.1. Application of License.\n"
        + "The Modifications which You contribute are governed by the terms of\n"
        + "this License, including without limitation Section 2.2. The Source\n"
        + "Code version of Covered Code may be distributed only under the terms\n"
        + "of this License, and You must include a copy of this License with\n"
        + "every copy of the Source Code You distribute. You may not offer or\n"
        + "impose any terms on any Source Code version that alters or restricts\n"
        + "the applicable version of this License or the recipients' rights\n"
        + "hereunder. However, You may include an additional document offering\n"
        + "the additional rights described in Section 3.5. \n"
        + "\n"
        + "3.2. Availability of Source Code.\n"
        + "Any Modification which You contribute must be made available in Source\n"
        + "Code form under the terms of this License either on the same media as\n"
        + "an Executable version or via an accepted Electronic Distribution\n"
        + "Mechanism to anyone to whom you made an Executable version available;\n"
        + "and if made available via Electronic Distribution Mechanism, must\n"
        + "remain available for at least twelve (12) months after the date it\n"
        + "initially became available, or at least six (6) months after a\n"
        + "subsequent version of that particular Modification has been made\n"
        + "available to such recipients. You are responsible for ensuring that\n"
        + "the Source Code version remains available even if the Electronic\n"
        + "Distribution Mechanism is maintained by a third party.\n"
        + "\n"
        + "3.3. Description of Modifications.\n"
        + "You must cause all Covered Code to which you contribute to contain a\n"
        + "file documenting the changes You made to create that Covered Code and\n"
        + "the date of any change. You must include a prominent statement that\n"
        + "the Modification is derived, directly or indirectly, from Original\n"
        + "Code provided by the Initial Developer and including the name of the\n"
        + "Initial Developer in (a) the Source Code, and (b) in any notice in an\n"
        + "Executable version or related documentation in which You describe the\n"
        + "origin or ownership of the Covered Code.\n"
        + "\n"
        + "3.4. Intellectual Property Matters\n"
        + "\n"
        + "(a) Third Party Claims.\n"
        + "    If You have knowledge that a party claims an intellectual property\n"
        + "    right in particular functionality or code (or its utilization\n"
        + "    under this License), you must include a text file with the source\n"
        + "    code distribution titled ``LEGAL'' which describes the claim and\n"
        + "    the party making the claim in sufficient detail that a recipient\n"
        + "    will know whom to contact. If you obtain such knowledge after You\n"
        + "    make Your Modification available as described in Section 3.2, You\n"
        + "    shall promptly modify the LEGAL file in all copies You make\n"
        + "    available thereafter and shall take other steps (such as notifying\n"
        + "    appropriate mailing lists or newsgroups) reasonably calculated to\n"
        + "    inform those who received the Covered Code that new knowledge has\n"
        + "    been obtained. \n"
        + "\n"
        + "(b) Contributor APIs.\n"
        + "    If Your Modification is an application programming interface and\n"
        + "    You own or control patents which are reasonably necessary to\n"
        + "    implement that API, you must also include this information in the\n"
        + "    LEGAL file. \n"
        + "\n"
        + "3.5. Required Notices.\n"
        + "You must duplicate the notice in Exhibit A in each file of the Source\n"
        + "Code, and this License in any documentation for the Source Code, where\n"
        + "You describe recipients' rights relating to Covered Code. If You\n"
        + "created one or more Modification(s), You may add your name as a\n"
        + "Contributor to the notice described in Exhibit A. If it is not\n"
        + "possible to put such notice in a particular Source Code file due to\n"
        + "its structure, then you must include such notice in a location (such\n"
        + "as a relevant directory file) where a user would be likely to look for\n"
        + "such a notice. You may choose to offer, and to charge a fee for,\n"
        + "warranty, support, indemnity or liability obligations to one or more\n"
        + "recipients of Covered Code. However, You may do so only on Your own\n"
        + "behalf, and not on behalf of the Initial Developer or any\n"
        + "Contributor. You must make it absolutely clear than any such warranty,\n"
        + "support, indemnity or liability obligation is offered by You alone,\n"
        + "and You hereby agree to indemnify the Initial Developer and every\n"
        + "Contributor for any liability incurred by the Initial Developer or\n"
        + "such Contributor as a result of warranty, support, indemnity or\n"
        + "liability terms You offer.\n"
        + "\n"
        + "3.6. Distribution of Executable Versions.\n"
        + "You may distribute Covered Code in Executable form only if the\n"
        + "requirements of Section 3.1-3.5 have been met for that Covered Code,\n"
        + "and if You include a notice stating that the Source Code version of\n"
        + "the Covered Code is available under the terms of this License,\n"
        + "including a description of how and where You have fulfilled the\n"
        + "obligations of Section 3.2. The notice must be conspicuously included\n"
        + "in any notice in an Executable version, related documentation or\n"
        + "collateral in which You describe recipients' rights relating to the\n"
        + "Covered Code. You may distribute the Executable version of Covered\n"
        + "Code under a license of Your choice, which may contain terms different\n"
        + "from this License, provided that You are in compliance with the terms\n"
        + "of this License and that the license for the Executable version does\n"
        + "not attempt to limit or alter the recipient's rights in the Source\n"
        + "Code version from the rights set forth in this License. If You\n"
        + "distribute the Executable version under a different license You must\n"
        + "make it absolutely clear that any terms which differ from this License\n"
        + "are offered by You alone, not by the Initial Developer or any\n"
        + "Contributor. You hereby agree to indemnify the Initial Developer and\n"
        + "every Contributor for any liability incurred by the Initial Developer\n"
        + "or such Contributor as a result of any such terms You offer.\n"
        + "\n"
        + "3.7. Larger Works.\n"
        + "You may create a Larger Work by combining Covered Code with other code\n"
        + "not governed by the terms of this License and distribute the Larger\n"
        + "Work as a single product. In such a case, You must make sure the\n"
        + "requirements of this License are fulfilled for the Covered Code.\n"
        + "\n"
        + "4. Inability to Comply Due to Statute or Regulation.\n"
        + "If it is impossible for You to comply with any of the terms of this\n"
        + "License with respect to some or all of the Covered Code due to statute\n"
        + "or regulation then You must: (a) comply with the terms of this License\n"
        + "to the maximum extent possible; and (b) describe the limitations and\n"
        + "the code they affect. Such description must be included in the LEGAL\n"
        + "file described in Section 3.4 and must be included with all\n"
        + "distributions of the Source Code. Except to the extent prohibited by\n"
        + "statute or regulation, such description must be sufficiently detailed\n"
        + "for a recipient of ordinary skill to be able to understand it.\n"
        + "\n"
        + "5. Application of this License.\n"
        + "\n"
        + "This License applies to code to which the Initial Developer has\n"
        + "attached the notice in Exhibit A, and to related Covered Code.\n"
        + "\n"
        + "6. CONNECTION TO MOZILLA PUBLIC LICENSE\n"
        + "\n"
        + "This Erlang License is a derivative work of the Mozilla Public\n"
        + "License, Version 1.0. It contains terms which differ from the Mozilla\n"
        + "Public License, Version 1.0.\n"
        + "\n"
        + "7. DISCLAIMER OF WARRANTY.\n"
        + "\n"
        + "COVERED CODE IS PROVIDED UNDER THIS LICENSE ON AN ``AS IS'' BASIS,\n"
        + "WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING,\n"
        + "WITHOUT LIMITATION, WARRANTIES THAT THE COVERED CODE IS FREE OF\n"
        + "DEFECTS, MERCHANTABLE, FIT FOR A PARTICULAR PURPOSE OR\n"
        + "NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF\n"
        + "THE COVERED CODE IS WITH YOU. SHOULD ANY COVERED CODE PROVE DEFECTIVE\n"
        + "IN ANY RESPECT, YOU (NOT THE INITIAL DEVELOPER OR ANY OTHER\n"
        + "CONTRIBUTOR) ASSUME THE COST OF ANY NECESSARY SERVICING, REPAIR OR\n"
        + "CORRECTION. THIS DISCLAIMER OF WARRANTY CONSTITUTES AN ESSENTIAL PART\n"
        + "OF THIS LICENSE. NO USE OF ANY COVERED CODE IS AUTHORIZED HEREUNDER\n"
        + "EXCEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "8. TERMINATION.\n"
        + "This License and the rights granted hereunder will terminate\n"
        + "automatically if You fail to comply with terms herein and fail to cure\n"
        + "such breach within 30 days of becoming aware of the breach. All\n"
        + "sublicenses to the Covered Code which are properly granted shall\n"
        + "survive any termination of this License. Provisions which, by their\n"
        + "nature, must remain in effect beyond the termination of this License\n"
        + "shall survive.\n"
        + "\n"
        + "9. DISCLAIMER OF LIABILITY\n"
        + "Any utilization of Covered Code shall not cause the Initial Developer\n"
        + "or any Contributor to be liable for any damages (neither direct nor\n"
        + "indirect).\n"
        + "\n"
        + "10. MISCELLANEOUS\n"
        + "This License represents the complete agreement concerning the subject\n"
        + "matter hereof. If any provision is held to be unenforceable, such\n"
        + "provision shall be reformed only to the extent necessary to make it\n"
        + "enforceable. This License shall be construed by and in accordance with\n"
        + "the substantive laws of Sweden. Any dispute, controversy or claim\n"
        + "arising out of or relating to this License, or the breach, termination\n"
        + "or invalidity thereof, shall be subject to the exclusive jurisdiction\n"
        + "of Swedish courts, with the Stockholm City Court as the first\n"
        + "instance.\n"
        + " \n"
        + "EXHIBIT A.\n"
        + "\n"
        + "``The contents of this file are subject to the Erlang Public License,\n"
        + "Version 1.1, (the \"License\"); you may not use this file except in\n"
        + "compliance with the License. You should have received a copy of the\n"
        + "Erlang Public License along with this software. If not, it can be\n"
        + "retrieved via the world wide web at http://www.erlang.org/.\n"
        + "\n"
        + "Software distributed under the License is distributed on an \"AS IS\"\n"
        + "basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See\n"
        + "the License for the specific language governing rights and limitations\n"
        + "under the License.\n"
        + "\n"
        + "The Initial Developer of the Original Code is Ericsson Utvecklings AB.\n"
        + "Portions created by Ericsson are Copyright 1999, Ericsson Utvecklings\n"
        + "AB. All Rights Reserved.''\n"
; // the license text
    }
 
    
}