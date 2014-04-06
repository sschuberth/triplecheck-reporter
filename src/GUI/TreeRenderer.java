/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-17T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: TreeRenderer.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Add the pretty icons on tree objects </text> 
 */

package GUI;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import main.core;


public class TreeRenderer extends DefaultTreeCellRenderer {
 
    // get our icons
    private Icon get(String what){
        return new ImageIcon(core.getIcon(what).getAbsolutePath());
    }
    
    Icon 
            none = get("blue-document-node.png"),
            person = get("stickman.png"),
            //person = get("user-medium-silhouette.png"),
            sectionCreator = get("fingerprint.png"),
            sectionPackage = get("box.png"),
            sectionFile = get("documents-stack.png"),
            sectionReview = get("geolocation.png"),
            //dependency = get("envelope.png"),
            file = get("document-number.png"),
            home = get("home.png"),
    
            folderClosed = get("folder-horizontal.png"),
            folderOpen = get("folder-horizontal-open.png");
    
            // medal-premium.png
  
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
        boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        
        super.getTreeCellRendererComponent(
            tree, value, sel, exp, leaf, row, hasFocus);
        
        TreeNodeSPDX node = (TreeNodeSPDX) value;

        // if there is an icon defined for this node, set it up here.
        if(node.icon != null){
            setIcon(node.icon);
        }
        else // do the switch based on type of icon
        switch(node.nodeType){
            case none:
                setIcon(none);
                break;
            case file:
                setIcon(file);
                break;
            case folder:
                setIcon(folderClosed);
                node.iconWhenSelected = get("folder-horizontal-open.png");
                break;
            case person:
                setIcon(person);
                break;
            case sectionCreator:
                setIcon(sectionCreator);
                break;
            case sectionPackage:
                setIcon(sectionPackage);
                break;
            case sectionFile:
                setIcon(sectionFile);
                break;
            case sectionReview:
                setIcon(sectionReview);
                break;
//            case home:
//                setIcon(home);
//                break;
            case home:
                setIcon(home);
                break;
        }
        
        // is this icon selected?
        if(sel == true){
            if(node.iconWhenSelected != null){
                setIcon(node.iconWhenSelected);
            }
        
        }
        
            // write the title of this product
            setText(node.toString());
  
        return this;
    }

}
