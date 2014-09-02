package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:05Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class LPL_1_0 extends License{
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
        return "LPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Lucent Public License Version 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Lucent Public License Version 1.0\n"
        + "\n"
        + "THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS PUBLIC LICENSE (\"AG"
        + "REEMENT\"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THE PROGRAM CONSTITUTES RECI"
        + "PIENT'S ACCEPTANCE OF THIS AGREEMENT.\n"
        + "\n"
        + "1. DEFINITIONS\n"
        + "\n"
        + "\"Contribution\" means:\n"
        + "\n"
        + "a.  in the case of <ORGANIZATION> (\"<OWNER>\"), the Original Program, and\n"
        + "b.  in the case of each Contributor,\n"
        + "i.  changes to the Program, and\n"
        + "ii.  additions to the Program; where such changes and/or additions to the Prog"
        + "ram originate from and are \"Contributed\" by that particular Contributor.\n"
        + "\n"
        + "A Contribution is \"Contributed\" by a Contributor only (i) if it was added to the"
        + " Program by such Contributor itself or anyone acting on such Contributor's behal"
        + "f, and (ii) the Contributor explicitly consents, in accordance with Section 3C, "
        + "to characterization of the changes and/or additions as Contributions. Contributi"
        + "ons do not include additions to the Program which: (i) are separate modules of s"
        + "oftware distributed in conjunction with the Program under their own license agre"
        + "ement, and (ii) are not derivative works of the Program.\n"
        + "\n"
        + "\"Contributor\" means <OWNER> and any other entity that has Contributed a Contribu"
        + "tion to the Program.\n"
        + "\n"
        + "\"Distributor\" means a Recipient that distributes the Program, modifications to t"
        + "he Program, or any part thereof.\n"
        + "\n"
        + "\"Licensed Patents\" mean patent claims licensable by a Contributor which are nece"
        + "ssarily infringed by the use or sale of its Contribution alone or when combined "
        + "with the Program.\n"
        + "\n"
        + "\"Original Program\" means the original version of the software accompanying this "
        + "Agreement as released by <OWNER>, including source code, object code and documen"
        + "tation, if any.\n"
        + "\n"
        + "\"Program\" means the Original Program and Contributions or any part thereof\n"
        + "\n"
        + "\"Recipient\" means anyone who receives the Program under this Agreement, includin"
        + "g all Contributors.\n"
        + "\n"
        + "2. GRANT OF RIGHTS\n"
        + "\n"
        + "a.  Subject to the terms of this Agreement, each Contributor hereby grants Recip"
        + "ient a non-exclusive, worldwide, royalty-free copyright license to reproduce, pr"
        + "epare derivative works of, publicly display, publicly perform, distribute and su"
        + "blicense the Contribution of such Contributor, if any, and such derivative works"
        + ", in source code and object code form.\n"
        + "\n"
        + "b.  Subject to the terms of this Agreement, each Contributor hereby grants Recip"
        + "ient a non-exclusive, worldwide, royalty-free patent license under Licensed Pate"
        + "nts to make, use, sell, offer to sell, import and otherwise transfer the Contrib"
        + "ution of such Contributor, if any, in source code and object code form. The pate"
        + "nt license granted by a Contributor shall also apply to the combination of the C"
        + "ontribution of that Contributor and the Program if, at the time the Contribution"
        + " is added by the Contributor, such addition of the Contribution causes such comb"
        + "ination to be covered by the Licensed Patents. The patent license granted by a C"
        + "ontributor shall not apply to (i) any other combinations which include the Contr"
        + "ibution, nor to (ii) Contributions of other Contributors. No hardware per se is "
        + "licensed hereunder.\n"
        + "\n"
        + "c.  Recipient understands that although each Contributor grants the licenses to "
        + "its Contributions set forth herein, no assurances are provided by any Contributo"
        + "r that the Program does not infringe the patent or other intellectual property r"
        + "ights of any other entity. Each Contributor disclaims any liability to Recipient"
        + " for claims brought by any other entity based on infringement of intellectual pr"
        + "operty rights or otherwise. As a condition to exercising the rights and licenses"
        + " granted hereunder, each Recipient hereby assumes sole responsibility to secure "
        + "any other intellectual property rights needed, if any. For example, if a third p"
        + "arty patent license is required to allow Recipient to distribute the Program, it"
        + " is Recipient's responsibility to acquire that license before distributing the P"
        + "rogram.\n"
        + "\n"
        + "d.  Each Contributor represents that to its knowledge it has sufficient copyrigh"
        + "t rights in its Contribution, if any, to grant the copyright license set forth i"
        + "n this Agreement.\n"
        + "\n"
        + "3. REQUIREMENTS\n"
        + "\n"
        + "A. Distributor may choose to distribute the Program in any form under this Agree"
        + "ment or under its own license agreement, provided that:\n"
        + "\n"
        + "a.  it complies with the terms and conditions of this Agreement;\n"
        + "b.  if the Program is distributed in source code or other tangible form, a copy"
        + " of this Agreement or Distributor's own license agreement is included with each "
        + "copy of the Program; and\n"
        + "c.  if distributed under Distributor's own license agreement, such license agre"
        + "ement:\n"
        + "i.  effectively disclaims on behalf of all Contributors all warranties and con"
        + "ditions, express and implied, including warranties or conditions of title and no"
        + "n-infringement, and implied warranties or conditions of merchantability and fitn"
        + "ess for a particular purpose;\n"
        + "ii.  effectively excludes on behalf of all Contributors all liability for dama"
        + "ges, including direct, indirect, special, incidental and consequential damages, "
        + "such as lost profits; and\n"
        + "iii.  states that any provisions which differ from this Agreement are offered "
        + "by that Contributor alone and not by any other party.\n"
        + "\n"
        + "B. Each Distributor must include the following in a conspicuous location in the "
        + "Program:\n"
        + "\n"
        + "Copyright (C) <YEAR>, <ORGANIZATION> and others. All Rights Reserved.\n"
        + "\n"
        + "C. In addition, each Contributor must identify itself as the originator of its C"
        + "ontribution, if any, and indicate its consent to characterization of its additio"
        + "ns and/or changes as a Contribution, in a manner that reasonably allows subseque"
        + "nt Recipients to identify the originator of the Contribution. Once consent is gr"
        + "anted, it may not thereafter be revoked.\n"
        + "\n"
        + "4. COMMERCIAL DISTRIBUTION\n"
        + "\n"
        + "Commercial distributors of software may accept certain responsibilities with res"
        + "pect to end users, business partners and the like. While this license is intende"
        + "d to facilitate the commercial use of the Program, the Distributor who includes "
        + "the Program in a commercial product offering should do so in a manner which does"
        + " not create potential liability for Contributors. Therefore, if a Distributor in"
        + "cludes the Program in a commercial product offering, such Distributor (\"Commerci"
        + "al Distributor\") hereby agrees to defend and indemnify every Contributor (\"Indem"
        + "nified Contributor\") against any losses, damages and costs (collectively \"Losses"
        + "\") arising from claims, lawsuits and other legal actions brought by a third part"
        + "y against the Indemnified Contributor to the extent caused by the acts or omissi"
        + "ons of such Commercial Distributor in connection with its distribution of the Pr"
        + "ogram in a commercial product offering. The obligations in this section do not a"
        + "pply to any claims or Losses relating to any actual or alleged intellectual prop"
        + "erty infringement. In order to qualify, an Indemnified Contributor must: a) prom"
        + "ptly notify the Commercial Distributor in writing of such claim, and b) allow th"
        + "e Commercial Distributor to control, and cooperate with the Commercial Distribut"
        + "or in, the defense and any related settlement negotiations. The Indemnified Cont"
        + "ributor may participate in any such claim at its own expense.\n"
        + "\n"
        + "For example, a Distributor might include the Program in a commercial product off"
        + "ering, Product X. That Distributor is then a Commercial Distributor. If that Com"
        + "mercial Distributor then makes performance claims, or offers warranties related "
        + "to Product X, those performance claims and warranties are such Commercial Distri"
        + "butor's responsibility alone. Under this section, the Commercial Distributor wou"
        + "ld have to defend claims against the Contributors related to those performance c"
        + "laims and warranties, and if a court requires any Contributor to pay any damages"
        + " as a result, the Commercial Distributor must pay those damages.\n"
        + "\n"
        + "5. NO WARRANTY\n"
        + "\n"
        + "EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, THE PROGRAM IS PROVIDED ON AN \""
        + "AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, EITHER EXPRESS OR IM"
        + "PLIED INCLUDING, WITHOUT LIMITATION, ANY WARRANTIES OR CONDITIONS OF TITLE, NON-"
        + "INFRINGEMENT, MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Each Recipien"
        + "t is solely responsible for determining the appropriateness of using and distrib"
        + "uting the Program and assumes all risks associated with its exercise of rights u"
        + "nder this Agreement, including but not limited to the risks and costs of program"
        + " errors, compliance with applicable laws, damage to or loss of data, programs or"
        + " equipment, and unavailability or interruption of operations.\n"
        + "\n"
        + "6. DISCLAIMER OF LIABILITY\n"
        + "\n"
        + "EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, NEITHER RECIPIENT NOR ANY CONTR"
        + "IBUTORS SHALL HAVE ANY LIABILITY FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, "
        + "EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING WITHOUT LIMITATION LOST PROFITS),"
        + " HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIAB"
        + "ILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE"
        + " USE OR DISTRIBUTION OF THE PROGRAM OR THE EXERCISE OF ANY RIGHTS GRANTED HEREUN"
        + "DER, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "7. GENERAL\n"
        + "\n"
        + "If any provision of this Agreement is invalid or unenforceable under applicable "
        + "law, it shall not affect the validity or enforceability of the remainder of the "
        + "terms of this Agreement, and without further action by the parties hereto, such "
        + "provision shall be reformed to the minimum extent necessary to make such provisi"
        + "on valid and enforceable.\n"
        + "\n"
        + "If Recipient institutes patent litigation against a Contributor with respect to "
        + "a patent applicable to software (including a cross-claim or counterclaim in a la"
        + "wsuit), then any patent licenses granted by that Contributor to such Recipient u"
        + "nder this Agreement shall terminate as of the date such litigation is filed. In "
        + "addition, if Recipient institutes patent litigation against any entity (includin"
        + "g a cross-claim or counterclaim in a lawsuit) alleging that the Program itself ("
        + "excluding combinations of the Program with other software or hardware) infringes"
        + " such Recipient's patent(s), then such Recipient's rights granted under Section "
        + "2(b) shall terminate as of the date such litigation is filed.\n"
        + "\n"
        + "All Recipient's rights under this Agreement shall terminate if it fails to compl"
        + "y with any of the material terms or conditions of this Agreement and does not cu"
        + "re such failure in a reasonable period of time after becoming aware of such nonc"
        + "ompliance. If all Recipient's rights under this Agreement terminate, Recipient a"
        + "grees to cease use and distribution of the Program as soon as reasonably practic"
        + "able. However, Recipient's obligations under this Agreement and any licenses gra"
        + "nted by Recipient relating to the Program shall continue and survive.\n"
        + "\n"
        + "<OWNER> may publish new versions (including revisions) of this Agreement from ti"
        + "me to time. Each new version of the Agreement will be given a distinguishing ver"
        + "sion number. The Program (including Contributions) may always be distributed sub"
        + "ject to the version of the Agreement under which it was received. In addition, a"
        + "fter a new version of the Agreement is published, Contributor may elect to distr"
        + "ibute the Program (including its Contributions) under the new version. No one ot"
        + "her than <OWNER> has the right to modify this Agreement. Except as expressly sta"
        + "ted in Sections 2(a) and 2(b) above, Recipient receives no rights or licenses to"
        + " the intellectual property of any Contributor under this Agreement, whether expr"
        + "essly, by implication, estoppel or otherwise. All rights in the Program not expr"
        + "essly granted under this Agreement are reserved.\n"
        + "\n"
        + "This Agreement is governed by the laws of the State of <STATE> and the intellect"
        + "ual property laws of the United States of America. No party to this Agreement wi"
        + "ll bring a legal action under this Agreement more than one year after the cause "
        + "of action arose. Each party waives its rights to a jury trial in any resulting l"
        + "itigation.\n"
; // the license text
    }
 
    
}
