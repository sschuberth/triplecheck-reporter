/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-11-12T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: showFileDetails.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This class displays the details about a given file that
 * has been selected on the treeview or throught some similar manner </text> 
 */

package spdx;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import definitions.Messages;
import definitions.is;
import java.io.File;
import main.core;
import main.param;
import script.Plugin;
import script.log;
import spdxlib.FileInfo;
import spdxlib.SPDXfile;
import spdxlib.tools;
import utils.html;
import www.WebRequest;


/**
 *
 * @author Nuno Brito, 12th of November 2013 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class showFileDetails extends Plugin{
    @Override
    public void startup(){
        // react whenever a tree node is changed
        log.hooks.addAction(Messages.TreeNodeChanged, thisFile, "processFile");
    }
    
    
     /**
     * list some information according to a filter
     * @param request
     */
    public void specific(WebRequest request) {
        // we need the "file" parameter to tell us what to detail
        String spdxTarget = request.getParameter(param.spdx);
        // does this file exists?
        File spdxFile = tools.getFile(spdxTarget, request);
        if(spdxFile == null){
            return;
        }
        // get what we want to show
        String targetFile = request.getParameter(param.file);
        // value can't be empty
        if(targetFile == null){
            request.setAnswer("No filter specified");
            return;
        }
        // start the processing
        SPDXfile spdx = new SPDXfile(spdxFile);
        // go through all files inside the document
        for(FileInfo file : spdx.fileSection.files){
            // have we (finally) found a match?
            if(targetFile.equals(file.getName())){
                String result = showFileDetails(file);
                request.setAnswer(result);
                return;
            }
        }
        request.setAnswer("Didn't found " + targetFile);
    }
    
    /**
     * Checks if the node of a file has been selected. If this is the case then
     * show as much details as possible about the file
     */
    void processFile(){
        // ensure we get to know which node is selected
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            return;
        }
        
        // process files
        if(node.nodeType != NodeType.file){
            return;
        }

        // we're talking about tree nodes, get the respective information
        FileInfo file = (FileInfo) node.getUserObject();
        
        // create the summary for the requested file
        String output = showFileDetails(file);
        // this only applies to calls from the treeview
        core.studio.editorPane(is.contentHTML, Boolean.FALSE, 0, output);
        
    }

    
    
    /**
     * Tries to discover the file extension based on the SPDX file name
     * @return 
     */
    String getFileExtension(String filename){
        // preflight checks
        if(filename.contains(".")==false){
            return "";
        }
        if(filename.contains("/")){
            return "";
        }
                
        int pos = filename.lastIndexOf(".");
        String extension = "filetype:" + filename.substring(pos+1);
        return extension;
    }
    
    /**
     * Do the actual part of showing the details for this file
     * @param node 
     */
    private String showFileDetails(FileInfo file) {
        // where we store the end result
//        FileInfo file = (FileInfo) node.getUserObject();
        
        String googleTerm = "";
        String filename = file.getName();
        // get the file extension if available
        //String extension = getFileExtension(filename);
            
        try{
            // get the package name to narrow down the results
//            TreeNodeSPDX parent = (TreeNodeSPDX) node.getParent();
//            TreeNodeSPDX root = (TreeNodeSPDX) parent.getParent();
            
            // we need to remove misleading terms from the filename
            String filteredName = file.getName();
                   // root.id.toLowerCase();
            
                filteredName = filteredName.replace(".tar.gz", "");
                filteredName = filteredName.replace(".zip", "");
                filteredName = filteredName.replace(".jar", "");
                filteredName = filteredName.replace(".7z", "");
                filteredName = filteredName.replace(".tar", "");
                filteredName = filteredName.replace(".bz2", "");
            
            // build up our google query
            googleTerm =  filteredName
                            +  " %22"
                            + filename
                            + "%22 "
                            //+ extension
                            ;        
        
        } catch (Exception e){
            log.write(is.ERROR, "SFD01 - Error occurred when trying to build"
                    + " a search keyword for google");
        }
        
        // do the introduction of this file with a breadcrumb
//        String[] fields = node.getUID().split(">>");
//        String breadCrumb = 
//                  fields[4]
//                + ">"
//                + fields[3]
//                + ">"
//                + fields[1]
//                ;
        // add a short summary about the file
        String summary = "";
        if(file.tagFileSize != null){
            summary += "This file is sized in " + file.tagFileSize.toString();
        }
        if(file.tagFileLOC != null){
            summary += " with " + file.tagFileLOC + " lines of code" 
                    ;
        }
        
        if(file.countLicensesDeclared()>0){
            summary += 
                    html.br 
                    + html.br 
                    + "Applicable license(s): " + file.getLicense();
        }
        
        // do the date creation
        //TODO We need to archive file date information
        //summary += "Created in " + file.;
        
        
        String resultIntroduction = ""
                + "<h2>"
                + filename
//                + breadCrumb
                + "</h2>"
                + html.div()
                + summary
                + html._div
               // + html.br
                ;
        
        // Add links to find more info on the Internet about the file name
        String resultFilename = 
                          html.div()
                        + html.linkToSearchYandex("\"" + filename + "\"")
                        + html.divider
                        + html.linkToSearchGoogle(googleTerm)
//                        + html.divider
//                        + html.linkToSearchOhloh(file.tagFileName.toString())
                        + html.divider
                        + html.linkToSearchGitHub(file.tagFileName.toString())
                        + html._div;
        
        String resultSHA1 = "";
        if(file.tagFileChecksumSHA1!= null){
            resultSHA1 = file.tagFileChecksumSHA1.toString()
                        + html.br
                        + html.div()
                        + html.linkSearch("Find duplicates", "SHA1: "
                            + file.tagFileChecksumSHA1.toString())
                        + html.divider
                        + html.linkToSearchGoogle(
                            "%22"+ file.tagFileChecksumSHA1.toString() + "%22" )
                        + html._div;
        }
        
        String resultSHA256 = "";
        if(file.tagFileChecksumSHA256!= null){
            resultSHA256 = file.tagFileChecksumSHA256.toString()
                        + html.div()
                        // only possible when we have SHA256 hashes available
                        + html.linkToSearchMetaScan(file.tagFileChecksumSHA256.toString())
                        + ""
                        + html._div;
        }
        
      String resultMD5 = "";
        if(file.tagFileChecksumMD5!= null){
            resultMD5 = file.tagFileChecksumMD5.toString()
                        + html.div()
                        // We might be lucky and find an MD5 with info
                        + html.linkToSearchGoogle(
                            "%22"+ file.tagFileChecksumMD5.toString() + "%22" )
                        + html._div;
        }
        
      
        String resultSSDEEP = "";
        if(file.tagFileChecksumSSDEEP!= null){
            String text = file.tagFileChecksumSSDEEP.raw;
            // remove the tag header
            text = text.replace("FileChecksum: SSDEEP: ", "");
            
            resultSSDEEP = text
                        + html.div()
                        // only possible when we have SHA256 hashes available
                        + html.linkSearch("Find similar files", "SSDEEP: "
                            + text)
                        //+ html.link("Find similar files111", text)    
                        + html._div;
        }
        
        String result = html.div()
                    + resultIntroduction
                    + html.br
                    + html.br
                    + swingUtils.addIfNotEmpty("SHA1", resultSHA1)
                    + swingUtils.addIfNotEmpty("SHA256", resultSHA256)
                    + swingUtils.addIfNotEmpty("MD5",resultMD5)
                    //+ html.br
                    + swingUtils.addIfNotEmpty("SSDEEP", resultSSDEEP)
                    + html.br
                    + swingUtils.addIfNotEmpty("Look for \""
                        +filename
                        +"\""
                        , resultFilename)
                    + html._div
//                    + swingUtils.addSSDEEP("SSDEEP", file)
//                    + swingUtils.addIfNotEmpty("Copyright text",file.tagFileCopyrightText.toString())
                    ;
        
       /** missing to add:
        * - File path
        * - Applicable licenses (when available)
        */
        return result;
    }

}
