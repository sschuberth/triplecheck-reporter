package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:12Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: CC0_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class CC0_1_0 extends License{
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
        return "CC0-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Creative Commons Zero v1.0 Universal"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Creative Commons CC0 1.0 Universal\n"
        + "\n"
        + "CREATIVE COMMONS CORPORATION IS NOT A LAW FIRM AND DOES NOT PROVIDE\n"
        + "LEGAL SERVICES. DISTRIBUTION OF THIS DOCUMENT DOES NOT CREATE AN\n"
        + "ATTORNEY-CLIENT RELATIONSHIP. CREATIVE COMMONS PROVIDES THIS INFORMATION\n"
        + "ON AN \"AS-IS\" BASIS. CREATIVE COMMONS MAKES NO WARRANTIES REGARDING THE\n"
        + "USE OF THIS DOCUMENT OR THE INFORMATION OR WORKS PROVIDED HEREUNDER, AND\n"
        + "DISCLAIMS LIABILITY FOR DAMAGES RESULTING FROM THE USE OF THIS DOCUMENT\n"
        + "OR THE INFORMATION OR WORKS PROVIDED HEREUNDER.\n"
        + "\n"
        + "Statement of Purpose\n"
        + "\n"
        + "The laws of most jurisdictions throughout the world automatically confer\n"
        + "exclusive Copyright and Related Rights (defined below) upon the creator\n"
        + "and subsequent owner(s) (each and all, an \"owner\") of an original work\n"
        + "of authorship and/or a database (each, a \"Work\").\n"
        + "\n"
        + "Certain owners wish to permanently relinquish those rights to a Work for\n"
        + "the purpose of contributing to a commons of creative, cultural and\n"
        + "scientific works (\"Commons\") that the public can reliably and without\n"
        + "fear of later claims of infringement build upon, modify, incorporate in\n"
        + "other works, reuse and redistribute as freely as possible in any form\n"
        + "whatsoever and for any purposes, including without limitation commercial\n"
        + "purposes. These owners may contribute to the Commons to promote the\n"
        + "ideal of a free culture and the further production of creative, cultural\n"
        + "and scientific works, or to gain reputation or greater distribution for\n"
        + "their Work in part through the use and efforts of others.\n"
        + "\n"
        + "For these and/or other purposes and motivations, and without any\n"
        + "expectation of additional consideration or compensation, the person\n"
        + "associating CC0 with a Work (the \"Affirmer\"), to the extent that he or\n"
        + "she is an owner of Copyright and Related Rights in the Work, voluntarily\n"
        + "elects to apply CC0 to the Work and publicly distribute the Work under\n"
        + "its terms, with knowledge of his or her Copyright and Related Rights in\n"
        + "the Work and the meaning and intended legal effect of CC0 on those\n"
        + "rights.\n"
        + "\n"
        + "1. Copyright and Related Rights. A Work made available under CC0 may be\n"
        + "protected by copyright and related or neighboring rights (\"Copyright and\n"
        + "Related Rights\"). Copyright and Related Rights include, but are not\n"
        + "limited to, the following:\n"
        + "\n"
        + "i. the right to reproduce, adapt, distribute, perform, display,\n"
        + "communicate, and translate a Work;\n"
        + "\n"
        + "ii. moral rights retained by the original author(s) and/or performer(s);\n"
        + "\n"
        + "iii. publicity and privacy rights pertaining to a person's image or\n"
        + "likeness depicted in a Work;\n"
        + "\n"
        + "iv. rights protecting against unfair competition in regards to a Work,\n"
        + "subject to the limitations in paragraph 4(a), below;\n"
        + "\n"
        + "v. rights protecting the extraction, dissemination, use and reuse of\n"
        + "data in a Work;\n"
        + "\n"
        + "vi. database rights (such as those arising under Directive 96/9/EC of\n"
        + "the European Parliament and of the Council of 11 March 1996 on the legal\n"
        + "protection of databases, and under any national implementation thereof,\n"
        + "including any amended or successor version of such directive); and\n"
        + "\n"
        + "vii. other similar, equivalent or corresponding rights throughout the\n"
        + "world based on applicable law or treaty, and any national\n"
        + "implementations thereof.\n"
        + "\n"
        + "2. Waiver. To the greatest extent permitted by, but not in contravention\n"
        + "of, applicable law, Affirmer hereby overtly, fully, permanently,\n"
        + "irrevocably and unconditionally waives, abandons, and surrenders all of\n"
        + "Affirmer's Copyright and Related Rights and associated claims and causes\n"
        + "of action, whether now known or unknown (including existing as well as\n"
        + "future claims and causes of action), in the Work (i) in all territories\n"
        + "worldwide, (ii) for the maximum duration provided by applicable law or\n"
        + "treaty (including future time extensions), (iii) in any current or\n"
        + "future medium and for any number of copies, and (iv) for any purpose\n"
        + "whatsoever, including without limitation commercial, advertising or\n"
        + "promotional purposes (the \"Waiver\"). Affirmer makes the Waiver for the\n"
        + "benefit of each member of the public at large and to the detriment of\n"
        + "Affirmer's heirs and successors, fully intending that such Waiver shall\n"
        + "not be subject to revocation, rescission, cancellation, termination, or\n"
        + "any other legal or equitable action to disrupt the quiet enjoyment of\n"
        + "the Work by the public as contemplated by Affirmer's express Statement\n"
        + "of Purpose.\n"
        + "\n"
        + "3. Public License Fallback. Should any part of the Waiver for any reason\n"
        + "be judged legally invalid or ineffective under applicable law, then the\n"
        + "Waiver shall be preserved to the maximum extent permitted taking into\n"
        + "account Affirmer's express Statement of Purpose. In addition, to the\n"
        + "extent the Waiver is so judged Affirmer hereby grants to each affected\n"
        + "person a royalty-free, non transferable, non sublicensable, non\n"
        + "exclusive, irrevocable and unconditional license to exercise Affirmer's\n"
        + "Copyright and Related Rights in the Work (i) in all territories\n"
        + "worldwide, (ii) for the maximum duration provided by applicable law or\n"
        + "treaty (including future time extensions), (iii) in any current or\n"
        + "future medium and for any number of copies, and (iv) for any purpose\n"
        + "whatsoever, including without limitation commercial, advertising or\n"
        + "promotional purposes (the \"License\"). The License shall be deemed\n"
        + "effective as of the date CC0 was applied by Affirmer to the Work. Should\n"
        + "any part of the License for any reason be judged legally invalid or\n"
        + "ineffective under applicable law, such partial invalidity or\n"
        + "ineffectiveness shall not invalidate the remainder of the License, and\n"
        + "in such case Affirmer hereby affirms that he or she will not (i)\n"
        + "exercise any of his or her remaining Copyright and Related Rights in the\n"
        + "Work or (ii) assert any associated claims and causes of action with\n"
        + "respect to the Work, in either case contrary to Affirmer's express\n"
        + "Statement of Purpose.\n"
        + "\n"
        + "4. Limitations and Disclaimers.\n"
        + "\n"
        + "a. No trademark or patent rights held by Affirmer are waived, abandoned,\n"
        + "surrendered, licensed or otherwise affected by this document.\n"
        + "\n"
        + "b. Affirmer offers the Work as-is and makes no representations or\n"
        + "warranties of any kind concerning the Work, express, implied, statutory\n"
        + "or otherwise, including without limitation warranties of title,\n"
        + "merchantability, fitness for a particular purpose, non infringement, or\n"
        + "the absence of latent or other defects, accuracy, or the present or\n"
        + "absence of errors, whether or not discoverable, all to the greatest\n"
        + "extent permissible under applicable law.\n"
        + "\n"
        + "c. Affirmer disclaims responsibility for clearing rights of other\n"
        + "persons that may apply to the Work or any use thereof, including without\n"
        + "limitation any person's Copyright and Related Rights in the Work.\n"
        + "Further, Affirmer disclaims responsibility for obtaining any necessary\n"
        + "consents, permissions or other rights required for any use of the Work.\n"
        + "\n"
        + "d. Affirmer understands and acknowledges that Creative Commons is not a\n"
        + "party to this document and has no duty or obligation with respect to\n"
        + "this CC0 or use of the Work.\n"
; // the license text
    }
 
    
}
