package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:48Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LGPL_2_1_plus.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class LGPL_2_1_plus extends License{
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
        return "LGPL-2.1+"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU Lesser General Public License v2.1 or later"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "GNU LESSER GENERAL PUBLIC LICENSE\n"
        + "\n"
        + "Version 2.1, February 1999\n"
        + "\n"
        + "Copyright (C) 1991, 1999 Free Software Foundation, Inc.\n"
        + "51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA\n"
        + "\n"
        + "Everyone is permitted to copy and distribute verbatim copies of this license doc"
        + "ument, but changing it is not allowed.\n"
        + "\n"
        + "[This is the first released version of the Lesser GPL.  It also counts as the su"
        + "ccessor of the GNU Library Public License, version 2, hence the version number 2"
        + ".1.]\n"
        + "\n"
        + "Preamble\n"
        + "\n"
        + "The licenses for most software are designed to take away your freedom to share a"
        + "nd change it. By contrast, the GNU General Public Licenses are intended to guara"
        + "ntee your freedom to share and change free software--to make sure the software i"
        + "s free for all its users.\n"
        + "\n"
        + "This license, the Lesser General Public License, applies to some specially desig"
        + "nated software packages--typically libraries--of the Free Software Foundation an"
        + "d other authors who decide to use it. You can use it too, but we suggest you fir"
        + "st think carefully about whether this license or the ordinary General Public Lic"
        + "ense is the better strategy to use in any particular case, based on the explanat"
        + "ions below.\n"
        + "\n"
        + "When we speak of free software, we are referring to freedom of use, not price. O"
        + "ur General Public Licenses are designed to make sure that you have the freedom t"
        + "o distribute copies of free software (and charge for this service if you wish); "
        + "that you receive source code or can get it if you want it; that you can change t"
        + "he software and use pieces of it in new free programs; and that you are informed"
        + " that you can do these things.\n"
        + "\n"
        + "To protect your rights, we need to make restrictions that forbid distributors to"
        + " deny you these rights or to ask you to surrender these rights. These restrictio"
        + "ns translate to certain responsibilities for you if you distribute copies of the"
        + " library or if you modify it.\n"
        + "\n"
        + "For example, if you distribute copies of the library, whether gratis or for a fe"
        + "e, you must give the recipients all the rights that we gave you. You must make s"
        + "ure that they, too, receive or can get the source code. If you link other code w"
        + "ith the library, you must provide complete object files to the recipients, so th"
        + "at they can relink them with the library after making changes to the library and"
        + " recompiling it. And you must show them these terms so they know their rights.\n"
        + "\n"
        + "We protect your rights with a two-step method: (1) we copyright the library, and"
        + " (2) we offer you this license, which gives you legal permission to copy, distri"
        + "bute and/or modify the library.\n"
        + "\n"
        + "To protect each distributor, we want to make it very clear that there is no warr"
        + "anty for the free library. Also, if the library is modified by someone else and "
        + "passed on, the recipients should know that what they have is not the original ve"
        + "rsion, so that the original author's reputation will not be affected by problems"
        + " that might be introduced by others.\n"
        + "\n"
        + "Finally, software patents pose a constant threat to the existence of any free pr"
        + "ogram. We wish to make sure that a company cannot effectively restrict the users"
        + " of a free program by obtaining a restrictive license from a patent holder. Ther"
        + "efore, we insist that any patent license obtained for a version of the library m"
        + "ust be consistent with the full freedom of use specified in this license.\n"
        + "\n"
        + "Most GNU software, including some libraries, is covered by the ordinary GNU Gene"
        + "ral Public License. This license, the GNU Lesser General Public License, applies"
        + " to certain designated libraries, and is quite different from the ordinary Gener"
        + "al Public License. We use this license for certain libraries in order to permit "
        + "linking those libraries into non-free programs.\n"
        + "\n"
        + "When a program is linked with a library, whether statically or using a shared li"
        + "brary, the combination of the two is legally speaking a combined work, a derivat"
        + "ive of the original library. The ordinary General Public License therefore permi"
        + "ts such linking only if the entire combination fits its criteria of freedom. The"
        + " Lesser General Public License permits more lax criteria for linking other code "
        + "with the library.\n"
        + "\n"
        + "We call this license the \"Lesser\" General Public License because it does Less to"
        + " protect the user's freedom than the ordinary General Public License. It also pr"
        + "ovides other free software developers Less of an advantage over competing non-fr"
        + "ee programs. These disadvantages are the reason we use the ordinary General Publ"
        + "ic License for many libraries. However, the Lesser license provides advantages i"
        + "n certain special circumstances.\n"
        + "\n"
        + "For example, on rare occasions, there may be a special need to encourage the wid"
        + "est possible use of a certain library, so that it becomes a de-facto standard. T"
        + "o achieve this, non-free programs must be allowed to use the library. A more fre"
        + "quent case is that a free library does the same job as widely used non-free libr"
        + "aries. In this case, there is little to gain by limiting the free library to fre"
        + "e software only, so we use the Lesser General Public License.\n"
        + "\n"
        + "In other cases, permission to use a particular library in non-free programs enab"
        + "les a greater number of people to use a large body of free software. For example"
        + ", permission to use the GNU C Library in non-free programs enables many more peo"
        + "ple to use the whole GNU operating system, as well as its variant, the GNU/Linux"
        + " operating system.\n"
        + "\n"
        + "Although the Lesser General Public License is Less protective of the users' free"
        + "dom, it does ensure that the user of a program that is linked with the Library h"
        + "as the freedom and the wherewithal to run that program using a modified version "
        + "of the Library.\n"
        + "\n"
        + "The precise terms and conditions for copying, distribution and modification foll"
        + "ow. Pay close attention to the difference between a \"work based on the library\" "
        + "and a \"work that uses the library\". The former contains code derived from the li"
        + "brary, whereas the latter must be combined with the library in order to run.\n"
        + "\n"
        + "TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION\n"
        + "\n"
        + "0. This License Agreement applies to any software library or other program which"
        + " contains a notice placed by the copyright holder or other authorized party sayi"
        + "ng it may be distributed under the terms of this Lesser General Public License ("
        + "also called \"this License\"). Each licensee is addressed as \"you\".\n"
        + "\n"
        + "A \"library\" means a collection of software functions and/or data prepared so as "
        + "to be conveniently linked with application programs (which use some of those fun"
        + "ctions and data) to form executables.\n"
        + "\n"
        + "The \"Library\", below, refers to any such software library or work which has been"
        + " distributed under these terms. A \"work based on the Library\" means either the L"
        + "ibrary or any derivative work under copyright law: that is to say, a work contai"
        + "ning the Library or a portion of it, either verbatim or with modifications and/o"
        + "r translated straightforwardly into another language. (Hereinafter, translation "
        + "is included without limitation in the term \"modification\".)\n"
        + "\n"
        + "\"Source code\" for a work means the preferred form of the work for making modific"
        + "ations to it. For a library, complete source code means all the source code for "
        + "all modules it contains, plus any associated interface definition files, plus th"
        + "e scripts used to control compilation and installation of the library.\n"
        + "\n"
        + "Activities other than copying, distribution and modification are not covered by "
        + "this License; they are outside its scope. The act of running a program using the"
        + " Library is not restricted, and output from such a program is covered only if it"
        + "s contents constitute a work based on the Library (independent of the use of the"
        + " Library in a tool for writing it). Whether that is true depends on what the Lib"
        + "rary does and what the program that uses the Library does.\n"
        + "\n"
        + "1. You may copy and distribute verbatim copies of the Library's complete source "
        + "code as you receive it, in any medium, provided that you conspicuously and appro"
        + "priately publish on each copy an appropriate copyright notice and disclaimer of "
        + "warranty; keep intact all the notices that refer to this License and to the abse"
        + "nce of any warranty; and distribute a copy of this License along with the Librar"
        + "y.\n"
        + "\n"
        + "You may charge a fee for the physical act of transferring a copy, and you may at"
        + " your option offer warranty protection in exchange for a fee.\n"
        + "\n"
        + "2. You may modify your copy or copies of the Library or any portion of it, thus "
        + "forming a work based on the Library, and copy and distribute such modifications "
        + "or work under the terms of Section 1 above, provided that you also meet all of t"
        + "hese conditions:\n"
        + "\n"
        + "a) The modified work must itself be a software library.\n"
        + "b) You must cause the files modified to carry prominent notices stating that you"
        + " changed the files and the date of any change.\n"
        + "c) You must cause the whole of the work to be licensed at no charge to all third"
        + " parties under the terms of this License.\n"
        + "d) If a facility in the modified Library refers to a function or a table of data"
        + " to be supplied by an application program that uses the facility, other than as "
        + "an argument passed when the facility is invoked, then you must make a good faith"
        + " effort to ensure that, in the event an application does not supply such functio"
        + "n or table, the facility still operates, and performs whatever part of its purpo"
        + "se remains meaningful.\n"
        + "\n"
        + "(For example, a function in a library to compute square roots has a purpose that"
        + " is entirely well-defined independent of the application. Therefore, Subsection "
        + "2d requires that any application-supplied function or table used by this functio"
        + "n must be optional: if the application does not supply it, the square root funct"
        + "ion must still compute square roots.)\n"
        + "\n"
        + "These requirements apply to the modified work as a whole. If identifiable sectio"
        + "ns of that work are not derived from the Library, and can be reasonably consider"
        + "ed independent and separate works in themselves, then this License, and its term"
        + "s, do not apply to those sections when you distribute them as separate works. Bu"
        + "t when you distribute the same sections as part of a whole which is a work based"
        + " on the Library, the distribution of the whole must be on the terms of this Lice"
        + "nse, whose permissions for other licensees extend to the entire whole, and thus "
        + "to each and every part regardless of who wrote it.\n"
        + "\n"
        + "Thus, it is not the intent of this section to claim rights or contest your right"
        + "s to work written entirely by you; rather, the intent is to exercise the right t"
        + "o control the distribution of derivative or collective works based on the Librar"
        + "y.\n"
        + "\n"
        + "In addition, mere aggregation of another work not based on the Library with the "
        + "Library (or with a work based on the Library) on a volume of a storage or distri"
        + "bution medium does not bring the other work under the scope of this License.\n"
        + "\n"
        + "3. You may opt to apply the terms of the ordinary GNU General Public License ins"
        + "tead of this License to a given copy of the Library. To do this, you must alter "
        + "all the notices that refer to this License, so that they refer to the ordinary G"
        + "NU General Public License, version 2, instead of to this License. (If a newer ve"
        + "rsion than version 2 of the ordinary GNU General Public License has appeared, th"
        + "en you can specify that version instead if you wish.) Do not make any other chan"
        + "ge in these notices.\n"
        + "\n"
        + "Once this change is made in a given copy, it is irreversible for that copy, so t"
        + "he ordinary GNU General Public License applies to all subsequent copies and deri"
        + "vative works made from that copy.\n"
        + "\n"
        + "This option is useful when you wish to copy part of the code of the Library into"
        + " a program that is not a library.\n"
        + "\n"
        + "4. You may copy and distribute the Library (or a portion or derivative of it, un"
        + "der Section 2) in object code or executable form under the terms of Sections 1 a"
        + "nd 2 above provided that you accompany it with the complete corresponding machin"
        + "e-readable source code, which must be distributed under the terms of Sections 1 "
        + "and 2 above on a medium customarily used for software interchange.\n"
        + "\n"
        + "If distribution of object code is made by offering access to copy from a designa"
        + "ted place, then offering equivalent access to copy the source code from the same"
        + " place satisfies the requirement to distribute the source code, even though thir"
        + "d parties are not compelled to copy the source along with the object code.\n"
        + "\n"
        + "5. A program that contains no derivative of any portion of the Library, but is d"
        + "esigned to work with the Library by being compiled or linked with it, is called "
        + "a \"work that uses the Library\". Such a work, in isolation, is not a derivative w"
        + "ork of the Library, and therefore falls outside the scope of this License.\n"
        + "\n"
        + "However, linking a \"work that uses the Library\" with the Library creates an exec"
        + "utable that is a derivative of the Library (because it contains portions of the "
        + "Library), rather than a \"work that uses the library\". The executable is therefor"
        + "e covered by this License. Section 6 states terms for distribution of such execu"
        + "tables.\n"
        + "\n"
        + "When a \"work that uses the Library\" uses material from a header file that is par"
        + "t of the Library, the object code for the work may be a derivative work of the L"
        + "ibrary even though the source code is not. Whether this is true is especially si"
        + "gnificant if the work can be linked without the Library, or if the work is itsel"
        + "f a library. The threshold for this to be true is not precisely defined by law.\n"
        + "\n"
        + "If such an object file uses only numerical parameters, data structure layouts an"
        + "d accessors, and small macros and small inline functions (ten lines or less in l"
        + "ength), then the use of the object file is unrestricted, regardless of whether i"
        + "t is legally a derivative work. (Executables containing this object code plus po"
        + "rtions of the Library will still fall under Section 6.)\n"
        + "\n"
        + "Otherwise, if the work is a derivative of the Library, you may distribute the ob"
        + "ject code for the work under the terms of Section 6. Any executables containing "
        + "that work also fall under Section 6, whether or not they are linked directly wit"
        + "h the Library itself.\n"
        + "\n"
        + "6. As an exception to the Sections above, you may also combine or link a \"work t"
        + "hat uses the Library\" with the Library to produce a work containing portions of "
        + "the Library, and distribute that work under terms of your choice, provided that "
        + "the terms permit modification of the work for the customer's own use and reverse"
        + " engineering for debugging such modifications.\n"
        + "\n"
        + "You must give prominent notice with each copy of the work that the Library is us"
        + "ed in it and that the Library and its use are covered by this License. You must "
        + "supply a copy of this License. If the work during execution displays copyright n"
        + "otices, you must include the copyright notice for the Library among them, as wel"
        + "l as a reference directing the user to the copy of this License. Also, you must "
        + "do one of these things:\n"
        + "\n"
        + "a) Accompany the work with the complete corresponding machine-readable source co"
        + "de for the Library including whatever changes were used in the work (which must "
        + "be distributed under Sections 1 and 2 above); and, if the work is an executable "
        + "linked with the Library, with the complete machine-readable \"work that uses the "
        + "Library\", as object code and/or source code, so that the user can modify the Lib"
        + "rary and then relink to produce a modified executable containing the modified Li"
        + "brary. (It is understood that the user who changes the contents of definitions f"
        + "iles in the Library will not necessarily be able to recompile the application to"
        + " use the modified definitions.)\n"
        + "b) Use a suitable shared library mechanism for linking with the Library. A suita"
        + "ble mechanism is one that (1) uses at run time a copy of the library already pre"
        + "sent on the user's computer system, rather than copying library functions into t"
        + "he executable, and (2) will operate properly with a modified version of the libr"
        + "ary, if the user installs one, as long as the modified version is interface-comp"
        + "atible with the version that the work was made with.\n"
        + "c) Accompany the work with a written offer, valid for at least three years, to g"
        + "ive the same user the materials specified in Subsection 6a, above, for a charge "
        + "no more than the cost of performing this distribution.\n"
        + "d) If distribution of the work is made by offering access to copy from a designa"
        + "ted place, offer equivalent access to copy the above specified materials from th"
        + "e same place.\n"
        + "e) Verify that the user has already received a copy of these materials or that y"
        + "ou have already sent this user a copy.\n"
        + "\n"
        + "For an executable, the required form of the \"work that uses the Library\" must in"
        + "clude any data and utility programs needed for reproducing the executable from i"
        + "t. However, as a special exception, the materials to be distributed need not inc"
        + "lude anything that is normally distributed (in either source or binary form) wit"
        + "h the major components (compiler, kernel, and so on) of the operating system on "
        + "which the executable runs, unless that component itself accompanies the executab"
        + "le.\n"
        + "\n"
        + "It may happen that this requirement contradicts the license restrictions of othe"
        + "r proprietary libraries that do not normally accompany the operating system. Suc"
        + "h a contradiction means you cannot use both them and the Library together in an "
        + "executable that you distribute.\n"
        + "\n"
        + "7. You may place library facilities that are a work based on the Library side-by"
        + "-side in a single library together with other library facilities not covered by "
        + "this License, and distribute such a combined library, provided that the separate"
        + " distribution of the work based on the Library and of the other library faciliti"
        + "es is otherwise permitted, and provided that you do these two things:\n"
        + "\n"
        + "a) Accompany the combined library with a copy of the same work based on the Libr"
        + "ary, uncombined with any other library facilities. This must be distributed unde"
        + "r the terms of the Sections above.\n"
        + "b) Give prominent notice with the combined library of the fact that part of it i"
        + "s a work based on the Library, and explaining where to find the accompanying unc"
        + "ombined form of the same work.\n"
        + "\n"
        + "8. You may not copy, modify, sublicense, link with, or distribute the Library ex"
        + "cept as expressly provided under this License. Any attempt otherwise to copy, mo"
        + "dify, sublicense, link with, or distribute the Library is void, and will automat"
        + "ically terminate your rights under this License. However, parties who have recei"
        + "ved copies, or rights, from you under this License will not have their licenses "
        + "terminated so long as such parties remain in full compliance.\n"
        + "\n"
        + "9. You are not required to accept this License, since you have not signed it. Ho"
        + "wever, nothing else grants you permission to modify or distribute the Library or"
        + " its derivative works. These actions are prohibited by law if you do not accept "
        + "this License. Therefore, by modifying or distributing the Library (or any work b"
        + "ased on the Library), you indicate your acceptance of this License to do so, and"
        + " all its terms and conditions for copying, distributing or modifying the Library"
        + " or works based on it.\n"
        + "\n"
        + "10. Each time you redistribute the Library (or any work based on the Library), t"
        + "he recipient automatically receives a license from the original licensor to copy"
        + ", distribute, link with or modify the Library subject to these terms and conditi"
        + "ons. You may not impose any further restrictions on the recipients' exercise of "
        + "the rights granted herein. You are not responsible for enforcing compliance by t"
        + "hird parties with this License.\n"
        + "\n"
        + "11. If, as a consequence of a court judgment or allegation of patent infringemen"
        + "t or for any other reason (not limited to patent issues), conditions are imposed"
        + " on you (whether by court order, agreement or otherwise) that contradict the con"
        + "ditions of this License, they do not excuse you from the conditions of this Lice"
        + "nse. If you cannot distribute so as to satisfy simultaneously your obligations u"
        + "nder this License and any other pertinent obligations, then as a consequence you"
        + " may not distribute the Library at all. For example, if a patent license would n"
        + "ot permit royalty-free redistribution of the Library by all those who receive co"
        + "pies directly or indirectly through you, then the only way you could satisfy bot"
        + "h it and this License would be to refrain entirely from distribution of the Libr"
        + "ary.\n"
        + "\n"
        + "If any portion of this section is held invalid or unenforceable under any partic"
        + "ular circumstance, the balance of the section is intended to apply, and the sect"
        + "ion as a whole is intended to apply in other circumstances.\n"
        + "\n"
        + "It is not the purpose of this section to induce you to infringe any patents or o"
        + "ther property right claims or to contest validity of any such claims; this secti"
        + "on has the sole purpose of protecting the integrity of the free software distrib"
        + "ution system which is implemented by public license practices. Many people have "
        + "made generous contributions to the wide range of software distributed through th"
        + "at system in reliance on consistent application of that system; it is up to the "
        + "author/donor to decide if he or she is willing to distribute software through an"
        + "y other system and a licensee cannot impose that choice.\n"
        + "\n"
        + "This section is intended to make thoroughly clear what is believed to be a conse"
        + "quence of the rest of this License.\n"
        + "\n"
        + "12. If the distribution and/or use of the Library is restricted in certain count"
        + "ries either by patents or by copyrighted interfaces, the original copyright hold"
        + "er who places the Library under this License may add an explicit geographical di"
        + "stribution limitation excluding those countries, so that distribution is permitt"
        + "ed only in or among countries not thus excluded. In such case, this License inco"
        + "rporates the limitation as if written in the body of this License.\n"
        + "\n"
        + "13. The Free Software Foundation may publish revised and/or new versions of the "
        + "Lesser General Public License from time to time. Such new versions will be simil"
        + "ar in spirit to the present version, but may differ in detail to address new pro"
        + "blems or concerns.\n"
        + "\n"
        + "Each version is given a distinguishing version number. If the Library specifies "
        + "a version number of this License which applies to it and \"any later version\", yo"
        + "u have the option of following the terms and conditions either of that version o"
        + "r of any later version published by the Free Software Foundation. If the Library"
        + " does not specify a license version number, you may choose any version ever publ"
        + "ished by the Free Software Foundation.\n"
        + "\n"
        + "14. If you wish to incorporate parts of the Library into other free programs who"
        + "se distribution conditions are incompatible with these, write to the author to a"
        + "sk for permission. For software which is copyrighted by the Free Software Founda"
        + "tion, write to the Free Software Foundation; we sometimes make exceptions for th"
        + "is. Our decision will be guided by the two goals of preserving the free status o"
        + "f all derivatives of our free software and of promoting the sharing and reuse of"
        + " software generally.\n"
        + "\n"
        + "NO WARRANTY\n"
        + "\n"
        + "15. BECAUSE THE LIBRARY IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR THE"
        + " LIBRARY, TO THE EXTENT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN OTHERWISE STATE"
        + "D IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE LIBRARY \"AS "
        + "IS\" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NO"
        + "T LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTIC"
        + "ULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE LIBRARY I"
        + "S WITH YOU. SHOULD THE LIBRARY PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECES"
        + "SARY SERVICING, REPAIR OR CORRECTION.\n"
        + "\n"
        + "16. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING WILL A"
        + "NY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR REDISTRIBUTE THE L"
        + "IBRARY AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY GENERAL, "
        + "SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR INABILITY"
        + " TO USE THE LIBRARY (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA BEING REN"
        + "DERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A FAILURE OF THE"
        + " LIBRARY TO OPERATE WITH ANY OTHER SOFTWARE), EVEN IF SUCH HOLDER OR OTHER PARTY"
        + " HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "END OF TERMS AND CONDITIONS\n"
        + "\n"
        + "How to Apply These Terms to Your New Libraries\n"
        + "\n"
        + "If you develop a new library, and you want it to be of the greatest possible use"
        + " to the public, we recommend making it free software that everyone can redistrib"
        + "ute and change. You can do so by permitting redistribution under these terms (or"
        + ", alternatively, under the terms of the ordinary General Public License).\n"
        + "\n"
        + "To apply these terms, attach the following notices to the library. It is safest "
        + "to attach them to the start of each source file to most effectively convey the e"
        + "xclusion of warranty; and each file should have at least the \"copyright\" line an"
        + "d a pointer to where the full notice is found.\n"
        + "\n"
        + "one line to give the library's name and an idea of what it does.\n"
        + "Copyright (C) year  name of author\n"
        + "\n"
        + "This library is free software; you can redistribute it and/or\n"
        + "modify it under the terms of the GNU Lesser General Public\n"
        + "License as published by the Free Software Foundation; either\n"
        + "version 2.1 of the License, or (at your option) any later version.\n"
        + "\n"
        + "This library is distributed in the hope that it will be useful,\n"
        + "but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
        + "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU\n"
        + "Lesser General Public License for more details.\n"
        + "\n"
        + "You should have received a copy of the GNU Lesser General Public\n"
        + "License along with this library; if not, write to the Free Software\n"
        + "Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA\n"
        + "Also add information on how to contact you by electronic and paper mail.\n"
        + "\n"
        + "You should also get your employer (if you work as a programmer) or your school, "
        + "if any, to sign a \"copyright disclaimer\" for the library, if necessary. Here is "
        + "a sample; alter the names:\n"
        + "\n"
        + "Yoyodyne, Inc., hereby disclaims all copyright interest in\n"
        + "the library `Frob' (a library for tweaking knobs) written\n"
        + "by James Random Hacker.\n"
        + "\n"
        + "signature of Ty Coon, 1 April 1990\n"
        + "Ty Coon, President of Vice\n"
        + "That's all there is to it!\n"
; // the license text
    }
 
    
}
