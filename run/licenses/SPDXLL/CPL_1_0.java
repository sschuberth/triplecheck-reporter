package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:43:59Z
 * LicenseName: Apache-2.0
 * FileName: CPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class CPL_1_0 extends License{
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
        return "CPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Common Public License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Common Public License Version 1.0\n"
        + "\n"
        + "THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS COMMON PUBLIC\n"
        + "LICENSE (\"AGREEMENT\"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THE PROGRAM\n"
        + "CONSTITUTES RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.\n"
        + "\n"
        + "1. DEFINITIONS\n"
        + "\n"
        + "\"Contribution\" means:\n"
        + "\n"
        + " a) in the case of the initial Contributor, the initial code and\n"
        + " documentation distributed under this Agreement, and\n"
        + "\n"
        + " b) in the case of each subsequent Contributor:\n"
        + "\n"
        + "   i) changes to the Program, and\n"
        + "\n"
        + "   ii) additions to the Program;\n"
        + "\n"
        + "   where such changes and/or additions to the Program originate from and are\n"
        + "   distributed by that particular Contributor. A Contribution 'originates' from "
        + "a\n"
        + "   Contributor if it was added to the Program by such Contributor itself or anyo"
        + "ne\n"
        + "   acting on such Contributor's behalf. Contributions do not include additions t"
        + "o\n"
        + "   the Program which: (i) are separate modules of software distributed in\n"
        + "   conjunction with the Program under their own license agreement, and (ii) are "
        + "not\n"
        + "   derivative works of the Program.\n"
        + "\n"
        + "\"Contributor\" means any person or entity that distributes the Program.\n"
        + "\n"
        + "\"Licensed Patents \" mean patent claims licensable by a Contributor which are\n"
        + "necessarily infringed by the use or sale of its Contribution alone or when\n"
        + "combined with the Program.\n"
        + "\n"
        + "\"Program\" means the Contributions distributed in accordance with this Agreement.\n"
        + "\n"
        + "\"Recipient\" means anyone who receives the Program under this Agreement,\n"
        + "including all Contributors.\n"
        + "\n"
        + "2. GRANT OF RIGHTS\n"
        + "\n"
        + "a) Subject to the terms of this Agreement, each Contributor hereby grants\n"
        + "Recipient a non-exclusive, worldwide, royalty-free copyright license to\n"
        + "reproduce, prepare derivative works of, publicly display, publicly perform,\n"
        + "distribute and sublicense the Contribution of such Contributor, if any, and such\n"
        + "derivative works, in source code and object code form.\n"
        + "\n"
        + "b) Subject to the terms of this Agreement, each Contributor hereby grants\n"
        + "Recipient a non-exclusive, worldwide, royalty-free patent license under Licensed\n"
        + "Patents to make, use, sell, offer to sell, import and otherwise transfer the\n"
        + "Contribution of such Contributor, if any, in source code and object code form.\n"
        + "This patent license shall apply to the combination of the Contribution and the\n"
        + "Program if, at the time the Contribution is added by the Contributor, such\n"
        + "addition of the Contribution causes such combination to be covered by the\n"
        + "Licensed Patents. The patent license shall not apply to any other combinations\n"
        + "which include the Contribution. No hardware per se is licensed hereunder.\n"
        + "\n"
        + "c) Recipient understands that although each Contributor grants the licenses\n"
        + "to its Contributions set forth herein, no assurances are provided by any\n"
        + "Contributor that the Program does not infringe the patent or other intellectual\n"
        + "property rights of any other entity. Each Contributor disclaims any liability to\n"
        + "Recipient for claims brought by any other entity based on infringement of\n"
        + "intellectual property rights or otherwise. As a condition to exercising the\n"
        + "rights and licenses granted hereunder, each Recipient hereby assumes sole\n"
        + "responsibility to secure any other intellectual property rights needed, if any.\n"
        + "For example, if a third party patent license is required to allow Recipient to\n"
        + "distribute the Program, it is Recipient's responsibility to acquire that license\n"
        + "before distributing the Program.\n"
        + "\n"
        + "d) Each Contributor represents that to its knowledge it has sufficient\n"
        + "copyright rights in its Contribution, if any, to grant the copyright license set\n"
        + "forth in this Agreement.\n"
        + "\n"
        + "3. REQUIREMENTS\n"
        + "\n"
        + "A Contributor may choose to distribute the Program in object code form under its\n"
        + "own license agreement, provided that:\n"
        + "\n"
        + "a) it complies with the terms and conditions of this Agreement; and\n"
        + "\n"
        + "b) its license agreement:\n"
        + "\n"
        + "i) effectively disclaims on behalf of all Contributors all warranties and\n"
        + "conditions, express and implied, including warranties or conditions of title and\n"
        + "non-infringement, and implied warranties or conditions of merchantability and\n"
        + "fitness for a particular purpose;\n"
        + "\n"
        + "ii) effectively excludes on behalf of all Contributors all liability for\n"
        + "damages, including direct, indirect, special, incidental and consequential\n"
        + "damages, such as lost profits;\n"
        + "\n"
        + "iii) states that any provisions which differ from this Agreement are offered\n"
        + "by that Contributor alone and not by any other party; and\n"
        + "\n"
        + "iv) states that source code for the Program is available from such\n"
        + "Contributor, and informs licensees how to obtain it in a reasonable manner on or\n"
        + "through a medium customarily used for software exchange.\n"
        + "\n"
        + "When the Program is made available in source code form:\n"
        + "\n"
        + "a) it must be made available under this Agreement; and\n"
        + "\n"
        + "b) a copy of this Agreement must be included with each copy of the Program.\n"
        + "\n"
        + "Contributors may not remove or alter any copyright notices contained within the\n"
        + "Program.\n"
        + "\n"
        + "Each Contributor must identify itself as the originator of its Contribution, if\n"
        + "any, in a manner that reasonably allows subsequent Recipients to identify the\n"
        + "originator of the Contribution.\n"
        + "\n"
        + "4. COMMERCIAL DISTRIBUTION\n"
        + "\n"
        + "Commercial distributors of software may accept certain responsibilities with\n"
        + "respect to end users, business partners and the like. While this license is\n"
        + "intended to facilitate the commercial use of the Program, the Contributor who\n"
        + "includes the Program in a commercial product offering should do so in a manner\n"
        + "which does not create potential liability for other Contributors. Therefore, if\n"
        + "a Contributor includes the Program in a commercial product offering, such\n"
        + "Contributor (\"Commercial Contributor\") hereby agrees to defend and indemnify\n"
        + "every other Contributor (\"Indemnified Contributor\") against any losses, damages\n"
        + "and costs (collectively \"Losses\") arising from claims, lawsuits and other legal\n"
        + "actions brought by a third party against the Indemnified Contributor to the\n"
        + "extent caused by the acts or omissions of such Commercial Contributor in\n"
        + "connection with its distribution of the Program in a commercial product\n"
        + "offering. The obligations in this section do not apply to any claims or Losses\n"
        + "relating to any actual or alleged intellectual property infringement. In order\n"
        + "to qualify, an Indemnified Contributor must: a) promptly notify the Commercial\n"
        + "Contributor in writing of such claim, and b) allow the Commercial Contributor to\n"
        + "control, and cooperate with the Commercial Contributor in, the defense and any\n"
        + "related settlement negotiations. The Indemnified Contributor may participate in\n"
        + "any such claim at its own expense.\n"
        + "\n"
        + "For example, a Contributor might include the Program in a commercial product\n"
        + "offering, Product X. That Contributor is then a Commercial Contributor. If that\n"
        + "Commercial Contributor then makes performance claims, or offers warranties\n"
        + "related to Product X, those performance claims and warranties are such\n"
        + "Commercial Contributor's responsibility alone. Under this section, the\n"
        + "Commercial Contributor would have to defend claims against the other\n"
        + "Contributors related to those performance claims and warranties, and if a court\n"
        + "requires any other Contributor to pay any damages as a result, the Commercial\n"
        + "Contributor must pay those damages.\n"
        + "\n"
        + "5. NO WARRANTY\n"
        + "\n"
        + "EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, THE PROGRAM IS PROVIDED ON AN\n"
        + "\"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, EITHER EXPRESS OR\n"
        + "IMPLIED INCLUDING, WITHOUT LIMITATION, ANY WARRANTIES OR CONDITIONS OF TITLE,\n"
        + "NON-INFRINGEMENT, MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Each\n"
        + "Recipient is solely responsible for determining the appropriateness of using and\n"
        + "distributing the Program and assumes all risks associated with its exercise of\n"
        + "rights under this Agreement, including but not limited to the risks and costs of\n"
        + "program errors, compliance with applicable laws, damage to or loss of data,\n"
        + "programs or equipment, and unavailability or interruption of operations.\n"
        + "\n"
        + "6. DISCLAIMER OF LIABILITY\n"
        + "\n"
        + "EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, NEITHER RECIPIENT NOR ANY\n"
        + "CONTRIBUTORS SHALL HAVE ANY LIABILITY FOR ANY DIRECT, INDIRECT, INCIDENTAL,\n"
        + "SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING WITHOUT LIMITATION LOST\n"
        + "PROFITS), HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,\n"
        + "STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY\n"
        + "OUT OF THE USE OR DISTRIBUTION OF THE PROGRAM OR THE EXERCISE OF ANY RIGHTS\n"
        + "GRANTED HEREUNDER, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "7. GENERAL\n"
        + "\n"
        + "If any provision of this Agreement is invalid or unenforceable under applicable\n"
        + "law, it shall not affect the validity or enforceability of the remainder of the\n"
        + "terms of this Agreement, and without further action by the parties hereto, such\n"
        + "provision shall be reformed to the minimum extent necessary to make such\n"
        + "provision valid and enforceable.\n"
        + "\n"
        + "If Recipient institutes patent litigation against a Contributor with respect to\n"
        + "a patent applicable to software (including a cross-claim or counterclaim in a\n"
        + "lawsuit), then any patent licenses granted by that Contributor to such Recipient\n"
        + "under this Agreement shall terminate as of the date such litigation is filed. In\n"
        + "addition, if Recipient institutes patent litigation against any entity\n"
        + "(including a cross-claim or counterclaim in a lawsuit) alleging that the Program\n"
        + "itself (excluding combinations of the Program with other software or hardware)\n"
        + "infringes such Recipient's patent(s), then such Recipient's rights granted under\n"
        + "Section 2(b) shall terminate as of the date such litigation is filed.\n"
        + "\n"
        + "All Recipient's rights under this Agreement shall terminate if it fails to\n"
        + "comply with any of the material terms or conditions of this Agreement and does\n"
        + "not cure such failure in a reasonable period of time after becoming aware of\n"
        + "such noncompliance. If all Recipient's rights under this Agreement terminate,\n"
        + "Recipient agrees to cease use and distribution of the Program as soon as\n"
        + "reasonably practicable. However, Recipient's obligations under this Agreement\n"
        + "and any licenses granted by Recipient relating to the Program shall continue and\n"
        + "survive.\n"
        + "\n"
        + "Everyone is permitted to copy and distribute copies of this Agreement, but in\n"
        + "order to avoid inconsistency the Agreement is copyrighted and may only be\n"
        + "modified in the following manner. The Agreement Steward reserves the right to\n"
        + "publish new versions (including revisions) of this Agreement from time to time.\n"
        + "No one other than the Agreement Steward has the right to modify this Agreement.\n"
        + "IBM is the initial Agreement Steward. IBM may assign the responsibility to serve\n"
        + "as the Agreement Steward to a suitable separate entity. Each new version of the\n"
        + "Agreement will be given a distinguishing version number. The Program (including\n"
        + "Contributions) may always be distributed subject to the version of the Agreement\n"
        + "under which it was received. In addition, after a new version of the Agreement\n"
        + "is published, Contributor may elect to distribute the Program (including its\n"
        + "Contributions) under the new version. Except as expressly stated in Sections\n"
        + "2(a) and 2(b) above, Recipient receives no rights or licenses to the\n"
        + "intellectual property of any Contributor under this Agreement, whether\n"
        + "expressly, by implication, estoppel or otherwise. All rights in the Program not\n"
        + "expressly granted under this Agreement are reserved.\n"
        + "\n"
        + "This Agreement is governed by the laws of the State of New York and the\n"
        + "intellectual property laws of the United States of America. No party to this\n"
        + "Agreement will bring a legal action under this Agreement more than one year\n"
        + "after the cause of action arose. Each party waives its rights to a jury trial in\n"
        + "any resulting litigation.\n"
; // the license text
    }
 
    
}
