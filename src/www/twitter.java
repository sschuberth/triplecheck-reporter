/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-14T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: twitter.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Support for Twitter related actions </text> 
 */

package www;
//
//import com.colorfulsoftware.rss.RSS;
//import com.colorfulsoftware.rss.RSSDoc;
//import definitions.is;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import script.log;
//import twitter4j.Paging;
//import twitter4j.Status;
//import twitter4j.Twitter;
//import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;
//import twitter4j.User;
//import twitter4j.conf.ConfigurationBuilder;
//import utils.html;
//import utils.vogella.Feed;
//import utils.vogella.FeedMessage;
//import utils.vogella.RSSFeedParser;
//

/**
 *
 * @author Nuno Brito, 21st of December 2013 in Darsmtadt, Germany
 */
public class twitter {
//
//    // define where we store all cached files
//    static File folderCache = new File("cache");
//    
//    /** 
//     * Downloads a file from the Internet straight onto the local disk
//     * @param url The link to the web file
//     * @param localFilename The file where the contents will be stored
//     * @source on http://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
//     * @author Muhammad Umair - http://stackoverflow.com/users/1749165/muhammad-umair
//     * @retrieved 2013-12-14 by Nuno Brito
//     */
//    static void downloadFromUrl(String link, File localFilename) {
//    InputStream is = null;
//    FileOutputStream fos = null;
//
//    try {
//        URL url = new URL(link);
//        URLConnection urlConn = url.openConnection();//connect
//
//        is = urlConn.getInputStream();               //get connection inputstream
//        fos = new FileOutputStream(localFilename);   //open outputstream to local file
//
//        byte[] buffer = new byte[4096];              //declare 4KB buffer
//        int len;
//
//        //while we have availble data, continue downloading and storing to local file
//        while ((len = is.read(buffer)) > 0) {  
//            fos.write(buffer, 0, len);
//        }
//    }   catch (IOException ex) {
//            Logger.getLogger(twitter.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//        try {
//            if (is != null) {
//                is.close();
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(twitter.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(twitter.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }
//}
//    
///**
// * When given an input, replace all http:// references on text with HTML link
// * representations.
// * 
// * @param text the plain text containing the links to be converted
// * @return formatted HTML text, links are now clickable
// * @source on http://stackoverflow.com/questions/1909534/java-replacing-text-url-with-clickable-html-link
// * @author Paul Croarkin - http://stackoverflow.com/users/18995/paul-croarkin
// * @retrieved 2013-12-14 by Nuno Brito
// */
//public static String textToHtmlConvertingURLsToLinks(String text) {
//    if (text == null) {
//        return text;
//    }
//    return text.replaceAll("(\\A|\\s)((http|https|ftp|mailto):\\S+)(\\s|\\z)",
//        "$1<a href=\"$2\">$2</a>$4");
//}
//    
///**
// * When given an input, replace all http:// references on text with HTML link
// * representations.
// * 
// * @param input the plain text containing the links to be converted
// * @return formatted HTML text, links are now clickable
// */
// public static String replaceTextWithURL(String input){
//     String result = input;
//        String temp = input;
//        while(temp.contains("http://")){
//            // get the beginning of the http tag
//            int i = temp.indexOf("http://");
//            temp = temp.substring(i);
//            // get the first space
//            int end = temp.indexOf(" ");
//            // is the link on the end of text?
//            if(end == -1){
//                end = temp.length();
//            }
//            String url = temp.substring(0, end);
//            // replace the URL with the HTML code
//            result = result.replace(url, "<a href='"+url+"'>"+url+"</a>");
//            // process the rest of the string
//            temp = temp.substring(end);
//            System.out.println(result);
//        }
//     return result;
// }   
// 
// /**
//  * Provides an HTML formatted link to an image
//  * @param url
//  * @return 
//  */
// static String getImageHTML(String url){
//     String temp = url.toLowerCase();
//     // BMP files are not supported
//     if(temp.endsWith(".bmp")){
//         return "";
//     }
//     
//     // first, we need to cache this image
//     //String data = utils.internet.getTextFile(url);
//     //String data = utils.internet.webget(url);
//     
//     int pos = url.lastIndexOf("/") + 1;
//     String fileName = url.substring(pos);
//     File imageFile = new File(folderCache, fileName);
//     
//     if(imageFile.exists() == false){
//            downloadFromUrl(url,imageFile);
//        }
//     
//     
//     // second round
//     if(imageFile.exists() == false){
//         return "";
//     }
//     
//     // do a web request to support both web browsers and desktop images
//     WebRequest request = new WebRequest();
//     request.BaseFolder = folderCache;
//     request.requestOrigin = RequestOrigin.GUI;
//     
//     return html.getIcon(fileName, request);
//     // return   "<img style=\"width: 48px; height: 48px;\" src=\""+url+"\"'>";
// }
// 
// 
// static String doItem(String image, String text){
//     return
//         "<table style=\"text-align: left; width: 100%;\" border=\"0\""
//         + "cellpadding=\"2\" cellspacing=\"2\">"
//         + " <tbody>"
//         + "  <tr>"
//         + "     <td style=\"height: 50px; width: 50px; text-align: center; vertical-align: middle;\">"
//         + getImageHTML(image)
//         + "</td>"
//         + "     <td>"
//         + text        
//         + "  </td>"
//         + "  </tr>"
//         + " </tbody>"
//         + "</table>"
//        ;
// }
// 
////    
//// 
////public static String getTimeLine(String userName){
////    String result = "";
////    
////     RSSFeedParser parser = new RSSFeedParser("http://triplecheck.de/feed");
////		Feed feed = parser.readFeed();
////		//System.out.println(feed);
////		for (FeedMessage msg : feed.getMessages()) {
////                    
////                    result +=
////                            html.link(msg.getTitle(), msg.getLink())
////                            + html.br
////                            + msg.getDescription()
////                            + html.br
////                            + html.br
////                            ;
////                    
////			System.out.println(msg);
////                }
////    
////    
////    return result;
////}
// 
// 
// 
///**
// * Retrieves a list of tweet entries from a given username
// * @param userName The username from where the tweets are read
// * @return An HTML formated string
// */    
//public static String getTimeLineOld(String userName){
//    // the file where we cache our results
//    File file = new File(folderCache, "twitter.html");
//    // shall we provide the cached version instead?
//    if(file.exists()){
//        long lastModified = file.lastModified();
//        // define cache time as 24 hours
//        long cacheTime = 24 * 60 * 60 * 1000;
//        long rightNow = System.currentTimeMillis();
//        // have more than 24 hours passed?
//        if(rightNow < (lastModified + cacheTime)){
//            long inBetween = rightNow - lastModified;
//            // use the cached file instead
//            log.write(is.INFO, "Using the cached twitter page from %1 ago", 
//                    utils.time.timeNumberToHumanReadable(inBetween));
//            return utils.files.readAsString(file);
//        }
//    }
//    
//    
//    String result = "";
//      Paging pg = new Paging();
//      ConfigurationBuilder cb = new ConfigurationBuilder();
//      cb.setOAuthConsumerKey("hQzmMsrVRc8mnFrWuz4Fvg");
//      cb.setOAuthConsumerSecret("jAbxaE9fiDQ4DjepmlOOspYCTyaKrrEYTB6h4R5dWY");
//      cb.setOAuthAccessToken("2238936962-C5W622ue70tUMBwjefRPifhg9U2ReDhhOxC7EcK");
//      cb.setOAuthAccessTokenSecret("lec0U1dbH7QRch73H9sxxtXD4JgUsec1iDNF2AHf6to4H");
//
//  Twitter twitter = new TwitterFactory(cb.build()).getInstance();
//  int numberOfTweets = 10;
//  long lastID = Long.MAX_VALUE;
//  ArrayList<Status> tweets = new ArrayList<Status>();
//  while (tweets.size () < numberOfTweets) {
//    try {
//      tweets.addAll(twitter.getUserTimeline(userName,pg));
//      System.out.println("Gathered " + tweets.size() + " tweets");
//      for (Status t: tweets){ 
//        if(t.getId() < lastID){
//            lastID = t.getId();
//            //System.out.println(t.getText());
//            User user = t.getUser();
//            if(t.isRetweeted()){
//                Status retweetedStatus = t.getRetweetedStatus();
//                User curRTUser = retweetedStatus.getUser();
//                //long curRTUserID = curRTUser.getId();
//                String convertedText = 
//                        textToHtmlConvertingURLsToLinks(
//                                t.getText()
//                        );
//                
//                // needs to contain a link inside
//                if(convertedText.contains("<a") == false){
//                    continue;
//                }
//                
//                result += ""
//                        + doItem(
//                                curRTUser.getProfileImageURL(),
//                        "<b>" + curRTUser.getName() + "</b>"
//                        + html.br 
//                        + convertedText
//                        + html.br )
//                        + "\n";  
//            }else{
//                //result += t.getText() + "\n";   
//                String convertedText = 
//                        textToHtmlConvertingURLsToLinks(
//                                t.getText()
//                        );
//                result += ""
//                        + doItem(
//                                user.getProfileImageURL(),
//                        "<b>" + user.getName() + "</b>"
//                        + html.br 
//                        + convertedText
//                        + html.br )
//                        + "\n";  
//            }
//            
//            
//            
//        }
//        }
//      }
//    catch (TwitterException te) {
//      System.out.println("Couldn't connect: " + te);
//      return null;
//    } 
//    }
//    pg.setMaxId(lastID-1);
//  
//    
//    // save the results to disk (ensure faster start within 24 hours)
//    utils.files.SaveStringToFile(file, result);
//    
//  return result;
//}
    
}
