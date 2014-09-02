package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:54Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: IJG.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class IJG extends License{
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
        return "IJG"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Independent JPEG Group License"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Independent JPEG Group License\n"
        + "\n"
        + "\n"
        + "LEGAL ISSUES\n"
        + "============\n"
        + "\n"
        + "In plain English:\n"
        + "\n"
        + "1. We don't promise that this software works.  (But if you find any bugs,\n"
        + "   please let us know!)\n"
        + "2. You can use this software for whatever you want.  You don't have to pay us.\n"
        + "3. You may not pretend that you wrote this software.  If you use it in a\n"
        + "   program, you must acknowledge somewhere in your documentation that\n"
        + "   you've used the IJG code.\n"
        + "\n"
        + "In legalese:\n"
        + "\n"
        + "The authors make NO WARRANTY or representation, either express or implied,\n"
        + "with respect to this software, its quality, accuracy, merchantability, or\n"
        + "fitness for a particular purpose.  This software is provided \"AS IS\", and you,\n"
        + "its user, assume the entire risk as to its quality and accuracy.\n"
        + "\n"
        + "This software is copyright (C) 1991-1998, Thomas G. Lane.\n"
        + "All Rights Reserved except as specified below.\n"
        + "\n"
        + "Permission is hereby granted to use, copy, modify, and distribute this\n"
        + "software (or portions thereof) for any purpose, without fee, subject to these\n"
        + "conditions:\n"
        + "(1) If any part of the source code for this software is distributed, then this\n"
        + "README file must be included, with this copyright and no-warranty notice\n"
        + "unaltered; and any additions, deletions, or changes to the original files\n"
        + "must be clearly indicated in accompanying documentation.\n"
        + "(2) If only executable code is distributed, then the accompanying\n"
        + "documentation must state that \"this software is based in part on the work of\n"
        + "the Independent JPEG Group\".\n"
        + "(3) Permission for use of this software is granted only if the user accepts\n"
        + "full responsibility for any undesirable consequences; the authors accept\n"
        + "NO LIABILITY for damages of any kind.\n"
        + "\n"
        + "These conditions apply to any software derived from or based on the IJG code,\n"
        + "not just to the unmodified library.  If you use our work, you ought to\n"
        + "acknowledge us.\n"
        + "\n"
        + "Permission is NOT granted for the use of any IJG author's name or company name\n"
        + "in advertising or publicity relating to this software or products derived from\n"
        + "it.  This software may be referred to only as \"the Independent JPEG Group's\n"
        + "software\".\n"
        + "\n"
        + "We specifically permit and encourage the use of this software as the basis of\n"
        + "commercial products, provided that all warranty or liability claims are\n"
        + "assumed by the product vendor.\n"
        + "\n"
        + "\n"
        + "ansi2knr.c is included in this distribution by permission of L. Peter Deutsch,\n"
        + "sole proprietor of its copyright holder, Aladdin Enterprises of Menlo Park, CA.\n"
        + "ansi2knr.c is NOT covered by the above copyright and conditions, but instead\n"
        + "by the usual distribution terms of the Free Software Foundation; principally,\n"
        + "that you must include source code if you redistribute it.  (See the file\n"
        + "ansi2knr.c for full details.)  However, since ansi2knr.c is not needed as part\n"
        + "of any program generated from the IJG code, this does not limit you more than\n"
        + "the foregoing paragraphs do.\n"
        + "\n"
        + "The Unix configuration script \"configure\" was produced with GNU Autoconf.\n"
        + "It is copyright by the Free Software Foundation but is freely distributable.\n"
        + "The same holds for its supporting scripts (config.guess, config.sub,\n"
        + "ltconfig, ltmain.sh).  Another support script, install-sh, is copyright\n"
        + "by M.I.T. but is also freely distributable.\n"
        + "\n"
        + "It appears that the arithmetic coding option of the JPEG spec is covered by\n"
        + "patents owned by IBM, AT&T, and Mitsubishi.  Hence arithmetic coding cannot\n"
        + "legally be used without obtaining one or more licenses.  For this reason,\n"
        + "support for arithmetic coding has been removed from the free JPEG software.\n"
        + "(Since arithmetic coding provides only a marginal gain over the unpatented\n"
        + "Huffman mode, it is unlikely that very many implementations will support it.)\n"
        + "So far as we are aware, there are no patent restrictions on the remaining\n"
        + "code.\n"
        + "\n"
        + "The IJG distribution formerly included code to read and write GIF files.\n"
        + "To avoid entanglement with the Unisys LZW patent, GIF reading support has\n"
        + "been removed altogether, and the GIF writer has been simplified to produce\n"
        + "\"uncompressed GIFs\".  This technique does not use the LZW algorithm; the\n"
        + "resulting GIF files are larger than usual, but are readable by all standard\n"
        + "GIF decoders.\n"
        + "\n"
        + "We are required to state that\n"
        + "    \"The Graphics Interchange Format(c) is the Copyright property of\n"
        + "    CompuServe Incorporated.  GIF(sm) is a Service Mark property of\n"
        + "    CompuServe Incorporated.\"\n"
; // the license text
    }
 
    
}
