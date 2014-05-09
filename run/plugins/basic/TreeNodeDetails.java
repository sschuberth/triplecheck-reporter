/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-15T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TreeNodeDetails.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This plugin adds up more details on the tree view 
 * whenever the user clicks on a given SPDX document </text> 
 */

package basic;

import GUI.TreeviewUtils;
import definitions.Messages;
import script.Plugin;
import script.log;

/**
 *
 * @author Nuno Brito, 15th of December 2013 in Darsmtadt, Germany
 */
public class TreeNodeDetails extends Plugin{

    
    @Override
    public void startup(){
        // react whenever a tree node is changed
        log.hooks.addAction(Messages.TreeNodeChanged, thisFile, "react");
    }
    

    
    /**
     * List all files for the treeview exploration
     */
    void react(){
        try{
        
            TreeviewUtils.react();
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   
    
    /**
     * Returns the parent path (if available)
     */
    private String getParentFolder(String path){
        // we need to count the number of slashes
        int lengthOriginal = path.length();
        String temp = path.replace("/", "");
        // do we have at least two slashes?
        if(lengthOriginal > (temp.length() + 1)){
            // get everything up to last slash
            return path.substring(0, path.lastIndexOf("/"));
        }
        // we have nothing, return the root folder
        return "./";
    }
    
    
    
  
    
   
    
}
