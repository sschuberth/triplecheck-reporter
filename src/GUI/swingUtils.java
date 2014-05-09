/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-01T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: swingUtils.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Fast access to common GUI swingUtils </text> 
 */
package GUI;

import definitions.Messages;
import definitions.folder;
import definitions.is;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;
import javax.swing.text.Element;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import main.controller;
import main.core;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;
import script.log;
import spdxlib.*;
import utils.html;
import www.RequestOrigin;
import www.RequestType;
import www.WebRequest;


public class swingUtils {

    
    /**
     * Shows the dialog to allow selecting a folder
     * @param startInFolder
     * @param key Which key will this value be written at?
     * @return 
     */
    public static File chooseFolder(File startInFolder, String key){
        JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(false);
            // only show directories
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // check if the last used folder still exists
            if((startInFolder!=null)&&(startInFolder.exists())){
                // start from the previous folder if possible
                fc.setCurrentDirectory(startInFolder);
            }

        fc.setDialogTitle("Open directory");
        // open up the dialog
        if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        
        // write the key
        if(key.isEmpty() == false){
            core.settings.write(key, fc.getSelectedFile().getAbsolutePath());
        }
            
        log.write(is.ACCEPTED, "Folder chosen: %1"
                ,fc.getSelectedFile().getAbsolutePath());
        
        // grab the file
        return fc.getSelectedFile();
    }
    
     /**
     * Get the currently selected node from a given tree using the default
     * UI as model
     * @return the currently selected tree node or null if nothing is selected
     */
    public static TreeNodeSPDX getSelectedNode(){
        JTree tree = core.studio.getTree();
        return swingUtils.getSelectedNode(tree);
    }
    
    
    /**
     * Get the currently selected node from a given tree
     * @param tree The tree box on the left side of the default UI
     * @return The currently selected node or null if nothing selected
     */
    public static TreeNodeSPDX getSelectedNode(JTree tree){
        // preflight checks
        TreeNodeSPDX result;
        try{
            result =  
                (TreeNodeSPDX) tree.getSelectionPath().getLastPathComponent();
        }catch (Exception e){
            //e.printStackTrace();
            return null;
        }
    return result;
    }
    
    /**
     * Get the currently selected node from a given tree
     * @param tree The tree box on the left side of the default UI
     * @return The currently selected node or null if nothing selected
     */
    public static ArrayList<TreeNodeSPDX> getSelectedNodes(JTree tree){
        // preflight checks
        ArrayList<TreeNodeSPDX> result = new ArrayList();
        
        //TreeNodeSPDX pathw = (TreeNodeSPDX) tree.getSelectionPath().getLastPathComponent();
        
        try{
            for(TreePath path : tree.getSelectionPaths()){
                TreeNodeSPDX node = (TreeNodeSPDX) path.getLastPathComponent();
                result.add(node);
            }
        }catch (Exception e){
            //e.printStackTrace();
            return null;
        }
    return result;
    }
    
    
    /**
     * Creates a new under under a given root node.
     * The new node contains the details about a person
     * @param root the parent of the new node
     * @param person the object that will be used to populate the new node
     * @return The node with the person details
     */
    static public TreeNodeSPDX addNodePerson(TreeNodeSPDX root, Person person){
        TreeNodeSPDX nodePerson = 
                   createNodeChild(person.getTitle(),root);
        // add the object
           nodePerson.nodeType = NodeType.person;
           nodePerson.id = person.getTitle();
           nodePerson.setUserObject(person);
           return nodePerson;
    } 
    
    
    /**
     * Method to ease the creation of new nodes on the tree list
     * @param title the title of this node that is present to the public
     * @param root the parent of the new node to be created
     * @return the new node
     */
    static public TreeNodeSPDX createNodeChild(String title, TreeNodeSPDX root){
        TreeNodeSPDX node =
            new TreeNodeSPDX(title);
        root.add(node); 
        return node;
    }
    
    /**
      * Adds the output when the given tag is not null
     * @param title the title of this entry
     * @param tag the value of this entry
     * @return a printable string using the format "key: value"
      */
    static public String addIfNotEmpty(String title, String text){
        // preflight checks
        if(text.isEmpty()){
            return "";
        }
        if(text.isEmpty()){
            return "";
        }
        String result = ""
                + "<b>" 
                + title 
                + "</b>"
                + ": "
                //+ "<PLAINTEXT>" 
                //+ "<pre>" 
                + text
                //+ "</pre>"
                //+ "</PLAINTEXT>"
                //+ "<br>"
                //+ "<br>"
                + html.br;
        return result;
    }
    
