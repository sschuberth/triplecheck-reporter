/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2014-06-08T18:02:12Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: export.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Exports the SPDX document to a given format </text> 
 */

package components;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import definitions.is;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.core;
import org.apache.commons.io.FileUtils;
import script.Plugin;
import script.log;
import spdxlib.SPDXfile2;
import utils.html;
import www.RequestOrigin;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 8th of June 2014 in Darmstadt, Germany
 */
public class export extends Plugin{
    
    String redirect = html.redirect("/components/export", 0, " Returning..");
    /**
     * Display the current list of tasks
     * @param request the request for this method
     */
    @Override
    public void main(WebRequest request){
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // only accept components nodes
        if(node == null || node.nodeType != NodeType.sectionExport){
            log.write(is.ERROR, "EX40 - Export node was not selected.");
            return;
        }
        
        String export = "\"export\"";
        
        // add a link on the export link if the host is windows
        if(utils.misc.isWindows()){
             export = html.link("export", "?x=folder&folder="
                     + core.getFolderExport());
        }
        
        // and now with the spdx summary, get the list of components
        String result = ""
                + html.div()
                + html.h2("Export the licensing data")
                + "Use this menu to export the documentation and files of this"
                + " project. The exported data can be found inside the "
                + export
                + " folder."
                + html.br
                + html.br
                + html.div()
                + html.link("Report", "?x=export&type=report")
                + html.br
                + html.br
                + html.link("Files", "?x=export&type=files")
                + html._div
                + ""
                + html._div;
        
        request.setAnswer(result);       
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
        
        String paramString = request.getParameter("folder");
        File folder = new File(paramString);
        try {
                Desktop.getDesktop().open(folder);
        } catch (IOException ex) {
            log.write(is.ERROR, "EX106 Exception: " + ex.getMessage());
        }
        
        // all done, let's go back
        request.setAnswer(redirect);
    }
 
     /**
     * Performs the requested export
     * @param request 
     */
    public void export(WebRequest request){
        log.write(is.INFO, "Exporting documentation");
        // now that we have the correct node, get the spdx object
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        SPDXfile2 spdx = (SPDXfile2) node.getUserObject();
        // now create the folders related to what was requested
        String whatWasAsked = request.getParameter("type");
        // avoid mal-formed requests
        if(whatWasAsked == null){
            request.setAnswer(redirect);
        }else
        if(whatWasAsked.equals("report")){
            request.setAnswer(doReport(spdx));
        }else
        if(whatWasAsked.equals("files")){
            request.setAnswer(doReport(spdx));
        }
    }

    /**
     * Create the report for this SPDX project
     * @param spdx
     * @return 
     */
    private String doReport(SPDXfile2 spdx) {
        String result = "Report written!";
        // start by creating our export directory
        File folderExport = new File(core.getFolderExport(), spdx.getId());
        // if the folder doesn't exist, create one
        utils.files.mkdirs(folderExport);
        // now create the report folder
        File folderReport = new File(folderExport, "report");
        // create this folder if it doesn't exist already
        utils.files.mkdirs(folderReport);
        
        // get the component report
        String reportComponents = spdx.summary.components();
        // save it to disk
        File fileComponents = new File(folderReport, "components.html");
        utils.files.SaveStringToFile(fileComponents, reportComponents);
        // make a copy of the SPDX document to this folder too
        File fileSPDX = new File(folderReport, "files.spdx");
        try {
            // copy the file to "files.spdx"
            FileUtils.copyFile(spdx.file, fileSPDX);
       
            // all seems done, now create the zipped archive with all files inside
            File fileZip = new File(folderExport, "report.zip");
            ThirdParty.zip.createZip(folderReport, fileZip);
        
        } catch (IOException ex) {
            Logger.getLogger(export.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        return result;
    }
    
    
}
