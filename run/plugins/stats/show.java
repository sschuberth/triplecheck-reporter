/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-03T09:04:11Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: show.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Provides generic stats for end-users </text> 
 */

package stats;

import definitions.Messages;
import main.core;
import script.Plugin;
import script.log;
import utils.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 16th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class show extends Plugin{
    
   
    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        addTreeNode("Statistics", "medal--plus.png", "main");
        
//        addChildNode("from web", "application-dock-270.png", "mainWeb");
//        addChildNode("from folder", "folder-smiley.png", "mainFolder");
//        addChildNode("batch mode", "blue-document-node.png", "mainBatch");
        
    }
    
    /**
     * Displays the menu for creating new SPDX documents
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        
       String result = core.popularity.getPopularitySummary(); 
       
       // get the summary
       result += core.popularity.getAuthorStatsSummary();
       
       // give a left-side margin on the output
       result = html.div()
               + result
               + html._div;
        
       request.setAnswer(result);
    }


    
}

