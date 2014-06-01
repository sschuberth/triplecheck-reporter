package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:46Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: OFL_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class OFL_1_0 extends License{
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
        return "OFL-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "SIL Open Font License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "SIL OPEN FONT LICENSE\n"
        + "\n"
        + "Version 1.0 - 22 November 2005\n"
        + "\n"
        + "PREAMBLE\n"
        + "The goals of the Open Font License (OFL) are to stimulate worldwide\n"
        + "development of cooperative font projects, to support the font creation\n"
        + "efforts of academic and linguistic communities, and to provide an open\n"
        + "framework in which fonts may be shared and improved in partnership with\n"
        + "others.\n"
        + "\n"
        + "The OFL allows the licensed fonts to be used, studied, modified and\n"
        + "redistributed freely as long as they are not sold by themselves. The\n"
        + "fonts, including any derivative works, can be bundled, embedded, \n"
        + "redistributed and sold with any software provided that the font\n"
        + "names of derivative works are changed. The fonts and derivatives,\n"
        + "however, cannot be released under any other type of license.\n"
        + "\n"
        + "DEFINITIONS\n"
        + "\"Font Software\" refers to any and all of the following:\n"
        + "\n"
        + "font files\n"
        + "data files\n"
        + "source code\n"
        + "build scripts\n"
        + "documentation\n"
        + "\"Reserved Font Name\" refers to the Font Software name as seen by\n"
        + "users and any other names as specified after the copyright statement.\n"
        + "\n"
        + "\"Standard Version\" refers to the collection of Font Software\n"
        + "components as distributed by the Copyright Holder.\n"
        + "\n"
        + "\"Modified Version\" refers to any derivative font software made by\n"
        + "adding to, deleting, or substituting — in part or in whole --\n"
        + "any of the components of the Standard Version, by changing formats\n"
        + "or by porting the Font Software to a new environment.\n"
        + "\n"
        + "\"Author\" refers to any designer, engineer, programmer, technical\n"
        + "writer or other person who contributed to the Font Software.\n"
        + "\n"
        + "PERMISSION & CONDITIONS\n"
        + "Permission is hereby granted, free of charge, to any person obtaining\n"
        + "a copy of the Font Software, to use, study, copy, merge, embed, modify,\n"
        + "redistribute, and sell modified and unmodified copies of the Font\n"
        + "Software, subject to the following conditions:\n"
        + "\n"
        + "1) Neither the Font Software nor any of its individual components,\n"
        + "in Standard or Modified Versions, may be sold by itself.\n"
        + "\n"
        + "2) Standard or Modified Versions of the Font Software may be bundled,\n"
        + "redistributed and sold with any software, provided that each copy\n"
        + "contains the above copyright notice and this license. These can be\n"
        + "included either as stand-alone text files, human-readable headers or\n"
        + "in the appropriate machine-readable metadata fields within text or\n"
        + "binary files as long as those fields can be easily viewed by the user.\n"
        + "\n"
        + "3) No Modified Version of the Font Software may use the Reserved Font\n"
        + "Name(s), in part or in whole, unless explicit written permission is\n"
        + "granted by the Copyright Holder. This restriction applies to all \n"
        + "references stored in the Font Software, such as the font menu name and\n"
        + "other font description fields, which are used to differentiate the\n"
        + "font from others.\n"
        + "\n"
        + "4) The name(s) of the Copyright Holder or the Author(s) of the Font\n"
        + "Software shall not be used to promote, endorse or advertise any\n"
        + "Modified Version, except to acknowledge the contribution(s) of the\n"
        + "Copyright Holder and the Author(s) or with their explicit written\n"
        + "permission.\n"
        + "\n"
        + "5) The Font Software, modified or unmodified, in part or in whole,\n"
        + "must be distributed using this license, and may not be distributed\n"
        + "under any other license.\n"
        + "\n"
        + "TERMINATION\n"
        + "This license becomes null and void if any of the above conditions are\n"
        + "not met.\n"
        + "\n"
        + "DISCLAIMER\n"
        + "THE FONT SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n"
        + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO ANY WARRANTIES OF\n"
        + "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT\n"
        + "OF COPYRIGHT, PATENT, TRADEMARK, OR OTHER RIGHT. IN NO EVENT SHALL THE\n"
        + "COPYRIGHT HOLDER BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,\n"
        + "INCLUDING ANY GENERAL, SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL\n"
        + "DAMAGES, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING\n"
        + "FROM, OUT OF THE USE OR INABILITY TO USE THE FONT SOFTWARE OR FROM\n"
        + "OTHER DEALINGS IN THE FONT SOFTWARE.\n"
; // the license text
    }
 
    
}
