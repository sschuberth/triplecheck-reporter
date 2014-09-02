package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:57Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LPPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class LPPL_1_0 extends License{
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
        return "LPPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "LaTeX Project Public License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "LaTeX Project Public License\n"
        + "============================\n"
        + " \n"
        + "LPPL Version 1.0  1999-03-01\n"
        + "\n"
        + "Copyright 1999 LaTeX3 Project\n"
        + "    Everyone is permitted to copy and distribute verbatim copies\n"
        + "    of this license document, but modification is not allowed.\n"
        + "\n"
        + "\n"
        + "Preamble\n"
        + "========\n"
        + "\n"
        + "The LaTeX Project Public License (LPPL) is the license under which the\n"
        + "base LaTeX distribution is distributed. As described below you may use\n"
        + "this licence for any software that you wish to distribute. \n"
        + "\n"
        + "It may be particularly suitable if your software is TeX related (such\n"
        + "as a LaTeX package file) but it may be used for any software, even if\n"
        + "it is unrelated to TeX.\n"
        + "\n"
        + "To use this license, the files of your distribution should have an\n"
        + "explicit copyright notice giving your name and the year, together\n"
        + "with a reference to this license.\n"
        + "\n"
        + "A typical example would be\n"
        + "\n"
        + "   %% pig.sty\n"
        + "   %% Copyright 2001 M. Y. Name\n"
        + "\n"
        + "   % This program can redistributed and/or modified under the terms\n"
        + "   % of the LaTeX Project Public License Distributed from CTAN\n"
        + "   % archives in directory macros/latex/base/lppl.txt; either\n"
        + "   % version 1 of the License, or (at your option) any later version.\n"
        + "\n"
        + "Given such a notice in the file, the conditions of this document would\n"
        + "apply, with:\n"
        + "\n"
        + "`The Program' referring to the software `pig.sty'  and \n"
        + "`The Copyright Holder' referring to the person `M. Y. Name'.\n"
        + "\n"
        + "To see a real example, see the file legal.txt which carries the\n"
        + "copyright notice for the base latex distribution.\n"
        + "\n"
        + "This license gives terms under which files of The Program may be\n"
        + "distributed and modified. Individual files may have specific further\n"
        + "constraints on modification, but no file should have restrictions on\n"
        + "distribution other than those specified below. \n"
        + "This is to ensure that a distributor wishing to distribute a complete\n"
        + "unmodified copy of The Program need only check the conditions in this\n"
        + "file, and does not need to check every file in The Program for extra\n"
        + "restrictions. If you do need to modify the distribution terms of some\n"
        + "files, do not refer to this license, instead distribute The Program\n"
        + "under a different license. You may use the parts of the text of LPPL as\n"
        + "a model for your own license, but your license should not directly refer\n"
        + "to the LPPL or otherwise give the impression that The Program is\n"
        + "distributed under the LPPL. \n"
        + "\n"
        + "\n"
        + "\n"
        + "The LaTeX Project Public License\n"
        + "================================\n"
        + "Terms And Conditions For Copying, Distribution And Modification\n"
        + "===============================================================\n"
        + "\n"
        + "\n"
        + "WARRANTY\n"
        + "========\n"
        + "\n"
        + "There is no warranty for The Program, to the extent permitted by\n"
        + "applicable law.  Except when otherwise stated in writing, The\n"
        + "Copyright Holder provides The Program `as is' without warranty of any\n"
        + "kind, either expressed or implied, including, but not limited to, the\n"
        + "implied warranties of merchantability and fitness for a particular\n"
        + "purpose.  The entire risk as to the quality and performance of the\n"
        + "program is with you.  Should The Program prove defective, you assume\n"
        + "the cost of all necessary servicing, repair or correction.\n"
        + "\n"
        + "In no event unless required by applicable law or agreed to in writing\n"
        + "will The Copyright Holder, or any of the individual authors named in\n"
        + "the source for The Program, be liable to you for damages, including\n"
        + "any general, special, incidental or consequential damages arising out\n"
        + "of any use of The Program or out of inability to use The Program\n"
        + "(including but not limited to loss of data or data being rendered\n"
        + "inaccurate or losses sustained by you or by third parties as a result\n"
        + "of a failure of The Program to operate with any other programs), even\n"
        + "if such holder or other party has been advised of the possibility of\n"
        + "such damages.\n"
        + "\n"
        + "\n"
        + "DISTRIBUTION\n"
        + "============\n"
        + "\n"
        + "Redistribution of unchanged files is allowed provided that all files\n"
        + "that make up the distribution of The Program are distributed.\n"
        + "In particular this means that The Program has to be distributed\n"
        + "including its documentation if documentation was part of the original\n"
        + "distribution.\n"
        + "\n"
        + "The distribution of The Program will contain a prominent file\n"
        + "listing all the files covered by this license.\n"
        + "\n"
        + "If you receive only some of these files from someone, complain!\n"
        + "\n"
        + "The distribution of changed versions of certain files included in the\n"
        + "The Program, and the reuse of code from The Program, are allowed\n"
        + "under the following restrictions:\n"
        + "\n"
        + " * It is allowed only if the legal notice in the file does not\n"
        + "   expressly forbid it.\n"
        + "   See note below, under \"Conditions on individual files\".\n"
        + " \n"
        + " * You rename the file before you make any changes to it, unless the\n"
        + "   file explicitly says that renaming is not required.  Any such changed\n"
        + "   files must be distributed under a license that forbids distribution\n"
        + "   of those files, and any files derived from them, under the names used\n"
        + "   by the original files in the distribution of The Program.\n"
        + "\n"
        + " * You change any `identification string' in The Program to clearly \n"
        + "   indicate that the file is not part of the standard system.\n"
        + "\n"
        + " * If The Program includes an `error report address' so that errors\n"
        + "   may be reported to The Copyright Holder, or other specified\n"
        + "   addresses, this address must be changed in any modified versions of\n"
        + "   The Program, so that reports for files not maintained by the\n"
        + "   original program maintainers are directed to the maintainers of the\n"
        + "   changed files. \n"
        + "\n"
        + " * You acknowledge the source and authorship of the original version\n"
        + "   in the modified file.\n"
        + "\n"
        + " * You also distribute the unmodified version of the file or\n"
        + "   alternatively provide sufficient information so that the\n"
        + "   user of your modified file can be reasonably expected to be\n"
        + "   able to obtain an original, unmodified copy of The Program.\n"
        + "   For example, you may specify a URL to a site that you expect\n"
        + "   will freely provide the user with a copy of The Program (either\n"
        + "   the version on which your modification is based, or perhaps a\n"
        + "   later version).\n"
        + "\n"
        + " * If The Program is intended to be used with, or is based on, LaTeX,\n"
        + "   then files with the following file extensions which have special\n"
        + "   meaning in LaTeX Software, have special modification rules under the\n"
        + "   license:\n"
        + " \n"
        + "    - Files with extension `.ins' (installation files): these files may\n"
        + "      not be modified at all because they contain the legal notices\n"
        + "      that are placed in the generated files.\n"
        + " \n"
        + "    - Files with extension `.fd' (LaTeX font definitions files): these\n"
        + "      files are allowed to be modified without changing the name, but\n"
        + "      only to enable use of all available fonts and to prevent attempts\n"
        + "      to access unavailable fonts. However, modified files are not\n"
        + "      allowed to be distributed in place of original files.\n"
        + " \n"
        + "    - Files with extension `.cfg' (configuration files): these files\n"
        + "      can be created or modified to enable easy configuration of the\n"
        + "      system.  The documentation in cfgguide.tex in the base LaTeX\n"
        + "      distribution describes when it makes sense to modify or generate\n"
        + "      such files.\n"
        + " \n"
        + "\n"
        + "The above restrictions are not intended to prohibit, and hence do\n"
        + "not apply to, the updating, by any method, of a file so that it\n"
        + "becomes identical to the latest version of that file in The Program.\n"
        + "\n"
        + "========================================================================\n"
        + "\n"
        + "NOTES\n"
        + "=====\n"
        + "\n"
        + "We believe that these requirements give you the freedom you to make\n"
        + "modifications that conform with whatever technical specifications you\n"
        + "wish, whilst maintaining the availability, integrity and reliability of\n"
        + "The Program.  If you do not see how to achieve your goal whilst\n"
        + "adhering to these requirements then read the document cfgguide.tex\n"
        + "in the base LaTeX distribution for suggestions. \n"
        + "\n"
        + "Because of the portability and exchangeability aspects of systems\n"
        + "like LaTeX, The LaTeX3 Project deprecates the distribution of\n"
        + "non-standard versions of components of LaTeX or of generally available\n"
        + "contributed code for them but such distributions are permitted under the\n"
        + "above restrictions.\n"
        + "\n"
        + "The document modguide.tex in the base LaTeX distribution details\n"
        + "the reasons for the legal requirements detailed above.\n"
        + "Even if The Program is unrelated to LaTeX, the argument in\n"
        + "modguide.tex may still apply, and should be read before\n"
        + "a modified version of The Program is distributed.\n"
        + "\n"
        + "\n"
        + "Conditions on individual files\n"
        + "==============================\n"
        + "\n"
        + "The individual files may bear additional conditions which supersede\n"
        + "the general conditions on distribution and modification contained in\n"
        + "this file. If there are any such files, the distribution of The\n"
        + "Program will contain a prominent file that lists all the exceptional\n"
        + "files.\n"
        + "\n"
        + "Typical examples of files with more restrictive modification\n"
        + "conditions would be files that contain the text of copyright notices.\n"
        + "\n"
        + " * The conditions on individual files differ only in the\n"
        + "   extent of *modification* that is allowed.\n"
        + "\n"
        + " * The conditions on *distribution* are the same for all the files.\n"
        + "   Thus a (re)distributor of a complete, unchanged copy of The Program\n"
        + "   need meet only the conditions in this file; it is not necessary to\n"
        + "   check the header of every file in the distribution to check that a\n"
        + "   distribution meets these requirements.\n"
; // the license text
    }
 
    
}
