package spdxlib;

/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito
 * Created: 2014-05-15T11:43:29Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: LicenseType.java 
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014, Nuno Brito </text>
 */

public enum LicenseType {
        // added for own use
	Public_Domain,
        Proprietary,
        MPL_2_0_plus,
        GPL,
        LGPL,
        BSD,
        // from the SPDX site
	AFL_1_1,                                 // Academic Free License v1.1
	AFL_1_2,                                 // Academic Free License v1.2
	AFL_2_0,                                 // Academic Free License v2.0
	AFL_2_1,                                 // Academic Free License v2.1
	AFL_3_0,                                 // Academic Free License v3.0
	APL_1_0,                                 // Adaptive Public License 1.0
	Aladdin,                                 // Aladdin Free Public License
	ANTLR_PD,                                // ANTLR Software Rights Notice
	Apache_1_0,                              // Apache License 1.0
	Apache_1_1,                              // Apache License 1.1
	Apache_2_0,                              // Apache License 2.0
	APSL_1_0,                                // Apple Public Source License 1.0
	APSL_1_1,                                // Apple Public Source License 1.1
	APSL_1_2,                                // Apple Public Source License 1.2
	APSL_2_0,                                // Apple Public Source License 2.0
	Artistic_1_0,                            // Artistic License 1.0
	Artistic_1_0_cl8,                        // Artistic License 1.0 w/clause 8
	Artistic_1_0_Perl,                       // Artistic License 1.0 (Perl)
	Artistic_2_0,                            // Artistic License 2.0
	AAL,                                     // Attribution Assurance License
	BitTorrent_1_0,                          // BitTorrent Open Source License v1.0
	BitTorrent_1_1,                          // BitTorrent Open Source License v1.1
	BSL_1_0,                                 // Boost Software License 1.0
	BSD_2_Clause,                            // BSD 2-clause "Simplified" License
	BSD_2_Clause_FreeBSD,                    // BSD 2-clause FreeBSD License
	BSD_2_Clause_NetBSD,                     // BSD 2-clause NetBSD License
	BSD_3_Clause,                            // BSD 3-clause "New" or "Revised" License
	BSD_3_Clause_Clear,                      // BSD 3-clause Clear License
	BSD_4_Clause,                            // BSD 4-clause "Original" or "Old" License
	BSD_4_Clause_UC,                         // BSD-4-Clause (University of California-Specific)
	CECILL_1_0,                              // CeCILL Free Software License Agreement v1.0
	CECILL_1_1,                              // CeCILL Free Software License Agreement v1.1
	CECILL_2_0,                              // CeCILL Free Software License Agreement v2.0
	CECILL_B,                                // CeCILL-B Free Software License Agreement
	CECILL_C,                                // CeCILL-C Free Software License Agreement
	ClArtistic,                              // Clarified Artistic License
	CNRI_Python,                             // CNRI Python License
	CNRI_Python_GPL_Compatible,              // CNRI Python Open Source GPL Compatible License Agreement
	CPOL_1_02,                               // Code Project Open License 1.02
	CDDL_1_0,                                // Common Development and Distribution License 1.0
	CDDL_1_1,                                // Common Development and Distribution License 1.1
	CPAL_1_0,                                // Common Public Attribution License 1.0 
	CPL_1_0,                                 // Common Public License 1.0
	CATOSL_1_1,                              // Computer Associates Trusted Open Source License 1.1
	Condor_1_1,                              // Condor Public License v1.1
	CC_BY_1_0,                               // Creative Commons Attribution 1.0
	CC_BY_2_0,                               // Creative Commons Attribution 2.0
	CC_BY_2_5,                               // Creative Commons Attribution 2.5
	CC_BY_3_0,                               // Creative Commons Attribution 3.0
	CC_BY_ND_1_0,                            // Creative Commons Attribution No Derivatives 1.0
	CC_BY_ND_2_0,                            // Creative Commons Attribution No Derivatives 2.0
	CC_BY_ND_2_5,                            // Creative Commons Attribution No Derivatives 2.5
	CC_BY_ND_3_0,                            // Creative Commons Attribution No Derivatives 3.0
	CC_BY_NC_1_0,                            // Creative Commons Attribution Non Commercial 1.0
	CC_BY_NC_2_0,                            // Creative Commons Attribution Non Commercial 2.0
	CC_BY_NC_2_5,                            // Creative Commons Attribution Non Commercial 2.5
	CC_BY_NC_3_0,                            // Creative Commons Attribution Non Commercial 3.0
	CC_BY_NC_ND_1_0,                         // Creative Commons Attribution Non Commercial No Derivatives 1.0
	CC_BY_NC_ND_2_0,                         // Creative Commons Attribution Non Commercial No Derivatives 2.0
	CC_BY_NC_ND_2_5,                         // Creative Commons Attribution Non Commercial No Derivatives 2.5
	CC_BY_NC_ND_3_0,                         // Creative Commons Attribution Non Commercial No Derivatives 3.0
	CC_BY_NC_SA_1_0,                         // Creative Commons Attribution Non Commercial Share Alike 1.0
	CC_BY_NC_SA_2_0,                         // Creative Commons Attribution Non Commercial Share Alike 2.0
	CC_BY_NC_SA_2_5,                         // Creative Commons Attribution Non Commercial Share Alike 2.5
	CC_BY_NC_SA_3_0,                         // Creative Commons Attribution Non Commercial Share Alike 3.0
	CC_BY_SA_1_0,                            // Creative Commons Attribution Share Alike 1.0
	CC_BY_SA_2_0,                            // Creative Commons Attribution Share Alike 2.0
	CC_BY_SA_2_5,                            // Creative Commons Attribution Share Alike 2.5
	CC_BY_SA_3_0,                            // Creative Commons Attribution Share Alike 3.0
	CC0_1_0,                                 // Creative Commons Zero v1.0 Universal
	CUA_OPL_1_0,                             // CUA Office Public License v1.0
	D_FSL_1_0,                               // Deutsche Freie Software Lizenz
	WTFPL,                                   // Do What The F*ck You Want To Public License
	EPL_1_0,                                 // Eclipse Public License 1.0
	eCos_2_0,                                // eCos license version 2.0
	ECL_1_0,                                 // Educational Community License v1.0
	ECL_2_0,                                 // Educational Community License v2.0
	EFL_1_0,                                 // Eiffel Forum License v1.0
	EFL_2_0,                                 // Eiffel Forum License v2.0
	Entessa,                                 // Entessa Public License v1.0
	ErlPL_1_1,                               // Erlang Public License v1.1
	EUDatagrid,                              // EU DataGrid Software License
	EUPL_1_0,                                // European Union Public License 1.0
	EUPL_1_1,                                // European Union Public License 1.1
	Fair,                                    // Fair License
	Frameworx_1_0,                           // Frameworx Open License 1.0
	FTL,                                     // Freetype Project License
	AGPL_1_0,                                // GNU Affero General Public License v1.0
	AGPL_3_0,                                // GNU Affero General Public License v3.0
	GFDL_1_1,                                // GNU Free Documentation License v1.1
	GFDL_1_2,                                // GNU Free Documentation License v1.2
	GFDL_1_3,                                // GNU Free Documentation License v1.3
	GPL_1_0,                                 // GNU General Public License v1.0 only
	GPL_1_0_plus,                            // GNU General Public License v1.0 or later
	GPL_2_0,                                 // GNU General Public License v2.0 only
	GPL_2_0_plus,                            // GNU General Public License v2.0 or later
	GPL_2_0_with_autoconf_exception,         // GNU General Public License v2.0 w/Autoconf exception
	GPL_2_0_with_bison_exception,            // GNU General Public License v2.0 w/Bison exception
	GPL_2_0_with_classpath_exception,        // GNU General Public License v2.0 w/Classpath exception
	GPL_2_0_with_font_exception,             // GNU General Public License v2.0 w/Font exception
	GPL_2_0_with_GCC_exception,              // GNU General Public License v2.0 w/GCC Runtime Library exception
	GPL_3_0,                                 // GNU General Public License v3.0 only
	GPL_3_0_plus,                            // GNU General Public License v3.0 or later
	GPL_3_0_with_autoconf_exception,         // GNU General Public License v3.0 w/Autoconf exception
	GPL_3_0_with_GCC_exception,              // GNU General Public License v3.0 w/GCC Runtime Library exception
	LGPL_2_1,                                // GNU Lesser General Public License v2.1 only
	LGPL_2_1_plus,                           // GNU Lesser General Public License v2.1 or later
	LGPL_3_0,                                // GNU Lesser General Public License v3.0 only
	LGPL_3_0_plus,                           // GNU Lesser General Public License v3.0 or later
	LGPL_2_0,                                // GNU Library General Public License v2 only
	LGPL_2_0_plus,                           // GNU Library General Public License v2 or later
	gSOAP_1_3b,                              // gSOAP Public License v1.3b
	HPND,                                    // Historic Permission Notice and Disclaimer
	IBM_pibs,                                // IBM PowerPC Initialization and Boot Software 
	IPL_1_0,                                 // IBM Public License v1.0
	Imlib2,                                  // Imlib2 License
	IJG,                                     // Independent JPEG Group License
	Intel,                                   // Intel Open Source License
	IPA,                                     // IPA Font License
	ISC,                                     // ISC License
	JSON,                                    // JSON License
	LPPL_1_3a,                               // LaTeX Project Public License 1.3a 
	LPPL_1_0,                                // LaTeX Project Public License v1.0
	LPPL_1_1,                                // LaTeX Project Public License v1.1
	LPPL_1_2,                                // LaTeX Project Public License v1.2
	LPPL_1_3c,                               // LaTeX Project Public License v1.3c
	Libpng,                                  // libpng License
	LPL_1_02,                                // Lucent Public License v1.02
	LPL_1_0,                                 // Lucent Public License Version 1.0
	MS_PL,                                   // Microsoft Public License
	MS_RL,                                   // Microsoft Reciprocal License
	MirOS,                                   // MirOS Licence
	MIT,                                     // MIT License
	Motosoto,                                // Motosoto License
	MPL_1_0,                                 // Mozilla Public License 1.0
	MPL_1_1,                                 // Mozilla Public License 1.1 
	MPL_2_0,                                 // Mozilla Public License 2.0
	MPL_2_0_no_copyleft_exception,           // Mozilla Public License 2.0 (no copyleft exception)
	Multics,                                 // Multics License
	NASA_1_3,                                // NASA Open Source Agreement 1.3
	Naumen,                                  // Naumen Public License
	NBPL_1_0,                                // Net Boolean Public License v1 
	NGPL,                                    // Nethack General Public License
	NOSL,                                    // Netizen Open Source License
	NPL_1_0,                                 // Netscape Public License v1.0
	NPL_1_1,                                 // Netscape Public License v1.1
	Nokia,                                   // Nokia Open Source License
	NPOSL_3_0,                               // Non-Profit Open Software License 3.0
	NTP,                                     // NTP License
	OCLC_2_0,                                // OCLC Research Public License 2.0
	ODbL_1_0,                                // ODC Open Database License v1.0
	PDDL_1_0,                                // ODC Public Domain Dedication & License 1.0
	OGTSL,                                   // Open Group Test Suite License
	OLDAP_2_2_2,                             // Open LDAP Public License  2.2.2
	OLDAP_1_1,                               // Open LDAP Public License v1.1
	OLDAP_1_2,                               // Open LDAP Public License v1.2 
	OLDAP_1_3,                               // Open LDAP Public License v1.3
	OLDAP_1_4,                               // Open LDAP Public License v1.4
	OLDAP_2_0,                               // Open LDAP Public License v2.0 (or possibly 2.0A and 2.0B)
	OLDAP_2_0_1,                             // Open LDAP Public License v2.0.1
	OLDAP_2_1,                               // Open LDAP Public License v2.1
	OLDAP_2_2,                               // Open LDAP Public License v2.2
	OLDAP_2_2_1,                             // Open LDAP Public License v2.2.1
	OLDAP_2_3,                               // Open LDAP Public License v2.3
	OLDAP_2_4,                               // Open LDAP Public License v2.4
	OLDAP_2_5,                               // Open LDAP Public License v2.5
	OLDAP_2_6,                               // Open LDAP Public License v2.6
	OLDAP_2_7,                               // Open LDAP Public License v2.7
	OPL_1_0,                                 // Open Public License v1.0
	OSL_1_0,                                 // Open Software License 1.0
	OSL_2_0,                                 // Open Software License 2.0
	OSL_2_1,                                 // Open Software License 2.1
	OSL_3_0,                                 // Open Software License 3.0
	OLDAP_2_8,                               // OpenLDAP Public License v2.8
	OpenSSL,                                 // OpenSSL License
	PHP_3_0,                                 // PHP License v3.0
	PHP_3_01,                                // PHP License v3.01
	PostgreSQL,                              // PostgreSQL License
	Python_2_0,                              // Python License 2.0
	QPL_1_0,                                 // Q Public License 1.0
	RPSL_1_0,                                // RealNetworks Public Source License v1.0
	RPL_1_1,                                 // Reciprocal Public License 1.1
	RPL_1_5,                                 // Reciprocal Public License 1.5 
	RHeCos_1_1,                              // Red Hat eCos Public License v1.1
	RSCPL,                                   // Ricoh Source Code Public License
	Ruby,                                    // Ruby License
	SAX_PD,                                  // Sax Public Domain Notice
	SGI_B_1_0,                               // SGI Free Software License B v1.0
	SGI_B_1_1,                               // SGI Free Software License B v1.1
	SGI_B_2_0,                               // SGI Free Software License B v2.0
	OFL_1_0,                                 // SIL Open Font License 1.0
	OFL_1_1,                                 // SIL Open Font License 1.1
	SimPL_2_0,                               // Simple Public License 2.0
	Sleepycat,                               // Sleepycat License
	SMLNJ,                                   // Standard ML of New Jersey License
	SugarCRM_1_1_3,                          // SugarCRM Public License v1.1.3
	SISSL,                                   // Sun Industry Standards Source License v1.1
	SISSL_1_2,                               // Sun Industry Standards Source License v1.2
	SPL_1_0,                                 // Sun Public License v1.0
	Watcom_1_0,                              // Sybase Open Watcom Public License 1.0
	NCSA,                                    // University of Illinois/NCSA Open Source License
	VSL_1_0,                                 // Vovida Software License v1.0
	W3C,                                     // W3C Software Notice and License
	WXwindows,                               // wxWindows Library License
	Xnet,                                    // X.Net License
	X11,                                     // X11 License
	XFree86_1_1,                             // XFree86 License 1.1
	YPL_1_0,                                 // Yahoo! Public License v1.0
	YPL_1_1,                                 // Yahoo! Public License v1.1
	Zimbra_1_3,                              // Zimbra Public License v1.3
	Zlib,                                    // zlib License
	ZPL_1_1,                                 // Zope Public License 1.1
	ZPL_2_0,                                 // Zope Public License 2.0
	ZPL_2_1,                                 // Zope Public License 2.1
	Unlicense;                               // The Unlicense


