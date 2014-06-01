package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:58Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Zimbra_1_3.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Zimbra_1_3 extends License{
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
        return "Zimbra-1.3"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Zimbra Public License v1.3"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Zimbra Public License, Version 1.3 (ZPL)\n"
        + "\n"
        + "This Zimbra Public License (this \"Agreement\") is a legal agreement that describe"
        + "s the terms under which VMware, Inc., a Delaware corporation having its principa"
        + "l place of business at 3401 Hillview Avenue, Palo Alto, California 94304 (\"VMwar"
        + "e\") will provide software to you via download or otherwise (\"Software\"). By usin"
        + "g the Software, you, an individual or an entity (\"You\") agree to the terms of th"
        + "is Agreement.\n"
        + "\n"
        + "In consideration of the mutual promises and upon the terms and conditions set fo"
        + "rth below, the parties agree as follows:\n"
        + "\n"
        + "1. Grant of Copyright License\n"
        + "1.1 - Subject to the terms and conditions of this Agreement, VMware hereby grant"
        + "s to You, under any and all of its copyright interest in and to the Software, a "
        + "royalty-free, non-exclusive, non-transferable license to copy, modify, compile, "
        + "execute, and distribute the Software and Modifications. For the purposes of this"
        + " Agreement, any change to, addition to, or abridgement of the Software made by Y"
        + "ou is a \"Modification;\" however, any file You add to the Software that does not "
        + "contain any part of the Software is not a \"Modification.\"\n"
        + "1.2 - If You are an individual acting on behalf of a corporation or other entity"
        + ", Your use of the Software or any Modification is subject to Your having the aut"
        + "hority to bind such corporation or entity to this Agreement. Providing copies to"
        + " persons within such corporation or entity is not considered distribution for pu"
        + "rposes of this Agreement.\n"
        + "1.3 - For the Software or any Modification You distribute in source code format,"
        + " You must do so only under the terms of this Agreement, and You must include a c"
        + "omplete copy of this Agreement with Your distribution. With respect to any Modif"
        + "ication You distribute in source code format, the terms of this Agreement will a"
        + "pply to You in the same way those terms apply to VMware with respect to the Soft"
        + "ware. In other words, when You are distributing Modifications under this Agreeme"
        + "nt, You \"stand in the shoes\" of VMware in terms of the rights You grant and how "
        + "the terms and conditions apply to You and the licensees of Your Modifications. N"
        + "otwithstanding the foregoing, when You \"stand in the shoes\" of VMware, You are n"
        + "ot subject to the jurisdiction provision under Section 7, which requires all dis"
        + "putes under this Agreement to be subject to the jurisdiction of federal or state"
        + " courts of northern California.\n"
        + "1.4 - For the Software or any Modification You distribute in compiled or object "
        + "code format, You must also provide recipients with access to the Software or Mod"
        + "ification in source code format along with a complete copy of this Agreement. Th"
        + "e distribution of the Software or Modifications in compiled or object code forma"
        + "t may be under a license of Your choice, provided that You are in compliance wit"
        + "h the terms of this Agreement. In addition, You must make absolutely clear that "
        + "any license terms applying to such Software or Modification that differ from thi"
        + "s Agreement are offered by You alone and not by VMware, and that such license do"
        + "es not restrict recipients from exercising rights in the source code to the Soft"
        + "ware granted by VMware under this Agreement or rights in the source code to any "
        + "Modification granted by You as described in Section 1.3.\n"
        + "1.5 - This Agreement does not limit Your right to distribute files that are enti"
        + "rely Your own work (i.e., which do not incorporate any portion of the Software a"
        + "nd are not Modifications) under any terms You choose.\n"
        + "\n"
        + "2. Support\n"
        + "VMware has no obligation to provide technical support or updates to You. Nothing"
        + " in this Agreement requires VMware to enter into any license with You for any ot"
        + "her edition of the Software.\n"
        + "\n"
        + "3. Intellectual Property Rights\n"
        + "3.1 - Except for the license expressly granted under copyright in Section 1.1, n"
        + "o rights, licenses or forbearances are granted or may arise in relation to this "
        + "Agreement whether expressly, by implication, exhaustion, estoppel or otherwise. "
        + "All rights, including all intellectual property rights, that are not expressly g"
        + "ranted under this Agreement are hereby reserved.\n"
        + "3.2 - In any copy of the Software or in any Modification you create, You must re"
        + "tain and reproduce, any and all copyright, patent, trademark, and attribution no"
        + "tices that are included in the Software in the same form as they appear in the S"
        + "oftware. This includes the preservation of attribution notices in the form of tr"
        + "ademarks or logos that exist within a user interface of the Software.\n"
        + "3.3 - This license does not grant You rights to use any party's name, logo, or t"
        + "rademarks, except solely as necessary to comply with Section 3.2.\n"
        + "\n"
        + "4. Disclaimer of Warranties\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\" AND WITHOUT WARRANTY OF ANY KIND. VMWARE MAKES "
        + "NO WARRANTIES, WHETHER EXPRESS, IMPLIED, OR STATUTORY REGARDING OR RELATING TO T"
        + "HE SOFTWARE. SPECIFICALLY, VMWARE DOES NOT WARRANT THAT THE SOFTWARE WILL BE ERR"
        + "OR FREE OR WILL PERFORM IN AN UNINTERRUPTED MANNER. TO THE GREATEST EXTENT ALLOW"
        + "ED BY LAW, VMWARE SPECIFICALLY DISCLAIMS ALL IMPLIED WARRANTIES OF MERCHANTABILI"
        + "TY, FITNESS FOR A PARTICULAR PURPOSE (EVEN IF VMWARE HAD BEEN INFORMED OF SUCH P"
        + "URPOSE), AND NONINFRINGEMENT WITH RESPECT TO THE SOFTWARE, ANY MODIFICATIONS THE"
        + "RETO AND WITH RESPECT TO THE USE OF THE FOREGOING.\n"
        + "\n"
        + "5. Limitation of Liability\n"
        + "IN NO EVENT WILL VMWARE BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,"
        + " EXEMPLARY, OR CONSEQUENTIAL DAMAGES OF ANY KIND (INCLUDING WITHOUT LIMITATION L"
        + "OSS OF PROFITS, LOSS OF USE, BUSINESS INTERRUPTION, LOSS OF DATA, COST OF COVER)"
        + " IN CONNECTION WITH OR ARISING OUT OF OR RELATING TO THE FURNISHING, PERFORMANCE"
        + " OR USE OF THE SOFTWARE OR ANY OTHER RIGHTS GRANTED HEREUNDER, WHETHER ALLEGED A"
        + "S A BREACH OF CONTRACT OR TORTIOUS CONDUCT, INCLUDING NEGLIGENCE, AND EVEN IF VM"
        + "WARE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "6. Term and Termination\n"
        + "6.1 - This Agreement will continue in effect unless and until terminated earlier"
        + " pursuant to this Section 6.\n"
        + "6.2 - In the event You violate the terms of this Agreement, VMware may terminate"
        + " this Agreement.\n"
        + "6.3 - All licenses granted hereunder shall terminate upon the termination of thi"
        + "s Agreement. Termination will be in addition to any rights and remedies availabl"
        + "e to VMware at law or equity or under this Agreement.\n"
        + "6.4 - Termination of this Agreement will not affect the provisions regarding res"
        + "ervation of rights (Section 3.1), provisions disclaiming or limiting VMware's li"
        + "ability (Sections 4 and 5), Termination (Section 6) or Miscellaneous (Section 7)"
        + ", which provisions will survive termination of this Agreement.\n"
        + "\n"
        + "7. Miscellaneous\n"
        + "This Agreement contains the entire agreement of the parties with respect to the "
        + "subject matter of this Agreement and supersedes all previous communications, rep"
        + "resentations, understandings and agreements, either oral or written, between the"
        + " parties with respect to said subject matter. The relationship of the parties he"
        + "reunder is that of independent contractors, and this Agreement will not be const"
        + "rued as creating an agency, partnership, joint venture or any other form of lega"
        + "l association between the parties. If any term, condition, or provision in this "
        + "Agreement is found to be invalid, unlawful or unenforceable to any extent, this "
        + "Agreement will be construed in a manner that most closely effectuates the intent"
        + " of this Agreement. Such invalid term, condition or provision will be severed fr"
        + "om the remaining terms, conditions and provisions, which will continue to be val"
        + "id and enforceable to the fullest extent permitted by law. This Agreement will b"
        + "e interpreted and construed in accordance with the laws of the State of Californ"
        + "ia and the United States of America, without regard to conflict of law principle"
        + "s. The U.N. Convention on Contracts for the International Sale of Goods shall no"
        + "t apply to this Agreement. All disputes arising out of this Agreement involving "
        + "VMware or any of its subsidiaries shall be subject to the jurisdiction of the fe"
        + "deral or state courts of northern California, with venue lying in Santa Clara Co"
        + "unty, California. No rights may be assigned, no obligations may be delegated, an"
        + "d this Agreement may not be transferred by You, in whole or in part, whether vol"
        + "untary or by operation of law, including by way of sale of assets, merger or con"
        + "solidation, without the prior written consent of VMware, and any purported assig"
        + "nment, delegation or transfer without such consent shall be void ab initio. Any "
        + "waiver of the provisions of this Agreement or of a party's rights or remedies un"
        + "der this Agreement must be in writing to be effective. Failure, neglect or delay"
        + " by a party to enforce the provisions of this Agreement or its rights or remedie"
        + "s at any time, will not be construed or be deemed to be a waiver of such party's"
        + " rights under this Agreement and will not in any way affect the validity of the "
        + "whole or any part of this Agreement or prejudice such party's right to take subs"
        + "equent action.\n"
; // the license text
    }
 
    
}
