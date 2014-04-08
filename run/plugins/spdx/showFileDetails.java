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
import script.FileExtension;
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
        FileInfo fileInfo = (FileInfo) node.getUserObject();
        
        // create the summary for the requested file
        String output = showFileDetails(fileInfo);
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
    private String showFileDetails(FileInfo fileInfo) {
        // where we store the end result
//        FileInfo file = (FileInfo) node.getUserObject();
        
        String googleTerm = "";
        String filename = fileInfo.getName();
        // get the file extension if available
        //String extension = getFileExtension(filename);
            
         SPDXfile spdx = fileInfo.getSPDX();
        
         // where are the source code files located?
         File sourceFolder = spdx.getSourceFolder();
        
//        if(folder == null){
//            System.err.println("No source code folder available");
//        }else{
//            System.out.println(folder.toString());
//        }
        
        
        
        try{
            // get the package name to narrow down the results
//            TreeNodeSPDX parent = (TreeNodeSPDX) node.getParent();
//            TreeNodeSPDX root = (TreeNodeSPDX) parent.getParent();
            
            // we need to remove misleading terms from the filename
            String filteredName = fileInfo.getName();
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
        

        // add a short summary about the file
        String summary = "";
        
        
       
        // this is later used for fetching online information about extension  
        String lookForExtensionInfo = "";
        
        FileExtension extension = fileInfo.getExtension();
        
        if(extension != null){
             // add the part that permits online searches
             lookForExtensionInfo = ""
                        //+ html.br
                        + swingUtils.addIfNotEmpty("Info about file extension \""
                            + extension.getIdentifierShort()
                            + "\"",
                            html.div() 
                            + html.linkToSearchFileExtension
                            (extension.getIdentifierShort())
                            + html._div
                     );
        
            
            if(extension.getDescription()!=null){
                summary += extension.getDescription();
            }else{
                summary += ""
                        + extension.getCategory().toStringCapitalLetter()
                        + " file";
            }
        }
        //summary += html.br;
        
         if(fileInfo.tagFileSize != null){
            summary += ", sized in " + fileInfo.tagFileSize.toString();
        }
         if(fileInfo.tagFileLOC != null){
            summary += " with " + fileInfo.tagFileLOC + " lines of code"; 
                    
        }
        
        summary += html.br;
        
        // remove the comma and space when there is no extension
        if(fileInfo.getExtension() == null){
            summary = "S" + summary.substring(3);
        }
        
        if(fileInfo.countLicensesDeclared()>0){
            summary += 
                     html.br 
                    + "Applicable license(s): " + fileInfo.getLicense();
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
                        + html.linkToSearchGitHub(fileInfo.tagFileName.toString())
                        + html._div;
        
        String resultSHA1 = "";
        if(fileInfo.tagFileChecksumSHA1!= null){
            resultSHA1 = fileInfo.tagFileChecksumSHA1.toString()
                        + html.br
                        + html.div()
                        + html.linkSearch("Find duplicates", "SHA1: "
                            + fileInfo.tagFileChecksumSHA1.toString())
                        + html.divider
                        + html.linkToSearchGoogle(
                            "%22"+ fileInfo.tagFileChecksumSHA1.toString() + "%22" )
                        + html._div;
        }
        
        String resultSHA256 = "";
        if(fileInfo.tagFileChecksumSHA256!= null){
            resultSHA256 = fileInfo.tagFileChecksumSHA256.toString()
                        + html.div()
                        // only possible when we have SHA256 hashes available
                        + html.linkToSearchMetaScan(fileInfo.tagFileChecksumSHA256.toString())
                        + html.divider
                        + html.linkToSearchVirusTotal(fileInfo.tagFileChecksumSHA256.toString())
                        + html._div;
        }
        
      String resultMD5 = "";
        if(fileInfo.tagFileChecksumMD5!= null){
            resultMD5 = fileInfo.tagFileChecksumMD5.toString()
                        + html.div()
                        // We might be lucky and find an MD5 with info
                        + html.linkToSearchGoogle(
                            "%22"+ fileInfo.tagFileChecksumMD5.toString() + "%22" )
                        + html._div;
        }
        
      
        String resultSSDEEP = "";
        if(fileInfo.tagFileChecksumSSDEEP!= null){
            String text = fileInfo.tagFileChecksumSSDEEP.raw;
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
                    + sourceCodeActions(fileInfo, sourceFolder)
                    + html.br
                    + html.br
                    + swingUtils.addIfNotEmpty("SHA1", resultSHA1)
                    + swingUtils.addIfNotEmpty("SHA256", resultSHA256)
                    + swingUtils.addIfNotEmpty("MD5",resultMD5)
                    //+ html.br
                    + swingUtils.addIfNotEmpty("SSDEEP", resultSSDEEP)
                    //+ html.br
                    + swingUtils.addIfNotEmpty("Look for \""
                        +filename
                        +"\""
                        , resultFilename)
                    + lookForExtensionInfo
                    + html._div
                    + html.br
                    + html.br
                      
//                    + swingUtils.addIfNotEmpty("Copyright text",file.tagFileCopyrightText.toString())
                    ;
        
       /** missing to add:
        * - File path
        * - Applicable licenses (when available)
        */
        return result;
    }

    /**
     * These are actions that are only possible when we have access to the
     * folder where the source code of the SPDX report
     * @param fileInfo  The object containing the reference information 
     */
    private String sourceCodeActions(FileInfo fileInfo, File folder){
        String result;
        
        // first step, do we have a source code for this file?
        if(folder == null){
            // nothing, let's go back empty handed
            return "";
        }
        
        // what is the relative path?
        String relativePath = fileInfo.getRelativeLocation();
        // get our target file
        File targetFile = new File(folder, relativePath);
        // doesn't exist? No need to continue
        if(targetFile.exists() == false){
            return "";
        }
        
        String URL = "/spdx/actions";
        String parameters = "?file=" + targetFile.getAbsolutePath();
        String folderText = "?x=folder&target=" + targetFile.getParentFile().getAbsolutePath(); 
        
        result = ""
                + html.br
                + html.div()
                + html.link("View", URL + parameters)
                + html.divider
                + html.link("Open folder", URL + folderText)
                + html._div
                ;
        
        return result;
    }
    
    
}
