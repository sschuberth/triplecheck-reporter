package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:32:24Z
 * LicenseName: Apache-2.0
 * FileName: GFDL_1_2.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class GFDL_1_2 extends License{
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
        return "GFDL-1.2"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU Free Documentation License v1.2"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "                GNU Free Documentation License\n"
        + "                  Version 1.2, November 2002\n"
        + "\n"
        + "\n"
        + " Copyright (C) 2000,2001,2002  Free Software Foundation, Inc.\n"
        + "     51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA\n"
        + " Everyone is permitted to copy and distribute verbatim copies\n"
        + " of this license document, but changing it is not allowed.\n"
        + "\n"
        + "\n"
        + "0. PREAMBLE\n"
        + "\n"
        + "The purpose of this License is to make a manual, textbook, or other\n"
        + "functional and useful document \"free\" in the sense of freedom: to\n"
        + "assure everyone the effective freedom to copy and redistribute it,\n"
        + "with or without modifying it, either commercially or noncommercially.\n"
        + "Secondarily, this License preserves for the author and publisher a way\n"
        + "to get credit for their work, while not being considered responsible\n"
        + "for modifications made by others.\n"
        + "\n"
        + "This License is a kind of \"copyleft\", which means that derivative\n"
        + "works of the document must themselves be free in the same sense.  It\n"
        + "complements the GNU General Public License, which is a copyleft\n"
        + "license designed for free software.\n"
        + "\n"
        + "We have designed this License in order to use it for manuals for free\n"
        + "software, because free software needs free documentation: a free\n"
        + "program should come with manuals providing the same freedoms that the\n"
        + "software does.  But this License is not limited to software manuals;\n"
        + "it can be used for any textual work, regardless of subject matter or\n"
        + "whether it is published as a printed book.  We recommend this License\n"
        + "principally for works whose purpose is instruction or reference.\n"
        + "\n"
        + "\n"
        + "1. APPLICABILITY AND DEFINITIONS\n"
        + "\n"
        + "This License applies to any manual or other work, in any medium, that\n"
        + "contains a notice placed by the copyright holder saying it can be\n"
        + "distributed under the terms of this License.  Such a notice grants a\n"
        + "world-wide, royalty-free license, unlimited in duration, to use that\n"
        + "work under the conditions stated herein.  The \"Document\", below,\n"
        + "refers to any such manual or work.  Any member of the public is a\n"
        + "licensee, and is addressed as \"you\".  You accept the license if you\n"
        + "copy, modify or distribute the work in a way requiring permission\n"
        + "under copyright law.\n"
        + "\n"
        + "A \"Modified Version\" of the Document means any work containing the\n"
        + "Document or a portion of it, either copied verbatim, or with\n"
        + "modifications and/or translated into another language.\n"
        + "\n"
        + "A \"Secondary Section\" is a named appendix or a front-matter section of\n"
        + "the Document that deals exclusively with the relationship of the\n"
        + "publishers or authors of the Document to the Document's overall subject\n"
        + "(or to related matters) and contains nothing that could fall directly\n"
        + "within that overall subject.  (Thus, if the Document is in part a\n"
        + "textbook of mathematics, a Secondary Section may not explain any\n"
        + "mathematics.)  The relationship could be a matter of historical\n"
        + "connection with the subject or with related matters, or of legal,\n"
        + "commercial, philosophical, ethical or political position regarding\n"
        + "them.\n"
        + "\n"
        + "The \"Invariant Sections\" are certain Secondary Sections whose titles\n"
        + "are designated, as being those of Invariant Sections, in the notice\n"
        + "that says that the Document is released under this License.  If a\n"
        + "section does not fit the above definition of Secondary then it is not\n"
        + "allowed to be designated as Invariant.  The Document may contain zero\n"
        + "Invariant Sections.  If the Document does not identify any Invariant\n"
        + "Sections then there are none.\n"
        + "\n"
        + "The \"Cover Texts\" are certain short passages of text that are listed,\n"
        + "as Front-Cover Texts or Back-Cover Texts, in the notice that says that\n"
        + "the Document is released under this License.  A Front-Cover Text may\n"
        + "be at most 5 words, and a Back-Cover Text may be at most 25 words.\n"
        + "\n"
        + "A \"Transparent\" copy of the Document means a machine-readable copy,\n"
        + "represented in a format whose specification is available to the\n"
        + "general public, that is suitable for revising the document\n"
        + "straightforwardly with generic text editors or (for images composed of\n"
        + "pixels) generic paint programs or (for drawings) some widely available\n"
        + "drawing editor, and that is suitable for input to text formatters or\n"
        + "for automatic translation to a variety of formats suitable for input\n"
        + "to text formatters.  A copy made in an otherwise Transparent file\n"
        + "format whose markup, or absence of markup, has been arranged to thwart\n"
        + "or discourage subsequent modification by readers is not Transparent.\n"
        + "An image format is not Transparent if used for any substantial amount\n"
        + "of text.  A copy that is not \"Transparent\" is called \"Opaque\".\n"
        + "\n"
        + "Examples of suitable formats for Transparent copies include plain\n"
        + "ASCII without markup, Texinfo input format, LaTeX input format, SGML\n"
        + "or XML using a publicly available DTD, and standard-conforming simple\n"
        + "HTML, PostScript or PDF designed for human modification.  Examples of\n"
        + "transparent image formats include PNG, XCF and JPG.  Opaque formats\n"
        + "include proprietary formats that can be read and edited only by\n"
        + "proprietary word processors, SGML or XML for which the DTD and/or\n"
        + "processing tools are not generally available, and the\n"
        + "machine-generated HTML, PostScript or PDF produced by some word\n"
        + "processors for output purposes only.\n"
        + "\n"
        + "The \"Title Page\" means, for a printed book, the title page itself,\n"
        + "plus such following pages as are needed to hold, legibly, the material\n"
        + "this License requires to appear in the title page.  For works in\n"
        + "formats which do not have any title page as such, \"Title Page\" means\n"
        + "the text near the most prominent appearance of the work's title,\n"
        + "preceding the beginning of the body of the text.\n"
        + "\n"
        + "A section \"Entitled XYZ\" means a named subunit of the Document whose\n"
        + "title either is precisely XYZ or contains XYZ in parentheses following\n"
        + "text that translates XYZ in another language.  (Here XYZ stands for a\n"
        + "specific section name mentioned below, such as \"Acknowledgements\",\n"
        + "\"Dedications\", \"Endorsements\", or \"History\".)  To \"Preserve the Title\"\n"
        + "of such a section when you modify the Document means that it remains a\n"
        + "section \"Entitled XYZ\" according to this definition.\n"
        + "\n"
        + "The Document may include Warranty Disclaimers next to the notice which\n"
        + "states that this License applies to the Document.  These Warranty\n"
        + "Disclaimers are considered to be included by reference in this\n"
        + "License, but only as regards disclaiming warranties: any other\n"
        + "implication that these Warranty Disclaimers may have is void and has\n"
        + "no effect on the meaning of this License.\n"
        + "\n"
        + "\n"
        + "2. VERBATIM COPYING\n"
        + "\n"
        + "You may copy and distribute the Document in any medium, either\n"
        + "commercially or noncommercially, provided that this License, the\n"
        + "copyright notices, and the license notice saying this License applies\n"
        + "to the Document are reproduced in all copies, and that you add no other\n"
        + "conditions whatsoever to those of this License.  You may not use\n"
        + "technical measures to obstruct or control the reading or further\n"
        + "copying of the copies you make or distribute.  However, you may accept\n"
        + "compensation in exchange for copies.  If you distribute a large enough\n"
        + "number of copies you must also follow the conditions in section 3.\n"
        + "\n"
        + "You may also lend copies, under the same conditions stated above, and\n"
        + "you may publicly display copies.\n"
        + "\n"
        + "\n"
        + "3. COPYING IN QUANTITY\n"
        + "\n"
        + "If you publish printed copies (or copies in media that commonly have\n"
        + "printed covers) of the Document, numbering more than 100, and the\n"
        + "Document's license notice requires Cover Texts, you must enclose the\n"
        + "copies in covers that carry, clearly and legibly, all these Cover\n"
        + "Texts: Front-Cover Texts on the front cover, and Back-Cover Texts on\n"
        + "the back cover.  Both covers must also clearly and legibly identify\n"
        + "you as the publisher of these copies.  The front cover must present\n"
        + "the full title with all words of the title equally prominent and\n"
        + "visible.  You may add other material on the covers in addition.\n"
        + "Copying with changes limited to the covers, as long as they preserve\n"
        + "the title of the Document and satisfy these conditions, can be treated\n"
        + "as verbatim copying in other respects.\n"
        + "\n"
        + "If the required texts for either cover are too voluminous to fit\n"
        + "legibly, you should put the first ones listed (as many as fit\n"
        + "reasonably) on the actual cover, and continue the rest onto adjacent\n"
        + "pages.\n"
        + "\n"
        + "If you publish or distribute Opaque copies of the Document numbering\n"
        + "more than 100, you must either include a machine-readable Transparent\n"
        + "copy along with each Opaque copy, or state in or with each Opaque copy\n"
        + "a computer-network location from which the general network-using\n"
        + "public has access to download using public-standard network protocols\n"
        + "a complete Transparent copy of the Document, free of added material.\n"
        + "If you use the latter option, you must take reasonably prudent steps,\n"
        + "when you begin distribution of Opaque copies in quantity, to ensure\n"
        + "that this Transparent copy will remain thus accessible at the stated\n"
        + "location until at least one year after the last time you distribute an\n"
        + "Opaque copy (directly or through your agents or retailers) of that\n"
        + "edition to the public.\n"
        + "\n"
        + "It is requested, but not required, that you contact the authors of the\n"
        + "Document well before redistributing any large number of copies, to give\n"
        + "them a chance to provide you with an updated version of the Document.\n"
        + "\n"
        + "\n"
        + "4. MODIFICATIONS\n"
        + "\n"
        + "You may copy and distribute a Modified Version of the Document under\n"
        + "the conditions of sections 2 and 3 above, provided that you release\n"
        + "the Modified Version under precisely this License, with the Modified\n"
        + "Version filling the role of the Document, thus licensing distribution\n"
        + "and modification of the Modified Version to whoever possesses a copy\n"
        + "of it.  In addition, you must do these things in the Modified Version:\n"
        + "\n"
        + "A. Use in the Title Page (and on the covers, if any) a title distinct\n"
        + "   from that of the Document, and from those of previous versions\n"
        + "   (which should, if there were any, be listed in the History section\n"
        + "   of the Document).  You may use the same title as a previous version\n"
        + "   if the original publisher of that version gives permission.\n"
        + "B. List on the Title Page, as authors, one or more persons or entities\n"
        + "   responsible for authorship of the modifications in the Modified\n"
        + "   Version, together with at least five of the principal authors of the\n"
        + "   Document (all of its principal authors, if it has fewer than five),\n"
        + "   unless they release you from this requirement.\n"
        + "C. State on the Title page the name of the publisher of the\n"
        + "   Modified Version, as the publisher.\n"
        + "D. Preserve all the copyright notices of the Document.\n"
        + "E. Add an appropriate copyright notice for your modifications\n"
        + "   adjacent to the other copyright notices.\n"
        + "F. Include, immediately after the copyright notices, a license notice\n"
        + "   giving the public permission to use the Modified Version under the\n"
        + "   terms of this License, in the form shown in the Addendum below.\n"
        + "G. Preserve in that license notice the full lists of Invariant Sections\n"
        + "   and required Cover Texts given in the Document's license notice.\n"
        + "H. Include an unaltered copy of this License.\n"
        + "I. Preserve the section Entitled \"History\", Preserve its Title, and add\n"
        + "   to it an item stating at least the title, year, new authors, and\n"
        + "   publisher of the Modified Version as given on the Title Page.  If\n"
        + "   there is no section Entitled \"History\" in the Document, create one\n"
        + "   stating the title, year, authors, and publisher of the Document as\n"
        + "   given on its Title Page, then add an item describing the Modified\n"
        + "   Version as stated in the previous sentence.\n"
        + "J. Preserve the network location, if any, given in the Document for\n"
        + "   public access to a Transparent copy of the Document, and likewise\n"
        + "   the network locations given in the Document for previous versions\n"
        + "   it was based on.  These may be placed in the \"History\" section.\n"
        + "   You may omit a network location for a work that was published at\n"
        + "   least four years before the Document itself, or if the original\n"
        + "   publisher of the version it refers to gives permission.\n"
        + "K. For any section Entitled \"Acknowledgements\" or \"Dedications\",\n"
        + "   Preserve the Title of the section, and preserve in the section all\n"
        + "   the substance and tone of each of the contributor acknowledgements\n"
        + "   and/or dedications given therein.\n"
        + "L. Preserve all the Invariant Sections of the Document,\n"
        + "   unaltered in their text and in their titles.  Section numbers\n"
        + "   or the equivalent are not considered part of the section titles.\n"
        + "M. Delete any section Entitled \"Endorsements\".  Such a section\n"
        + "   may not be included in the Modified Version.\n"
        + "N. Do not retitle any existing section to be Entitled \"Endorsements\"\n"
        + "   or to conflict in title with any Invariant Section.\n"
        + "O. Preserve any Warranty Disclaimers.\n"
        + "\n"
        + "If the Modified Version includes new front-matter sections or\n"
        + "appendices that qualify as Secondary Sections and contain no material\n"
        + "copied from the Document, you may at your option designate some or all\n"
        + "of these sections as invariant.  To do this, add their titles to the\n"
        + "list of Invariant Sections in the Modified Version's license notice.\n"
        + "These titles must be distinct from any other section titles.\n"
        + "\n"
        + "You may add a section Entitled \"Endorsements\", provided it contains\n"
        + "nothing but endorsements of your Modified Version by various\n"
        + "parties--for example, statements of peer review or that the text has\n"
        + "been approved by an organization as the authoritative definition of a\n"
        + "standard.\n"
        + "\n"
        + "You may add a passage of up to five words as a Front-Cover Text, and a\n"
        + "passage of up to 25 words as a Back-Cover Text, to the end of the list\n"
        + "of Cover Texts in the Modified Version.  Only one passage of\n"
        + "Front-Cover Text and one of Back-Cover Text may be added by (or\n"
        + "through arrangements made by) any one entity.  If the Document already\n"
        + "includes a cover text for the same cover, previously added by you or\n"
        + "by arrangement made by the same entity you are acting on behalf of,\n"
        + "you may not add another; but you may replace the old one, on explicit\n"
        + "permission from the previous publisher that added the old one.\n"
        + "\n"
        + "The author(s) and publisher(s) of the Document do not by this License\n"
        + "give permission to use their names for publicity for or to assert or\n"
        + "imply endorsement of any Modified Version.\n"
        + "\n"
        + "\n"
        + "5. COMBINING DOCUMENTS\n"
        + "\n"
        + "You may combine the Document with other documents released under this\n"
        + "License, under the terms defined in section 4 above for modified\n"
        + "versions, provided that you include in the combination all of the\n"
        + "Invariant Sections of all of the original documents, unmodified, and\n"
        + "list them all as Invariant Sections of your combined work in its\n"
        + "license notice, and that you preserve all their Warranty Disclaimers.\n"
        + "\n"
        + "The combined work need only contain one copy of this License, and\n"
        + "multiple identical Invariant Sections may be replaced with a single\n"
        + "copy.  If there are multiple Invariant Sections with the same name but\n"
        + "different contents, make the title of each such section unique by\n"
        + "adding at the end of it, in parentheses, the name of the original\n"
        + "author or publisher of that section if known, or else a unique number.\n"
        + "Make the same adjustment to the section titles in the list of\n"
        + "Invariant Sections in the license notice of the combined work.\n"
        + "\n"
        + "In the combination, you must combine any sections Entitled \"History\"\n"
        + "in the various original documents, forming one section Entitled\n"
        + "\"History\"; likewise combine any sections Entitled \"Acknowledgements\",\n"
        + "and any sections Entitled \"Dedications\".  You must delete all sections\n"
        + "Entitled \"Endorsements\".\n"
        + "\n"
        + "\n"
        + "6. COLLECTIONS OF DOCUMENTS\n"
        + "\n"
        + "You may make a collection consisting of the Document and other documents\n"
        + "released under this License, and replace the individual copies of this\n"
        + "License in the various documents with a single copy that is included in\n"
        + "the collection, provided that you follow the rules of this License for\n"
        + "verbatim copying of each of the documents in all other respects.\n"
        + "\n"
        + "You may extract a single document from such a collection, and distribute\n"
        + "it individually under this License, provided you insert a copy of this\n"
        + "License into the extracted document, and follow this License in all\n"
        + "other respects regarding verbatim copying of that document.\n"
        + "\n"
        + "\n"
        + "7. AGGREGATION WITH INDEPENDENT WORKS\n"
        + "\n"
        + "A compilation of the Document or its derivatives with other separate\n"
        + "and independent documents or works, in or on a volume of a storage or\n"
        + "distribution medium, is called an \"aggregate\" if the copyright\n"
        + "resulting from the compilation is not used to limit the legal rights\n"
        + "of the compilation's users beyond what the individual works permit.\n"
        + "When the Document is included in an aggregate, this License does not\n"
        + "apply to the other works in the aggregate which are not themselves\n"
        + "derivative works of the Document.\n"
        + "\n"
        + "If the Cover Text requirement of section 3 is applicable to these\n"
        + "copies of the Document, then if the Document is less than one half of\n"
        + "the entire aggregate, the Document's Cover Texts may be placed on\n"
        + "covers that bracket the Document within the aggregate, or the\n"
        + "electronic equivalent of covers if the Document is in electronic form.\n"
        + "Otherwise they must appear on printed covers that bracket the whole\n"
        + "aggregate.\n"
        + "\n"
        + "\n"
        + "8. TRANSLATION\n"
        + "\n"
        + "Translation is considered a kind of modification, so you may\n"
        + "distribute translations of the Document under the terms of section 4.\n"
        + "Replacing Invariant Sections with translations requires special\n"
        + "permission from their copyright holders, but you may include\n"
        + "translations of some or all Invariant Sections in addition to the\n"
        + "original versions of these Invariant Sections.  You may include a\n"
        + "translation of this License, and all the license notices in the\n"
        + "Document, and any Warranty Disclaimers, provided that you also include\n"
        + "the original English version of this License and the original versions\n"
        + "of those notices and disclaimers.  In case of a disagreement between\n"
        + "the translation and the original version of this License or a notice\n"
        + "or disclaimer, the original version will prevail.\n"
        + "\n"
        + "If a section in the Document is Entitled \"Acknowledgements\",\n"
        + "\"Dedications\", or \"History\", the requirement (section 4) to Preserve\n"
        + "its Title (section 1) will typically require changing the actual\n"
        + "title.\n"
        + "\n"
        + "\n"
        + "9. TERMINATION\n"
        + "\n"
        + "You may not copy, modify, sublicense, or distribute the Document except\n"
        + "as expressly provided for under this License.  Any other attempt to\n"
        + "copy, modify, sublicense or distribute the Document is void, and will\n"
        + "automatically terminate your rights under this License.  However,\n"
        + "parties who have received copies, or rights, from you under this\n"
        + "License will not have their licenses terminated so long as such\n"
        + "parties remain in full compliance.\n"
        + "\n"
        + "\n"
        + "10. FUTURE REVISIONS OF THIS LICENSE\n"
        + "\n"
        + "The Free Software Foundation may publish new, revised versions\n"
        + "of the GNU Free Documentation License from time to time.  Such new\n"
        + "versions will be similar in spirit to the present version, but may\n"
        + "differ in detail to address new problems or concerns.  See\n"
        + "http://www.gnu.org/copyleft/.\n"
        + "\n"
        + "Each version of the License is given a distinguishing version number.\n"
        + "If the Document specifies that a particular numbered version of this\n"
        + "License \"or any later version\" applies to it, you have the option of\n"
        + "following the terms and conditions either of that specified version or\n"
        + "of any later version that has been published (not as a draft) by the\n"
        + "Free Software Foundation.  If the Document does not specify a version\n"
        + "number of this License, you may choose any version ever published (not\n"
        + "as a draft) by the Free Software Foundation.\n"
        + "\n"
        + "\n"
        + "ADDENDUM: How to use this License for your documents\n"
        + "\n"
        + "To use this License in a document you have written, include a copy of\n"
        + "the License in the document and put the following copyright and\n"
        + "license notices just after the title page:\n"
        + "\n"
        + "    Copyright (c)  YEAR  YOUR NAME.\n"
        + "    Permission is granted to copy, distribute and/or modify this document\n"
        + "    under the terms of the GNU Free Documentation License, Version 1.2\n"
        + "    or any later version published by the Free Software Foundation;\n"
        + "    with no Invariant Sections, no Front-Cover Texts, and no Back-Cover Texts.\n"
        + "    A copy of the license is included in the section entitled \"GNU\n"
        + "    Free Documentation License\".\n"
        + "\n"
        + "If you have Invariant Sections, Front-Cover Texts and Back-Cover Texts,\n"
        + "replace the \"with...Texts.\" line with this:\n"
        + "\n"
        + "    with the Invariant Sections being LIST THEIR TITLES, with the\n"
        + "    Front-Cover Texts being LIST, and with the Back-Cover Texts being LIST.\n"
        + "\n"
        + "If you have Invariant Sections without Cover Texts, or some other\n"
        + "combination of the three, merge those two alternatives to suit the\n"
        + "situation.\n"
        + "\n"
        + "If your document contains nontrivial examples of program code, we\n"
        + "recommend releasing these examples in parallel under your choice of\n"
        + "free software license, such as the GNU General Public License,\n"
        + "to permit their use in free software.\n"
; // the license text
    }
 
    
}
