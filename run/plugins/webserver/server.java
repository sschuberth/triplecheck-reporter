/*
 * Makes possible the web user interface. Allows users to control the program
 * using a web browser.
 */
package webserver;

import definitions.Messages;
import definitions.definition;
import main.core;
import script.Plugin;
import script.log;
import utils.html;
import www.WebRequest;
import www.WebServer;

/**
 *
 * @author Nuno Brito, 9th of January 2013 in Darmstadt, Germany.
 */
public class server extends Plugin{

    // title for this plugin
    private final String id = "Web server";
    
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
        startServer();
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        addTreeNode(id, "network-clouds.png", "main");
    }
 
    
   /** Start our instance */     
   public void startServer(){
       String status = settings.read("status", "offline");
       // if we are supposed to be offline, don't start the server
       if(status.equals("offline")){
           // we might have started before and need to now place it offline
           WebServer server = (WebServer) core.temp.get("server");
           if(server != null){
               server.stopServer();
           }
           return;
       }
       // let's kickoff the server
       WebServer server = new WebServer();
       String portNumber = settings.read("port", definition.portDefault);
       server.startServer(portNumber);
       core.temp.put("server", server);
   }
    
   /**
    * Save the settings to disk
    * @param request 
    */
    public void save(WebRequest request){
        // save the info from our template for future use
        templateSave(request);
 
        // Let's see if we need to start our server
        startServer();
        // all done
        String message = html.h3("Settings saved!");
        request.setAnswer(utils.html.redirect("/webserver/server", 2, message));
    }
   
    
    /**
     * Opens up the web browser from the user on the front page of our software
     * @param request the end-user request
     */
    public void open(WebRequest request){
        String status = settings.read("status", "offline");
       // if we are supposed to be offline, we can't use this thing
       if(status.equals("offline")){
           String message = html.h3("You need to first activate the server..");
           request.setAnswer(utils.html.redirect("/webserver/server", 2, message));
           return;
       }
       
       // get the current port number
       String portNumber = settings.read("port", definition.portDefault);
       
       // All checked, let's open the front page
       utils.internet.openURL("http://127.0.0.1:" + portNumber 
               + "/basic/home");
       
       String message = html.h3("Opening your web browser..");
       request.setAnswer(utils.html.redirect("/webserver/server", 2, message));
    }
    
   /**
    * Show the main page for the server settings
    * @param request the request from the end-user
    */ 
   @Override
   public void main(WebRequest request){
       templateLoad("serverSettings.html", request);
   }
   
    
}
