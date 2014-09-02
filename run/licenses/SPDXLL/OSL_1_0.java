package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:33Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OSL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OSL_1_0 extends License{
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
        return "OSL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Open Software License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Open Software License\n"
        + "v. 1.0\n"
        + "\n"
        + "This Open Software License (the \"License\") applies to any original\n"
        + "work of authorship (the \"Original Work\") whose owner (the \"Licensor\")\n"
        + "has placed the following notice immediately following the copyright\n"
        + "notice for the Original Work: \"Licensed under the Open Software\n"
        + "License version 1.0\"\n"
        + "\n"
        + "License Terms\n"
        + "\n"
        + "1) Grant of Copyright License. Licensor hereby grants You a\n"
        + "world-wide, royalty-free, non-exclusive, perpetual, non-sublicenseable\n"
        + "license to do the following:\n"
        + "\n"
        + "a) to reproduce the Original Work in copies;\n"
        + "\n"
        + "b) to prepare derivative works (\"Derivative Works\") based upon the\n"
        + "Original Work;\n"
        + "\n"
        + "c) to distribute copies of the Original Work and Derivative Works\n"
        + "to the public, with the proviso that copies of Original Work or\n"
        + "Derivative Works that You distribute shall be licensed under the\n"
        + "Open Software License;\n"
        + "\n"
        + "d) to perform the Original Work publicly; and\n"
        + "\n"
        + "e) to display the Original Work publicly.\n"
        + "\n"
        + "2) Grant of Patent License. Licensor hereby grants You a world-wide,\n"
        + "royalty-free, non-exclusive, perpetual, non-sublicenseable license,\n"
        + "under patent claims owned or controlled by the Licensor that are\n"
        + "embodied in the Original Work as furnished by the Licensor (\"Licensed\n"
        + "Claims\") to make, use, sell and offer for sale the Original Work.\n"
        + "Licensor hereby grants You a world-wide, royalty-free, non-exclusive,\n"
        + "perpetual, non-sublicenseable license under the Licensed Claims to\n"
        + "make, use, sell and offer for sale Derivative Works.\n"
        + "\n"
        + "3) Grant of Source Code License. The term \"Source Code\" means the\n"
        + "preferred form of the Original Work for making modifications to it and\n"
        + "all available documentation describing how to access and modify the\n"
        + "Original Work. Licensor hereby agrees to provide a machine-readable\n"
        + "copy of the Source Code of the Original Work along with each copy of\n"
        + "the Original Work that Licensor distributes. Licensor reserves the\n"
        + "right to satisfy this obligation by placing a machine-readable copy of\n"
        + "the Source Code in an information repository reasonably calculated to\n"
        + "permit inexpensive and convenient access by You for as long as\n"
        + "Licensor continues to distribute the Original Work, and by publishing\n"
        + "the address of that information repository in a notice immediately\n"
        + "following the copyright notice that applies to the Original Work.\n"
        + "\n"
        + "4) Exclusions From License Grant. Nothing in this License shall be\n"
        + "deemed to grant any rights to trademarks, copyrights, patents, trade\n"
        + "secrets or any other intellectual property of Licensor except as\n"
        + "expressly stated herein. No patent license is granted to make, use,\n"
        + "sell or offer to sell embodiments of any patent claims other than the\n"
        + "Licensed Claims defined in Section 2. No right is granted to the\n"
        + "trademarks of Licensor even if such marks are included in the Original\n"
        + "Work. Nothing in this License shall be interpreted to prohibit\n"
        + "Licensor from licensing under different terms from this License any\n"
        + "Original Work that Licensor otherwise would have a right to license.\n"
        + "\n"
        + "5) External Deployment. The term \"External Deployment\" means the use\n"
        + "or distribution of the Original Work or Derivative Works in any way\n"
        + "such that the Original Work or Derivative Works may be accessed or\n"
        + "used by anyone other than You, whether the Original Work or Derivative\n"
        + "Works are distributed to those persons, made available as an\n"
        + "application intended for use over a computer network, or used to\n"
        + "provide services or otherwise deliver content to anyone other than\n"
        + "You. As an express condition for the grants of license hereunder, You\n"
        + "agree that any External Deployment by You shall be deemed a\n"
        + "distribution and shall be licensed to all under the terms of this\n"
        + "License, as prescribed in section 1(c) herein.\n"
        + "\n"
        + "6) Warranty and Disclaimer of Warranty. LICENSOR WARRANTS THAT THE\n"
        + "COPYRIGHT IN AND TO THE ORIGINAL WORK IS OWNED BY THE LICENSOR OR THAT\n"
        + "THE ORIGINAL WORK IS DISTRIBUTED BY LICENSOR UNDER A VALID CURRENT\n"
        + "LICENSE FROM THE COPYRIGHT OWNER. EXCEPT AS EXPRESSLY STATED IN THE\n"
        + "IMMEDIATELY PRECEEDING SENTENCE, THE ORIGINAL WORK IS PROVIDED UNDER\n"
        + "THIS LICENSE ON AN \"AS IS\" BASIS, WITHOUT WARRANTY, EITHER EXPRESS OR\n"
        + "IMPLIED, INCLUDING, WITHOUT LIMITATION, THE WARRANTY OF\n"
        + "NON-INFRINGEMENT AND WARRANTIES THAT THE ORIGINAL WORK IS MERCHANTABLE\n"
        + "OR FIT FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY OF\n"
        + "THE ORIGINAL WORK IS WITH YOU. THIS DISCLAIMER OF WARRANTY CONSTITUTES\n"
        + "AN ESSENTIAL PART OF THIS LICENSE. NO LICENSE TO ORIGINAL WORK IS\n"
        + "GRANTED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "7) Limitation of Liability. UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL\n"
        + "THEORY, WHETHER TORT (INCLUDING NEGLIGENCE), CONTRACT, OR OTHERWISE,\n"
        + "SHALL THE LICENSOR BE LIABLE TO ANY PERSON FOR ANY DIRECT, INDIRECT,\n"
        + "SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES OF ANY CHARACTER ARISING\n"
        + "AS A RESULT OF THIS LICENSE OR THE USE OF THE ORIGINAL WORK INCLUDING,\n"
        + "WITHOUT LIMITATION, DAMAGES FOR LOSS OF GOODWILL, WORK STOPPAGE,\n"
        + "COMPUTER FAILURE OR MALFUNCTION, OR ANY AND ALL OTHER COMMERCIAL\n"
        + "DAMAGES OR LOSSES, EVEN IF SUCH PERSON SHALL HAVE BEEN INFORMED OF THE\n"
        + "POSSIBILITY OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SHALL NOT\n"
        + "APPLY TO LIABILITY FOR DEATH OR PERSONAL INJURY RESULTING FROM SUCH\n"
        + "PARTY'S NEGLIGENCE TO THE EXTENT APPLICABLE LAW PROHIBITS SUCH\n"
        + "LIMITATION. SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OR\n"
        + "LIMITATION OF INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO THIS EXCLUSION\n"
        + "AND LIMITATION MAY NOT APPLY TO YOU.\n"
        + "\n"
        + "8) Acceptance and Termination. Nothing else but this License (or\n"
        + "another written agreement between Licensor and You) grants You\n"
        + "permission to create Derivative Works based upon the Original Work,\n"
        + "and any attempt to do so except under the terms of this License (or\n"
        + "another written agreement between Licensor and You) is expressly\n"
        + "prohibited by U.S. copyright law, the equivalent laws of other\n"
        + "countries, and by international treaty. Therefore, by exercising any\n"
        + "of the rights granted to You in Sections 1 and 2 herein, You indicate\n"
        + "Your acceptance of this License and all of its terms and conditions.\n"
        + "This license shall terminate immediately and you may no longer\n"
        + "exercise any of the rights granted to You by this License upon Your\n"
        + "failure to honor the proviso in Section 1(c) herein.\n"
        + "\n"
        + "9) Mutual Termination for Patent Action. This License shall terminate\n"
        + "automatically and You may no longer exercise any of the rights granted\n"
        + "to You by this License if You file a lawsuit in any court alleging\n"
        + "that any OSI Certified open source software that is licensed under any\n"
        + "license containing this \"Mutual Termination for Patent Action\" clause\n"
        + "infringes any patent claims that are essential to use that software.\n"
        + "\n"
        + "10) Jurisdiction, Venue and Governing Law. You agree that any lawsuit\n"
        + "arising under or relating to this License shall be maintained in the\n"
        + "courts of the jurisdiction wherein the Licensor resides or in which\n"
        + "Licensor conducts its primary business, and under the laws of that\n"
        + "jurisdiction excluding its conflict-of-law provisions. The application\n"
        + "of the United Nations Convention on Contracts for the International\n"
        + "Sale of Goods is expressly excluded. Any use of the Original Work\n"
        + "outside the scope of this License or after its termination shall be\n"
        + "subject to the requirements and penalties of the U.S. Copyright Act,\n"
        + "17 U.S.C. § 101 et seq., the equivalent laws of other countries, and\n"
        + "international treaty. This section shall survive the termination of\n"
        + "this License.\n"
        + "\n"
        + "11) Attorneys Fees. In any action to enforce the terms of this License\n"
        + "or seeking damages relating thereto, the prevailing party shall be\n"
        + "entitled to recover its costs and expenses, including, without\n"
        + "limitation, reasonable attorneys' fees and costs incurred in\n"
        + "connection with such action, including any appeal of such action. This\n"
        + "section shall survive the termination of this License.\n"
        + "\n"
        + "12) Miscellaneous. This License represents the complete agreement\n"
        + "concerning the subject matter hereof. If any provision of this License\n"
        + "is held to be unenforceable, such provision shall be reformed only to\n"
        + "the extent necessary to make it enforceable.\n"
        + "\n"
        + "13) Definition of \"You\" in This License. \"You\" throughout this\n"
        + "License, whether in upper or lower case, means an individual or a\n"
        + "legal entity exercising rights under, and complying with all of the\n"
        + "terms of, this License. For legal entities, \"You\" includes any entity\n"
        + "that controls, is controlled by, or is under common control with you.\n"
        + "For purposes of this definition, \"control\" means (i) the power, direct\n"
        + "or indirect, to cause the direction or management of such entity,\n"
        + "whether by contract or otherwise, or (ii) ownership of fifty percent\n"
        + "(50%) or more of the outstanding shares, or (iii) beneficial ownership\n"
        + "of such entity.\n"
        + "\n"
        + "This license is Copyright (C) 2002 Lawrence E. Rosen. All rights\n"
        + "reserved. Permission is hereby granted to copy and distribute this\n"
        + "license without modification. This license may not be modified without\n"
        + "the express written permission of its copyright owner.\n"
; // the license text
    }
 
    
}