	public String toTitle(){
        switch(this){
        // own usage    
	case Public_Domain: return "Public Domain";
        case Proprietary: return "Proprietary";
        case MPL_2_0_plus: return "Mozilla Public License 2.0 or later";                                 
        case GPL: return "GNU General Public License (version not defined)";                                 
        case LGPL: return "GNU Lesser General Public License (version not defined)";                                 
        case BSD: return "BSD-like license (type not defined)";                                 
        
        // SPDX list    
	case AFL_1_1: return "Academic Free License v1.1";
	case AFL_1_2: return "Academic Free License v1.2";
	case AFL_2_0: return "Academic Free License v2.0";
	case AFL_2_1: return "Academic Free License v2.1";
	case AFL_3_0: return "Academic Free License v3.0";
	case APL_1_0: return "Adaptive Public License 1.0";
	case Aladdin: return "Aladdin Free Public License";
	case ANTLR_PD: return "ANTLR Software Rights Notice";
	case Apache_1_0: return "Apache License 1.0";
	case Apache_1_1: return "Apache License 1.1";
	case Apache_2_0: return "Apache License 2.0";
	case APSL_1_0: return "Apple Public Source License 1.0";
	case APSL_1_1: return "Apple Public Source License 1.1";
	case APSL_1_2: return "Apple Public Source License 1.2";
	case APSL_2_0: return "Apple Public Source License 2.0";
	case Artistic_1_0: return "Artistic License 1.0";
	case Artistic_1_0_cl8: return "Artistic License 1.0 w/clause 8";
	case Artistic_1_0_Perl: return "Artistic License 1.0 (Perl)";
	case Artistic_2_0: return "Artistic License 2.0";
	case AAL: return "Attribution Assurance License";
	case BitTorrent_1_0: return "BitTorrent Open Source License v1.0";
	case BitTorrent_1_1: return "BitTorrent Open Source License v1.1";
	case BSL_1_0: return "Boost Software License 1.0";
	case BSD_2_Clause: return "BSD 2-clause \"Simplified\" License";
	case BSD_2_Clause_FreeBSD: return "BSD 2-clause FreeBSD License";
	case BSD_2_Clause_NetBSD: return "BSD 2-clause NetBSD License";
	case BSD_3_Clause: return "BSD 3-clause \"New\" or \"Revised\" License";
	case BSD_3_Clause_Clear: return "BSD 3-clause Clear License";
	case BSD_4_Clause: return "BSD 4-clause \"Original\" or \"Old\" License";
	case BSD_4_Clause_UC: return "BSD-4-Clause (University of California-Specific)";
	case CECILL_1_0: return "CeCILL Free Software License Agreement v1.0";
	case CECILL_1_1: return "CeCILL Free Software License Agreement v1.1";
	case CECILL_2_0: return "CeCILL Free Software License Agreement v2.0";
	case CECILL_B: return "CeCILL-B Free Software License Agreement";
	case CECILL_C: return "CeCILL-C Free Software License Agreement";
	case ClArtistic: return "Clarified Artistic License";
	case CNRI_Python: return "CNRI Python License";
	case CNRI_Python_GPL_Compatible: return "CNRI Python Open Source GPL Compatible License Agreement";
	case CPOL_1_02: return "Code Project Open License 1.02";
	case CDDL_1_0: return "Common Development and Distribution License 1.0";
	case CDDL_1_1: return "Common Development and Distribution License 1.1";
	case CPAL_1_0: return "Common Public Attribution License 1.0 ";
	case CPL_1_0: return "Common Public License 1.0";
	case CATOSL_1_1: return "Computer Associates Trusted Open Source License 1.1";
	case Condor_1_1: return "Condor Public License v1.1";
	case CC_BY_1_0: return "Creative Commons Attribution 1.0";
	case CC_BY_2_0: return "Creative Commons Attribution 2.0";
	case CC_BY_2_5: return "Creative Commons Attribution 2.5";
	case CC_BY_3_0: return "Creative Commons Attribution 3.0";
	case CC_BY_ND_1_0: return "Creative Commons Attribution No Derivatives 1.0";
	case CC_BY_ND_2_0: return "Creative Commons Attribution No Derivatives 2.0";
	case CC_BY_ND_2_5: return "Creative Commons Attribution No Derivatives 2.5";
	case CC_BY_ND_3_0: return "Creative Commons Attribution No Derivatives 3.0";
	case CC_BY_NC_1_0: return "Creative Commons Attribution Non Commercial 1.0";
	case CC_BY_NC_2_0: return "Creative Commons Attribution Non Commercial 2.0";
	case CC_BY_NC_2_5: return "Creative Commons Attribution Non Commercial 2.5";
	case CC_BY_NC_3_0: return "Creative Commons Attribution Non Commercial 3.0";
	case CC_BY_NC_ND_1_0: return "Creative Commons Attribution Non Commercial No Derivatives 1.0";
	case CC_BY_NC_ND_2_0: return "Creative Commons Attribution Non Commercial No Derivatives 2.0";
	case CC_BY_NC_ND_2_5: return "Creative Commons Attribution Non Commercial No Derivatives 2.5";
	case CC_BY_NC_ND_3_0: return "Creative Commons Attribution Non Commercial No Derivatives 3.0";
	case CC_BY_NC_SA_1_0: return "Creative Commons Attribution Non Commercial Share Alike 1.0";
	case CC_BY_NC_SA_2_0: return "Creative Commons Attribution Non Commercial Share Alike 2.0";
	case CC_BY_NC_SA_2_5: return "Creative Commons Attribution Non Commercial Share Alike 2.5";
	case CC_BY_NC_SA_3_0: return "Creative Commons Attribution Non Commercial Share Alike 3.0";
	case CC_BY_SA_1_0: return "Creative Commons Attribution Share Alike 1.0";
	case CC_BY_SA_2_0: return "Creative Commons Attribution Share Alike 2.0";
	case CC_BY_SA_2_5: return "Creative Commons Attribution Share Alike 2.5";
	case CC_BY_SA_3_0: return "Creative Commons Attribution Share Alike 3.0";
	case CC0_1_0: return "Creative Commons Zero v1.0 Universal";
	case CUA_OPL_1_0: return "CUA Office Public License v1.0";
	case D_FSL_1_0: return "Deutsche Freie Software Lizenz";
	case WTFPL: return "Do What The F*ck You Want To Public License";
	case EPL_1_0: return "Eclipse Public License 1.0";
	case eCos_2_0: return "eCos license version 2.0";
	case ECL_1_0: return "Educational Community License v1.0";
	case ECL_2_0: return "Educational Community License v2.0";
	case EFL_1_0: return "Eiffel Forum License v1.0";
	case EFL_2_0: return "Eiffel Forum License v2.0";
	case Entessa: return "Entessa Public License v1.0";
	case ErlPL_1_1: return "Erlang Public License v1.1";
	case EUDatagrid: return "EU DataGrid Software License";
	case EUPL_1_0: return "European Union Public License 1.0";
	case EUPL_1_1: return "European Union Public License 1.1";
	case Fair: return "Fair License";
	case Frameworx_1_0: return "Frameworx Open License 1.0";
	case FTL: return "Freetype Project License";
	case AGPL_1_0: return "GNU Affero General Public License v1.0";
	case AGPL_3_0: return "GNU Affero General Public License v3.0";
	case GFDL_1_1: return "GNU Free Documentation License v1.1";
	case GFDL_1_2: return "GNU Free Documentation License v1.2";
	case GFDL_1_3: return "GNU Free Documentation License v1.3";
	case GPL_1_0: return "GNU General Public License v1.0 only";
	case GPL_1_0_plus: return "GNU General Public License v1.0 or later";
	case GPL_2_0: return "GNU General Public License v2.0 only";
	case GPL_2_0_plus: return "GNU General Public License v2.0 or later";
	case GPL_2_0_with_autoconf_exception: return "GNU General Public License v2.0 w/Autoconf exception";
	case GPL_2_0_with_bison_exception: return "GNU General Public License v2.0 w/Bison exception";
	case GPL_2_0_with_classpath_exception: return "GNU General Public License v2.0 w/Classpath exception";
	case GPL_2_0_with_font_exception: return "GNU General Public License v2.0 w/Font exception";
	case GPL_2_0_with_GCC_exception: return "GNU General Public License v2.0 w/GCC Runtime Library exception";
	case GPL_3_0: return "GNU General Public License v3.0 only";
	case GPL_3_0_plus: return "GNU General Public License v3.0 or later";
	case GPL_3_0_with_autoconf_exception: return "GNU General Public License v3.0 w/Autoconf exception";
	case GPL_3_0_with_GCC_exception: return "GNU General Public License v3.0 w/GCC Runtime Library exception";
	case LGPL_2_1: return "GNU Lesser General Public License v2.1 only";
	case LGPL_2_1_plus: return "GNU Lesser General Public License v2.1 or later";
	case LGPL_3_0: return "GNU Lesser General Public License v3.0 only";
	case LGPL_3_0_plus: return "GNU Lesser General Public License v3.0 or later";
	case LGPL_2_0: return "GNU Library General Public License v2 only";
	case LGPL_2_0_plus: return "GNU Library General Public License v2 or later";
	case gSOAP_1_3b: return "gSOAP Public License v1.3b";
	case HPND: return "Historic Permission Notice and Disclaimer";
	case IBM_pibs: return "IBM PowerPC Initialization and Boot Software ";
	case IPL_1_0: return "IBM Public License v1.0";
	case Imlib2: return "Imlib2 License";
	case IJG: return "Independent JPEG Group License";
	case Intel: return "Intel Open Source License";
	case IPA: return "IPA Font License";
	case ISC: return "ISC License";
	case JSON: return "JSON License";
	case LPPL_1_3a: return "LaTeX Project Public License 1.3a ";
	case LPPL_1_0: return "LaTeX Project Public License v1.0";
	case LPPL_1_1: return "LaTeX Project Public License v1.1";
	case LPPL_1_2: return "LaTeX Project Public License v1.2";
	case LPPL_1_3c: return "LaTeX Project Public License v1.3c";
	case Libpng: return "libpng License";
	case LPL_1_02: return "Lucent Public License v1.02";
	case LPL_1_0: return "Lucent Public License Version 1.0";
	case MS_PL: return "Microsoft Public License";
	case MS_RL: return "Microsoft Reciprocal License";
	case MirOS: return "MirOS Licence";
	case MIT: return "MIT License";
	case Motosoto: return "Motosoto License";
	case MPL_1_0: return "Mozilla Public License 1.0";
	case MPL_1_1: return "Mozilla Public License 1.1 ";
	case MPL_2_0: return "Mozilla Public License 2.0";
	case MPL_2_0_no_copyleft_exception: return "Mozilla Public License 2.0 (no copyleft exception)";
	case Multics: return "Multics License";
	case NASA_1_3: return "NASA Open Source Agreement 1.3";
	case Naumen: return "Naumen Public License";
	case NBPL_1_0: return "Net Boolean Public License v1 ";
	case NGPL: return "Nethack General Public License";
	case NOSL: return "Netizen Open Source License";
	case NPL_1_0: return "Netscape Public License v1.0";
	case NPL_1_1: return "Netscape Public License v1.1";
	case Nokia: return "Nokia Open Source License";
	case NPOSL_3_0: return "Non-Profit Open Software License 3.0";
	case NTP: return "NTP License";
	case OCLC_2_0: return "OCLC Research Public License 2.0";
	case ODbL_1_0: return "ODC Open Database License v1.0";
	case PDDL_1_0: return "ODC Public Domain Dedication & License 1.0";
	case OGTSL: return "Open Group Test Suite License";
	case OLDAP_2_2_2: return "Open LDAP Public License  2.2.2";
	case OLDAP_1_1: return "Open LDAP Public License v1.1";
	case OLDAP_1_2: return "Open LDAP Public License v1.2 ";
	case OLDAP_1_3: return "Open LDAP Public License v1.3";
	case OLDAP_1_4: return "Open LDAP Public License v1.4";
	case OLDAP_2_0: return "Open LDAP Public License v2.0 (or possibly 2.0A and 2.0B)";
	case OLDAP_2_0_1: return "Open LDAP Public License v2.0.1";
	case OLDAP_2_1: return "Open LDAP Public License v2.1";
	case OLDAP_2_2: return "Open LDAP Public License v2.2";
	case OLDAP_2_2_1: return "Open LDAP Public License v2.2.1";
	case OLDAP_2_3: return "Open LDAP Public License v2.3";
	case OLDAP_2_4: return "Open LDAP Public License v2.4";
	case OLDAP_2_5: return "Open LDAP Public License v2.5";
	case OLDAP_2_6: return "Open LDAP Public License v2.6";
	case OLDAP_2_7: return "Open LDAP Public License v2.7";
	case OPL_1_0: return "Open Public License v1.0";
	case OSL_1_0: return "Open Software License 1.0";
	case OSL_2_0: return "Open Software License 2.0";
	case OSL_2_1: return "Open Software License 2.1";
	case OSL_3_0: return "Open Software License 3.0";
	case OLDAP_2_8: return "OpenLDAP Public License v2.8";
	case OpenSSL: return "OpenSSL License";
	case PHP_3_0: return "PHP License v3.0";
	case PHP_3_01: return "PHP License v3.01";
	case PostgreSQL: return "PostgreSQL License";
	case Python_2_0: return "Python License 2.0";
	case QPL_1_0: return "Q Public License 1.0";
	case RPSL_1_0: return "RealNetworks Public Source License v1.0";
	case RPL_1_1: return "Reciprocal Public License 1.1";
	case RPL_1_5: return "Reciprocal Public License 1.5 ";
	case RHeCos_1_1: return "Red Hat eCos Public License v1.1";
	case RSCPL: return "Ricoh Source Code Public License";
	case Ruby: return "Ruby License";
	case SAX_PD: return "Sax Public Domain Notice";
	case SGI_B_1_0: return "SGI Free Software License B v1.0";
	case SGI_B_1_1: return "SGI Free Software License B v1.1";
	case SGI_B_2_0: return "SGI Free Software License B v2.0";
	case OFL_1_0: return "SIL Open Font License 1.0";
	case OFL_1_1: return "SIL Open Font License 1.1";
	case SimPL_2_0: return "Simple Public License 2.0";
	case Sleepycat: return "Sleepycat License";
	case SMLNJ: return "Standard ML of New Jersey License";
	case SugarCRM_1_1_3: return "SugarCRM Public License v1.1.3";
	case SISSL: return "Sun Industry Standards Source License v1.1";
	case SISSL_1_2: return "Sun Industry Standards Source License v1.2";
	case SPL_1_0: return "Sun Public License v1.0";
	case Watcom_1_0: return "Sybase Open Watcom Public License 1.0";
	case NCSA: return "University of Illinois/NCSA Open Source License";
	case VSL_1_0: return "Vovida Software License v1.0";
	case W3C: return "W3C Software Notice and License";
	case WXwindows: return "wxWindows Library License";
	case Xnet: return "X.Net License";
	case X11: return "X11 License";
	case XFree86_1_1: return "XFree86 License 1.1";
	case YPL_1_0: return "Yahoo! Public License v1.0";
	case YPL_1_1: return "Yahoo! Public License v1.1";
	case Zimbra_1_3: return "Zimbra Public License v1.3";
	case Zlib: return "zlib License";
	case ZPL_1_1: return "Zope Public License 1.1";
	case ZPL_2_0: return "Zope Public License 2.0";
	case ZPL_2_1: return "Zope Public License 2.1";
	case Unlicense: return "The Unlicense";
	default: return "Not recognized";
		}
	}

