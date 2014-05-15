/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-04-10T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: MiscMethods.java  
 * FileType: SOURCE
 * FileCopyrightText: <text>
 * Copyright 2014 Nuno Brito, TripleCheck
 * Copyright 2010 aterai (https://community.oracle.com/people/aterai)
 * </text>
 * FileComment: <text> Code from other authors. Permission and credits 
 * are assigned where possible. This class does not intend to keep a complete
 * list of all the third-party snippets, it is used whenever possible.</text> 
 */

package ThirdParty;

import GUI.TreeNodeSPDX;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreePath;


/**
 *
 * @author Nuno Brito, 15th of May 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class MiscMethods {

    /**
     * This code helps to collapse all the tree nodes from a treeview.
     * It was retried from a forum post on the Internet
     * @origin https://community.oracle.com/thread/1558600?start=0&tstart=0
     * @date 2014-05-15
     * @author aterai (Oct 12, 2010 2:15 AM)  
     * @param tree      A given treeview object
     * @param parent    The path that we want to collapse
     */
    public static void collapseAll(JTree tree, TreePath parent) {
        TreeNodeSPDX node = (TreeNodeSPDX)parent.getLastPathComponent();
        if (!node.isLeaf() && node.getChildCount()>=0) {
        Enumeration e = node.children();
        while (e.hasMoreElements()) {
            TreeNodeSPDX n = (TreeNodeSPDX)e.nextElement();
            TreePath path = parent.pathByAddingChild(n);
            collapseAll(tree, path);
        }
        }
        tree.collapsePath(parent);
    }
    
}
