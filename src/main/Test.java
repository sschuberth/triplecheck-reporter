/**
 * SPDXVersion: SPDX-1.1 Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) Created:
 * 2013-12-08T00:00:00Z LicenseName: NOASSERTION FileName: Test.java FileType:
 * SOURCE FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck
 * </text>
 * FileComment: <text> </text>
 */

package main;

/**
 *
 * @author Nuno Brito, 8th of December 2013 in Darmstadt, Germany.
 */
public class Test {

    
    
/**
 * When given an input, replace all http:// references on text with HTML link
 * representations.
 * 
 * @param input the plain text containing the links to be converted
 * @return formatted HTML text, links are now clickable
 */
 public static String replaceTextWithURL(String input){
     String result = input;
        String temp = input;
        while(temp.contains("http://")){
            // get the beginning of the http tag
            int i = temp.indexOf("http://");
            temp = temp.substring(i);
            // get the first space
            int end = temp.indexOf(" ");
            // is the link on the end of text?
            if(end == -1){
                end = temp.length();
            }
            String url = temp.substring(0, end);
            // replace the URL with the HTML code
            result = result.replace(url, "<a href='"+url+"'>"+url+"</a>");
            // process the rest of the string
            temp = temp.substring(end);
            System.out.println(result);
        }
     return result;
 }   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String test1 = "RT @FoundOpenGov: Excited to talk producing #OpenLaw tomorrow at @civicMIT! It'll be webcast here at 12 PM EST: http://t.co/wujAzaJigg #ope…";
        String test2 = " RT @nn81: 50 shades of #GPL. Non-Obvious GPL: http://t.co/TR9HLj0IFk";
        
        String result = replaceTextWithURL(test1);
        
//        String result = test2;
//        String temp = test;
//        while(temp.contains("http://")){
//            // get the beginning of the http tag
//            int i = temp.indexOf("http://");
//            temp = temp.substring(i);
//            // get the first space
//            int end = temp.indexOf(" ");
//            String url = temp.substring(0, end);
//            // replace the URL with the HTML code
//            result = result.replace(url, "<a href='"+url+"'>"+url+"</a>");
//            // process the rest of the string
//            temp = temp.substring(end);
//            System.out.println(result);
//        }
        
        //System.out.println(result);
        
//        String test = utils.html.redirect("/basic/status", 0);
//        //System.out.println(test);
//        
//        String URL = "";
//        String delay = "";
//        
//        String beacon  = "http-equiv=\"refresh\"";
//        String beacon2 = "content=\"";
//        String beacon3 = "url=";
//        String text = test.toLowerCase();
//        if(text.contains(beacon)){
//            // get the beginning of the text
//            int pos1 = text.indexOf(beacon);
//            String s1 = text.substring(pos1 + beacon.length());
//            int pos2 = s1.indexOf(beacon3);
//            int pos3 = s1.indexOf("\">");
//            String s2 = s1.substring(pos2 + beacon3.length(), pos3);
//            
////            // get the beginning of the text
////            int pos1 = text.indexOf(beacon);
////            String s1 = text.substring(pos1 + beacon.length());
////            // get the delay
////            int pos2 = s1.indexOf(beacon2);
////            String s2 = s1.substring(pos2 + beacon2.length());
////            int pos3 = s2.indexOf(";");
////            delay = s2.substring(0, pos3);
////            // get the URL
////            pos1 = s2.indexOf(beacon3);
////            pos2 = s2.indexOf("\">");
////            URL = s2.substring(pos1 + beacon3.length(), pos2);
//            System.out.println(delay +"->" + URL + "\n" + s2);
        }
        
        
   
    
}
