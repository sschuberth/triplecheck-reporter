package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:22Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: AFL_1_2.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class AFL_1_2 extends License{
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
        return "AFL-1.2"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Academic Free License v1.2"; // full text title
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
        + "Version 1.2 \n"
        + "\n"
        + "This Academic Free License applies to any original work of authorship (the \"Orig"
        + "inal Work\") whose owner (the \"Licensor\") has placed the \n"
        + "following notice immediately following the copyright notice for the Original Wor"
        + "k:\n"
        + "\n"
        + "Licensed under the Academic Free License version 1.2 \n"
        + "\n"
        + "Grant of License. Licensor hereby grants to any person obtaining a copy of the O"
        + "riginal Work (\"You\") a world-wide, royalty-free, non-exclusive, perpetual, non-s"
        + "ublicenseable license (1) to use, copy, modify, merge, publish, perform, distrib"
        + "ute and/or sell copies of the Original Work and derivative works thereof, and (2"
        + ") under patent claims owned or controlled by the Licensor that are embodied in t"
        + "he Original Work as furnished by the Licensor, to make, use, sell and offer for "
        + "sale the Original Work and derivative works thereof, subject to the \n"
        + "following conditions.\n"
        + "\n"
        + "Attribution Rights. You must retain, in the Source Code of any Derivative Works "
        + "that You create, all copyright, patent or trademark notices from the Source Code"
        + " of the Original Work, as well as any notices of licensing and any descriptive t"
        + "ext identified therein as an \"Attribution Notice.\" You must cause the Source Cod"
        + "e for any Derivative Works that You create to carry a prominent Attribution Noti"
        + "ce reasonably calculated to inform recipients that You have modified the Origina"
        + "l Work.\n"
        + "\n"
        + "Exclusions from License Grant. Neither the names of Licensor, nor the names of a"
        + "ny contributors to the Original Work, nor any of their trademarks or service mar"
        + "ks, may be used to endorse or promote products derived from this Original Work w"
        + "ithout express prior written permission of the Licensor.\n"
        + "\n"
        + "Warranty and Disclaimer of Warranty. Licensor warrants that the copyright in and"
        + " to the Original Work is owned by the Licensor or that the Original Work is dist"
        + "ributed by Licensor under a valid current license from the copyright owner. Exce"
        + "pt as expressly stated in the immediately proceeding sentence, the Original Work"
        + " is provided under this License on an \"AS IS\" BASIS and WITHOUT WARRANTY, either"
        + " express or implied, including, without limitation, the warranties of NON-INFRIN"
        + "GEMENT, MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS "
        + "TO THE QUALITY OF THE ORIGINAL WORK IS WITH YOU. This DISCLAIMER OF WARRANTY con"
        + "stitutes an essential part of this License. No license to Original Work is grant"
        + "ed hereunder except under this disclaimer.\n"
        + "\n"
        + "Limitation of Liability. Under no circumstances and under no legal theory, wheth"
        + "er in tort (including negligence), contract, or otherwise, shall the Licensor be"
        + " liable to any person for any direct, indirect, special, incidental, or conseque"
        + "ntial damages of any character arising as a result of this License or the use of"
        + " the Original Work including, without limitation, damages for loss of goodwill, "
        + "work stoppage, computer failure or malfunction, or any and all other commercial "
        + "damages or losses. This limitation of liability shall not apply to liability for"
        + " death or personal injury resulting from Licensor's negligence to the extent app"
        + "licable law prohibits such limitation. Some jurisdictions do not allow the exclu"
        + "sion or limitation of incidental or consequential damages, so this exclusion and"
        + " limitation may not apply to You.\n"
        + "\n"
        + "License to Source Code. The term \"Source Code\" means the preferred form of the O"
        + "riginal Work for making modifications to it and all available \n"
        + "documentation describing how to modify the Original Work. Licensor hereby agrees"
        + " to provide a machine-readable copy of the Source Code of the Original Work alon"
        + "g with each copy of the Original Work that Licensor distributes. Licensor reserv"
        + "es the right to satisfy this obligation by placing a machine-readable copy of th"
        + "e Source Code in an information repository reasonably calculated to permit inexp"
        + "ensive and convenient access by You for as long as Licensor continues to distrib"
        + "ute the Original Work, and by publishing the address of that information reposit"
        + "ory in a notice immediately following the copyright notice that applies to the O"
        + "riginal Work.\n"
        + "\n"
        + "Mutual Termination for Patent Action. This License shall terminate automatically"
        + " and You may no longer exercise any of the rights granted to You by this License"
        + " if You file a lawsuit in any court alleging that any OSI Certified open source "
        + "software that is licensed under any license containing this \"Mutual Termination "
        + "for Patent Action\" clause infringes any patent claims that are essential to use "
        + "that software.\n"
        + "\n"
        + "Right to Use. You may use the Original Work in all ways not otherwise restricted"
        + " or conditioned by this License or by law, and Licensor promises not to interfer"
        + "e with or be responsible for such uses by You.\n"
        + "\n"
        + "This license is Copyright (C) 2002 Lawrence E. Rosen. All rights reserved. \n"
        + "Permission is hereby granted to copy and distribute this license without modific"
        + "ation. This license may not be modified without the express written permission o"
        + "f its copyright owner.\n"
; // the license text
    }
 
    
}
