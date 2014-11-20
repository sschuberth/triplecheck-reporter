/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-05T18:02:12Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: summary.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Show the list of components inside an SPDX document </text> 
 */

package components;

import GUI.swingUtils;
import definitions.is;
import script.Plugin;
import script.log;
import spdxlib.SPDXfile;
import spdxlib.swing.NodeType;
import spdxlib.swing.TreeNodeSPDX;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 3rd of May 2014 in Darmstadt, Germany
 */
public class summary extends Plugin{
    
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // only accept components nodes
        if(node == null || node.nodeType != NodeType.sectionComponents){
            log.write(is.ERROR, "No component node selected");
            return;
        }
        
        // now that we have the correct node, get the spdx object
        SPDXfile spdx = (SPDXfile) node.getUserObject();
        
        // and now with the spdx summary, get the list of components
        String result = spdx.summary.components();
        
        request.setAnswer(result);       
    }
    
    
  
}
