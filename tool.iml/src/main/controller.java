/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-02T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: controller.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class is responsible for receiving requests from 
 * users, dispatching the correct actions to process the request and then 
 * provide an answer. The reason why it is called "controller" is because it
 * stays in the middle between the communication. The controller receives
 * web requests and knows where they should be displayed. </text> 
 */

package main;

import definitions.is;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import script.log;
import www.RequestOrigin;
import www.WebRequest;
import www.WebServer;

/**
 *
 * @author Nuno Brito, 2nd of December 2013 in Darsmtadt, Germany
 */
public class controller {
 
    
    
    /**
     * Places a web request on the queue to be processed. This is an important
     * step to ensure that each web request is handled in the same manner. There
     * is no more direct contact with the location where the web request is
     * displayed, there is this controller class that will know and decide when
     * to present the message.
     * @param request The object with details about the request
     */
    public static void display(WebRequest request) {
        // preflight checking, we need an answer to be available
        if(request.hasAnswer() == false){
            return;
        }
        
        // is this request intended for the web or for the Swing UI?
        if(request.requestOrigin == RequestOrigin.GUI){
            displayRequestGUI(request);
            return;
        }
        
        // is this request intended for the web or for the Swing UI?
        if(request.requestOrigin == RequestOrigin.GUI_tree){
            displayRequestGUI(request);
            return;
        }
        
        // Was this request made from a web browser?
        if(request.requestOrigin == RequestOrigin.BROWSER){
            displayRequestBrowser(request);
            return;
        }
        
        
        System.err.println("WR002 - Unknown origin for request");
    }

    /**
     * Handle a given request that we want to display on the Swing UI
     * @param request 
     */
    private static void displayRequestGUI(WebRequest request) {
        core.studio.editorPane(is.contentHTML, false, 0, 
                request.getAnswer(), Boolean.TRUE, request);
    }

    /**
     * Display the provided request on the web browser
     * @param request 
     */
    private static void displayRequestBrowser(WebRequest request) {
        PrintStream body;
            // a request has arrived, let's process this
            try {
                body = request.responseSimple.getPrintStream();
                body.println(request.getAnswer());
                 // all done
                body.close();                
                
                // close our connection after serving the text
                //response.set("Connection", "close");
                request.responseSimple.close();
                
            } catch (IOException ex) {
                Logger.getLogger(WebServer.class.getName()).log
                    (Level.SEVERE, null, ex);
            }
    }
    
    /**
     * The front-end of the controller class to receive request and forward this
     * request to the appropriate script to later collect the expected answer.
     * @param newRequest 
     * @return The HTML code that will be presented to the end-user
     */
    public static String process(WebRequest newRequest) {
        // if the user clicked on a tree node, we know what to do
//        if(
//           (newRequest.requestOrigin == RequestOrigin.GUI_tree)
//          || (newRequest.requestOrigin == RequestOrigin.GUI)
//                
//                ){
        
        
        if(newRequest == null){
            log.write(is.ERROR, "CON001 - Received a null request");
            return "";
        }
        
             // if there is no method selected, just call the default one
            if((newRequest.scriptMethod == null)
                    ||(newRequest.scriptMethod.isEmpty())
                ){
                    newRequest.scriptMethod = is.methodDefault;
                }
        
            // we need the base folder to be defined as well
            newRequest.BaseFolder = newRequest.scriptFile.getParentFile();
            newRequest.scriptFolder = newRequest.BaseFolder;
            
            log.write(is.OPENING, "Web request for \"%1\" in %2", 
                    newRequest.scriptMethod,
                    newRequest.scriptFile.getAbsolutePath());
        
            // do a unique id for this request
            long randomTime = System.currentTimeMillis();
            String randomId = "request" + randomTime;
            // place this request in our memory
            core.temp.put(randomId, newRequest);
            // prepare our tricky command
            // basically, we first retrieve the object and then pass this as
            // parameter for the requested method
            String command = ""
                    + "WebRequest webRequest = (WebRequest) core.temp.get(\"" 
                    + randomId 
                    +"\");\n"
                    + "plugin." + newRequest.scriptMethod + "(webRequest);";
            // run the script file
            core.script.runJava(newRequest.scriptFile, command, is.plugin);
            
            WebRequest processedRequest = (WebRequest) core.temp.get(randomId);
            
            // we might have cases where the request is null
            String result = "";
            if(processedRequest != null){
                result = processedRequest.getAnswer();
                //return null;
            }
            
            // remove it from the memory
            core.temp.remove(randomId);
            
            return result;
    }
//            return;
//        }
//        System.err.println("CN001 - Request not processed");
//    }

    
}
