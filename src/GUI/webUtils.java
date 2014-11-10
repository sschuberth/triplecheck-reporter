/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-10-17T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: webUtils.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Set of useful methods for handling web requests. </text> 
 */

package GUI;

import definitions.is;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import main.engine;
import org.simpleframework.http.Request;
import script.log;
import www.RequestOrigin;
import www.WebRequest;

/**
 *
 * @author Nuno Brito, 17th of October 2014 in Darsmtadt, Germany
 */
public class webUtils {

    public static String getIcon(String iconName, WebRequest request){
        String result;
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
        File icon = engine.getIcon(iconName);
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
    
    
    
      /** Get the value from an HTML provided on command line
     * @param request the request from our web server
     * @param parameter the key title for the value that we need acquire
     * @return a simple string with the value for the requested key
     */
   public static String getHTMLparameter(Request request, String parameter){
        String result = "";
        try {   // should we show a specific section?
                result = request.getParameter(parameter);
            } catch (IOException ex) {
            }

        if(result == null)
            result = ""; // we can't afford null values,

        // clean up the result
        result = java.net.URLDecoder.decode(result);
        
        return result;
    }
    
   
   
   
    
}
