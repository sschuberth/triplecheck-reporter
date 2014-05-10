/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-08T09:46:54Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: TreeviewUtils.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> A set of actions to make complete use of the
    GUI treeview when applied to our software.</text> 
 */

package GUI;

import static GUI.swingUtils.nodeCreate;
import definitions.Messages;
import definitions.definition;
import definitions.is;
import java.awt.Cursor;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.JTree;
import main.core;
import main.param;
import script.log;
import spdxlib.FileInfo;
import spdxlib.Person;
import spdxlib.SPDXfile;


/**
 *
 * @author Nuno Brito, 10th of April 2014 in Darmstadt, Germany.
 *  nuno.brito@triplecheck.de | http://nunobrito.eu
 */
public class TreeviewUtils {
 
    static TreeNodeSPDX nodeReports;
   
    /**
     * Selects a node from the tree list based on a specific ID string
     * @param UID the specific ID of the node to be selected
     * @return 
     */ 
    public static TreeNodeSPDX getNode(String UID) {
        TreeNodeSPDX rootNode = (TreeNodeSPDX)
                core.studio.getTree().getModel().getRoot();
        Enumeration e = rootNode.preorderEnumeration();
        while(e.hasMoreElements()){
            TreeNodeSPDX currentNode = (TreeNodeSPDX) e.nextElement();
            String thisID = currentNode.getUID();//getId(currentNode);
            if(thisID.equalsIgnoreCase(UID)){
                return currentNode;
            }
        }
        return null;
    }
    
    /**
     * Update the tree node details for a given SPDX object. If the SPDX node
     * does not exist yet then it will be added, otherwise its contents are
     * refreshed.
     * @param UID   Unique identification for this spdx
     * @param file  its location on disk
     */
    public static void spdxAddOrUpdate(String UID, File file) {
       // get the software node
        TreeNodeSPDX node = getNode(UID);
        // does the node already exists?
        if(node != null){
            log.write(is.INSTALLING, "Replacing node");
            spdxReplace(node, true);
            return;
        }
        
        // we now are sure that exists no such SPDX indexed yet 
        log.write(is.INSTALLING, "Adding new SPDX node");
        // add this new SPDX to our list
        SPDXfile spdx = core.reports.add(file);
        // preflight check
        if(spdx == null){
            log.write(is.ERROR, "TU79 - SPDX object is null: %1", 
                    file.getAbsolutePath());
            return;
        }
        // add this node to our list
        TreeNodeSPDX result = spdxAddNode(file, nodeReports);
        spdxCreateNodeStructure(result);
        swingUtils.setSelectedNode(UID);
        log.write(is.COMPLETED, "Added SPDX node: %1", file.getName());
    }

    
    
