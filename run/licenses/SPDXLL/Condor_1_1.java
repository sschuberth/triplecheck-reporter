package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:27:49Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Condor_1_1.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Condor_1_1 extends License{
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
        return "Condor-1.1"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Condor Public License v1.1"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "Condor Public License\n"
        + "\n"
        + "Version 1.1, October 30, 2003\n"
        + "\n"
        + "Copyright © 1990-2006 Condor Team, Computer Sciences Department, University of W"
        + "isconsin-Madison, Madison, WI. All Rights Reserved. For more information contact"
        + ": Condor Team, Attention: Professor Miron Livny, Dept of Computer Sciences, 1210"
        + " W. Dayton St., Madison, WI 53706-1685, (608) 262-0856 or miron@cs.wisc.edu.\n"
        + "\n"
        + "This software referred to as the Condor® Version 6.x software (\"Software\") was d"
        + "eveloped by the Condor Project, Condor Team, Computer Sciences Department, Unive"
        + "rsity of Wisconsin-Madison, under the authority of the Board of Regents of the U"
        + "niversity of Wisconsin System and includes voluntary contributions made to the C"
        + "ondor Project (\"Copyright Holders and Contributors and the University\"). For mor"
        + "e information on the Condor Project, please see http://www.condorproject.org/.\n"
        + "\n"
        + "Installation, use, reproduction, display, modification and redistribution of thi"
        + "s Software, with or without modification, in source and binary forms, are permit"
        + "ted. Any exercise of rights under this license including sublicenses by you is s"
        + "ubject to the following conditions:\n"
        + "\n"
        + "1.Redistributions of this Software, with or without modification, must reprodu"
        + "ce this Condor Public License in: (1) the Software, and (2) any user documentati"
        + "on or other similar material which is provided with the Software.\n"
        + "\n"
        + "2.Any user documentation included with a redistribution must include the follo"
        + "wing notice: ``This product includes software from the Condor® Project (http://w"
        + "ww.condorproject.org/)\" Alternatively, if that is where third-party acknowledgme"
        + "nts normally appear, this acknowledgment must be reproduced in the Software itse"
        + "lf. \n"
        + "3.Any academic report, publication, or other academic disclosure of results ob"
        + "tained with this Software will acknowledge this Software's use by an appropriate"
        + " citation.\n"
        + "\n"
        + "4.The name Condor® is a registered trademark of the University of Wisconsin-Ma"
        + "dison. The trademark may not be used to endorse or promote software, or products"
        + " derived therefrom, and, other than as required by section 2 and 3 above, it may"
        + " not be affixed to modified redistributions of this Software without the prior w"
        + "ritten approval, obtainable via email to condor-admin@cs.wisc.edu.\n"
        + "\n"
        + "5.To the extent that patent claims licensable by the University of Wisconsin-M"
        + "adison are necessarily infringed by the use or sale of the Software, you are gra"
        + "nted a non-exclusive, worldwide, royalty- free perpetual license under such pate"
        + "nt claims, with the rights for you to make, use, sell, offer to sell, import and"
        + " otherwise transfer the Software in source code and object code form and derivat"
        + "ive works. This patent license shall apply to the combination of the Software wi"
        + "th other software if, at the time the Software is added by you, such addition of"
        + " the Software causes such combination to be covered by such patent claims. This "
        + "patent license shall not apply to any other combinations which include the Softw"
        + "are. No hardware per se is licensed hereunder.If you or any subsequent sub-licen"
        + "see (a ``Recipient\") institutes patent litigation against any entity (including "
        + "a cross-claim or counterclaim in a lawsuit) alleging that the Software infringes"
        + " such Recipient's patent(s), then such Recipient's rights granted (directly or i"
        + "ndirectly) under the patent license above shall terminate as of the date such li"
        + "tigation is filed. All sublicenses to the Software which have been properly gran"
        + "ted prior to termination shall survive any termination of said patent license, i"
        + "f not otherwise terminated pursuant to this section. \n"
        + "6.DISCLAIMER \n"
        + "THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS AND THE UNIV"
        + "ERSITY \"AS IS\" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED"
        + " TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, OF SATISFACTORY QUALITY, AND FIT"
        + "NESS FOR A PARTICULAR PURPOSE OR USE ARE DISCLAIMED. THE COPYRIGHT HOLDERS AND C"
        + "ONTRIBUTORS AND THE UNIVERSITY MAKE NO REPRESENTATION THAT THE SOFTWARE, MODIFIC"
        + "ATIONS, ENHANCEMENTS OR DERIVATIVE WORKS THEREOF, WILL NOT INFRINGE ANY PATENT, "
        + "COPYRIGHT, TRADEMARK, TRADE SECRET OR OTHER PROPRIETARY RIGHT. \n"
        + "7.LIMITATION OF LIABILITY \n"
        + "THE COPYRIGHT HOLDERS AND CONTRIBUTORS AND ANY OTHER OFFICER, AGENT, OR EMPLOYEE"
        + " OF THE UNIVERSITY SHALL HAVE NO LIABILITY TO LICENSEE OR OTHER PERSONS FOR DIRE"
        + "CT, INDIRECT, SPECIAL, INCIDENTAL, CONSEQUENTIAL, EXEMPLARY, OR PUNITIVE DAMAGES"
        + " OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, PROCUREMENT OF SUBSTITUTE GOODS"
        + " OR SERVICES, LOSS OF USE, DATA OR PROFITS, OR BUSINESS INTERRUPTION, HOWEVER CA"
        + "USED AND ON ANY THEORY OF CONTRACT, WARRANTY, TORT (INCLUDING NEGLIGENCE), PRODU"
        + "CT LIABILITY OR OTHERWISE, ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, E"
        + "VEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. \n"
        + "8.Certain uses and transfers of the Software or documentation, and/or items or"
        + " software incorporating the Condor Software or documentation, may require a lice"
        + "nse under U.S. Export Control laws. Licensee represents and warrants that all us"
        + "es and transfers of the Condor Software or documentation and/or any items or sof"
        + "tware incorporating Condor shall be in compliance with U.S. Export Control laws,"
        + " and Licensee further understands that failure to comply with such export contro"
        + "l laws may result in criminal liability to Licensee under U.S. laws.\n"
        + "\n"
        + "9.The Condor Team may publish revised and/or new versions of this Condor Publi"
        + "c License (``this License\") from time to time. Each version will be given a dist"
        + "inguishing version number. Once Software has been published under a particular v"
        + "ersion of this License, you may always continue to use it under the terms of tha"
        + "t version. You may also choose to use such Software under the terms of any subse"
        + "quent version of this License published by the Condor Team. No one other than th"
        + "e Condor Team has the right to modify the terms of this License.\n"
        + "\n"
        + "For more information: \n"
        + "\n"
        + "Condor Team \n"
        + "Attention: Professor Miron Livny \n"
        + "7367 Computer Sciences \n"
        + "1210 W. Dayton St. \n"
        + "Madison, WI 53706-1685 \n"
        + "miron@cs.wisc.edu \n"
        + "http://pages.cs.wisc.edu/~miron/miron.html \n"
; // the license text
    }
 
    
}
