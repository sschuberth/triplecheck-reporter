package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:32Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Artistic_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Artistic_2_0 extends License{
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
        return "Artistic-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Artistic License 2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "The Artistic License 2.0\n"
        + "\n"
        + "Copyright (c) 2000-2006, The Perl Foundation.\n"
        + "\n"
        + "Everyone is permitted to copy and distribute verbatim copies of this license doc"
        + "ument, but changing it is not allowed.\n"
        + "\n"
        + "Preamble\n"
        + "\n"
        + "This license establishes the terms under which a given free software Package may"
        + " be copied, modified, distributed, and/or redistributed. The intent is that the "
        + "Copyright Holder maintains some artistic control over the development of that Pa"
        + "ckage while still keeping the Package available as open source and free software"
        + ".\n"
        + "\n"
        + "You are always permitted to make arrangements wholly outside of this license dir"
        + "ectly with the Copyright Holder of a given Package.  If the terms of this licens"
        + "e do not permit the full use that you propose to make of the Package, you should"
        + " contact the Copyright Holder and seek a different licensing arrangement. \n"
        + "\n"
        + "Definitions\n"
        + "\n"
        + "\"Copyright Holder\" means the individual(s) or organization(s) named in the copyr"
        + "ight notice for the entire Package.\n"
        + "\n"
        + "\"Contributor\" means any party that has contributed code or other material to the"
        + " Package, in accordance with the Copyright Holder's procedures.\n"
        + "\n"
        + "\"You\" and \"your\" means any person who would like to copy, distribute, or modify "
        + "the Package.\n"
        + "\n"
        + "\"Package\" means the collection of files distributed by the Copyright Holder, and"
        + " derivatives of that collection and/or of those files. A given Package may consi"
        + "st of either the Standard Version, or a Modified Version.\n"
        + "\n"
        + "\"Distribute\" means providing a copy of the Package or making it accessible to an"
        + "yone else, or in the case of a company or organization, to others outside of you"
        + "r company or organization.\n"
        + "\n"
        + "\"Distributor Fee\" means any fee that you charge for Distributing this Package or"
        + " providing support for this Package to another party.  It does not mean licensin"
        + "g fees.\n"
        + "\n"
        + "\"Standard Version\" refers to the Package if it has not been modified, or has bee"
        + "n modified only in ways explicitly requested by the Copyright Holder.\n"
        + "\n"
        + "\"Modified Version\" means the Package, if it has been changed, and such changes w"
        + "ere not explicitly requested by the Copyright Holder. \n"
        + "\n"
        + "\"Original License\" means this Artistic License as Distributed with the Standard "
        + "Version of the Package, in its current version or as it may be modified by The P"
        + "erl Foundation in the future.\n"
        + "\n"
        + "\"Source\" form means the source code, documentation source, and configuration fil"
        + "es for the Package.\n"
        + "\n"
        + "\"Compiled\" form means the compiled bytecode, object code, binary, or any other f"
        + "orm resulting from mechanical transformation or translation of the Source form.\n"
        + "\n"
        + "Permission for Use and Modification Without Distribution\n"
        + "\n"
        + "(1)  You are permitted to use the Standard Version and create and use Modified V"
        + "ersions for any purpose without restriction, provided that you do not Distribute"
        + " the Modified Version.\n"
        + "\n"
        + "\n"
        + "Permissions for Redistribution of the Standard Version\n"
        + "\n"
        + "(2)  You may Distribute verbatim copies of the Source form of the Standard Versi"
        + "on of this Package in any medium without restriction, either gratis or for a Dis"
        + "tributor Fee, provided that you duplicate all of the original copyright notices "
        + "and associated disclaimers.  At your discretion, such verbatim copies may or may"
        + " not include a Compiled form of the Package.\n"
        + "\n"
        + "(3)  You may apply any bug fixes, portability changes, and other modifications m"
        + "ade available from the Copyright Holder.  The resulting Package will still be co"
        + "nsidered the Standard Version, and as such will be subject to the Original Licen"
        + "se.\n"
        + "\n"
        + "\n"
        + "Distribution of Modified Versions of the Package as Source \n"
        + "\n"
        + "(4)  You may Distribute your Modified Version as Source (either gratis or for a "
        + "Distributor Fee, and with or without a Compiled form of the Modified Version) pr"
        + "ovided that you clearly document how it differs from the Standard Version, inclu"
        + "ding, but not limited to, documenting any non-standard features, executables, or"
        + " modules, and provided that you do at least ONE of the following:\n"
        + "\n"
        + "    (a)  make the Modified Version available to the Copyright Holder of the Stan"
        + "dard Version, under the Original License, so that the Copyright Holder may inclu"
        + "de your modifications in the Standard Version.\n"
        + "\n"
        + "    (b)  ensure that installation of your Modified Version does not prevent the "
        + "user installing or running the Standard Version. In addition, the Modified Versi"
        + "on must bear a name that is different from the name of the Standard Version.\n"
        + "\n"
        + "    (c)  allow anyone who receives a copy of the Modified Version to make the So"
        + "urce form of the Modified Version available to others under\n"
        + "  \n"
        + " (i)  the Original License or\n"
        + "\n"
        + " (ii)  a license that permits the licensee to freely copy, modify and redistrib"
        + "ute the Modified Version using the same licensing terms that apply to the copy t"
        + "hat the licensee received, and requires that the Source form of the Modified Ver"
        + "sion, and of any works derived from it, be made freely available in that license"
        + " fees are prohibited but Distributor Fees are allowed.\n"
        + "\n"
        + "\n"
        + "Distribution of Compiled Forms of the Standard Version or Modified Versions with"
        + "out the Source\n"
        + "\n"
        + "(5)  You may Distribute Compiled forms of the Standard Version without the Sourc"
        + "e, provided that you include complete instructions on how to get the Source of t"
        + "he Standard Version.  Such instructions must be valid at the time of your distri"
        + "bution.  If these instructions, at any time while you are carrying out such dist"
        + "ribution, become invalid, you must provide new instructions on demand or cease f"
        + "urther distribution. If you provide valid instructions or cease distribution wit"
        + "hin thirty days after you become aware that the instructions are invalid, then y"
        + "ou do not forfeit any of your rights under this license.\n"
        + "\n"
        + "(6)  You may Distribute a Modified Version in Compiled form without the Source, "
        + "provided that you comply with Section 4 with respect to the Source of the Modifi"
        + "ed Version.\n"
        + "\n"
        + "\n"
        + "Aggregating or Linking the Package \n"
        + "\n"
        + "(7)  You may aggregate the Package (either the Standard Version or Modified Vers"
        + "ion) with other packages and Distribute the resulting aggregation provided that "
        + "you do not charge a licensing fee for the Package.  Distributor Fees are permitt"
        + "ed, and licensing fees for other components in the aggregation are permitted. Th"
        + "e terms of this license apply to the use and Distribution of the Standard or Mod"
        + "ified Versions as included in the aggregation.\n"
        + "\n"
        + "(8) You are permitted to link Modified and Standard Versions with other works, t"
        + "o embed the Package in a larger work of your own, or to build stand-alone binary"
        + " or bytecode versions of applications that include the Package, and Distribute t"
        + "he result without restriction, provided the result does not expose a direct inte"
        + "rface to the Package.\n"
        + "\n"
        + "\n"
        + "Items That are Not Considered Part of a Modified Version \n"
        + "\n"
        + "(9) Works (including, but not limited to, modules and scripts) that merely exten"
        + "d or make use of the Package, do not, by themselves, cause the Package to be a M"
        + "odified Version.  In addition, such works are not considered parts of the Packag"
        + "e itself, and are not subject to the terms of this license.\n"
        + "\n"
        + "\n"
        + "General Provisions\n"
        + "\n"
        + "(10)  Any use, modification, and distribution of the Standard or Modified Versio"
        + "ns is governed by this Artistic License. By using, modifying or distributing the"
        + " Package, you accept this license. Do not use, modify, or distribute the Package"
        + ", if you do not accept this license.\n"
        + "\n"
        + "(11)  If your Modified Version has been derived from a Modified Version made by "
        + "someone other than you, you are nevertheless required to ensure that your Modifi"
        + "ed Version complies with the requirements of this license.\n"
        + "\n"
        + "(12)  This license does not grant you the right to use any trademark, service ma"
        + "rk, tradename, or logo of the Copyright Holder.\n"
        + "\n"
        + "(13)  This license includes the non-exclusive, worldwide, free-of-charge patent "
        + "license to make, have made, use, offer to sell, sell, import and otherwise trans"
        + "fer the Package with respect to any patent claims licensable by the Copyright Ho"
        + "lder that are necessarily infringed by the Package. If you institute patent liti"
        + "gation (including a cross-claim or counterclaim) against any party alleging that"
        + " the Package constitutes direct or contributory patent infringement, then this A"
        + "rtistic License to you shall terminate on the date that such litigation is filed"
        + ".\n"
        + "\n"
        + "(14)  Disclaimer of Warranty:\n"
        + "THE PACKAGE IS PROVIDED BY THE COPYRIGHT HOLDER AND CONTRIBUTORS \"AS IS' AND WIT"
        + "HOUT ANY EXPRESS OR IMPLIED WARRANTIES. THE IMPLIED WARRANTIES OF MERCHANTABILIT"
        + "Y, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT ARE DISCLAIMED TO THE E"
        + "XTENT PERMITTED BY YOUR LOCAL LAW. UNLESS REQUIRED BY LAW, NO COPYRIGHT HOLDER O"
        + "R CONTRIBUTOR WILL BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, OR CONSEQUENT"
        + "IAL DAMAGES ARISING IN ANY WAY OUT OF THE USE OF THE PACKAGE, EVEN IF ADVISED OF"
        + " THE POSSIBILITY OF SUCH DAMAGE.\n"
; // the license text
    }
 
    
}
