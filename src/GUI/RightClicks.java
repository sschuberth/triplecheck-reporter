/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-10-18T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: RightClicks.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The code written here is intended to later be 
    ported over to beanshell scripts </text> 
 */
package GUI;

import definitions.Messages;
import definitions.is;
import java.io.File;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import script.log;
import spdxlib.FileInfo;
import spdxlib.Person;
import spdxlib.SPDXfile;
import main.core;

/**
 *
 * @author Nuno Brito, 18th of October 2013 in Darmstadt, Germany.
 */
public class RightClicks {
    
    
    
    /**
     * Generic processing of clicks on the tree box
     */
//     static public void processClick(){
//         JTree tree = core.studio.getTree();
//         TreeNodeSPDX currentNode = swingUtils.getSelectedNode(tree);
//         // if there is nothing selected, there is nothing to be done
//         if(currentNode == null){
//            return;
//         }
//
//         // remove all items from the right-column that are registered here
//         removeTreeActions();
//          
//         // get some variables from our UI
//         JEditorPane text = core.studio.getTextBox();
//         
//         // get the UID of the selected node
//         String UID = currentNode.getUID();
//         log.write(is.INFO, Messages.NodeSelected, UID);
//         //System.err.println("RC01 - " + UID);
//         
//        // launch the trigger for clicking on library components 
//        if(UID.contains(" >> Library")){
//            log.write(is.INFO, Messages.ClickedOnLibraryComponent);
//        }        
//         
//         
//         // what kind of node have we clicked?
//        if(currentNode.nodeType == NodeType.file){
//            FileInfo file = (FileInfo) currentNode.getUserObject();
//            
//            int lineNumber = file.tagFileName.linePosition;
//            // move to the specific line when possible
//            swingUtils.moveToLine(lineNumber, text, core.studio);
//   
//            log.write(is.INFO,"File at line %1", lineNumber + "");
//            //core.studio.writeBoxMessage(log.getLatest().getMessageSimple());
//            return;
//        }
//        
//        // handle the nodes of people
//        if(currentNode.nodeType == NodeType.person){
//            Person person  = (Person) currentNode.getUserObject();
//            //TODO this is not a good code, better have something generic
//            int lineNumber;
//            
//            if(person.tagPerson == null){
//                if(person.tagTool == null){
//                    return; // some weird exceptions happen here
//                }else{
//                    // I've seen cases where only the tool is mentioned
//                    lineNumber = person.tagTool.linePosition;
//                }
//                
//            }else{
//                // default case, use the person name
//                lineNumber = person.tagPerson.linePosition;
//            }
//            // move to the specific line when possible
//            swingUtils.moveToLine(lineNumber, text, core.studio);
//            // all done
//            addPersonActions();
//            log.write(is.INFO,"Person at line %1", lineNumber + "");
//            //core.studio.writeBoxMessage(log.getLatest().getMessageSimple());
//        }
//        
//     }
     
//     /**
//      * Remove all icons associated with "persons". This is necessary
//      */
//     static void removeTreeActions(){
//         // we need to manually register here all the actions to remove     
//         RunPlugins.removeItem(Actions.personDelete);
//         RunPlugins.removeItem(Actions.addComponentToProduct);
//      }
     
     /**
      * Add the typical icons that you would like to see when a person
      * is selected on the tree box
      */
//     public static void addPersonActions(){
//                
//         // specify the action to delete the selected person
//         ListItem item = new ListItem();
//         item.title = Actions.personDelete;
//         item.singleClick = true;
//         File icon = core.getIcon("cross-script.png");
//         item.setIcon(icon);
//         RunPlugins.addItem(item);
//     }
     
    
    ////////////////////////////////////////////////////////////////////////
    /////////////////////////                   ////////////////////////////
    /////////////////////////  Click on Library ////////////////////////////
    /////////////////////////                   ////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    
    /**
     * Shows the actions available when clicking at a component inside our
     * common library. This is useful for actions such as adding the component
     * to the currently selected product
     */
//    public static void processClickOnLibraryComponent(){
//        TreeNodeSPDX currentNode = swingUtils.getSelectedNode();
//        // if there is nothing selected, there is nothing to be done
//        if(currentNode == null){
//            return;
//         }
//     
//        if(core.studio.productSelected == null){
//            log.write(is.INFO,"No product is selected");
//            return;
//         }
//     
//        // specify the action to delete the selected person
//         ListItem item = new ListItem();
//         item.title = Actions.addComponentToProduct;
//         item.singleClick = true;
//         File icon = core.getIcon("box--plus.png");
//         item.setIcon(icon);
//         RunPlugins.addItem(item);
//         // mention what is the selected product right now
//         log.write(is.INFO,"Selected product is \"%1\"", 
//                 core.studio.productSelected.getId());
//         //core.studio.writeBoxMessage(log.getLatest().getMessageSimple());    
//    }
//    
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
     public static void newSPDX(){
         // instantiate the new SPDX document object
         NewSPDX newSPDX = new NewSPDX();
         newSPDX.setVisible(true);
         
         // get the current UID of the selected node
         TreeNodeSPDX currentNode = swingUtils.getSelectedNode();
         if(currentNode == null){
             return;
         }
         
        // the ID of currently selected node 
        String UID = currentNode.getUID();
        // refresh the data
        swingUtils.populateTree(core.studio.getTree());
        // get back to the parent node
        swingUtils.setSelectedNode(UID);
         
     }
    
}
