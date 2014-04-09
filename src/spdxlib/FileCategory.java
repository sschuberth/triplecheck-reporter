/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-08-29T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: FileCategory.java  
 * FileCategory: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Declare the established types of files </text> 
 */
package spdxlib;

public enum FileCategory {
    TEXT,
    SOURCE,
    DOCUMENT,
    INTERNET,
    SCRIPT,
    SCHEMA,
    CONFIG,
    VERSIONING,
    EXECUTABLE,
    FONT,
    ARCHIVE,
    BINARY,
    DATABASE,
    IMAGE,
    VIDEO,
    SOUND,
    MUSIC,
    OTHER,
    UNKNOWN;
    
    @Override
    public String toString() {
       String result = this.name().toLowerCase();
       
//        result = // just upgrade the first case 
//                Character.toString(result.charAt(0)).toUpperCase()
//                // keep the rest in lower case
//                + result.substring(1);
        return result;
    }
       
        public String toStringCapitalLetter() {
       String result = this.name().toLowerCase();
        result = // just upgrade the first case 
                Character.toString(result.charAt(0)).toUpperCase()
                // keep the rest in lower case
                + result.substring(1);
        return result;
    }
    
}
