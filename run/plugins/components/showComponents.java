/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-03T12:10:47Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: showComponents.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The page for finding components </text> 
 */

package components;

import GUI.SearchType;
import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import definitions.Messages;
import java.io.File;
import main.core;
import script.Plugin;
import script.log;
import utils.html;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public class showComponents extends Plugin{
     
    String id = "Components";
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        TreeNodeSPDX baseNode = addTreeNode(id, "blue-document-node.png", "main");
        
        TreeNodeSPDX nodeCreateComponent = swingUtils.addNode("Create new", 
                "box--plus.png", baseNode);
        // set the associated script that we want to run
        nodeCreateComponent.scriptFile = new File(thisFolder, "createNew.java");
        nodeCreateComponent.scriptFolder = thisFolder;
        nodeCreateComponent.scriptMethod = "createNew";
    }
    
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        // specific to the GUI
        if(request.requestOrigin == RequestOrigin.GUI_tree){
            core.studio.setSearchProvider(SearchType.Components_Show);
        }
        // show up our search page
        final String link = "/components/showComponent?name=";
        String result = core.components.getPrettyListHTML("View", link);
        
        result = html.div()
                + result
                + html._div;
        
        request.setAnswer(result);
        
    }
   
}
