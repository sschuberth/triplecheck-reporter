/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-05-08T09:46:54Z
 * LicenseName: AGPL-3.0+
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
import java.util.HashMap;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import main.controller;
import main.coreGUI;
import main.engine;
import main.param;
import main.script.log;
import spdxlib.FileInfo;
import license.License;
import license.LicenseType;
import spdxlib.SPDXfile;
import spdxlib.swing.NodeType;
import spdxlib.swing.TreeNodeSPDX;
import www.RequestOrigin;
import www.RequestType;
import www.WebRequest;


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
                coreGUI.studio.getTree().getModel().getRoot();
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
//        SPDXfile spdx = engine.reports.get(file);
//        // preflight check
//        if(spdx == null){
//            log.write(is.ERROR, "TU79 - SPDX object is null: %1", 
//                    file.getAbsolutePath());
//            return;
//        }
//        // add this node to our list
//        TreeNodeSPDX result = spdxAddNode(spdx, nodeReports);
////        spdxCreateNodeStructure(result);
//        swingUtils.setSelectedNode(UID);
//        log.write(is.COMPLETED, "Added SPDX node: %1", file.getName());
    }

    
    
    /**
     * This method will add a given SPDX node to our treeview and select
     * the new node as default
     * @param spdx
     * @param rootNode
     * @return 
     */
    public static TreeNodeSPDX spdxAddNode(final SPDXfile spdx, 
            final TreeNodeSPDX rootNode) {
        
        // avoid null spdx objects
        if(spdx == null || spdx.getNodeAuthorShip() == null){
            return null;
        }
        
        final File file = spdx.file;
        final String fileName = file.getName();
        // create the new node, remove the spdx file extension
        final TreeNodeSPDX node = new TreeNodeSPDX(fileName.replace(".spdx", ""));
        node.setIcon("box.png");
        node.nodeType = NodeType.SPDX;
        node.id = fileName;
        // set here what we want to happen when the user clicks on it
        final File scriptFile = new File(engine.getPluginsFolder(), "/spdx/show.java");
        node.scriptFile = scriptFile;
        node.scriptFolder = scriptFile.getParentFile();
        node.scriptMethod = "summary";
        // Set as object the file pointer
        node.setUserObject(file);
        
        // add the files that we might have
        node.add(spdx.getNodeFiles());
        // provide for some authorship stats / tooling
        node.add(spdx.getNodeAuthorShip());
        // add up the components node
        node.add(spdx.getNodeComponents());
        // add up the settings node
        node.add(spdx.getNodeSettings());
        // add up the settings node
        node.add(spdx.getNodeExport());
        
        // create the correct parameters
        final String relativePath = spdx.getRelativePath();
        node.scriptParameters.add(new String[]{param.spdx, relativePath});
        rootNode.add(node);
        return node;
    }
    
    /**
    * Something changed on the disk, reload everything from start 
    * @param UID       The node that should be selected after reloading
     * @param refreshText
    */
    public static void refreshAll(final String UID, final boolean refreshText){
        // something went wrong, perhaps we want to output an error message
        if(UID == null){
            log.write(is.ERROR, "SU505 - UID for selected node is null");
            return;
        }
        try{
            //coreGUI.studio.getTree().removeAll();
            coreGUI.studio.doSettingsTreeview();
            //coreGUI.studio.doSettings();
            // get back to the previoulsy selected node
            swingUtils.setSelectedNode(UID);
            // refresh things up
            coreGUI.studio.getTree().repaint();
            if(refreshText){
                swingUtils.refreshTextBox();
            }
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
        boolean isOk = engine.reports.refresh(file.getAbsolutePath());
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
        final JTree tree = coreGUI.studio.getTree();
       
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
        File scriptFile = new File(engine.getPluginsFolder(), "/basic/home.java");
        nodeReports.scriptFile = scriptFile;
        nodeReports.scriptFolder = scriptFile.getParentFile();
        nodeReports.scriptMethod = "main";
  
              
        TreeNodeSPDX lastNode = null;
        int counter = 0;
        // create a tree based on folder tree on disk
        for(SPDXfile spdx : engine.reports.getList()){
            try{
                lastNode = spdxAddNode(spdx, nodeReports);
            }catch (Exception e){
                System.err.println("TU238, Error processing SPDX: " + spdx.getRelativePath());
                e.printStackTrace();
                // sometimes the problem is an empty SPDX file, we can delete it
                File spdxFile = spdx.getFile();
                // is the file containing zero bytes?
                if(spdxFile.length() == 0){
                    // no point in keeping, just delete please
                    spdxFile.delete();
                }else{
                    // something else is happening, call for attention
                    System.exit(-1);
                }
                
            }
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
            JTree tree = coreGUI.studio.getTree();
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

    /**
     * The node under which all SPDX reports are placed
     * @return 
     */
    public static TreeNodeSPDX getNodeReports() {
        return nodeReports;
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
    
        JTree tree = coreGUI.studio.getTree();
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
    
    
    /**
     * Based on a given treeview node, fire up the specified event just like
     * a normal user would have clicked on it.
     * @param scriptFile    The file to execute
     * @param method        The method to be called
     * @param parameters    The parameters for this call
     */
    public static void doRequest(final File scriptFile, 
            final String method, final ArrayList<String[]> parameters){
        WebRequest newRequest = new WebRequest();
        newRequest.requestType = RequestType.NONE;
        newRequest.requestOrigin = RequestOrigin.GUI_tree;
        newRequest.BaseFolder = scriptFile.getParentFile();
        newRequest.scriptFile = scriptFile;
        newRequest.scriptFolder = scriptFile.getParentFile();
        newRequest.scriptMethod = method;
        newRequest.parameters = parameters;
        controller.process(newRequest);
    }
    
    
    /**
     * Looking on the treeview of the main user interface form, we will first
     * get all the selected tree nodes, then pick only the ones that belong
     * to files and in the end group each file according to the SPDX document
     * where it belongs to.
     * @return  An array of SPDX documents and selected files within, null otherwise
     */
    public static HashMap<String, ArrayList<FileInfo>> getSelectedFiles(){
    // create a list of nodes to process
        ArrayList<TreeNodeSPDX> selectedNodes = swingUtils.getSelectedNodes(coreGUI.studio.getTree());
        ArrayList<TreeNodeSPDX> nodeList = new ArrayList();
        // get only the relevant nodes
        for(TreeNodeSPDX node : selectedNodes){
              // only files and folders are supported at the moment
            if((node.nodeType == NodeType.folder)
                    ||(node.nodeType == NodeType.sectionFile)){
                //System.err.println("Changing the whole folder");
                TreeviewUtils.getNodes(node, nodeList, NodeType.file);
            }
            // only files are supported at the moment
            if(node.nodeType == NodeType.file){
                nodeList.add(node);
            }
        }
        
        // now update the licenses
        if(nodeList.isEmpty()){
            // nothing to do, just leave
            System.err.println("TU803 - No nodes available to change");
            return null;
        }
        
        // on this operation we need to account that an end-user might choose
        // nodes from different SPDX documents, therefore we need to split these
        HashMap<String, ArrayList<FileInfo>> spdxList = new HashMap();
        // now iterate each node and split them into respective SPDX
        for(TreeNodeSPDX node : nodeList){
            FileInfo fileInfo = (FileInfo) node.getUserObject();
            // we use the id as unique identifier
            final String id = fileInfo.getSPDX().getId();
            if(spdxList.containsKey(id)){
                spdxList.get(id).add(fileInfo);
            }else{
                // didn't existed before, create a list for this spdx
                ArrayList<FileInfo> list = new ArrayList();
                list.add(fileInfo);
                spdxList.put(id, list);
            }
        }
        // all done
        return spdxList;
    }
    
    
    /**
     * This method will change the declared license for a group of files.
     * It requires a list of the Id's that will be modified and a registered
     * license.
     * @param listUID   A string array where each element is a separate UID
     * @param license   A license from our list of available licenses
     */
    public static void changeDeclaredLicense(String[] listUID, License license){
        // we have a list of UID, now we need to convert these onto
        // real objects.
        
        // create the list that will host the real nodes
        ArrayList<TreeNodeSPDX> nodeList = new ArrayList();
        // now iterate each array member to get the respective object
        for(String UID : listUID){
            // get the node
            TreeNodeSPDX node = TreeviewUtils.getNode(UID);
            // add to our list
            nodeList.add(node);
        }
        
        
        // on this operation we need to account that an end-user might choose
        // nodes from different SPDX documents, therefore we need to split these
        HashMap<String, ArrayList<FileInfo>> spdxList = new HashMap();
        // now iterate each node and split them into respective SPDX
        for(TreeNodeSPDX node : nodeList){
            FileInfo fileInfo = (FileInfo) node.getUserObject();
            // we use the id as unique identifier
            final String id = fileInfo.getSPDX().getId();
            if(spdxList.containsKey(id)){
                spdxList.get(id).add(fileInfo);
            }else{
                // didn't existed before, create a list for this spdx
                ArrayList<FileInfo> thisList = new ArrayList();
                thisList.add(fileInfo);
                spdxList.put(id, thisList);
            }
        }
        
        // now that we splitted all the fileInfo, it is time to write them
        for(ArrayList<FileInfo> fileInfoList : spdxList.values()){
            // get the SPDX object
            SPDXfile spdx = fileInfoList.get(0).getSPDX();
            // write the lines for this list
            spdx.writeLines(fileInfoList, is.tagLicenseConcluded, license.getId(), true);
            // after writing the changes to disk, it is time to update the nodes
            for(FileInfo fileInfo : fileInfoList){
                fileInfo.setLicenseConcluded(LicenseType.convertToEnum(license.getId()));
            }
        }
        
        // finish by updating the nodes on the treeview
        for(TreeNodeSPDX node : nodeList){
            if(node.nodeType != NodeType.file){
                continue;
            }
            DefaultTreeModel model = (DefaultTreeModel) 
                    coreGUI.studio.getTree().getModel();
            model.nodeChanged(node);
        }
    }
}
