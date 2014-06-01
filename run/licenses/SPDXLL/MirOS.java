package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:07Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: MirOS.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class MirOS extends License{
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
        return "MirOS"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "MirOS Licence"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "MirOS License\n"
        + "\n"
        + "Copyright � [YEAR]\n"
        + "[NAME]  [EMAIL] \n"
        + " \n"
        + "Provided that these terms and disclaimer and all copyright notices are retained "
        + "or reproduced in an accompanying document, permission is granted to deal in this"
        + " work without restriction, including unlimited rights to use, publicly perform, "
        + "distribute, sell, modify, merge, give away, or sublicence.\n"
        + " \n"
        + "This work is provided \"AS IS\" and WITHOUT WARRANTY of any kind, to the utmost ex"
        + "tent permitted by applicable law, neither express nor implied; without malicious"
        + " intent or gross negligence. In no event may a licensor, author or contributor b"
        + "e held liable for indirect, direct, other damage, loss, or other issues arising "
        + "in any way out of dealing in the work, even if advised of the possibility of suc"
        + "h damage or existence of a defect, except proven that it results out of said per"
        + "son's immediate fault when using the work as intended.\n"
        + "\n"
        + "\n"
        + "I_N_S_T_R_U_C_T_I_O_N_S_:_\n"
        + "To apply the template(1) specify the years of copyright (separated by\n"
        + "comma, not as a range), the legal names of the copyright holders, and\n"
        + "the real names of the authors if different. Avoid adding text.\n"
        + "\n"
        + "R_A_T_I_O_N_A_L_E_:_\n"
        + "This licence is apt for any kind of work (such as source code, fonts,\n"
        + "documentation, graphics, sound etc.) and the preferred terms for work\n"
        + "added to MirBSD. It has been drafted as universally usable equivalent\n"
        + "of the \"historic permission notice\"(2) adapted to Europen law because\n"
        + "in some (droit d'auteur) countries authors cannot disclaim all liabi‐\n"
        + "lities. Compliance to DFSG(3) 1.1 is ensured, and GPLv2 compatibility\n"
        + "is asserted unless advertising clauses are used. The MirOS Licence is\n"
        + "certified to conform to OKD(4) 1.0 and OSD(5) 1.9, and qualifies as a\n"
        + "Free Software(6) and also Free Documentation(7) licence and is included in some "
        + "relevant lists(8)(9)(10).\n"
        + "\n"
        + "We believe you are not liable for work inserted which is intellectual\n"
        + "property of third parties, if you were not aware of the fact, act appropriately "
        + "as soon as you become aware of that problem, seek an amicable solution for all p"
        + "arties, and never knowingly distribute a work\n"
        + "without being authorised to do so by its licensors.\n"
        + "\n"
        + "R_E_F_E_R_E_N_C_E_S_:_\n"
        + "(1) also at http://mirbsd.de/MirOS-Licence\n"
        + "(2) http://www.opensource.org/licenses/historical.php\n"
        + "(3) http://www.debian.org/social_contract#guidelines\n"
        + "(4) http://www.opendefinition.org/1.0\n"
        + "(5) http://www.opensource.org/docs/osd\n"
        + "(6) http://www.gnu.org/philosophy/free-sw.html\n"
        + "(7) http://www.gnu.org/philosophy/free-doc.html\n"
        + "(8) http://www.ifross.de/ifross_html/lizenzcenter.html\n"
        + "(9) http://www.opendefinition.org/licenses\n"
        + "(10) http://opensource.org/licenses/miros.html\n"
; // the license text
    }
 
    
}
