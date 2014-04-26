package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:44:12Z
 * LicenseName: Apache-2.0
 * FileName: CC_BY_NC_SA_3_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class CC_BY_NC_SA_3_0 extends License{
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
        return "CC-BY-NC-SA-3.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Creative Commons Attribution Non Commercial Share Alike 3.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported\n"
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
        + "Section 1(g) below, which, by reason of the selection and arrangement of\n"
        + "their contents, constitute intellectual creations, in which the Work is\n"
        + "included in its entirety in unmodified form along with one or more other\n"
        + "contributions, each constituting separate and independent works in\n"
        + "themselves, which together are assembled into a collective whole. A work\n"
        + "that constitutes a Collection will not be considered an Adaptation (as\n"
        + "defined above) for the purposes of this License.\n"
        + "\n"
        + "c. \"Distribute\" means to make available to the public the original and\n"
        + "copies of the Work or Adaptation, as appropriate, through sale or other\n"
        + "transfer of ownership.\n"
        + "\n"
        + "d. \"License Elements\" means the following high-level license attributes\n"
        + "as selected by Licensor and indicated in the title of this License:\n"
        + "Attribution, Noncommercial, ShareAlike.\n"
        + "\n"
        + "e. \"Licensor\" means the individual, individuals, entity or entities that\n"
        + "offer(s) the Work under the terms of this License.\n"
        + "\n"
        + "f. \"Original Author\" means, in the case of a literary or artistic work,\n"
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
        + "g. \"Work\" means the literary and/or artistic work offered under the\n"
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
        + "h. \"You\" means an individual or entity exercising rights under this\n"
        + "License who has not previously violated the terms of this License with\n"
        + "respect to the Work, or who has received express permission from the\n"
        + "Licensor to exercise rights under this License despite a previous\n"
        + "violation.\n"
        + "\n"
        + "i. \"Publicly Perform\" means to perform public recitations of the Work\n"
        + "and to communicate to the public those public recitations, by any means\n"
        + "or process, including by wire or wireless means or public digital\n"
        + "performances; to make available to the public Works in such a way that\n"
        + "members of the public may access these Works from a place and at a place\n"
        + "individually chosen by them; to perform the Work to the public by any\n"
        + "means or process and the communication to the public of the performances\n"
        + "of the Work, including by public digital performance; to broadcast and\n"
        + "rebroadcast the Work by any means including signs, sounds or images.\n"
        + "\n"
        + "j. \"Reproduce\" means to make copies of the Work by any means including\n"
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
        + "Collections;\n"
        + "\n"
        + "b. to create and Reproduce Adaptations provided that any such\n"
        + "Adaptation, including any translation in any medium, takes reasonable\n"
        + "steps to clearly label, demarcate or otherwise identify that changes\n"
        + "were made to the original Work. For example, a translation could be\n"
        + "marked \"The original work was translated from English to Spanish,\" or a\n"
        + "modification could indicate \"The original work has been modified.\";\n"
        + "\n"
        + "c. to Distribute and Publicly Perform the Work including as incorporated\n"
        + "in Collections; and,\n"
        + "\n"
        + "d. to Distribute and Publicly Perform Adaptations.\n"
        + "\n"
        + "The above rights may be exercised in all media and formats whether now\n"
        + "known or hereafter devised. The above rights include the right to make\n"
        + "such modifications as are technically necessary to exercise the rights\n"
        + "in other media and formats. Subject to Section 8(f), all rights not\n"
        + "expressly granted by Licensor are hereby reserved, including but not\n"
        + "limited to the rights described in Section 4(e).\n"
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
        + "remove from the Collection any credit as required by Section 4(d), as\n"
        + "requested. If You create an Adaptation, upon notice from any Licensor\n"
        + "You must, to the extent practicable, remove from the Adaptation any\n"
        + "credit as required by Section 4(d), as requested.\n"
        + "\n"
        + "b. You may Distribute or Publicly Perform an Adaptation only under: (i)\n"
        + "the terms of this License; (ii) a later version of this License with the\n"
        + "same License Elements as this License; (iii) a Creative Commons\n"
        + "jurisdiction license (either this or a later license version) that\n"
        + "contains the same License Elements as this License (e.g.,\n"
        + "Attribution-NonCommercial-ShareAlike 3.0 US) (\"Applicable License\"). You\n"
        + "must include a copy of, or the URI, for Applicable License with every\n"
        + "copy of each Adaptation You Distribute or Publicly Perform. You may not\n"
        + "offer or impose any terms on the Adaptation that restrict the terms of\n"
        + "the Applicable License or the ability of the recipient of the Adaptation\n"
        + "to exercise the rights granted to that recipient under the terms of the\n"
        + "Applicable License. You must keep intact all notices that refer to the\n"
        + "Applicable License and to the disclaimer of warranties with every copy\n"
        + "of the Work as included in the Adaptation You Distribute or Publicly\n"
        + "Perform. When You Distribute or Publicly Perform the Adaptation, You may\n"
        + "not impose any effective technological measures on the Adaptation that\n"
        + "restrict the ability of a recipient of the Adaptation from You to\n"
        + "exercise the rights granted to that recipient under the terms of the\n"
        + "Applicable License. This Section 4(b) applies to the Adaptation as\n"
        + "incorporated in a Collection, but this does not require the Collection\n"
        + "apart from the Adaptation itself to be made subject to the terms of the\n"
        + "Applicable License.\n"
        + "\n"
        + "c. You may not exercise any of the rights granted to You in Section 3\n"
        + "above in any manner that is primarily intended for or directed toward\n"
        + "commercial advantage or private monetary compensation. The exchange of\n"
        + "the Work for other copyrighted works by means of digital file-sharing or\n"
        + "otherwise shall not be considered to be intended for or directed toward\n"
        + "commercial advantage or private monetary compensation, provided there is\n"
        + "no payment of any monetary compensation in con-nection with the exchange\n"
        + "of copyrighted works.\n"
        + "\n"
        + "d. If You Distribute, or Publicly Perform the Work or any Adaptations or\n"
        + "Collections, You must, unless a request has been made pursuant to\n"
        + "Section 4(a), keep intact all copyright notices for the Work and\n"
        + "provide, reasonable to the medium or means You are utilizing: (i) the\n"
        + "name of the Original Author (or pseudonym, if applicable) if supplied,\n"
        + "and/or if the Original Author and/or Licensor designate another party or\n"
        + "parties (e.g., a sponsor institute, publishing entity, journal) for\n"
        + "attribution (\"Attribution Parties\") in Licensor's copyright notice,\n"
        + "terms of service or by other reasonable means, the name of such party or\n"
        + "parties; (ii) the title of the Work if supplied; (iii) to the extent\n"
        + "reasonably practicable, the URI, if any, that Licensor specifies to be\n"
        + "associated with the Work, unless such URI does not refer to the\n"
        + "copyright notice or licensing information for the Work; and, (iv)\n"
        + "consistent with Section 3(b), in the case of an Adaptation, a credit\n"
        + "identifying the use of the Work in the Adaptation (e.g., \"French\n"
        + "translation of the Work by Original Author,\" or \"Screenplay based on\n"
        + "original Work by Original Author\"). The credit required by this Section\n"
        + "4(d) may be implemented in any reasonable manner; provided, however,\n"
        + "that in the case of a Adaptation or Collection, at a minimum such credit\n"
        + "will appear, if a credit for all contributing authors of the Adaptation\n"
        + "or Collection appears, then as part of these credits and in a manner at\n"
        + "least as prominent as the credits for the other contributing authors.\n"
        + "For the avoidance of doubt, You may only use the credit required by this\n"
        + "Section for the purpose of attribution in the manner set out above and,\n"
        + "by exercising Your rights under this License, You may not implicitly or\n"
        + "explicitly assert or imply any connection with, sponsorship or\n"
        + "endorsement by the Original Author, Licensor and/or Attribution Parties,\n"
        + "as appropriate, of You or Your use of the Work, without the separate,\n"
        + "express prior written permission of the Original Author, Licensor and/or\n"
        + "Attribution Parties.\n"
        + "\n"
        + "e. For the avoidance of doubt:\n"
        + "\n"
        + "i. Non-waivable Compulsory License Schemes. In those jurisdictions in\n"
        + "which the right to collect royalties through any statutory or compulsory\n"
        + "licensing scheme cannot be waived, the Licensor reserves the exclusive\n"
        + "right to collect such royalties for any exercise by You of the rights\n"
        + "granted under this License;\n"
        + "\n"
        + "ii. Waivable Compulsory License Schemes. In those jurisdictions in which\n"
        + "the right to collect royalties through any statutory or compulsory\n"
        + "licensing scheme can be waived, the Licensor reserves the exclusive\n"
        + "right to collect such royalties for any exercise by You of the rights\n"
        + "granted under this License if Your exercise of such rights is for a\n"
        + "purpose or use which is otherwise than noncommercial as permitted under\n"
        + "Section 4(c) and otherwise waives the right to collect royalties through\n"
        + "any statutory or compulsory licensing scheme; and,\n"
        + "\n"
        + "iii. Voluntary License Schemes. The Licensor reserves the right to\n"
        + "collect royalties, whether individually or, in the event that the\n"
        + "Licensor is a member of a collecting society that administers voluntary\n"
        + "licensing schemes, via that society, from any exercise by You of the\n"
        + "rights granted under this License that is for a purpose or use which is\n"
        + "otherwise than noncommercial as permitted under Section 4(c).\n"
        + "\n"
        + "f. Except as otherwise agreed in writing by the Licensor or as may be\n"
        + "otherwise permitted by applicable law, if You Reproduce, Distribute or\n"
        + "Publicly Perform the Work either by itself or as part of any Adaptations\n"
        + "or Collections, You must not distort, mutilate, modify or take other\n"
        + "derogatory action in relation to the Work which would be prejudicial to\n"
        + "the Original Author's honor or reputation. Licensor agrees that in those\n"
        + "jurisdictions (e.g. Japan), in which any exercise of the right granted\n"
        + "in Section 3(b) of this License (the right to make Adaptations) would be\n"
        + "deemed to be a distortion, mutilation, modification or other derogatory\n"
        + "action prejudicial to the Original Author's honor and reputation, the\n"
        + "Licensor will waive or not assert, as appropriate, this Section, to the\n"
        + "fullest extent permitted by the applicable national law, to enable You\n"
        + "to reasonably exercise Your right under Section 3(b) of this License\n"
        + "(right to make Adaptations) but not otherwise.\n"
        + "\n"
        + "5. Representations, Warranties and Disclaimer\n"
        + "\n"
        + "UNLESS OTHERWISE MUTUALLY AGREED TO BY THE PARTIES IN WRITING AND TO THE\n"
        + "FULLEST EXTENT PERMITTED BY APPLICABLE LAW, LICENSOR OFFERS THE WORK\n"
        + "AS-IS AND MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING\n"
        + "THE WORK, EXPRESS, IMPLIED, STATUTORY OR OTHERWISE, INCLUDING, WITHOUT\n"
        + "LIMITATION, WARRANTIES OF TITLE, MERCHANTABILITY, FITNESS FOR A\n"
        + "PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER\n"
        + "DEFECTS, ACCURACY, OR THE PRESENCE OF ABSENCE OF ERRORS, WHETHER OR NOT\n"
        + "DISCOVERABLE. SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OF IMPLIED\n"
        + "WARRANTIES, SO THIS EXCLUSION MAY NOT APPLY TO YOU.\n"
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
        + "Individuals or entities who have received Adaptations or Collections\n"
        + "from You under this License, however, will not have their licenses\n"
        + "terminated provided such individuals or entities remain in full\n"
        + "compliance with those licenses. Sections 1, 2, 5, 6, 7, and 8 will\n"
        + "survive any termination of this License.\n"
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
        + "b. Each time You Distribute or Publicly Perform an Adaptation, Licensor\n"
        + "offers to the recipient a license to the original Work on the same terms\n"
        + "and conditions as the license granted to You under this License.\n"
        + "\n"
        + "c. If any provision of this License is invalid or unenforceable under\n"
        + "applicable law, it shall not affect the validity or enforceability of\n"
        + "the remainder of the terms of this License, and without further action\n"
        + "by the parties to this agreement, such provision shall be reformed to\n"
        + "the minimum extent necessary to make such provision valid and\n"
        + "enforceable.\n"
        + "\n"
        + "d. No term or provision of this License shall be deemed waived and no\n"
        + "breach consented to unless such waiver or consent shall be in writing\n"
        + "and signed by the party to be charged with such waiver or consent.\n"
        + "\n"
        + "e. This License constitutes the entire agreement between the parties\n"
        + "with respect to the Work licensed here. There are no understandings,\n"
        + "agreements or representations with respect to the Work not specified\n"
        + "here. Licensor shall not be bound by any additional provisions that may\n"
        + "appear in any communication from You.  This License may not be modified\n"
        + "without the mutual written agreement of the Licensor and You.\n"
        + "\n"
        + "f. The rights granted under, and the subject matter referenced, in this\n"
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
