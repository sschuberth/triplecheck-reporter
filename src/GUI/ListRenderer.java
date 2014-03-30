/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-20T00:00:00Z
 *
 * LicenseName: NOASSERTION
 *
 * FileName: ListRenderer.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> This class sets the icons that are displaed on the tree
 * lists for each item.</text> 
 */
package GUI;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import main.core;


public class ListRenderer 
	extends DefaultListCellRenderer {
   
    // get our icons
    private Icon get(String what){
        return new ImageIcon(core.getIcon(what).getAbsolutePath());
    }
    
      Icon 
            defaultIcon = get("blue-document-node.png");
        
        
	@Override
	public Component getListCellRendererComponent(
		JList list, Object value, int index, 
		boolean isSelected, boolean cellHasFocus) {
            
            // inherit all the good stuff that comes as default
            super.getListCellRendererComponent
                    (list, value, index, isSelected, cellHasFocus);
            
            // get the product object
            ListItem item = (ListItem) value; 

            // write the title of this product
            //setText(item.toString());
            
            if(item.icon == null){
                setIcon(defaultIcon);
            }else{
                setIcon(item.icon);
            }
            
            return this;
	}

	
}

