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
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import main.core;
import main.param;
import script.log;
import spdxlib.SPDXfile2;


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
        System.err.println("TU68: AddOrUpdate SPDX not implemented");
       // get the software node
//        TreeNodeSPDX node = getNode(UID);
//        // does the node already exists?
//        if(node != null){
//            log.write(is.INSTALLING, "Replacing node");
//            spdxReplace(node, true);
//            return;
//        }
//        
//        // we now are sure that exists no such SPDX indexed yet 
//        log.write(is.INSTALLING, "Adding new SPDX node");
//        // add this new SPDX to our list
//        SPDXfile2 spdx = core.reports.get(file);
//        // preflight check
//        if(spdx == null){
//            log.write(is.ERROR, "TU79 - SPDX object is null: %1", 
//                    file.getAbsolutePath());
//            return;
//        }
//        // add this node to our list
//        TreeNodeSPDX result = spdxAddNode2(spdx, nodeReports);
////        spdxCreateNodeStructure(result);
//        swingUtils.setSelectedNode(UID);
//        log.write(is.COMPLETED, "Added SPDX node: %1", file.getName());
    }

    
    
    /**
     * This method will add a given SPDX node to our treeview and select
     * the new node as default
     * @param UID   Unique identification for this spdx
     * @param file  its location on disk
     */
    private static TreeNodeSPDX spdxAddNode2(final SPDXfile2 spdx, 
            final TreeNodeSPDX rootNode) {
        final File file = spdx.file;
        final String fileName = file.getName();
        // create the new node, remove the spdx file extension
        final TreeNodeSPDX node = new TreeNodeSPDX(fileName.replace(".spdx", ""));
        node.setIcon("box.png");
        node.nodeType = NodeType.SPDX;
        node.id = fileName;
        // set here what we want to happen when the user clicks on it
        final File scriptFile = new File(core.getPluginsFolder(), "/spdx/show.java");
        node.scriptFile = scriptFile;
        node.scriptFolder = scriptFile.getParentFile();
        node.scriptMethod = "summary";
        // Set as object the file pointer
        node.setUserObject(file);
        
        // add the files that we might have
        node.add(spdx.getNodeFiles());
        
        // create the correct parameters
        final String relativePath = 
        file.getAbsolutePath().replace(core.getProductsFolder().getAbsolutePath(), "");
        node.scriptParameters.add(new String[]{param.spdx, relativePath});
        rootNode.add(node);
        return node;
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
 readLines it again from disk to reflect changes from an update
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
        final JTree tree = core.studio.getTree();
       
        // get the root node where we have our treeview
        final TreeNodeSPDX rootNode = swingUtils.getRootNode(tree);
        
         // create the node for hosting our list of SPDX documents
        nodeReports = nodeCreate(
                definition.nodeReports
                , NodeType.other, rootNode);
        // add the identification to this tag
        nodeReports.id = definition.nodeReports;
        nodeReports.setIcon("box-label.png");
        
        // set here what we want to happen when the user clicks on it
        File scriptFile = new File(core.getPluginsFolder(), "/basic/home.java");
        nodeReports.scriptFile = scriptFile;
        nodeReports.scriptFolder = scriptFile.getParentFile();
        nodeReports.scriptMethod = "main";
  
              
        TreeNodeSPDX lastNode = null;
        int counter = 0;
        // create a tree based on folder tree on disk
        for(SPDXfile2 spdx : core.reports.getList()){
            lastNode = spdxAddNode2(spdx, nodeReports);
            counter++;
        }
        
        if(counter > 0){
            nodeReports.setTitle(definition.nodeReports + " (" + counter + ")");
        }
        
       
        if(lastNode == null){
            return;
        }
        
        // expand the tree node
        //TreeviewUtils.nodeExpand(lastNode);
       final TreeNodeSPDX node = lastNode;
        final TreeNodeSPDX softNode = nodeReports;
        
        
        
        SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JTree tree = core.studio.getTree();
            tree.updateUI();
            tree.requestFocus();
            tree.setExpandsSelectedPaths(true);
            TreeSelectionModel model = tree.getSelectionModel();
            TreePath path1 = new TreePath(rootNode.getPath());
            TreePath path2 = new TreePath(softNode.getPath());
            TreePath path3 = new TreePath(node.getPath());

            model.setSelectionPath(path1);
            model.setSelectionPath(path2);
            model.setSelectionPath(path3);
            tree.scrollPathToVisible(path3);  
            tree.setSelectionModel(model);
            tree.expandPath(path3);

            ThirdParty.MiscMethods.collapseAll(tree, path3);

                }
            });
        
     
    }

    
    
    
   
