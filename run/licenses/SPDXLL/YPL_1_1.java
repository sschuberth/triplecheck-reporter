package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:57Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: YPL_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class YPL_1_1 extends License{
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
        return "YPL-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Yahoo! Public License v1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Yahoo! Public License, Version 1.1 (YPL)\n"
        + "\n"
        + "This Yahoo! Public License (this \"Agreement\") is a legal agreement that describe"
        + "s the terms under which Yahoo! Inc., a Delaware corporation having its principal"
        + " place of business at 701 First Avenue, Sunnyvale, California 94089 (\"Yahoo!\") w"
        + "ill provide software to you via download or otherwise (\"Software\"). By using the"
        + " Software, you, an individual or an entity (\"You\") agree to the terms of this Ag"
        + "reement.\n"
        + "\n"
        + "In consideration of the mutual promises and upon the terms and conditions set fo"
        + "rth below, the parties agree as follows:\n"
        + "\n"
        + "1.Grant of Copyright License\n"
        + "1.1 - Subject to the terms and conditions of this Agreement, Yahoo! hereby gran"
        + "ts to You, under any and all of its copyright interest in and to the Software, a"
        + " royalty-free, non-exclusive, non-transferable license to copy, modify, compile,"
        + " execute, and distribute the Software and Modifications. For the purposes of thi"
        + "s Agreement, any change to, addition to, or abridgement of the Software made by "
        + "You is a \"Modification;\" however, any file You add to the Software that does not"
        + " contain any part of the Software is not a \"Modification.\"\n"
        + "1.2 - If You are an individual acting on behalf of a corporation or other entit"
        + "y, Your use of the Software or any Modification is subject to Your having the au"
        + "thority to bind such corporation or entity to this Agreement. Providing copies t"
        + "o persons within such corporation or entity is not considered distribution for p"
        + "urposes of this Agreement.\n"
        + "1.3 - For the Software or any Modification You distribute in source code format"
        + ", You must do so only under the terms of this Agreement, and You must include a "
        + "complete copy of this Agreement with Your distribution. With respect to any Modi"
        + "fication You distribute in source code format, the terms of this Agreement will "
        + "apply to You in the same way those terms apply to Yahoo! with respect to the Sof"
        + "tware. In other words, when You are distributing Modifications under this Agreem"
        + "ent, You \"stand in the shoes\" of Yahoo! in terms of the rights You grant and how"
        + " the terms and conditions apply to You and the licensees of Your Modifications. "
        + "Notwithstanding the foregoing, when You \"stand in the shoes\" of Yahoo!, You are "
        + "not subject to the jurisdiction provision under Section 7, which requires all di"
        + "sputes under this Agreement to be subject to the jurisdiction of federal or stat"
        + "e courts of northern California.\n"
        + "1.4 - For the Software or any Modification You distribute in compiled or object"
        + " code format, You must also provide recipients with access to the Software or Mo"
        + "dification in source code format along with a complete copy of this Agreement. T"
        + "he distribution of the Software or Modifications in compiled or object code form"
        + "at may be under a license of Your choice, provided that You are in compliance wi"
        + "th the terms of this Agreement. In addition, You must make absolutely clear that"
        + " any license terms applying to such Software or Modification that differ from th"
        + "is Agreement are offered by You alone and not by Yahoo!, and that such license d"
        + "oes not restrict recipients from exercising rights in the source code to the Sof"
        + "tware granted by Yahoo! under this Agreement or rights in the source code to any"
        + " Modification granted by You as described in Section 1.3.\n"
        + "1.5 - This Agreement does not limit Your right to distribute files that are ent"
        + "irely Your own work (i.e., which do not incorporate any portion of the Software "
        + "and are not Modifications) under any terms You choose.\n"
        + "\n"
        + "2.Support\n"
        + "Yahoo! has no obligation to provide technical support or updates to You. Nothin"
        + "g in this Agreement requires Yahoo! to enter into any license with You for any o"
        + "ther edition of the Software.\n"
        + "\n"
        + "3.Intellectual Property Rights\n"
        + "3.1 - Except for the license expressly granted under copyright in Section 1.1, "
        + "no rights, licenses or forbearances are granted or may arise in relation to this"
        + " Agreement whether expressly, by implication, exhaustion, estoppel or otherwise."
        + " All rights, including all intellectual property rights, that are not expressly "
        + "granted under this Agreement are hereby reserved.\n"
        + "3.2 - In any copy of the Software or in any Modification you create, You must r"
        + "etain and reproduce, any and all copyright, patent, trademark, and attribution n"
        + "otices that are included in the Software in the same form as they appear in the "
        + "Software. This includes the preservation of attribution notices in the form of t"
        + "rademarks or logos that exist within a user interface of the Software.\n"
        + "3.3 - This license does not grant You rights to use any party's name, logo, or "
        + "trademarks, except solely as necessary to comply with Section 3.2.\n"
        + "\n"
        + "4.Disclaimer of Warranties\n"
        + "THE SOFTWARE IS PROVIDED \"AS IS\" AND WITHOUT WARRANTY OF ANY KIND. YAHOO! MAKES"
        + " NO WARRANTIES, WHETHER EXPRESS, IMPLIED, OR STATUTORY REGARDING OR RELATING TO "
        + "THE SOFTWARE. SPECIFICALLY, YAHOO! DOES NOT WARRANT THAT THE SOFTWARE WILL BE ER"
        + "ROR FREE OR WILL PERFORM IN AN UNINTERRUPTED MANNER. TO THE GREATEST EXTENT ALLO"
        + "WED BY LAW, YAHOO! SPECIFICALLY DISCLAIMS ALL IMPLIED WARRANTIES OF MERCHANTABIL"
        + "ITY, FITNESS FOR A PARTICULAR PURPOSE (EVEN IF YAHOO! HAD BEEN INFORMED OF SUCH "
        + "PURPOSE), AND NONINFRINGEMENT WITH RESPECT TO THE SOFTWARE, ANY MODIFICATIONS TH"
        + "ERETO AND WITH RESPECT TO THE USE OF THE FOREGOING.\n"
        + "\n"
        + "5.Limitation of Liability\n"
        + "IN NO EVENT WILL YAHOO! BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL"
        + ", EXEMPLARY, OR CONSEQUENTIAL DAMAGES OF ANY KIND (INCLUDING WITHOUT LIMITATION "
        + "LOSS OF PROFITS, LOSS OF USE, BUSINESS INTERRUPTION, LOSS OF DATA, COST OF COVER"
        + ") IN CONNECTION WITH OR ARISING OUT OF OR RELATING TO THE FURNISHING, PERFORMANC"
        + "E OR USE OF THE SOFTWARE OR ANY OTHER RIGHTS GRANTED HEREUNDER, WHETHER ALLEGED "
        + "AS A BREACH OF CONTRACT OR TORTIOUS CONDUCT, INCLUDING NEGLIGENCE, AND EVEN IF Y"
        + "AHOO! HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "6.Term and Termination\n"
        + "6.1 - This Agreement will continue in effect unless and until terminated earlie"
        + "r pursuant to this Section 6.\n"
        + "6.2 - In the event You violate the terms of this Agreement, Yahoo! may terminat"
        + "e this Agreement.\n"
        + "6.3 - All licenses granted hereunder shall terminate upon the termination of th"
        + "is Agreement. Termination will be in addition to any rights and remedies availab"
        + "le to Yahoo! at law or equity or under this Agreement.\n"
        + "6.4 - Termination of this Agreement will not affect the provisions regarding re"
        + "servation of rights (Section 3.1), provisions disclaiming or limiting Yahoo!'s l"
        + "iability (Sections 4 and 5), Termination (Section 6) or Miscellaneous (Section 7"
        + "), which provisions will survive termination of this Agreement.\n"
        + "\n"
        + "7.Miscellaneous\n"
        + "This Agreement contains the entire agreement of the parties with respect to the"
        + " subject matter of this Agreement and supersedes all previous communications, re"
        + "presentations, understandings and agreements, either oral or written, between th"
        + "e parties with respect to said subject matter. The relationship of the parties h"
        + "ereunder is that of independent contractors, and this Agreement will not be cons"
        + "trued as creating an agency, partnership, joint venture or any other form of leg"
        + "al association between the parties. If any term, condition, or provision in this"
        + " Agreement is found to be invalid, unlawful or unenforceable to any extent, this"
        + " Agreement will be construed in a manner that most closely effectuates the inten"
        + "t of this Agreement. Such invalid term, condition or provision will be severed f"
        + "rom the remaining terms, conditions and provisions, which will continue to be va"
        + "lid and enforceable to the fullest extent permitted by law. This Agreement will "
        + "be interpreted and construed in accordance with the laws of the State of Califor"
        + "nia and the United States of America, without regard to conflict of law principl"
        + "es. The U.N. Convention on Contracts for the International Sale of Goods shall n"
        + "ot apply to this Agreement. All disputes arising out of this Agreement involving"
        + " Yahoo! or any of its subsidiaries shall be subject to the jurisdiction of the f"
        + "ederal or state courts of northern California, with venue lying in Santa Clara C"
        + "ounty, California. No rights may be assigned, no obligations may be delegated, a"
        + "nd this Agreement may not be transferred by You, in whole or in part, whether vo"
        + "luntary or by operation of law, including by way of sale of assets, merger or co"
        + "nsolidation, without the prior written consent of Yahoo!, and any purported assi"
        + "gnment, delegation or transfer without such consent shall be void ab initio. Any"
        + " waiver of the provisions of this Agreement or of a party's rights or remedies u"
        + "nder this Agreement must be in writing to be effective. Failure, neglect or dela"
        + "y by a party to enforce the provisions of this Agreement or its rights or remedi"
        + "es at any time, will not be construed or be deemed to be a waiver of such party'"
        + "s rights under this Agreement and will not in any way affect the validity of the"
        + " whole or any part of this Agreement or prejudice such party's right to take sub"
        + "sequent action.\n"
; // the license text
    }
 
    
}
