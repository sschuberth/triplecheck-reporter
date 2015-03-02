/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-01-09T14:04:22Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: WebServer.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Makes possible the web user interface. Allows users to 
 * control the program using a web browser.</text>
 */
package www;

import GUI.webUtils;
import definitions.is;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.controller;
import main.engine;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;
import org.simpleframework.util.thread.Scheduler;
import main.script.log;

/**
 *
 * @author Nuno Brito, 9th of January 2013 in Darmstadt, Germany.
 */
public class WebServer implements Container {

    // title for this plugin
    private final String id = "Web Interface";
    
    Scheduler queue;
    Connection connection;
    public String webOutput = "";
    
          
    /** 
     * Serve the requested file
     * @param request Provided by this web server
     * @param response Provided by this web server
     * @param targetFile The file inside our server machine
     */
    public static void giveFileDownload(Request request, Response response,
            File targetFile ){
        try{
            // don't give away any folders
            if(targetFile.isDirectory() || targetFile.exists()==false){
                log.write(is.REFUSED, "Web server is unable to find %1", 
                        targetFile.getName());
                response.close();
                return;
            }

            // set the type of download
            response.setMinor(1);
            OutputStream out = response.getOutputStream();

            //String diskFile = targetFile.getPath();
            // get the MIME header when available
            //response.set("Content-Type", MimeIndexer.getContentType(diskFile));
            // help web browsers know about the size of this file in advance
            response.set("Content-Length", (int) targetFile.length());
            // define the file name
            response.set("Content-Disposition", "filename=\""
                    + targetFile.getName() + "\"");
            // close our connection after serving the file
            response.set("Connection", "close");

            InputStream file = null;
                try {

                    file = new FileInputStream(targetFile);
                    byte[] chunk = new byte[(int) targetFile.length()];
                    int count;
                    int pos = 0;
                    while ((count = file.read(chunk, pos, chunk.length - pos)) > 0) {
                        pos += count;
                    }
                    out.write(chunk);
                } finally {
                    // close our input stream
                    if(file!=null)
                        file.close();
                }
            // close our response
            response.close();
        } catch (IOException ex) {
            Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    
    /** Start our web server instance
     * @param portNumber the port of communications (typically 80 for Internet)
     */     
   public void startServer(String portNumber){
          
            try {
            // get the port number
//            String portNumber = engine.settings.read(definition.port, 
//                    definition.portDefault);
            int serverPort = Integer.parseInt(portNumber);
            
            // launch our server instance
            queue = new Scheduler(20);
            Container container = this; //new WebServer(queue);
            connection = new SocketConnection(container);
            final SocketAddress address = new InetSocketAddress(serverPort);

            // do the connection itself
            connection.connect(address);
                   
            
//            utils.internet.openURL("http://127.0.0.1/" + portNumber);
            log.write(is.COMPLETED, "Web server is available on port %1 of this"
                    + " machine", portNumber);
            
         } catch (IOException ex) {
             log.write(is.ERROR, "Web server error. Couldn't open port %1: %2"
                     ,portNumber , ex.getMessage());
      }
   }

   /**
    * stop the server in case it was already running
    */
    public void stopServer() {
        try {
            this.connection.close();
            log.write(is.CLOSE, "Web server was closed");
        } catch (IOException ex) {
            Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   class Task implements Runnable {
  
      private final Response response;
      private final Request request;
 
      public Task(Request request, Response response) {
         this.response = response;
         this.request = request;
      }

      
        @Override
        public void run() {
            // get what we are tryng to run
            String rawText = request.getTarget();
            log.write(is.RUNNING, "Web request for %1", rawText);
                
            // do we want a script file or a normal binary file?
            // we need to define the concept of root folder that is shared.
            int pos = rawText.indexOf("?");
            // handle the case when there is no "?" on the path
            if(pos < 0){
                pos = rawText.length();
            }

            // get the file name
            String targetScript = rawText.substring(0,pos);

            // if it does not have a .java extension, add one up
            if((targetScript.contains(".") == false) &&
                    (targetScript.toLowerCase().endsWith(".java")==false)){
                // this allows pretty URLs to happen
                targetScript += ".java";
            }

            
            // do we just want to serve a file?
            if(targetScript.toLowerCase().endsWith(".java")==false){
                File file = new File(engine.getPluginsFolder(), rawText);
                WebServer.giveFileDownload(request, response, file);
                return;
            }
               
            
                File scriptFile = new File(engine.getPluginsFolder(), targetScript);
                File scriptFolder = scriptFile.getParentFile();
                
                // exit if a file was not found
                if(scriptFile.exists() == false){
                    log.write(is.NOTFOUND, "Web request file was not found: %1",
                            scriptFile.getName());
                }
                
                String scriptMethod = 
                        webUtils.getHTMLparameter(request, is.methodExecute);
                
//                if(scriptMethod.equals("start")){
//                    System.err.println("Listing all parameters:");
//                    utils.internet.getHTMLparameters(request);
//                }
                
                WebRequest newRequest = new WebRequest();
                newRequest.requestType = RequestType.UNKNOWN;
                newRequest.requestOrigin = RequestOrigin.BROWSER;
                newRequest.BaseFolder = scriptFolder;
                newRequest.scriptFile = scriptFile;
                newRequest.scriptFolder = scriptFolder;
                newRequest.scriptMethod = scriptMethod;
                newRequest.requestSimple = request;
                newRequest.responseSimple = response;
                
                // add the parameters
                 
          try {
              Set<String> keyset;
                keyset = keyset = request.getForm().keySet();
         
            for(String key : keyset) {
                //String key = part.getName();
                String value = request.getParameter(key);
//                System.err.println(key + "-->" + value);
                newRequest.addParameter(key, value);
            }
                } catch (IOException ex) {
              Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
          } 
                
                controller.process(newRequest);
                
                //System.err.println(result);
                
                // http://localhost:10101/createspdx/CreateSPDX.java?method=showTools&params=1234
//                String address = request.getAddress().getPath().toString();
//                
//                System.err.println("WS002 - " + address);
//                
//                if(address.equals("/log")){
//                    body.println(doHeaderAndBodyAutoRefresh());
//                    ArrayList<LogEntry> entries = log.getList();
//                    if(entries.isEmpty()){
//                        String temp = 
//                                "<xmp>"
//                                + "</xmp>"
//                                + "<tt>"
//                                + "</tt>"
//                                ;
//                        body.println(temp);
//                    }
//
//                    body.println("<div style=\"width: 100%;\"><tt>");
//                    
//                    // getMessage only the last 20 entries
//                    int count = (entries.size()>21) ? entries.size() - 20 : 1;
//                    
//                    for(int i = count; i <= entries.size(); i++){
//                        LogEntry entry = entries.get(i-1);
//                        String output = entry.getMessage() + "<br>";
//                        output = output.replace("\n", "\n<br>");
//                        if(entry.getResult() != is.EXTRA){
//                            output = entry.getTimeReadable() + " " + output;
//                        }
//                        //+ "<br>";
//                            body.println(output);
//                    }
//                    
//                    body.println("</tt></div>");
//                    body.close();                
//                    response.close();
//                    return;
//                }
//                
//
//                
//                body.println("<iframe name=\"iframeName\" src=\"/log\" width=\"100%\" "
//                        + "onload=\"document.title=this.contentWindow.document.title;\" "
//                        + "height=\"100%\" frameborder=\"0\" "
//                        + "align=\"left\" "
//                        + "scrolling=\"no\""
//                        + " onload=\"document.title=parent.frames['iframeName'].document.title;\""
//                        + "></iframe><br><br>");
//                
//                 
//                // all done
//                body.close();                
//                
//                // close our connection after serving the text
//                //response.set("Connection", "close");
//                response.close();
                
//            } catch (IOException ex) {
//                Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    @Override
    public void handle(Request rqst, Response rspns) {
                  Task task = new Task(rqst, rspns);
                  queue.execute(task);
    }

  
    
   
    
}
