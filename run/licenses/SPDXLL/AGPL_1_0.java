package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:44:24Z
 * LicenseName: Apache-2.0
 * FileName: AGPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class AGPL_1_0 extends License{
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
        return "AGPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU Affero General Public License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "AFFERO GENERAL PUBLIC LICENSE\n"
        + "Version 1, March 2002  Copyright © 2002 Affero Inc. 510 Third Street - Suite 225"
        + ", San Francisco, CA 94107, USA\n"
        + "\n"
        + "This license is a modified version of the GNU General Public License copyright ("
        + "C) 1989, 1991 Free Software Foundation, Inc. made with their permission. Section"
        + " 2(d) has been added to cover use of software over a computer network.  Everyone"
        + " is permitted to copy and distribute verbatim copies of this license document, b"
        + "ut changing it is not allowed.  Preamble  The licenses for most software are des"
        + "igned to take away your freedom to share and change it. By contrast, the Affero "
        + "General Public License is intended to guarantee your freedom to share and change"
        + " free software--to make sure the software is free for all its users. This Public"
        + " License applies to most of Affero's software and to any other program whose aut"
        + "hors commit to using it. (Some other Affero software is covered by the GNU Libra"
        + "ry General Public License instead.) You can apply it to your programs, too.  Whe"
        + "n we speak of free software, we are referring to freedom, not price. This Genera"
        + "l Public License is designed to make sure that you have the freedom to distribut"
        + "e copies of free software (and charge for this service if you wish), that you re"
        + "ceive source code or can get it if you want it, that you can change the software"
        + " or use pieces of it in new free programs; and that you know you can do these th"
        + "ings.  To protect your rights, we need to make restrictions that forbid anyone t"
        + "o deny you these rights or to ask you to surrender the rights. These restriction"
        + "s translate to certain responsibilities for you if you distribute copies of the "
        + "software, or if you modify it.  For example, if you distribute copies of such a "
        + "program, whether gratis or for a fee, you must give the recipients all the right"
        + "s that you have. You must make sure that they, too, receive or can get the sourc"
        + "e code. And you must show them these terms so they know their rights.  We protec"
        + "t your rights with two steps: (1) copyright the software, and (2) offer you this"
        + " license which gives you legal permission to copy, distribute and/or modify the "
        + "software.  Also, for each author's protection and ours, we want to make certain "
        + "that everyone understands that there is no warranty for this free software. If t"
        + "he software is modified by someone else and passed on, we want its recipients to"
        + " know that what they have is not the original, so that any problems introduced b"
        + "y others will not reflect on the original authors' reputations.  Finally, any fr"
        + "ee program is threatened constantly by software patents. We wish to avoid the da"
        + "nger that redistributors of a free program will individually obtain patent licen"
        + "ses, in effect making the program proprietary. To prevent this, we have made it "
        + "clear that any patent must be licensed for everyone's free use or not licensed a"
        + "t all.  The precise terms and conditions for copying, distribution and modificat"
        + "ion follow.  TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION  0."
        + " This License applies to any program or other work which contains a notice place"
        + "d by the copyright holder saying it may be distributed under the terms of this A"
        + "ffero General Public License. The \"Program\", below, refers to any such program o"
        + "r work, and a \"work based on the Program\" means either the Program or any deriva"
        + "tive work under copyright law: that is to say, a work containing the Program or "
        + "a portion of it, either verbatim or with modifications and/or translated into an"
        + "other language. (Hereinafter, translation is included without limitation in the "
        + "term \"modification\".) Each licensee is addressed as \"you\".  Activities other tha"
        + "n copying, distribution and modification are not covered by this License; they a"
        + "re outside its scope. The act of running the Program is not restricted, and the "
        + "output from the Program is covered only if its contents constitute a work based "
        + "on the Program (independent of having been made by running the Program). Whether"
        + " that is true depends on what the Program does.  1. You may copy and distribute "
        + "verbatim copies of the Program's source code as you receive it, in any medium, p"
        + "rovided that you conspicuously and appropriately publish on each copy an appropr"
        + "iate copyright notice and disclaimer of warranty; keep intact all the notices th"
        + "at refer to this License and to the absence of any warranty; and give any other "
        + "recipients of the Program a copy of this License along with the Program.  You ma"
        + "y charge a fee for the physical act of transferring a copy, and you may at your "
        + "option offer warranty protection in exchange for a fee.  2. You may modify your "
        + "copy or copies of the Program or any portion of it, thus forming a work based on"
        + " the Program, and copy and distribute such modifications or work under the terms"
        + " of Section 1 above, provided that you also meet all of these conditions:  a) Y"
        + "ou must cause the modified files to carry prominent notices stating that you cha"
        + "nged the files and the date of any change.    b) You must cause any work that y"
        + "ou distribute or publish, that in whole or in part contains or is derived from t"
        + "he Program or any part thereof, to be licensed as a whole at no charge to all th"
        + "ird parties under the terms of this License.    c) If the modified program norm"
        + "ally reads commands interactively when run, you must cause it, when started runn"
        + "ing for such interactive use in the most ordinary way, to print or display an an"
        + "nouncement including an appropriate copyright notice and a notice that there is "
        + "no warranty (or else, saying that you provide a warranty) and that users may red"
        + "istribute the program under these conditions, and telling the user how to view a"
        + " copy of this License. (Exception: if the Program itself is interactive but does"
        + " not normally print such an announcement, your work based on the Program is not "
        + "required to print an announcement.)    d) If the Program as you received it is "
        + "intended to interact with users through a computer network and if, in the versio"
        + "n you received, any user interacting with the Program was given the opportunity "
        + "to request transmission to that user of the Program's complete source code, you "
        + "must not remove that facility from your modified version of the Program or work "
        + "based on the Program, and must offer an equivalent opportunity for all users int"
        + "eracting with your Program through a computer network to request immediate trans"
        + "mission by HTTP of the complete source code of your modified version or other de"
        + "rivative work.  These requirements apply to the modified work as a whole. If ide"
        + "ntifiable sections of that work are not derived from the Program, and can be rea"
        + "sonably considered independent and separate works in themselves, then this Licen"
        + "se, and its terms, do not apply to those sections when you distribute them as se"
        + "parate works. But when you distribute the same sections as part of a whole which"
        + " is a work based on the Program, the distribution of the whole must be on the te"
        + "rms of this License, whose permissions for other licensees extend to the entire "
        + "whole, and thus to each and every part regardless of who wrote it.  Thus, it is "
        + "not the intent of this section to claim rights or contest your rights to work wr"
        + "itten entirely by you; rather, the intent is to exercise the right to control th"
        + "e distribution of derivative or collective works based on the Program.  In addit"
        + "ion, mere aggregation of another work not based on the Program with the Program "
        + "(or with a work based on the Program) on a volume of a storage or distribution m"
        + "edium does not bring the other work under the scope of this License.  3. You may"
        + " copy and distribute the Program (or a work based on it, under Section 2) in obj"
        + "ect code or executable form under the terms of Sections 1 and 2 above provided t"
        + "hat you also do one of the following:    a) Accompany it with the complete corr"
        + "esponding machine-readable source code, which must be distributed under the term"
        + "s of Sections 1 and 2 above on a medium customarily used for software interchang"
        + "e; or,    b) Accompany it with a written offer, valid for at least three years,"
        + " to give any third party, for a charge no more than your cost of physically perf"
        + "orming source distribution, a complete machine-readable copy of the correspondin"
        + "g source code, to be distributed under the terms of Sections 1 and 2 above on a "
        + "medium customarily used for software interchange; or,    c) Accompany it with t"
        + "he information you received as to the offer to distribute corresponding source c"
        + "ode. (This alternative is allowed only for noncommercial distribution and only i"
        + "f you received the program in object code or executable form with such an offer,"
        + " in accord with Subsection b above.)  The source code for a work means the prefe"
        + "rred form of the work for making modifications to it. For an executable work, co"
        + "mplete source code means all the source code for all modules it contains, plus a"
        + "ny associated interface definition files, plus the scripts used to control compi"
        + "lation and installation of the executable. However, as a special exception, the "
        + "source code distributed need not include anything that is normally distributed ("
        + "in either source or binary form) with the major components (compiler, kernel, an"
        + "d so on) of the operating system on which the executable runs, unless that compo"
        + "nent itself accompanies the executable.  If distribution of executable or object"
        + " code is made by offering access to copy from a designated place, then offering "
        + "equivalent access to copy the source code from the same place counts as distribu"
        + "tion of the source code, even though third parties are not compelled to copy the"
        + " source along with the object code.  4. You may not copy, modify, sublicense, or"
        + " distribute the Program except as expressly provided under this License. Any att"
        + "empt otherwise to copy, modify, sublicense or distribute the Program is void, an"
        + "d will automatically terminate your rights under this License. However, parties "
        + "who have received copies, or rights, from you under this License will not have t"
        + "heir licenses terminated so long as such parties remain in full compliance.  5. "
        + "You are not required to accept this License, since you have not signed it. Howev"
        + "er, nothing else grants you permission to modify or distribute the Program or it"
        + "s derivative works. These actions are prohibited by law if you do not accept thi"
        + "s License. Therefore, by modifying or distributing the Program (or any work base"
        + "d on the Program), you indicate your acceptance of this License to do so, and al"
        + "l its terms and conditions for copying, distributing or modifying the Program or"
        + " works based on it.  6. Each time you redistribute the Program (or any work base"
        + "d on the Program), the recipient automatically receives a license from the origi"
        + "nal licensor to copy, distribute or modify the Program subject to these terms an"
        + "d conditions. You may not impose any further restrictions on the recipients' exe"
        + "rcise of the rights granted herein. You are not responsible for enforcing compli"
        + "ance by third parties to this License.  7. If, as a consequence of a court judgm"
        + "ent or allegation of patent infringement or for any other reason (not limited to"
        + " patent issues), conditions are imposed on you (whether by court order, agreemen"
        + "t or otherwise) that contradict the conditions of this License, they do not excu"
        + "se you from the conditions of this License. If you cannot distribute so as to sa"
        + "tisfy simultaneously your obligations under this License and any other pertinent"
        + " obligations, then as a consequence you may not distribute the Program at all. F"
        + "or example, if a patent license would not permit royalty-free redistribution of "
        + "the Program by all those who receive copies directly or indirectly through you, "
        + "then the only way you could satisfy both it and this License would be to refrain"
        + " entirely from distribution of the Program.  If any portion of this section is h"
        + "eld invalid or unenforceable under any particular circumstance, the balance of t"
        + "he section is intended to apply and the section as a whole is intended to apply "
        + "in other circumstances.  It is not the purpose of this section to induce you to "
        + "infringe any patents or other property right claims or to contest validity of an"
        + "y such claims; this section has the sole purpose of protecting the integrity of "
        + "the free software distribution system, which is implemented by public license pr"
        + "actices. Many people have made generous contributions to the wide range of softw"
        + "are distributed through that system in reliance on consistent application of tha"
        + "t system; it is up to the author/donor to decide if he or she is willing to dist"
        + "ribute software through any other system and a licensee cannot impose that choic"
        + "e.  This section is intended to make thoroughly clear what is believed to be a c"
        + "onsequence of the rest of this License.  8. If the distribution and/or use of th"
        + "e Program is restricted in certain countries either by patents or by copyrighted"
        + " interfaces, the original copyright holder who places the Program under this Lic"
        + "ense may add an explicit geographical distribution limitation excluding those co"
        + "untries, so that distribution is permitted only in or among countries not thus e"
        + "xcluded. In such case, this License incorporates the limitation as if written in"
        + " the body of this License.  9. Affero Inc. may publish revised and/or new versio"
        + "ns of the Affero General Public License from time to time. Such new versions wil"
        + "l be similar in spirit to the present version, but may differ in detail to addre"
        + "ss new problems or concerns.  Each version is given a distinguishing version num"
        + "ber. If the Program specifies a version number of this License which applies to "
        + "it and \"any later version\", you have the option of following the terms and condi"
        + "tions either of that version or of any later version published by Affero, Inc. I"
        + "f the Program does not specify a version number of this License, you may choose "
        + "any version ever published by Affero, Inc.\n"
        + "You may also choose to redistribute modified versions of this program under any "
        + "version of the Free Software Foundation's GNU General Public License version 3 o"
        + "r higher, so long as that version of the GNU GPL includes terms and conditions s"
        + "ubstantially equivalent to those of this license.\n"
        + "10. If you wish to incorporate parts of the Program into other free programs who"
        + "se distribution conditions are different, write to the author to ask for permiss"
        + "ion. For software which is copyrighted by Affero, Inc., write to us; we sometime"
        + "s make exceptions for this. Our decision will be guided by the two goals of pres"
        + "erving the free status of all derivatives of our free software and of promoting "
        + "the sharing and reuse of software generally.  NO WARRANTY  11. BECAUSE THE PROGR"
        + "AM IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR THE PROGRAM, TO THE EXTE"
        + "NT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPY"
        + "RIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE PROGRAM \"AS IS\" WITHOUT WARRANTY "
        + "OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMP"
        + "LIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE ENT"
        + "IRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM IS WITH YOU. SHOULD TH"
        + "E PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECESSARY SERVICING, REPAI"
        + "R OR CORRECTION.  12. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO"
        + " IN WRITING WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR "
        + "REDISTRIBUTE THE PROGRAM AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLU"
        + "DING ANY GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF TH"
        + "E USE OR INABILITY TO USE THE PROGRAM (INCLUDING BUT NOT LIMITED TO LOSS OF DATA"
        + " OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES O"
        + "R A FAILURE OF THE PROGRAM TO OPERATE WITH ANY OTHER PROGRAMS), EVEN IF SUCH HOL"
        + "DER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
; // the license text
    }
 
    
}