     /**
      * Adds the output when the given tag is not null
     * @param title the title of this entry
     * @param tag the value of this entry
     * @return a printable string using the format "key: value"
      */
    static public String addIfNotEmpty(String title, TagValue tag){
        // preflight checks
        if(tag == null){
            return "";
        }
        return addIfNotEmpty(title, tag.toString());
    }
    
    
      public static void runDemo(FileInfo file) {
        System.err.println("");
    }
    
      
    /**
     * Creates a new node on our tree list
     * @param title the readable title of this node
     * @param nodeType category of this node
     * @param root the node where all other nodes will created as child
     * @return a node fully configured
     */
    public static TreeNodeSPDX nodeCreate(String title, NodeType nodeType,
            TreeNodeSPDX root){
            TreeNodeSPDX node = swingUtils.createNodeChild(title,root);
            node.nodeType = nodeType;
            node.id = title;
            return node;
    }
    
    
    
    /**
     * Add the basic root node to a treeview
     * @param tree The treeview that we want to target
     */
    public static void nodeAddRoot(JTree tree){
     // tree hook
        tree.setCellRenderer(new TreeRenderer()); 
        //Create the nodes.
        TreeNodeSPDX nodeRoot =
            new TreeNodeSPDX("root");
        nodeRoot.id = "Root";
        DefaultTreeModel treeModel = new DefaultTreeModel(nodeRoot);
        tree.setModel(treeModel);
    }
    
    
    /**
     * List all the indexed SPDX documents on the tree view
     * @param tree where all items are listed
     */
    public static void populateTree(JTree tree){
        // tree hook
        tree.setCellRenderer(new TreeRenderer()); 
        //Create the nodes.
        TreeNodeSPDX nodeRoot =
            new TreeNodeSPDX("root");
        nodeRoot.id = "Root";
        
        //createNode("Home", NodeType.home, nodeRoot);
        
        
        // create the node for hosting our reports
        TreeNodeSPDX productNode = nodeCreate(
                "Reports (" + core.reports.list.size() + ")"
                , NodeType.other, nodeRoot);
        productNode.id = folder.reports;
        
        // add all SPDX documents that were found
            for(SPDXfile spdx : core.reports.list){
                addNodeSPDX(productNode, spdx);
            }
        
            
//        // now create our library node with all found components    
//        TreeNodeSPDX libraryNode = nodeCreate(
//                "Library (" + core.components.size() + ")"
//                , NodeType.other, nodeRoot);
//        libraryNode.id = "Library";
//        // add all SPDX documents that were found
//            for(SPDXfile spdx : core.components){
//                addNodeSPDX(libraryNode, spdx);
//            }

    // all finished, write this data on GUI tree list
        DefaultTreeModel treeModel = new DefaultTreeModel(nodeRoot);
        tree.setModel(treeModel);
    }
    
        /**
     * Given an SPDX object, create the tree nodes with information
     * @param root where the SPDX tree will be built upon
     * @param spdx the object with relevant SPDX information
     */
    public static void addNodeSPDX(TreeNodeSPDX root, SPDXfile spdx){
        // create the new node that is used as base, choose an ID
        TreeNodeSPDX node = swingUtils.createNodeChild("",root);
        node.nodeType = NodeType.sectionPackage;
        node.id = spdx.getId();
        // add the full object to ease representation
        node.setUserObject(spdx);
        // create the subnodes for creation information
        doNodeCreationInfo(node, spdx); 
        // add up all the fileSection
        doNodeFileInfo(node, spdx);
        // now we add the dependencies node
        doNodeDependencies(node, spdx);
        
        
//        TreeNodeSPDX nodeReviews = swingUtils.nodeCreate("Review",node);
//        nodeReviews.nodeType = NodeType.sectionReview;
        // all done, add this node on the tree structure
        root.add(node);
        
        // code for debugging
        //System.err.println(node.getUID());
        
    }
    
    
    /**
     * Adds the details of the creation info
     */
    static void doNodeCreationInfo(TreeNodeSPDX root, SPDXfile spdx){
        
        TreeNodeSPDX node = swingUtils.createNodeChild("",root);
        node.nodeType = NodeType.sectionCreator;
        node.id = "Creator";
        node.setUserObject(spdx.creatorSection);
        
        // now, create a node for each author
        for(Person person : spdx.creatorSection.people){
            swingUtils.addNodePerson(node, person);
        }
    }
    
