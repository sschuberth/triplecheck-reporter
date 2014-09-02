/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-13T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Page.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the contents of a web page, captures details
 * such as position of the text cursor, content, selected node, etc. </text> 
 */

package GUI;

import definitions.is;


/**
 *
 * @author Nuno Brito, 13th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class Page {

    public String 
            contentType = is.contentHTML,
            header = "",
            body = "",
            content = "",
            footer = "";
    
    public int carotPosition = 0;
    
    public Boolean editable = false;
    
    /**
     * Does this page has any real content or not?
     * @return 
     */
    public boolean hasContent(){
        if(content == null){
            return false;
        }
        if(content.length() > 0){
            return true;
        }
        // nothing worked, return as empty
        return false;
    }
    
    /**
     * gets a page ready for web publishing
     * @return the HTML code to be inserted on the web page
     */
    public String getText(){
        return    header
                + body
                + content
                + footer;
    }
}
