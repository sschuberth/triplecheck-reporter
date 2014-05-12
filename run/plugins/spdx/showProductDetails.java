/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: showProductDetails.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> When the user clicks on tree node that belongs to a 
 * product, show either the SPDX content or a summary with the highlights
 * </text> 
 */

package spdx;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import experiment.SPDXfile2;
import java.util.ArrayList;
import main.core;
import script.Plugin;
import script.log;
import utils.html;
import www.Table;


/**
 *
 * @author Nuno Brito, 10th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class showProductDetails extends Plugin{
    
    // node currently selected on the tree, we use this object across the script
    private TreeNodeSPDX node;

    @Override
    public void startup(){
        // react whenever a tree node is changed
        log.hooks.addAction(Messages.TreeNodeChanged, thisFile, "processNode");
    }
    
    /**
     * This is the method that proceed with the initial filtering. This is 
     * important to decide if we should continue or not
     */
    void processNode(){
        // ensure we get to know which node is selected
        node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            return;
        }
        // now we want to know if this is either:
        // a) a root node called "Reports"
        // b) a components inside one of the nodes from a)
        
        String nodeUID = node.getUID();
        
        // are we clicking on the root of packages?
//        if(nodeUID.equals(">> Products ")){
//            showPackageRoot("Products ", core.reports.list);
//            return;
//        }
//        // do the same, this time for libraries
//        if(nodeUID.equals(">> Library ")){
//            showPackageRoot("Library ",core.components);
//            return;
//        }
        
        // process files
//        if(node.nodeType == NodeType.sectionPackage){
//            showPackageDetails(node);
//        }
    }

//    /**
//     * Shows a summary of details about the selected package
//     */
//    private void showPackageRoot(String title, ArrayList list) {
//        int 
//                counterFiles = 0,
//                counterCreators = 0,
//                counterLicensesDeclared = 0
//                ;
//        
//        // pre-flight check
//        if(list.isEmpty()){
//            core.studio.editorPane(is.contentHTML, false, 0, "");
//            return;
//        }
//        
//        // get some statistical data
//        for(Object object : list){
//            SPDXfile2 spdx = (SPDXfile2) object;
//            counterFiles += spdx.getFiles().size();
//            counterCreators += spdx.creatorSection.people.size();
//            counterLicensesDeclared += spdx.getStatsLicensesDeclared();
//        }
//        
//        // calculate percentage of files with a trigger declared
//        String percentage = 
//                  " ("
//                + (counterLicensesDeclared * 100)/counterFiles
//                + "% in total)" + html.br; 
//                
//        
//        String result = 
//                html.div()
//                + "<h2>"
//                + html.getCommonFolderIcon("wooden-box-label.png")
//                + title
//                + "</h2>"
//                + html._div
//                + html.div(20)
//                + html.getCommonFolderIcon("documents-stack.png")
//                + counterFiles + " files in total" 
//                + html.br
//                + html.getCommonFolderIcon("calculator.png")
//                + counterLicensesDeclared + " files with declared licenses" 
//                + percentage
//                + html.getCommonFolderIcon("stickman.png")
//                + counterCreators + " SPDX creators" + html.br
//                //+ html.br
//                + html._div
//                + html.br
//                + "";
//        
//        // write everything on our UI text area
//        core.studio.editorPane(is.contentHTML, false, 0, result);
//    }

  
   
