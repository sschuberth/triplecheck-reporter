package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:32:03Z
 * LicenseName: Apache-2.0
 * FileName: CC_BY_ND_3_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class CC_BY_ND_3_0 extends License{
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
        return "CC-BY-ND-3.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Creative Commons Attribution No Derivatives 3.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Creative Commons Attribution-NoDerivs 3.0 Unported\n"
        + "\n"
        + "CREATIVE COMMONS CORPORATION IS NOT A LAW FIRM AND DOES NOT PROVIDE\n"
        + "LEGAL SERVICES. DISTRIBUTION OF THIS LICENSE DOES NOT CREATE AN\n"
        + "ATTORNEY-CLIENT RELATIONSHIP. CREATIVE COMMONS PROVIDES THIS INFORMATION\n"
        + "ON AN \"AS-IS\" BASIS. CREATIVE COMMONS MAKES NO WARRANTIES REGARDING THE\n"
        + "INFORMATION PROVIDED, AND DISCLAIMS LIABILITY FOR DAMAGES RESULTING FROM\n"
        + "ITS USE.\n"
        + "\n"
        + "License\n"
        + "\n"
        + "THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS CREATIVE\n"
        + "COMMONS PUBLIC LICENSE (\"CCPL\" OR \"LICENSE\"). THE WORK IS PROTECTED BY\n"
        + "COPYRIGHT AND/OR OTHER APPLICABLE LAW. ANY USE OF THE WORK OTHER THAN AS\n"
        + "AUTHORIZED UNDER THIS LICENSE OR COPYRIGHT LAW IS PROHIBITED.\n"
        + "\n"
        + "BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND AGREE\n"
        + "TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE MAY\n"
        + "BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS\n"
        + "CONTAINED HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND\n"
        + "CONDITIONS.\n"
        + "\n"
        + "1. Definitions\n"
        + "\n"
        + "a. \"Adaptation\" means a work based upon the Work, or upon the Work and\n"
        + "other pre-existing works, such as a translation, adaptation, derivative\n"
        + "work, arrangement of music or other alterations of a literary or\n"
        + "artistic work, or phonogram or performance and includes cinematographic\n"
        + "adaptations or any other form in which the Work may be recast,\n"
        + "transformed, or adapted including in any form recognizably derived from\n"
        + "the original, except that a work that constitutes a Collection will not\n"
        + "be considered an Adaptation for the purpose of this License. For the\n"
        + "avoidance of doubt, where the Work is a musical work, performance or\n"
        + "phonogram, the synchronization of the Work in timed-relation with a\n"
        + "moving image (\"synching\") will be considered an Adaptation for the\n"
        + "purpose of this License.\n"
        + "\n"
        + "b. \"Collection\" means a collection of literary or artistic works, such\n"
        + "as encyclopedias and anthologies, or performances, phonograms or\n"
        + "broadcasts, or other works or subject matter other than works listed in\n"
        + "Section 1(f) below, which, by reason of the selection and arrangement of\n"
        + "their contents, constitute intellectual creations, in which the Work is\n"
        + "included in its entirety in unmodified form along with one or more other\n"
        + "contributions, each constituting separate and independent works in\n"
        + "themselves, which together are assembled into a collective whole. A work\n"
        + "that constitutes a Collection will not be considered an Adaptation (as\n"
        + "defined above) for the purposes of this License.\n"
        + "\n"
        + "c. \"Distribute\" means to make available to the public the original and\n"
        + "copies of the Work through sale or other transfer of ownership.\n"
        + "\n"
        + "d. \"Licensor\" means the individual, individuals, entity or entities that\n"
        + "offer(s) the Work under the terms of this License.\n"
        + "\n"
        + "e. \"Original Author\" means, in the case of a literary or artistic work,\n"
        + "the individual, individuals, entity or entities who created the Work or\n"
        + "if no individual or entity can be identified, the publisher; and in\n"
        + "addition (i) in the case of a performance the actors, singers,\n"
        + "musicians, dancers, and other persons who act, sing, deliver, declaim,\n"
        + "play in, interpret or otherwise perform literary or artistic works or\n"
        + "expressions of folklore; (ii) in the case of a phonogram the producer\n"
        + "being the person or legal entity who first fixes the sounds of a\n"
        + "performance or other sounds; and, (iii) in the case of broadcasts, the\n"
        + "organization that transmits the broadcast.\n"
        + "\n"
        + "f. \"Work\" means the literary and/or artistic work offered under the\n"
        + "terms of this License including without limitation any production in the\n"
        + "literary, scientific and artistic domain, whatever may be the mode or\n"
        + "form of its expression including digital form, such as a book, pamphlet\n"
        + "and other writing; a lecture, address, sermon or other work of the same\n"
        + "nature; a dramatic or dramatico-musical work; a choreographic work or\n"
        + "entertainment in dumb show; a musical composition with or without words;\n"
        + "a cinematographic work to which are assimilated works expressed by a\n"
        + "process analogous to cinematography; a work of drawing, painting,\n"
        + "architecture, sculpture, engraving or lithography; a photographic work\n"
        + "to which are assimilated works expressed by a process analogous to\n"
        + "photography; a work of applied art; an illustration, map, plan, sketch\n"
        + "or three-dimensional work relative to geography, topography,\n"
        + "architecture or science; a performance; a broadcast; a phonogram; a\n"
        + "compilation of data to the extent it is protected as a copyrightable\n"
        + "work; or a work performed by a variety or circus performer to the extent\n"
        + "it is not otherwise considered a literary or artistic work.\n"
        + "\n"
        + "g. \"You\" means an individual or entity exercising rights under this\n"
        + "License who has not previously violated the terms of this License with\n"
        + "respect to the Work, or who has received express permission from the\n"
        + "Licensor to exercise rights under this License despite a previous\n"
        + "violation.\n"
        + "\n"
        + "h. \"Publicly Perform\" means to perform public recitations of the Work\n"
        + "and to communicate to the public those public recitations, by any means\n"
        + "or process, including by wire or wireless means or public digital\n"
        + "performances; to make available to the public Works in such a way that\n"
        + "members of the public may access these Works from a place and at a place\n"
        + "individually chosen by them; to perform the Work to the public by any\n"
        + "means or process and the communication to the public of the performances\n"
        + "of the Work, including by public digital performance; to broadcast and\n"
        + "rebroadcast the Work by any means including signs, sounds or images.\n"
        + "\n"
        + "i. \"Reproduce\" means to make copies of the Work by any means including\n"
        + "without limitation by sound or visual recordings and the right of\n"
        + "fixation and reproducing fixations of the Work, including storage of a\n"
        + "protected performance or phonogram in digital form or other electronic\n"
        + "medium.\n"
        + "\n"
        + "2. Fair Dealing Rights. Nothing in this License is intended to reduce,\n"
        + "limit, or restrict any uses free from copyright or rights arising from\n"
        + "limitations or exceptions that are provided for in connection with the\n"
        + "copyright protection under copyright law or other applicable laws.\n"
        + "\n"
        + "3. License Grant. Subject to the terms and conditions of this License,\n"
        + "Licensor hereby grants You a worldwide, royalty-free, non-exclusive,\n"
        + "perpetual (for the duration of the applicable copyright) license to\n"
        + "exercise the rights in the Work as stated below:\n"
        + "\n"
        + "a. to Reproduce the Work, to incorporate the Work into one or more\n"
        + "Collections, and to Reproduce the Work as incorporated in the\n"
        + "Collections; and,\n"
        + "\n"
        + "b. to Distribute and Publicly Perform the Work including as incorporated\n"
        + "in Collections.\n"
        + "\n"
        + "c. For the avoidance of doubt:\n"
        + "\n"
        + "i. Non-waivable Compulsory License Schemes. In those jurisdictions in\n"
        + "which the right to collect royalties through any statutory or compulsory\n"
        + "licensing scheme cannot be waived, the Licensor reserves the exclusive\n"
        + "right to collect such royalties for any exercise by You of the rights\n"
        + "granted under this License;\n"
        + "\n"
        + "ii. Waivable Compulsory License Schemes. In those jurisdictions in which\n"
        + "the right to collect royalties through any statutory or compulsory\n"
        + "licensing scheme can be waived, the Licensor waives the exclusive right\n"
        + "to collect such royalties for any exercise by You of the rights granted\n"
        + "under this License; and,\n"
        + "\n"
        + "iii. Voluntary License Schemes. The Licensor waives the right to collect\n"
        + "royalties, whether individually or, in the event that the Licensor is a\n"
        + "member of a collecting society that administers voluntary licensing\n"
        + "schemes, via that society, from any exercise by You of the rights\n"
        + "granted under this License.\n"
        + "\n"
        + "The above rights may be exercised in all media and formats whether now\n"
        + "known or hereafter devised. The above rights include the right to make\n"
        + "such modifications as are technically necessary to exercise the rights\n"
        + "in other media and formats, but otherwise you have no rights to make\n"
        + "Adaptations. Subject to Section 8(f), all rights not expressly granted\n"
        + "by Licensor are hereby reserved.\n"
        + "\n"
        + "4. Restrictions. The license granted in Section 3 above is expressly\n"
        + "made subject to and limited by the following restrictions:\n"
        + "\n"
        + "a. You may Distribute or Publicly Perform the Work only under the terms\n"
        + "of this License. You must include a copy of, or the Uniform Resource\n"
        + "Identifier (URI) for, this License with every copy of the Work You\n"
        + "Distribute or Publicly Perform. You may not offer or impose any terms on\n"
        + "the Work that restrict the terms of this License or the ability of the\n"
        + "recipient of the Work to exercise the rights granted to that recipient\n"
        + "under the terms of the License. You may not sublicense the Work. You\n"
        + "must keep intact all notices that refer to this License and to the\n"
        + "disclaimer of warranties with every copy of the Work You Distribute or\n"
        + "Publicly Perform. When You Distribute or Publicly Perform the Work, You\n"
        + "may not impose any effective technological measures on the Work that\n"
        + "restrict the ability of a recipient of the Work from You to exercise the\n"
        + "rights granted to that recipient under the terms of the License. This\n"
        + "Section 4(a) applies to the Work as incorporated in a Collection, but\n"
        + "this does not require the Collection apart from the Work itself to be\n"
        + "made subject to the terms of this License. If You create a Collection,\n"
        + "upon notice from any Licensor You must, to the extent practicable,\n"
        + "remove from the Collection any credit as required by Section 4(b), as\n"
        + "requested.\n"
        + "\n"
        + "b. If You Distribute, or Publicly Perform the Work or Collections, You\n"
        + "must, unless a request has been made pursuant to Section 4(a), keep\n"
        + "intact all copyright notices for the Work and provide, reasonable to the\n"
        + "medium or means You are utilizing: (i) the name of the Original Author\n"
        + "(or pseudonym, if applicable) if supplied, and/or if the Original Author\n"
        + "and/or Licensor designate another party or parties (e.g., a sponsor\n"
        + "institute, publishing entity, journal) for attribution (\"Attribution\n"
        + "Parties\") in Licensor's copyright notice, terms of service or by other\n"
        + "reasonable means, the name of such party or parties; (ii) the title of\n"
        + "the Work if supplied; (iii) to the extent reasonably practicable, the\n"
        + "URI, if any, that Licensor specifies to be associated with the Work,\n"
        + "unless such URI does not refer to the copyright notice or licensing\n"
        + "information for the Work. The credit required by this Section 4(b) may\n"
        + "be implemented in any reasonable manner; provided, however, that in the\n"
        + "case of a Collection, at a minimum such credit will appear, if a credit\n"
        + "for all contributing authors of the Collection appears, then as part of\n"
        + "these credits and in a manner at least as prominent as the credits for\n"
        + "the other contributing authors. For the avoidance of doubt, You may only\n"
        + "use the credit required by this Section for the purpose of attribution\n"
        + "in the manner set out above and, by exercising Your rights under this\n"
        + "License, You may not implicitly or explicitly assert or imply any\n"
        + "connection with, sponsorship or endorsement by the Original Author,\n"
        + "Licensor and/or Attribution Parties, as appropriate, of You or Your use\n"
        + "of the Work, without the separate, express prior written permission of\n"
        + "the Original Author, Licensor and/or Attribution Parties.\n"
        + "\n"
        + "c. Except as otherwise agreed in writing by the Licensor or as may be\n"
        + "otherwise permitted by applicable law, if You Reproduce, Distribute or\n"
        + "Publicly Perform the Work either by itself or as part of any\n"
        + "Collections, You must not distort, mutilate, modify or take other\n"
        + "derogatory action in relation to the Work which would be prejudicial to\n"
        + "the Original Author's honor or reputation.\n"
        + "\n"
        + "5. Representations, Warranties and Disclaimer\n"
        + "\n"
        + "UNLESS OTHERWISE MUTUALLY AGREED TO BY THE PARTIES IN WRITING, LICENSOR\n"
        + "OFFERS THE WORK AS-IS AND MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY\n"
        + "KIND CONCERNING THE WORK, EXPRESS, IMPLIED, STATUTORY OR OTHERWISE,\n"
        + "INCLUDING, WITHOUT LIMITATION, WARRANTIES OF TITLE, MERCHANTIBILITY,\n"
        + "FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF\n"
        + "LATENT OR OTHER DEFECTS, ACCURACY, OR THE PRESENCE OF ABSENCE OF ERRORS,\n"
        + "WHETHER OR NOT DISCOVERABLE. SOME JURISDICTIONS DO NOT ALLOW THE\n"
        + "EXCLUSION OF IMPLIED WARRANTIES, SO SUCH EXCLUSION MAY NOT APPLY TO YOU.\n"
        + "\n"
        + "6. Limitation on Liability. EXCEPT TO THE EXTENT REQUIRED BY APPLICABLE\n"
        + "LAW, IN NO EVENT WILL LICENSOR BE LIABLE TO YOU ON ANY LEGAL THEORY FOR\n"
        + "ANY SPECIAL, INCIDENTAL, CONSEQUENTIAL, PUNITIVE OR EXEMPLARY DAMAGES\n"
        + "ARISING OUT OF THIS LICENSE OR THE USE OF THE WORK, EVEN IF LICENSOR HAS\n"
        + "BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\n"
        + "\n"
        + "7. Termination\n"
        + "\n"
        + "a. This License and the rights granted hereunder will terminate\n"
        + "automatically upon any breach by You of the terms of this License.\n"
        + "Individuals or entities who have received Collections from You under\n"
        + "this License, however, will not have their licenses terminated provided\n"
        + "such individuals or entities remain in full compliance with those\n"
        + "licenses. Sections 1, 2, 5, 6, 7, and 8 will survive any termination of\n"
        + "this License.\n"
        + "\n"
        + "b. Subject to the above terms and conditions, the license granted here\n"
        + "is perpetual (for the duration of the applicable copyright in the Work).\n"
        + "Notwithstanding the above, Licensor reserves the right to release the\n"
        + "Work under different license terms or to stop distributing the Work at\n"
        + "any time; provided, however that any such election will not serve to\n"
        + "withdraw this License (or any other license that has been, or is\n"
        + "required to be, granted under the terms of this License), and this\n"
        + "License will continue in full force and effect unless terminated as\n"
        + "stated above.\n"
        + "\n"
        + "8. Miscellaneous\n"
        + "\n"
        + "a. Each time You Distribute or Publicly Perform the Work or a\n"
        + "Collection, the Licensor offers to the recipient a license to the Work\n"
        + "on the same terms and conditions as the license granted to You under\n"
        + "this License.\n"
        + "\n"
        + "b. If any provision of this License is invalid or unenforceable under\n"
        + "applicable law, it shall not affect the validity or enforceability of\n"
        + "the remainder of the terms of this License, and without further action\n"
        + "by the parties to this agreement, such provision shall be reformed to\n"
        + "the minimum extent necessary to make such provision valid and\n"
        + "enforceable.\n"
        + "\n"
        + "c. No term or provision of this License shall be deemed waived and no\n"
        + "breach consented to unless such waiver or consent shall be in writing\n"
        + "and signed by the party to be charged with such waiver or consent.\n"
        + "\n"
        + "d. This License constitutes the entire agreement between the parties\n"
        + "with respect to the Work licensed here. There are no understandings,\n"
        + "agreements or representations with respect to the Work not specified\n"
        + "here. Licensor shall not be bound by any additional provisions that may\n"
        + "appear in any communication from You. This License may not be modified\n"
        + "without the mutual written agreement of the Licensor and You.\n"
        + "\n"
        + "e. The rights granted under, and the subject matter referenced, in this\n"
        + "License were drafted utilizing the terminology of the Berne Convention\n"
        + "for the Protection of Literary and Artistic Works (as amended on\n"
        + "September 28, 1979), the Rome Convention of 1961, the WIPO Copyright\n"
        + "Treaty of 1996, the WIPO Performances and Phonograms Treaty of 1996 and\n"
        + "the Universal Copyright Convention (as revised on July 24, 1971). These\n"
        + "rights and subject matter take effect in the relevant jurisdiction in\n"
        + "which the License terms are sought to be enforced according to the\n"
        + "corresponding provisions of the implementation of those treaty\n"
        + "provisions in the applicable national law. If the standard suite of\n"
        + "rights granted under applicable copyright law includes additional rights\n"
        + "not granted under this License, such additional rights are deemed to be\n"
        + "included in the License; this License is not intended to restrict the\n"
        + "license of any rights under applicable law.\n"
        + "\n"
        + "\n"
        + "Creative Commons Notice\n"
        + "\n"
        + "Creative Commons is not a party to this License, and makes no warranty\n"
        + "whatsoever in connection with the Work. Creative Commons will not be\n"
        + "liable to You or any party on any legal theory for any damages\n"
        + "whatsoever, including without limitation any general, special,\n"
        + "incidental or consequential damages arising in connection to this\n"
        + "license. Notwithstanding the foregoing two (2) sentences, if Creative\n"
        + "Commons has expressly identified itself as the Licensor hereunder, it\n"
        + "shall have all rights and obligations of Licensor.\n"
        + "\n"
        + "Except for the limited purpose of indicating to the public that the Work\n"
        + "is licensed under the CCPL, Creative Commons does not authorize the use\n"
        + "by either party of the trademark \"Creative Commons\" or any related\n"
        + "trademark or logo of Creative Commons without the prior written consent\n"
        + "of Creative Commons. Any permitted use will be in compliance with\n"
        + "Creative Commons' then-current trademark usage guidelines, as may be\n"
        + "published on its website or otherwise made available upon request from\n"
        + "time to time. For the avoidance of doubt, this trademark restriction\n"
        + "does not form part of this License.\n"
        + "\n"
        + "Creative Commons may be contacted at http://creativecommons.org/.\n"
; // the license text
    }
 
    
}
