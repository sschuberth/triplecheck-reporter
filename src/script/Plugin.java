/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: Plugin.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Used as the skeleton for beanshell/java hybrid
 * plugins. This part is what beanshell is actually running, albeit in the 
 * NetBeans IDE and code of each script we are declaring each plugin 
 * to implement Plugin.java
 * 
 * This trick was necessary to overcome some differences between Java and 
 * the Beanshell scripting" </text> 
 */

package script;

import GUI.swingUtils;
import definitions.is;
import java.io.File;
import java.util.Enumeration;
import main.engine;
import net.htmlparser.jericho.FormFields;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import spdxlib.swing.TreeNodeSPDX;
import www.WebRequest;

   
/**
 *
 * @author Nuno Brito, 8th of November 2013 in Darmstadt, Germany.
 */
public class Plugin extends PluginVanilla{

    // where we will store and retrieve the settings for this page
    private final String settingsFileName = "settings.xml";
    
     
     public void main(WebRequest request){
         request.setAnswer("<h1>In construction</h1>"
                 + "There is nothing (yet) to be displayed on this page.");
     }
     
    /**
     * Adds a tree node on the default User Interface when desired by the
     * plugin
     * @param title Title for the tree node that is shown to user
     * @param iconName Icon from our archive that is used for the node
     * @param methodName The method that is called when the node is clicked
     * @return 
      */
     protected TreeNodeSPDX addTreeNode(String title, String iconName, 
             String methodName){
     // get the saved node on our temporary storage
        TreeNodeSPDX nodeRoot = (TreeNodeSPDX) engine.temp.get("nodeTree");
        // add it up to our tree
        thisNode = swingUtils.addNode(title, iconName, nodeRoot);
        // set the associated script that we want to run
        thisNode.scriptFile = thisFile;
        thisNode.scriptFolder = thisFolder;
        thisNode.scriptMethod = methodName;
        
        // all done
        log.write(is.COMPLETED, "Added tool: %1", title);
        return thisNode;
     }
 
     
     /**
      * Adds a child node on the default User Interface when desired by the
      * plugin
      * @param title Title for the tree node that is shown to user
      * @param iconName Icon from our archive that is used for the node
      * @param methodName The method that is called when the node is clicked
      */
     protected void addChildNode(String title, String iconName, 
             String methodName){
         // we need that a root node exists
         if(thisNode == null){
             return;
         }
         
        // add it up 
        TreeNodeSPDX node = swingUtils.addNode(title, iconName, thisNode);
        // set the associated script that we want to run
        node.scriptFile = thisFile;
        node.scriptFolder = thisFolder;
        node.scriptMethod = methodName;
     }
     
     /**
      * Loads a given template file from the local folder. This template file
      * will automatically inherit the saved values from the local settings
      * file.
      * @param templateFile An HTML template that we want to use
      * @param request The web request with the necessary information
      */
     protected void templateLoad(String templateFile, WebRequest request){
      //TODO what happens if settings file doesn't exist?

     // get our template page
       File templatePage = new File(thisFolder, templateFile);
       // place its contents inside a string
       String webText = utils.files.readAsString(templatePage);
       
        // instantiate our HTML manipulating class
        Source source = new net.htmlparser.jericho.Source(webText);
        // get all the data available right now on the form
        FormFields formFields = source.getFormFields();
        // go throught all the saved values and place them on the web page
        Enumeration e = settings.getAllKeys();
        // iterate throught all saved settings
        while (e.hasMoreElements()) {
            // current key
            String key = (String) e.nextElement();
            if (key.equals("")==false) {
                String value = settings.read(key);
                formFields.setValue(key, value);
            }
        }
       
        // save the output
        OutputDocument outputDocument = new OutputDocument(source);
        // adds all segments necessary to effect changes
        outputDocument.replace(formFields);
        String result = outputDocument.toString();

        File tempFile = new File(thisFolder, "temp.html");
        utils.files.SaveStringToFile(tempFile, result);
        // load the page
        request.setPage(tempFile);
        // delete the page
        tempFile.delete();
     }
     
     /**
    * Save the settings to disk
    * @param request 
    */
    public void templateSave(WebRequest request){
        // get all parameters from our request, save them to disk
        for(String[] parameter : request.parameters){
            settings.write(parameter[0], parameter[1]);
        }
    }
     
}
