/**
 * SPDXVersion: SPDX-1.1 Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) Created:
 * 2013-12-08T00:00:00Z LicenseName: NOASSERTION FileName: Test.java FileType:
 * SOURCE FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck
 * </text>
 * FileComment: <text> </text>
 */

package main;

import java.io.File;
import output.OutputSPDXToHTML;
import spdxlib.SPDXfile;


/**
 *
 * @author Nuno Brito, 8th of December 2013 in Darmstadt, Germany.
 */
public class Test {

    public static void outputSPDXtoHTML(File folder, SPDXfile spdx){
        OutputSPDXToHTML outputHTML = new OutputSPDXToHTML(folder, spdx);
        outputHTML.doOutput();
    }
    
    
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
    
        // file location
        File file = new File("reports", "2015-03-19-Java-Jar-Zip.spdx");
        // read the file
        SPDXfile spdx = new SPDXfile(file);
        // where we store the HTML files
        File folder = new File("export/2015-03-19-Java-Jar-Zip/report/");
        // create the HTML report
        outputSPDXtoHTML(folder, spdx);
        
    }
        
        
   
    
}
