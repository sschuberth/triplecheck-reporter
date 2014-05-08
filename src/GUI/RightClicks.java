/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-10-18T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: RightClicks.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The code written here is intended to later be 
    ported over to beanshell scripts </text> 
 */
package GUI;

import definitions.is;
import script.log;
import spdxlib.SPDXfile;
import main.core;

/**
 *
 * @author Nuno Brito, 18th of October 2013 in Darmstadt, Germany.
 */
public class RightClicks {
    
    
    /**
      * Adds the currently selected component to the currently selected product
      */
     public static void addComponent(){
         TreeNodeSPDX currentNode = swingUtils.getSelectedNode();
         // avoid null cases
         if(currentNode == null){
             return;
         }
         // get the SPDX file from the root node
         SPDXfile component = (SPDXfile) swingUtils.getNodePackage
                 (core.studio.getTree())
                 .getUserObject();
        // if there is nothing selected, there is nothing to be done
        if(currentNode == null){
            return;
         }
        
        // get the current UID of the selected node
        String UID = currentNode.getUID();
        
        // get the current selected SPDXfile
        SPDXfile spdx = core.studio.productSelected;
        // check if it exists
        if(spdx == null){
            log.write(is.ERROR, "No product selected, cannot add component!");
            return;
         }
        // add this SPDX component onto the SPDX product
        spdx.addComponent(component);
        // refresh all the user data
        swingUtils.populateTree(core.studio.getTree());
        // get back to the parent node
        swingUtils.setSelectedNode(UID);
        // debug message
        //System.err.println("RE76 - Hi Mom!");
        
        
     }
    
     
     
     /**
      * Adds the currently selected component to the currently selected product
      */
//     public static void newSPDX(){
//         // instantiate the new SPDX document object
//         NewSPDX newSPDX = new NewSPDX();
//         newSPDX.setVisible(true);
//         
//         // get the current UID of the selected node
//         TreeNodeSPDX currentNode = swingUtils.getSelectedNode();
//         if(currentNode == null){
//             return;
//         }
//         
//        // the ID of currently selected node 
//        String UID = currentNode.getUID();
//        // refresh the data
//        swingUtils.populateTree(core.studio.getTree());
//        // get back to the parent node
//        swingUtils.setSelectedNode(UID);
//         
//     }
    
}
