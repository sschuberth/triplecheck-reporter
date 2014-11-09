/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-01-16T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * LicenseName: GPL-2.0+
 * FileName: frontPage.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Defines the front page when the program starts </text> 
 */

package basic;

import GUI.TreeviewUtils;
import GUI.swingUtils;
import GUI.webUtils;
import definitions.Messages;
import definitions.is;
import main.controller;
import script.Plugin;
import script.log;
import spdxlib.swing.TreeNodeSPDX;
import utils.www.html;
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
        
        request.setPage("index.html");
        
//        String navigationMain = ""
//                + html.div()
//                + html.link("Create a new report", "/spdx/create?x=mainFolder")
//                + html.divider
//                + html.link("View reports", "/spdx/show")    
//                //+ html.link("Create new report", "/spdx/create")
//                + html._div
//                + "";
//        
////                String navigationSub = ""
//////                + html.h2("Actions")
//////                + html.br
////                //+ html.br        
////                + html.div()
////                + "Other actions: "   
////                //+ html.link("Ask a question", "http://triplecheck.de/forum")
////                + html.divider
////                + html.link("View reports", "/spdx/show")        
////                + html.divider
////                + html.link("Log", "/basic/ToolsLog.java?x=showPage")
////                + html.divider
////                //+ html.link("Status", "/basic/status")
//////                + html.divider
//////                + html.link("Server", "/webserver/server")
////                + html._div
////                + html.br
//////                + html.br
//////                + html.br
////                + "";
//        
//        
////        String[] params = new String[]{
////            webUtils.getIcon("logo.png", request)
////                , navigationMain
////        };
//        
//        int[] size = new int[]{60, 250};
//        
//        String result = ""
//                + html.div()
//                + html.br
////                + Table.alignedTable(params, size)
//                + navigationMain
//                //+ navigation
//                + html.br
//                //+ quickHelp
////                + navigationSub
//                + "<hr style=\"height: 2px; width: 75%;\">"
//                + html.br
//                
//                + html._div
//                ;
//        
       // request.setAnswer(result);
    }
    
    
    
}


