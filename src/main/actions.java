/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-13T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: actions.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A simple static class to provide default actions 
 * related to SPDX handling </text> 
 */

package main;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import static GUI.swingUtils.nodeCreate;
import definitions.definition;
import definitions.folder;
import definitions.is;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import script.log;
import spdxlib.SPDXfile;


public class actions {

    /**
     * This method adds up all the licenses found on the licenses folder
     */
    public static void addLicenses(){
        File folderLicense = new File(core.getWorkFolder(), folder.licenses);
        ArrayList<File> files = utils.files.findFilesFiltered(folderLicense, ".java", 2);
        for(File file : files){
            core.script.runJava(file, null, is.trigger);
        }
        
         // worry about the case when there is no folder nor licenses to include
        if(core.licenses.isEmpty()){
            log.write(is.WARNING, "No licenses were added, "
                    + "license detection is disabled.");
        }
        
    }

    /**
     * Find all files within a given folder, return the respective
     * details such as hashes and other details relevant for SPDX processing
     * @param folder The folder location where we will look for SPDX files
     * @return 
     */
    public static ArrayList<SPDXfile> findSPDX(File folder){
        // only find the SPDX documents with .SPDX extension
        ArrayList<File> files = utils.files.findFilesFiltered(folder, ".spdx", 25);
        ArrayList<SPDXfile> list = new ArrayList();
        try {
            for(File file: files){
            
            String filePath = file.getCanonicalPath();
            // ignore SVN folders of any kind
            if(filePath.contains(".svn")){
                continue;
            }
            SPDXfile spdxFile;
                spdxFile = new SPDXfile(file.getCanonicalFile());
                list.add(spdxFile);
        }
             
            String pathName = folder.getCanonicalPath();
            
            pathName = "." 
                    + pathName.replace(core.getWorkFolder().getCanonicalPath(), "");
           // System.err.println(core.getWorkFolder().getCanonicalPath());
            
            log.write(is.INFO, "Found %1 files in %2", 
                files.size()
                +"", pathName);
                
            } catch (IOException ex) {
                Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-100);
            }
       
        return list;
    }

    
     /**
     * This is a critical method. It will look for all SPDX files inside a given
     * folder and them as tree nodes
     * @param tree 
     */
    public static void addTreeSPDX(JTree tree) {
        // only find the SPDX documents with .SPDX extension
        ArrayList<File> fileList = utils.files
                .findFilesFiltered(core.getProductsFolder(), ".spdx", 25);
        
       
        // get the root node where we have our treeview
        TreeNodeSPDX rootNode = swingUtils.getRootNode(tree);
        
         // create the node for hosting our list of SPDX documents
        TreeNodeSPDX softwareNode = nodeCreate(
                definition.nodeSoftware
                        //+ " (" + fileList.size() + ")"
                , NodeType.other, rootNode);
        // add the identification to this tag
        softwareNode.id = definition.nodeSoftware;
        softwareNode.setIcon("box-label.png");
        
        // set here what we want to happen when the user clicks on it
              File scriptFile = new File(core.getPluginsFolder(), "/basic/home.java");
              softwareNode.scriptFile = scriptFile;
              softwareNode.scriptFolder = scriptFile.getParentFile();
              softwareNode.scriptMethod = "main";
        
        // no need to continue if no SPDX reports were found, just leave here
        if(fileList.isEmpty()){
            return;
        }
    
              
        // create a tree based on folder tree on disk
        findFolders(core.getProductsFolder(), 25, softwareNode);
        
        
        // we use this value for later showing the reports (SPDX) node
        // fully expanded
        core.temp.put(is.products, softwareNode.getUID());
        
       // swingUtils.setSelectedNode(softwareNode.getUID());
    }
    
    /**
     * Find all subfolders in a given folder.
     * @param where A file object of the start folder
     * @param maxDeep How deep is the crawl allowed to proceed
     * @param rootNode
//     * @return An array containing all the found files, returns null if none is
//     * found
     * @return the number of relevant children that should be accounted
     */
     public static int findFolders(File where, int maxDeep
             , TreeNodeSPDX rootNode){

        // get a list of the current files on this folder 
        File[] files = where.listFiles();
       
        // we use this for counting files that were added
        int count = 0;
        
        // go through all the files/folders that were listed
        if(files != null)
        for (File file : files) {
          // only accept folders, ignore files  
          if ( (file.isDirectory())
             &&( maxDeep-1 > 0 ) ){
              String folderName = file.getName();
              // ignore SVN folders
              if(folderName.equals(".svn")){
                  continue;
              }
              // create a new node for the current folder
              TreeNodeSPDX node = new TreeNodeSPDX(folderName);
              node.setIcon("folder-horizontal.png");
              node.setIconWhenSelected("folder-horizontal-open.png");
              node.nodeType = NodeType.folder;
              node.id = folderName;
              // we want to track if something new was added
              int oldCount = count;
              // do the recursive crawling
              count += findFolders(file, maxDeep-1, node);
              // only add this node if we found something interesting there
              if(count > oldCount){
                // add the node as a child of the root node
                rootNode.add(node);
              }
          }
          
          // perhaps we can add this file if it is an SPDX?
          if(file.isFile()){
              String fileName = file.getName();
              // we only want files with an SPDX extension
              if(file.getName().endsWith(".spdx")==false){
                  continue;
              }
              // we don't generic SPDX files here
              if(file.getName().endsWith("-info.spdx")){
                  continue;
              }
              // create the new node
              TreeNodeSPDX node = new TreeNodeSPDX(fileName);
              node.setIcon("box.png");
              node.nodeType = NodeType.SPDX;
              node.id = fileName;
              // set here what we want to happen when the user clicks on it
              File scriptFile = new File(core.getPluginsFolder(), "/spdx/show.java");
              node.scriptFile = scriptFile;
              node.scriptFolder = scriptFile.getParentFile();
              node.scriptMethod = "summary";
              
              // Set as object the file pointer
              node.setUserObject(file);
              // create the correct parameters
              String relativePath = 
                      file.getAbsolutePath().replace(core.getProductsFolder().getAbsolutePath(), "");
              node.scriptParameters.add(new String[]{param.spdx, relativePath});
              // add it up
              rootNode.add(node);
              count++;
          }
          
        }
        //  how many files were found here?
        rootNode.setCounter(count);
        return count;
      }
    
    
}
