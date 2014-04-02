/**
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de)
 * Created: 2013-12-15T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: TreeNodeDetails.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright (c) 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> This plugin adds up more details on the tree view 
 * whenever the user clicks on a given SPDX document </text> 
 */

package basic;

import GUI.NodeType;
import GUI.TreeNodeSPDX;
import GUI.swingUtils;
import definitions.Messages;
import definitions.definition;
import definitions.is;
import java.awt.Cursor;
import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import main.core;
import main.param;
import script.Plugin;
import script.log;
import spdxlib.FileCategory;
import spdxlib.FileInfo;
import spdxlib.Person;
import spdxlib.SPDXfile;

/**
 *
 * @author Nuno Brito, 15th of December 2013 in Darsmtadt, Germany
 */
public class TreeNodeDetails extends Plugin{

    
    @Override
    public void startup(){
        // react whenever a tree node is changed
        log.hooks.addAction(Messages.TreeNodeChanged, thisFile, "react");
    }
    

    /**
     * Displays a basic list of tools that are supported
     */
    public void react(){ // ensure we get to know which node is selected
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // no need to continue if there is nothing selected
        if(node == null){
            return;
        }
        
        // we only want SPDX documents from this point forward
        if(node.nodeType != NodeType.SPDX){
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
        
        
        // all done, time to refresh things up
        swingUtils.setSelectedNode(node.getUID());
        // refresh things up
        core.studio.getTree().repaint();
        
    }
    
    
    /**
     * Add the files inside this SPDX document
     */
    private void addFiles(SPDXfile spdx, TreeNodeSPDX spdxNode){
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
        doTreeStructure(node, spdx);
        // if an exception occurs, this next line doesn't happen..
        core.studio.getTree().setCursor(Cursor.getDefaultCursor());
       
        
    }
    
    
    /**
     * Creates a tree of folders and respective files
     * @param root
     * @param spdx 
     */
    private void doTreeStructure(TreeNodeSPDX root, SPDXfile spdx){
        
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
            
            //String parentFolder = getParentFolder(path);
            // add it up to our list
            TreeNodeSPDX folderNode = addNodeFolder(root, path);
            // put in our cached list
            //path = path.substring(0, path.length() -1);
            nodeList.put(path, folderNode);
            // ./jfreechart-1.0.17/lib/
            //System.err.println("Placing path: " + path);
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
            nodeFile.setUserObject(fileInfo);
            // set a specific icon for this item
            nodeFile.icon = swingUtils.setIcon(fileInfo);
            
            // add this file to the parent path
            pathNode.add(nodeFile);
        }
    }

    
    /**
     * Adds a given folder as child from a specific folder
     */
    private TreeNodeSPDX addNodeFolder(TreeNodeSPDX root, String newFolder){
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
    private TreeNodeSPDX createTheOne(TreeNodeSPDX root, String what){
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
     * Does a given node contain a child with a specific ID?
     * @return 
     */
    private TreeNodeSPDX getNode(TreeNodeSPDX where, String what){
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
     * Tries to find a node with a given ID from a given 
     * node as root location
     * @param what
     * @return 
     */
    private TreeNodeSPDX findTheOne(TreeNodeSPDX where, String what){
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
     * Returns the parent path (if available)
     */
    private String getParentFolder(String path){
        // we need to count the number of slashes
        int lengthOriginal = path.length();
        String temp = path.replace("/", "");
        // do we have at least two slashes?
        if(lengthOriginal > (temp.length() + 1)){
            // get everything up to last slash
            return path.substring(0, path.lastIndexOf("/"));
        }
        // we have nothing, return the root folder
        return "./";
    }
    
    
    /**
     * Returns the path portion from a given FileInfo object
     * @return 
     */
    private String getFilePath(FileInfo fileInfo){
        
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
     * When necessary, add nodes listing the people that have created the SPDX
     * document. If these nodes were already created, do nothing
     */
    private void addPeople(SPDXfile spdx, TreeNodeSPDX spdxNode){
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
    
   
    
}
