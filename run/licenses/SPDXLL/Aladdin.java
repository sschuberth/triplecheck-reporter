package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:25Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Aladdin.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Aladdin extends License{
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
        return "Aladdin"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Aladdin Free Public License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Aladdin Free Public License\n"
        + "(Version 8, November 18, 1999)\n"
        + "\n"
        + "Copyright (C) 1994, 1995, 1997, 1998, 1999 Aladdin Enterprises, Menlo Park, Cali"
        + "fornia, U.S.A. All rights reserved.\n"
        + "\n"
        + "NOTE: This License is not the same as any of the GNU Licenses published by the F"
        + "ree Software Foundation. Its terms are substantially different from those of the"
        + " GNU Licenses. If you are familiar with the GNU Licenses, please read this licen"
        + "se with extra care.\n"
        + "\n"
        + "Aladdin Enterprises hereby grants to anyone the permission to apply this License"
        + " to their own work, as long as the entire License (including the above notices a"
        + "nd this paragraph) is copied with no changes, additions, or deletions except for"
        + " changing the first paragraph of Section 0 to include a suitable description of "
        + "the work to which the license is being applied and of the person or entity that "
        + "holds the copyright in the work, and, if the License is being applied to a work "
        + "created in a country other than the United States, replacing the first paragraph"
        + " of Section 6 with an appropriate reference to the laws of the appropriate count"
        + "ry.\n"
        + "\n"
        + "0. Subject Matter\n"
        + "\n"
        + "This License applies to the computer program known as \"Aladdin Ghostscript.\" The"
        + " \"Program\", below, refers to such program. The Program is a copyrighted work who"
        + "se copyright is held by Aladdin Enterprises (the \"Licensor\"). Please note that A"
        + "laddin Ghostscript is neither the program known as \"GNU Ghostscript\" nor the ver"
        + "sion of Ghostscript available for commercial licensing from Artifex Software Inc"
        + ".\n"
        + "\n"
        + "A \"work based on the Program\" means either the Program or any derivative work of"
        + " the Program, as defined in the United States Copyright Act of 1976, such as a t"
        + "ranslation or a modification.\n"
        + "\n"
        + "BY MODIFYING OR DISTRIBUTING THE PROGRAM (OR ANY WORK BASED ON THE PROGRAM), YOU"
        + " INDICATE YOUR ACCEPTANCE OF THIS LICENSE TO DO SO, AND ALL ITS TERMS AND CONDIT"
        + "IONS FOR COPYING, DISTRIBUTING OR MODIFYING THE PROGRAM OR WORKS BASED ON IT. NO"
        + "THING OTHER THAN THIS LICENSE GRANTS YOU PERMISSION TO MODIFY OR DISTRIBUTE THE "
        + "PROGRAM OR ITS DERIVATIVE WORKS. THESE ACTIONS ARE PROHIBITED BY LAW. IF YOU DO "
        + "NOT ACCEPT THESE TERMS AND CONDITIONS, DO NOT MODIFY OR DISTRIBUTE THE PROGRAM.\n"
        + "\n"
        + "1. Licenses.\n"
        + "\n"
        + "Licensor hereby grants you the following rights, provided that you comply with a"
        + "ll of the restrictions set forth in this License and provided, further, that you"
        + " distribute an unmodified copy of this License with the Program:\n"
        + "(a) You may copy and distribute literal (i.e., verbatim) copies of the Program'"
        + "s source code as you receive it throughout the world, in any medium.\n"
        + "(b) You may modify the Program, create works based on the Program and distribut"
        + "e copies of such throughout the world, in any medium.\n"
        + "\n"
        + "2. Restrictions.\n"
        + "\n"
        + "This license is subject to the following restrictions:\n"
        + "(a) Distribution of the Program or any work based on the Program by a commercia"
        + "l organization to any third party is prohibited if any payment is made in connec"
        + "tion with such distribution, whether directly (as in payment for a copy of the P"
        + "rogram) or indirectly (as in payment for some service related to the Program, or"
        + " payment for some product or service that includes a copy of the Program \"withou"
        + "t charge\"; these are only examples, and not an exhaustive enumeration of prohibi"
        + "ted activities). The following methods of distribution involving payment shall n"
        + "ot in and of themselves be a violation of this restriction:\n"
        + "(i) Posting the Program on a public access information storage and retrieval s"
        + "ervice for which a fee is received for retrieving information (such as an on-lin"
        + "e service), provided that the fee is not content-dependent (i.e., the fee would "
        + "be the same for retrieving the same volume of information consisting of random d"
        + "ata) and that access to the service and to the Program is available independent "
        + "of any other product or service. An example of a service that does not fall unde"
        + "r this section is an on-line service that is operated by a company and that is o"
        + "nly available to customers of that company. (This is not an exhaustive enumerati"
        + "on.)\n"
        + "(ii) Distributing the Program on removable computer-readable media, provided t"
        + "hat the files containing the Program are reproduced entirely and verbatim on suc"
        + "h media, that all information on such media be redistributable for non-commercia"
        + "l purposes without charge, and that such media are distributed by themselves (ex"
        + "cept for accompanying documentation) independent of any other product or service"
        + ". Examples of such media include CD-ROM, magnetic tape, and optical storage medi"
        + "a. (This is not intended to be an exhaustive list.) An example of a distribution"
        + " that does not fall under this section is a CD-ROM included in a book or magazin"
        + "e. (This is not an exhaustive enumeration.)\n"
        + "(b) Activities other than copying, distribution and modification of the Program"
        + " are not subject to this License and they are outside its scope. Functional use "
        + "(running) of the Program is not restricted, and any output produced through the "
        + "use of the Program is subject to this license only if its contents constitute a "
        + "work based on the Program (independent of having been made by running the Progra"
        + "m).\n"
        + "(c) You must meet all of the following conditions with respect to any work that"
        + " you distribute or publish that in whole or in part contains or is derived from "
        + "the Program or any part thereof (\"the Work\"):\n"
        + "(i) If you have modified the Program, you must cause the Work to carry promine"
        + "nt notices stating that you have modified the Program's files and the date of an"
        + "y change. In each source file that you have modified, you must include a promine"
        + "nt notice that you have modified the file, including your name, your e-mail addr"
        + "ess (if any), and the date and purpose of the change;\n"
        + "(ii) You must cause the Work to be licensed as a whole and at no charge to all"
        + " third parties under the terms of this License;\n"
        + "(iii) If the Work normally reads commands interactively when run, you must cau"
        + "se it, at each time the Work commences operation, to print or display an announc"
        + "ement including an appropriate copyright notice and a notice that there is no wa"
        + "rranty (or else, saying that you provide a warranty). Such notice must also stat"
        + "e that users may redistribute the Work only under the conditions of this License"
        + " and tell the user how to view the copy of this License included with the Work. "
        + "(Exceptions: if the Program is interactive but normally prints or displays such "
        + "an announcement only at the request of a user, such as in an \"About box\", the Wo"
        + "rk is required to print or display the notice only under the same circumstances;"
        + " if the Program itself is interactive but does not normally print such an announ"
        + "cement, the Work is not required to print an announcement.);\n"
        + "(iv) You must accompany the Work with the complete corresponding machine-reada"
        + "ble source code, delivered on a medium customarily used for software interchange"
        + ". The source code for a work means the preferred form of the work for making mod"
        + "ifications to it. For an executable work, complete source code means all the sou"
        + "rce code for all modules it contains, plus any associated interface definition f"
        + "iles, plus the scripts used to control compilation and installation of the execu"
        + "table code. If you distribute with the Work any component that is normally distr"
        + "ibuted (in either source or binary form) with the major components (compiler, ke"
        + "rnel, and so on) of the operating system on which the executable runs, you must "
        + "also distribute the source code of that component if you have it and are allowed"
        + " to do so;\n"
        + "(v) If you distribute any written or printed material at all with the Work, su"
        + "ch material must include either a written copy of this License, or a prominent w"
        + "ritten indication that the Work is covered by this License and written instructi"
        + "ons for printing and/or displaying the copy of the License on the distribution m"
        + "edium;\n"
        + "(vi) You may not impose any further restrictions on the recipient's exercise o"
        + "f the rights granted herein.\n"
        + "\n"
        + "If distribution of executable or object code is made by offering the equivalent "
        + "ability to copy from a designated place, then offering equivalent ability to cop"
        + "y the source code from the same place counts as distribution of the source code,"
        + " even though third parties are not compelled to copy the source code along with "
        + "the object code.\n"
        + "\n"
        + "3. Reservation of Rights.\n"
        + "\n"
        + "No rights are granted to the Program except as expressly set forth herein. You m"
        + "ay not copy, modify, sublicense, or distribute the Program except as expressly p"
        + "rovided under this License. Any attempt otherwise to copy, modify, sublicense or"
        + " distribute the Program is void, and will automatically terminate your rights un"
        + "der this License. However, parties who have received copies, or rights, from you"
        + " under this License will not have their licenses terminated so long as such part"
        + "ies remain in full compliance.\n"
        + "\n"
        + "4. Other Restrictions.\n"
        + "\n"
        + "If the distribution and/or use of the Program is restricted in certain countries"
        + " for any reason, Licensor may add an explicit geographical distribution limitati"
        + "on excluding those countries, so that distribution is permitted only in or among"
        + " countries not thus excluded. In such case, this License incorporates the limita"
        + "tion as if written in the body of this License.\n"
        + "\n"
        + "5. Limitations.\n"
        + "\n"
        + "THE PROGRAM IS PROVIDED TO YOU \"AS IS,\" WITHOUT WARRANTY. THERE IS NO WARRANTY F"
        + "OR THE PROGRAM, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE "
        + "IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE AND N"
        + "ONINFRINGEMENT OF THIRD PARTY RIGHTS. THE ENTIRE RISK AS TO THE QUALITY AND PERF"
        + "ORMANCE OF THE PROGRAM IS WITH YOU. SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSU"
        + "ME THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.\n"
        + "\n"
        + "IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING WILL LICEN"
        + "SOR, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR REDISTRIBUTE THE PROGRAM AS PERMIT"
        + "TED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY GENERAL, SPECIAL, INCIDEN"
        + "TAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR INABILITY TO USE THE PROG"
        + "RAM (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA BEING RENDERED INACCURATE"
        + " OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A FAILURE OF THE PROGRAM TO OPER"
        + "ATE WITH ANY OTHER PROGRAMS), EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISE"
        + "D OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "6. General.\n"
        + "\n"
        + "This License is governed by the laws of the State of California, U.S.A., excludi"
        + "ng choice of law rules.\n"
        + "\n"
        + "If any part of this License is found to be in conflict with the law, that part s"
        + "hall be interpreted in its broadest meaning consistent with the law, and no othe"
        + "r parts of the License shall be affected.\n"
        + "\n"
        + "For United States Government users, the Program is provided with RESTRICTED RIGH"
        + "TS. If you are a unit or agency of the United States Government or are acquiring"
        + " the Program for any such unit or agency, the following apply:\n"
        + "\n"
        + "If the unit or agency is the Department of Defense (\"DOD\"), the Program and its"
        + " documentation are classified as \"commercial computer software\" and \"commercial "
        + "computer software documentation\" respectively and, pursuant to DFAR Section 227."
        + "7202, the Government is acquiring the Program and its documentation in accordanc"
        + "e with the terms of this License. If the unit or agency is other than DOD, the P"
        + "rogram and its documentation are classified as \"commercial computer software\" an"
        + "d \"commercial computer software documentation\" respectively and, pursuant to FAR"
        + " Section 12.212, the Government is acquiring the Program and its documentation i"
        + "n accordance with the terms of this License.\n"
; // the license text
    }
 
    
}