	public String toId(){
        switch(this){
        // own usage
        case Public_Domain: return "Public Domain";
        case Proprietary: return "Proprietary";
        case MPL_2_0_plus: return "MPL-2.0+";                                 
        case GPL: return "GPL";                                 
        case LGPL: return "LGPL";                                 
        case BSD: return "BSD";                                 
        
	// SPDX list 
	case AFL_1_1: return "AFL-1.1";
	case AFL_1_2: return "AFL-1.2";
	case AFL_2_0: return "AFL-2.0";
	case AFL_2_1: return "AFL-2.1";
	case AFL_3_0: return "AFL-3.0";
	case APL_1_0: return "APL-1.0";
	case Aladdin: return "Aladdin";
	case ANTLR_PD: return "ANTLR-PD";
	case Apache_1_0: return "Apache-1.0";
	case Apache_1_1: return "Apache-1.1";
	case Apache_2_0: return "Apache-2.0";
	case APSL_1_0: return "APSL-1.0";
	case APSL_1_1: return "APSL-1.1";
	case APSL_1_2: return "APSL-1.2";
	case APSL_2_0: return "APSL-2.0";
	case Artistic_1_0: return "Artistic-1.0";
	case Artistic_1_0_cl8: return "Artistic-1.0-cl8";
	case Artistic_1_0_Perl: return "Artistic-1.0-Perl";
	case Artistic_2_0: return "Artistic-2.0";
	case AAL: return "AAL";
	case BitTorrent_1_0: return "BitTorrent-1.0";
	case BitTorrent_1_1: return "BitTorrent-1.1";
	case BSL_1_0: return "BSL-1.0";
	case BSD_2_Clause: return "BSD-2-Clause";
	case BSD_2_Clause_FreeBSD: return "BSD-2-Clause-FreeBSD";
	case BSD_2_Clause_NetBSD: return "BSD-2-Clause-NetBSD";
	case BSD_3_Clause: return "BSD-3-Clause";
	case BSD_3_Clause_Clear: return "BSD-3-Clause-Clear";
	case BSD_4_Clause: return "BSD-4-Clause";
	case BSD_4_Clause_UC: return "BSD-4-Clause-UC";
	case CECILL_1_0: return "CECILL-1.0";
	case CECILL_1_1: return "CECILL-1.1";
	case CECILL_2_0: return "CECILL-2.0";
	case CECILL_B: return "CECILL-B";
	case CECILL_C: return "CECILL-C";
	case ClArtistic: return "ClArtistic";
	case CNRI_Python: return "CNRI-Python";
	case CNRI_Python_GPL_Compatible: return "CNRI-Python-GPL-Compatible";
	case CPOL_1_02: return "CPOL-1.02";
	case CDDL_1_0: return "CDDL-1.0";
	case CDDL_1_1: return "CDDL-1.1";
	case CPAL_1_0: return "CPAL-1.0";
	case CPL_1_0: return "CPL-1.0";
	case CATOSL_1_1: return "CATOSL-1.1";
	case Condor_1_1: return "Condor-1.1";
	case CC_BY_1_0: return "CC-BY-1.0";
	case CC_BY_2_0: return "CC-BY-2.0";
	case CC_BY_2_5: return "CC-BY-2.5";
	case CC_BY_3_0: return "CC-BY-3.0";
	case CC_BY_ND_1_0: return "CC-BY-ND-1.0";
	case CC_BY_ND_2_0: return "CC-BY-ND-2.0";
	case CC_BY_ND_2_5: return "CC-BY-ND-2.5";
	case CC_BY_ND_3_0: return "CC-BY-ND-3.0";
	case CC_BY_NC_1_0: return "CC-BY-NC-1.0";
	case CC_BY_NC_2_0: return "CC-BY-NC-2.0";
	case CC_BY_NC_2_5: return "CC-BY-NC-2.5";
	case CC_BY_NC_3_0: return "CC-BY-NC-3.0";
	case CC_BY_NC_ND_1_0: return "CC-BY-NC-ND-1.0";
	case CC_BY_NC_ND_2_0: return "CC-BY-NC-ND-2.0";
	case CC_BY_NC_ND_2_5: return "CC-BY-NC-ND-2.5";
	case CC_BY_NC_ND_3_0: return "CC-BY-NC-ND-3.0";
	case CC_BY_NC_SA_1_0: return "CC-BY-NC-SA-1.0";
	case CC_BY_NC_SA_2_0: return "CC-BY-NC-SA-2.0";
	case CC_BY_NC_SA_2_5: return "CC-BY-NC-SA-2.5";
	case CC_BY_NC_SA_3_0: return "CC-BY-NC-SA-3.0";
	case CC_BY_SA_1_0: return "CC-BY-SA-1.0";
	case CC_BY_SA_2_0: return "CC-BY-SA-2.0";
	case CC_BY_SA_2_5: return "CC-BY-SA-2.5";
	case CC_BY_SA_3_0: return "CC-BY-SA-3.0";
	case CC0_1_0: return "CC0-1.0";
	case CUA_OPL_1_0: return "CUA-OPL-1.0";
	case D_FSL_1_0: return "D-FSL-1.0";
	case WTFPL: return "WTFPL";
	case EPL_1_0: return "EPL-1.0";
	case eCos_2_0: return "eCos-2.0";
	case ECL_1_0: return "ECL-1.0";
	case ECL_2_0: return "ECL-2.0";
	case EFL_1_0: return "EFL-1.0";
	case EFL_2_0: return "EFL-2.0";
	case Entessa: return "Entessa";
	case ErlPL_1_1: return "ErlPL-1.1";
	case EUDatagrid: return "EUDatagrid";
	case EUPL_1_0: return "EUPL-1.0";
	case EUPL_1_1: return "EUPL-1.1";
	case Fair: return "Fair";
	case Frameworx_1_0: return "Frameworx-1.0";
	case FTL: return "FTL";
	case AGPL_1_0: return "AGPL-1.0";
	case AGPL_3_0: return "AGPL-3.0";
	case GFDL_1_1: return "GFDL-1.1";
	case GFDL_1_2: return "GFDL-1.2";
	case GFDL_1_3: return "GFDL-1.3";
	case GPL_1_0: return "GPL-1.0";
	case GPL_1_0_plus: return "GPL-1.0+";
	case GPL_2_0: return "GPL-2.0";
	case GPL_2_0_plus: return "GPL-2.0+";
	case GPL_2_0_with_autoconf_exception: return "GPL-2.0-with-autoconf-exception";
	case GPL_2_0_with_bison_exception: return "GPL-2.0-with-bison-exception";
	case GPL_2_0_with_classpath_exception: return "GPL-2.0-with-classpath-exception";
	case GPL_2_0_with_font_exception: return "GPL-2.0-with-font-exception";
	case GPL_2_0_with_GCC_exception: return "GPL-2.0-with-GCC-exception";
	case GPL_3_0: return "GPL-3.0";
	case GPL_3_0_plus: return "GPL-3.0+";
	case GPL_3_0_with_autoconf_exception: return "GPL-3.0-with-autoconf-exception";
	case GPL_3_0_with_GCC_exception: return "GPL-3.0-with-GCC-exception";
	case LGPL_2_1: return "LGPL-2.1";
	case LGPL_2_1_plus: return "LGPL-2.1+";
	case LGPL_3_0: return "LGPL-3.0";
	case LGPL_3_0_plus: return "LGPL-3.0+";
	case LGPL_2_0: return "LGPL-2.0";
	case LGPL_2_0_plus: return "LGPL-2.0+";
	case gSOAP_1_3b: return "gSOAP-1.3b";
	case HPND: return "HPND";
	case IBM_pibs: return "IBM-pibs";
	case IPL_1_0: return "IPL-1.0";
	case Imlib2: return "Imlib2";
	case IJG: return "IJG";
	case Intel: return "Intel";
	case IPA: return "IPA";
	case ISC: return "ISC";
	case JSON: return "JSON";
	case LPPL_1_3a: return "LPPL-1.3a";
	case LPPL_1_0: return "LPPL-1.0";
	case LPPL_1_1: return "LPPL-1.1";
	case LPPL_1_2: return "LPPL-1.2";
	case LPPL_1_3c: return "LPPL-1.3c";
	case Libpng: return "Libpng";
	case LPL_1_02: return "LPL-1.02";
	case LPL_1_0: return "LPL-1.0";
	case MS_PL: return "MS-PL";
	case MS_RL: return "MS-RL";
	case MirOS: return "MirOS";
	case MIT: return "MIT";
	case Motosoto: return "Motosoto";
	case MPL_1_0: return "MPL-1.0";
	case MPL_1_1: return "MPL-1.1";
	case MPL_2_0: return "MPL-2.0";
	case MPL_2_0_no_copyleft_exception: return "MPL-2.0-no-copyleft-exception";
	case Multics: return "Multics";
	case NASA_1_3: return "NASA-1.3";
	case Naumen: return "Naumen";
	case NBPL_1_0: return "NBPL-1.0";
	case NGPL: return "NGPL";
	case NOSL: return "NOSL";
	case NPL_1_0: return "NPL-1.0";
	case NPL_1_1: return "NPL-1.1";
	case Nokia: return "Nokia";
	case NPOSL_3_0: return "NPOSL-3.0";
	case NTP: return "NTP";
	case OCLC_2_0: return "OCLC-2.0";
	case ODbL_1_0: return "ODbL-1.0";
	case PDDL_1_0: return "PDDL-1.0";
	case OGTSL: return "OGTSL";
	case OLDAP_2_2_2: return "OLDAP-2.2.2";
	case OLDAP_1_1: return "OLDAP-1.1";
	case OLDAP_1_2: return "OLDAP-1.2";
	case OLDAP_1_3: return "OLDAP-1.3";
	case OLDAP_1_4: return "OLDAP-1.4";
	case OLDAP_2_0: return "OLDAP-2.0";
	case OLDAP_2_0_1: return "OLDAP-2.0.1";
	case OLDAP_2_1: return "OLDAP-2.1";
	case OLDAP_2_2: return "OLDAP-2.2";
	case OLDAP_2_2_1: return "OLDAP-2.2.1";
	case OLDAP_2_3: return "OLDAP-2.3";
	case OLDAP_2_4: return "OLDAP-2.4";
	case OLDAP_2_5: return "OLDAP-2.5";
	case OLDAP_2_6: return "OLDAP-2.6";
	case OLDAP_2_7: return "OLDAP-2.7";
	case OPL_1_0: return "OPL-1.0";
	case OSL_1_0: return "OSL-1.0";
	case OSL_2_0: return "OSL-2.0";
	case OSL_2_1: return "OSL-2.1";
	case OSL_3_0: return "OSL-3.0";
	case OLDAP_2_8: return "OLDAP-2.8";
	case OpenSSL: return "OpenSSL";
	case PHP_3_0: return "PHP-3.0";
	case PHP_3_01: return "PHP-3.01";
	case PostgreSQL: return "PostgreSQL";
	case Python_2_0: return "Python-2.0";
	case QPL_1_0: return "QPL-1.0";
	case RPSL_1_0: return "RPSL-1.0";
	case RPL_1_1: return "RPL-1.1";
	case RPL_1_5: return "RPL-1.5";
	case RHeCos_1_1: return "RHeCos-1.1";
	case RSCPL: return "RSCPL";
	case Ruby: return "Ruby";
	case SAX_PD: return "SAX-PD";
	case SGI_B_1_0: return "SGI-B-1.0";
	case SGI_B_1_1: return "SGI-B-1.1";
	case SGI_B_2_0: return "SGI-B-2.0";
	case OFL_1_0: return "OFL-1.0";
	case OFL_1_1: return "OFL-1.1";
	case SimPL_2_0: return "SimPL-2.0";
	case Sleepycat: return "Sleepycat";
	case SMLNJ: return "SMLNJ";
	case SugarCRM_1_1_3: return "SugarCRM-1.1.3";
	case SISSL: return "SISSL";
	case SISSL_1_2: return "SISSL-1.2";
	case SPL_1_0: return "SPL-1.0";
	case Watcom_1_0: return "Watcom-1.0";
	case NCSA: return "NCSA";
	case VSL_1_0: return "VSL-1.0";
	case W3C: return "W3C";
	case WXwindows: return "WXwindows";
	case Xnet: return "Xnet";
	case X11: return "X11";
	case XFree86_1_1: return "XFree86-1.1";
	case YPL_1_0: return "YPL-1.0";
	case YPL_1_1: return "YPL-1.1";
	case Zimbra_1_3: return "Zimbra-1.3";
	case Zlib: return "Zlib";
	case ZPL_1_1: return "ZPL-1.1";
	case ZPL_2_0: return "ZPL-2.0";
	case ZPL_2_1: return "ZPL-2.1";
	case Unlicense: return "Unlicense";
	default: return "Not recognized";
		}
	}