//    /**
//     * Show the details of the selected package
//     * @param node 
//     */
//    private void showPackageDetails(TreeNodeSPDX node) {
//        // get the SPDX file from the root node
//        SPDXfile spdx = (SPDXfile) node.getUserObject();
//        // place this node on our temp queue, useful for links used from here
//        core.temp.put("showPackageDetails", node);
//        int counterLicensesDeclared = spdx.getStatsLicensesDeclared();
//        int counterFiles = spdx.fileSection.files.size();
//            
//        // calculate percentage of files with a trigger declared
//        String percentage = 
//                  " ("
//                + (counterLicensesDeclared * 100)/counterFiles
//                + "% in total)" + html.br; 
//        
//        String searchEngines = 
//                html.div(30)
//                + html.linkToSearchGoogle(node.id)
////                + html.divider
////                + html.linkToSearchAntepedia(node.id)
//                + html.divider
//                + html.linkToSearchGitHub(node.id)
//                + html._div
//                ;
//        
//        String evaluation = doEvaluation(spdx);
//        
//        // prepare the answer
//        String result = 
//                swingUtils.getBreadcrumb(node)
//                + html.div(20)
//                + html.getCommonFolderIcon("documents-stack.png")
//                + counterFiles + " files inside the package" 
//                + html.br
//                + html.getCommonFolderIcon("calculator.png")
//                + counterLicensesDeclared + " files with declared licenses" 
//                + percentage
//                + evaluation
//                + html._div
//                
//                
//                + html.div()
//                + html.br
//                + swingUtils.addIfNotEmpty(
//                        html.getCommonFolderIcon("magnifier-zoom-fit.png")
//                        + "Look for \""
//                        + node.id
//                        +"\" around the web"
//                        , searchEngines)
//                + html._div
//                
//                + html.div()
//                + "<b>" + "Other actions" + "</b>" + html.br
//                + html._div
//                + html.div(20)
//                + html.getCommonFolderIcon("receipt--pencil.png")
//                + html.linkScript("See the full text of this SPDX document"
//                    , thisFile, "showSPDX")
//                + html._div
//                + html.br
//                //+ html.br
//                
//                + html.div()
//                + "<b>" + "List files" + "</b>" + html.br
//                + html._div
//                + html.div(20)
//                + html.getCommonFolderIcon("folder-smiley-sad.png")
//                + html.linkScript("Without a license", thisFile, "showFilesWithoutLicense")
//                + html.br
//                + html.getCommonFolderIcon("folder-smiley.png")
//                + html.linkScript("With a license reported", thisFile, "showFilesWithLicense")
//                + html._div
//                + "";
//        
//        // write everything on our UI text area
//        core.studio.editorPane(is.contentHTML, false, 0, result);
//    }
//    
    
       
//    /**
//     * This operation might take a while, so we first launch a menu asking
//     * people to wait for a while and then launch a thread with the results
//     */
//    void showFilesWithoutLicense(){
//        String inProgress = ""
//                    + html.div()
//                    + "<h2>"
//                    + html.getCommonFolderIcon("wand.png")
//                    + "In progress!</h2>"
//                    + ""
//                    + "We are creating a list, please wait.."
//                    + html.br
//                    + html._div;
//            // update the text box
//            core.studio.editorPane(is.contentHTML, false, 0, inProgress);
//            Thread thread = new Thread(){
//                @Override
//                public void run(){
//                    processFilesWithoutLicense();
//                    }
//                };
//                thread.start();
//    }
//    
//    /**
//     * This operation might take a while, so we first launch a menu asking
//     * people to wait for a while and then launch a thread with the results
//     */
//    void showFilesWithLicense(){
//        String inProgress = ""
//                    + html.div()
//                    + "<h2>"
//                    + html.getCommonFolderIcon("wand.png")
//                    + "In progress!</h2>"
//                    + ""
//                    + "We are creating a list, please wait.."
//                    + html.br
//                    + html._div;
//            // update the text box
//            core.studio.editorPane(is.contentHTML, false, 0, inProgress);
//            Thread thread = new Thread(){
//                @Override
//                public void run(){
//                    processFilesWithLicense();
//                    }
//                };
//                thread.start();
//    }
    
    
 
    
//    /**
//     * Shows a list of files for the selected package that do not have a trigger
//     */
//    void processFilesWithoutLicense(){
//        
//        //node = swingUtils.getSelectedNode();
//        node = (TreeNodeSPDX) core.temp.get("showPackageDetails");
//        // no need to continue if there is nothing selected
//        if(node == null){
//            return;
//        }
//        // get the SPDX file from the root node
//        SPDXfile spdx = (SPDXfile) node.getUserObject();
//        
//        // create the HTML data where our info will be placed
//        String[] columns = new String[]{"File name", "Path", ""};
//        Table table = new Table(columns);
//        
//        
//        // iterate through all files
//        for(FileInfo file : spdx.fileSection.files){
//
//            // if there is a trigger, no need to continue
//            if(file.countLicensesDeclared()>0){
//                continue;
//            }
//            
//            // create a column with our file information
//            String[] column = new String[]{
//                utils.text.shortText(file.toString(), 25),
//                utils.text.shortText(file.tagFilePath.toString(), 30),
//                //file.tagFilePath.toString(),
//                html.linkNode("details",  ">> "
//                    + file.tagFileName.toString()
//                    + " >> Files >> "
//                    + node.id
//                    + " >> Products ")
//            };
//            table.add(column);
//        }
//                
//        // do the output that is displayed to the end-user
//        String result = swingUtils.getBreadcrumb(node)
//                + html.div(20)
//                + table.output()
//                + html._div
//                ;
//        
//        // write everything on our UI text area
//        core.studio.editorPane(is.contentHTML, false, 0, result, false, null);
//    }
//    
//    /**
//     * Shows a list of files for the selected package that do not have a trigger
//     */
//    void processFilesWithLicense(){
//        
//        //node = swingUtils.getSelectedNode();
//        node = (TreeNodeSPDX) core.temp.get("showPackageDetails");
//        // no need to continue if there is nothing selected
//        if(node == null){
//            return;
//        }
//        // get the SPDX file from the root node
//        SPDXfile spdx = (SPDXfile) node.getUserObject();
//        
//        // create the HTML data where our info will be placed
//        String[] columns = new String[]{"File name", "Path", ""};
//        Table table = new Table(columns);
//        
//        
//        // iterate through all files
//        for(FileInfo file : spdx.fileSection.files){
//
//            // if there is a trigger, no need to continue
//            if(file.countLicensesDeclared() == 0){
//                continue;
//            }
//            
//            // create a column with our file information
//            String[] column = new String[]{
//                utils.text.shortText(file.toString(), 25),
//                utils.text.shortText(file.tagFilePath.toString(), 30),
//                //file.tagFilePath.toString(),
//                html.linkNode("details",  ">> "
//                    + file.tagFileName.toString()
//                    + " >> Files >> "
//                    + node.id
//                    + " >> Products ")
//            };
//            table.add(column);
//        }
//                
//        // do the output that is displayed to the end-user
//        String result = swingUtils.getBreadcrumb(node)
//                + html.div(20)
//                + table.output()
//                + html._div
//                ;
//        
//        // write everything on our UI text area
//        core.studio.editorPane(is.contentHTML, false, 0, result, false, null);
//    }
//    
    