    /**
     * Add the node of files if there are any available
     */
    static void doNodeFileInfo(TreeNodeSPDX root, SPDXfile spdx){
        
        int fileCount = spdx.fileSection.files.size();
        String counter = (fileCount > 0) ? " (" + fileCount + ")" : "";        
        
        TreeNodeSPDX node = swingUtils.createNodeChild("Files" + counter,root);
        node.nodeType = NodeType.sectionFile;
        node.id = "Files";
        
        for(FileInfo file : spdx.fileSection.files){
            TreeNodeSPDX fileNode 
                    = swingUtils.createNodeChild(
                    "" // name is inherited from toString() of the file object
                    , node);
            // define this node as a normal file
            fileNode.nodeType = NodeType.file;
            fileNode.id = file.getName();
            fileNode.setUserObject(file);
        }
        
    }  
    
    
    /**
     * Add nodes with the dependencies required for the SPDX package
     */
    static void doNodeDependencies(TreeNodeSPDX root, SPDXfile spdx){
        TreeNodeSPDX node = swingUtils.createNodeChild(
                "Dependencies ("
                + spdx.packageSection.dependencies.size()
                + ")"
                ,root);
        node.id = "Dependencies";
        
        for(TagValue dep : spdx.packageSection.dependencies){
            //System.err.println("FG09 - Added a dependency");
            TreeNodeSPDX depNode 
                    = swingUtils.createNodeChild(
                    dep.toString() // name is inherited from toString() of the file object
                    , node);
            // define this node as a normal file
            depNode.nodeType = NodeType.dependency;
            depNode.id = dep.toString();
            depNode.setIcon("box.png");
            depNode.setUserObject(dep);
        }
    }
   
    
  
    
     /**
      * Using the node currently selected on tree view, iterate
      * each node one level below until a package node is found
     * @param tree Where all the items are located on our UI
     * @return The SPDXfile node object
      */
     public static TreeNodeSPDX getNodePackage(JTree tree){
         TreeNodeSPDX node = swingUtils.getSelectedNode(tree);
         // preflight check
         if(node == null){
             return null;
         }
         
        // get the root package node
        while((node.getParent() != null)
                &&(node.nodeType != NodeType.sectionPackage)){
            node = (TreeNodeSPDX) node.getParent();
        }
        // extra safety check
        if(node.nodeType != NodeType.sectionPackage){
            return null;
        } 
        
        return node;
     }
     
     /**
      * Displays a simple text box on the screen
      * @param message 
      */
     static public void showMessage(String message){
        JOptionPane.showMessageDialog
                                (core.studio, message);
     }
     
     /**
      * Mark a given line as selected on a text box
     * @param lineNumber the line what we want to highlight
     * @param text Where the text is located and where we want to move
     * @param frame A specific UI where our approach is working
      */
     
     static public void moveToLine(int lineNumber, JEditorPane text,
             StudioUI4 frame){
         
         // do the selection part 
            Element selectedLine = text.getDocument()  
                                .getDefaultRootElement().getElement(lineNumber);
           
            if(selectedLine == null){
                return;
            }
        
            int 
                    lineStart = selectedLine.getStartOffset(),
                    lineEnd = selectedLine.getEndOffset();

            // jump to the desired line
            text.setCaretPosition(selectedLine.getStartOffset());
            text.setEditable(true);
            
            text.setSelectionStart(lineStart);
            text.setSelectionEnd(lineEnd-1);
            
             // we need to temporarily disable focus messages 
            // to avoid false positive cases 
            //TODO for some reason this is not working
//            frame.setDisableFocusMessages(true);
            text.requestFocusInWindow();
//            frame.setDisableFocusMessages(false);
            
     }
    