//    /**
//     * This is a critical method. It will look for all SPDX files inside a given
//     * folder and them as tree nodes 
//     */
//    public static void spdxCreateListFull() {
//        JTree tree = core.studio.getTree();
//        // only find the SPDX documents with .SPDX extension
//        ArrayList<File> fileList = utils.files
//                .findFilesFiltered(core.getProductsFolder(), ".spdx", 25);
//        
//       
//        // get the root node where we have our treeview
//        TreeNodeSPDX rootNode = swingUtils.getRootNode(tree);
//        
//         // create the node for hosting our list of SPDX documents
//        nodeReports = nodeCreate(
//                definition.nodeReports
//                        //+ " (" + fileList.size() + ")"
//                , NodeType.reportsHome, rootNode);
//        // add the identification to this tag
//        nodeReports.id = definition.nodeReports;
//        nodeReports.setIcon("box-label.png");
//        
//        // set here what we want to happen when the user clicks on it
//              File scriptFile = new File(core.getPluginsFolder(), "/basic/home.java");
//              nodeReports.scriptFile = scriptFile;
//              nodeReports.scriptFolder = scriptFile.getParentFile();
//              nodeReports.scriptMethod = "main";
//        
//        // no need to continue if no SPDX reports were found, just leave here
//        if(fileList.isEmpty()){
//            return;
//        }
//       
//        // create a tree based on folder tree on disk
//        spdxAddFiles(core.getProductsFolder(), 25, nodeReports);
//    }
//    
     
    /**
     * The node under which all SPDX reports are placed
     * @return 
     */
    public static TreeNodeSPDX getNodeReports() {
        return nodeReports;
    }
    
    
//    /**
//     * Add the files inside this SPDX document to the treeview node
//     */
//    private static void spdxCreateFileSection(SPDXfile2 spdx, TreeNodeSPDX spdxNode){
//        // this code below avoids that we add too many times the Files node
//        Enumeration list = spdxNode.children();
//        while(list.hasMoreElements()){
//            TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
//            if(child.nodeType == NodeType.sectionFile){
//                // no need to continue, our files were already listed
//                return;
//            }
//        }
//        
//        
//        // title of the node that we want to create
//        String title = "Files";
//        
//        // do we have more than one reviewer?
//        if(spdx.getFiles().size() > 1){
//            title = "Files " 
//                    + " ("
//                    + spdx.getFiles().size()
//                    + ")";
//        }
//        
//        // let's add the main node for files
//        TreeNodeSPDX node = swingUtils.nodeCreate(
//                title, 
//                NodeType.sectionFile, spdxNode);
//        node.nodeType = NodeType.sectionFile;
//        node.id = "./";
//        node.setUserObject(spdx.getFiles());
//
//        
//        
//        core.studio.getTree().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//        // create the tree structure
//        node.add(spdx.getNodeFiles());
//        // if an exception occurs, this next line doesn't happen..
//        core.studio.getTree().setCursor(Cursor.getDefaultCursor());
//    }
//    
     
