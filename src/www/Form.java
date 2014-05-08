/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-01-20T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Form.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Code related to HTML forms, such as buttons and other
 *  dialog boxes.</text> 
 */

package www;

/**
 *
 * @author Nuno Brito, 21st of December 2013 in Darsmtadt, Germany
 */
public class Form {
    
    public static String doButton(String title, String action){
    String result = "<form action=\""
            + action
            + "\" method=\"post\">"
            + "<input value=\""
            + title
            + "\" name=\"SubmitButton\" type=\"submit\">"
            + "</form>";
            
    
    return result;
    }

}
