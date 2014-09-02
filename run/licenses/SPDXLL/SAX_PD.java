package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:29:44Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SAX_PD.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class SAX_PD extends License{
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
        return "SAX-PD"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Sax Public Domain Notice"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Copyright Status\n"
        + "\n"
        + "SAX is free!\n"
        + "\n"
        + "In fact, it's not possible to own a license to SAX, since it's been placed in th"
        + "e public domain.\n"
        + "\n"
        + "No Warranty\n"
        + "\n"
        + "Because SAX is released to the public domain, there is no warranty for the desig"
        + "n or for the software implementation, to the extent permitted by applicable law."
        + " Except when otherwise stated in writing the copyright holders and/or other part"
        + "ies provide SAX \"as is\" without warranty of any kind, either expressed or implie"
        + "d, including, but not limited to, the implied warranties of merchantability and "
        + "fitness for a particular purpose. The entire risk as to the quality and performa"
        + "nce of SAX is with you. Should SAX prove defective, you assume the cost of all n"
        + "ecessary servicing, repair or correction.\n"
        + "\n"
        + "In no event unless required by applicable law or agreed to in writing will any c"
        + "opyright holder, or any other party who may modify and/or redistribute SAX, be l"
        + "iable to you for damages, including any general, special, incidental or conseque"
        + "ntial damages arising out of the use or inability to use SAX (including but not "
        + "limited to loss of data or data being rendered inaccurate or losses sustained by"
        + " you or third parties or a failure of the SAX to operate with any other programs"
        + "), even if such holder or other party has been advised of the possibility of suc"
        + "h damages.\n"
        + "\n"
        + "Copyright Disclaimers\n"
        + "\n"
        + "This page includes statements to that effect by David Megginson, who would have "
        + "been able to claim copyright for the original work.\n"
        + "\n"
        + "SAX 1.0\n"
        + "\n"
        + "Version 1.0 of the Simple API for XML (SAX), created collectively by the members"
        + "hip of the XML-DEV mailing list, is hereby released into the public domain.\n"
        + "\n"
        + "No one owns SAX: you may use it freely in both commercial and non-commercial app"
        + "lications, bundle it with your software distribution, include it on a CD-ROM, li"
        + "st the source code in a book, mirror the documentation at your own web site, or "
        + "use it in any other way you see fit.\n"
        + "\n"
        + "David Megginson, Megginson Technologies Ltd.\n"
        + "1998-05-11\n"
        + "\n"
        + "SAX 2.0\n"
        + "\n"
        + "I hereby abandon any property rights to SAX 2.0 (the Simple API for XML), and re"
        + "lease all of the SAX 2.0 source code, compiled code, and documentation contained"
        + " in this distribution into the Public Domain. SAX comes with NO WARRANTY or guar"
        + "antee of fitness for any purpose.\n"
        + "\n"
        + "David Megginson, Megginson Technologies Ltd.\n"
        + "2000-05-05\n"
; // the license text
    }
 
    
}