    /**
     * Selects a node from the tree list based on a specific ID string
     * @param UID the specific ID of the node to be selected
     */ 
    public static void setSelectedNode(String UID) {
        // we need to do some checking
        // if we are calling an SPDX, has it been loaded?
        if(UID.contains(".spdx >> Reports ")){
            // get the SPDX name
            String catch1 = " >> ./ >> ";
            int pos = UID.indexOf(catch1);
            String temp = UID.substring(pos + catch1.length()) ;
            // now get the SPDX node
            TreeNodeSPDX node = TreeviewUtils.getNode(">> " + temp);
            // if there is no children, do the reading
            if(node!= null && node.getChildCount() == 0){
                TreeviewUtils.spdxCreateNodeStructure(node);
            }
            
        }
        
        
        TreeNodeSPDX rootNode = (TreeNodeSPDX)
                core.studio.getTree().getModel().getRoot();
        Enumeration e = rootNode.preorderEnumeration();
        TreeNodeSPDX selectedNode = null;
        while(e.hasMoreElements()){
            TreeNodeSPDX currentNode = (TreeNodeSPDX) e.nextElement();
            String thisID = currentNode.getUID();//getId(currentNode);
            if(thisID.equalsIgnoreCase(UID)){
                selectedNode = currentNode;
                break;
            }
        }
        if(selectedNode != null){
            // make the node visible again on the tree
            JTree m_tree = core.studio.getTree();
            TreeSelectionModel model = m_tree.getSelectionModel();
            TreePath path;
            
            // we first select one of the children to ensure it gets expanded
            TreeNodeSPDX child = null;
            try{
            child = (TreeNodeSPDX) selectedNode.getFirstChild();
            } catch (Exception except){
                System.err.println("SU479 - No reports available");
            }
            
            try{
            
            if(child != null){
            path = new TreePath(child.getPath());
            // now out tree will expand the first child
            model.addSelectionPath(path);
            m_tree.setExpandsSelectedPaths(true);
            m_tree.setSelectionPath(path);  
            m_tree.scrollPathToVisible(path);   
            } 
            
            // second wave
            path = new TreePath(selectedNode.getPath());
            // what we really wanted is to highligh the father, so, go back!
            model.addSelectionPath(path);
            m_tree.setExpandsSelectedPaths(true);
            m_tree.setSelectionPath(path);  
            m_tree.scrollPathToVisible(path);    
            
            }catch(Exception ex){
                System.err.println("SU497 - Failed to select the treeview path");
            }
        }
    }
    
    
    
    
    
//    // find all components inside our common library
//        File baseFolder = new File(".");
////        core.components = actions.findSPDX(new File(baseFolder, 
////                is.library));
//        // now find our reports
//        core.reports = actions.findSPDX(new File(baseFolder, 
//                is.reports));
//        
//        // get the current UID of the selected node
//        if(UID.isEmpty()){
//            TreeNodeSPDX currentNode = swingUtils.getSelectedNode();
//            if(currentNode != null){
//                // the ID of currently selected node 
//                UID = currentNode.getUID();
//            }
//        }
//        // write our results on the tree
//        populateTree(tree);
//        
//        // get the list of RunPlugins going
//        RunPlugins.listPlugins();
//        log.write(is.INFO, Messages.ReadyToUse);
//        
//        // get back to the previoulsy selected node
//        swingUtils.setSelectedNode(UID);
//        // refresh things up
//        tree.repaint();
//        swingUtils.refreshTextBox();
  
    
    
    /**
     * This method forces the node currently selected
     * to be again re-selected, causing a page refresh
     * on the text box. This is useful to update values.
     */
    public static void refreshTextBox(){
        // get the node currently selected on the tree view
        TreeNodeSPDX node = getSelectedNode();
        if(node == null){
            return;
        }
        // All done, let's leave
        log.write(is.INFO, Messages.TreeNodeChanged, node.getUID());
    }

   
 
    
    /////////////////////////////////////////////////////////////////////////
    // Things related to show the SPDX text on the text area
    
     /**
     * Loads up the text for the currently selected package
     */
    private void showTextProductTabSPDX(JTree tree, JEditorPane text) {
      // display the text from the original spdx document
        TreeNodeSPDX node = swingUtils.getNodePackage(tree);
        // preflight check
        if(node == null){
            return;
        }
        
        // display our text file
        SPDXfile spdx = (SPDXfile) node.getUserObject();
        text.setEnabled(false);
        text.setContentType("text/plain");
        text.setText(spdx.rawText);
        //text.setCaretPosition(0);
        text.setEnabled(true);
        text.setEditable(true);
        
       
        
        // all done
        core.textWasModified = false;
        log.write(is.COMMAND, Messages.TextWasLoaded);
    }
    
    
      /**
     * SSDEEP is an object that needs to be handled separately since it includes
     * chars that confuse the interpreter
     * @param title Title to be used on the text
     * @param file The FileInfo object that contains SSDEEP information
     * @return 
     */
    public static String addSSDEEP(String title, FileInfo file) {
        // get the raw contents of this tag
        String text = file.tagFileChecksumSSDEEP.raw;
        // remove the tag header
        text = text.replace("FileChecksum: SSDEEP: ", "");
        swingUtils.addIfNotEmpty(title, text);
        return swingUtils.addIfNotEmpty(title, text);
    } 
    
