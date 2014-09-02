package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:17Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: NGPL.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class NGPL extends License{
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
        return "NGPL"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Nethack General Public License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "\n"
        + "NETHACK GENERAL PUBLIC LICENSE\n"
        + "\n"
        + "(Copyright 1989 M. Stephenson) \n"
        + "(Based on the BISON general public license, copyright 1988 Richard M. Stallman)\n"
        + "\n"
        + "Everyone is permitted to copy and distribute verbatim copies of this license, bu"
        + "t changing it is not allowed. You can also use this wording to make the terms fo"
        + "r other programs.\n"
        + "The license agreements of most software companies keep you at the mercy of those"
        + " companies. By contrast, our general public license is intended to give everyone"
        + " the right to share NetHack. To make sure that you get the rights we want you to"
        + " have, we need to make restrictions that forbid anyone to deny you these rights "
        + "or to ask you to surrender the rights. Hence this license agreement.\n"
        + "\n"
        + "Specifically, we want to make sure that you have the right to give away copies o"
        + "f NetHack, that you receive source code or else can get it if you want it, that "
        + "you can change NetHack or use pieces of it in new free programs, and that you kn"
        + "ow you can do these things.\n"
        + "\n"
        + "To make sure that everyone has such rights, we have to forbid you to deprive any"
        + "one else of these rights. For example, if you distribute copies of NetHack, you "
        + "must give the recipients all the rights that you have. You must make sure that t"
        + "hey, too, receive or can get the source code. And you must tell them their right"
        + "s.\n"
        + "\n"
        + "Also, for our own protection, we must make certain that everyone finds out that "
        + "there is no warranty for NetHack. If NetHack is modified by someone else and pas"
        + "sed on, we want its recipients to know that what they have is not what we distri"
        + "buted.\n"
        + "\n"
        + "Therefore we (Mike Stephenson and other holders of NetHack copyrights) make the "
        + "following terms which say what you must do to be allowed to distribute or change"
        + " NetHack.\n"
        + "\n"
        + "COPYING POLICIES\n"
        + "\n"
        + "You may copy and distribute verbatim copies of NetHack source code as you receiv"
        + "e it, in any medium, provided that you keep intact the notices on all files that"
        + " refer to copyrights, to this License Agreement, and to the absence of any warra"
        + "nty; and give any other recipients of the NetHack program a copy of this License"
        + " Agreement along with the program.\n"
        + "You may modify your copy or copies of NetHack or any portion of it, and copy and"
        + " distribute such modifications under the terms of Paragraph 1 above (including d"
        + "istributing this License Agreement), provided that you also do the following:\n"
        + "a) cause the modified files to carry prominent notices stating that you changed "
        + "the files and the date of any change; and\n"
        + "\n"
        + "b) cause the whole of any work that you distribute or publish, that in whole or "
        + "in part contains or is a derivative of NetHack or any part thereof, to be licens"
        + "ed at no charge to all third parties on terms identical to those contained in th"
        + "is License Agreement (except that you may choose to grant more extensive warrant"
        + "y protection to some or all third parties, at your option)\n"
        + "\n"
        + "c) You may charge a distribution fee for the physical act of transferring a copy"
        + ", and you may at your option offer warranty protection in exchange for a fee.\n"
        + "\n"
        + "You may copy and distribute NetHack (or a portion or derivative of it, under Par"
        + "agraph 2) in object code or executable form under the terms of Paragraphs 1 and "
        + "2 above provided that you also do one of the following:\n"
        + "a) accompany it with the complete machine-readable source code, which must be di"
        + "stributed under the terms of Paragraphs 1 and 2 above; or,\n"
        + "\n"
        + "b) accompany it with full information as to how to obtain the complete machine-r"
        + "eadable source code from an appropriate archive site. (This alternative is allow"
        + "ed only for noncommercial distribution.)\n"
        + "\n"
        + "For these purposes, complete source code means either the full source distributi"
        + "on as originally released over Usenet or updated copies of the files in this dis"
        + "tribution used to create the object code or executable.\n"
        + "\n"
        + "You may not copy, sublicense, distribute or transfer NetHack except as expressly"
        + " provided under this License Agreement. Any attempt otherwise to copy, sublicens"
        + "e, distribute or transfer NetHack is void and your rights to use the program und"
        + "er this License agreement shall be automatically terminated. However, parties wh"
        + "o have received computer software programs from you with this License Agreement "
        + "will not have their licenses terminated so long as such parties remain in full c"
        + "ompliance.\n"
        + "Stated plainly: You are permitted to modify NetHack, or otherwise use parts of N"
        + "etHack, provided that you comply with the conditions specified above; in particu"
        + "lar, your modified NetHack or program containing parts of NetHack must remain fr"
        + "eely available as provided in this License Agreement. In other words, go ahead a"
        + "nd share NetHack, but don't try to stop anyone else from sharing it farther. \n"
        + "[  Home  |  Version 3.4.3  |  Contact Us  ]\n"
        + "\n"
        + "\n"
        + "\n"
        + "Hosted by:       \n"
        + "NetHack is Copyright 1985-2003 by Stichting Mathematisch Centrum and M. Stephens"
        + "on. See our license for details.\n"
        + "This site is Copyright 1999-2009 by Kenneth Lorber, Kensington, Maryland.\n"
; // the license text
    }
 
    
}
