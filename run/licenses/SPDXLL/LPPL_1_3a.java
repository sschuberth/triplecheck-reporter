package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:32:39Z
 * LicenseName: Apache-2.0
 * FileName: LPPL_1_3a.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class LPPL_1_3a extends License{
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
        return "LPPL-1.3a"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "LaTeX Project Public License 1.3a "; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The LaTeX Project Public License\n"
        + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n"
        + "\n"
        + "LPPL Version 1.3a  2004-10-01\n"
        + "\n"
        + "Copyright 1999 2002-04 LaTeX3 Project\n"
        + "    Everyone is allowed to distribute verbatim copies of this\n"
        + "    license document, but modification of it is not allowed.\n"
        + "\n"
        + "\n"
        + "PREAMBLE\n"
        + "========\n"
        + "\n"
        + "The LaTeX Project Public License (LPPL) is the primary license under\n"
        + "which the the LaTeX kernel and the base LaTeX packages are distributed.\n"
        + "\n"
        + "You may use this license for any work of which you hold the copyright\n"
        + "and which you wish to distribute.  This license may be particularly\n"
        + "suitable if your work is TeX-related (such as a LaTeX package), but\n"
        + "you may use it with small modifications even if your work is unrelated\n"
        + "to TeX.\n"
        + "\n"
        + "The section `WHETHER AND HOW TO DISTRIBUTE WORKS UNDER THIS LICENSE',\n"
        + "below, gives instructions, examples, and recommendations for authors\n"
        + "who are considering distributing their works under this license.\n"
        + "\n"
        + "This license gives conditions under which a work may be distributed\n"
        + "and modified, as well as conditions under which modified versions of\n"
        + "that work may be distributed.\n"
        + "\n"
        + "We, the LaTeX3 Project, believe that the conditions below give you\n"
        + "the freedom to make and distribute modified versions of your work\n"
        + "that conform with whatever technical specifications you wish while\n"
        + "maintaining the availability, integrity, and reliability of\n"
        + "that work.  If you do not see how to achieve your goal while\n"
        + "meeting these conditions, then read the document `cfgguide.tex'\n"
        + "and `modguide.tex' in the base LaTeX distribution for suggestions.\n"
        + "\n"
        + "\n"
        + "DEFINITIONS\n"
        + "===========\n"
        + "\n"
        + "In this license document the following terms are used:\n"
        + "\n"
        + "   `Work'\n"
        + "    Any work being distributed under this License.\n"
        + "    \n"
        + "   `Derived Work'\n"
        + "    Any work that under any applicable law is derived from the Work.\n"
        + "\n"
        + "   `Modification' \n"
        + "    Any procedure that produces a Derived Work under any applicable\n"
        + "    law -- for example, the production of a file containing an\n"
        + "    original file associated with the Work or a significant portion of\n"
        + "    such a file, either verbatim or with modifications and/or\n"
        + "    translated into another language.\n"
        + "\n"
        + "   `Modify'\n"
        + "    To apply any procedure that produces a Derived Work under any\n"
        + "    applicable law.\n"
        + "    \n"
        + "   `Distribution'\n"
        + "    Making copies of the Work available from one person to another, in\n"
        + "    whole or in part.  Distribution includes (but is not limited to)\n"
        + "    making any electronic components of the Work accessible by\n"
        + "    file transfer protocols such as FTP or HTTP or by shared file\n"
        + "    systems such as Sun's Network File System (NFS).\n"
        + "\n"
        + "   `Compiled Work'\n"
        + "    A version of the Work that has been processed into a form where it\n"
        + "    is directly usable on a computer system.  This processing may\n"
        + "    include using installation facilities provided by the Work,\n"
        + "    transformations of the Work, copying of components of the Work, or\n"
        + "    other activities.  Note that modification of any installation\n"
        + "    facilities provided by the Work constitutes modification of the Work.\n"
        + "\n"
        + "   `Current Maintainer'\n"
        + "    A person or persons nominated as such within the Work.  If there is\n"
        + "    no such explicit nomination then it is the `Copyright Holder' under\n"
        + "    any applicable law.\n"
        + "\n"
        + "   `Base Interpreter' \n"
        + "    A program or process that is normally needed for running or\n"
        + "    interpreting a part or the whole of the Work.    \n"
        + "    A Base Interpreter may depend on external components but these\n"
        + "    are not considered part of the Base Interpreter provided that each\n"
        + "    external component clearly identifies itself whenever it is used\n"
        + "    interactively.  Unless explicitly specified when applying the\n"
        + "    license to the Work, the only applicable Base Interpreter is a\n"
        + "    \"LaTeX-Format\".\n"
        + "\n"
        + "\n"
        + "\n"
        + "CONDITIONS ON DISTRIBUTION AND MODIFICATION\n"
        + "===========================================\n"
        + "\n"
        + "1.  Activities other than distribution and/or modification of the Work\n"
        + "are not covered by this license; they are outside its scope.  In\n"
        + "particular, the act of running the Work is not restricted and no\n"
        + "requirements are made concerning any offers of support for the Work.\n"
        + "\n"
        + "2.  You may distribute a complete, unmodified copy of the Work as you\n"
        + "received it.  Distribution of only part of the Work is considered\n"
        + "modification of the Work, and no right to distribute such a Derived\n"
        + "Work may be assumed under the terms of this clause.\n"
        + "\n"
        + "3.  You may distribute a Compiled Work that has been generated from a\n"
        + "complete, unmodified copy of the Work as distributed under Clause 2\n"
        + "above, as long as that Compiled Work is distributed in such a way that\n"
        + "the recipients may install the Compiled Work on their system exactly\n"
        + "as it would have been installed if they generated a Compiled Work\n"
        + "directly from the Work.\n"
        + "\n"
        + "4.  If you are the Current Maintainer of the Work, you may, without\n"
        + "restriction, modify the Work, thus creating a Derived Work.  You may\n"
        + "also distribute the Derived Work without restriction, including\n"
        + "Compiled Works generated from the Derived Work.  Derived Works\n"
        + "distributed in this manner by the Current Maintainer are considered to\n"
        + "be updated versions of the Work.\n"
        + "\n"
        + "5.  If you are not the Current Maintainer of the Work, you may modify\n"
        + "your copy of the Work, thus creating a Derived Work based on the Work,\n"
        + "and compile this Derived Work, thus creating a Compiled Work based on\n"
        + "the Derived Work.\n"
        + "\n"
        + "6.  If you are not the Current Maintainer of the Work, you may\n"
        + "distribute a Derived Work provided the following conditions are met\n"
        + "for every component of the Work unless that component clearly states\n"
        + "in the copyright notice that it is exempt from that condition.  Only\n"
        + "the Current Maintainer is allowed to add such statements of exemption \n"
        + "to a component of the Work. \n"
        + "\n"
        + "  a. If a component of this Derived Work can be a direct replacement\n"
        + "     for a component of the Work when that component is used with the\n"
        + "     Base Interpreter, then, wherever this component of the Work\n"
        + "     identifies itself to the user when used interactively with that\n"
        + "     Base Interpreter, the replacement component of this Derived Work\n"
        + "     clearly and unambiguously identifies itself as a modified version\n"
        + "     of this component to the user when used interactively with that\n"
        + "     Base Interpreter.\n"
        + "     \n"
        + "  b. Every component of the Derived Work contains prominent notices\n"
        + "     detailing the nature of the changes to that component, or a\n"
        + "     prominent reference to another file that is distributed as part\n"
        + "     of the Derived Work and that contains a complete and accurate log\n"
        + "     of the changes.\n"
        + "  \n"
        + "  c. No information in the Derived Work implies that any persons,\n"
        + "     including (but not limited to) the authors of the original version\n"
        + "     of the Work, provide any support, including (but not limited to)\n"
        + "     the reporting and handling of errors, to recipients of the\n"
        + "     Derived Work unless those persons have stated explicitly that\n"
        + "     they do provide such support for the Derived Work.\n"
        + "\n"
        + "  d. You distribute at least one of the following with the Derived Work:\n"
        + "\n"
        + "       1. A complete, unmodified copy of the Work; \n"
        + "          if your distribution of a modified component is made by\n"
        + "          offering access to copy the modified component from a\n"
        + "          designated place, then offering equivalent access to copy\n"
        + "          the Work from the same or some similar place meets this\n"
        + "          condition, even though third parties are not compelled to\n"
        + "          copy the Work along with the modified component;\n"
        + "\n"
        + "       2. Information that is sufficient to obtain a complete, unmodified\n"
        + "          copy of the Work.\n"
        + "\n"
        + "7.  If you are not the Current Maintainer of the Work, you may\n"
        + "distribute a Compiled Work generated from a Derived Work, as long as\n"
        + "the Derived Work is distributed to all recipients of the Compiled\n"
        + "Work, and as long as the conditions of Clause 6, above, are met with\n"
        + "regard to the Derived Work.\n"
        + "\n"
        + "8.  The conditions above are not intended to prohibit, and hence do\n"
        + "not apply to, the modification, by any method, of any component so that it\n"
        + "becomes identical to an  updated version of that component of the Work as\n"
        + "it is distributed by the Current Maintainer under Clause 4, above.\n"
        + "\n"
        + "9.  Distribution of the Work or any Derived Work in an alternative\n"
        + "format, where the Work or that Derived Work (in whole or in part) is\n"
        + "then produced by applying some process to that format, does not relax or\n"
        + "nullify any sections of this license as they pertain to the results of\n"
        + "applying that process.\n"
        + "     \n"
        + "10. a. A Derived Work may be distributed under a different license\n"
        + "       provided that license itself honors the conditions listed in\n"
        + "       Clause 6 above, in regard to the Work, though it does not have\n"
        + "       to honor the rest of the conditions in this license.\n"
        + "      \n"
        + "    b. If a Derived Work is distributed under this license, that\n"
        + "       Derived Work must provide sufficient documentation as part of\n"
        + "       itself to allow each recipient of that Derived Work to honor the \n"
        + "       restrictions in Clause 6 above, concerning changes from the Work.\n"
        + "\n"
        + "11. This license places no restrictions on works that are unrelated to\n"
        + "the Work, nor does this license place any restrictions on aggregating\n"
        + "such works with the Work by any means.\n"
        + "\n"
        + "12.  Nothing in this license is intended to, or may be used to, prevent\n"
        + "complete compliance by all parties with all applicable laws.\n"
        + "\n"
        + "\n"
        + "NO WARRANTY\n"
        + "===========\n"
        + "\n"
        + "There is no warranty for the Work.  Except when otherwise stated in\n"
        + "writing, the Copyright Holder provides the Work `as is', without\n"
        + "warranty of any kind, either expressed or implied, including, but not\n"
        + "limited to, the implied warranties of merchantability and fitness for\n"
        + "a particular purpose.  The entire risk as to the quality and performance\n"
        + "of the Work is with you.  Should the Work prove defective, you\n"
        + "assume the cost of all necessary servicing, repair, or correction.\n"
        + "\n"
        + "In no event unless required by applicable law or agreed to in writing\n"
        + "will The Copyright Holder, or any author named in the components of\n"
        + "the Work, or any other party who may distribute and/or modify the Work\n"
        + "as permitted above, be liable to you for damages, including any\n"
        + "general, special, incidental or consequential damages arising out of\n"
        + "any use of the Work or out of inability to use the Work (including,\n"
        + "but not limited to, loss of data, data being rendered inaccurate, or\n"
        + "losses sustained by anyone as a result of any failure of the Work to\n"
        + "operate with any other programs), even if the Copyright Holder or said\n"
        + "author or said other party has been advised of the possibility of such\n"
        + "damages.\n"
        + "\n"
        + "\n"
        + "MAINTENANCE OF THE WORK\n"
        + "=======================\n"
        + "\n"
        + "The Work has the status `author-maintained' if the Copyright Holder\n"
        + "explicitly and prominently states near the primary copyright notice in\n"
        + "the Work that the Work can only be maintained by the Copyright Holder\n"
        + "or simply that is `author-maintained'.\n"
        + "\n"
        + "The Work has the status `maintained' if there is a Current Maintainer\n"
        + "who has indicated in the Work that they are willing to receive error\n"
        + "reports for the Work (for example, by supplying a valid e-mail\n"
        + "address). It is not required for the Current Maintainer to acknowledge\n"
        + "or act upon these error reports.\n"
        + "\n"
        + "The Work changes from status `maintained' to `unmaintained' if there\n"
        + "is no Current Maintainer, or the person stated to be Current\n"
        + "Maintainer of the work cannot be reached through the indicated means\n"
        + "of communication for a period of six months, and there are no other\n"
        + "significant signs of active maintenance.\n"
        + "\n"
        + "You can become the Current Maintainer of the Work by agreement with\n"
        + "any existing Current Maintainer to take over this role.\n"
        + "\n"
        + "If the Work is unmaintained, you can become the Current Maintainer of\n"
        + "the Work through the following steps:\n"
        + "\n"
        + " 1.  Make a reasonable attempt to trace the Current Maintainer (and\n"
        + "     the Copyright Holder, if the two differ) through the means of\n"
        + "     an Internet or similar search.\n"
        + "\n"
        + " 2.  If this search is successful, then enquire whether the Work\n"
        + "     is still maintained.\n"
        + "\n"
        + "  a. If it is being maintained, then ask the Current Maintainer\n"
        + "     to update their communication data within one month.\n"
        + "     \n"
        + "  b. If the search is unsuccessful or no action to resume active\n"
        + "     maintenance is taken by the Current Maintainer, then announce\n"
        + "     within the pertinent community your intention to take over\n"
        + "     maintenance.  (If the Work is a LaTeX work, this could be\n"
        + "     done, for example, by posting to comp.text.tex.)\n"
        + "\n"
        + " 3a. If the Current Maintainer is reachable and agrees to pass\n"
        + "     maintenance of the Work to you, then this takes effect\n"
        + "     immediately upon announcement.\n"
        + "     \n"
        + "  b. If the Current Maintainer is not reachable and the Copyright\n"
        + "     Holder agrees that maintenance of the Work be passed to you,\n"
        + "     then this takes effect immediately upon announcement.  \n"
        + "    \n"
        + " 4.  If you make an `intention announcement' as described in 2b. above\n"
        + "     and after three months your intention is challenged neither by\n"
        + "     the Current Maintainer nor by the Copyright Holder nor by other\n"
        + "     people, then you may arrange for the Work to be changed so as\n"
        + "     to name you as the (new) Current Maintainer.\n"
        + "     \n"
        + " 5.  If the previously unreachable Current Maintainer becomes\n"
        + "     reachable once more within three months of a change completed\n"
        + "     under the terms of 3b) or 4), then that Current Maintainer must\n"
        + "     become or remain the Current Maintainer upon request provided\n"
        + "     they then update their communication data within one month.\n"
        + "\n"
        + "A change in the Current Maintainer does not, of itself, alter the fact\n"
        + "that the Work is distributed under the LPPL license.\n"
        + "\n"
        + "If you become the Current Maintainer of the Work, you should\n"
        + "immediately provide, within the Work, a prominent and unambiguous\n"
        + "statement of your status as Current Maintainer.  You should also\n"
        + "announce your new status to the same pertinent community as\n"
        + "in 2b) above.\n"
        + "\n"
        + "\n"
        + "WHETHER AND HOW TO DISTRIBUTE WORKS UNDER THIS LICENSE\n"
        + "======================================================\n"
        + "\n"
        + "This section contains important instructions, examples, and\n"
        + "recommendations for authors who are considering distributing their\n"
        + "works under this license.  These authors are addressed as `you' in\n"
        + "this section.\n"
        + "\n"
        + "Choosing This License or Another License\n"
        + "----------------------------------------\n"
        + "\n"
        + "If for any part of your work you want or need to use *distribution*\n"
        + "conditions that differ significantly from those in this license, then\n"
        + "do not refer to this license anywhere in your work but, instead,\n"
        + "distribute your work under a different license.  You may use the text\n"
        + "of this license as a model for your own license, but your license\n"
        + "should not refer to the LPPL or otherwise give the impression that\n"
        + "your work is distributed under the LPPL.\n"
        + "\n"
        + "The document `modguide.tex' in the base LaTeX distribution explains\n"
        + "the motivation behind the conditions of this license.  It explains,\n"
        + "for example, why distributing LaTeX under the GNU General Public\n"
        + "License (GPL) was considered inappropriate.  Even if your work is\n"
        + "unrelated to LaTeX, the discussion in `modguide.tex' may still be\n"
        + "relevant, and authors intending to distribute their works under any\n"
        + "license are encouraged to read it.\n"
        + "\n"
        + "A Recommendation on Modification Without Distribution\n"
        + "-----------------------------------------------------\n"
        + "\n"
        + "It is wise never to modify a component of the Work, even for your own\n"
        + "personal use, without also meeting the above conditions for\n"
        + "distributing the modified component.  While you might intend that such\n"
        + "modifications will never be distributed, often this will happen by\n"
        + "accident -- you may forget that you have modified that component; or\n"
        + "it may not occur to you when allowing others to access the modified\n"
        + "version that you are thus distributing it and violating the conditions\n"
        + "of this license in ways that could have legal implications and, worse,\n"
        + "cause problems for the community.  It is therefore usually in your\n"
        + "best interest to keep your copy of the Work identical with the public\n"
        + "one.  Many works provide ways to control the behavior of that work\n"
        + "without altering any of its licensed components.\n"
        + "\n"
        + "How to Use This License\n"
        + "-----------------------\n"
        + "\n"
        + "To use this license, place in each of the components of your work both\n"
        + "an explicit copyright notice including your name and the year the work\n"
        + "was authored and/or last substantially modified.  Include also a\n"
        + "statement that the distribution and/or modification of that\n"
        + "component is constrained by the conditions in this license.\n"
        + "\n"
        + "Here is an example of such a notice and statement:\n"
        + "\n"
        + "  %% pig.dtx\n"
        + "  %% Copyright 2003 M. Y. Name\n"
        + "  %\n"
        + "  % This work may be distributed and/or modified under the\n"
        + "  % conditions of the LaTeX Project Public License, either version 1.3\n"
        + "  % of this license or (at your option) any later version.\n"
        + "  % The latest version of this license is in\n"
        + "  %   http://www.latex-project.org/lppl.txt\n"
        + "  % and version 1.3 or later is part of all distributions of LaTeX\n"
        + "  % version 2003/12/01 or later.\n"
        + "  %\n"
        + "  % This work has the LPPL maintenance status \"maintained\".\n"
        + "  % \n"
        + "  % This Current Maintainer of this work is M. Y. Name.\n"
        + "  %\n"
        + "  % This work consists of the files pig.dtx and pig.ins\n"
        + "  % and the derived file pig.sty.\n"
        + "\n"
        + "Given such a notice and statement in a file, the conditions\n"
        + "given in this license document would apply, with the `Work' referring\n"
        + "to the three files `pig.dtx', `pig.ins', and `pig.sty' (the last being\n"
        + "generated from `pig.dtx' using `pig.ins'), the `Base Interpreter'\n"
        + "referring to any \"LaTeX-Format\", and both `Copyright Holder' and\n"
        + "`Current Maintainer' referring to the person `M. Y. Name'.\n"
        + "\n"
        + "If you do not want the Maintenance section of LPPL to apply to your\n"
        + "Work, change \"maintained\" above into \"author-maintained\".  \n"
        + "However, we recommend that you use \"maintained\" as the Maintenance\n"
        + "section was added in order to ensure that your Work remains useful to\n"
        + "the community even when you can no longer maintain and support it\n"
        + "yourself.\n"
        + "\n"
        + "\n"
        + "Important Recommendations\n"
        + "-------------------------\n"
        + "\n"
        + " Defining What Constitutes the Work\n"
        + "\n"
        + "   The LPPL requires that distributions of the Work contain all the\n"
        + "   files of the Work.  It is therefore important that you provide a\n"
        + "   way for the licensee to determine which files constitute the Work.\n"
        + "   This could, for example, be achieved by explicitly listing all the\n"
        + "   files of the Work near the copyright notice of each file or by\n"
        + "   using a line such as:\n"
        + "\n"
        + "    % This work consists of all files listed in manifest.txt.\n"
        + "   \n"
        + "   in that place.  In the absence of an unequivocal list it might be\n"
        + "   impossible for the licensee to determine what is considered by you\n"
        + "   to comprise the Work and, in such a case, the licensee would be\n"
        + "   entitled to make reasonable conjectures as to which files comprise\n"
        + "   the Work.\n"
; // the license text
    }
 
    
}
