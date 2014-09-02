package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:22Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: AFL_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class AFL_1_1 extends License{
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
        return "AFL-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Academic Free License v1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Academic Free License\n"
        + "Version 1.1\n"
        + "\n"
        + "The Academic Free License applies to any original work of authorship (the \"Origi"
        + "nal Work\") whose owner (the \"Licensor\") has placed the following notice immediat"
        + "ely following the copyright notice for the Original Work: \n"
        + "\n"
        + "\"Licensed under the Academic Free License version 1.1.\"\n"
        + "\n"
        + "Grant of License. Licensor hereby grants to any person obtaining a copy of the O"
        + "riginal Work (\"You\") a world-wide, royalty-free, non-exclusive, perpetual, non-s"
        + "ublicenseable license (1) to use, copy, modify, merge, publish, perform, distrib"
        + "ute and/or sell copies of the Original Work and derivative works thereof, and (2"
        + ") under patent claims owned or controlled by the Licensor that are embodied in t"
        + "he Original Work as furnished by the Licensor, to make, use, sell and offer for "
        + "sale the Original Work and derivative works thereof, subject to the following co"
        + "nditions.\n"
        + "\n"
        + "Right of Attribution. Redistributions of the Original Work must reproduce all co"
        + "pyright notices in the Original Work as furnished by the Licensor, both in the O"
        + "riginal Work itself and in any documentation and/or other materials provided wit"
        + "h the distribution of the Original Work in executable form.\n"
        + "\n"
        + "Exclusions from License Grant. Neither the names of Licensor, nor the names of a"
        + "ny contributors to the Original Work, nor any of their trademarks or service mar"
        + "ks, may be used to endorse or promote products derived from this Original Work w"
        + "ithout express prior written permission of the Licensor.\n"
        + "\n"
        + "WARRANTY AND DISCLAIMERS. LICENSOR WARRANTS THAT THE COPYRIGHT IN AND TO THE ORI"
        + "GINAL WORK IS OWNED BY THE LICENSOR OR THAT THE ORIGINAL WORK IS DISTRIBUTED BY "
        + "LICENSOR UNDER A VALID CURRENT LICENSE FROM THE COPYRIGHT OWNER. EXCEPT AS EXPRE"
        + "SSLY STATED IN THE IMMEDIATELY PRECEEDING SENTENCE, THE ORIGINAL WORK IS PROVIDE"
        + "D UNDER THIS LICENSE ON AN \"AS IS\" BASIS, WITHOUT WARRANTY, EITHER EXPRESS OR IM"
        + "PLIED, INCLUDING, WITHOUT LIMITATION, THE WARRANTY OF NON-INFRINGEMENT AND WARRA"
        + "NTIES THAT THE ORIGINAL WORK IS MERCHANTABLE OR FIT FOR A PARTICULAR PURPOSE. TH"
        + "E ENTIRE RISK AS TO THE QUALITY OF THE ORIGINAL WORK IS WITH YOU. THIS DISCLAIME"
        + "R OF WARRANTY CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE. NO LICENSE TO ORIGI"
        + "NAL WORK IS GRANTED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.\n"
        + "\n"
        + "LIMITATION OF LIABILITY. UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL THEORY, WHETH"
        + "ER TORT (INCLUDING NEGLIGENCE), CONTRACT, OR OTHERWISE, SHALL THE LICENSOR BE LI"
        + "ABLE TO ANY PERSON FOR ANY DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTI"
        + "AL DAMAGES OF ANY CHARACTER ARISING AS A RESULT OF THIS LICENSE OR THE USE OF TH"
        + "E ORIGINAL WORK INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF GOODWILL, WOR"
        + "K STOPPAGE, COMPUTER FAILURE OR MALFUNCTION, OR ANY AND ALL OTHER COMMERCIAL DAM"
        + "AGES OR LOSSES, EVEN IF SUCH PERSON SHALL HAVE BEEN INFORMED OF THE POSSIBILITY "
        + "OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SHALL NOT APPLY TO LIABILITY FOR D"
        + "EATH OR PERSONAL INJURY RESULTING FROM SUCH PARTY'S NEGLIGENCE TO THE EXTENT APP"
        + "LICABLE LAW PROHIBITS SUCH \n"
        + "LIMITATION. SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OR LIMITATION OF INCID"
        + "ENTAL OR CONSEQUENTIAL DAMAGES, SO THIS EXCLUSION AND LIMITATION MAY NOT APPLY T"
        + "O YOU.\n"
        + "\n"
        + "License to Source Code. The term \"Source Code\" means the preferred form of the O"
        + "riginal Work for making modifications to it and all available documentation desc"
        + "ribing how to access and modify the Original Work. Licensor hereby agrees to pro"
        + "vide a machine-readable copy of the Source Code of the Original Work along with "
        + "each copy of the Original Work that Licensor distributes. Licensor reserves the "
        + "right to satisfy this obligation by placing a machine-readable copy of the Sourc"
        + "e Code in an information repository reasonably calculated to permit inexpensive "
        + "and convenient access by You for as long as Licensor continues to distribute the"
        + " Original Work, and by publishing the address of that information repository in "
        + "a notice immediately following the copyright notice that applies to the Original"
        + " Work.\n"
        + "\n"
        + "Mutual Termination for Patent Action. This License shall terminate automatically"
        + " and You may no longer exercise any of the rights granted to You by this License"
        + " if You file a lawsuit in any court alleging that any OSI Certified open source "
        + "software that is licensed under any license containing this \"Mutual Termination "
        + "for Patent Action\" clause infringes any patent claims that are essential to use "
        + "that software.\n"
        + "\n"
        + "This license is Copyright (C) 2002 Lawrence E. Rosen. All rights reserved. \n"
        + "Permission is hereby granted to copy and distribute this license without modific"
        + "ation. This license may not be modified without the express written permission o"
        + "f its copyright owner.\n"
; // the license text
    }
 
    
}