//     /**
//     * Show the SPDX document on the text area
//     */
//    public void showSPDX(){
//        node = swingUtils.getSelectedNode();
//        // no need to continue if there is nothing selected
//        if(node == null){
//            return;
//        }
//        // get the SPDX file from the root node
//        SPDXfile spdx = (SPDXfile) node.getUserObject();
//        
//        
//        // write everything on our UI text area
//        String content = spdx.rawText;
//        core.studio.editorPane(is.contentText, true, 0, content);
//    }
//
// 
//    
////    /**
////     * When given a SPDX object, provide some statistics
////     * about the number of triggers that are not declared
////     */
////    int doStatistics(SPDXfile spdx){
////        int counterLicensesDeclared = 0;
////        // get the number of triggers declared
////            for(Object fileObject : spdx.fileSection.files){
////                FileInfo file = (FileInfo) fileObject;
////                // go deep into the trigger information
////                if(file.countLicensesDeclared()>0){
////                    counterLicensesDeclared++;
////                }
////            }
////            return counterLicensesDeclared;
////    }
//
//    /**
//     * Create a list with all the files inside this SPDX document
//     * @return 
//     */
//    private String doFileSummary(SPDXfile spdx) {
//        String result = html.br;
//        
//        for(FileInfo file : spdx.fileSection.files){
//            result = result.concat( 
//                    file.toString()
//                    + html.br
//                    )
//                    ;
//        }
//        
//        
//        return result;
//    }

//    /**
//     * Provides an evaluation if the SPDX file has quality or not
//     * @param spdx an object from where we will read all data
//     * @return A string used for the HTML output
//     */
//    private String doEvaluation(SPDXfile spdx) {
//        String result = "";
//        Boolean hasSVNfiles = false;
//        ArrayList<FileInfo> list = spdx.fileSection.files;
//        for(FileInfo file : list){
//            if(file.tagFileName.toString().contains(".svn")){
//                hasSVNfiles = true;
//                break;
//            }
//        }
//        
//        if(hasSVNfiles){
//            result = html.br
//                    + html.h2(html.getCommonFolderIcon("exclamation.png") + "Defects")
//                    + "Source code has SVN files that should be removed"
//                    + html.br
//                    + html.br
//                    ;
//        }
//        
//        return result;
//    }

}
