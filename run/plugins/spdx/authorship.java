/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-01T23:50:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: authorship.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Shows details about the authorship of a project </text> 
 */

package spdx;

import GUI.swingUtils;
import java.io.File;
import main.engine;
import script.Plugin;
import spdxlib.SPDXfile2;
import spdxlib.swing.TreeNodeSPDX;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 2nd of April 2014 in Darsmtadt, Germany
 */
public class authorship extends Plugin{
     
     
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       // we only expect to be called from the treeview
       if(request.requestOrigin != RequestOrigin.GUI_tree){
           return;
       }
       
       // get the SPDX node
       TreeNodeSPDX node = (TreeNodeSPDX) swingUtils.getSelectedNode().getParent();
       File spdxFile = (File) node.getUserObject();
       SPDXfile2 spdx = engine.reports.get(spdxFile);
       // get the summary of authorship out of this spdx object
       String output = spdx.computeAuthorship();

       // load the template from disk
       request.setTemplate("fileAuthorship.html");
       
       // the replacements
       request.changeTemplate("%original%", spdx.getFilesAuthored() + "");
       request.changeTemplate("%3rdparty%", spdx.getFilesExternal() + "");
       request.changeTemplate("%modded3rdparty%", spdx.getFilesModified() + "");
       request.changeTemplate("%automated%", spdx.getFilesAutomated() + "");
       request.changeTemplate("%automixed%", spdx.getFilesAutomixed() + "");
       request.changeTemplate("%unknown%", spdx.getFilesUnknown() + "");
        
       
       // all done
       request.closeTemplate();
       
    }

    
}