//    /**
//     * Creates a tree of folders and respective files
//     * @param root
//     * @param spdx 
//     */
//    public static void spdxDoTreeFileStructureOld(TreeNodeSPDX root, SPDXfile2 spdx){
//        
//        // where we store all the nodes of our tree
//        HashMap nodeList = new HashMap();
//        
//        // add up the root as node as initial part
//        nodeList.put(".", root);
//        
//        // go through all the files inside the SPDX 
//        for(FileInfo2 fileInfo : spdx.getFiles()){
//            // get the path for this file bit
//            final String path = fileInfo.getFilePath();
//            // don't add the root node
//            if(utils.text.equals(path, ".")){
//                continue;
//            }
//            // add a new folder to our list
//            TreeNodeSPDX folderNode = addNodeFolder(root, path);
//            // put in our cached list
//            nodeList.put(path, folderNode);
//        }
//        
//        
//        // now add all the files from the SPDX to our treeview folders
//        for(FileInfo2 fileInfo : spdx.getFiles()){
//            // get the path for this file bit
//            final String path = fileInfo.getFilePath();
//            
//            final TreeNodeSPDX pathNode = (TreeNodeSPDX) nodeList.get(path);
//            TreeNodeSPDX nodeFile = new TreeNodeSPDX(fileInfo.getName());
//            nodeFile.id = fileInfo.getFileName();
//            nodeFile.nodeType = NodeType.file;
//            // set a specific icon for this item
//            nodeFile.icon = fileInfo.getFileCategory().toIcon();
//            // add this file to the parent path
//            nodeFile.setUserObject(fileInfo);
//            pathNode.add(nodeFile);
//        }
//    }

//    /**
//     * Adds a given folder as child from a specific folder
//     */
//    private static TreeNodeSPDX addNodeFolder(TreeNodeSPDX root, String newFolder){
//        // don't accept requests for the root node
////        if(utils.text.equals(newFolder, "./")){
////            return root;
////        }
//        
//        // try to locate this parent
//        TreeNodeSPDX TheOne = findTheOne(root, newFolder);
//        // if no folder/node was found, create it
//        if(TheOne == null){
//            TheOne = createTheOne(root, newFolder);
//        }
//        return TheOne;
//    }
    
//    /**
//     * Create the node inside a given node as father
//     */
//    private static TreeNodeSPDX createTheOne(TreeNodeSPDX root, String what){
//        // we want to break apart all the folder components
//        String path = what;
//        // we don't need the root part
//        if(path.startsWith("./")){
//            // remove it
//            path = path.substring(2);
//        }
//        
//        // break everything into little pieces
//        String[] pathPortions = path.split("/");
//        // go through each little piece
//        TreeNodeSPDX lastNode = root;
//        String lastPortion = ".";
//        for(String portion : pathPortions){
//            String thisPath = lastPortion + "/" + portion;
//            // get the node if it exists, return null if not existing
//            TreeNodeSPDX node = getNode(lastNode, thisPath);
//            // doesn't exist? Create one
//            if(node == null){
//                node = new TreeNodeSPDX(portion);
//                node.nodeType = NodeType.folder;
//                node.id = thisPath;
//                // add up this node as child
//                lastNode.add(node);
//                //System.err.println("TND23s - " + thisPath);
//            }
//            // increment our data
//            lastNode = node;
//            lastPortion = thisPath;
//        }
//        // give back the last node that was created
//        return lastNode;
//    }
    
//     /**
//     * Tries to find a node with a given ID from a given 
//     * node as root location
//     * @param what
//     * @return 
//     */
//    private static TreeNodeSPDX findTheOne(TreeNodeSPDX where, final String what){
//    // list all the children folders
//        Enumeration list = where.children();
//        while(list.hasMoreElements()){
//            final TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
//            // first question: Are you the one?
//            if(utils.text.equals(child.id,what)){
//                 return child;
//            }
//            // Is any of your children, the one?
//            TreeNodeSPDX result = findTheOne(child, what);
//            if(result != null){
//                // he is the one
//                return result;
//            }
//        }
//        return null;
//    }
//    
   
