/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-06-05T10:30:30Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: loadPage.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package comp;

import utils.www.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 5th of June 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class loadPage {

    /**
     * Given a project ID, this method will launch a thread to load a google
     * project page. In the process will display a "Please wait" message to the
     * end-users while the contents are being loaded from the Internet
     */
    public static void googleCode(final String name, final String license, 
            final WebRequest request){
         
        
//        Thread thread = new Thread(){
//            @Override
//            public void run(){
//                final String loadingMessage = ""
//                                + html.div()
//                                + html.textGrey("Loading webpage, please wait..")
//                                + html._div
//                                + "";
//                // place the loading message 
//                engine.studio.editorPane(is.contentHTML, false, 0, loadingMessage);
//            };
//        };
//        thread.start();
        
        
               
                String result = getGoogleCodeDescription(name);
                String link = "https://code.google.com/p/" + name;
                String output = html.br
                        + html.br
                        + html.div()
                        //+ "License: " + license
                        //+ html.br
                        + "Project page: "
                        + html.link(link, link)
                        + html._div
                        + html.br
                        + html.br
                        ;
                
                //System.out.println(result);
                request.setAnswer(result + output, false);
        
                
//                // did we got any meaningful text?
//                if(result.isEmpty() || result.equals(loadingMessage)){
//                    //System.out.println(output);
//                    engine.studio.editorPane(is.contentHTML, true, 0, output);
//                }else{
//                    //System.out.println(result);
//                    engine.studio.editorPane(is.contentHTML, true, 0, result);
//                }
//                //request.setAnswer(result);
//         }
//        };
//        thread.start();
    }
    
    
    /**
     * Returns the HTML description of a given project on google code.
     * @param projectID The project ID on google code
     * @return          An HTML summary ready for display to the end-user
     */
    static private String getGoogleCodeDescription(String title){
        String result;
        
        try{
        // define the specifics of google code web pages
        final String tag1 = "<td id=\"wikicontent\" class=\"psdescription\">";
        final String tag2 = "</td> </tr></table>";
        final String url = "https://code.google.com/p/";
        // get the web page
        final String page = utils.internet.webget(url + title);
        //System.err.println(page);
        final int i1 = page.indexOf(tag1) + tag1.length();
        final String temp = page.substring(i1, page.length());
        final int i2 = temp.indexOf(tag2);
        // get the related 
        result = html.div()
                + temp.substring(0, i2)
                + html._div;
        } catch (Exception e){
            result = html.textGreyAligned("Failed to load web page with more details");
        }
        return result;
    }
}
