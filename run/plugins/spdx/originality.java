/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2015-02-16T23:26:01Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileCopyrightText: <text> Copyright (c) 2015 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Evaluate the originality of a project. </text> 
 */

package spdx;

import GUI.swingUtils;
import java.io.File;
import main.engine;
import script.Plugin;
import spdxlib.SPDXfile;
import spdxlib.swing.TreeNodeSPDX;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 2nd of April 2014 in Darmstadt, Germany
 */
public class originality extends Plugin{
     
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       // get the SPDX node
       TreeNodeSPDX node = (TreeNodeSPDX) swingUtils.getSelectedNode().getParent();
       File spdxFile = (File) node.getUserObject();
       SPDXfile spdx = engine.reports.get(spdxFile);
       // get the summary of authorship out of this spdx object
       request.setAnswer(spdx.getId());
    }

    
}
