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

import java.io.Serializable;
import javax.swing.Icon;
import main.core;

public enum FileCategory implements Serializable{
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
    TEMP,
    UNKNOWN;
    
    
    /**
     * Based on the name of the category, get the associated icon
     * @return 
     */
    public Icon toIcon() {
        switch(this){
            case TEXT: return core.iconTEXT;
            case SOURCE: return core.iconSOURCE;
            case DOCUMENT: return core.iconDOCUMENT;
            case INTERNET: return core.iconINTERNET;
            case SCRIPT: return core.iconSCRIPT;
            case SCHEMA: return core.iconSCHEMA;
            case CONFIG: return core.iconCONFIG;
            case VERSIONING: return core.iconVERSIONING;
            case EXECUTABLE: return core.iconEXECUTABLE;
            case FONT: return core.iconFONT;
            case ARCHIVE: return core.iconARCHIVE;
            case BINARY: return core.iconBINARY;
            case DATABASE: return core.iconDATABASE;
            case IMAGE: return core.iconIMAGE;
            case VIDEO: return core.iconVIDEO;
            case SOUND: return core.iconSOUND;
            case MUSIC: return core.iconMUSIC;
            case OTHER: return core.iconOTHER;
            case TEMP: return core.iconTEMP;
            case UNKNOWN: return core.iconUNKNOWN;
            default: return core.iconUNKNOWN;
        }
    }
    
    
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