    /**
     * Adds a tree node on the Swing UI
     * @param title Title that is read by the user
     * @param iconImage Specify an icon image from our local archive
     * @param nodeRoot The parent node where the new node will be attached
     * @return The newly created tree node
     */
    public static TreeNodeSPDX addNode(String title, String iconImage, 
            TreeNodeSPDX nodeRoot) {
        JTree tree = core.studio.getTree();
        TreeNodeSPDX node = swingUtils.nodeCreate(title, NodeType.other, nodeRoot);
        node.setIcon(iconImage);
        // all finished, write this data on GUI tree list
        nodeRoot = (TreeNodeSPDX) tree.getModel().getRoot();
        DefaultTreeModel treeModel = new DefaultTreeModel(nodeRoot);
        tree.setModel(treeModel);
        return node;
    }
    
     
    /**
     * When given a node, provide an HTML breadcrumb to serve as navigation
     * and title on the header of the page.
     * 
     * @param node The target node at the end of the tree path
     * @return HTML code showing the path to the curently selected node 
     */
    public static String getBreadcrumb(TreeNodeSPDX node){
        // preflight check
        if(node == null){
            return "";
        }
        // do the introduction of this file with a breadcrumb
        String[] fields = node.getUID().split(">>");
        String breadCrumb = 
                  fields[2]
                + ">"
                + fields[1]
                ;
        
        // prepare the result
        String result = 
                html.div()
                + "<h2>"
                + html.getCommonFolderIcon("wooden-box-label.png")
                + breadCrumb
                + "</h2>"
                + html._div
                ;
        return result;
    }
    
    
    public static boolean hasSelectedNode(String title){
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            return false;
        }
        // get the unique identifier
        String nodeUID = node.getUID();
        // are we clicking on the root of our intended node?
        if(nodeUID.equals(title + " ")){
            return true;
        }
        return false;
    }
    
   
     /**
     * A very tricky method that helps to extract the parameters from a META
     * refresh tag inside an HTML page. This is used at the Swing container
     * since JEditorPane does not support this kind of page refresh natively.
     * @param textHTML
     * @param delay
     * @param URL
     * @param parameters
     * @return 
     */
    public static MetaContainer getMetaRefresh(String textHTML, int delay, 
            String URL, ArrayList<String[]> parameters){
        // process the source code from the HTML page
        Source source=new Source(textHTML);
        // get all the elements
        List<net.htmlparser.jericho.Element> elements = source.getAllElements(HTMLElementName.META);
        // how many elements were found?
        //System.err.println("META 001, number of elements:" + elements.size());
        // go through only the meta elements
        for (net.htmlparser.jericho.Element element : elements) {
            // get them to lower case, find ours that is a refresh type
            String text = element.toString().toLowerCase();
            if(text.contains("http-equiv=")==false){
                continue;
            }
            // get specifically the time delay and URL
            String content = element.getAttributeValue("content");
            // this can't be empty
            if(content == null){
                System.err.println("META error 001: No content found");
                break;
            }
            // 5; URL=autoforward_target.html&id=1234
            // we have some content, let's split this thing
            if(content.contains("=") == false){
                System.err.println("META error 002: No = symbol was found");
                return null;
            }
            
            int pos = content.indexOf("=");
            // filter our number from the rest of the text
            delay = utils.text.justNumbers(content.substring(0,pos));
            // we use -1 as indicator that something went wrong
            if(delay == -1){
                System.err.println("META error 003: No delay value was found");
                return null;
            }
            // now go for the URL
            String temp = content.substring(pos +1);
            if(temp.contains("?")){
                // if we have parameters to report, split them here
                String[] portion = temp.split("\\?");
                URL = portion[0]; 
                String[] rawParameters = portion[1].split("&");
                for(String rawParameter : rawParameters){
                    String[] param = rawParameter.split("=");
                    parameters.add(param);
                }
                
            }else{
                // no parameters, just get the full thing
                URL = temp;
            }
            
            //System.err.println("delay=" + delay + "\n" + URL + "\n" + parameters.get(0)[1]);
            // We have found a match (avoid duplicate entries after this one)
            MetaContainer result = new MetaContainer();
            result.delay = delay;
            result.params = parameters;
            result.url = URL;
            
            // get the method that we want to run (if any)
            for(String[] item : parameters){
                if(item[0].toLowerCase().equals(is.methodExecute)){
                    result.scriptMethod = item[1];
                }
            }
            
            return result;
        }
        // nothing was found
        System.err.println("META error: Nothing was done");
        //System.err.println(textHTML);
        return null;
    }
    
    /**
     * Returns the node that is the root of a given treeview 
     * @param tree JTree object where all nodes are placed
     * @return the root node or null if it does not exist
     */
    public static TreeNodeSPDX getRootNode(JTree tree){
   // avoid empty null objects when there is nothing on the tree
        if(tree.getModel().getRoot()==null){
            return null;
        }
        TreeNodeSPDX nodeRoot = (TreeNodeSPDX) tree.getModel().getRoot();
    return nodeRoot;
    }
    
    
     // get a specific icon from our own library
    private static Icon getIcon(String what){
        return new ImageIcon(core.getIcon(what).getAbsolutePath());
    }

    
    /**
     * given a specific type of file extension, output an appropriate icon
     * @param fileInfo
     * @return 
     */
    public static Icon setIcon(FileInfo fileInfo) {

       if(fileInfo.fileCategory == FileCategory.IMAGE){
           return getIcon("document-image.png");
       }
       
       if(fileInfo.fileCategory == FileCategory.DOCUMENT){
           return getIcon("document-word.png");
       }
       
       if(fileInfo.fileCategory == FileCategory.SOURCE){
           return getIcon("document-code.png");
       }
       
       if(fileInfo.fileCategory == FileCategory.ARCHIVE){
           return getIcon("box.png");
       }
       
       if(fileInfo.fileCategory == FileCategory.SCRIPT){
           return getIcon("script-code.png");
       }
       
       if(fileInfo.fileCategory == FileCategory.VIDEO){
           return getIcon("document-film.png");
       }
      
       if(fileInfo.fileCategory == FileCategory.TEXT){
           return getIcon("document-list.png");
       }
      
       if(fileInfo.fileCategory == FileCategory.DATABASE){
           return getIcon("database.png");
       }
      
       if(fileInfo.fileCategory == FileCategory.CONFIG){
           return getIcon("document--pencil.png");
       }
      
       if(fileInfo.fileCategory == FileCategory.INTERNET){
           return getIcon("document-globe.png");
       }
       
       if(fileInfo.fileCategory == FileCategory.VERSIONING){
           return getIcon("document-clock.png");
       }
      
       
       if((fileInfo.fileCategory == FileCategory.SCHEMA)
               || ((fileInfo.fileCategory == FileCategory.OTHER))
               ){
           return getIcon("document-xaml.png");
       }
         
       if(fileInfo.fileCategory == FileCategory.BINARY){
           return getIcon("document-binary.png");
       }
     
       if(fileInfo.fileCategory == FileCategory.EXECUTABLE){
           return getIcon("compile.png");
       }
     
       if(fileInfo.fileCategory == FileCategory.TEMP){
           return getIcon("document-clock.png");
       }
     
       if(fileInfo.fileCategory == FileCategory.MUSIC
               || fileInfo.fileCategory == FileCategory.SOUND){
           return getIcon("document-music.png");
       }
     
       
         
       return getIcon("document.png");
    }
    
 
    /**
     * Based on a given treeview node, fire up the specified event just like
     * a normal user would have clicked on it.
     * @param node      A node from our treeview
     */
    public static void doRequest(TreeNodeSPDX node){
        WebRequest newRequest = new WebRequest();
                        newRequest.requestType = RequestType.NONE;
                        newRequest.requestOrigin = RequestOrigin.GUI_tree;
                        newRequest.BaseFolder = node.scriptFolder;
                        newRequest.scriptFile = node.scriptFile;
                        newRequest.scriptFolder = node.scriptFolder;
                        newRequest.scriptMethod = node.scriptMethod;
                        newRequest.parameters = node.scriptParameters;
                        controller.process(newRequest);
    }
    
    
}
