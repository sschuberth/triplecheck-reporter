package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:31:42Z
 * LicenseName: Apache-2.0
 * FileName: Apache_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class Apache_2_0 extends License{
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
        return "Apache-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Apache License 2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Apache License\n"
        + "Version 2.0, January 2004\n"
        + "http://www.apache.org/licenses/\n"
        + "\n"
        + "TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION\n"
        + "\n"
        + "1. Definitions.\n"
        + "\n"
        + "\"License\" shall mean the terms and conditions for use, reproduction, and distrib"
        + "ution as defined by Sections 1 through 9 of this document.\n"
        + "\n"
        + "\"Licensor\" shall mean the copyright owner or entity authorized by the copyright "
        + "owner that is granting the License.\n"
        + "\n"
        + "\"Legal Entity\" shall mean the union of the acting entity and all other entities "
        + "that control, are controlled by, or are under common control with that entity. F"
        + "or the purposes of this definition, \"control\" means (i) the power, direct or ind"
        + "irect, to cause the direction or management of such entity, whether by contract "
        + "or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstandin"
        + "g shares, or (iii) beneficial ownership of such entity.\n"
        + "\n"
        + "\"You\" (or \"Your\") shall mean an individual or Legal Entity exercising permission"
        + "s granted by this License.\n"
        + "\n"
        + "\"Source\" form shall mean the preferred form for making modifications, including "
        + "but not limited to software source code, documentation source, and configuration"
        + " files.\n"
        + "\n"
        + "\"Object\" form shall mean any form resulting from mechanical transformation or tr"
        + "anslation of a Source form, including but not limited to compiled object code, g"
        + "enerated documentation, and conversions to other media types.\n"
        + "\n"
        + "\"Work\" shall mean the work of authorship, whether in Source or Object form, made"
        + " available under the License, as indicated by a copyright notice that is include"
        + "d in or attached to the work (an example is provided in the Appendix below).\n"
        + "\n"
        + "\"Derivative Works\" shall mean any work, whether in Source or Object form, that i"
        + "s based on (or derived from) the Work and for which the editorial revisions, ann"
        + "otations, elaborations, or other modifications represent, as a whole, an origina"
        + "l work of authorship. For the purposes of this License, Derivative Works shall n"
        + "ot include works that remain separable from, or merely link (or bind by name) to"
        + " the interfaces of, the Work and Derivative Works thereof.\n"
        + "\n"
        + "\"Contribution\" shall mean any work of authorship, including the original version"
        + " of the Work and any modifications or additions to that Work or Derivative Works"
        + " thereof, that is intentionally submitted to Licensor for inclusion in the Work "
        + "by the copyright owner or by an individual or Legal Entity authorized to submit "
        + "on behalf of the copyright owner. For the purposes of this definition, \"submitte"
        + "d\" means any form of electronic, verbal, or written communication sent to the Li"
        + "censor or its representatives, including but not limited to communication on ele"
        + "ctronic mailing lists, source code control systems, and issue tracking systems t"
        + "hat are managed by, or on behalf of, the Licensor for the purpose of discussing "
        + "and improving the Work, but excluding communication that is conspicuously marked"
        + " or otherwise designated in writing by the copyright owner as \"Not a Contributio"
        + "n.\"\n"
        + "\n"
        + "\"Contributor\" shall mean Licensor and any individual or Legal Entity on behalf o"
        + "f whom a Contribution has been received by Licensor and subsequently incorporate"
        + "d within the Work.\n"
        + "\n"
        + "2. Grant of Copyright License. Subject to the terms and conditions of this Licen"
        + "se, each Contributor hereby grants to You a perpetual, worldwide, non-exclusive,"
        + " no-charge, royalty-free, irrevocable copyright license to reproduce, prepare De"
        + "rivative Works of, publicly display, publicly perform, sublicense, and distribut"
        + "e the Work and such Derivative Works in Source or Object form.\n"
        + "\n"
        + "3. Grant of Patent License. Subject to the terms and conditions of this License,"
        + " each Contributor hereby grants to You a perpetual, worldwide, non-exclusive, no"
        + "-charge, royalty-free, irrevocable (except as stated in this section) patent lic"
        + "ense to make, have made, use, offer to sell, sell, import, and otherwise transfe"
        + "r the Work, where such license applies only to those patent claims licensable by"
        + " such Contributor that are necessarily infringed by their Contribution(s) alone "
        + "or by combination of their Contribution(s) with the Work to which such Contribut"
        + "ion(s) was submitted. If You institute patent litigation against any entity (inc"
        + "luding a cross-claim or counterclaim in a lawsuit) alleging that the Work or a C"
        + "ontribution incorporated within the Work constitutes direct or contributory pate"
        + "nt infringement, then any patent licenses granted to You under this License for "
        + "that Work shall terminate as of the date such litigation is filed.\n"
        + "\n"
        + "4. Redistribution. You may reproduce and distribute copies of the Work or Deriva"
        + "tive Works thereof in any medium, with or without modifications, and in Source o"
        + "r Object form, provided that You meet the following conditions:\n"
        + "\n"
        + "     (a) You must give any other recipients of the Work or Derivative Works a co"
        + "py of this License; and\n"
        + "\n"
        + "     (b) You must cause any modified files to carry prominent notices stating th"
        + "at You changed the files; and\n"
        + "\n"
        + "     (c) You must retain, in the Source form of any Derivative Works that You di"
        + "stribute, all copyright, patent, trademark, and attribution notices from the Sou"
        + "rce form of the Work, excluding those notices that do not pertain to any part of"
        + " the Derivative Works; and\n"
        + "\n"
        + "     (d) If the Work includes a \"NOTICE\" text file as part of its distribution, "
        + "then any Derivative Works that You distribute must include a readable copy of th"
        + "e attribution notices contained within such NOTICE file, excluding those notices"
        + " that do not pertain to any part of the Derivative Works, in at least one of the"
        + " following places: within a NOTICE text file distributed as part of the Derivati"
        + "ve Works; within the Source form or documentation, if provided along with the De"
        + "rivative Works; or, within a display generated by the Derivative Works, if and w"
        + "herever such third-party notices normally appear. The contents of the NOTICE fil"
        + "e are for informational purposes only and do not modify the License. You may add"
        + " Your own attribution notices within Derivative Works that You distribute, along"
        + "side or as an addendum to the NOTICE text from the Work, provided that such addi"
        + "tional attribution notices cannot be construed as modifying the License.\n"
        + "\n"
        + "     You may add Your own copyright statement to Your modifications and may prov"
        + "ide additional or different license terms and conditions for use, reproduction, "
        + "or distribution of Your modifications, or for any such Derivative Works as a who"
        + "le, provided Your use, reproduction, and distribution of the Work otherwise comp"
        + "lies with the conditions stated in this License.\n"
        + "\n"
        + "5. Submission of Contributions. Unless You explicitly state otherwise, any Contr"
        + "ibution intentionally submitted for inclusion in the Work by You to the Licensor"
        + " shall be under the terms and conditions of this License, without any additional"
        + " terms or conditions. Notwithstanding the above, nothing herein shall supersede "
        + "or modify the terms of any separate license agreement you may have executed with"
        + " Licensor regarding such Contributions.\n"
        + "\n"
        + "6. Trademarks. This License does not grant permission to use the trade names, tr"
        + "ademarks, service marks, or product names of the Licensor, except as required fo"
        + "r reasonable and customary use in describing the origin of the Work and reproduc"
        + "ing the content of the NOTICE file.\n"
        + "\n"
        + "7. Disclaimer of Warranty. Unless required by applicable law or agreed to in wri"
        + "ting, Licensor provides the Work (and each Contributor provides its Contribution"
        + "s) on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either exp"
        + "ress or implied, including, without limitation, any warranties or conditions of "
        + "TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. Y"
        + "ou are solely responsible for determining the appropriateness of using or redist"
        + "ributing the Work and assume any risks associated with Your exercise of permissi"
        + "ons under this License.\n"
        + "\n"
        + "8. Limitation of Liability. In no event and under no legal theory, whether in to"
        + "rt (including negligence), contract, or otherwise, unless required by applicable"
        + " law (such as deliberate and grossly negligent acts) or agreed to in writing, sh"
        + "all any Contributor be liable to You for damages, including any direct, indirect"
        + ", special, incidental, or consequential damages of any character arising as a re"
        + "sult of this License or out of the use or inability to use the Work (including b"
        + "ut not limited to damages for loss of goodwill, work stoppage, computer failure "
        + "or malfunction, or any and all other commercial damages or losses), even if such"
        + " Contributor has been advised of the possibility of such damages.\n"
        + "\n"
        + "9. Accepting Warranty or Additional Liability. While redistributing the Work or "
        + "Derivative Works thereof, You may choose to offer, and charge a fee for, accepta"
        + "nce of support, warranty, indemnity, or other liability obligations and/or right"
        + "s consistent with this License. However, in accepting such obligations, You may "
        + "act only on Your own behalf and on Your sole responsibility, not on behalf of an"
        + "y other Contributor, and only if You agree to indemnify, defend, and hold each C"
        + "ontributor harmless for any liability incurred by, or claims asserted against, s"
        + "uch Contributor by reason of your accepting any such warranty or additional liab"
        + "ility.\n"
        + "\n"
        + "END OF TERMS AND CONDITIONS\n"
        + "\n"
        + "APPENDIX: How to apply the Apache License to your work.\n"
        + "\n"
        + "To apply the Apache License to your work, attach the following boilerplate notic"
        + "e, with the fields enclosed by brackets \"[]\" replaced with your own identifying "
        + "information. (Don't include the brackets!)  The text should be enclosed in the a"
        + "ppropriate comment syntax for the file format. We also recommend that a file or "
        + "class name and description of purpose be included on the same \"printed page\" as "
        + "the copyright notice for easier identification within third-party archives.\n"
        + "\n"
        + "Copyright [yyyy] [name of copyright owner]\n"
        + "\n"
        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
        + "you may not use this file except in compliance with the License.\n"
        + "You may obtain a copy of the License at\n"
        + "\n"
        + "http://www.apache.org/licenses/LICENSE-2.0\n"
        + "\n"
        + "Unless required by applicable law or agreed to in writing, software\n"
        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
        + "See the License for the specific language governing permissions and\n"
        + "limitations under the License.\n"
; // the license text
    }
 
    
}
