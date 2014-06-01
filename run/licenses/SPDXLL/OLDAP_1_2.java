package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:26Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OLDAP_1_2.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OLDAP_1_2 extends License{
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
        return "OLDAP-1.2"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Open LDAP Public License v1.2 "; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The OpenLDAP Public License\n"
        + "\n"
        + "Version 1.2, 1 September 1998\n"
        + "Copyright 1998, The OpenLDAP Foundation.\n"
        + "All Rights Reserved.\n"
        + "\n"
        + "Note:\n"
        + "    This license is derived from the \"Artistic License\" as distributed\n"
        + "    with the Perl Programming Language.  As differences may exist,\n"
        + "    the complete license should be read.\n"
        + "\n"
        + "PREAMBLE\n"
        + "\n"
        + "The intent of this document is to state the conditions under which\n"
        + "a Package may be copied, such that the Copyright Holder maintains\n"
        + "some semblance of artistic control over the development of the\n"
        + "package, while giving the users of the package the right to use\n"
        + "and distribute the Package in a more-or-less customary fashion,\n"
        + "plus the right to make reasonable modifications.\n"
        + "\n"
        + "Definitions:\n"
        + "\n"
        + "    \"Package\" refers to the collection of files distributed by the\n"
        + "    Copyright Holder, and derivatives of that collection of files\n"
        + "    created through textual modification.\n"
        + "\n"
        + "    \"Standard Version\" refers to such a Package if it has not been\n"
        + "    modified, or has been modified in accordance with the wishes\n"
        + "    of the Copyright Holder.\n"
        + "\n"
        + "    \"Copyright Holder\" is whoever is named in the copyright or\n"
        + "    copyrights for the package.\n"
        + "\n"
        + "    \"You\" is you, if you're thinking about copying or distributing\n"
        + "    this Package.\n"
        + "\n"
        + "    \"Reasonable copying fee\" is whatever you can justify on the\n"
        + "    basis of media cost, duplication charges, time of people\n"
        + "    involved, and so on.  (You will not be required to justify it\n"
        + "    to the Copyright Holder, but only to the computing community\n"
        + "    at large as a market that must bear the fee.)\n"
        + "\n"
        + "    \"Freely Available\" means that no fee is charged for the item\n"
        + "    itself, though there may be fees involved in handling the item.\n"
        + "    It also means that recipients of the item may redistribute it\n"
        + "    under the same conditions they received it.\n"
        + "\n"
        + "1. You may make and give away verbatim copies of the source form\n"
        + "of the Standard Version of this Package without restriction, provided\n"
        + "that you duplicate all of the original copyright notices and\n"
        + "associated disclaimers.\n"
        + "\n"
        + "2. You may apply bug fixes, portability fixes and other modifications\n"
        + "derived from the Public Domain or from the Copyright Holder.  A\n"
        + "Package modified in such a way shall still be considered the Standard\n"
        + "Version.\n"
        + "\n"
        + "3. You may otherwise modify your copy of this Package in any way,\n"
        + "provided that you insert a prominent notice in each changed file\n"
        + "stating how and when you changed that file, and provided that you\n"
        + "do at least ONE of the following:\n"
        + "\n"
        + "    a) place your modifications in the Public Domain or otherwise\n"
        + "    make them Freely Available, such as by posting said modifications\n"
        + "    to Usenet or an equivalent medium, or placing the modifications\n"
        + "    on a major archive site such as uunet.uu.net, or by allowing\n"
        + "    the Copyright Holder to include your modifications in the\n"
        + "    Standard Version of the Package.\n"
        + "\n"
        + "    b) use the modified Package only within your corporation or\n"
        + "    organization.\n"
        + "\n"
        + "    c) rename any non-standard executables so the names do not\n"
        + "    conflict with standard executables, which must also be provided,\n"
        + "    and provide a separate manual page for each non-standard\n"
        + "    executable that clearly documents how it differs from the\n"
        + "    Standard Version.\n"
        + "\n"
        + "    d) make other distribution arrangements with the Copyright\n"
        + "    Holder.\n"
        + "\n"
        + "4. You may distribute the programs of this Package in object code\n"
        + "or executable form, provided that you do at least ONE of the\n"
        + "following:\n"
        + "\n"
        + "    a) distribute a Standard Version of the executables and library\n"
        + "    files, together with instructions (in the manual page or\n"
        + "    equivalent) on where to get the Standard Version.\n"
        + "\n"
        + "    b) accompany the distribution with the machine-readable source\n"
        + "    of the Package with your modifications.\n"
        + "\n"
        + "    c) accompany any non-standard executables with their corresponding\n"
        + "    Standard Version executables, giving the non-standard executables\n"
        + "    non-standard names, and clearly documenting the differences in\n"
        + "    manual pages (or equivalent), together with instructions on\n"
        + "    where to get the Standard Version.\n"
        + "\n"
        + "    d) make other distribution arrangements with the Copyright\n"
        + "    Holder.\n"
        + "\n"
        + "5. You may charge a reasonable copying fee for any distribution of\n"
        + "this Package.  You may charge any fee you choose for support of\n"
        + "this Package.  You may not charge a fee for this Package itself.\n"
        + "However, you may distribute this Package in aggregate with other\n"
        + "(possibly commercial) programs as part of a larger (possibly\n"
        + "commercial) software distribution provided that you do not advertise\n"
        + "this Package as a product of your own.\n"
        + "\n"
        + "6. The scripts and library files supplied as input to or produced\n"
        + "as output from the programs of this Package do not automatically\n"
        + "fall under the copyright of this Package, but belong to whomever\n"
        + "generated them, and may be sold commercially, and may be aggregated\n"
        + "with this Package.\n"
        + "\n"
        + "7. C subroutines supplied by you and linked into this Package in\n"
        + "order to emulate subroutines and variables of the language defined\n"
        + "by this Package shall not be considered part of this Package, but\n"
        + "are the equivalent of input as in Paragraph 6, provided these\n"
        + "subroutines do not change the language in any way that would cause\n"
        + "it to fail the regression tests for the language.\n"
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
