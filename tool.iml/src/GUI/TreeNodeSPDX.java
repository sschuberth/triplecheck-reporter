/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-01T00:00:00Z
 *
 * LicenseName: EUPL-1.1-without-appendix
 *
 * FileName: TreeNodeSPDX.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> A tree node object adapted for SPDX documents </text> 
 */

package GUI;

import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import main.core;


public class TreeNodeSPDX extends DefaultMutableTreeNode{
 
    public NodeType // define the type of node that we have here 
            nodeType = NodeType.none;
    
    public String
            id = "";
    
    private String
            title = "";
    
    private int
            // counts the number of relevant childs
            counter = 0;
    
    // in case we want to run a file with a script
    public File 
            scriptFile = null,
            scriptFolder = null;
    // if a file with a script was added, which method should be run?
    public String scriptMethod;
    public ArrayList<String[]> scriptParameters = new ArrayList();
    
    public Icon 
            icon = null,
            iconWhenSelected = null;
    

    public TreeNodeSPDX(String library) {
        super(library);
        title = library;
    }
    
//    @Override
//    public String toString(){
//        return "";
//    }

    public TreeNodeSPDX(TreeNodeSPDX root) {
        super(root);
         title = root.toString();
    }
    
    @Override
    public String toString(){
        String result = getTitle();
        if(counter > 0){
            result += " (" + counter + ")";
        }
        return result;
    }

    public String getTitle() {
        if(title == null){
            title = id;
        }
        if(title.isEmpty()){
            title = id;
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
     /**
      * Given a specific tree node, generate a unique ID
      * @param node the node from where start to calculate the ID string
      * @return a unique ID based on the parent nodes of this entry
      */
     public String getUID(){
         String result = "";
         TreeNodeSPDX currentNode = this;
         while(currentNode.getParent() != null){
             result = result + ">> " + currentNode.id + " ";
             currentNode = (TreeNodeSPDX) currentNode.getParent();
         }     
         return result;
     }
    
     
    
     /**
      * Defines a new Icon for this node
      * @param what the icon file name that is located under the "icons" folder
      */
     public void setIcon(String what){
        icon = new ImageIcon(core.getIcon(what).getAbsolutePath());
    }
     
     /**
      * Defines a new Icon for this node
      * @param what the icon file name that is located under the "icons" folder
      */
     public void setIconWhenSelected(String what){
        iconWhenSelected = new ImageIcon(core.getIcon(what).getAbsolutePath());
    }

     /**
      * Sets the number of relevant children on this node
      * @param counter a positive, decimal value
      */
    public void setCounter(int counter) {
        this.counter = counter;
    }
     
     
     
}
