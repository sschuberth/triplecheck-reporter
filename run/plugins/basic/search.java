/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-04-02T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: search.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The page for finding information </text> 
 */

package basic;

import definitions.Messages;
import definitions.is;
import java.io.File;
import main.core;
import script.Plugin;
import script.RunningTask;
import script.log;
import utils.html;
import www.Table;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 2nd of April 2014 in Darsmtadt, Germany
 */
public class search extends Plugin{
     
    String id = "Search";
    
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        addTreeNode(id, "magnifier-left.png", "main");
    }
    
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       // show up our search page
        File tempFile = new File(thisFolder, "search.html");
        request.setPage(tempFile);
    }

    
}
