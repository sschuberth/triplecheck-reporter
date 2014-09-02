/**
 * SPDXVersion: SPDX-1.1 
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) 
 * Created: 2013-12-02T00:00:00Z 
 * LicenseName: EUPL-1.1-without-appendix 
 * FileName: RequestOrigin.java
 * FileType: SOURCE 
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> From where has this request came from? </text>
 */

package www;

/**
 *
 * @author Nuno Brito, 2nd of December 2013 in Darsmtadt, Germany
 */
public enum RequestOrigin {
    UNKNOWN,  // unknown origin
    BROWSER,  // from a normal web browser
    GUI,   // from a Java Swing user interface
    GUI_tree; // from the tree view on our GUI
}
