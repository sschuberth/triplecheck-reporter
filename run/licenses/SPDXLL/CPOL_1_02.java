package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:45Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: CPOL_1_02.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class CPOL_1_02 extends License{
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
        return "CPOL-1.02"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Code Project Open License 1.02"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Code Project Open License (CPOL) 1.02\n"
        + "\n"
        + "Preamble\n"
        + "This License governs Your use of the Work. This License is intended to allow dev"
        + "elopers to use the Source Code and Executable Files provided as part of the Work"
        + " in any application in any form. \n"
        + "The main points subject to the terms of the License are:\n"
        + "- Source Code and Executable Files can be used in commercial applications; \n"
        + "- Source Code and Executable Files can be redistributed; and \n"
        + "- Source Code can be modified to create derivative works. \n"
        + "- No claim of suitability, guarantee, or any warranty whatsoever is provided. Th"
        + "e software is provided \"as-is\". \n"
        + "- The Article accompanying the Work may not be distributed or republished withou"
        + "t the Author's consent \n"
        + "- This License is entered between You, the individual or other entity reading or"
        + " otherwise making use of the Work licensed pursuant to this License and the indi"
        + "vidual or other entity which offers the Work under the terms of this License (\"A"
        + "uthor\").\n"
        + "\n"
        + "License\n"
        + "THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS CODE PROJECT OPE"
        + "N LICENSE (\"LICENSE\"). THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABL"
        + "E LAW. ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR COPYRI"
        + "GHT LAW IS PROHIBITED.\n"
        + "BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HEREIN, YOU ACCEPT AND AGREE TO BE"
        + " BOUND BY THE TERMS OF THIS LICENSE. THE AUTHOR GRANTS YOU THE RIGHTS CONTAINED "
        + "HEREIN IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS. IF YOU "
        + "DO NOT AGREE TO ACCEPT AND BE BOUND BY THE TERMS OF THIS LICENSE, YOU CANNOT MAK"
        + "E ANY USE OF THE WORK.\n"
        + "\n"
        + "1. Definitions. \n"
        + "a. \"Articles\" means, collectively, all articles written by Author which describe"
        + "s how the Source Code and Executable Files for the Work may be used by a user. \n"
        + "b. \"Author\" means the individual or entity that offers the Work under the terms "
        + "of this License. \n"
        + "c. \"Derivative Work\" means a work based upon the Work or upon the Work and other"
        + " pre-existing works. \n"
        + "d. \"Executable Files\" refer to the executables, binary files, configuration and "
        + "any required data files included in the Work. \n"
        + "e. \"Publisher\" means the provider of the website, magazine, CD-ROM, DVD or other"
        + " medium from or by which the Work is obtained by You. \n"
        + "f. \"Source Code\" refers to the collection of source code and configuration files"
        + " used to create the Executable Files. \n"
        + "g. \"Standard Version\" refers to such a Work if it has not been modified, or has "
        + "been modified in accordance with the consent of the Author, such consent being i"
        + "n the full discretion of the Author. \n"
        + "h. \"Work\" refers to the collection of files distributed by the Publisher, includ"
        + "ing the Source Code, Executable Files, binaries, data files, documentation, whit"
        + "epapers and the Articles. \n"
        + "i. \"You\" is you, an individual or entity wishing to use the Work and exercise yo"
        + "ur rights under this License. \n"
        + "\n"
        + "2. Fair Use/Fair Use Rights. Nothing in this License is intended to reduce, limi"
        + "t, or restrict any rights arising from fair use, fair dealing, first sale or oth"
        + "er limitations on the exclusive rights of the copyright owner under copyright la"
        + "w or other applicable laws. \n"
        + "\n"
        + "3. License Grant. Subject to the terms and conditions of this License, the Autho"
        + "r hereby grants You a worldwide, royalty-free, non-exclusive, perpetual (for the"
        + " duration of the applicable copyright) license to exercise the rights in the Wor"
        + "k as stated below: \n"
        + "a. You may use the standard version of the Source Code or Executable Files in Yo"
        + "ur own applications. \n"
        + "b. You may apply bug fixes, portability fixes and other modifications obtained f"
        + "rom the Public Domain or from the Author. A Work modified in such a way shall st"
        + "ill be considered the standard version and will be subject to this License. \n"
        + "c. You may otherwise modify Your copy of this Work (excluding the Articles) in a"
        + "ny way to create a Derivative Work, provided that You insert a prominent notice "
        + "in each changed file stating how, when and where You changed that file. \n"
        + "d. You may distribute the standard version of the Executable Files and Source Co"
        + "de or Derivative Work in aggregate with other (possibly commercial) programs as "
        + "part of a larger (possibly commercial) software distribution. \n"
        + "e. The Articles discussing the Work published in any form by the author may not "
        + "be distributed or republished without the Author's consent. The author retains c"
        + "opyright to any such Articles. You may use the Executable Files and Source Code "
        + "pursuant to this License but you may not repost or republish or otherwise distri"
        + "bute or make available the Articles, without the prior written consent of the Au"
        + "thor. \n"
        + "Any subroutines or modules supplied by You and linked into the Source Code or Ex"
        + "ecutable Files of this Work shall not be considered part of this Work and will n"
        + "ot be subject to the terms of this License. \n"
        + "\n"
        + "4. Patent License. Subject to the terms and conditions of this License, each Aut"
        + "hor hereby grants to You a perpetual, worldwide, non-exclusive, no-charge, royal"
        + "ty-free, irrevocable (except as stated in this section) patent license to make, "
        + "have made, use, import, and otherwise transfer the Work. \n"
        + "\n"
        + "5. Restrictions. The license granted in Section 3 above is expressly made subjec"
        + "t to and limited by the following restrictions: \n"
        + "a. You agree not to remove any of the original copyright, patent, trademark, and"
        + " attribution notices and associated disclaimers that may appear in the Source Co"
        + "de or Executable Files. \n"
        + "b. You agree not to advertise or in any way imply that this Work is a product of"
        + " Your own. \n"
        + "c. The name of the Author may not be used to endorse or promote products derived"
        + " from the Work without the prior written consent of the Author. \n"
        + "d. You agree not to sell, lease, or rent any part of the Work. This does not res"
        + "trict you from including the Work or any part of the Work inside a larger softwa"
        + "re distribution that itself is being sold. The Work by itself, though, cannot be"
        + " sold, leased or rented. \n"
        + "e. You may distribute the Executable Files and Source Code only under the terms "
        + "of this License, and You must include a copy of, or the Uniform Resource Identif"
        + "ier for, this License with every copy of the Executable Files or Source Code You"
        + " distribute and ensure that anyone receiving such Executable Files and Source Co"
        + "de agrees that the terms of this License apply to such Executable Files and/or S"
        + "ource Code. You may not offer or impose any terms on the Work that alter or rest"
        + "rict the terms of this License or the recipients' exercise of the rights granted"
        + " hereunder. You may not sublicense the Work. You must keep intact all notices th"
        + "at refer to this License and to the disclaimer of warranties. You may not distri"
        + "bute the Executable Files or Source Code with any technological measures that co"
        + "ntrol access or use of the Work in a manner inconsistent with the terms of this "
        + "License. \n"
        + "f. You agree not to use the Work for illegal, immoral or improper purposes, or o"
        + "n pages containing illegal, immoral or improper material. The Work is subject to"
        + " applicable export laws. You agree to comply with all such laws and regulations "
        + "that may apply to the Work after Your receipt of the Work. \n"
        + "\n"
        + "6. Representations, Warranties and Disclaimer. THIS WORK IS PROVIDED \"AS IS\", \"W"
        + "HERE IS\" AND \"AS AVAILABLE\", WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES OR CONDIT"
        + "IONS OR GUARANTEES. YOU, THE USER, ASSUME ALL RISK IN ITS USE, INCLUDING COPYRIG"
        + "HT INFRINGEMENT, PATENT INFRINGEMENT, SUITABILITY, ETC. AUTHOR EXPRESSLY DISCLAI"
        + "MS ALL EXPRESS, IMPLIED OR STATUTORY WARRANTIES OR CONDITIONS, INCLUDING WITHOUT"
        + " LIMITATION, WARRANTIES OR CONDITIONS OF MERCHANTABILITY, MERCHANTABLE QUALITY O"
        + "R FITNESS FOR A PARTICULAR PURPOSE, OR ANY WARRANTY OF TITLE OR NON-INFRINGEMENT"
        + ", OR THAT THE WORK (OR ANY PORTION THEREOF) IS CORRECT, USEFUL, BUG-FREE OR FREE"
        + " OF VIRUSES. YOU MUST PASS THIS DISCLAIMER ON WHENEVER YOU DISTRIBUTE THE WORK O"
        + "R DERIVATIVE WORKS. \n"
        + "\n"
        + "7. Indemnity. You agree to defend, indemnify and hold harmless the Author and th"
        + "e Publisher from and against any claims, suits, losses, damages, liabilities, co"
        + "sts, and expenses (including reasonable legal or attorneys� fees) resulting from"
        + " or relating to any use of the Work by You. \n"
        + "\n"
        + "8. Limitation on Liability. EXCEPT TO THE EXTENT REQUIRED BY APPLICABLE LAW, IN "
        + "NO EVENT WILL THE AUTHOR OR THE PUBLISHER BE LIABLE TO YOU ON ANY LEGAL THEORY F"
        + "OR ANY SPECIAL, INCIDENTAL, CONSEQUENTIAL, PUNITIVE OR EXEMPLARY DAMAGES ARISING"
        + " OUT OF THIS LICENSE OR THE USE OF THE WORK OR OTHERWISE, EVEN IF THE AUTHOR OR "
        + "THE PUBLISHER HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. \n"
        + "\n"
        + "9. Termination. \n"
        + "a. This License and the rights granted hereunder will terminate automatically up"
        + "on any breach by You of any term of this License. Individuals or entities who ha"
        + "ve received Derivative Works from You under this License, however, will not have"
        + " their licenses terminated provided such individuals or entities remain in full "
        + "compliance with those licenses. Sections 1, 2, 6, 7, 8, 9, 10 and 11 will surviv"
        + "e any termination of this License. \n"
        + "b. If You bring a copyright, trademark, patent or any other infringement claim a"
        + "gainst any contributor over infringements You claim are made by the Work, your L"
        + "icense from such contributor to the Work ends automatically. \n"
        + "c. Subject to the above terms and conditions, this License is perpetual (for the"
        + " duration of the applicable copyright in the Work). Notwithstanding the above, t"
        + "he Author reserves the right to release the Work under different license terms o"
        + "r to stop distributing the Work at any time; provided, however that any such ele"
        + "ction will not serve to withdraw this License (or any other license that has bee"
        + "n, or is required to be, granted under the terms of this License), and this Lice"
        + "nse will continue in full force and effect unless terminated as stated above. \n"
        + "\n"
        + "10. Publisher. The parties hereby confirm that the Publisher shall not, under an"
        + "y circumstances, be responsible for and shall not have any liability in respect "
        + "of the subject matter of this License. The Publisher makes no warranty whatsoeve"
        + "r in connection with the Work and shall not be liable to You or any party on any"
        + " legal theory for any damages whatsoever, including without limitation any gener"
        + "al, special, incidental or consequential damages arising in connection to this l"
        + "icense. The Publisher reserves the right to cease making the Work available to Y"
        + "ou at any time without notice \n"
        + "\n"
        + "11. Miscellaneous \n"
        + "a. This License shall be governed by the laws of the location of the head office"
        + " of the Author or if the Author is an individual, the laws of location of the pr"
        + "incipal place of residence of the Author. \n"
        + "b. If any provision of this License is invalid or unenforceable under applicable"
        + " law, it shall not affect the validity or enforceability of the remainder of the"
        + " terms of this License, and without further action by the parties to this Licens"
        + "e, such provision shall be reformed to the minimum extent necessary to make such"
        + " provision valid and enforceable. \n"
        + "c. No term or provision of this License shall be deemed waived and no breach con"
        + "sented to unless such waiver or consent shall be in writing and signed by the pa"
        + "rty to be charged with such waiver or consent. \n"
        + "d. This License constitutes the entire agreement between the parties with respec"
        + "t to the Work licensed herein. There are no understandings, agreements or repres"
        + "entations with respect to the Work not specified herein. The Author shall not be"
        + " bound by any additional provisions that may appear in any communication from Yo"
        + "u. This License may not be modified without the mutual written agreement of the "
        + "Author and You. \n"
; // the license text
    }
 
    
}
