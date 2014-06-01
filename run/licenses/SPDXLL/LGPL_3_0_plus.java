package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:49Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LGPL_3_0_plus.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class LGPL_3_0_plus extends License{
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
        return "LGPL-3.0+"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "GNU Lesser General Public License v3.0 or later"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "                   GNU LESSER GENERAL PUBLIC LICENSE\n"
        + "                       Version 3, 29 June 2007\n"
        + "\n"
        + " Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>\n"
        + " \n"
        + "Everyone is permitted to copy and distribute verbatim copies of this license doc"
        + "ument, but changing it is not allowed.\n"
        + "\n"
        + "This version of the GNU Lesser General Public License incorporates the terms and"
        + " conditions of version 3 of the GNU General Public License, supplemented by the "
        + "additional permissions listed below.\n"
        + "\n"
        + "0. Additional Definitions.\n"
        + "\n"
        + "As used herein, \"this License\" refers to version 3 of the GNU Lesser General Pub"
        + "lic License, and the \"GNU GPL\" refers to version 3 of the GNU General Public Lic"
        + "ense.\n"
        + "\n"
        + "\"The Library\" refers to a covered work governed by this License, other than an A"
        + "pplication or a Combined Work as defined below.\n"
        + "\n"
        + "An \"Application\" is any work that makes use of an interface provided by the Libr"
        + "ary, but which is not otherwise based on the Library. Defining a subclass of a c"
        + "lass defined by the Library is deemed a mode of using an interface provided by t"
        + "he Library.\n"
        + "\n"
        + "A \"Combined Work\" is a work produced by combining or linking an Application with"
        + " the Library.  The particular version of the Library with which the Combined Wor"
        + "k was made is also called the \"Linked Version\".\n"
        + "\n"
        + "The \"Minimal Corresponding Source\" for a Combined Work means the Corresponding S"
        + "ource for the Combined Work, excluding any source code for portions of the Combi"
        + "ned Work that, considered in isolation, are based on the Application, and not on"
        + " the Linked Version.\n"
        + "\n"
        + "The \"Corresponding Application Code\" for a Combined Work means the object code a"
        + "nd/or source code for the Application, including any data and utility programs n"
        + "eeded for reproducing the Combined Work from the Application, but excluding the "
        + "System Libraries of the Combined Work.\n"
        + "\n"
        + "1. Exception to Section 3 of the GNU GPL.\n"
        + "You may convey a covered work under sections 3 and 4 of this License without bei"
        + "ng bound by section 3 of the GNU GPL.\n"
        + "\n"
        + "2. Conveying Modified Versions.\n"
        + "If you modify a copy of the Library, and, in your modifications, a facility refe"
        + "rs to a function or data to be supplied by an Application that uses the facility"
        + " (other than as an argument passed when the facility is invoked), then you may c"
        + "onvey a copy of the modified version:\n"
        + "\n"
        + "   a) under this License, provided that you make a good faith effort to ensure t"
        + "hat, in the event an Application does not supply the function or data, the facil"
        + "ity still operates, and performs whatever part of its purpose remains meaningful"
        + ", or\n"
        + "\n"
        + "   b) under the GNU GPL, with none of the additional permissions of this License"
        + " applicable to that copy.\n"
        + "\n"
        + "3. Object Code Incorporating Material from Library Header Files.\n"
        + "The object code form of an Application may incorporate material from a header fi"
        + "le that is part of the Library.  You may convey such object code under terms of "
        + "your choice, provided that, if the incorporated material is not limited to numer"
        + "ical parameters, data structure layouts and accessors, or small macros, inline f"
        + "unctions and templates (ten or fewer lines in length), you do both of the follow"
        + "ing:\n"
        + "\n"
        + "   a) Give prominent notice with each copy of the object code that the Library i"
        + "s used in it and that the Library and its use are covered by this License.\n"
        + "\n"
        + "   b) Accompany the object code with a copy of the GNU GPL and this license docu"
        + "ment.\n"
        + "\n"
        + "4. Combined Works.\n"
        + "You may convey a Combined Work under terms of your choice that, taken together, "
        + "effectively do not restrict modification of the portions of the Library containe"
        + "d in the Combined Work and reverse engineering for debugging such modifications,"
        + " if you also do each of the following:\n"
        + "\n"
        + "   a) Give prominent notice with each copy of the Combined Work that the Library"
        + " is used in it and that the Library and its use are covered by this License.\n"
        + "\n"
        + "   b) Accompany the Combined Work with a copy of the GNU GPL and this license do"
        + "cument.\n"
        + "\n"
        + "   c) For a Combined Work that displays copyright notices during execution, incl"
        + "ude the copyright notice for the Library among these notices, as well as a refer"
        + "ence directing the user to the copies of the GNU GPL and this license document.\n"
        + "\n"
        + "   d) Do one of the following:\n"
        + "\n"
        + "       0) Convey the Minimal Corresponding Source under the terms of this Licens"
        + "e, and the Corresponding Application Code in a form suitable for, and under term"
        + "s that permit, the user to recombine or relink the Application with a modified v"
        + "ersion of the Linked Version to produce a modified Combined Work, in the manner "
        + "specified by section 6 of the GNU GPL for conveying Corresponding Source.\n"
        + "\n"
        + "       1) Use a suitable shared library mechanism for linking with the Library. "
        + " A suitable mechanism is one that (a) uses at run time a copy of the Library alr"
        + "eady present on the user's computer system, and (b) will operate properly with a"
        + " modified version of the Library that is interface-compatible with the Linked Ve"
        + "rsion.\n"
        + "\n"
        + "   e) Provide Installation Information, but only if you would otherwise be requi"
        + "red to provide such information under section 6 of the GNU GPL, and only to the "
        + "extent that such information is necessary to install and execute a modified vers"
        + "ion of the Combined Work produced by recombining or relinking the Application wi"
        + "th a modified version of the Linked Version. (If you use option 4d0, the Install"
        + "ation Information must accompany the Minimal Corresponding Source and Correspond"
        + "ing Application Code. If you use option 4d1, you must provide the Installation I"
        + "nformation in the manner specified by section 6 of the GNU GPL for conveying Cor"
        + "responding Source.)\n"
        + "\n"
        + "5. Combined Libraries.\n"
        + "You may place library facilities that are a work based on the Library side by si"
        + "de in a single library together with other library facilities that are not Appli"
        + "cations and are not covered by this License, and convey such a combined library "
        + "under terms of your choice, if you do both of the following:\n"
        + "\n"
        + "   a) Accompany the combined library with a copy of the same work based on the L"
        + "ibrary, uncombined with any other library facilities, conveyed under the terms o"
        + "f this License.\n"
        + "\n"
        + "   b) Give prominent notice with the combined library that part of it is a work "
        + "based on the Library, and explaining where to find the accompanying uncombined f"
        + "orm of the same work.\n"
        + "\n"
        + "6. Revised Versions of the GNU Lesser General Public License.\n"
        + "The Free Software Foundation may publish revised and/or new versions of the GNU "
        + "Lesser General Public License from time to time. Such new versions will be simil"
        + "ar in spirit to the present version, but may differ in detail to address new pro"
        + "blems or concerns.\n"
        + "\n"
        + "Each version is given a distinguishing version number. If the Library as you rec"
        + "eived it specifies that a certain numbered version of the GNU Lesser General Pub"
        + "lic License \"or any later version\" applies to it, you have the option of followi"
        + "ng the terms and conditions either of that published version or of any later ver"
        + "sion published by the Free Software Foundation. If the Library as you received i"
        + "t does not specify a version number of the GNU Lesser General Public License, yo"
        + "u may choose any version of the GNU Lesser General Public License ever published"
        + " by the Free Software Foundation.\n"
        + "\n"
        + "If the Library as you received it specifies that a proxy can decide whether futu"
        + "re versions of the GNU Lesser General Public License shall\n"
        + "apply, that proxy's public statement of acceptance of any version is permanent a"
        + "uthorization for you to choose that version for the Library.\n"
; // the license text
    }
 
    
}
