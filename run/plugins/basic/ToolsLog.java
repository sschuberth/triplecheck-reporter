/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-17T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: pluginLog.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Shows to the end-user a log of what is happening </text> 
 */

package basic;

import definitions.Messages;
import main.coreGUI;
import script.Plugin;
import script.log;
import utils.www.html;
import www.RequestOrigin;
import www.WebRequest;



/**
 *
 * @author Nuno Brito, 17th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class ToolsLog extends Plugin{

    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.AddingTools, thisFile, "addNode");
    }
    
    /**
     * Add our toolbox node to the treeview.
     */
    public void addNode(){
        addTreeNode("Log", "book-open-text.png", "showPage");
    }
    
    /**
     * Displays a basic log of what has been happening
     * @param request The request from the end-user
     */
    public void showPage(WebRequest request){ 
       // get all the messages since the beginning
       String result = log.getMessagesSince(0);
       // replace the break lines with an HTML break line
       result = "<html><body>" 
               + result.replace("\n", html.br)
               + "</body></html>";
       // write everything for the user to read
       request.setAnswer(result);
       
       // move down to the bottom of the log window when looking through the GUI
       if((request.requestOrigin == RequestOrigin.GUI)
               ||(request.requestOrigin == RequestOrigin.GUI_tree)){
           coreGUI.studio.textMoveToBottom();
       }
    }

}
