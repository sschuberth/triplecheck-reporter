/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-05T18:02:12Z
 * LicenseName: AGPL-3.0+
 * FileName: summary.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Show the list of components inside an SPDX document </text> 
 */

package components;

import GUI.swingUtils;
import definitions.is;
import script.Plugin;
import main.script.log;
import spdxlib.SPDXfile;
import spdxlib.swing.NodeType;
import spdxlib.swing.TreeNodeSPDX;
import utils.www.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public class summary extends Plugin{
    
    final String 
            headerStart = "<br><span style=\"font-family: serif; color: "
            + "rgb(255, 255, 255); background-color: rgb(0, 0, 0); font-size: "
            + "16px; line-height: 33px;\">",
            
            headerEnd = "</span><br>",
            
            descStartBig = "<span style=\"color: rgb(0, 0, 0); background-color:"
            + " rgb(255, 204, 51); font-size: 12px; line-height: 16px; "
            + "font-family: serif;\">",
            
            descStartSmall = "<span style=\"font-family: serif; color: rgb(0, 0, 0); "
            + "background-color: rgb(180, 255, 148); font-size: 12px; "
            + "line-height: 33px;\">",
            descEnd = "</span><br>",
            
            licStart = "<span style=\"font-family: serif; color: rgb(0, 0, 0); "
            + "background-color: rgb(255, 204, 51); font-size: 12px; "
            + "line-height: 33px;\">&nbsp;License&nbsp;</span><span style=\""
            + "font-family: serif; color: rgb(0, 0, 0); background-color: "
            + "rgb(180, 255, 148); font-size: 12px; line-height: 33px;\">&nbsp;",
    
            autStart = "<span style=\"font-family: serif; color: rgb(0, 0, 0); "
            + "background-color: rgb(255, 204, 51); font-size: 12px; "
            + "line-height: 33px;\">&nbsp;Author&nbsp;</span><span style=\""
            + "font-family: serif; color: rgb(0, 0, 0); background-color: "
            + "rgb(180, 255, 148); font-size: 12px; line-height: 33px;\">&nbsp;";
    
    
    
    
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // only accept componentsHTML nodes
        if(node == null || node.nodeType != NodeType.sectionComponents){
            log.write(is.ERROR, "No component node selected");
            return;
        }
        
        // now that we have the correct node, get the spdx object
        SPDXfile spdx = (SPDXfile) node.getUserObject();
        
        request.setTemplate("comp_associated.html");
        
        // and now with the spdx summary, get the list of componentsHTML
        String result = spdx.summary.componentsHTML();
        
        request.changeTemplate("%title%", "Components");
        
        // add the text from the summary computation
        request.changeTemplate("%text%", result);
        
        // add the pretty titles
        request.changeTemplate("<h2>", headerStart);
        request.changeTemplate("</h2>", headerEnd);
        // remove the line headers
        request.changeTemplate(html.line, "");
        
        request.changeTemplate("<description>", descStartBig);
        request.changeTemplate("</description>", descEnd);
        // add the declared license info
        request.changeTemplate("<declaredlicense>", licStart);
        request.changeTemplate("</declaredlicense>", "</span>");
        request.changeTemplate("<mainauthor>", autStart);
        request.changeTemplate("</mainauthor>", descEnd);
        
        request.changeTemplate("Files: ", "");
        request.changeTemplate("File: ", "");
        
        
        request.closeTemplate();
        //request.setAnswer(result);       
    }
    
  
  
}
