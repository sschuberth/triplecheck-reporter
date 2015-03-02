/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-11T10:18:12Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: refresh.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Synchronise the contents of a SPDX document with the
 * respective source code on disk. </text>
 */

package spdx;

import GUI.swingUtils;
import definitions.is;
import script.Plugin;
import main.script.log;
import spdxlib.SPDXfile;
import spdxlib.swing.NodeType;
import spdxlib.swing.TreeNodeSPDX;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 11th of June 2014 in Darmstadt, Germany
 */
public class refresh extends Plugin{
    
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // only accept components nodes
        if(node == null || node.nodeType != NodeType.sectionSettings){
            log.write(is.ERROR, "No settings node selected");
            return;
        }
        
        // now that we have the correct node, get the spdx object
        SPDXfile spdx = (SPDXfile) node.getUserObject();
        
        // and now with the spdx refresh, get the list of components
        String result = "RE49 - Not yet implemented";
        
        request.setAnswer(result);       
    }
  
}
