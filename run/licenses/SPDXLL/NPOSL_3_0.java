package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:21Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: NPOSL_3_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class NPOSL_3_0 extends License{
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
        return "NPOSL-3.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Non-Profit Open Software License 3.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Non-Profit Open Software License (\"Non-Profit OSL\") 3.0\n"
        + "\n"
        + "This Non-Profit Open Software License (\"Non-Profit OSL\") version 3.0 (the \"Licen"
        + "se\") applies to any original work of authorship (the \"Original Work\") whose owne"
        + "r (the \"Licensor\") has placed the following licensing notice adjacent to the cop"
        + "yright notice for the Original Work:\n"
        + "\n"
        + "Licensed under the Non-Profit Open Software License version 3.0\n"
        + "\n"
        + "1) Grant of Copyright License. Licensor grants You a worldwide, royalty-free, no"
        + "n-exclusive, sublicensable license, for the duration of the copyright, to do the"
        + " following:\n"
        + "\n"
        + "a) to reproduce the Original Work in copies, either alone or as part of a collec"
        + "tive work;\n"
        + "\n"
        + "b) to translate, adapt, alter, transform, modify, or arrange the Original Work, "
        + "thereby creating derivative works (\"Derivative Works\") based upon the Original W"
        + "ork;\n"
        + "\n"
        + "c) to distribute or communicate copies of the Original Work and Derivative Works"
        + " to the public, with the proviso that copies of Original Work or Derivative Work"
        + "s that You distribute or communicate shall be licensed under this Non-Profit Ope"
        + "n Software License or as provided in section 17(d);\n"
        + "\n"
        + "d) to perform the Original Work publicly; and\n"
        + "\n"
        + "e) to display the Original Work publicly.\n"
        + "\n"
        + "2) Grant of Patent License. Licensor grants You a worldwide, royalty-free, non-e"
        + "xclusive, sublicensable license, under patent claims owned or controlled by the "
        + "Licensor that are embodied in the Original Work as furnished by the Licensor, fo"
        + "r the duration of the patents, to make, use, sell, offer for sale, have made, an"
        + "d import the Original Work and Derivative Works.\n"
        + "\n"
        + "3) Grant of Source Code License. The term \"Source Code\" means the preferred form"
        + " of the Original Work for making modifications to it and all available documenta"
        + "tion describing how to modify the Original Work. Licensor agrees to provide a ma"
        + "chine-readable copy of the Source Code of the Original Work along with each copy"
        + " of the Original Work that Licensor distributes. Licensor reserves the right to "
        + "satisfy this obligation by placing a machine-readable copy of the Source Code in"
        + " an information repository reasonably calculated to permit inexpensive and conve"
        + "nient access by You for as long as Licensor continues to distribute the Original"
        + " Work.\n"
        + "\n"
        + "4) Exclusions From License Grant. Neither the names of Licensor, nor the names o"
        + "f any contributors to the Original Work, nor any of their trademarks or service "
        + "marks, may be used to endorse or promote products derived from this Original Wor"
        + "k without express prior permission of the Licensor. Except as expressly stated h"
        + "erein, nothing in this License grants any license to Licensor's trademarks, copy"
        + "rights, patents, trade secrets or any other intellectual property. No patent lic"
        + "ense is granted to make, use, sell, offer for sale, have made, or import embodim"
        + "ents of any patent claims other than the licensed claims defined in Section 2. N"
        + "o license is granted to the trademarks of Licensor even if such marks are includ"
        + "ed in the Original Work. Nothing in this License shall be interpreted to prohibi"
        + "t Licensor from licensing under terms different from this License any Original W"
        + "ork that Licensor otherwise would have a right to license.\n"
        + "\n"
        + "5) External Deployment. The term \"External Deployment\" means the use, distributi"
        + "on, or communication of the Original Work or Derivative Works in any way such th"
        + "at the Original Work or Derivative Works may be used by anyone other than You, w"
        + "hether those works are distributed or communicated to those persons or made avai"
        + "lable as an application intended for use over a network. As an express condition"
        + " for the grants of license hereunder, You must treat any External Deployment by "
        + "You of the Original Work or a Derivative Work as a distribution under section 1("
        + "c).\n"
        + "\n"
        + "6) Attribution Rights. You must retain, in the Source Code of any Derivative Wor"
        + "ks that You create, all copyright, patent, or trademark notices from the Source "
        + "Code of the Original Work, as well as any notices of licensing and any descripti"
        + "ve text identified therein as an \"Attribution Notice.\" You must cause the Source"
        + " Code for any Derivative Works that You create to carry a prominent Attribution "
        + "Notice reasonably calculated to inform recipients that You have modified the Ori"
        + "ginal Work.\n"
        + "\n"
        + "7) Warranty of Provenance and Disclaimer of Warranty. The Original Work is provi"
        + "ded under this License on an \"AS IS\" BASIS and WITHOUT WARRANTY, either express "
        + "or implied, including, without limitation, the warranties of non-infringement, m"
        + "erchantability or fitness for a particular purpose. THE ENTIRE RISK AS TO THE QU"
        + "ALITY OF THE ORIGINAL WORK IS WITH YOU. This DISCLAIMER OF WARRANTY constitutes "
        + "an essential part of this License. No license to the Original Work is granted by"
        + " this License except under this disclaimer.\n"
        + "\n"
        + "8) Limitation of Liability. Under no circumstances and under no legal theory, wh"
        + "ether in tort (including negligence), contract, or otherwise, shall the Licensor"
        + " be liable to anyone for any direct, indirect, special, incidental, or consequen"
        + "tial damages of any character arising as a result of this License or the use of "
        + "the Original Work including, without limitation, damages for loss of goodwill, w"
        + "ork stoppage, computer failure or malfunction, or any and all other commercial d"
        + "amages or losses. This limitation of liability shall not apply to the extent app"
        + "licable law prohibits such limitation.\n"
        + "\n"
        + "9) Acceptance and Termination. If, at any time, You expressly assented to this L"
        + "icense, that assent indicates your clear and irrevocable acceptance of this Lice"
        + "nse and all of its terms and conditions. If You distribute or communicate copies"
        + " of the Original Work or a Derivative Work, You must make a reasonable effort un"
        + "der the circumstances to obtain the express assent of recipients to the terms of"
        + " this License. This License conditions your rights to undertake the activities l"
        + "isted in Section 1, including your right to create Derivative Works based upon t"
        + "he Original Work, and doing so without honoring these terms and conditions is pr"
        + "ohibited by copyright law and international treaty. Nothing in this License is i"
        + "ntended to affect copyright exceptions and limitations (including \"fair use\" or "
        + "\"fair dealing\"). This License shall terminate immediately and You may no longer "
        + "exercise any of the rights granted to You by this License upon your failure to h"
        + "onor the conditions in Section 1(c).\n"
        + "\n"
        + "10) Termination for Patent Action. This License shall terminate automatically an"
        + "d You may no longer exercise any of the rights granted to You by this License as"
        + " of the date You commence an action, including a cross-claim or counterclaim, ag"
        + "ainst Licensor or any licensee alleging that the Original Work infringes a paten"
        + "t. This termination provision shall not apply for an action alleging patent infr"
        + "ingement by combinations of the Original Work with other software or hardware.\n"
        + "\n"
        + "11) Jurisdiction, Venue and Governing Law. Any action or suit relating to this L"
        + "icense may be brought only in the courts of a jurisdiction wherein the Licensor "
        + "resides or in which Licensor conducts its primary business, and under the laws o"
        + "f that jurisdiction excluding its conflict-of-law provisions. The application of"
        + " the United Nations Convention on Contracts for the International Sale of Goods "
        + "is expressly excluded. Any use of the Original Work outside the scope of this Li"
        + "cense or after its termination shall be subject to the requirements and penaltie"
        + "s of copyright or patent law in the appropriate jurisdiction. This section shall"
        + " survive the termination of this License.\n"
        + "\n"
        + "12) Attorneys' Fees. In any action to enforce the terms of this License or seeki"
        + "ng damages relating thereto, the prevailing party shall be entitled to recover i"
        + "ts costs and expenses, including, without limitation, reasonable attorneys' fees"
        + " and costs incurred in connection with such action, including any appeal of such"
        + " action. This section shall survive the termination of this License.\n"
        + "\n"
        + "13) Miscellaneous. If any provision of this License is held to be unenforceable,"
        + " such provision shall be reformed only to the extent necessary to make it enforc"
        + "eable.\n"
        + "\n"
        + "14) Definition of \"You\" in This License. \"You\" throughout this License, whether "
        + "in upper or lower case, means an individual or a legal entity exercising rights "
        + "under, and complying with all of the terms of, this License. For legal entities,"
        + " \"You\" includes any entity that controls, is controlled by, or is under common c"
        + "ontrol with you. For purposes of this definition, \"control\" means (i) the power,"
        + " direct or indirect, to cause the direction or management of such entity, whethe"
        + "r by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of "
        + "the outstanding shares, or (iii) beneficial ownership of such entity.\n"
        + "\n"
        + "15) Right to Use. You may use the Original Work in all ways not otherwise restri"
        + "cted or conditioned by this License or by law, and Licensor promises not to inte"
        + "rfere with or be responsible for such uses by You.\n"
        + "\n"
        + "16) Modification of This License. This License is Copyright © 2005 Lawrence Rose"
        + "n. Permission is granted to copy, distribute, or communicate this License withou"
        + "t modification. Nothing in this License permits You to modify this License as ap"
        + "plied to the Original Work or to Derivative Works. However, You may modify the t"
        + "ext of this License and copy, distribute or communicate your modified version (t"
        + "he \"Modified License\") and apply it to other original works of authorship subjec"
        + "t to the following conditions: (i) You may not indicate in any way that your Mod"
        + "ified License is the \"Open Software License\" or \"OSL\" and you may not use those "
        + "names in the name of your Modified License; (ii) You must replace the notice spe"
        + "cified in the first paragraph above with the notice \"Licensed under <insert your"
        + " license name here>\" or with a notice of your own that is not confusingly simila"
        + "r to the notice in this License; and (iii) You may not claim that your original "
        + "works are open source software unless your Modified License has been approved by"
        + " Open Source Initiative (OSI) and You comply with its license review and certifi"
        + "cation process.\n"
        + "\n"
        + "17) Non-Profit Amendment. The name of this amended version of the Open Software "
        + "License (\"OSL 3.0\") is \"Non-Profit Open Software License 3.0\". The original OSL "
        + "3.0 license has been amended as follows:\n"
        + "\n"
        + "(a) Licensor represents and declares that it is a not-for-profit organization th"
        + "at derives no revenue whatsoever from the distribution of the Original Work or D"
        + "erivative Works thereof, or from support or services relating thereto.\n"
        + "\n"
        + "(b) The first sentence of Section 7 [\"Warranty of Provenance\"] of OSL 3.0 has be"
        + "en stricken. For Original Works licensed under this Non-Profit OSL 3.0, LICENSOR"
        + " OFFERS NO WARRANTIES WHATSOEVER.\n"
        + "\n"
        + "(c) In the first sentence of Section 8 [\"Limitation of Liability\"] of this Non-P"
        + "rofit OSL 3.0, the list of damages for which LIABILITY IS LIMITED now includes \""
        + "direct\" damages.\n"
        + "\n"
        + "(d) The proviso in Section 1(c) of this License now refers to this \"Non-Profit O"
        + "pen Software License\" rather than the \"Open Software License\". You may distribut"
        + "e or communicate the Original Work or Derivative Works thereof under this Non-Pr"
        + "ofit OSL 3.0 license only if You make the representation and declaration in para"
        + "graph (a) of this Section 17. Otherwise, You shall distribute or communicate the"
        + " Original Work or Derivative Works thereof only under the OSL 3.0 license and Yo"
        + "u shall publish clear licensing notices so stating. Also by way of clarification"
        + ", this License does not authorize You to distribute or communicate works under t"
        + "his Non-Profit OSL 3.0 if You received them under the original OSL 3.0 license.\n"
        + "\n"
        + "(e) Original Works licensed under this license shall reference \"Non-Profit OSL 3"
        + ".0\" in licensing notices to distinguish them from works licensed under the origi"
        + "nal OSL 3.0 license.\n"
; // the license text
    }
 
    
}
