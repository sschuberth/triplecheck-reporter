/**
 * SPDXVersion: SPDX-1.1 
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) 
 * Created: 2013-12-02T00:00:00Z 
 * LicenseName: EUPL-1.1-without-appendix 
 * FileName: RequestType.java
 * FileType: SOURCE 
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text>
 */

package www;

/**
 *
 * @author Nuno Brito, 2nd of December 2013 in Darsmtadt, Germany
 */
public enum RequestType {
    UNKNOWN,
    LINK,  // when a link was clicked
    FORM,  // when a form was submitted by the user
    NONE  // when all that we want to do is display a web page
}
