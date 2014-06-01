package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:47Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SimPL_2_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class SimPL_2_0 extends License{
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
        return "SimPL-2.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Simple Public License 2.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Simple Public License (SimPL)\n"
        + "\n"
        + "Preamble\n"
        + "This Simple Public License 2.0 (SimPL 2.0 for short) is a plain language impleme"
        + "ntation of GPL 2.0.  The words are different, but the goal is the same - to guar"
        + "antee for all users the freedom to share and change software.  If anyone wonders"
        + " about the meaning of the SimPL, they should interpret it as consistent with GPL"
        + " 2.0.\n"
        + "Simple Public License (SimPL) 2.0\n"
        + "The SimPL applies to the software's source and object code and comes with any ri"
        + "ghts that I have in it (other than trademarks). You agree to the SimPL by copyin"
        + "g, distributing, or making a derivative work of the software.\n"
        + "\n"
        + "You get the royalty free right to:\n"
        + "Use the software for any purpose;\n"
        + "Make derivative works of it (this is called a \"Derived Work\");\n"
        + "Copy and distribute it and any Derived Work.\n"
        + "If you distribute the software or a Derived Work, you must give back to the comm"
        + "unity by:\n"
        + "Prominently noting the date of any changes you make;\n"
        + "Leaving other people's copyright notices, warranty disclaimers, and license term"
        + "s  in place;\n"
        + "Providing the source code, build scripts, installation scripts, and interface de"
        + "finitions in a form that is easy to get and best to modify;\n"
        + "Licensing it to everyone under SimPL, or substantially similar terms (such as GP"
        + "L 2.0), without adding further restrictions to the rights provided;\n"
        + "Conspicuously announcing that it is available under that license.\n"
        + "There are some things that you must shoulder:\n"
        + "You get NO WARRANTIES. None of any kind;\n"
        + "If the software damages you in any way, you may only recover direct damages up t"
        + "o the amount you paid for it (that is zero if you did not pay anything). You may"
        + " not recover any other damages, including those called \"consequential damages.\" "
        + "(The state or country where you live may not allow you to limit your liability i"
        + "n this way, so this may not apply to you);\n"
        + "The SimPL continues perpetually, except that your license rights end automatical"
        + "ly if:\n"
        + "You do not abide by the \"give back to the community\" terms (your licensees get t"
        + "o keep their rights if they abide);\n"
        + "Anyone prevents you from distributing the software under the terms of the SimPL.\n"
        + "License for the License\n"
        + "You may do anything that you want with the SimPL text; it's a license form to us"
        + "e in any way that you find helpful.  To avoid confusion, however, if you change "
        + "the terms in any way then you may not call your license the Simple Public Licens"
        + "e or the SimPL (but feel free to acknowledge that your license is \"based on the "
        + "Simple Public License\").\n"
; // the license text
    }
 
    
}
