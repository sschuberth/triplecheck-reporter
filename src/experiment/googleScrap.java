/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-04T19:20:20Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: googleScrap.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Given a project id from google code, get the pertinent
 * details from the project in HTML format</text> 
 */

package experiment;


/**
 *
 * @author Nuno Brito, 4th of May 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class googleScrap {
    
    public static void main(String[] args) {
        final String test = "remedium";
        
        googleScrap gc = new googleScrap();
        
        
        System.out.println(gc.getGoogleCodeDescription(test));
        
        
        System.exit(1981);
    }
    
    /**
     * Returns the HTML description of a given project on google code.
     * @param projectID The project ID on google code
     * @return          An HTML summary ready for display to the end-user
     */
    public String getGoogleCodeDescription(final String projectID){
        String result;
        // define the specifics of google code web pages
        final String tag1 = "<td id=\"wikicontent\" class=\"psdescription\">";
        final String tag2 = "</td> </tr></table>";
        final String url = "https://code.google.com/p/";
        // get the web page
        final String page = utils.internet.webget(url + projectID);
        //System.err.println(page);
        final int i1 = page.indexOf(tag1) + tag1.length();
        final String temp = page.substring(i1, page.length());
        final int i2 = temp.indexOf(tag2);
        // get the related 
        result = temp.substring(0, i2);
        return result;
    }
    
}
