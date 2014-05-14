package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:43:39Z
 * LicenseName: Apache-2.0
 * FileName: AFL_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class AFL_2_0 extends License{
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
        return "AFL-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Academic Free License v2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Academic Free License\n"
        + "v. 2.0\n"
        + "\n"
        + " This Academic Free License (the \"License\") applies to any original work of auth"
        + "orship (the \"Original Work\") whose owner (the \"Licensor\") has placed the followi"
        + "ng notice immediately following the copyright notice for the Original Work:   \n"
        + "Licensed under the Academic Free License version 2.0 \n"
        + "\n"
        + "1) Grant of Copyright License. Licensor hereby grants You a world-wide, royalty-"
        + "free, non-exclusive, perpetual, sublicenseable license to do the following: \n"
        + "\n"
        + "a) to reproduce the Original Work in copies; \n"
        + "\n"
        + "b) to prepare derivative works (\"Derivative Works\") based upon the Original Wor"
        + "k; \n"
        + "\n"
        + "c) to distribute copies of the Original Work and Derivative Works to the public"
        + "; \n"
        + "\n"
        + "d) to perform the Original Work publicly; and \n"
        + "\n"
        + "e) to display the Original Work publicly.   \n"
        + "\n"
        + "2) Grant of Patent License. Licensor hereby grants You a world-wide, royalty-fre"
        + "e, non-exclusive, perpetual, sublicenseable license, under patent claims owned o"
        + "r controlled by the Licensor that are embodied in the Original Work as furnished"
        + " by the Licensor, to make, use, sell and offer for sale the Original Work and De"
        + "rivative Works.  \n"
        + "\n"
        + "3) Grant of Source Code License. The term \"Source Code\" means the preferred form"
        + " of the Original Work for making modifications to it and all available documenta"
        + "tion describing how to modify the Original Work.  Licensor hereby agrees to prov"
        + "ide a machine-readable copy of the Source Code of the Original Work along with e"
        + "ach copy of the Original Work that Licensor distributes.  Licensor reserves the "
        + "right to satisfy this obligation by placing a machine-readable copy of the Sourc"
        + "e Code in an information repository reasonably calculated to permit inexpensive "
        + "and convenient access by You for as long as Licensor continues to distribute the"
        + " Original Work, and by publishing the address of that information repository in "
        + "a notice immediately following the copyright notice that applies to the Original"
        + " Work.    \n"
        + "\n"
        + "4) Exclusions From License Grant. Neither the names of Licensor, nor the names o"
        + "f any contributors to the Original Work, nor any of their trademarks or service "
        + "marks, may be used to endorse or promote products derived from this Original Wor"
        + "k without express prior written permission of the Licensor.  Nothing in this Lic"
        + "ense shall be deemed to grant any rights to trademarks, copyrights, patents, tra"
        + "de secrets or any other intellectual property of Licensor except as expressly st"
        + "ated herein.  No patent license is granted to make, use, sell or offer to sell e"
        + "mbodiments of any patent claims other than the licensed claims defined in Sectio"
        + "n 2.  No right is granted to the trademarks of Licensor even if such marks are i"
        + "ncluded in the Original Work.  Nothing in this License shall be interpreted to p"
        + "rohibit Licensor from licensing under different terms from this License any Orig"
        + "inal Work that Licensor otherwise would have a right to license.  \n"
        + "\n"
        + "5) This section intentionally omitted.  \n"
        + "\n"
        + "6) Attribution Rights. You must retain, in the Source Code of any Derivative Wor"
        + "ks that You create, all copyright, patent or trademark notices from the Source C"
        + "ode of the Original Work, as well as any notices of licensing and any descriptiv"
        + "e text identified therein as an \"Attribution Notice.\"  You must cause the Source"
        + " Code for any Derivative Works that You create to carry a prominent Attribution "
        + "Notice reasonably calculated to inform recipients that You have modified the Ori"
        + "ginal Work.  \n"
        + "\n"
        + "7) Warranty of Provenance and Disclaimer of Warranty. Licensor warrants that the"
        + " copyright in and to the Original Work and the patent rights granted herein by L"
        + "icensor are owned by the Licensor or are sublicensed to You under the terms of t"
        + "his License with the permission of the contributor(s) of those copyrights and pa"
        + "tent rights.  Except as expressly stated in the immediately proceeding sentence,"
        + " the Original Work is provided under this License on an \"AS IS\" BASIS and WITHOU"
        + "T WARRANTY, either express or implied, including, without limitation, the warran"
        + "ties of NON-INFRINGEMENT, MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  "
        + "THE ENTIRE RISK AS TO THE QUALITY OF THE ORIGINAL WORK IS WITH YOU.  This DISCLA"
        + "IMER OF WARRANTY constitutes an essential part of this License.  No license to O"
        + "riginal Work is granted hereunder except under this disclaimer.  \n"
        + "\n"
        + "8) Limitation of Liability. Under no circumstances and under no legal theory, wh"
        + "ether in tort (including negligence), contract, or otherwise, shall the Licensor"
        + " be liable to any person for any direct, indirect, special, incidental, or conse"
        + "quential damages of any character arising as a result of this License or the use"
        + " of the Original Work including, without limitation, damages for loss of goodwil"
        + "l, work stoppage, computer failure or malfunction, or any and all other commerci"
        + "al damages or losses.  This limitation of liability shall not apply to liability"
        + " for death or personal injury resulting from Licensor's negligence to the extent"
        + " applicable law prohibits such limitation.  Some jurisdictions do not allow the "
        + "exclusion or limitation of incidental or consequential damages, so this exclusio"
        + "n and limitation may not apply to You.  \n"
        + "\n"
        + "9) Acceptance and Termination. If You distribute  copies of the Original Work or"
        + " a Derivative Work, You must make a reasonable effort under the circumstances to"
        + " obtain the express assent of recipients to the terms of this License.  Nothing "
        + "else but this License (or another written agreement between Licensor and You) gr"
        + "ants You permission to create Derivative Works based upon the Original Work or t"
        + "o exercise any of the rights granted in Section 1 herein, and any attempt to do "
        + "so except under the terms of this License (or another written agreement between "
        + "Licensor and You) is expressly prohibited by U.S. copyright law, the equivalent "
        + "laws of other countries, and by international treaty.  Therefore, by exercising "
        + "any of the rights granted to You in Section 1 herein, You indicate Your acceptan"
        + "ce of this License and all of its terms and conditions.    \n"
        + "\n"
        + "10) Termination for Patent Action. This License shall terminate automatically an"
        + "d You may no longer exercise any of the rights granted to You by this License as"
        + " of the date You commence an action, including a cross-claim or counterclaim, fo"
        + "r patent infringement (i) against Licensor with respect to a patent applicable t"
        + "o software or (ii) against any entity with respect to a patent applicable to the"
        + " Original Work (but excluding combinations of the Original Work with other softw"
        + "are or hardware).    \n"
        + "\n"
        + "11) Jurisdiction, Venue and Governing Law. Any action or suit relating to this L"
        + "icense may be brought only in the courts of a jurisdiction wherein the Licensor "
        + "resides or in which Licensor conducts its primary business, and under the laws o"
        + "f that jurisdiction excluding its conflict-of-law provisions.  The application o"
        + "f the United Nations Convention on Contracts for the International Sale of Goods"
        + " is expressly excluded.  Any use of the Original Work outside the scope of this "
        + "License or after its termination shall be subject to the requirements and penalt"
        + "ies of the U.S. Copyright Act, 17 U.S.C. ¤ 101 et seq., the equivalent laws of o"
        + "ther countries, and international treaty.  This section shall survive the termin"
        + "ation of this License.  \n"
        + "\n"
        + "12) Attorneys Fees. In any action to enforce the terms of this License or seekin"
        + "g damages relating thereto, the prevailing party shall be entitled to recover it"
        + "s costs and expenses, including, without limitation, reasonable attorneys' fees "
        + "and costs incurred in connection with such action, including any appeal of such "
        + "action.  This section shall survive the termination of this License.  \n"
        + "\n"
        + "13) Miscellaneous. This License represents the complete agreement concerning the"
        + " subject matter hereof.  If any provision of this License is held to be unenforc"
        + "eable, such provision shall be reformed only to the extent necessary to make it "
        + "enforceable.    \n"
        + "\n"
        + "14) Definition of \"You\" in This License. \"You\" throughout this License, whether "
        + "in upper or lower case, means an individual or a legal entity exercising rights "
        + "under, and complying with all of the terms of, this License.  For legal entities"
        + ", \"You\" includes any entity that controls, is controlled by, or is under common "
        + "control with you.  For purposes of this definition, \"control\" means (i) the powe"
        + "r, direct or indirect, to cause the direction or management of such entity, whet"
        + "her by contract or otherwise, or (ii) ownership of fifty percent (50%) or more o"
        + "f the outstanding shares, or (iii) beneficial ownership of such entity.   \n"
        + "\n"
        + "15) Right to Use. You may use the Original Work in all ways not otherwise restri"
        + "cted or conditioned by this License or by law, and Licensor promises not to inte"
        + "rfere with or be responsible for such uses by You.    \n"
        + "\n"
        + "This license is Copyright (C) 2003 Lawrence E. Rosen.  All rights reserved.  \n"
        + "Permission is hereby granted to copy and distribute this license without modific"
        + "ation.  This license may not be modified without the express written permission "
        + "of its copyright owner. \n"
; // the license text
    }
 
    
}