//     /**
//     * Does a given node contain a child with a specific ID?
//     * @return 
//     */
//    private static TreeNodeSPDX getNode(TreeNodeSPDX where, String what){
//        // list all the children folders
//        Enumeration list = where.children();
//        while(list.hasMoreElements()){
//            TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
//            // first question: Are you the one?
//            if(child.id.equals(what)){
//                // no need to continue, he is the one
//                return child;
//            }
//        }
//       return null; 
//    }
    
   /**
     * Displays a basic list of tools that are supported
     */
//    public static void react(){ // ensure we get to know which node is selected
//        TreeNodeSPDX node = swingUtils.getSelectedNode();
//        // no need to continue if there is nothing selected
//        if(node == null){
//            System.err.println("TU569 - No node selected");
//            return;
//        }
//        
//        // we only want SPDX documents from this point forward
//        if(node.nodeType != NodeType.SPDX){
//            return;
//        }
//       
//        // create the node files and folders
//        spdxCreateNodeStructure(node);
//        
//        // all done, time to refresh things up
//        swingUtils.setSelectedNode(node.getUID());
//        // refresh things up
//        core.studio.getTree().repaint();
//        
//    }
    
//    /**
//     * This is the method that add files and all other nodes inside the
//     * node of a given SPDX document
//     * @param node      The SPDX node from where we start
//     */
//    public static void spdxCreateNodeStructure(TreeNodeSPDX node){
//        if(node == null){
//            System.err.println("TU595 - Null node on spdxCreateNodeStructure");
//            return;
//        }
//    // SPDX nodes only come with a single param, easy to get
//        String[] parameter = node.scriptParameters.get(0);
//        // check if this is really what I want
//        if(parameter[0].equals(param.spdx)==false){
//            log.write(is.ERROR, "TN01 - Was expecting to find the first parameter "
//                    + " of the SPDX tree node defining the SPDX document file "
//                    + "path on %1", node.getUID());
//            return;
//        }
//        
//        // get the relative name of this file
//        String spdxRelativePath = parameter[1];
//        // now we get the file point, it needs to exist before we continue
//        File spdxFile = new File(core.getProductsFolder(), spdxRelativePath);
//        if(spdxFile.exists() == false){
//            log.write(is.NOTFOUND, "TN02 - Unable to find file %1", 
//                    spdxFile.getAbsolutePath());
//            return;
//        }
//        // now read the SPDX document
//        SPDXfile2 spdx = core.reports.get(spdxFile);
//        // basic parts were done, now add up the needed details
//        spdxCreateFileSection(spdx, node);
//        node.update(true);
//    }
      