    /**
     * This method will add a given SPDX node to our treeview and select
     * the new node as default
     * @param UID   Unique identification for this spdx
     * @param file  its location on disk
     */
    private static TreeNodeSPDX spdxAddNode(File file, TreeNodeSPDX rootNode) {
        String fileName = file.getName();
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
        rootNode.add(node);
        // add it up (not working)
        rootNode.update();
        return node;
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
     public static int spdxAddFiles(File where, int maxDeep
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
              count += spdxAddFiles(file, maxDeep-1, node);
              // only add this node if we found something interesting there
              if(count > oldCount){
                // add the node as a child of the root node
                rootNode.add(node);
              }
          }
          
          // perhaps we can add this file if it is an SPDX?
          if(file.isFile()){
              // we only want files with an SPDX extension
              if(file.getName().endsWith(".spdx")==false){
                  continue;
              }
              // we don't generic SPDX files here
              if(file.getName().endsWith("-info.spdx")){
                  continue;
              }
              // add this SPDX to our tree view
              spdxAddNode(file, rootNode);
              count++;
          }
          
        }
        //  how many files were found here?
        rootNode.setCounter(count);
        return count;
    }
    

    /**
    * Something changed on the disk, reload everything from start 
    * @param UID       The node that should be selected after reloading
    */
    public static void refreshAll(String UID){
        // something went wrong, perhaps we want to output an error message
        if(UID == null){
            log.write(is.ERROR, "SU505 - UID for selected node is null");
            return;
        }
        try{
        core.studio.doSettings();
        // get back to the previoulsy selected node
        swingUtils.setSelectedNode(UID);
        // refresh things up
        core.studio.getTree().repaint();
        swingUtils.refreshTextBox();
        } catch (Exception e){
            System.err.println("SU526: Exception while refreshing the user "
                    + "interface"
            );
        }
    }

    /**
     * This method will select a given SPDX node on the treeview and then
     * read it again from disk to reflect changes from an update
     * @param UID 
     */
    private static void spdxReplace(TreeNodeSPDX node, boolean selected) {
        // preflight check
        if(node.nodeType != NodeType.SPDX){
            log.write(is.ERROR, "TU100 - Node is not an SPDX: %1", node.getUID());
            return;
        }
        
        // get the respective object for this SPDX
        File file = (File) node.getUserObject();
        // do the refresh
        boolean isOk = core.reports.refresh(file.getAbsolutePath());
        // are we good to go?
        if(isOk == false){
            log.write(is.ERROR, "TU137 - Failed to refresh SPDX: %1", node.getUID());
            return;
        }
        // shall we select this node on the treeview?
        if(selected){
            swingUtils.setSelectedNode(node.getUID());
            log.write(is.INFO, Messages.TreeNodeChanged, node.getUID());
        }
    }
    
    
     
    /**
     * This is a critical method. It will look for all SPDX files inside a given
     * folder and them as tree nodes 
     */
    public static void spdxAddFullTree() {
        JTree tree = core.studio.getTree();
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
        spdxAddFiles(core.getProductsFolder(), 25, softwareNode);
    }

   
    /**
     * This is a critical method. It will look for all SPDX files inside a given
     * folder and them as tree nodes 
     */
    public static void spdxCreateListFull() {
        JTree tree = core.studio.getTree();
        // only find the SPDX documents with .SPDX extension
        ArrayList<File> fileList = utils.files
                .findFilesFiltered(core.getProductsFolder(), ".spdx", 25);
        
       
        // get the root node where we have our treeview
        TreeNodeSPDX rootNode = swingUtils.getRootNode(tree);
        
         // create the node for hosting our list of SPDX documents
        nodeReports = nodeCreate(
                definition.nodeSoftware
                        //+ " (" + fileList.size() + ")"
                , NodeType.reportsHome, rootNode);
        // add the identification to this tag
        nodeReports.id = definition.nodeSoftware;
        nodeReports.setIcon("box-label.png");
        
        // set here what we want to happen when the user clicks on it
              File scriptFile = new File(core.getPluginsFolder(), "/basic/home.java");
              nodeReports.scriptFile = scriptFile;
              nodeReports.scriptFolder = scriptFile.getParentFile();
              nodeReports.scriptMethod = "main";
        
        // no need to continue if no SPDX reports were found, just leave here
        if(fileList.isEmpty()){
            return;
        }
       
        // create a tree based on folder tree on disk
        spdxAddFiles(core.getProductsFolder(), 25, nodeReports);
    }
    
     
    /**
     * The node under which all SPDX reports are placed
     * @return 
     */
    public static TreeNodeSPDX getNodeReports() {
        return nodeReports;
    }
    
    
    /**
     * Add the files inside this SPDX document
     */
    private static void addFiles(SPDXfile spdx, TreeNodeSPDX spdxNode){
        // this code below avoids that we add too many times the Files node
        Enumeration list = spdxNode.children();
        while(list.hasMoreElements()){
            TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
            if(child.nodeType == NodeType.sectionFile){
                // no need to continue, our files were already listed
                return;
            }
        }
        
        
        // title of the node that we want to create
        String title = "Files";
        
        // do we have more than one reviewer?
        if(spdx.fileSection.files.size() > 1){
            title = "Files " 
                    + " ("
                    + spdx.fileSection.files.size()
                    + ")";
        }
        
        // let's add the main node for files
        TreeNodeSPDX node = swingUtils.nodeCreate(
                title, 
                NodeType.sectionFile, spdxNode);
        node.nodeType = NodeType.sectionFile;
        node.id = "./";
        node.setUserObject(spdx.fileSection);

        
        
        core.studio.getTree().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // create the tree structure
        spdxDoTreeStructure(node, spdx);
        // if an exception occurs, this next line doesn't happen..
        core.studio.getTree().setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * Creates a tree of folders and respective files
     * @param root
     * @param spdx 
     */
    private static void spdxDoTreeStructure(TreeNodeSPDX root, SPDXfile spdx){
        
        // where we store all the nodes of our tree
        HashMap nodeList = new HashMap();
        
        // add up the root as node as initial part
        nodeList.put(".", root);
        
        // go through all the files inside the SPDX 
        for(FileInfo fileInfo : spdx.fileSection.files){
            // get the path for this file bit
            String path = getFilePath(fileInfo);
            
            // don't add the root node
            if(path.equals(".")){
                continue;
            }
            // add it up to our list
            TreeNodeSPDX folderNode = addNodeFolder(root, path);
            // put in our cached list
            nodeList.put(path, folderNode);
        }
        
        
        // add all the files from the SPDX to our treeview folders
        for(FileInfo fileInfo : spdx.fileSection.files){
            // get the path for this file bit
            String path = getFilePath(fileInfo);
            
            //System.out.println("Looking for -->" + path);
            TreeNodeSPDX pathNode = (TreeNodeSPDX) nodeList.get(path);
            TreeNodeSPDX nodeFile = new TreeNodeSPDX(fileInfo.toString());
            nodeFile.id = fileInfo.getName();
            nodeFile.nodeType = NodeType.file;
            // set a specific icon for this item
            nodeFile.icon = swingUtils.setIcon(fileInfo);
            // add this file to the parent path
            nodeFile.setUserObject(fileInfo);
            pathNode.add(nodeFile);
        }
    }

    /**
     * Returns the path portion from a given FileInfo object
     * @return 
     */
    private static String getFilePath(FileInfo fileInfo){
        
        // or else, the path is found inside the FileName tag
        String fileName = fileInfo.tagFileName.getValue();
        
        // if we have a FilePath tag available, use it as default
        if(fileInfo.tagFilePath != null){
            String filePath = fileInfo.tagFilePath.getValue();
            fileName = filePath + fileName;
        }
        
        // if no path is available, just mention it as root
        if(fileName.contains("/")==false){
            return "./";
        }
        // there is a path available, let's get it
        String result = fileName.substring(0, fileName.lastIndexOf("/"));
        
        return result;
    }
    
    /**
     * Adds a given folder as child from a specific folder
     */
    private static TreeNodeSPDX addNodeFolder(TreeNodeSPDX root, String newFolder){
        // don't accept requests for the root node
        if(newFolder.equals("./")){
            return root;
        }
        
        // try to locate this parent
        TreeNodeSPDX TheOne = findTheOne(root, newFolder);
        // if no folder/node was found, create it
        if(TheOne == null){
            TheOne = createTheOne(root, newFolder);
        }
         
        return TheOne;
    }
    
    /**
     * Create the node inside a given node as father
     */
    private static TreeNodeSPDX createTheOne(TreeNodeSPDX root, String what){
        // we want to break apart all the folder components
        String path = what;
        // we don't need the root part
        if(path.startsWith("./")){
            // remove it
            path = path.substring(2);
        }
        
        // break everything into little pieces
        String[] pathPortions = path.split("/");
        // go through each little piece
        TreeNodeSPDX lastNode = root;
        String lastPortion = ".";
        for(String portion : pathPortions){
            String thisPath = lastPortion + "/" + portion;
            // get the node if it exists, return null if not existing
            TreeNodeSPDX node = getNode(lastNode, thisPath);
            // doesn't exist? Create one
            if(node == null){
                node = new TreeNodeSPDX(portion);
                node.nodeType = NodeType.folder;
                node.id = thisPath;
                // add up this node as child
                lastNode.add(node);
                //System.err.println("TND23s - " + thisPath);
            }
            // increment our data
            lastNode = node;
            lastPortion = thisPath;
        }
        // give back the last node that was created
        return lastNode;
    }
    
     /**
     * Tries to find a node with a given ID from a given 
     * node as root location
     * @param what
     * @return 
     */
    private static TreeNodeSPDX findTheOne(TreeNodeSPDX where, String what){
    // list all the children folders
        Enumeration list = where.children();
        while(list.hasMoreElements()){
            TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
            // first question: Are you the one?
            if(child.id.equals(what)){
                // no need to continue, he is the one
                return child;
            }
            // Is any of your children, the one?
            TreeNodeSPDX result = findTheOne(child, what);
            if(result != null){
                // he is the one
                return result;
            }
        }
        return null;
    }
    
   
     /**
     * Does a given node contain a child with a specific ID?
     * @return 
     */
    private static TreeNodeSPDX getNode(TreeNodeSPDX where, String what){
        // list all the children folders
        Enumeration list = where.children();
        while(list.hasMoreElements()){
            TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
            // first question: Are you the one?
            if(child.id.equals(what)){
                // no need to continue, he is the one
                return child;
            }
        }
       return null; 
    }
    
   /**
     * Displays a basic list of tools that are supported
     */
    public static void react(){ // ensure we get to know which node is selected
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            System.err.println("TU569 - No node selected");
            return;
        }
        
        // we only want SPDX documents from this point forward
        if(node.nodeType != NodeType.SPDX){
            return;
        }
       
        // create the node files and folders
        spdxCreateNodeStructure(node);
        
        
        // all done, time to refresh things up
        swingUtils.setSelectedNode(node.getUID());
        // refresh things up
        core.studio.getTree().repaint();
        
    }
    
    /**
     * This is the method that add files and all other nodes inside the
     * node of a given SPDX document
     * @param node      The SPDX node from where we start
     */
    public static void spdxCreateNodeStructure(TreeNodeSPDX node){
        if(node == null){
            System.err.println("TU595 - Null node on spdxCreateNodeStructure");
            return;
        }
    // SPDX nodes only come with a single param, easy to get
        String[] parameter = node.scriptParameters.get(0);
        // check if this is really what I want
        if(parameter[0].equals(param.spdx)==false){
            log.write(is.ERROR, "TN01 - Was expecting to find the first parameter "
                    + " of the SPDX tree node defining the SPDX document file "
                    + "path on %1", node.getUID());
            return;
        }
        
        // get the relative name of this file
        String spdxRelativePath = parameter[1];
        // now we get the file point, it needs to exist before we continue
        File spdxFile = new File(core.getProductsFolder(), spdxRelativePath);
        if(spdxFile.exists() == false){
            log.write(is.NOTFOUND, "TN02 - Unable to find file %1", 
                    spdxFile.getAbsolutePath());
            return;
        }
        // now read the SPDX document
        SPDXfile spdx = new SPDXfile(spdxFile);
        
        
        // basic parts were done, now add up the needed details
        addPeople(spdx, node);
        addFiles(spdx, node);
        node.update();
    }
      
    /**
     * When necessary, add nodes listing the people that have created the SPDX
     * document. If these nodes were already created, do nothing
     */
    private static void addPeople(SPDXfile spdx, TreeNodeSPDX spdxNode){
        Enumeration list = spdxNode.children();
        while(list.hasMoreElements()){
            TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
            if(child.nodeType == NodeType.sectionCreator){
                // no need to continue, people were already listed
                return;
            }
        }
        
        // title of the node that we want to create
        String title = definition.nodeReviewerSPDX;
        
        // do we have more than one reviewer?
        if(spdx.creatorSection.people.size() > 1){
            title = definition.nodeReviewersSPDX 
                    + " ("
                    + spdx.creatorSection.people.size()
                    + ")";
        }
        
        // let's add people, this is our main node
        TreeNodeSPDX node = swingUtils.nodeCreate(
                title, 
                NodeType.sectionCreator, spdxNode);
        node.nodeType = NodeType.sectionCreator;
        node.id = definition.nodeReviewerSPDX;
        node.setUserObject(spdx.creatorSection);
        
        // create now a node for each author
        for(Person person : spdx.creatorSection.people){
            TreeNodeSPDX nodePerson = swingUtils.addNodePerson(node, person);
            // add here the action we want to happen when clicked
            File scriptFile = new File(core.getPluginsFolder(), "/people/show.java");
            nodePerson.scriptFile = scriptFile;
            nodePerson.scriptFolder = scriptFile.getParentFile();
            nodePerson.scriptMethod = "details";
            // create the correct parameters
            String relativePath = 
                    spdx.file.getAbsolutePath().replace(core.getProductsFolder().getAbsolutePath(), "");
            // add the SPDX that we want to edit/show
            nodePerson.scriptParameters.add(new String[]{param.spdx, relativePath});
            // add the user name that we want to edit
            nodePerson.scriptParameters.add(new String[]{param.filter, person.getTitle()});
        }
    } 
    
    /**
     * Starting from a specific node, find all child nodes that correspond
     * to a specific node type filter. (most used used to collect file nodes)
     * @param node      The starting point from where we want to get results
     * @param nodes     The result, contains a list of nodes
     * @param filter    Only nodes of a given NodeType will be added to the list
     */
    public static void getNodes(TreeNodeSPDX node, 
            ArrayList<TreeNodeSPDX> nodes, NodeType filter){
            
        // no child nodes? nothing else to do on this loop
        if(node.getChildCount() == 0){
            //System.err.println("SU1155: No child nodes to proceed");
            return;
        }
        // enumerate the available sub-nodes and add them up
        Enumeration list = node.children();
        while(list.hasMoreElements()){
            // get the next node
            TreeNodeSPDX newNode = (TreeNodeSPDX) list.nextElement();
            // dig deeper to find other subnodes there
            getNodes(newNode, nodes, filter);
             // what type of nodes are we interested?
            if(newNode.nodeType != filter){
                continue;
            }
            // add this node on our list
            //System.err.println("->" + newNode.toString());
            nodes.add(newNode);
       }
      // return nodes; 
    }
    
    
     /**
     * When changes happen on the physical SPDX document on disk, we need
     * to update the nodes inside the treeview with the fresh information
     * @param spdx      The spdx object with the updated information
     */
    public static void spdxUpdateAllNodes(SPDXfile spdx){
        nodeReports.children();
        // enumerate the available sub-nodes and add them up
        Enumeration list = nodeReports.children();
        TreeNodeSPDX spdxNode = null;
        // go through the basic root of documents
        while(list.hasMoreElements()){
            // get the next node
            TreeNodeSPDX tempNode = (TreeNodeSPDX) list.nextElement();
            // does its object match with what we are looking?
            File file = (File) tempNode.getUserObject();
            if(file.getAbsolutePath().equals(spdx.file.getAbsolutePath())){
                spdxNode = tempNode;
                // no need to loop through the other documents
                break;
            }
       }
        // no need to continue if nothing was found
        if(spdxNode == null){
            System.err.println("TU728 - Didn't found spdxNode at " 
                    + spdx.file.getAbsolutePath());
            return;
        }

        // now create a list with all the nodes that we want to change
        ArrayList<TreeNodeSPDX> nodes = new ArrayList();
        getNodes(spdxNode, nodes, NodeType.file);
        //System.err.println("Changing " + nodes.size() + " nodes");
        // go through each one to make changes
        for(TreeNodeSPDX node : nodes){
             // get the object
            FileInfo fileInfo = (FileInfo) node.getUserObject();       
            // now update the value on our treeview
            String location = fileInfo.getRelativeLocation();
            FileInfo newInfo = fileInfo.spdx.findRelative(location);
            // no need to continue if the result is null
            if(newInfo == null){
                System.err.println("SU1228: Didn't found the relative FileInfo");
                return;
            }
            // now update the node on the tree view
            node.setUserObject(newInfo);
            node.setTitle(newInfo.toString());
            node.update();
        }
        
    }
    
    
}