	public boolean isApprovedOSI(){
        switch(this){
	case AFL_1_1: return true;
	case AFL_1_2: return true;
	case AFL_2_0: return true;
	case AFL_2_1: return true;
	case AFL_3_0: return true;
	case APL_1_0: return true;
	case Aladdin: return false;
	case ANTLR_PD: return false;
	case Apache_1_0: return false;
	case Apache_1_1: return true;
	case Apache_2_0: return true;
	case APSL_1_0: return true;
	case APSL_1_1: return true;
	case APSL_1_2: return true;
	case APSL_2_0: return true;
	case Artistic_1_0: return true;
	case Artistic_1_0_cl8: return true;
	case Artistic_1_0_Perl: return false;
	case Artistic_2_0: return true;
	case AAL: return true;
	case BitTorrent_1_0: return false;
	case BitTorrent_1_1: return false;
	case BSL_1_0: return true;
	case BSD_2_Clause: return true;
	case BSD_2_Clause_FreeBSD: return false;
	case BSD_2_Clause_NetBSD: return false;
	case BSD_3_Clause: return true;
	case BSD_3_Clause_Clear: return false;
	case BSD_4_Clause: return false;
	case BSD_4_Clause_UC: return false;
	case CECILL_1_0: return false;
	case CECILL_1_1: return false;
	case CECILL_2_0: return false;
	case CECILL_B: return false;
	case CECILL_C: return false;
	case ClArtistic: return false;
	case CNRI_Python: return true;
	case CNRI_Python_GPL_Compatible: return false;
	case CPOL_1_02: return false;
	case CDDL_1_0: return true;
	case CDDL_1_1: return false;
	case CPAL_1_0: return true;
	case CPL_1_0: return true;
	case CATOSL_1_1: return true;
	case Condor_1_1: return false;
	case CC_BY_1_0: return false;
	case CC_BY_2_0: return false;
	case CC_BY_2_5: return false;
	case CC_BY_3_0: return false;
	case CC_BY_ND_1_0: return false;
	case CC_BY_ND_2_0: return false;
	case CC_BY_ND_2_5: return false;
	case CC_BY_ND_3_0: return false;
	case CC_BY_NC_1_0: return false;
	case CC_BY_NC_2_0: return false;
	case CC_BY_NC_2_5: return false;
	case CC_BY_NC_3_0: return false;
	case CC_BY_NC_ND_1_0: return false;
	case CC_BY_NC_ND_2_0: return false;
	case CC_BY_NC_ND_2_5: return false;
	case CC_BY_NC_ND_3_0: return false;
	case CC_BY_NC_SA_1_0: return false;
	case CC_BY_NC_SA_2_0: return false;
	case CC_BY_NC_SA_2_5: return false;
	case CC_BY_NC_SA_3_0: return false;
	case CC_BY_SA_1_0: return false;
	case CC_BY_SA_2_0: return false;
	case CC_BY_SA_2_5: return false;
	case CC_BY_SA_3_0: return false;
	case CC0_1_0: return false;
	case CUA_OPL_1_0: return true;
	case D_FSL_1_0: return false;
	case WTFPL: return false;
	case EPL_1_0: return true;
	case eCos_2_0: return false;
	case ECL_1_0: return true;
	case ECL_2_0: return true;
	case EFL_1_0: return true;
	case EFL_2_0: return true;
	case Entessa: return true;
	case ErlPL_1_1: return false;
	case EUDatagrid: return true;
	case EUPL_1_0: return false;
	case EUPL_1_1: return true;
	case Fair: return true;
	case Frameworx_1_0: return true;
	case FTL: return false;
	case AGPL_1_0: return false;
	case AGPL_3_0: return true;
	case GFDL_1_1: return false;
	case GFDL_1_2: return false;
	case GFDL_1_3: return false;
	case GPL_1_0: return false;
	case GPL_1_0_plus: return false;
	case GPL_2_0: return true;
	case GPL_2_0_plus: return true;
	case GPL_2_0_with_autoconf_exception: return true;
	case GPL_2_0_with_bison_exception: return true;
	case GPL_2_0_with_classpath_exception: return true;
	case GPL_2_0_with_font_exception: return true;
	case GPL_2_0_with_GCC_exception: return true;
	case GPL_3_0: return true;
	case GPL_3_0_plus: return true;
	case GPL_3_0_with_autoconf_exception: return true;
	case GPL_3_0_with_GCC_exception: return true;
	case LGPL_2_1: return true;
	case LGPL_2_1_plus: return true;
	case LGPL_3_0: return true;
	case LGPL_3_0_plus: return true;
	case LGPL_2_0: return true;
	case LGPL_2_0_plus: return true;
	case gSOAP_1_3b: return false;
	case HPND: return true;
	case IBM_pibs: return false;
	case IPL_1_0: return true;
	case Imlib2: return false;
	case IJG: return false;
	case Intel: return true;
	case IPA: return true;
	case ISC: return true;
	case JSON: return false;
	case LPPL_1_3a: return false;
	case LPPL_1_0: return false;
	case LPPL_1_1: return false;
	case LPPL_1_2: return false;
	case LPPL_1_3c: return true;
	case Libpng: return false;
	case LPL_1_02: return true;
	case LPL_1_0: return true;
	case MS_PL: return true;
	case MS_RL: return true;
	case MirOS: return true;
	case MIT: return true;
	case Motosoto: return true;
	case MPL_1_0: return true;
	case MPL_1_1: return true;
	case MPL_2_0: return true;
	case MPL_2_0_no_copyleft_exception: return true;
	case Multics: return true;
	case NASA_1_3: return true;
	case Naumen: return true;
	case NBPL_1_0: return false;
	case NGPL: return true;
	case NOSL: return false;
	case NPL_1_0: return false;
	case NPL_1_1: return false;
	case Nokia: return true;
	case NPOSL_3_0: return true;
	case NTP: return true;
	case OCLC_2_0: return true;
	case ODbL_1_0: return false;
	case PDDL_1_0: return false;
	case OGTSL: return true;
	case OLDAP_2_2_2: return false;
	case OLDAP_1_1: return false;
	case OLDAP_1_2: return false;
	case OLDAP_1_3: return false;
	case OLDAP_1_4: return false;
	case OLDAP_2_0: return false;
	case OLDAP_2_0_1: return false;
	case OLDAP_2_1: return false;
	case OLDAP_2_2: return false;
	case OLDAP_2_2_1: return false;
	case OLDAP_2_3: return false;
	case OLDAP_2_4: return false;
	case OLDAP_2_5: return false;
	case OLDAP_2_6: return false;
	case OLDAP_2_7: return false;
	case OPL_1_0: return false;
	case OSL_1_0: return true;
	case OSL_2_0: return true;
	case OSL_2_1: return true;
	case OSL_3_0: return true;
	case OLDAP_2_8: return false;
	case OpenSSL: return false;
	case PHP_3_0: return true;
	case PHP_3_01: return false;
	case PostgreSQL: return true;
	case Python_2_0: return true;
	case QPL_1_0: return true;
	case RPSL_1_0: return true;
	case RPL_1_1: return true;
	case RPL_1_5: return true;
	case RHeCos_1_1: return false;
	case RSCPL: return true;
	case Ruby: return false;
	case SAX_PD: return false;
	case SGI_B_1_0: return false;
	case SGI_B_1_1: return false;
	case SGI_B_2_0: return false;
	case OFL_1_0: return false;
	case OFL_1_1: return true;
	case SimPL_2_0: return true;
	case Sleepycat: return true;
	case SMLNJ: return false;
	case SugarCRM_1_1_3: return false;
	case SISSL: return true;
	case SISSL_1_2: return false;
	case SPL_1_0: return true;
	case Watcom_1_0: return true;
	case NCSA: return true;
	case VSL_1_0: return true;
	case W3C: return true;
	case WXwindows: return true;
	case Xnet: return true;
	case X11: return false;
	case XFree86_1_1: return false;
	case YPL_1_0: return false;
	case YPL_1_1: return false;
	case Zimbra_1_3: return false;
	case Zlib: return true;
	case ZPL_1_1: return false;
	case ZPL_2_0: return true;
	case ZPL_2_1: return false;
	case Unlicense: return false;
	default: return false;
		}
	}
        
        
        
        
    /**
     * Convert the SPDX identifier of a license into an ENUM
     * @param id the id to a meaninful object
     * @return  The LicenseType when identified
     */
    public static LicenseType convertToEnum(final String id) {
        final String result = id
                .replace(" ", "_")
                .replace("-", "_")
                .replace(".", "_")
                .replace("+", "_plus");
        return LicenseType.valueOf(result);
    }
    
   
}