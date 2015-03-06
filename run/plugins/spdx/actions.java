/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-08T00:00:00Z
 * LicenseName: AGPL-3.0+
 * FileName: actions.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package spdx;

import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;
import main.coreGUI;
import main.engine;
import FileExtension.FileExtension;
import script.Plugin;
import main.script.log;
import spdxlib.FileInfo;
import spdxlib.swing.NodeType;
import spdxlib.swing.TreeNodeSPDX;
import utils.www.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 08th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class actions extends Plugin{
    
    
    @Override
    public void startup(){
        // react whenever a tree node is changed
         log.hooks.addAction(Messages.TreeNodeDoubleClick, 
                thisFile, "processDoubleClick");    
    }

   
    
    /**
     * Shows a summary of details about the selected package
     * @param request
     */
    @Override
    public void main(WebRequest request) {
        // get the first parameter, which contains the file path
        String[] action = request.parameters.get(0);
        
        // create the file pointer
        File targetFile = new File(action[1]);
        // default answer
        String result = "File was not found: " 
                + targetFile.getAbsolutePath();
        
        // if the file exists, show it
        if(targetFile.exists()){
            result = readFile(targetFile);
        }
       
        request.setAnswer(result);
    }

    /**
     * This method attempts to display a file from disk and format in a manner
     * that looks more human-readable.
     * 
     * @param targetFile    The file that we want to open
     * @return              HTML text ready to be displayed to the user
     */
    private String readFile(File targetFile) {
        // get the extension object
        FileExtension extension = engine.extensions.get(targetFile);
        
        // when we know the extension, make it pretty
        if(extension != null){
            return extension.format(targetFile);
        } else{
            // read the contents of this file
            return boringText(targetFile);
        }
    }
    
    
    /**
     * Displays the text in a format without color highlighting on its syntax
     * @param targetFile    The file that we want to read
     * @param input         
     * @return 
     */
    String boringText(File targetFile){
            System.err.println("Reading: " + targetFile.getAbsolutePath());
            String input = utils.files.readAsString(targetFile);
            // We don't what we have here, but display it anyways
            input = "<pre>" + input + "</pre>";
            input = html.div() + input + html._div;
            return input;
    }
    
    /**
     * Opens up a requested folder on disk
     * @param request
     */
    public void folder(WebRequest request) {
    String paramString = request.getParameter("target");
        File file = new File(paramString);
         try {
                Desktop.getDesktop().open(file.getParentFile());
            } catch (IOException ex) {
            }
         
         
         String output = "Opening the folder.";
         request.setAnswer(output);
    }
    
     /**
     * This method handles doubleclicks on tree nodes
     */
    void processDoubleClick(){
        // ensure we get to know which node is selected
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            System.err.println("AC123 Null node");
            return;
        }
        
         // process files
        if(node.nodeType != NodeType.file){
            System.err.println("AC129 Not a node file");
            return;
        }
       
        // we're talking about tree nodes, get the respective information
        FileInfo fileInfo = (FileInfo) node.getUserObject();
        File targetFile = fileInfo.getFile();
        
        if(targetFile == null){
            System.err.println("AC139 Null file pointer on: " + fileInfo.getFileName());
            return;
        }
        
        String result = "";
        
        // if the file exists, show it
        if(targetFile.exists()){
            result = readFile(targetFile);
        }

        // no results? no point in continuing
        if(result==null || result.isEmpty()){
            return;
        }
        
        // try to place everything on screen
        try{
            final String content = result;
            
//            engine.studio.editorPane(is.contentHTML, false, 0, result);
            SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run(){
            coreGUI.studio.editorPane(is.contentHTML, false, 0, content);
                }
            });
            
            
        }catch (RuntimeException e){
            System.err.println("AC168 - Error when showing file: " + targetFile.getAbsolutePath());
            // activate plan B, just show the boring stuff
            result = boringText(targetFile);
            coreGUI.studio.editorPane(is.contentHTML, false, 0, result);
        }
    }
    
}
