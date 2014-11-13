/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-02T08:53:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: settings.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Shows details about the settings of a project </text> 
 */

package spdx;

import GUI.swingUtils;
import definitions.is;
import java.io.File;
import main.coreGUI;
import main.engine;
import script.Plugin;
import spdxlib.SPDXfile2;
import spdxlib.swing.TreeNodeSPDX;
import utils.www.html;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 2nd of May 2014 in Darsmtadt, Germany
 */
public class settings extends Plugin{
     
    final String templateFolderHTML = "spdxSettings.html";
    
    /**
     * Display the current settings
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
       // we only expect to be called from the treeview
//       if(request.requestOrigin != RequestOrigin.GUI_tree
//               && request.requestOrigin != RequestOrigin.GUI){
//           return;
//       }
       
       // get the toggle value
       final String toggleValue = settings.read(coreGUI.toggleScore, "-1");
       final int value = Integer.parseInt(toggleValue);
       // where we create the link
       String link;
       String auditMode;
       String linkText = "change";
       if(value == 1){
           link = utils.www.html.link(linkText, "settings.java?x=toggle&value=0");
           auditMode = "ON";
       }else{
            link = utils.www.html.link(linkText, "settings.java?x=toggle&value=1");
            auditMode = "OFF";
       }
       
       // load our template
       request.setTemplate(templateFolderHTML);
       // add the value of our directory
       request.changeTemplate("none-template", getFolderString());
       // 
       request.changeTemplate("%auditMode%", auditMode);
       request.changeTemplate("%toggle%", link);
       
       // all done
       request.closeTemplate();
    }

    /**
     * Toggle on/off for the audit mode in the scoring mechanism
     * @param request 
     */
    public void toggle(WebRequest request){
        final String param = request.getParameter("value");
        // write back this value on our settings
        settings.write(coreGUI.toggleScore, param);
        main(request);
        
    }
    
    /**
     * Provides back the string for the folder where the source code files
     * are located (if any), or returns empty if nothing exists
     * @return  The path to the source code files on disk
     */
    private String getFolderString(){
       // get the SPDX node
       TreeNodeSPDX node = (TreeNodeSPDX) swingUtils.getSelectedNode();
       SPDXfile2 spdx = (SPDXfile2) node.getUserObject();
       // get the value used before
       File sourceFolder = spdx.getSourceFolder();
       // if nothing is chosen, just show it as "none"
       String selectedFolder = "";
       if(sourceFolder != null){
           selectedFolder = sourceFolder.getAbsolutePath();
       }
       return selectedFolder;
    }
    
    /**
     * Chooses a folder to be used as source for creating a new SPDX
     * @param request 
     */
    public void folder(WebRequest request){
        // no support for requests from the browser
        if(request.requestOrigin == RequestOrigin.BROWSER){
            request.setAnswer("Not supported from browser");
            return;
        }
        
        // do we want an older location defined?
        String selectedFolder = getFolderString();

        // do we want to use the default location or do we have an older choice?
        File startFolder = engine.getWorkFolder();
        if(selectedFolder != null){
            startFolder = new File(selectedFolder);
        }
        
        // show the dialog
        File result = swingUtils.chooseFolder(startFolder, "");
        
        // get the SPDX node
        TreeNodeSPDX node = (TreeNodeSPDX) swingUtils.getSelectedNode();
        SPDXfile2 spdx = (SPDXfile2) node.getUserObject();
        // now save the new settings
        spdx.setSourceFolder(result);
       
        // all done, let's go back
        String output = html.redirect("/spdx/settings", 0, 
                       " Returning to previous page..");
        request.setAnswer(output);
    }
  
    
}
