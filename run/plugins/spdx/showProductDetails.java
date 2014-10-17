/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: showProductDetails.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> When the user clicks on tree node that belongs to a 
 * product, show either the SPDX content or a summary with the highlights
 * </text> 
 */

package spdx;

import GUI.swingUtils;
import definitions.Messages;
import script.Plugin;
import script.log;
import spdxlib.swing.TreeNodeSPDX;


/**
 *
 * @author Nuno Brito, 10th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class showProductDetails extends Plugin{
    
    // node currently selected on the tree, we use this object across the script
    private TreeNodeSPDX node;

    @Override
    public void startup(){
        // react whenever a tree node is changed
        log.hooks.addAction(Messages.TreeNodeChanged, thisFile, "processNode");
    }
    
    /**
     * This is the method that proceed with the initial filtering. This is 
     * important to decide if we should continue or not
     */
    void processNode(){
        // ensure we get to know which node is selected
        node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            return;
        }
        // now we want to know if this is either:
        // a) a root node called "Reports"
        // b) a components inside one of the nodes from a)
     
    }
}