//    /**
//     * When necessary, add nodes listing the people that have created the SPDX
//     * document. If these nodes were already created, do nothing
//     */
//    private static void addPeople(SPDXfile2 spdx, TreeNodeSPDX spdxNode){
//        Enumeration list = spdxNode.children();
//        while(list.hasMoreElements()){
//            TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
//            if(child.nodeType == NodeType.sectionCreator){
//                // no need to continue, people were already listed
//                return;
//            }
//        }
//        
//        // title of the node that we want to create
//        String title = definition.nodeReviewerSPDX;
//        
//        // do we have more than one reviewer?
//        if(spdx.creatorSection.people.size() > 1){
//            title = definition.nodeReviewersSPDX 
//                    + " ("
//                    + spdx.creatorSection.people.size()
//                    + ")";
//        }
//        
//        // let's add people, this is our main node
//        TreeNodeSPDX node = swingUtils.nodeCreate(
//                title, 
//                NodeType.sectionCreator, spdxNode);
//        node.nodeType = NodeType.sectionCreator;
//        node.id = definition.nodeReviewerSPDX;
//        node.setUserObject(spdx.creatorSection);
//        
//        // create now a node for each author
//        for(Person person : spdx.creatorSection.people){
//            TreeNodeSPDX nodePerson = swingUtils.addNodePerson(node, person);
//            // add here the action we want to happen when clicked
//            File scriptFile = new File(core.getPluginsFolder(), "/people/show.java");
//            nodePerson.scriptFile = scriptFile;
//            nodePerson.scriptFolder = scriptFile.getParentFile();
//            nodePerson.scriptMethod = "details";
//            // create the correct parameters
//            String relativePath = 
//                    spdx.file.getAbsolutePath().replace(core.getProductsFolder().getAbsolutePath(), "");
//            // add the SPDX that we want to edit/show
//            nodePerson.scriptParameters.add(new String[]{param.spdx, relativePath});
//            // add the user name that we want to edit
//            nodePerson.scriptParameters.add(new String[]{param.filter, person.getTitle()});
//        }
//    } 
    
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
     * When given a folder structure like ./examples/browser/simple.html where
     * we will create the folder structure and finish with a node for the file.
     * @param startingFolder    From where we should starting adding nodes
     * @param nodePath          The path of folders and file to be created
     * @return                  A TreeNodeSPDX of the file created 
     */
    static public TreeNodeSPDX mkdirNodes(final TreeNodeSPDX startingFolder, final String nodePath){
      String[] paths = nodePath.split("/");
      TreeNodeSPDX baseFolder = startingFolder;
      TreeNodeSPDX parentFolder = baseFolder;
      for(String path : paths){
          parentFolder = baseFolder;
          baseFolder = mkdirNode(baseFolder, path);
      }
      // the last node is a file
      baseFolder.nodeType = NodeType.file;
      
      // smartass way of adding files on the bottom of the list without an "IF" 
      parentFolder.remove(baseFolder);
      parentFolder.add(baseFolder);
      return baseFolder;
    }


  /**
   * Discover is a given folder node already exists. Otherwise, create one
   * @param parentNode  The base folder where we should look
   * @param find        The name of the folder
   * @return            The folder node
   */
    static TreeNodeSPDX mkdirNode(final TreeNodeSPDX parentNode, final String find){
    // get a list of them all
    Enumeration list = parentNode.children();
    while(list.hasMoreElements()){
        // get the next element
        final TreeNodeSPDX child = (TreeNodeSPDX) list.nextElement();
        // we only care for folders, otherwise jump to the next element
        if(child.nodeType != NodeType.folder){
            continue;
        }
        // do we have a match?
        if(utils.text.equals(child.getTitle(), find)){
            return child;
        }
    }
    // we reached the end and didn't found it. That's ok, create one now
    TreeNodeSPDX thisNode = new TreeNodeSPDX(find);
    thisNode.nodeType = NodeType.folder;
    // we place the node on top of the list (to show sorted folders/files)
    parentNode.insert(thisNode, 0);
    return thisNode;
}
    
    
     /**
     * When given a tree node, expand it.
     * @param node  The node to expand
     */
    public static void nodeExpand(TreeNodeSPDX node){
    
        JTree tree = core.studio.getTree();
        TreeSelectionModel model = tree.getSelectionModel();
        TreePath path;
        TreeNodeSPDX child;
        try{
        child = (TreeNodeSPDX) node.getFirstChild();
        } catch (Exception except){
            System.err.println("TU674 - No reports available");
            return;
        }
//
            path = new TreePath(child.getPath());
            // now out tree will expand the first child
            model.addSelectionPath(path);
            tree.setExpandsSelectedPaths(true);
            tree.setSelectionPath(path);  
            tree.scrollPathToVisible(path);
            
            tree.expandPath(path);
            tree.setSelectionModel(model);
         
        // second wave
        path = new TreePath(node.getPath());
        // what we really wanted is to highligh the father, so, go back!
        model.addSelectionPath(path);
        tree.setExpandsSelectedPaths(true);
        tree.setSelectionPath(path);  
        tree.scrollPathToVisible(path);    
        
        tree.setSelectionModel(model);
    }   
    
    
}
