/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-13T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: nodeTools.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Add the node of tools inside the tree view. </text> 
 */

package basic;

import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import main.coreGUI;
import main.engine;
import script.Plugin;
import script.log;
import spdxlib.swing.NodeType;
import spdxlib.swing.TreeNodeSPDX;
import utils.www.html;


/**
 *
 * @author Nuno Brito, 13th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class nodeTools extends Plugin{
    
    final String LastFolderNewSPDX = "LastFolderNewSPDX";
    
    int interval = 3;
    
    @Override
    public void startup(){
        // react whenever a tree node is changed
        log.hooks.addAction(Messages.ReadyToUse, thisFile, "addNode");
        log.hooks.addAction(Messages.TreeNodeChanged, thisFile, "showTools");
        
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        JTree tree = coreGUI.studio.getTree();
        // avoid empty null objects when there is nothing on the tree
        if(tree.getModel().getRoot()==null){
            return;
        }
        TreeNodeSPDX nodeRoot = (TreeNodeSPDX) tree.getModel().getRoot();
        TreeNodeSPDX node = swingUtils.nodeCreate("Tools", NodeType.none, nodeRoot);
        node.setIcon("toolbox.png");
        // all finished, write this data on GUI tree list
        DefaultTreeModel treeModel = new DefaultTreeModel(nodeRoot);
        tree.setModel(treeModel);
        // store the tools node for future use
        engine.temp.put("nodeTree", node);
        // all done. Signal that other plugins can now add their own tooling
        log.write(is.INSTALLING, Messages.AddingTools);
    }
    
    /**
     * Displays a basic list of tools that are supported
     */
    public void showTools(){ // ensure we get to know which node is selected
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            return;
        }
        // get the unique identifier
        String nodeUID = node.getUID();
        // are we clicking on the root of our intended node?
        if(nodeUID.equals(">> Tools ") == false){
            return;
        }
        String content = getContent();
        coreGUI.studio.editorPane(is.contentHTML, false, 0, content);
    }

    /**
     * Get the initial screen with the tools
     * @return 
     */
    private String getContent() {
        String result = ""
                + html.div()
                + "<h2>"
                + "Tools"
                + "</h2>"
                + html._div
                + html.div()
                + "The initial plan was to have a tool that would create SPDX "
                + "documents. It is now available. If you have any ideas for "
                + "other features to add up here, "
                + html.link("let us know!", "http://triplecheck.de")
                +" :-)"
                + html.br
                + html.br
                + "<h3>"
                + "Version"
                + "</h3>"
                + html._div
                + html.div(20)
                + "You are using version " + engine.version + " of TripleCheck"
                + html.br
                + html._div
                + "";
        
        
        
        return result;
    }
}
