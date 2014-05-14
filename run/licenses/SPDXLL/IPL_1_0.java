package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:44:39Z
 * LicenseName: Apache-2.0
 * FileName: IPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class IPL_1_0 extends License{
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
        return "IPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "IBM Public License v1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "IBM Public License Version 1.0\n"
        + "\n"
        + "THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS IBM\n"
        + "PUBLIC LICENSE (\"AGREEMENT\"). ANY USE, REPRODUCTION OR DISTRIBUTION\n"
        + "OF THE PROGRAM CONSTITUTES RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.\n"
        + "\n"
        + "1. DEFINITIONS\n"
        + "\"Contribution\" means:\n"
        + "\n"
        + "a.  in the case of International Business Machines Corporation (\"IBM\"), the Orig"
        + "inal Program, and\n"
        + "\n"
        + "b.  in the case of each Contributor,\n"
        + "i.  changes to the Program, and\n"
        + "ii.  additions to the Program;\n"
        + "where such changes and/or additions to the Program originate from and\n"
        + "are distributed by that particular Contributor. A Contribution\n"
        + "'originates' from a Contributor if it was added to the Program by\n"
        + "such Contributor itself or anyone acting on such Contributor's\n"
        + "behalf. Contributions do not include additions to the Program which:\n"
        + "(i) are separate modules of software distributed in conjunction with\n"
        + "the Program under their own license agreement, and (ii) are not\n"
        + "derivative works of the Program.\n"
        + "\n"
        + "\"Contributor\" means IBM and any other entity that distributes the Program.\n"
        + "\n"
        + "\"Licensed Patents \" mean patent claims licensable by a\n"
        + "Contributor which are necessarily infringed by the use or sale of its\n"
        + "Contribution alone or when combined with the Program.\n"
        + "\n"
        + "\"Original Program\" means the original version of the software\n"
        + "accompanying this Agreement as released by IBM, including source\n"
        + "code, object code and documentation, if any.\n"
        + "\n"
        + "\"Program\" means the Original Program and Contributions.\n"
        + "\n"
        + "\"Recipient\" means anyone who receives the Program under this\n"
        + "Agreement, including all Contributors.\n"
        + "\n"
        + "2. GRANT OF RIGHTS\n"
        + "a.  Subject to the terms of this Agreement, each Contributor hereby\n"
        + "grants Recipient a non-exclusive, worldwide, royalty-free copyright\n"
        + "license to reproduce, prepare derivative works of, publicly display,\n"
        + "publicly perform, distribute and sublicense the Contribution of such\n"
        + "Contributor, if any, and such derivative works, in source code and\n"
        + "object code form.\n"
        + "\n"
        + "b.  Subject to the terms of this Agreement, each Contributor hereby\n"
        + "grants Recipient a non-exclusive, worldwide, royalty-free patent\n"
        + "license under Licensed Patents to make, use, sell, offer to sell,\n"
        + "import and otherwise transfer the Contribution of such Contributor,\n"
        + "if any, in source code and object code form. This patent license\n"
        + "shall apply to the combination of the Contribution and the Program\n"
        + "if, at the time the Contribution is added by the Contributor, such\n"
        + "addition of the Contribution causes such combination to be covered by\n"
        + "the Licensed Patents. The patent license shall not apply to any\n"
        + "other combinations which include the Contribution. No hardware per\n"
        + "se is licensed hereunder.\n"
        + "\n"
        + "c.  Recipient understands that although each Contributor grants the\n"
        + "licenses to its Contributions set forth herein, no assurances are\n"
        + "provided by any Contributor that the Program does not infringe the\n"
        + "patent or other intellectual property rights of any other entity.\n"
        + "Each Contributor disclaims any liability to Recipient for claims\n"
        + "brought by any other entity based on infringement of intellectual\n"
        + "property rights or otherwise. As a condition to exercising the\n"
        + "rights and licenses granted hereunder, each Recipient hereby assumes\n"
        + "sole responsibility to secure any other intellectual property rights\n"
        + "needed, if any. For example, if a third party patent license is\n"
        + "required to allow Recipient to distribute the Program, it is\n"
        + "Recipient's responsibility to acquire that license before\n"
        + "distributing the Program.\n"
        + "\n"
        + "d.  Each Contributor represents that to its knowledge it has\n"
        + "sufficient copyright rights in its Contribution, if any, to grant the\n"
        + "copyright license set forth in this Agreement.\n"
        + "\n"
        + "3. REQUIREMENTS\n"
        + "A Contributor may choose to distribute\n"
        + "the Program in object code form under its own license agreement,\n"
        + "provided that:\n"
        + "\n"
        + "a.  it complies with the terms and conditions of this Agreement; and\n"
        + "b.  its license agreement:\n"
        + "i.  effectively disclaims on behalf of all Contributors all warranties\n"
        + "and conditions, express and implied, including warranties or\n"
        + "conditions of title and non-infringement, and implied warranties or\n"
        + "conditions of merchantability and fitness for a particular purpose;\n"
        + "ii.  effectively excludes on behalf of all Contributors all liability\n"
        + "for damages, including direct, indirect, special, incidental and\n"
        + "consequential damages, such as lost profits;\n"
        + "iii.  states that any provisions which differ from this Agreement are\n"
        + "offered by that Contributor alone and not by any other party; and\n"
        + "iv.  states that source code for the Program is available from such\n"
        + "Contributor, and informs licensees how to obtain it in a reasonable\n"
        + "manner on or through a medium customarily used for software exchange.\n"
        + "\n"
        + "When the Program is made available in source code form:\n"
        + "a.  it must be made available under this Agreement; and\n"
        + "b.  a copy of this Agreement must be included with each copy of the\n"
        + "Program.\n"
        + "\n"
        + "Each Contributor must include the following in a conspicuous location in the Pro"
        + "gram:\n"
        + "\n"
        + "Copyright (C) 1996, 1999 International Business Machines Corporation and others"
        + ". All Rights Reserved.\n"
        + "\n"
        + "In addition, each Contributor must identify itself as the originator\n"
        + "of its Contribution, if any, in a manner that reasonably allows\n"
        + "subsequent Recipients to identify the originator of the Contribution.\n"
        + "\n"
        + "4. COMMERCIAL DISTRIBUTION\n"
        + "Commercial distributors of software may accept certain\n"
        + "responsibilities with respect to end users, business partners and the\n"
        + "like. While this license is intended to facilitate the commercial\n"
        + "use of the Program, the Contributor who includes the Program in a\n"
        + "commercial product offering should do so in a manner which does not\n"
        + "create potential liability for other Contributors. Therefore, if a\n"
        + "Contributor includes the Program in a commercial product offering,\n"
        + "such Contributor (\"Commercial Contributor\") hereby agrees to defend\n"
        + "and indemnify every other Contributor (\"Indemnified Contributor\")\n"
        + "against any losses, damages and costs (collectively \"Losses\") arising\n"
        + "from claims, lawsuits and other legal actions brought by a third\n"
        + "party against the Indemnified Contributor to the extent caused by the\n"
        + "acts or omissions of such Commercial Contributor in connection with\n"
        + "its distribution of the Program in a commercial product offering.\n"
        + "The obligations in this section do not apply to any claims or Losses\n"
        + "relating to any actual or alleged intellectual property infringement.\n"
        + "In order to qualify, an Indemnified Contributor must: a) promptly\n"
        + "notify the Commercial Contributor in writing of such claim, and b)\n"
        + "allow the Commercial Contributor to control, and cooperate with the\n"
        + "Commercial Contributor in, the defense and any related settlement\n"
        + "negotiations. The Indemnified Contributor may participate in any\n"
        + "such claim at its own expense.\n"
        + "\n"
        + "For example, a Contributor might include the Program in a commercial\n"
        + "product offering, Product X. That Contributor is then a Commercial\n"
        + "Contributor. If that Commercial Contributor then makes performance\n"
        + "claims, or offers warranties related to Product X, those performance\n"
        + "claims and warranties are such Commercial Contributor's\n"
        + "responsibility alone. Under this section, the Commercial Contributor\n"
        + "would have to defend claims against the other Contributors related to\n"
        + "those performance claims and warranties, and if a court requires any\n"
        + "other Contributor to pay any damages as a result, the Commercial\n"
        + "Contributor must pay those damages.\n"
        + "\n"
        + "5. NO WARRANTY\n"
        + "EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, THE PROGRAM IS\n"
        + "PROVIDED ON AN \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY\n"
        + "KIND, EITHER EXPRESS OR IMPLIED INCLUDING, WITHOUT LIMITATION, ANY\n"
        + "WARRANTIES OR CONDITIONS OF TITLE, NON-INFRINGEMENT, MERCHANTABILITY\n"
        + "OR FITNESS FOR A PARTICULAR PURPOSE. Each Recipient is solely\n"
        + "responsible for determining the appropriateness of using and\n"
        + "distributing the Program and assumes all risks associated with its\n"
        + "exercise of rights under this Agreement, including but not limited to\n"
        + "the risks and costs of program errors, compliance with applicable\n"
        + "laws, damage to or loss of data, programs or equipment, and\n"
        + "unavailability or interruption of operations.\n"
        + "\n"
        + "6. DISCLAIMER OF LIABILITY\n"
        + "EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, NEITHER RECIPIENT\n"
        + "NOR ANY CONTRIBUTORS SHALL HAVE ANY LIABILITY FOR ANY DIRECT,\n"
        + "INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES\n"
        + "(INCLUDING WITHOUT LIMITATION LOST PROFITS), HOWEVER CAUSED AND ON\n"
        + "ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR\n"
        + "TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF\n"
        + "THE USE OR DISTRIBUTION OF THE PROGRAM OR THE EXERCISE OF ANY RIGHTS\n"
        + "GRANTED HEREUNDER, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "7. GENERAL\n"
        + "If any provision of this Agreement is invalid or unenforceable under\n"
        + "applicable law, it shall not affect the validity or enforceability of\n"
        + "the remainder of the terms of this Agreement, and without further\n"
        + "action by the parties hereto, such provision shall be reformed to the\n"
        + "minimum extent necessary to make such provision valid and enforceable.\n"
        + "\n"
        + "If Recipient institutes patent litigation against a Contributor with\n"
        + "respect to a patent applicable to software (including a cross-claim\n"
        + "or counterclaim in a lawsuit), then any patent licenses granted by\n"
        + "that Contributor to such Recipient under this Agreement shall\n"
        + "terminate as of the date such litigation is filed. In addition, if\n"
        + "Recipient institutes patent litigation against any entity (including\n"
        + "a cross-claim or counterclaim in a lawsuit) alleging that the Program\n"
        + "itself (excluding combinations of the Program with other software or\n"
        + "hardware) infringes such Recipient's patent(s), then such Recipient's\n"
        + "rights granted under Section 2(b) shall terminate as of the date such\n"
        + "litigation is filed.\n"
        + "\n"
        + "All Recipient's rights under this Agreement shall terminate if it\n"
        + "fails to comply with any of the material terms or conditions of this\n"
        + "Agreement and does not cure such failure in a reasonable period of\n"
        + "time after becoming aware of such noncompliance. If all Recipient's\n"
        + "rights under this Agreement terminate, Recipient agrees to cease use\n"
        + "and distribution of the Program as soon as reasonably practicable.\n"
        + "However, Recipient's obligations under this Agreement and any\n"
        + "licenses granted by Recipient relating to the Program shall continue\n"
        + "and survive.\n"
        + "\n"
        + "IBM may publish new versions (including revisions) of this Agreement\n"
        + "from time to time. Each new version of the Agreement will be given a\n"
        + "distinguishing version number. The Program (including Contributions)\n"
        + "may always be distributed subject to the version of the Agreement\n"
        + "under which it was received. In addition, after a new version of the\n"
        + "Agreement is published, Contributor may elect to distribute the\n"
        + "Program (including its Contributions) under the new version. No one\n"
        + "other than IBM has the right to modify this Agreement. Except as\n"
        + "expressly stated in Sections 2(a) and 2(b) above, Recipient receives\n"
        + "no rights or licenses to the intellectual property of any Contributor\n"
        + "under this Agreement, whether expressly, by implication, estoppel or\n"
        + "otherwise. All rights in the Program not expressly granted under\n"
        + "this Agreement are reserved.\n"
        + "\n"
        + "This Agreement is governed by the laws of the State of New York and\n"
        + "the intellectual property laws of the United States of America. No\n"
        + "party to this Agreement will bring a legal action under this\n"
        + "Agreement more than one year after the cause of action arose. Each\n"
        + "party waives its rights to a jury trial in any resulting litigation.\n"
; // the license text
    }
 
    
}
