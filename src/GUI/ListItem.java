/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-20T00:00:00Z
 *
 * LicenseName: EUPL-1.1-without-appendix
 *
 * FileName: ListItem.java  
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> The custom handler of nodes for lists </text> 
 */

package GUI;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Nuno Brito, 20th of September 2013 in Darmstadt, Germany.
 */
public class ListItem implements Comparable{

    public Icon 
            icon = null; // the icon that will be used for rendering this item
    
    public String 
            title = "";
    public boolean  // permit this item to be launched with a single click
            singleClick = false;
    
    // set of methods to be overriden
    public void onDoubleClick(){}
    public void onTripleClick() {}
    
    public void setIcon(File file){
        icon = new ImageIcon(file.getAbsolutePath());
    }
    
    @Override
    public String toString(){
        return title;
    }

    @Override
    public int compareTo(Object o) {
        ListItem product = (ListItem) o;
        return this.toString().compareTo(product.toString());
    }

}
