package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:31Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Artistic_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Artistic_1_0 extends License{
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
        return "Artistic-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Artistic License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Artistic License\n"
        + "Preamble\n"
        + "\n"
        + "The intent of this document is to state the conditions under which a Package may"
        + " be copied, such that the Copyright Holder maintains some semblance of artistic "
        + "control over the development of the package, while giving the users of the packa"
        + "ge the right to use and distribute the Package in a more-or-less customary fashi"
        + "on, plus the right to make reasonable modifications.\n"
        + "\n"
        + "Definitions:\n"
        + "\n"
        + "\"Package\" refers to the collection of files distributed by the Copyright Holder,"
        + " and derivatives of that collection of files created through textual modificatio"
        + "n.\n"
        + "\n"
        + "\"Standard Version\" refers to such a Package if it has not been modified, or has "
        + "been modified in accordance with the wishes of the Copyright Holder.\n"
        + "\n"
        + "\"Copyright Holder\" is whoever is named in the copyright or copyrights for the pa"
        + "ckage.\n"
        + "\n"
        + "\"You\" is you, if you're thinking about copying or distributing this Package.\n"
        + "\n"
        + "\"Reasonable copying fee\" is whatever you can justify on the basis of media cost,"
        + " duplication charges, time of people involved, and so on. (You will not be requi"
        + "red to justify it to the Copyright Holder, but only to the computing community a"
        + "t large as a market that must bear the fee.)\n"
        + "\n"
        + "\"Freely Available\" means that no fee is charged for the item itself, though ther"
        + "e may be fees involved in handling the item. It also means that recipients of th"
        + "e item may redistribute it under the same conditions they received it.\n"
        + "\n"
        + "1. You may make and give away verbatim copies of the source form of the Standard"
        + " Version of this Package without restriction, provided that you duplicate all of"
        + " the original copyright notices and associated disclaimers.\n"
        + "\n"
        + "2. You may apply bug fixes, portability fixes and other modifications derived fr"
        + "om the Public Domain or from the Copyright Holder. A Package modified in such a "
        + "way shall still be considered the Standard Version.\n"
        + "\n"
        + "3. You may otherwise modify your copy of this Package in any way, provided that "
        + "you insert a prominent notice in each changed file stating how and when you chan"
        + "ged that file, and provided that you do at least ONE of the following:\n"
        + "\n"
        + "  a) place your modifications in the Public Domain or otherwise make them Freely"
        + " Available, such as by posting said modifications to Usenet or an equivalent med"
        + "ium, or placing the modifications on a major archive site such as ftp.uu.net, or"
        + " by allowing the Copyright Holder to include your modifications in the Standard "
        + "Version of the Package.\n"
        + "\n"
        + "  b) use the modified Package only within your corporation or organization.\n"
        + "\n"
        + "  c) rename any non-standard executables so the names do not conflict with stand"
        + "ard executables, which must also be provided, and provide a separate manual page"
        + " for each non-standard executable that clearly documents how it differs from the"
        + " Standard Version.\n"
        + "\n"
        + "  d) make other distribution arrangements with the Copyright Holder.\n"
        + "\n"
        + "4. You may distribute the programs of this Package in object code or executable "
        + "form, provided that you do at least ONE of the following:\n"
        + "\n"
        + "  a) distribute a Standard Version of the executables and library files, togethe"
        + "r with instructions (in the manual page or equivalent) on where to get the Stand"
        + "ard Version.\n"
        + "\n"
        + "  b) accompany the distribution with the machine-readable source of the Package "
        + "with your modifications.\n"
        + "\n"
        + "  c) accompany any non-standard executables with their corresponding Standard Ve"
        + "rsion executables, giving the non-standard executables non-standard names, and c"
        + "learly documenting the differences in manual pages (or equivalent), together wit"
        + "h instructions on where to get the Standard Version.\n"
        + "\n"
        + "  d) make other distribution arrangements with the Copyright Holder.\n"
        + "\n"
        + "5. You may charge a reasonable copying fee for any distribution of this Package."
        + " You may charge any fee you choose for support of this Package. You may not char"
        + "ge a fee for this Package itself. However, you may distribute this Package in ag"
        + "gregate with other (possibly commercial) programs as part of a larger (possibly "
        + "commercial) software distribution provided that you do not advertise this Packag"
        + "e as a product of your own.\n"
        + "\n"
        + "6. The scripts and library files supplied as input to or produced as output from"
        + " the programs of this Package do not automatically fall under the copyright of t"
        + "his Package, but belong to whomever generated them, and may be sold commercially"
        + ", and may be aggregated with this Package.\n"
        + "\n"
        + "7. C or perl subroutines supplied by you and linked into this Package shall not "
        + "be considered part of this Package.\n"
        + "\n"
        + "8. The name of the Copyright Holder may not be used to endorse or promote produc"
        + "ts derived from this software without specific prior written permission.\n"
        + "\n"
        + "9. THIS PACKAGE IS PROVIDED \"AS IS\" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIE"
        + "S, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND "
        + "FITNESS FOR A PARTICULAR PURPOSE.\n"
        + "\n"
        + "The End\n"
; // the license text
    }
 
    
}
