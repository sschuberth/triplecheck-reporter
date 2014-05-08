/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-12T00:00:00Z
 * FileName: Page.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines a web page that is displayed to the end-user
 * </text> 
 */

package www;

import java.io.File;

/**
 *
 * @author Nuno Brito, 12th of December 2013 in Darsmtadt, Germany
 */
public class Page {

    private File 
            sourceFile, // has a file been used as source for this document
            sourceFolder;
    
    /**
     * Creates a page containing the HTML page
     * @return the HTML code to be displayed to the end user 
     */
    public String getOutput(){
        return "";
    }
    
}
