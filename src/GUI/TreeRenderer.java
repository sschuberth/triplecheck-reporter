/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-17T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TreeRenderer.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Add the pretty icons on tree objects </text> 
 */

package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import main.core;
import spdxlib.FileInfo2;


public class TreeRenderer extends DefaultTreeCellRenderer {
 
//    // get our icons
//    private Icon get(String what){
//        return new ImageIcon(core.getIcon(what).getAbsolutePath());
//    }
    
//    Icon 
//            none = get("blue-document-node.png"),
//            person = get("stickman.png"),
//            //person = get("user-medium-silhouette.png"),
//            sectionCreator = get("fingerprint.png"),
//            sectionPackage = get("box.png"),
//            sectionFile = get("documents-stack.png"),
//            sectionReview = get("geolocation.png"),
//            //dependency = get("envelope.png"),
//            file = get("document-number.png"),
//            home = get("home.png"),
//    
//            folderClosed = get("folder-horizontal.png"),
//            folderOpen = get("folder-horizontal-open.png");
    
            // medal-premium.png
  
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
        boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        
        super.getTreeCellRendererComponent(
            tree, value, sel, exp, leaf, row, hasFocus);
        
        // get the node we focusing at this moment
        TreeNodeSPDX node = (TreeNodeSPDX) value;
        
        // write the title of this product
            setText(node.toString());
            
       // is this icon selected?
        if(sel){
            // show the selected icon in that case
            if(node.iconWhenSelected != null){
                setIcon(node.iconWhenSelected);
            }
        }   
        
        
        // when it is a file, process and close down the shop
        if((node.getUserObject() != null)
                &&(node.nodeType == NodeType.file)){
            doNodeFile(node);
            return this;
        }
        // if there is an icon defined for this node, set it up here.
        if(node.icon != null){
            setIcon(node.icon);
        }
        else // do the switch based on type of icon
        switch(node.nodeType){
            case folder:
                setIcon(core.iconFolderClosed);
                node.iconWhenSelected = core.iconFolderOpen;
                break;
            case sectionFile:
                setIcon(core.iconFiles);
                break;
            default:
                setIcon(core.iconUNKNOWN);
                break;
        }
            
        return this;
    }

    
    /**
     * Handles a file node
     * @param node 
     */
    private void doNodeFile(TreeNodeSPDX node){
        // get the data from this node
        FileInfo2 fileInfo = (FileInfo2) node.getUserObject();

        if(fileInfo.getExtensionObject()!= null){
            //node.icon = fileInfo.getFileCategory().toIcon();
            node.icon = fileInfo.getExtensionObject().getCategory().toIcon();
            setIcon(node.icon);
        }

        setText(fileInfo.toString());
        setFont(getFont().deriveFont(Font.PLAIN));
        // show nodes with concluded license in blue color
        // when a file has a licensed declared and concluded
        if((fileInfo.hasLicenseConcluded())
                &&(fileInfo.hasLicenseInfoInFile())){
            setForeground(Color.BLUE);
            setFont(getFont().deriveFont(Font.BOLD));
        }else
            // when it's just a concluded license
        if(fileInfo.hasLicenseConcluded()){
            setBorderSelectionColor(Color.black);
            setForeground(Color.BLACK);
            setFont(getFont().deriveFont(Font.BOLD + Font.ITALIC));
        }else
            // when it is license inside the file
        if(fileInfo.hasLicenseInfoInFile()){
            setForeground(Color.BLUE);
        }
    }
    
    
}
