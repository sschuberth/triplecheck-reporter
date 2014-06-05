/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: html.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package utils;

import definitions.is;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import main.core;
import script.log;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 20th of September 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class html {

    public static final String 
            br = "\n<br>",
            _div = "</div>\n",
            space = "&nbsp",
            divider = space + "|" + space;
    
    
    
    /**
     * Retrieves an RSS feed from the Internet
     * @param wwwLink The URL for the RSS feed
     * @return an HTML formatted text
     */
    public static String getRSS(String wwwLink){
    String result = "";
    
//    try{
//     RSSFeedParser parser = new RSSFeedParser(wwwLink);
//		Feed feed = parser.readFeed();
//		//System.out.println(feed);
//		for (FeedMessage msg : feed.getMessages()) {
//                    
//                    result +=
//                            html.link(msg.getTitle(), msg.getLink())
//                            + html.br
//                            + msg.getDescription()
//                            + html.br
//                            + html.br
//                            ;
//			//System.out.println(msg);
//                }
//    } catch (Exception e){
//        log.write(is.ABORTED, "RSS feed unavailable, "
//                + "possibly no Internet connected");
//    }
//                
    return result;
}
    
    
    public static String getIcon(String iconName, WebRequest request){
        String result = iconName;
        if(request.requestOrigin == RequestOrigin.BROWSER){
                result =
                "<img align=\"middle;\" hspace=\"3\" src=\""
                + iconName
                + "\"> "
                ;
        return result;
        }
        
        File icon = new File(request.BaseFolder, iconName);
        String iconPath = icon.getAbsolutePath();
        iconPath = "file:///" + iconPath.replace("\\", "/");
        result =
                "<img align=\"middle;\" hspace=\"3\" src=\""
                + iconPath
                + "\"> "
                ;
        
        return result;
    }
    
    
    
      /**
     * Provides the HTML text necessary to display an image on our text box
     * @param iconName the icon from the collection of icons
     * @return An HTML valid string to be placed on web pages
     */
    public static String getCommonFolderIcon(String iconName){
     // create the icon image
        File icon = core.getIcon(iconName);
        String iconPath = icon.getAbsolutePath();
        iconPath = "file:///" + iconPath.replace("\\", "/");
        String result =
                "<img align=\"middle;\" hspace=\"3\" src=\""
                + iconPath
                + "\"> "
                ;
        return result;
    }
 
    
      /**
     * HTML string that shows text on a given color
     * @param text text to be displayed
     * @return An HTML text prepared to be displayed on a web page
     */
    public static String textGrey(String text){
        return "<span style=\"color: rgb("
                + "102, "
                + "102, "
                + "102);\">" 
                + text 
                + "</span>";

    }
    
    
    /**
     * HTML string that shows text on a given color
     * @param text text to be displayed
     * @return An HTML text prepared to be displayed on a web page
     */
    public static String textGreyAligned(String text){
        return ""
                + html.div()
                + html.textGrey("Loading, please wait..")
                + html._div;

    }
    
    
    /**
     * Adds an HTML link that allows selecting a specific tree node with a given
     * ID text
     * @param title Title displayed to the reader
     * @param link the action
     * @return the HTML text ready to be placed on the text editor/web page
     */
    public static String linkNode(String title, String link){
        return "<a href=\"nodeId://" + link + "\">" + title + "</a>";
    }
    
    /**
     * Allows to run a script at our choice
     * @param title The link title that is visible to the user
     * @param script The script file that where the source code is located
     * @param method The specific method that we want to call
     * @return the HTML code ready to be placed on a web page
     */
    public static String linkScript(String title, File script, String method){
        return "<a href=\"script://" + script.getAbsolutePath()
                + ">>"+method
                + "\">" + title + "</a>";
    }
    
    /**
     * Adds a plain normal HTTP link that will open a web page on the default
     * browser
     * @param title Title for the link that is read by end-user
     * @param link URL that is used for opening the site location
     * @return 
     */
    public static String link(String title, String link){
        return "<a href=\"" + link + "\">" + title + "</a>";
    }
    
    /**
     * Search for a given term or expression. It will fill the search box
     * with the selected term and then perform the search operation, displaying
     * the found results.
     * @param title The title for the link that is read by the end-user
     * @param what The expression or term that will be used on the search box
     * @return 
     */
    public static String linkSearch(String title, String what){
        return "<a href=\"search://" + what + "\">" + title + "</a>";
    }
    
    /**
     * Adds a text with an advance of 10 pixels
     * @return 
     */
    public static String div(){
        return "<div style=\"margin-left: 10px;\">";
    }
    
    /**
     * Adds a text with an advance of a given width in pixels
     * @param width width in pixels
     * @return an HTML text with the DIV code
     */
    public static String div(int width){
        return "<div style=\"margin-left: " + width + "px;\">";
    }
    
   /**
    * Search a term using the Yandex engine
    * @param what the search term to be found
    * @return The HTML text prepared to be added on a web page
    */
   public static String linkToSearchYandex(String what){
        return html.link("Yandex", "http://www.yandex.com/yandsearch?text=" 
                + what);
    }
   
   /**
    * Search a term using the Google engine
    * @param what the search term to be found
    * @return The HTML text prepared to be added on a web page
    */
   public static String linkToSearchGoogle(String what){
        return html.link("Google", "https://www.google.de/?#q=" + what);
    }

// public static String linkToSearchGoogle(String what){
//        return html.link("Google", "https://www.google.com/?q=\""
//                + what+"\"#q=\"" + what +"\"");
//    }

   /**
    * Search a term using the VirusTotal engine
    * @param what the search term to be found
    * @return The HTML text prepared to be added on a web page
    */
   public static String linkToSearchVirusTotal(String what){
        return html.link("VirusTotal", "https://www.virustotal.com/en/file/"
                +what
                +"/analysis/");
    }
 
  /**
    * Search a term using the VirusTotal engine
    * @param what the search term to be found
    * @return The HTML text prepared to be added on a web page
    */
   public static String linkToSearchMetaScan(String what){
        return html.link("Metascan Online", ""
                + "https://www.metascan-online.com/en/scanresult/hash/"
                + what
                );
    }
  
     /**
    * Search a term using the http://file-extension.net database
    * @param what the search term to be found
    * @return The HTML text prepared to be added on a web page
    */
   public static String linkToSearchFileExtension(String what){
        return html.link("File Extension Seeker", ""
                + "http://file-extension.net/seeker/file_extension_"
                + what.toLowerCase()
                );
    }
   
   /**
    * Search a term using the Ohloh engine
    * @param what the search term to be found
    * @return The HTML text prepared to be added on a web page
    */
   public static String linkToSearchOhloh(String what){
        return html.link("Ohloh", "http://code.ohloh.net/search?s="
                +what
                );
    }

   /**
    * Creates a link for an HTML page inside the computer that will be displayed
    * on the text box 
     * @param title The title that is visible to the user
    * @param htmlPage The file pointer to an HTML file
    * @return The HMTL code ready to be inserted on the web page
    */
   public static String linkInside(String title, File htmlPage){
       //String url = htmlPage.getAbsolutePath().replace("\\", "/");
       return link(title, htmlPage.getAbsolutePath());
   }

    public static String linkToSearchAntepedia(String what) {
       return html.link("Antepedia", "http://www.antepedia.com/search.html?q="
                +what
                );
    }

    public static String linkToSearchGitHub(String what) {
        return html.link("GitHub", "https://github.com/search?q="
                //+ "%22"
                + what
                //+ "%22"
                + "&type=Code&ref=searchresults"
                );
    }
   
   
    /**
     * Returns a text formatted as an H2 title
     * @param title title of the text
     * @return the HTML formatted text
     */
    public static String h2(String title){
        return "<h2>" + title + "</h2>";
    }
   
    /**
     * Returns a text formatted as an H3 title
     * @param title title of the text
     * @return the HTML formatted text
     */
    public static String h3(String title){
        return "<h3>" + title + "</h3>";
    }
   
    
   /**
    * This method picks a sentence of text containing several parameters and
    * then provides 
    * @param data in the format: test=123&test2=567
    * @return 
    */
    public static ArrayList<String[]> cleanParameters(String data){
        ArrayList<String[]> result = new ArrayList();
        // split each of the parameters into something we can process
        String[] params = data.split("&");
         // go through each parameter
        for (String param : params) {
            String[] pair = param.split("=");
            String value = "";
            String key = "";
            if (pair.length > 1) {
                try {
                    key = java.net.URLDecoder.decode(pair[0], "UTF-8");
                    value = java.net.URLDecoder.decode(pair[1], "UTF-8");
                    //value = pair[1];
                } catch (UnsupportedEncodingException er) {
                    log.write(is.ERROR,
                            "Failed to read: %1", data);
                    return null;
                }
            } else if (pair.length == 1) {
                try {
                    key = java.net.URLDecoder.decode(pair[0], "UTF-8");
                    //value = pair[1];
                } catch (UnsupportedEncodingException er) {
                    log.write(is.ERROR,
                            "Failed to read: %1", data);
                    return null;
                }
            }
            // add this parameter on our list
           result.add(new String[]{key, value});
        }// for 
        // all done
        return result;
    }
    
    
    /**
     * This method provides the HTML code to automatically redirect to a
     * different web page
     * @param URL the target URL
     * @param delay hoe many seconds to wait
     * @param message a Message to the end user
     * @return the HTML code that is provided to the end user
     */
    public static String redirect(String URL, int delay, String message){
        return "<html><head>"
                + "<meta http-equiv=\"refresh\" CONTENT=\""
                + delay
                +"; URL=" 
                + URL 
                + "\">"
                + "</head><body>"
                + html.br 
                + html.div()
                + message
                + html._div
                + "</body></html>"
                        ;
    }
    
    /**
     * Provides just the meta tag for the HTML portion of the request
     * @param URL the page to load
     * @param delay the time it will take until activated
     * @return an HTML portion properly formatted for a web page
     */
    public static String redirectMetaTag(String URL, int delay){
        return   "<meta http-equiv=\"refresh\" CONTENT=\""
                + delay
                +"; URL=" 
                + URL 
                + "\">";
    }
    
    /**
     * Converts all the HTML entities back into normal text
     * @param input
     * @return 
     */
    public static String decodeEntities(String input){
        input = input.replace("&amp;", "&");
        input = input.replace("&quot;", "\"");
        return input;
    }
}
