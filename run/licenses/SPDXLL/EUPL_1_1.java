package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:44:22Z
 * LicenseName: Apache-2.0
 * FileName: EUPL_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class EUPL_1_1 extends License{
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
        return "EUPL-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "European Union Public License 1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "European Union Public Licence\n"
        + "V. 1.1\n"
        + "\n"
        + "EUPL (c) the European Community 2007\n"
        + "\n"
        + "This European Union Public Licence (the \"EUPL\") applies to the Work or Software\n"
        + "(as defined below) which is provided under the terms of this Licence. Any use of"
        + " the\n"
        + "Work, other than as authorised under this Licence is prohibited (to the extent s"
        + "uch use\n"
        + "is covered by a right of the copyright holder of the Work).\n"
        + "\n"
        + "The Original Work is provided under the terms of this Licence when the Licensor "
        + "(as\n"
        + "defined below) has placed the following notice immediately following the copyrig"
        + "ht\n"
        + "notice for the Original Work:\n"
        + "Licensed under the EUPL V.1.1\n"
        + "or has expressed by any other mean his willingness to license under the EUPL.\n"
        + "\n"
        + "1. Definitions\n"
        + "\n"
        + "In this Licence, the following terms have the following meaning:\n"
        + "\n"
        + "- The Licence: this Licence.\n"
        + "\n"
        + "- The Original Work or the Software: the software distributed and/or communicate"
        + "d\n"
        + "by the Licensor under this Licence, available as Source Code and also as Executa"
        + "ble\n"
        + "Code as the case may be.\n"
        + "\n"
        + "- Derivative Works: the works or software that could be created by the Licensee,\n"
        + "based upon the Original Work or modifications thereof. This Licence does not def"
        + "ine\n"
        + "the extent of modification or dependence on the Original Work required in order "
        + "to\n"
        + "classify a work as a Derivative Work; this extent is determined by copyright law\n"
        + "applicable in the country mentioned in Article 15.\n"
        + "\n"
        + "- The Work: the Original Work and/or its Derivative Works.\n"
        + "\n"
        + "- The Source Code: the human-readable form of the Work which is the most\n"
        + "convenient for people to study and modify.\n"
        + "\n"
        + "- The Executable Code: any code which has generally been compiled and which is\n"
        + "meant to be interpreted by a computer as a program.\n"
        + "\n"
        + "- The Licensor: the natural or legal person that distributes and/or communicates"
        + " the\n"
        + "Work under the Licence.\n"
        + "\n"
        + "- Contributor(s): any natural or legal person who modifies the Work under the\n"
        + "Licence, or otherwise contributes to the creation of a Derivative Work.\n"
        + "\n"
        + "- The Licensee or \"You\": any natural or legal person who makes any usage of the\n"
        + "Software under the terms of the Licence.\n"
        + "\n"
        + "- Distribution and/or Communication: any act of selling, giving, lending, rentin"
        + "g,\n"
        + "distributing, communicating, transmitting, or otherwise making available, on-lin"
        + "e or\n"
        + "off-line, copies of the Work or providing access to its essential functionalitie"
        + "s at the\n"
        + "disposal of any other natural or legal person.\n"
        + "\n"
        + "2. Scope of the rights granted by the Licence\n"
        + "\n"
        + "The Licensor hereby grants You a world-wide, royalty-free, non-exclusive, sublic"
        + "ensable\n"
        + "licence to do the following, for the duration of copyright vested in the\n"
        + "Original Work:\n"
        + "\n"
        + "- use the Work in any circumstance and for all usage,\n"
        + "- reproduce the Work,\n"
        + "- modify the Original Work, and make Derivative Works based upon the Work,\n"
        + "- communicate to the public, including the right to make available or display th"
        + "e\n"
        + "Work or copies thereof to the public and perform publicly, as the case may be,\n"
        + "the Work,\n"
        + "- distribute the Work or copies thereof,\n"
        + "- lend and rent the Work or copies thereof,\n"
        + "- sub-license rights in the Work or copies thereof.\n"
        + "\n"
        + "Those rights can be exercised on any media, supports and formats, whether now\n"
        + "known or later invented, as far as the applicable law permits so.\n"
        + "\n"
        + "In the countries where moral rights apply, the Licensor waives his right to exer"
        + "cise his\n"
        + "moral right to the extent allowed by law in order to make effective the licence "
        + "of the\n"
        + "economic rights here above listed.\n"
        + "\n"
        + "The Licensor grants to the Licensee royalty-free, non exclusive usage rights to "
        + "any\n"
        + "patents held by the Licensor, to the extent necessary to make use of the rights "
        + "granted\n"
        + "on the Work under this Licence.\n"
        + "\n"
        + "3. Communication of the Source Code\n"
        + "\n"
        + "The Licensor may provide the Work either in its Source Code form, or as Executab"
        + "le\n"
        + "Code. If the Work is provided as Executable Code, the Licensor provides in addit"
        + "ion a\n"
        + "machine-readable copy of the Source Code of the Work along with each copy of the\n"
        + "Work that the Licensor distributes or indicates, in a notice following the copyr"
        + "ight\n"
        + "notice attached to the Work, a repository where the Source Code is easily and fr"
        + "eely\n"
        + "accessible for as long as the Licensor continues to distribute and/or communicat"
        + "e the\n"
        + "Work.\n"
        + "\n"
        + "4. Limitations on copyright\n"
        + "\n"
        + "Nothing in this Licence is intended to deprive the Licensee of the benefits from"
        + " any\n"
        + "exception or limitation to the exclusive rights of the rights owners in the Orig"
        + "inal\n"
        + "Work or Software, of the exhaustion of those rights or of other applicable limit"
        + "ations\n"
        + "thereto.\n"
        + "\n"
        + "5. Obligations of the Licensee\n"
        + "\n"
        + "The grant of the rights mentioned above is subject to some restrictions and obli"
        + "gations\n"
        + "imposed on the Licensee. Those obligations are the following:\n"
        + "\n"
        + "Attribution right: the Licensee shall keep intact all copyright, patent or trade"
        + "marks\n"
        + "notices and all notices that refer to the Licence and to the disclaimer of warra"
        + "nties.\n"
        + "The Licensee must include a copy of such notices and a copy of the Licence with\n"
        + "every copy of the Work he/she distributes and/or communicates. The Licensee must\n"
        + "cause any Derivative Work to carry prominent notices stating that the Work has b"
        + "een\n"
        + "modified and the date of modification.\n"
        + "\n"
        + "Copyleft clause: If the Licensee distributes and/or communicates copies of the\n"
        + "Original Works or Derivative Works based upon the Original Work, this Distributi"
        + "on\n"
        + "and/or Communication will be done under the terms of this Licence or of a later\n"
        + "version of this Licence unless the Original Work is expressly distributed only u"
        + "nder\n"
        + "this version of the Licence. The Licensee (becoming Licensor) cannot offer or im"
        + "pose\n"
        + "any additional terms or conditions on the Work or Derivative Work that alter or\n"
        + "restrict the terms of the Licence.\n"
        + "\n"
        + "Compatibility clause: If the Licensee Distributes and/or Communicates Derivative\n"
        + "Works or copies thereof based upon both the Original Work and another work\n"
        + "licensed under a Compatible Licence, this Distribution and/or Communication can "
        + "be\n"
        + "done under the terms of this Compatible Licence. For the sake of this clause,\n"
        + "\"Compatible Licence�\" refers to the licences listed in the appendix attached to "
        + "this\n"
        + "Licence. Should the Licensee’s obligations under the Compatible Licence conflict\n"
        + "with his/her obligations under this Licence, the obligations of the Compatible L"
        + "icence\n"
        + "shall prevail.\n"
        + "\n"
        + "Provision of Source Code: When distributing and/or communicating copies of the\n"
        + "Work, the Licensee will provide a machine-readable copy of the Source Code or\n"
        + "indicate a repository where this Source will be easily and freely available for "
        + "as long\n"
        + "as the Licensee continues to distribute and/or communicate the Work.\n"
        + "\n"
        + "Legal Protection: This Licence does not grant permission to use the trade names,\n"
        + "trademarks, service marks, or names of the Licensor, except as required for\n"
        + "reasonable and customary use in describing the origin of the Work and reproducin"
        + "g\n"
        + "the content of the copyright notice.\n"
        + "\n"
        + "6. Chain of Authorship\n"
        + "\n"
        + "The original Licensor warrants that the copyright in the Original Work granted\n"
        + "hereunder is owned by him/her or licensed to him/her and that he/she has the pow"
        + "er\n"
        + "and authority to grant the Licence.\n"
        + "\n"
        + "Each Contributor warrants that the copyright in the modifications he/she brings "
        + "to the\n"
        + "Work are owned by him/her or licensed to him/her and that he/she has the power a"
        + "nd\n"
        + "authority to grant the Licence.\n"
        + "\n"
        + "Each time You accept the Licence, the original Licensor and subsequent Contribut"
        + "ors\n"
        + "grant You a licence to their contributions to the Work, under the terms of this\n"
        + "Licence.\n"
        + "\n"
        + "7. Disclaimer of Warranty\n"
        + "\n"
        + "The Work is a work in progress, which is continuously improved by numerous\n"
        + "contributors. It is not a finished work and may therefore contain defects or \"bu"
        + "gs\"\n"
        + "inherent to this type of software development.\n"
        + "\n"
        + "For the above reason, the Work is provided under the Licence on an \"as is\" basis"
        + " and\n"
        + "without warranties of any kind concerning the Work, including without limitation\n"
        + "merchantability, fitness for a particular purpose, absence of defects or errors,\n"
        + "accuracy, non-infringement of intellectual property rights other than copyright "
        + "as\n"
        + "stated in Article 6 of this Licence.\n"
        + "\n"
        + "This disclaimer of warranty is an essential part of the Licence and a condition "
        + "for the\n"
        + "grant of any rights to the Work.\n"
        + "\n"
        + "8. Disclaimer of Liability\n"
        + "\n"
        + "Except in the cases of wilful misconduct or damages directly caused to natural\n"
        + "persons, the Licensor will in no event be liable for any direct or indirect, mat"
        + "erial or\n"
        + "moral, damages of any kind, arising out of the Licence or of the use of the Work"
        + ",\n"
        + "including without limitation, damages for loss of goodwill, work stoppage, compu"
        + "ter\n"
        + "failure or malfunction, loss of data or any commercial damage, even if the Licen"
        + "sor\n"
        + "has been advised of the possibility of such damage. However, the Licensor will b"
        + "e\n"
        + "liable under statutory product liability laws as far such laws apply to the Work"
        + ".\n"
        + "\n"
        + "9. Additional agreements\n"
        + "\n"
        + "While distributing the Original Work or Derivative Works, You may choose to\n"
        + "conclude an additional agreement to offer, and charge a fee for, acceptance of s"
        + "upport,\n"
        + "warranty, indemnity, or other liability obligations and/or services consistent w"
        + "ith this\n"
        + "Licence. However, in accepting such obligations, You may act only on your own\n"
        + "behalf and on your sole responsibility, not on behalf of the original Licensor o"
        + "r any\n"
        + "other Contributor, and only if You agree to indemnify, defend, and hold each\n"
        + "Contributor harmless for any liability incurred by, or claims asserted against s"
        + "uch\n"
        + "Contributor by the fact You have accepted any such warranty or additional liabil"
        + "ity.\n"
        + "\n"
        + "10. Acceptance of the Licence\n"
        + "\n"
        + "The provisions of this Licence can be accepted by clicking on an icon \"I agree\"\n"
        + "placed under the bottom of a window displaying the text of this Licence or by\n"
        + "affirming consent in any other similar way, in accordance with the rules of appl"
        + "icable\n"
        + "law. Clicking on that icon indicates your clear and irrevocable acceptance of th"
        + "is\n"
        + "Licence and all of its terms and conditions.\n"
        + "\n"
        + "Similarly, you irrevocably accept this Licence and all of its terms and conditio"
        + "ns by\n"
        + "exercising any rights granted to You by Article 2 of this Licence, such as the u"
        + "se of\n"
        + "the Work, the creation by You of a Derivative Work or the Distribution and/or\n"
        + "Communication by You of the Work or copies thereof.\n"
        + "\n"
        + "11. Information to the public\n"
        + "\n"
        + "In case of any Distribution and/or Communication of the Work by means of electro"
        + "nic\n"
        + "communication by You (for example, by offering to download the Work from a\n"
        + "remote location) the distribution channel or media (for example, a website) must"
        + " at\n"
        + "least provide to the public the information requested by the applicable law rega"
        + "rding\n"
        + "the Licensor, the Licence and the way it may be accessible, concluded, stored an"
        + "d\n"
        + "reproduced by the Licensee.\n"
        + "\n"
        + "12. Termination of the Licence\n"
        + "\n"
        + "The Licence and the rights granted hereunder will terminate automatically upon a"
        + "ny\n"
        + "breach by the Licensee of the terms of the Licence.\n"
        + "Such a termination will not terminate the licences of any person who has receive"
        + "d the\n"
        + "Work from the Licensee under the Licence, provided such persons remain in full\n"
        + "compliance with the Licence.\n"
        + "\n"
        + "13. Miscellaneous\n"
        + "\n"
        + "Without prejudice of Article 9 above, the Licence represents the complete agreem"
        + "ent\n"
        + "between the Parties as to the Work licensed hereunder.\n"
        + "\n"
        + "If any provision of the Licence is invalid or unenforceable under applicable law"
        + ", this\n"
        + "will not affect the validity or enforceability of the Licence as a whole. Such p"
        + "rovision\n"
        + "will be construed and/or reformed so as necessary to make it valid and enforceab"
        + "le.\n"
        + "\n"
        + "The European Commission may publish other linguistic versions and/or new version"
        + "s\n"
        + "of this Licence, so far this is required and reasonable, without reducing the sc"
        + "ope of\n"
        + "the rights granted by the Licence. New versions of the Licence will be published"
        + " with\n"
        + "a unique version number.\n"
        + "\n"
        + "All linguistic versions of this Licence, approved by the European Commission, ha"
        + "ve\n"
        + "identical value. Parties can take advantage of the linguistic version of their c"
        + "hoice.\n"
        + "\n"
        + "14. Jurisdiction\n"
        + "\n"
        + "Any litigation resulting from the interpretation of this License, arising betwee"
        + "n the\n"
        + "European Commission, as a Licensor, and any Licensee, will be subject to the\n"
        + "jurisdiction of the Court of Justice of the European Communities, as laid down i"
        + "n\n"
        + "article 238 of the Treaty establishing the European Community.\n"
        + "\n"
        + "Any litigation arising between Parties, other than the European Commission, and\n"
        + "resulting from the interpretation of this License, will be subject to the exclus"
        + "ive\n"
        + "jurisdiction of the competent court where the Licensor resides or conducts its p"
        + "rimary\n"
        + "business.\n"
        + "\n"
        + "15. Applicable Law\n"
        + "\n"
        + "This Licence shall be governed by the law of the European Union country where th"
        + "e\n"
        + "Licensor resides or has his registered office.\n"
        + "\n"
        + "This licence shall be governed by the Belgian law if:\n"
        + "\n"
        + "- a litigation arises between the European Commission, as a Licensor, and any\n"
        + "Licensee;\n"
        + "- the Licensor, other than the European Commission, has no residence or\n"
        + "registered office inside a European Union country.\n"
        + "\n"
        + "===\n"
        + "\n"
        + "Appendix\n"
        + "\n"
        + "\"Compatible Licences\" according to article 5 EUPL are:\n"
        + "- GNU General Public License (GNU GPL) v. 2\n"
        + "- Open Software License (OSL) v. 2.1, v. 3.0\n"
        + "- Common Public License v. 1.0\n"
        + "- Eclipse Public License v. 1.0\n"
        + "- Cecill v. 2.0\n"
; // the license text
    }
 
    
}