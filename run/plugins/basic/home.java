/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-01-16T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: frontPage.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the front page when the program starts </text> 
 */

package basic;

import GUI.TreeNodeSPDX;
import GUI.TreeviewUtils;
import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import main.controller;
import script.Plugin;
import script.log;
import utils.html;
import www.RequestOrigin;
import www.Table;
import www.WebRequest;



/**
 *
 * @author Nuno Brito, 21st of December 2013 in Darmstadt, Germany
 */
public class home extends Plugin{

    @Override
    public void startup(){
        // add our node to the tree right after the "Tools" node is added
        log.hooks.addAction(Messages.CallFrontScreen, thisFile, "doScreen");
    }
    

    
    void doScreen(){
       WebRequest request = new WebRequest();
            // signal that this request is coming from the user interface
            request.requestOrigin = RequestOrigin.GUI;
            request.BaseFolder = thisFile.getParentFile();
            request.scriptFile = thisFile;
            request.scriptMethod = is.methodDefault;
            // submit the request to be executed
            controller.process(request); 
    }
    
    
    /**
     * A wrapper for the doScreen method when requested from the web
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        
        String navigationMain = ""
                + html.div()
                + html.link("Create a new report", "/spdx/create?x=mainFolder")
                //+ html.link("Create new report", "/spdx/create")
                + html._div
                + "";
        
                String navigationSub = ""
//                + html.h2("Actions")
//                + html.br
                //+ html.br        
                + html.div()
                + "Other actions: "   
                + html.link("Ask a question", "http://triplecheck.de/forum")
                + html.divider
                + html.link("View reports", "/spdx/show")        
                + html.divider
                + html.link("Log", "/basic/ToolsLog.java?x=showPage")
                + html.divider
                + html.link("Status", "/basic/status")
//                + html.divider
//                + html.link("Server", "/webserver/server")
                + html._div
                + html.br
//                + html.br
//                + html.br
                + "";
        
        
        // get twitter new if available
        String timeLine = html.getRSS("http://triplecheck.de/feed");
        
        
        String[] params = new String[]{
            html.getIcon("logo.png", request)
                , navigationMain
        };
        
        int[] size = new int[]{60, 250};
        
        String quickHelp = ""//html.br
                + "<div style=\"text-align: right;\">Don't know how to start?\n" +
                "Watch our <a href=\"https://www.youtube.com/watch?v=nljP6hC8xbc\" target=\"_blank\">quick\n" +
                "guide</a>&nbsp&nbsp</div>"
                ;
        
        
        // only show the time line title when there is something to show
        if(timeLine.isEmpty() == false){
            timeLine = 
                    html.h3("Recent news")
                    + timeLine;
        }
        
        String result = ""
                + html.div()
                + html.br
                + Table.alignedTable(params, size)
                //+ navigation
                + html.br
                + quickHelp
                + "<hr>"
                + html.br
                + navigationSub
                + timeLine
                
                + html._div
                ;
        
        // expand the first treeview node by default
        try{
        //String showProducts = (String) core.temp.get(is.reports);
        TreeNodeSPDX nodeReports = TreeviewUtils.getNodeReports();
        if(nodeReports != null){
              swingUtils.setSelectedNode(nodeReports.getUID());
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        request.setAnswer(result);
    }
    
    
    
}


