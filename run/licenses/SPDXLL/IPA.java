package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:55Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: IPA.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class IPA extends License{
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
        return "IPA"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "IPA Font License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "IPA Font License Agreement v1.0 \n"
        + " \n"
        + "\n"
        + "The Licensor provides the Licensed Program (as defined in Article 1 below) under"
        + " the terms of this license agreement (\"Agreement\").  Any use, reproduction or di"
        + "stribution of the Licensed Program, or any exercise of rights under this Agreeme"
        + "nt by a Recipient (as defined in Article 1 below) constitutes the Recipient's ac"
        + "ceptance of this Agreement.\n"
        + "\n"
        + "\n"
        + "Article 1 (Definitions)\n"
        + "\n"
        + "1.         \"Digital Font Program\" shall mean a computer program containing, or u"
        + "sed to render or display fonts.\n"
        + "\n"
        + "2.         \"Licensed Program\" shall mean a Digital Font Program licensed by the "
        + "Licensor under this Agreement.\n"
        + "\n"
        + "3.         \"Derived Program\" shall mean a Digital Font Program created as a resu"
        + "lt of a modification, addition, deletion, replacement or any other adaptation to"
        + " or of a part or all of the Licensed Program, and includes a case where a Digita"
        + "l Font Program newly created by retrieving font information from a part or all o"
        + "f the Licensed Program or Embedded Fonts from a Digital Document File with or wi"
        + "thout modification of the retrieved font information. \n"
        + "\n"
        + "4.         \"Digital Content\" shall mean products provided to end users in the fo"
        + "rm of digital data, including video content, motion and/or still pictures, TV pr"
        + "ograms or other broadcasting content and products consisting of character text, "
        + "pictures, photographic images, graphic symbols and/or the like.\n"
        + "\n"
        + "5.         \"Digital Document File\" shall mean a PDF file or other Digital Conten"
        + "t created by various software programs in which a part or all of the Licensed Pr"
        + "ogram becomes embedded or contained in the file for the display of the font (\"Em"
        + "bedded Fonts\").  Embedded Fonts are used only in the display of characters in th"
        + "e particular Digital Document File within which they are embedded, and shall be "
        + "distinguished from those in any Digital Font Program, which may be used for disp"
        + "lay of characters outside that particular Digital Document File.\n"
        + "\n"
        + "6.         \"Computer\" shall include a server in this Agreement.\n"
        + "\n"
        + "7.         \"Reproduction and Other Exploitation\" shall mean reproduction, transf"
        + "er, distribution, lease, public transmission, presentation, exhibition, adaptati"
        + "on and any other exploitation.\n"
        + "\n"
        + "8.         \"Recipient\" shall mean anyone who receives the Licensed Program under"
        + " this Agreement, including one that receives the Licensed Program from a Recipie"
        + "nt.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Article 2 (Grant of License)\n"
        + "\n"
        + "The Licensor grants to the Recipient a license to use the Licensed Program in an"
        + "y and all countries in accordance with each of the provisions set forth in this "
        + "Agreement. However, any and all rights underlying in the Licensed Program shall "
        + "be held by the Licensor. In no sense is this Agreement intended to transfer any "
        + "right relating to the Licensed Program held by the Licensor except as specifical"
        + "ly set forth herein or any right relating to any trademark, trade name, or servi"
        + "ce mark to the Recipient.\n"
        + "\n"
        + " \n"
        + "\n"
        + "1.         The Recipient may install the Licensed Program on any number of Compu"
        + "ters and use the same in accordance with the provisions set forth in this Agreem"
        + "ent.\n"
        + "\n"
        + "2.         The Recipient may use the Licensed Program, with or without modificat"
        + "ion in printed materials or in Digital Content as an expression of character tex"
        + "ts or the like.\n"
        + "\n"
        + "3.         The Recipient may conduct Reproduction and Other Exploitation of the "
        + "printed materials and Digital Content created in accordance with the preceding P"
        + "aragraph, for commercial or non-commercial purposes and in any form of media inc"
        + "luding but not limited to broadcasting, communication and various recording medi"
        + "a.\n"
        + "\n"
        + "4.         If any Recipient extracts Embedded Fonts from a Digital Document File"
        + " to create a Derived Program, such Derived Program shall be subject to the terms"
        + " of this agreement.  \n"
        + "\n"
        + "5.         If any Recipient performs Reproduction or Other Exploitation of a Dig"
        + "ital Document File in which Embedded Fonts of the Licensed Program are used only"
        + " for rendering the Digital Content within such Digital Document File then such R"
        + "ecipient shall have no further obligations under this Agreement in relation to s"
        + "uch actions.\n"
        + "\n"
        + "6.         The Recipient may reproduce the Licensed Program as is without modifi"
        + "cation and transfer such copies, publicly transmit or otherwise redistribute the"
        + " Licensed Program to a third party for commercial or non-commercial purposes (\"R"
        + "edistribute\"), in accordance with the provisions set forth in Article 3 Paragrap"
        + "h 2.\n"
        + "\n"
        + "7.         The Recipient may create, use, reproduce and/or Redistribute a Derive"
        + "d Program under the terms stated above for the Licensed Program: provided, that "
        + "the Recipient shall follow the provisions set forth in Article 3 Paragraph 1 whe"
        + "n Redistributing the Derived Program. \n"
        + "\n"
        + "\n"
        + "Article 3 (Restriction)\n"
        + "\n"
        + "The license granted in the preceding Article shall be subject to the following r"
        + "estrictions:\n"
        + "\n"
        + "\n"
        + "1.         If a Derived Program is Redistributed pursuant to Paragraph 4 and 7 o"
        + "f the preceding Article, the following conditions must be met :\n"
        + "\n"
        + "(1)                The following must be also Redistributed together with the De"
        + "rived Program, or be made available online or by means of mailing mechanisms in "
        + "exchange for a cost which does not exceed the total costs of postage, storage me"
        + "dium and handling fees:\n"
        + "\n"
        + "(a)    a copy of the Derived Program; and\n"
        + "\n"
        + "(b)    any additional file created by the font developing program in the course "
        + "of creating the Derived Program that can be used for further modification of the"
        + " Derived Program, if any.\n"
        + "\n"
        + "(2)                It is required to also Redistribute means to enable recipient"
        + "s of the Derived Program to replace the Derived Program with the Licensed Progra"
        + "m first released under this License (the \"Original Program\").  Such means may be"
        + " to provide a difference file from the Original Program, or instructions setting"
        + " out a method to replace the Derived Program with the Original Program.\n"
        + "\n"
        + "(3)                The Recipient must license the Derived Program under the term"
        + "s and conditions of this Agreement.\n"
        + "\n"
        + "(4)                No one may use or include the name of the Licensed Program as"
        + " a program name, font name or file name of the Derived Program.\n"
        + "\n"
        + "(5)                Any material to be made available online or by means of maili"
        + "ng a medium to satisfy the requirements of this paragraph may be provided, verba"
        + "tim, by any party wishing to do so.\n"
        + "\n"
        + "2.         If the Recipient Redistributes the Licensed Program pursuant to Parag"
        + "raph 6 of the preceding Article, the Recipient shall meet all of the following c"
        + "onditions:\n"
        + "\n"
        + "(1)                The Recipient may not change the name of the Licensed Program"
        + ".\n"
        + "\n"
        + "(2)                The Recipient may not alter or otherwise modify the Licensed "
        + "Program.\n"
        + "\n"
        + "(3)                The Recipient must attach a copy of this Agreement to the Lic"
        + "ensed Program.\n"
        + "\n"
        + "3.         THIS LICENSED PROGRAM IS PROVIDED BY THE LICENSOR \"AS IS\" AND ANY EXP"
        + "RESSED OR IMPLIED WARRANTY AS TO THE LICENSED PROGRAM OR ANY DERIVED PROGRAM, IN"
        + "CLUDING, BUT NOT LIMITED TO, WARRANTIES OF TITLE, NON-INFRINGEMENT, MERCHANTABIL"
        + "ITY, OR FITNESS FOR A PARTICULAR PURPOSE, ARE DISCLAIMED.  IN NO EVENT SHALL THE"
        + " LICENSOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXTENDED, EXE"
        + "MPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO; PROCUREMENT OF "
        + "SUBSTITUTED GOODS OR SERVICE; DAMAGES ARISING FROM SYSTEM FAILURE; LOSS OR CORRU"
        + "PTION OF EXISTING DATA OR PROGRAM; LOST PROFITS), HOWEVER CAUSED AND ON ANY THEO"
        + "RY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY OR TORT (INCLUDING NEGLIG"
        + "ENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE INSTALLATION, USE, THE REPRODUC"
        + "TION OR OTHER EXPLOITATION OF THE LICENSED PROGRAM OR ANY DERIVED PROGRAM OR THE"
        + " EXERCISE OF ANY RIGHTS GRANTED HEREUNDER, EVEN IF ADVISED OF THE POSSIBILITY OF"
        + " SUCH DAMAGES.\n"
        + "\n"
        + "4.         The Licensor is under no obligation to respond to any technical quest"
        + "ions or inquiries, or provide any other user support in connection with the inst"
        + "allation, use or the Reproduction and Other Exploitation of the Licensed Program"
        + " or Derived Programs thereof.\n"
        + "\n"
        + "\n"
        + "Article 4 (Termination of Agreement)\n"
        + "\n"
        + "1.         The term of this Agreement shall begin from the time of receipt of th"
        + "e Licensed Program by the Recipient and shall continue as long as the Recipient "
        + "retains any such Licensed Program in any way.\n"
        + "\n"
        + "2.         Notwithstanding the provision set forth in the preceding Paragraph, i"
        + "n the event of the breach of any of the provisions set forth in this Agreement b"
        + "y the Recipient, this Agreement shall automatically terminate without any notice"
        + ". In the case of such termination, the Recipient may not use or conduct Reproduc"
        + "tion and Other Exploitation of the Licensed Program or a Derived Program: provid"
        + "ed that such termination shall not affect any rights of any other Recipient rece"
        + "iving the Licensed Program or the Derived Program from such Recipient who breach"
        + "ed this Agreement.\n"
        + "\n"
        + "\n"
        + "Article 5 (Governing Law)\n"
        + "\n"
        + "1.         IPA may publish revised and/or new versions of this License.  In such"
        + " an event, the Recipient may select either this Agreement or any subsequent vers"
        + "ion of the Agreement in using, conducting the Reproduction and Other Exploitatio"
        + "n of, or Redistributing the Licensed Program or a Derived Program. Other matters"
        + " not specified above shall be subject to the Copyright Law of Japan and other re"
        + "lated laws and regulations of Japan.\n"
        + "\n"
        + "2.         This Agreement shall be construed under the laws of Japan.\n"
; // the license text
    }
 
    
}
