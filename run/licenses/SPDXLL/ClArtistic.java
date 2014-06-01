package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:44Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: ClArtistic.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class ClArtistic extends License{
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
        return "ClArtistic"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Clarified Artistic License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Clarified Artistic License\n"
        + "\n"
        + "Preamble\n"
        + "\n"
        + "The intent of this document is to state the conditions under which a\n"
        + "Package may be copied, such that the Copyright Holder maintains some\n"
        + "semblance of artistic control over the development of the package,\n"
        + "while giving the users of the package the right to use and distribute\n"
        + "the Package in a more-or-less customary fashion, plus the right to make\n"
        + "reasonable modifications.\n"
        + "\n"
        + "Definitions:\n"
        + "\n"
        + " \"Package\" refers to the collection of files distributed by the\n"
        + " Copyright Holder, and derivatives of that collection of files\n"
        + " created through textual modification.\n"
        + "\n"
        + " \"Standard Version\" refers to such a Package if it has not been\n"
        + " modified, or has been modified in accordance with the wishes\n"
        + " of the Copyright Holder as specified below.\n"
        + "\n"
        + " \"Copyright Holder\" is whoever is named in the copyright or\n"
        + " copyrights for the package.\n"
        + "\n"
        + " \"You\" is you, if you're thinking about copying or distributing\n"
        + " this Package.\n"
        + "\n"
        + " \"Distribution fee\" is a fee you charge for providing a copy\n"
        + " of this Package to another party.\n"
        + "\n"
        + " \"Freely Available\" means that no fee is charged for the right to\n"
        + " use the item, though there may be fees involved in handling the\n"
        + " item.  It also means that recipients of the item may redistribute\n"
        + " it under the same conditions they received it.\n"
        + "\n"
        + "1. You may make and give away verbatim copies of the source form of the\n"
        + "Standard Version of this Package without restriction, provided that you\n"
        + "duplicate all of the original copyright notices and associated disclaimers.\n"
        + "\n"
        + "2. You may apply bug fixes, portability fixes and other modifications\n"
        + "derived from the Public Domain, or those made Freely Available, or from\n"
        + "the Copyright Holder.  A Package modified in such a way shall still be\n"
        + "considered the Standard Version.\n"
        + "\n"
        + "3. You may otherwise modify your copy of this Package in any way, provided\n"
        + "that you insert a prominent notice in each changed file stating how and\n"
        + "when you changed that file, and provided that you do at least ONE of the\n"
        + "following:\n"
        + "\n"
        + "    a) place your modifications in the Public Domain or otherwise make them\n"
        + "    Freely Available, such as by posting said modifications to Usenet or an\n"
        + "    equivalent medium, or placing the modifications on a major network\n"
        + "    archive site allowing unrestricted access to them, or by allowing the\n"
        + "    Copyright Holder to include your modifications in the Standard Version\n"
        + "    of the Package.\n"
        + "\n"
        + "    b) use the modified Package only within your corporation or organization.\n"
        + "\n"
        + "    c) rename any non-standard executables so the names do not conflict\n"
        + "    with standard executables, which must also be provided, and provide\n"
        + "    a separate manual page for each non-standard executable that clearly\n"
        + "    documents how it differs from the Standard Version.\n"
        + "\n"
        + "    d) make other distribution arrangements with the Copyright Holder.\n"
        + "\n"
        + "    e) permit and encourge anyone who receives a copy of the modified Package\n"
        + "    permission to make your modifications Freely Available\n"
        + "    in some specific way.\n"
        + "\n"
        + "\n"
        + "4. You may distribute the programs of this Package in object code or\n"
        + "executable form, provided that you do at least ONE of the following:\n"
        + "\n"
        + "    a) distribute a Standard Version of the executables and library files,\n"
        + "    together with instructions (in the manual page or equivalent) on where\n"
        + "    to get the Standard Version.\n"
        + "\n"
        + "    b) accompany the distribution with the machine-readable source of\n"
        + "    the Package with your modifications.\n"
        + "\n"
        + "    c) give non-standard executables non-standard names, and clearly\n"
        + "    document the differences in manual pages (or equivalent), together\n"
        + "    with instructions on where to get the Standard Version.\n"
        + "\n"
        + "    d) make other distribution arrangements with the Copyright Holder.\n"
        + "\n"
        + "    e) offer the machine-readable source of the Package, with your\n"
        + "    modifications, by mail order.\n"
        + "\n"
        + "5. You may charge a distribution fee for any distribution of this Package.\n"
        + "If you offer support for this Package, you may charge any fee you choose\n"
        + "for that support.  You may not charge a license fee for the right to use\n"
        + "this Package itself.  You may distribute this Package in aggregate with\n"
        + "other (possibly commercial and possibly nonfree) programs as part of a\n"
        + "larger (possibly commercial and possibly nonfree) software distribution,\n"
        + "and charge license fees for other parts of that software distribution,\n"
        + "provided that you do not advertise this Package as a product of your own.\n"
        + "If the Package includes an interpreter, You may embed this Package's\n"
        + "interpreter within an executable of yours (by linking); this shall be\n"
        + "construed as a mere form of aggregation, provided that the complete\n"
        + "Standard Version of the interpreter is so embedded.\n"
        + "\n"
        + "6. The scripts and library files supplied as input to or produced as\n"
        + "output from the programs of this Package do not automatically fall\n"
        + "under the copyright of this Package, but belong to whoever generated\n"
        + "them, and may be sold commercially, and may be aggregated with this\n"
        + "Package.  If such scripts or library files are aggregated with this\n"
        + "Package via the so-called \"undump\" or \"unexec\" methods of producing a\n"
        + "binary executable image, then distribution of such an image shall\n"
        + "neither be construed as a distribution of this Package nor shall it\n"
        + "fall under the restrictions of Paragraphs 3 and 4, provided that you do\n"
        + "not represent such an executable image as a Standard Version of this\n"
        + "Package.\n"
        + "\n"
        + "7. C subroutines (or comparably compiled subroutines in other\n"
        + "languages) supplied by you and linked into this Package in order to\n"
        + "emulate subroutines and variables of the language defined by this\n"
        + "Package shall not be considered part of this Package, but are the\n"
        + "equivalent of input as in Paragraph 6, provided these subroutines do\n"
        + "not change the language in any way that would cause it to fail the\n"
        + "regression tests for the language.\n"
        + "\n"
        + "8. Aggregation of the Standard Version of the Package with a commercial\n"
        + "distribution is always permitted provided that the use of this Package\n"
        + "is embedded; that is, when no overt attempt is made to make this Package's\n"
        + "interfaces visible to the end user of the commercial distribution.\n"
        + "Such use shall not be construed as a distribution of this Package.\n"
        + "\n"
        + "9. The name of the Copyright Holder may not be used to endorse or promote\n"
        + "products derived from this software without specific prior written permission.\n"
        + "\n"
        + "10. THIS PACKAGE IS PROVIDED \"AS IS\" AND WITHOUT ANY EXPRESS OR\n"
        + "IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED\n"
        + "WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.\n"
        + "\n"
        + "The End\n"
; // the license text
    }
 
    
}
