/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-04T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: FileLanguage.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> To which family a given file relates the most? </text> 
 */
package spdxlib;

public enum FileLanguage {
    
    // compiled
    JAVA,
    DELPHI,
    C,
    C_PLUS_PLUS,
    DOT_NET,
    C_SHARP,
    OBJECTIVE_C,
    
    // scripted
    PHP,
    JAVASCRIPT,
    RUBY,
    PYTHON,
    PERL,
    SCRIPT_LINUX,
    SCRIPT_WINDOWS,
    
    // misc
    SQL,
    HTML,
    UNSORTED
    
}
