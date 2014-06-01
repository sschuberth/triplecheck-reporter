package SPDXLL;

import spdxlib.License;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: nuno
 * Created: 2014-06-01T13:28:23Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Frameworx_1_0.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, nuno </text>
 */


public class Frameworx_1_0 extends License{
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
        return "Frameworx-1.0"; // short and unique id
    }
    
    /**
     * What is the full title for this license?
     * @return  The official full title of the license
     */
    @Override
    public String getTitle(){
        return "Frameworx Open License 1.0"; // full text title
    }
    
    /**
     * In most cases, the license will have generic terms that only present
     * minor changes such as copyright attributions. This method provides
     * an idea of the contents of the license.
     * @return  Normal text (no markup) version of the license terms
     */
    @Override
    public String getTerms(){
        return "THE FRAMEWORX OPEN LICENSE 1.0\n"
        + "\n"
        + "This License Agreement, The Frameworx Open License 1.0, has been entered into be"
        + "tween The Frameworx Company and you, the licensee hereunder, effective as of You"
        + "r acceptance of the Frameworx Code Base or an Downstream Distribution (each as d"
        + "efined below).\n"
        + "\n"
        + "AGREEMENT BACKGROUND\n"
        + "The Frameworx Company is committed to the belief that open source software resul"
        + "ts in better quality, greater technical and product innovation in the market pla"
        + "ce and a more empowered and productive developer and end-user community. Our obj"
        + "ective is to ensure that the Frameworx Code Base, and the source code for improv"
        + "ements and innovations to it, remain free and open to the community.To further t"
        + "hese beliefs and objectives, we are distributing the Frameworx Code Base, withou"
        + "t royalties and in source code form, to the community pursuant to this License A"
        + "greement.\n"
        + "\n"
        + "AGREEMENT TERMS\n"
        + "The Frameworx Company and You have agreed as follows:\n"
        + "1.Definitions.The following terms have the following respective meanings:\n"
        + "\n"
        + "(a)     Frameworx Code Base means the software developed by The Frameworx Compan"
        + "y and made available under this License Agreement\n"
        + "\n"
        + "(b)     Downstream Distribution means any direct or indirect release, distributi"
        + "on or remote availability of software (i) that directly or indirectly contains, "
        + "or depends for its intended functioning on, the Frameworx Code Base or any porti"
        + "on or element thereof and (ii) in which rights to use and distribute such Framew"
        + "orx Code Base software depend, directly or indirectly, on the License provided i"
        + "n Section 2 below.\n"
        + "\n"
        + "(c)     \"Source Code\" to any software means the preferred form for making modifi"
        + "cations to that software, including any associated documentation, interface defi"
        + "nition files and compilation or installation scripts, or any version thereof tha"
        + "t has been compressed or archived, and can be reconstituted, using an appropriat"
        + "e and generally available archival or compression technology.\n"
        + "\n"
        + "(d)     Value-Added Services means any commercial or fee-based software-related "
        + "service, including without limitation: system or application development or cons"
        + "ulting; technical or end-user support or training; distribution maintenance, con"
        + "figuration or versioning; or outsourced, hosted or network-based application ser"
        + "vices.\n"
        + "\n"
        + "2. License Grant. Subject to the terms and conditions hereof, The Frameworx Comp"
        + "any hereby grants You a non-exclusive license (the License), subject to third pa"
        + "rty intellectual property claims, and for no fee other than a nominal charge ref"
        + "lecting the costs of physical distribution, to:\n"
        + "\n"
        + "(a)     use the Frameworx Code Base, in either Source Code or machine-readable f"
        + "orm;\n"
        + "\n"
        + "(b)     make modifications, additions and deletions to the content or structure "
        + "of the Frameworx Code Base; or\n"
        + "\n"
        + "(c)     create larger works or derivative works including the Frameworx Code Bas"
        + "e or any portion or element thereof; and\n"
        + "\n"
        + "(d)     release, distribute or make available, either generally or to any specif"
        + "ic third-party, any of the foregoing in Source Code or binary form.\n"
        + "\n"
        + "3. License Conditions. The grant of the License under Section 1 hereof, and your"
        + " exercise of all rights in connection with this License Agreement, will remain s"
        + "ubject to the following terms and conditions, as well as to the other provisions"
        + " hereof:\n"
        + "\n"
        + "(a)     Complete Source Code for any Downstream Distribution directly or indirec"
        + "tly made by You that contains, or depends for its intended functionality on, the"
        + " Frameworx Code Base, or any portion or element thereof, shall be made freely av"
        + "ailable to all users thereof on terms and conditions no more restrictive, and no"
        + " less favorable for any user (including, without limitation, with regard to Sour"
        + "ce Code availability and royalty-free use) than those terms and conditions provi"
        + "ded in this License Agreement.\n"
        + "\n"
        + "(b)     Any Value-Added Services that you offer or provide, directly or indirect"
        + "ly, in relation to any Downstream Distribution shall be offered and provided on "
        + "commercial terms that are reasonably commensurate to the fair market value of su"
        + "ch Value-Added Services. In addition, the terms and conditions on which any such"
        + " Value Added Services are so offered or provided shall be consistent with, and s"
        + "hall fully support, the intent and purpose of this License Agreement.\n"
        + "\n"
        + "(c)     All Downstream Distributions shall:\n"
        + "\n"
        + "                               (i)            include all portions and elements "
        + "of the Frameworx Code Base required to build the Source Code of such Downstream "
        + "Distribution into a fully functional machine-executable system, or additional bu"
        + "ild scripts or comparable software necessary and sufficient for such purposes;\n"
        + "\n"
        + "                             (ii)            include, in each file containing an"
        + "y portion or element of the Frameworx Code Base, the following identifying legen"
        + "d: This file contains software that has been made available under The Frameworx "
        + "Open License 1.0. Use and distribution hereof are subject to the restrictions se"
        + "t forth therein.\n"
        + "\n"
        + "                            (iii)            include all other copyright notices"
        + ", authorship credits, warranty disclaimers (including that provided in Section 6"
        + " below), legends, documentation, annotations and comments contained in the Frame"
        + "worx Code Base as provided to You hereunder;\n"
        + "\n"
        + "                            (iv)            contain an unaltered copy of the htm"
        + "l file named frameworx_community_invitation.html included within the Frameworx C"
        + "ode Base that acknowledges new users and provides them with information on the F"
        + "rameworx Code Base community;\n"
        + "\n"
        + "                              (v)            contain an unaltered copy of the te"
        + "xt file named the_frameworx_license.txt included within the Frameworx Code Base "
        + "that includes a text copy of the form of this License Agreement; and\n"
        + "\n"
        + "                            (vi)            prominently display to any viewer or"
        + " user of the Source Code of such Open Downstream Distribution, in the place and "
        + "manner normally used for such displays, the following legend:\n"
        + "\n"
        + "Source code licensed under from The Frameworx Company is contained herein, and s"
        + "uch source code has been obtained either under The Frameworx Open License, or an"
        + "other license granted by The Frameworx Company. Use and distribution hereof is s"
        + "ubject to the restrictions provided in the relevant such license and to the copy"
        + "rights of the licensor thereunder. A copy of The Frameworx Open License is provi"
        + "ded in a file named the_frameworx_license.txt and included herein, and may also "
        + "be available for inspection at http://www.frameworx.com.\n"
        + "\n"
        + "4. Restrictions on Open Downstream Distributions. Each Downstream Distribution m"
        + "ade by You, and by any party directly or indirectly obtaining rights to the Fram"
        + "eworx Code Base through You, shall be made subject to a license grant or agreeme"
        + "nt to the extent necessary so that each distributee under that Downstream Distri"
        + "bution will be subject to the same restrictions on re-distribution and use as ar"
        + "e binding on You hereunder. You may satisfy this licensing requirement either by"
        + ":\n"
        + "\n"
        + "(a)     requiring as a condition to any Downstream Distribution made by you, or "
        + "by any direct or indirect distributee of Your Downstream Distribution (or any po"
        + "rtion or element thereof), that each distributee under the relevant Downstream D"
        + "istribution obtain a direct license (on the same terms and conditions as those i"
        + "n this License Agreement) from The Frameworx Company; or\n"
        + "\n"
        + "(b)     sub-licensing all (and not less than all) of Your rights and obligations"
        + " hereunder to that distributee, including (without limitation) Your obligation t"
        + "o require distributees to be bound by license restrictions as contemplated by th"
        + "is Section 4 above.\n"
        + "\n"
        + "The Frameworx Company hereby grants to you all rights to sub-license your rights"
        + " hereunder as necessary to fully effect the intent and purpose of this Section 4"
        + " above, provided, however, that your rights and obligations hereunder shall be u"
        + "naffected by any such sublicensing. In addition, The Frameworx Company expressly"
        + " retains all rights to take all appropriate action (including legal action) agai"
        + "nst any such direct or indirect sub-licensee to ensure its full compliance with "
        + "the intent and purposes of this License Agreement.\n"
        + "\n"
        + "5. Intellectual Property. Except as expressly provided herein, this License Agre"
        + "ement preserves and respects Your and The Frameworx Companys respective intellec"
        + "tual property rights, including, in the case of The Frameworx Company, its copyr"
        + "ights and patent rights relating to the Frameworx Code Base.\n"
        + "\n"
        + "6. Warranty Disclaimer. THE SOFTWARE LICENSED HEREUNDER IS PROVIDED ``AS IS.'' A"
        + "NY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WAR"
        + "RANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEME"
        + "NT, ARE HEREBY DISCLAIMED. IN NO EVENT SHALL THE LICENSOR OF THIS SOFTWARE, BE L"
        + "IABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL"
        + " DAMAGES INCLUDING (BUT NOT LIMITED TO) PROCUREMENT OF SUBSTITUTE GOODS OR SERVI"
        + "CES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND"
        + " ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY OR TORT (INCL"
        + "UDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWAR"
        + "E, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n"
        + "\n"
        + "7. License Violation. The License, and all of your rights thereunder, shall be d"
        + "eemed automatically terminated and void as of any Downstream Distribution direct"
        + "ly or indirectly made or facilitated by You that violates the provisions of this"
        + " License Agreement, provided, however, that this License Agreement shall survive"
        + " any such termination in order to remedy the effects of such violation. This Lic"
        + "ense Agreement shall be binding on the legal successors and assigns of the parti"
        + "es hereto.\n"
        + "\n"
        + "Your agreement to the foregoing as of the date hereof has been evidenced by your"
        + " acceptance of the relevant software distribution hereunder.\n"
        + "\n"
        + "(C) THE FRAMEWORX COMPANY 2003\n"
; // the license text
    }
 
    
}
