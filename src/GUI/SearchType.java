/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-03T10:06:18Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: SearchType.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the possible searches that we support.</text> 
 */
package GUI;

/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public enum SearchType {
    
    Files,
    License_Choose,
    License_Show, 
    Components_Show;
    
    
    /**
     * Provides the text that is displayed to end-users when changing the box
     * @return A text string
     */
    public String getSearchBoxText() {
        switch (this) {
        case Files: return "Search files..";
        case License_Choose: return "Find licenses..";
        case License_Show: return "Find licenses..";
        case Components_Show: return "Find components..";
        }
        return "Search";
    }
   
    
    /**
     * Provides the text that is displayed to end-users when changing the box
     * @return A text string
     */
    public String getHook() {
        switch (this) {
        case Files: return "Searching files";
        case License_Choose: return "Searching licenses";
        case License_Show: return "Showing licenses";
        case Components_Show: return "Showing components";
        }
        return "Search";
    }
    
}
