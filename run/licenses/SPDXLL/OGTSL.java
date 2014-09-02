package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:24Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OGTSL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OGTSL extends License{
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
        return "OGTSL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Open Group Test Suite License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Open Group Test Suite License\n"
        + "\n"
        + "Preamble\n"
        + "\n"
        + "The intent of this document is to state the conditions under which\n"
        + "a Package may be copied, such that the Copyright Holder maintains\n"
        + "some semblance of artistic control over the development of the\n"
        + "package, while giving the users of the package the right to use and\n"
        + "distribute the Package in a more-or-less customary fashion, plus\n"
        + "the right to make reasonable modifications.\n"
        + "\n"
        + "Testing is essential for proper development and maintenance of\n"
        + "standards-based products.\n"
        + "\n"
        + "For buyers: adequate conformance testing leads to reduced\n"
        + "integration costs and protection of investments in applications,\n"
        + "software and people.\n"
        + "\n"
        + "For software developers: conformance testing of platforms and\n"
        + "middleware greatly reduces the cost of developing and maintaining\n"
        + "multi-platform application software.\n"
        + "\n"
        + "For suppliers: In-depth testing increases customer satisfaction and\n"
        + "keeps development and support costs in check. API conformance is\n"
        + "highly measurable and suppliers who claim it must be able to\n"
        + "substantiate that claim.\n"
        + "\n"
        + "As such, since these are benchmark measures of conformance, we feel\n"
        + "the integrity of test tools is of importance. In order to preserve\n"
        + "the integrity of the existing conformance modes of this test\n"
        + "package and to permit recipients of modified versions of this\n"
        + "package to run the original test modes, this license requires that\n"
        + "the original test modes be preserved.\n"
        + "\n"
        + "If you find a bug in one of the standards mode test cases, please\n"
        + "let us know so we can feed this back into the original, and also\n"
        + "raise any specification issues with the appropriate bodies (for\n"
        + "example the POSIX committees).\n"
        + "\n"
        + "Definitions: \n"
        + "\n"
        + "     \"Package\" refers to the collection of files distributed by the\n"
        + "     Copyright Holder, and derivatives of that collection of files\n"
        + "     created through textual modification. \n"
        + "     \"Standard Version\" refers to such a Package if it has not been\n"
        + "     modified, or has been modified in accordance with the wishes\n"
        + "     of the Copyright Holder. \n"
        + "     \"Copyright Holder\" is whoever is named in the copyright or\n"
        + "     copyrights for the package. \"You\" is you, if you're thinking\n"
        + "     about copying or distributing this Package. \n"
        + "     \"Reasonable copying fee\" is whatever you can justify on the\n"
        + "     basis of media cost, duplication charges, time of people\n"
        + "     involved, and so on. (You will not be required to justify it\n"
        + "     to the Copyright Holder, but only to the computing community\n"
        + "     at large as a market that must bear the fee.) \n"
        + "     \"Freely Available\" means that no fee is charged for the item\n"
        + "     itself, though there may be fees involved in handling the\n"
        + "     item. It also means that recipients of the item may\n"
        + "     redistribute it under the same conditions they received it. \n"
        + "\n"
        + "1. You may make and give away verbatim copies of the source form of\n"
        + "the Standard Version of this Package without restriction, provided\n"
        + "that you duplicate all of the original copyright notices and\n"
        + "associated disclaimers.\n"
        + "\n"
        + "2. You may apply bug fixes, portability fixes and other\n"
        + "modifications derived from the Public Domain or from the Copyright\n"
        + "Holder. A Package modified in such a way shall still be considered\n"
        + "the Standard Version.\n"
        + "\n"
        + "3. You may otherwise modify your copy of this Package in any way,\n"
        + "provided that you insert a prominent notice in each changed file\n"
        + "stating how and when you changed that file, and provided that you\n"
        + "do at least the following:\n"
        + "\n"
        + "     rename any non-standard executables and testcases so the\n"
        + "     names do not conflict with standard executables and\n"
        + "     testcases, which must also be provided, and provide a\n"
        + "     separate manual page for each non-standard executable and\n"
        + "     testcase that clearly documents how it differs from the\n"
        + "     Standard Version.\n"
        + "\n"
        + "4. You may distribute the programs of this Package in object code\n"
        + "or executable form, provided that you do at least the following: \n"
        + "\n"
        + "     accompany any non-standard executables and testcases with\n"
        + "     their corresponding Standard Version executables and\n"
        + "     testcases, giving the non-standard executables and\n"
        + "     testcases non-standard names, and clearly documenting the\n"
        + "     differences in manual pages (or equivalent), together with\n"
        + "     instructions on where to get the Standard Version.\n"
        + "\n"
        + "5. You may charge a reasonable copying fee for any distribution of\n"
        + "this Package. You may charge any fee you choose for support of this\n"
        + "Package. You may not charge a fee for this Package itself. However,\n"
        + "you may distribute this Package in aggregate with other (possibly\n"
        + "commercial) programs as part of a larger (possibly commercial)\n"
        + "software distribution provided that you do not advertise this\n"
        + "Package as a product of your own.\n"
        + "\n"
        + "6. The scripts and library files supplied as input to or produced\n"
        + "as output from the programs of this Package do not automatically\n"
        + "fall under the copyright of this Package, but belong to whomever\n"
        + "generated them, and may be sold commercially, and may be aggregated\n"
        + "with this Package.\n"
        + "\n"
        + "7.Subroutines supplied by you and linked into this Package shall\n"
        + "not be considered part of this Package. \n"
        + "\n"
        + "8. The name of the Copyright Holder may not be used to endorse or\n"
        + "promote products derived from this software without specific prior\n"
        + "written permission.\n"
        + "\n"
        + "9. THIS PACKAGE IS PROVIDED \"AS IS\" AND WITHOUT ANY EXPRESS OR\n"
        + "IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED\n"
        + "WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.\n"
        + "\n"
        + "The End\n"
; // the license text
    }
 
    
}
