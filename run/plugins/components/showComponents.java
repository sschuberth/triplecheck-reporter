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
import GUI.swingUtils;
import comp.LinkType;
import definitions.Messages;
import java.io.File;
import java.util.ArrayList;
import main.engine;
import main.coreGUI;
import script.Plugin;
import main.script.log;
import spdxlib.swing.TreeNodeSPDX;
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
            coreGUI.studio.setSearchProvider(SearchType.Components_Show);
        }
        
        ArrayList<LinkType> link = new ArrayList();
        link.add(LinkType.View);
        
        String result = engine.components.getReport(link);
        
        request.setAnswer(result);
    }
   
}
