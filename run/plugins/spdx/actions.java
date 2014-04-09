/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-08T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: actions.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text>  </text> 
 */

package spdx;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import main.core;
import script.FileExtension;
import script.Plugin;
import script.log;
import spdxlib.FileInfo;
import utils.html;
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
        String result = "";
        // get the extension object
        FileExtension extension = core.extensions.get(targetFile);
        
        // when we know the extension, make it pretty
        if(extension != null){
            result = extension.format(targetFile);
            return result;
        } else{
            // read the contents of this file
            result = utils.files.readAsString(targetFile);
            // We don't what we have here, but display it anyways
            result = result.replace("\n", "\n" + html.br);
        }
        
        return result;
    }
    
    
    /**
     * Opens up a requested folder on disk
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
            return;
        }
        
         // process files
        if(node.nodeType != NodeType.file){
            return;
        }
       
        // we're talking about tree nodes, get the respective information
        FileInfo fileInfo = (FileInfo) node.getUserObject();
        
        File targetFile = fileInfo.getFileName();
        
        if(targetFile == null){
            return;
        }
        
        String result = "";
        
        // if the file exists, show it
        if(targetFile.exists()){
            result = readFile(targetFile);
        }

        // nothing exciting here, no point in continuing
        if(result.isEmpty()){
            return;
        }
        
        // place everything on screen
        core.studio.editorPane(is.contentHTML, false, 0, result);
    }
    
}
