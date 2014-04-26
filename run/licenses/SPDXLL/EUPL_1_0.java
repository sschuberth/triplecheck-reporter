package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:32:20Z
 * LicenseName: Apache-2.0
 * FileName: EUPL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class EUPL_1_0 extends License{
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
        return "EUPL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "European Union Public License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "European Union Public Licence \n"
        + "V.1.0 \n"
        + "\n"
        + "EUPL (c) the European Community 2007 \n"
        + "\n"
        + "This European Union Public Licence (the “EUPL”) applies to the Work or Software "
        + "(as \n"
        + "defined below) which is provided under the terms of this Licence. Any use of the"
        + " Work, other \n"
        + "than as authorised under this Licence is prohibited (to the extent such use is c"
        + "overed by a right \n"
        + "of the copyright holder of the Work). \n"
        + "\n"
        + "The Original Work is provided under the terms of this Licence when the Licensor "
        + "(as defined \n"
        + "below) has placed the following notice immediately following the copyright notic"
        + "e for the \n"
        + "\n"
        + "Original Work: \n"
        + "Licensed under the EUPL V.1.0 \n"
        + "or has expressed by any other mean his willingness to license under the EUPL. \n"
        + "\n"
        + "1. Definitions\n"
        + "\n"
        + "In this Licence, the following terms have the following meaning: \n"
        + "\n"
        + "− The Licence: this Licence. \n"
        + "\n"
        + "− The Original Work or the Software: the software distributed and/or communicate"
        + "d by \n"
        + "the Licensor under this Licence, available as Source Code and also as Executable"
        + " \n"
        + "Code as the case may be. \n"
        + "\n"
        + "− Derivative Works: the works or software that could be created by the Licensee,"
        + " based \n"
        + "upon the Original Work or modifications thereof. This Licence does not define th"
        + "e \n"
        + "extent of modification or dependence on the Original Work required in order to \n"
        + "classify a work as a Derivative Work; this extent is determined by copyright law"
        + " \n"
        + "applicable in the country mentioned in Article 15.  \n"
        + "\n"
        + "− The Work: the Original Work and/or its Derivative Works. \n"
        + "\n"
        + "− The Source Code: the human-readable form of the Work which is the most \n"
        + "convenient for people to study and modify. \n"
        + "\n"
        + "− The Executable Code: any code which has generally been compiled and which is \n"
        + "meant to be interpreted by a computer as a program. \n"
        + "\n"
        + "− The Licensor: the natural or legal person that  distributes and/or communicate"
        + "s the \n"
        + "Work under the Licence. \n"
        + "\n"
        + "− Contributor(s): any natural or legal person who modifies the Work under the \n"
        + "Licence, or otherwise contributes to the creation of a Derivative Work. \n"
        + "\n"
        + "− The Licensee or “You”:  any natural or legal person  who makes any usage of th"
        + "e \n"
        + "Software under the terms of the Licence. − Distribution and/or Communication: an"
        + "y act of selling,  giving, lending, renting, distributing, communicating, transm"
        + "itting, or otherwise making available, on-line or \n"
        + "off-line, copies of the Work at the disposal of any other natural or legal perso"
        + "n. \n"
        + "\n"
        + "2. Scope of the rights granted by the Licence\n"
        + "\n"
        + "The Licensor hereby grants You a world-wide,  royalty-free, non-exclusive, sub-l"
        + "icensable \n"
        + "licence to do the following, for the duration of copyright vested in the Origina"
        + "l Work: \n"
        + "\n"
        + "− use the Work in any circumstance and for all usage, \n"
        + "− reproduce the Work, \n"
        + "− modify the Original Work, and make Derivative Works based upon the Work, \n"
        + "− communicate to the public, including the right to make available or display th"
        + "e Work \n"
        + "or copies thereof to the public and perform publicly, as the case may be, the Wo"
        + "rk, \n"
        + "− distribute the Work or copies thereof, \n"
        + "− lend and rent the Work or copies thereof, \n"
        + "− sub-license rights in the Work or copies thereof. \n"
        + "\n"
        + "Those rights can be exercised on any media, supports and formats, whether now kn"
        + "own or \n"
        + "later invented, as far as the applicable law permits so. \n"
        + "\n"
        + "In the countries where moral rights apply, the Licensor waives his right to exer"
        + "cise his moral \n"
        + "right to the extent allowed by law in order to make effective the licence of the"
        + " economic rights \n"
        + "here above listed. \n"
        + "\n"
        + "The Licensor grants to the Licensee royalty-free, non exclusive usage rights to "
        + "any patents \n"
        + "held by the Licensor, to the extent necessary to make use of the rights granted "
        + "on the Work \n"
        + "under this Licence. \n"
        + "\n"
        + "3. Communication of the Source Code\n"
        + "\n"
        + "The Licensor may provide the Work either in its Source Code form, or as Executab"
        + "le Code. If \n"
        + "the Work is provided as Executable Code,  the Licensor provides in addition a ma"
        + "chinereadable copy of the Source Code of the Work along with each copy of the Wo"
        + "rk that the \n"
        + "Licensor distributes or indicates, in a notice following the copyright notice at"
        + "tached to the \n"
        + "Work, a repository where the Source Code is easily and freely accessible for as "
        + "long as the \n"
        + "Licensor continues to distribute and/or communicate the Work. \n"
        + "\n"
        + "4. Limitations on copyright\n"
        + "\n"
        + "Nothing in this Licence is intended to deprive the Licensee of the benefits from"
        + " any exception \n"
        + "or limitation to the exclusive rights of the rights owners in the Original Work "
        + "or Software, of \n"
        + "the exhaustion of those rights or of other applicable limitations thereto. \n"
        + "\n"
        + "5. Obligations of the Licensee\n"
        + "\n"
        + "The grant of the rights mentioned above is subject to some restrictions and obli"
        + "gations \n"
        + "imposed on the Licensee. Those obligations are the following: \n"
        + "\n"
        + "Attribution right: the Licensee shall keep intact all copyright, patent or trade"
        + "marks notices \n"
        + "and all notices that refer to the Licence and to the disclaimer of warranties. T"
        + "he Licensee must \n"
        + "include a copy of such notices and a copy of the Licence with every copy of the "
        + "Work he/she \n"
        + "distributes and/or communicates. The Licensee  must cause any Derivative Work to"
        + " carry \n"
        + "prominent notices stating that the Work has been modified and the date of modifi"
        + "cation. \n"
        + "\n"
        + "Copyleft clause: If the Licensee distributes and/or  communicates copies of the "
        + "Original \n"
        + "Works or Derivative Works based upon the Original Work, this Distribution and/or"
        + " \n"
        + "Communication will be done under the terms  of this Licence. The Licensee (becom"
        + "ing \n"
        + "Licensor) cannot offer or impose any additional terms or  conditions on the Work"
        + " or \n"
        + "Derivative Work that alter or restrict the terms of the Licence. \n"
        + "\n"
        + "Compatibility clause: If the Licensee Distributes and/or Communicates Derivative"
        + " Works or \n"
        + "copies thereof based upon both the Original Work and another work licensed under"
        + " a \n"
        + "Compatible Licence, this Distribution and/or Communication can be done under the"
        + " terms of \n"
        + "this Compatible Licence. For the sake of this clause, “Compatible Licence” refer"
        + "s to the \n"
        + "licences listed in the appendix attached to  this Licence. Should the  Licensee’"
        + "s obligations \n"
        + "under the Compatible Licence conflict with his/her  obligations under this Licen"
        + "ce, the \n"
        + "obligations of the Compatible Licence shall prevail.  \n"
        + "\n"
        + "Provision of Source Code: When distributing and/or communicating copies of the W"
        + "ork, the \n"
        + "Licensee will provide a machine-readable copy of the Source Code or indicate a r"
        + "epository \n"
        + "where this Source will be easily and freely available for as long as the License"
        + "e continues to \n"
        + "distribute and/or communicate the Work. \n"
        + "\n"
        + "Legal Protection: This Licence does not grant permission to use the trade names,"
        + " trademarks, \n"
        + "service marks, or names of the Licensor, except as required for reasonable and c"
        + "ustomary use \n"
        + "in describing the origin of the Work and reproducing the content of the copyrigh"
        + "t notice. \n"
        + "\n"
        + "6. Chain of Authorship\n"
        + "\n"
        + "The original Licensor warrants that the copyright in the Original Work granted h"
        + "ereunder is \n"
        + "owned by him/her or licensed to him/her and that he/she has the power and author"
        + "ity to grant \n"
        + "the Licence. \n"
        + "\n"
        + "Each Contributor warrants that the copyright in the modifications he/she brings "
        + "to the Work \n"
        + "are owned by him/her or licensed to him/her and that he/she has the power and au"
        + "thority to \n"
        + "grant the Licence. \n"
        + "\n"
        + "Each time You, as a Licensee,  receive the Work, the original Licensor and subse"
        + "quent \n"
        + "Contributors grant You a licence to their contributions to the Work, under the t"
        + "erms of this \n"
        + "Licence. \n"
        + "\n"
        + "7. Disclaimer of Warranty\n"
        + "\n"
        + "The Work is a work in progress, which is continuously improved by numerous contr"
        + "ibutors. It \n"
        + "is not a finished work and may therefore contain defects or “bugs” inherent to t"
        + "his type of \n"
        + "software development. \n"
        + "\n"
        + "For the above reason, the Work is provided under the Licence on an “as is” basis"
        + " and without \n"
        + "warranties of any kind concerning the Work,  including without limitation mercha"
        + "ntability, \n"
        + "fitness for a particular purpose, absence of defects or errors, accuracy, non-in"
        + "fringement of \n"
        + "intellectual property rights other than copyright as stated in Article 6 of this"
        + " Licence. \n"
        + "\n"
        + "This disclaimer of warranty is an essential part of the Licence and a condition "
        + "for the grant of \n"
        + "any rights to the Work. \n"
        + "\n"
        + "8. Disclaimer of Liability\n"
        + "\n"
        + "Except in the cases of wilful misconduct or damages directly caused to natural p"
        + "ersons, the \n"
        + "Licensor will in no event be liable for any direct or indirect, material or mora"
        + "l, damages of \n"
        + "any kind, arising out of the Licence or of the use of the Work, including withou"
        + "t limitation, \n"
        + "damages for loss of goodwill, work stoppage, computer failure or malfunction, lo"
        + "ss of data or \n"
        + "any commercial damage, even if the Licensor has been advised of the  possibility"
        + " of such \n"
        + "damage. However, the Licensor will be liable under statutory product liability l"
        + "aws as far such \n"
        + "laws apply to the Work. \n"
        + "\n"
        + "9. Additional agreements\n"
        + "\n"
        + "While distributing the Original Work or Derivative Works, You may choose to conc"
        + "lude an \n"
        + "additional agreement to offer, and charge a fee for, acceptance  of support, war"
        + "ranty, \n"
        + "indemnity, or other liability obligations and/or services consistent with this L"
        + "icence. \n"
        + "However, in accepting such obligations, You may act only on your own behalf and "
        + "on your \n"
        + "sole responsibility, not on behalf of the original Licensor or any other Contrib"
        + "utor, and only if \n"
        + "You agree to indemnify, defend, and hold each Contributor harmless for any liabi"
        + "lity incurred \n"
        + "by, or claims asserted against such Contributor by the fact You have accepted an"
        + "y such \n"
        + "warranty or additional liability. \n"
        + "\n"
        + "10. Acceptance of the Licence\n"
        + "\n"
        + "The provisions of this Licence can be accepted by clicking on an icon “I agree” "
        + "placed under \n"
        + "the bottom of a window displaying the text of this Licence or by affirming conse"
        + "nt in any \n"
        + "other similar way, in accordance with the rules of applicable law. Clicking on t"
        + "hat icon \n"
        + "indicates your clear and irrevocable acceptance of this Licence and  all of its "
        + "terms and \n"
        + "conditions.  \n"
        + "\n"
        + "Similarly, you irrevocably accept this Licence and all of its terms and conditio"
        + "ns by \n"
        + "exercising any rights granted to You by Article 2 of this Licence, such as the u"
        + "se of the Work, \n"
        + "the creation by You of a Derivative Work or the Distribution and/or Communicatio"
        + "n by You \n"
        + "of the Work or copies thereof.  \n"
        + "\n"
        + "11. Information to the public\n"
        + "\n"
        + "In case of any Distribution and/or Communication of the Work by means of electro"
        + "nic \n"
        + "communication by You (for example, by offering to download the Work from a remot"
        + "e \n"
        + "location) the distribution channel or media (for example, a website) must at lea"
        + "st provide to \n"
        + "the public the information requested by the applicable law regarding the identif"
        + "ication and \n"
        + "address of the Licensor, the Licence and the way it may be accessible, concluded"
        + ", stored and \n"
        + "reproduced by the Licensee. \n"
        + "\n"
        + "12. Termination of the Licence\n"
        + "\n"
        + "The Licence and the rights granted hereunder will terminate automatically upon a"
        + "ny breach by \n"
        + "the Licensee of the terms of the Licence. \n"
        + "\n"
        + "Such a termination will not terminate the licences of any person who has receive"
        + "d the Work \n"
        + "from the Licensee under the Licence, provided such persons remain in full compli"
        + "ance with \n"
        + "the Licence.  \n"
        + "\n"
        + "13. Miscellaneous\n"
        + "\n"
        + "Without prejudice of Article 9 above, the Licence represents the complete agreem"
        + "ent between \n"
        + "the Parties as to the Work licensed hereunder. \n"
        + "\n"
        + "If any provision of the Licence is invalid or unenforceable under applicable law"
        + ", this will not \n"
        + "affect the validity or enforceability of the Licence as a whole. Such provision "
        + "will be \n"
        + "construed and/or reformed so as necessary to make it valid and enforceable. \n"
        + "\n"
        + "The European Commission may put into force translations and/or binding new versi"
        + "ons of \n"
        + "this Licence, so far this is required and reasonable. New versions of the Licenc"
        + "e will be \n"
        + "published with a unique version number. The new version of the Licence becomes b"
        + "inding for \n"
        + "You as soon as You become aware of its publication. \n"
        + "\n"
        + "14. Jurisdiction\n"
        + "\n"
        + "Any litigation resulting from the interpretation of this License, arising betwee"
        + "n the European \n"
        + "Commission, as a Licensor, and any Licensee, will be subject to the jurisdiction"
        + " of the Court \n"
        + "of Justice of the European Communities, as laid down in article 238 of the Treat"
        + "y establishing \n"
        + "the European Community. \n"
        + "\n"
        + "Any litigation arising between Parties, other  than the European Commission, and"
        + " resulting \n"
        + "from the interpretation of this License, will be subject to the exclusive jurisd"
        + "iction of the \n"
        + "competent court where the Licensor resides or conducts its primary business. \n"
        + "\n"
        + "15. Applicable Law\n"
        + "\n"
        + "This Licence shall be governed by the law of the European Union country where th"
        + "e Licensor \n"
        + "resides or has his registered office. \n"
        + "\n"
        + "This licence shall be governed by the Belgian law if: \n"
        + "\n"
        + "− a litigation arises between the European Commission, as a Licensor, and any \n"
        + "Licensee; \n"
        + "\n"
        + "− the Licensor, other than the European Commission, has no residence or register"
        + "ed \n"
        + "office inside a European Union country.  \n"
        + "\n"
        + "=== \n"
        + "\n"
        + "Appendix\n"
        + "\n"
        + "“Compatible Licences” according to article 5 EUPL are: \n"
        + "\n"
        + "− General Public License (GPL) v. 2 \n"
        + "− Open Software License (OSL) v. 2.1, v. 3.0 \n"
        + "− Common Public License v. 1.0 \n"
        + "− Eclipse Public License v. 1.0 \n"
        + "− Cecill v. 2.0 \n"
; // the license text
    }
 
    
}
