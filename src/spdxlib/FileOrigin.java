/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-27T23:21:20Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: FileOrigin.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the possible states for the origin of a file </text> 
 */

package spdxlib;


/**
 *
 * @author Nuno Brito, 27th of April 2014 in Amrum, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public enum FileOrigin {
    AUTHORED,   // resource as developed by ourselves
    EXTERNAL,   // resource was made externally by a third-party provider
    AUTOMATED,  // resource is generated automatically, no changes by author
    AUTOMIXED,      // resource generated automatically and then modified by author
    MODIFIED,   // resource developed by a third-party and modified by author
    UNKNOWN;    // resource within unknown origin
    
    @Override
    public String toString() {
        return name().toUpperCase();
    }
    
    /**
     * Given a text string, identify which type of object we are referring to.
     * @param text      The text to match wiht a FileOrigin object
     * @return          A FileOrigin object
     */
    public static FileOrigin detect(String text){
        // go through each item on this enum, try to find a match
        for(FileOrigin value : FileOrigin.values()){
            // we found a match? Leave here
            if(text.equalsIgnoreCase(value.toString())){
                return value;
            }
        }
        // nothing found, return null
        return null;
    }

    /**
     * Get the pretty text for this file type
     * @return 
     */
    public String getFullText() {
        switch (this) {
        case AUTHORED: return "Authored files";
        case EXTERNAL: return "Files from a third-party author";
        case AUTOMATED: return "Files generated automatically, no changes by author";
        case AUTOMIXED: return "Files generated automatically and modified by author";
        case MODIFIED: return "Files developed by a third-party and modified by author";
        case UNKNOWN: return "Files with unknown origin";
        }
        return "";
    }

    public String getLowercase() {
        return name().toLowerCase();
    }
    
}
