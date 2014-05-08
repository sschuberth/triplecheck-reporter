package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-04-26T13:44:58Z
 * LicenseName: Apache-2.0
 * FileName: PDDL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */


public class PDDL_1_0 extends License{
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
        return "PDDL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "ODC Public Domain Dedication & License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Open Data Commons - Public Domain Dedication & License (PDDL)\n"
        + "\n"
        + "Preamble \n"
        + "The Open Data Commons � Public Domain Dedication & Licence is a document intende"
        + "d to allow you to freely share, modify, and use this work for any purpose and wi"
        + "thout any restrictions. This licence is intended for use on databases or their c"
        + "ontents (\"data\"), either together or individually.\n"
        + "\n"
        + "Many databases are covered by copyright. Some jurisdictions, mainly in Europe, h"
        + "ave specific special rights that cover databases called the \"sui generis\" databa"
        + "se right. Both of these sets of rights, as well as other legal rights used to pr"
        + "otect databases and data, can create uncertainty or practical difficulty for tho"
        + "se wishing to share databases and their underlying data but retain a limited amo"
        + "unt of rights under a \"some rights reserved\" approach to licensing as outlined i"
        + "n the Science Commons Protocol for Implementing Open Access Data. As a result, t"
        + "his waiver and licence tries to the fullest extent possible to eliminate or full"
        + "y license any rights that cover this database and data. Any Community Norms or s"
        + "imilar statements of use of the database or data do not form a part of this docu"
        + "ment, and do not act as a contract for access or other terms of use for the data"
        + "base or data.\n"
        + "\n"
        + "The position of the recipient of the work\n"
        + "\n"
        + "Because this document places the database and its contents in or as close as pos"
        + "sible within the public domain, there are no restrictions or requirements placed"
        + " on the recipient by this document. Recipients may use this work commercially, u"
        + "se technical protection measures, combine this data or database with other datab"
        + "ases or data, and share their changes and additions or keep them secret. It is n"
        + "ot a requirement that recipients provide further users with a copy of this licen"
        + "ce or attribute the original creator of the data or database as a source. The go"
        + "al is to eliminate restrictions held by the original creator of the data and dat"
        + "abase on the use of it by others.\n"
        + "\n"
        + "The position of the dedicator of the work\n"
        + "\n"
        + "Copyright law, as with most other law under the banner of \"intellectual property"
        + "\", is inherently national law. This means that there exists several differences "
        + "in how copyright and other IP rights can be relinquished, waived or licensed in "
        + "the many legal jurisdictions of the world. This is despite much harmonisation of"
        + " minimum levels of protection. The internet and other communication technologies"
        + " span these many disparate legal jurisdictions and thus pose special difficultie"
        + "s for a document relinquishing and waiving intellectual property rights, includi"
        + "ng copyright and database rights, for use by the global community. Because of th"
        + "is feature of intellectual property law, this document first relinquishes the ri"
        + "ghts and waives the relevant rights and claims. It then goes on to license these"
        + " same rights for jurisdictions or areas of law that may make it difficult to rel"
        + "inquish or waive rights or claims.\n"
        + "\n"
        + "The purpose of this document is to enable rightsholders to place their work into"
        + " the public domain. Unlike licences for free and open source software, free cult"
        + "ural works, or open content licences, rightsholders will not be able to \"dual li"
        + "cense\" their work by releasing the same work under different licences. This is b"
        + "ecause they have allowed anyone to use the work in whatever way they choose. Rig"
        + "htsholders therefore can’t re-license it under copyright or database rights on d"
        + "ifferent terms because they have nothing left to license. Doing so creates truly"
        + " accessible data to build rich applications and advance the progress of science "
        + "and the arts.\n"
        + "\n"
        + "This document can cover either or both of the database and its contents (the dat"
        + "a). Because databases can have a wide variety of content � not just factual data"
        + " � rightsholders should use the Open Data Commons � Public Domain Dedication & L"
        + "icence for an entire database and its contents only if everything can be placed "
        + "under the terms of this document. Because even factual data can sometimes have i"
        + "ntellectual property rights, rightsholders should use this licence to cover both"
        + " the database and its factual data when making material available under this doc"
        + "ument; even if it is likely that the data would not be covered by copyright or d"
        + "atabase rights.\n"
        + "\n"
        + "Rightsholders can also use this document to cover any copyright or database righ"
        + "ts claims over only a database, and leave the contents to be covered by other li"
        + "cences or documents. They can do this because this document refers to the \"Work\""
        + ", which can be either � or both � the database and its contents. As a result, ri"
        + "ghtsholders need to clearly state what they are dedicating under this document w"
        + "hen they dedicate it.\n"
        + "\n"
        + "Just like any licence or other document dealing with intellectual property, righ"
        + "tsholders should be aware that one can only license what one owns. Please ensure"
        + " that the rights have been cleared to make this material available under this do"
        + "cument.\n"
        + "\n"
        + "This document permanently and irrevocably makes the Work available to the public"
        + " for any use of any kind, and it should not be used unless the rightsholder is p"
        + "repared for this to happen.\n"
        + "\n"
        + "Part I: Introduction\n"
        + "\n"
        + "The Rightsholder (the Person holding rights or claims over the Work) agrees as f"
        + "ollows:\n"
        + "\n"
        + "1.0 Definitions of Capitalised Words\n"
        + "\n"
        + "\"Copyright\" � Includes rights under copyright and under neighbouring rights and "
        + "similarly related sets of rights under the law of the relevant jurisdiction unde"
        + "r Section 6.4.\n"
        + "\n"
        + "\"Data\" � The contents of the Database, which includes the information, independe"
        + "nt works, or other material collected into the Database offered under the terms "
        + "of this Document.\n"
        + "\n"
        + "\"Database\" � A collection of Data arranged in a systematic or methodical way and"
        + " individually accessible by electronic or other means offered under the terms of"
        + " this Document.\n"
        + "\n"
        + "\"Database Right\" � Means rights over Data resulting from the Chapter III (\"sui g"
        + "eneris\") rights in the Database Directive (Directive 96/9/EC of the European Par"
        + "liament and of the Council of 11 March 1996 on the legal protection of databases"
        + ") and any future updates as well as any similar rights available in the relevant"
        + " jurisdiction under Section 6.4.\n"
        + "\n"
        + "\"Document\" � means this relinquishment and waiver of rights and claims and back "
        + "up licence agreement.\n"
        + "\n"
        + "\"Person\" � Means a natural or legal person or a body of persons corporate or inc"
        + "orporate.\n"
        + "\n"
        + "\"Use\" � As a verb, means doing any act that is restricted by Copyright or Databa"
        + "se Rights whether in the original medium or any other; and includes modifying th"
        + "e Work as may be technically necessary to use it in a different mode or format. "
        + "This includes the right to sublicense the Work.\n"
        + "\n"
        + "\"Work\" � Means either or both of the Database and Data offered under the terms o"
        + "f this Document.\n"
        + "\n"
        + "\"You\" � the Person acquiring rights under the licence elements of this Document.\n"
        + "\n"
        + "Words in the singular include the plural and vice versa.\n"
        + "\n"
        + "2.0 What this document covers\n"
        + "\n"
        + "2.1. Legal effect of this Document. This Document is:\n"
        + "\n"
        + "a. A dedication to the public domain and waiver of Copyright and Database Rights"
        + " over the Work; and\n"
        + "\n"
        + "b. A licence of Copyright and Database Rights over the Work in jurisdictions tha"
        + "t do not allow for relinquishment or waiver.\n"
        + "\n"
        + "2.2. Legal rights covered.\n"
        + "\n"
        + "a. Copyright. Any copyright or neighbouring rights in the Work. Copyright law va"
        + "ries between jurisdictions, but is likely to cover: the Database model or schema"
        + ", which is the structure, arrangement, and organisation of the Database, and can"
        + " also include the Database tables and table indexes; the data entry and output s"
        + "heets; and the Field names of Data stored in the Database. Copyright may also co"
        + "ver the Data depending on the jurisdiction and type of Data; and\n"
        + "\n"
        + "b. Database Rights. Database Rights only extend to the extraction and re-utilisa"
        + "tion of the whole or a substantial part of the Data. Database Rights can apply e"
        + "ven when there is no copyright over the Database. Database Rights can also apply"
        + " when the Data is removed from the Database and is selected and arranged in a wa"
        + "y that would not infringe any applicable copyright.\n"
        + "\n"
        + "2.2 Rights not covered.\n"
        + "\n"
        + "a. This Document does not apply to computer programs used in the making or opera"
        + "tion of the Database;\n"
        + "\n"
        + "b. This Document does not cover any patents over the Data or the Database. Pleas"
        + "e see Section 4.2 later in this Document for further details; and\n"
        + "\n"
        + "c. This Document does not cover any trade marks associated with the Database. Pl"
        + "ease see Section 4.3 later in this Document for further details.\n"
        + "\n"
        + "Users of this Database are cautioned that they may have to clear other rights or"
        + " consult other licences.\n"
        + "\n"
        + "2.3 Facts are free. The Rightsholder takes the position that factual information"
        + " is not covered by Copyright. This Document however covers the Work in jurisdict"
        + "ions that may protect the factual information in the Work by Copyright, and to c"
        + "over any information protected by Copyright that is contained in the Work.\n"
        + "\n"
        + "Part II: Dedication to the public domain\n"
        + "\n"
        + "3.0 Dedication, waiver, and licence of Copyright and Database Rights\n"
        + "\n"
        + "3.1 Dedication of Copyright and Database Rights to the public domain. The Rights"
        + "holder by using this Document, dedicates the Work to the public domain for the b"
        + "enefit of the public and relinquishes all rights in Copyright and Database Right"
        + "s over the Work.\n"
        + "\n"
        + "a. The Rightsholder realises that once these rights are relinquished, that the R"
        + "ightsholder has no further rights in Copyright and Database Rights over the Work"
        + ", and that the Work is free and open for others to Use.\n"
        + "\n"
        + "b. The Rightsholder intends for their relinquishment to cover all present and fu"
        + "ture rights in the Work under Copyright and Database Rights, whether they are ve"
        + "sted or contingent rights, and that this relinquishment of rights covers all the"
        + "ir heirs and successors.\n"
        + "\n"
        + "The above relinquishment of rights applies worldwide and includes media and form"
        + "ats now known or created in the future.\n"
        + "\n"
        + "3.2 Waiver of rights and claims in Copyright and Database Rights when Section 3."
        + "1 dedication inapplicable. If the dedication in Section 3.1 does not apply in th"
        + "e relevant jurisdiction under Section 6.4, the Rightsholder waives any rights an"
        + "d claims that the Rightsholder may have or acquire in the future over the Work i"
        + "n:\n"
        + "\n"
        + "a. Copyright; and\n"
        + "\n"
        + "b. Database Rights.\n"
        + "\n"
        + "To the extent possible in the relevant jurisdiction, the above waiver of rights "
        + "and claims applies worldwide and includes media and formats now known or created"
        + " in the future. The Rightsholder agrees not to assert the above rights and waive"
        + "s the right to enforce them over the Work.\n"
        + "\n"
        + "3.3 Licence of Copyright and Database Rights when Sections 3.1 and 3.2 inapplica"
        + "ble. If the dedication and waiver in Sections 3.1 and 3.2 does not apply in the "
        + "relevant jurisdiction under Section 6.4, the Rightsholder and You agree as follo"
        + "ws:\n"
        + "\n"
        + "a. The Licensor grants to You a worldwide, royalty-free, non-exclusive, licence "
        + "to Use the Work for the duration of any applicable Copyright and Database Rights"
        + ". These rights explicitly include commercial use, and do not exclude any field o"
        + "f endeavour. To the extent possible in the relevant jurisdiction, these rights m"
        + "ay be exercised in all media and formats whether now known or created in the fut"
        + "ure.\n"
        + "\n"
        + "3.4 Moral rights. This section covers moral rights, including the right to be id"
        + "entified as the author of the Work or to object to treatment that would otherwis"
        + "e prejudice the author’s honour and reputation, or any other derogatory treatmen"
        + "t:\n"
        + "\n"
        + "a. For jurisdictions allowing waiver of moral rights, Licensor waives all moral "
        + "rights that Licensor may have in the Work to the fullest extent possible by the "
        + "law of the relevant jurisdiction under Section 6.4;\n"
        + "\n"
        + "b. If waiver of moral rights under Section 3.4 a in the relevant jurisdiction is"
        + " not possible, Licensor agrees not to assert any moral rights over the Work and "
        + "waives all claims in moral rights to the fullest extent possible by the law of t"
        + "he relevant jurisdiction under Section 6.4; and\n"
        + "\n"
        + "c. For jurisdictions not allowing waiver or an agreement not to assert moral rig"
        + "hts under Section 3.4 a and b, the author may retain their moral rights over the"
        + " copyrighted aspects of the Work.\n"
        + "\n"
        + "Please note that some jurisdictions do not allow for the waiver of moral rights,"
        + " and so moral rights may still subsist over the work in some jurisdictions.\n"
        + "\n"
        + "4.0 Relationship to other rights\n"
        + "\n"
        + "4.1 No other contractual conditions. The Rightsholder makes this Work available "
        + "to You without any other contractual obligations, either express or implied. Any"
        + " Community Norms statement associated with the Work is not a contract and does n"
        + "ot form part of this Document.\n"
        + "\n"
        + "4.2 Relationship to patents. This Document does not grant You a licence for any "
        + "patents that the Rightsholder may own. Users of this Database are cautioned that"
        + " they may have to clear other rights or consult other licences.\n"
        + "\n"
        + "4.3 Relationship to trade marks. This Document does not grant You a licence for "
        + "any trade marks that the Rightsholder may own or that the Rightsholder may use t"
        + "o cover the Work. Users of this Database are cautioned that they may have to cle"
        + "ar other rights or consult other licences. Part III: General provisions\n"
        + "\n"
        + "5.0 Warranties, disclaimer, and limitation of liability\n"
        + "\n"
        + "5.1 The Work is provided by the Rightsholder \"as is\" and without any warranty of"
        + " any kind, either express or implied, whether of title, of accuracy or completen"
        + "ess, of the presence of absence of errors, of fitness for purpose, or otherwise."
        + " Some jurisdictions do not allow the exclusion of implied warranties, so this ex"
        + "clusion may not apply to You.\n"
        + "\n"
        + "5.2 Subject to any liability that may not be excluded or limited by law, the Rig"
        + "htsholder is not liable for, and expressly excludes, all liability for loss or d"
        + "amage however and whenever caused to anyone by any use under this Document, whet"
        + "her by You or by anyone else, and whether caused by any fault on the part of the"
        + " Rightsholder or not. This exclusion of liability includes, but is not limited t"
        + "o, any special, incidental, consequential, punitive, or exemplary damages. This "
        + "exclusion applies even if the Rightsholder has been advised of the possibility o"
        + "f such damages.\n"
        + "\n"
        + "5.3 If liability may not be excluded by law, it is limited to actual and direct "
        + "financial loss to the extent it is caused by proved negligence on the part of th"
        + "e Rightsholder.\n"
        + "\n"
        + "6.0 General\n"
        + "\n"
        + "6.1 If any provision of this Document is held to be invalid or unenforceable, th"
        + "at must not affect the cvalidity or enforceability of the remainder of the terms"
        + " of this Document.\n"
        + "\n"
        + "6.2 This Document is the entire agreement between the parties with respect to th"
        + "e Work covered here. It replaces any earlier understandings, agreements or repre"
        + "sentations with respect to the Work not specified here.\n"
        + "\n"
        + "6.3 This Document does not affect any rights that You or anyone else may indepen"
        + "dently have under any applicable law to make any use of this Work, including (fo"
        + "r jurisdictions where this Document is a licence) fair dealing, fair use, databa"
        + "se exceptions, or any other legally recognised limitation or exception to infrin"
        + "gement of copyright or other applicable laws.\n"
        + "\n"
        + "6.4 This Document takes effect in the relevant jurisdiction in which the Documen"
        + "t terms are sought to be enforced. If the rights waived or granted under applica"
        + "ble law in the relevant jurisdiction includes additional rights not waived or gr"
        + "anted under this Document, these additional rights are included in this Document"
        + " in order to meet the intent of this Document.\n"
; // the license text
    }
 
    
}
