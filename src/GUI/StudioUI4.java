/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-01-13T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: StudioUI4.java
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The initial GUI for the end-users </text>
 */
package GUI;

import definitions.Messages;
import definitions.is;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Element;
import javax.swing.text.html.FormSubmitEvent;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import main.controller;
import main.coreGUI;
import main.engine;
import script.RunPlugins;
import main.script.log;
import spdxlib.FileInfo;
import spdxlib.FileOrigin;
import spdxlib.SPDXfile;
import spdxlib.swing.NodeType;
import spdxlib.swing.TreeNodeSPDX;
import utils.internet;
import www.RequestOrigin;
import www.RequestType;
import www.WebRequest;

/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public class StudioUI4 extends javax.swing.JFrame {

    /**
     * Is the mouse over the back-button?
     */
    private void doMouseOverButton() {
//        if(button.isEnabled()){
//            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        }else{
//            button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//        }
    }

    // what kind of clicks do we have?
    enum ClickType {LEFT, RIGHT, NONE}
    // what was the last type of click that was made?
    ClickType lastClick = ClickType.NONE;
    
    // helps to avoid loading the same information multiple times
    TreeNodeSPDX lastNodeSelected;
    
    // what was the last product that was marked as selected?
//    public SPDXfile productSelected = null;
    
    private final SearchType searchTextDefault = SearchType.Files;
    // we can permit our search box to do different actions
    private SearchType searchProvider = SearchType.Files;
    
    // where we store a track of the previous page
    private Page 
            lastPage = new Page();
            //currentPage = new Page();
    
    private File 
            baseFolderPresent = null,
            baseFolderPast = null,
            baseFilePresent = null,
            baseFilePast = null;
    
    // to measure time between mouse clicks
    boolean isAlreadyOneClick;
    
    boolean firstClickActive = false;
    boolean secondClickActive = false;
    
    /**
     * Creates new form StudioUI2
     */
    public StudioUI4() {
        // adopt the default user interface menus and buttons
        try {
            
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            //UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
            
        } catch (ClassNotFoundException ex) {} catch (IllegalAccessException ex) {
        } catch (InstantiationException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        // get the window icon working
        URL imgURL = this.getClass().getResource(is.defaultIcon);
        setIconImage(Toolkit.getDefaultToolkit().getImage(imgURL));
        
        initComponents();
        
        // place the frame on the middle of the screen
        setLocationRelativeTo(null);
        // change the background to full white
        //getContentPane().setBackground( Color.WHITE );
        //doSettings();
    }

    
    /**
     * The settings related to the treeview
     */
    public void doSettingsTreeview(){
        // the basic root node that is always needed
        swingUtils.nodeAddRoot(tree);
        // now add all reports that we can find
        TreeviewUtils.spdxAddFullTree();
        // get the list of RunPlugins going
        RunPlugins.listPlugins();
        log.write(is.INFO, Messages.ReadyToUse);
        
        
        // this is needed to ensure we get line-wrapping
        jScrollPane2.setViewportView(text);

    }
    
    public void doSettings() {
        // setup the treeview
        doSettingsTreeview();
        

//        Thread thread = new Thread(){
//                @Override
//                public void run(){
//                    utils.time.wait(1);
//                 log.write(is.INFO, Messages.ReadyToUse);
//                }
//                };
//            thread.start();
            
        // ensure that the search box is the selected component
        setSearchProvider(this.searchTextDefault);
        search.requestFocusInWindow();

        // solve a bug we have on the screen
        this.editorPane(is.contentHTML, true, 0, "");

        // do the front screen
        callFrontScreen();

        // capture the clicks on HTML content
        doFormInterception();
        
        // disable the back button
        //button.setEnabled(false);
        // select the tree as first topic
        tree.requestFocus();
        
        // change colors on the HTML background
        panelEast.setBackground(coreGUI.backgroundColor);
        
        // add a border on the search bar
        search.setBorder(BorderFactory.createCompoundBorder(
            search.getBorder(), BorderFactory.createEmptyBorder(5, 12, 5, 5)));
        
        // add a border on the HTML box
        text.setBorder(BorderFactory.createCompoundBorder(
            text.getBorder(), BorderFactory.createEmptyBorder(5, 12, 5, 12)));
        
                
        // expand the first treeview node by default
        try{
        TreeNodeSPDX nodeReports = TreeviewUtils.getNodeReports();
        if(nodeReports != null){
              swingUtils.setSelectedNode(nodeReports.getUID());
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        
         // change our title
        setTitle("TripleCheck reporter");
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuItem_Delete = new javax.swing.JMenuItem();
        popupMenuFile = new javax.swing.JPopupMenu();
        menuItem_AddToComponent = new javax.swing.JMenuItem();
        menuItem_DefineLicense = new javax.swing.JMenuItem();
        menuItem_MarkFileAuthored = new javax.swing.JMenuItem();
        menuItem_MarkFileExternal = new javax.swing.JMenuItem();
        menuItem_MarkFileAutomated = new javax.swing.JMenuItem();
        menuItem_MarkFileMixed = new javax.swing.JMenuItem();
        menuItem_MarkFileModified = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        panelWest = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        panelEast = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        text = new javax.swing.JEditorPane();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        menuItem_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cross-script.png"))); // NOI18N
        menuItem_Delete.setText("Delete");
        menuItem_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSomethingClicked(evt);
            }
        });

        popupMenuFile.setLabel("Mark as..");

        menuItem_AddToComponent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paper-bag--plus.png"))); // NOI18N
        menuItem_AddToComponent.setText("Add to component");
        menuItem_AddToComponent.setToolTipText("Add selected files to a software component");
        menuItem_AddToComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_AddToComponentActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuItem_AddToComponent);

        menuItem_DefineLicense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/medal--plus.png"))); // NOI18N
        menuItem_DefineLicense.setText("Define license");
        menuItem_DefineLicense.setToolTipText("What is the license concluded as applicable to this resource?");
        menuItem_DefineLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_DefineLicenseActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuItem_DefineLicense);

        menuItem_MarkFileAuthored.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fingerprint.png"))); // NOI18N
        menuItem_MarkFileAuthored.setToolTipText("Resource developed by ourselves");
        menuItem_MarkFileAuthored.setLabel("Mark file as authored (original)");
        menuItem_MarkFileAuthored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_MarkFileAuthoredActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuItem_MarkFileAuthored);

        menuItem_MarkFileExternal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/box-label.png"))); // NOI18N
        menuItem_MarkFileExternal.setToolTipText("Made externally by a third-party provider");
        menuItem_MarkFileExternal.setLabel("Mark file as 3rd party resource");
        menuItem_MarkFileExternal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_MarkFileExternalActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuItem_MarkFileExternal);

        menuItem_MarkFileAutomated.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/box-resize.png"))); // NOI18N
        menuItem_MarkFileAutomated.setToolTipText("Generated automatically, no changes by author");
        menuItem_MarkFileAutomated.setLabel("Mark file as auto-generated");
        menuItem_MarkFileAutomated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_MarkFileAutomatedActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuItem_MarkFileAutomated);

        menuItem_MarkFileMixed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document-number.png"))); // NOI18N
        menuItem_MarkFileMixed.setToolTipText("Generated automatically and then modified by author");
        menuItem_MarkFileMixed.setLabel("Mark as modified auto-generated file");
        menuItem_MarkFileMixed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_MarkFileMixedActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuItem_MarkFileMixed);

        menuItem_MarkFileModified.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/receipt--pencil.png"))); // NOI18N
        menuItem_MarkFileModified.setText("Mark file as modified");
        menuItem_MarkFileModified.setToolTipText("Developed by a third-party and modified by author");
        menuItem_MarkFileModified.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_MarkFileModifiedActionPerformed(evt);
            }
        });
        popupMenuFile.add(menuItem_MarkFileModified);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TripleCheck");
        setLocationByPlatform(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                frameKeypressed(evt);
            }
        });

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(200);

        panelWest.setAutoscrolls(true);
        panelWest.setPreferredSize(new java.awt.Dimension(172, 362));

        tree.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 2, 5, 5));
        tree.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        tree.setAutoscrolls(true);
        tree.setLargeModel(true);
        tree.setRootVisible(false);
        tree.setRowHeight(18);
        tree.setToggleClickCount(1);
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeeventTreeMouseClicked(evt);
            }
        });
        panelWest.setViewportView(tree);

        jSplitPane1.setLeftComponent(panelWest);

        panelEast.setBackground(java.awt.Color.white);
        panelEast.setBorder(null);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel3.setBorder(null);

        text.setBorder(null);
        text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFocusLost(evt);
            }
        });
        text.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textPropertyChange(evt);
            }
        });
        text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(text)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );

        jScrollPane2.setViewportView(jPanel3);

        search.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        search.setText("Search..");
        search.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        search.setMargin(new java.awt.Insets(2, 18, 2, 2));
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchdoSearchKeypress(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchdoSearch(evt);
            }
        });

        jLabel1.setText(" ");

        javax.swing.GroupLayout panelEastLayout = new javax.swing.GroupLayout(panelEast);
        panelEast.setLayout(panelEastLayout);
        panelEastLayout.setHorizontalGroup(
            panelEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
            .addGroup(panelEastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelEastLayout.setVerticalGroup(
            panelEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEastLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(panelEast);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void frameKeypressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frameKeypressed
    }//GEN-LAST:event_frameKeypressed

    private void treeeventTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeeventTreeMouseClicked

        // are we handling a right-click event?
        if (SwingUtilities.isRightMouseButton(evt)) {
            processRightClickTreeview(evt);
            return;
        }
        
        if(firstClickActive){
            doTreeNodeChanged(true);
            firstClickActive = false;
            secondClickActive = true;
            return;
        }
        
        if(secondClickActive==false){
         timeBombOneClick(250);
         firstClickActive = true;
        }
        // define what was the last type of click
        lastClick = ClickType.LEFT;
    }//GEN-LAST:event_treeeventTreeMouseClicked
    
    
    /**
     * This method will handle what happens when the end-user uses the mouse
     * right-click button.
     * @param evt 
     */
    void processRightClickTreeview(java.awt.event.MouseEvent evt){
        // get the place where the right-click occurred
        int row = tree.getClosestRowForLocation(evt.getX(), evt.getY());
        // mark the new selection on our treeview
        //tree.setSelectionRow(row);
        tree.addSelectionRow(row);
        // get the selected nodes
        ArrayList<TreeNodeSPDX> nodeList = swingUtils.getSelectedNodes(tree);

        // correct a defect that might happen. The first node selected by
        // default is "files". When the user-right clicks another files inside
        // the three structure, since the "files" node is selected then the
        // action will be applied to all nodes within. Causing unwanted overwrite
        for(TreeNodeSPDX thisNode : nodeList){
            //System.err.println(thisNode.nodeType);
            // we can't have the root selected, this causes confusion
            if(thisNode.nodeType == NodeType.sectionFile){
                tree.setSelectionRow(row);
            }
        }
        
        // avoid right clicks when root node is selected
        if(nodeList.size()>1){
            for(TreeNodeSPDX thisNode : nodeList){
                // we can't have the root selected, this causes confusion
                if(thisNode.nodeType == NodeType.reportsHome){
                    tree.setSelectionRow(row);
                    //System.err.println("SU405 - Choosing only last node");
                    break;
                }
            }
        }
        
        // remove double-right clicks
        if(nodeList.size()>1){
            if(lastClick == ClickType.RIGHT){
                tree.setSelectionRow(row);
            }
        }
        
        TreeNodeSPDX node = swingUtils.getSelectedNode();
//        // preflight check
//        if(node == null){
//            // nothing to do, just leave
//            return;
//        }
        // now show the popup menu as needed
        doPopupMenu(node, evt);
        // define what was the last type of click
        lastClick = ClickType.RIGHT;
    }
    
    
    /**
     * Handles the right-click menu when the user wants to perform an action
     * on the treeview
     */
    void doPopupMenu(TreeNodeSPDX node, java.awt.event.MouseEvent evt){

        // create the menu
        JPopupMenu popupMenu = new JPopupMenu();
    
//        // we only care about SPDX files here
        if(node.nodeType == NodeType.SPDX){
            popupMenu.add(menuItem_Delete);
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
           // shouldShow = true;
            return;
        }
       
         // allow to change triggers on files and folders
        if((node.nodeType == NodeType.file)
           ||(node.nodeType == NodeType.folder)
           ||(node.nodeType == NodeType.sectionFile)
                ){
            popupMenuFile.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    /**
     * Initiates the count-down to launch the click operation
     */
    private void timeBombOneClick(int time){
        Timer t = new Timer("doubleclickTimer", false);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                // only proceed if no second click occurred in the meanwhile
                if(secondClickActive == false){
                    doTreeNodeChanged(false);
                } 
                firstClickActive = false;
                secondClickActive = false;
            }
        }, time);
    }
    
    
    private void textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusGained
    }//GEN-LAST:event_textFocusGained

    private void textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusLost
    }//GEN-LAST:event_textFocusLost

    private void textPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textPropertyChange
    }//GEN-LAST:event_textPropertyChange

    private void textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textKeyTyped
    }//GEN-LAST:event_textKeyTyped

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        doSearchMouseClicked();
        coreGUI.searchBoxActive = true;
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        doSearchMouseClicked();
        // reset back to the default value when empty
        if(search.getText().isEmpty()){
            search.setText(searchTextDefault.getSearchBoxText());
        }
        coreGUI.searchBoxActive = false;
    }//GEN-LAST:event_searchFocusLost

    private void searchdoSearchKeypress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdoSearchKeypress

    }//GEN-LAST:event_searchdoSearchKeypress

    private void searchdoSearch(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdoSearch
        performSearch(evt);
    }//GEN-LAST:event_searchdoSearch

    private void deleteSomethingClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSomethingClicked
        deleteSomething();
    }//GEN-LAST:event_deleteSomethingClicked

    private void menuItem_DefineLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_DefineLicenseActionPerformed
        licenseSelectOpenDialog();
    }//GEN-LAST:event_menuItem_DefineLicenseActionPerformed

    private void menuItem_MarkFileAuthoredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_MarkFileAuthoredActionPerformed
        markFileOriginAs(FileOrigin.AUTHORED);
    }//GEN-LAST:event_menuItem_MarkFileAuthoredActionPerformed

    private void menuItem_MarkFileExternalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_MarkFileExternalActionPerformed
        markFileOriginAs(FileOrigin.EXTERNAL);
    }//GEN-LAST:event_menuItem_MarkFileExternalActionPerformed

    private void menuItem_MarkFileAutomatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_MarkFileAutomatedActionPerformed
        markFileOriginAs(FileOrigin.AUTOMATED);
    }//GEN-LAST:event_menuItem_MarkFileAutomatedActionPerformed

    private void menuItem_MarkFileMixedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_MarkFileMixedActionPerformed
         markFileOriginAs(FileOrigin.AUTOMIXED);
    }//GEN-LAST:event_menuItem_MarkFileMixedActionPerformed

    private void menuItem_MarkFileModifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_MarkFileModifiedActionPerformed
        markFileOriginAs(FileOrigin.MODIFIED);
    }//GEN-LAST:event_menuItem_MarkFileModifiedActionPerformed

    private void menuItem_AddToComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_AddToComponentActionPerformed
        showDialogAddFilesToComponent();
    }//GEN-LAST:event_menuItem_AddToComponentActionPerformed

    
    /**
     * Has the end-user clicked on the option to open the right-click menu
     * for changing licenses of a given set of files?
     */
    void licenseSelectOpenDialog(){
        // get the selected node
        ArrayList<TreeNodeSPDX> selectedNodes = swingUtils.getSelectedNodes(tree);
        
        ArrayList<TreeNodeSPDX> nodeList = new ArrayList();
        // get only the relevant nodes
        for(TreeNodeSPDX node : selectedNodes){
              // crawl into folders as needed
            if((node.nodeType == NodeType.folder)
                    ||(node.nodeType == NodeType.sectionFile)){
                TreeviewUtils.getNodes(node, nodeList, NodeType.file);
            }else
            // add the files directly
            if(node.nodeType == NodeType.file){
                nodeList.add(node);
            }
        }
        
        // just need to open one
        if(nodeList.isEmpty()){
            return;
        }

        log.write(is.INFO, "Opening license dialog");
        File script = new File(engine.getPluginsFolder(), "licenses/choose.java");
        // now do the parameters
        ArrayList<String[]> parameters = new ArrayList();
        String nodeUID = "";
        // do the list of nodes that we would like to change
        for(TreeNodeSPDX thisNode : nodeList){
            nodeUID += thisNode.getUID() + ";";
        }
        // add them up as parameter to our request
        String[] param = new String[]{nodeUID};
        parameters.add(param);
        // fire up the request
        TreeviewUtils.doRequest(script, "selectLicense", parameters);
    }
    
    
    /**
     * This method will delete a given SPDX document when selected from the
     * treeview menu item
     */
    void deleteSomething(){
        // get the selected node
        TreeNodeSPDX node = swingUtils.getSelectedNode();
        // preflight check
        if(node == null){
            // nothing to do, just leave
            return;
        }
        // we only care about SPDX files here
        if(node.nodeType != NodeType.SPDX){
            return;
        }

        
        File file = (File) node.getUserObject();
        
//        // no need to continue if the file does not exist
//        if(file.exists() == false){
//            return;
//        }
//        
        // output the message that we are deleting an SPDX
        log.write(is.DELETING,"SPDX to remove: %1", file.getAbsolutePath());
        // now delete the file
        engine.reports.delete(file);
        
//        // do the deletion
//        file.delete();
        // refresh all the contents
        //node = tree.
        //String UID = (String) engine.temp.get(is.reports);
        String UID = TreeviewUtils.getNodeReports().getUID();
        
        TreeviewUtils.refreshAll(UID, true);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem menuItem_AddToComponent;
    private javax.swing.JMenuItem menuItem_DefineLicense;
    private javax.swing.JMenuItem menuItem_Delete;
    private javax.swing.JMenuItem menuItem_MarkFileAuthored;
    private javax.swing.JMenuItem menuItem_MarkFileAutomated;
    private javax.swing.JMenuItem menuItem_MarkFileExternal;
    private javax.swing.JMenuItem menuItem_MarkFileMixed;
    private javax.swing.JMenuItem menuItem_MarkFileModified;
    private javax.swing.JPanel panelEast;
    private javax.swing.JScrollPane panelWest;
    private javax.swing.JPopupMenu popupMenuFile;
    private javax.swing.JTextField search;
    private javax.swing.JEditorPane text;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables

    
    public JTree getTree(){
        return tree;
    }

    /**
     * React whenever the user wants to start a search
     */
    private void doSearchMouseClicked() {
        String currentTerm = search.getText();
        if(currentTerm.equals(searchProvider.getSearchBoxText())){
            search.setText("");
        }
    }

    /**
     * Interprets the keys being pressed on the search box
     * @param evt the keystroke
     */
    private void performSearch(KeyEvent evt) {
        // people expect to press "ESC" to clear the whole bar
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            search.transferFocus();
            //System.err.println("SU00 - Pressed ESCAPE on search box");
            log.write(is.COMMAND, Messages.SearchBoxPressedESCAPE);
            search.setText(searchTextDefault.getSearchBoxText());
            return;
        }
        
        // ENTER means that we are serious about the current search term
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            log.write(is.COMMAND, searchProvider.getHook());
            return;
        } 

        // if the box is empty and someone presses backspace, then do nothing
        Boolean emptyBox = search.getText().isEmpty();
        Boolean backspacePressed = evt.getKeyCode() == KeyEvent.VK_BACK_SPACE;
        if((emptyBox)&&(backspacePressed)){
            // the result is empty, but make sure we clean up the results box
            text.setText("");
            return;
        }
        
        
        // there is a bug that allows people to write over the "search" default
        if(search.getText().isEmpty()){
            search.setText(searchTextDefault.getSearchBoxText());
            coreGUI.key.clear();
            return;
        }
        
        
        
        // there is a bug that allows people to write over the "search" default
        if(search.getText().startsWith(searchTextDefault.getSearchBoxText())){
            String temp = search.getText().replace(searchTextDefault.getSearchBoxText(), "");
            search.setText(temp);
        }
        
        // indicate that a key was pressed, this keeps the buffer alive
        coreGUI.key.pressedKey("x");
            
    }
    
    /**
     * Provides public access to the search box
     * @return the JTextfield representing the search box
     */
    public JTextField getSearch(){
        return search;
    }
    
    /**
     * Process the clicks on HTML hyperlinks at the text form
     */
    private void doFormInterception() {
         // add the URL interception
        HTMLEditorKit kit = (HTMLEditorKit) text.getEditorKit();
        kit.setAutoFormSubmission(false);
        text.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                processActionGUI(e);
            }
        });
    }

   
    /**
     * Moves the text box to the last line
     */
    public void textMoveToBottom(){
        // doesn't work.
        try{
        text.setCaretPosition(text.getText().length() - 1);
        }catch (Exception e){
        
        }
    }
    
    
    /**
     * This method is helpful to centralise the control of the
     * JEditorTextPane that has a prominent action in our tool.
     * This is the text area where the content of SPDX files are
     * displayed and at the same time the place where all other
     * actions such as search operations take place. Before this
     * method existed, it was a complete mess and very difficult
     * to make changes to all the occurences throughout the code
     * where this object was called/changed.
     * @param contentType
     * @param editable
     * @param caretPosition
     * @param content 
     */
    public void editorPane(String contentType, Boolean editable,
            int caretPosition, String content){

        this.editorPane(contentType, editable, caretPosition, content, true,
                null);
    }
    
  
    /**
     * This method is helpful to centralize the control of the
     * JEditorTextPane that has a prominent action in our tool.
     * This is the text area where the content of SPDX files are
     * displayed and at the same time the place where all other
     * actions such as search operations take place. Before this
     * method existed, it was a complete mess and very difficult
     * to make changes to all the occurrences throughout the code
     * where this object was called/changed.
     * @param contentType
     * @param editable
     * @param caretPosition
     * @param cache Should this change be stored in the cache or not?
     * @param content 
     * @param request 
     */
    public void editorPane(String contentType, Boolean editable,
            int caretPosition, String content, Boolean cache, 
            WebRequest request){
        
        
         // we don't need empty content
        if(content == null || content.isEmpty()){
            System.err.println("SU857 - Empty content on editor pane");
            return;
        }
        
        // sometimes we don't need to save the previous page
            if(cache){
                // save settings from the current page before writing a new one
                lastPage.contentType = text.getContentType();
                lastPage.content = text.getText();
            }
            
            // set the new content, first the type and then the text
            text.setContentType(contentType);
            
            try{
                // now write the text
                text.setText(content);
            }catch (Exception e){
                System.err.println("SU851 - Exception occurred while outputting text");
            }
            // disable this box if you don't need to see the output on a file
            //utils.files.SaveStringToFile(new File("output.html"), content);
                    
            // should the "go back" button be enabled?
            //button.setEnabled(true);
        
            // change the cursor position
            if(caretPosition > -1)
                text.setCaretPosition(caretPosition);
        
            // can we edit or not the text box?
            text.setEditable(editable);
            if(editable){
                // this is needed to workaround a defect in text/plain mode
                text.setCursor(Cursor.getDefaultCursor());
            }
           
             // no point to continue if the request is empty
            if(request == null){
                baseFolderPresent = null;
                return;
            }
            
            // keep track of what was executed last time
            if(request.scriptFile != null){
                baseFilePast = baseFilePresent;
                baseFilePresent = request.scriptFile;
            }else{
                baseFilePast = null;
                baseFilePresent = null;
            }
            
           
            
            // this is necessary to load pages from the same folder
            baseFolderPast = baseFolderPresent;
            baseFolderPresent = request.BaseFolder;

            // important step, sometimes we just want to define a page on disk
            if(request.hasPage()){
                try {
                    text.setPage(request.getPage());
                } catch (IOException ex) {
                    Logger.getLogger(StudioUI4.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            
            
        
      /**
       * A very tricky implementation. We use the code below to find the cases
       * where it is expected to support a refresh tag.
       */
        final String beacon  = "http-equiv=\"refresh\"";
        if(text.getText().contains(beacon)){
                     Thread thread = new Thread(){
                @Override
                public void run(){
     
                    String textsnip = text.getText();
                    // declare our variables
                    MetaContainer x = new MetaContainer();
                    // process the meta refresh tag
                    MetaContainer meta = swingUtils.getMetaRefresh(textsnip, 
                            x.delay, x.url, x.params);
                    if(meta == null){
                        return;
                    }
                  
                    // mandatory waiting by the refresh tag
                    utils.time.wait(meta.delay);
                    // if there is no .java URL mentioned, add one
                    String processedURL = meta.url;
                    if(processedURL.endsWith(".java")== false){
                       processedURL += ".java";
                    }
                    // create our jump
                    File jump = new File(engine.getPluginsFolder(), processedURL);
                    WebRequest newRequest = new WebRequest();
                    newRequest.requestType = RequestType.NONE;
                    newRequest.requestOrigin = RequestOrigin.GUI;
                    newRequest.BaseFolder = jump.getParentFile();
                    newRequest.scriptFile = jump;
                    newRequest.scriptFolder = jump.getParentFile();
                    newRequest.scriptMethod = meta.scriptMethod;
                    newRequest.parameters = meta.params;
                    controller.process(newRequest);
                }
            };
            thread.start();
            }
            
    }

    /**
     * Nothing more than going back when possible
     */
    private void doBackButton() {
        // restore previous page
        editorPane(
                lastPage.contentType, 
                lastPage.editable, 
                lastPage.carotPosition, 
                lastPage.getText());
        // destroy the old page
        lastPage = new Page();
        baseFolderPresent = baseFolderPast;
        baseFilePresent = baseFilePast;
        // disable button
        //button.setEnabled(false);
    }

  

    /**
     * Whenever a tree node has changed, fire up an action
     */
    private void doTreeNodeChanged(final Boolean doubleClick) {
        final TreeNodeSPDX node = swingUtils.getSelectedNode();
        if(node == null){
            return;
        }

        
        if(doubleClick){
            engine.temp.put(is.doubleClick, node);
            log.write(is.INFO, Messages.TreeNodeDoubleClick, node.getUID());
            return;
        }
              
     
        // do we have a script associated with this node?
        if(node.scriptFile != null){
            // launch a small thread to speed things up here
               Thread thread = new Thread(){
                   @Override
                   public void run(){
                       swingUtils.doRequest(node);
                   }
               };
               thread.start();
        }
        // now execute the addon actions
        log.write(is.INFO, Messages.TreeNodeChanged, node.getUID());
        
        // change the search provider if needed
        switch(node.nodeType){
            case sectionFile:
            case none:
            case root:
            case sectionCreator:
            case sectionPackage:
            case sectionSettings:
            case sectionExport:
            case home:
            case SPDX:
            case folder:
            case file: this.setSearchProvider(SearchType.Files);break;
        
        }
    }

    /**
     * The main point entry for actions that take place on the Swing GUI
     * component where the HTML text is displayed
     * @param e 
     */ 
    private void processActionGUI(HyperlinkEvent e){
        // an action happened and needs a reply
        WebRequest webRequest = new WebRequest();
        // signal that this request is coming from the user interface
        webRequest.requestOrigin = RequestOrigin.GUI;
        webRequest.BaseFolder = baseFolderPresent;

        // now react to forms being submitted
        if (e instanceof FormSubmitEvent) {
            webRequest.requestType = RequestType.FORM;
            processFormSubmit(webRequest, e);
//            System.err.println("SU006 - Processed FORM");
            return;
        }

        // react to hyperlinks being clicked
        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            webRequest.requestType = RequestType.LINK;
            // Do something with e.getURL() here
            processLinkClicked(webRequest, e.getDescription());
            //System.err.println("SU007 - LINK: " + e.getURL());
          //  return;
        }
    }
    
    
    /**
     * What do we do when a link is clicked by the user?
     * @param text The URL that is desired
     */
    private void processLinkClicked(WebRequest request, String text) {
        // we always process strings in lower case to ease identification
        String URL = text;//.toLowerCase();
        log.write(is.INFO, "SU2006- clicked on link %1", URL);
        
        // this is an internal link that needs to be followed
        if(URL.startsWith("/")){
            String script;
            String parameters = "";
           
                if(URL.contains("?")){
                    String[] part = text.split("\\?");
                    script = part[0];
                    parameters= part[1];
                }else{
                    script = text; 
                }
            // execute the link request
            processFormSubmit2(request, script, parameters);
            return;
        }
        
        
        if(URL.startsWith("?")){
            //?x=full&spdx=jfreechart-1.0.17.tar.gz.spdx
            // remove the "?" from the string
            String parameters = URL.substring(1);
            
            // the script can't have the full path defined, just a relative path
            String temp = baseFilePresent.getAbsolutePath();
            String script = temp.replace(engine.getPluginsFolder().getAbsolutePath(), "");
//            request.
                
            // execute the link request
            processFormSubmit2(request, script, parameters);
            return;
        }
        
        // normal web link, open in browser
        if(URL.startsWith("http://")){
            internet.openURL(text);
            log.write(is.COMMAND, "Opening URL: %1", URL);
            // nothing else to be done
            return;
        }
        
        // web(secure) link, open in browser
        if(URL.startsWith("https://")){
            internet.openURL(text);
            log.write(is.COMMAND, "Opening secure URL: %1", URL);
            // nothing else to be done
            return;
        }
        
        // process internal node links
        if(text.startsWith("nodeId://")){
            text = text.replace("nodeId://", "");
            log.write(is.COMMAND, "Selecting node: %1", text);
            swingUtils.setSelectedNode(text);
            log.write(is.INFO, Messages.TreeNodeChanged, text);
            return;
        }
        
        // launch a script
        if(text.startsWith("script://")){
            text = text.replace("script://", "");
            int pos = text.indexOf(">>");
            String filename = text.substring(0, pos);
            File scriptFile = new File(filename);
            String method = text.substring(pos + 2);
            engine.script.runJava(scriptFile, method, is.plugin);
            return;
        }
        
        // do a search inside our tool/library
        if(URL.startsWith("search://")){
            text = text.replace("search://", "");
            coreGUI.searchTerm = text;
            log.write(is.COMMAND, "Search: %1", text);
            //return;
        }
        
        
        
            // handle the case:
            // create?x=folder
            int sep = URL.indexOf("?");
            
            // get parameters found after the "?" mark
            String parameters = URL.substring(sep + 1);
            
            // the script can't have the full path defined, just a relative path
            String temp = baseFilePresent.getAbsolutePath();
            String script = temp.replace(engine.getPluginsFolder().getAbsolutePath(), "") 
                    //+ "/" + URL.substring(0, sep)
                    ;
//            request.
                
            // execute the link request
            processFormSubmit2(request, script, parameters);
        
    }

    /**
     * Handle the case when a form is submitted
     * @param data 
     */
    private void processFormSubmit2(WebRequest request, 
            String targetScript, String rawParameters) {
        // add parameters to our web request object
        ArrayList<String[]> parameters = webUtils.cleanParameters(rawParameters);
        for(String[] parameter : parameters){
            request.parameters.add(parameter);
        }
        
        // if it does not have a .java extension, add one up
        if(targetScript.toLowerCase().endsWith(".java")==false){
            // this allows pretty URLs to happen
            targetScript += ".java";
        }
        // now we need to know what is the script intended to process
        request.scriptFile = new File(engine.getPluginsFolder(), targetScript);
        
        if(request.scriptFile.exists() == false){
            log.write(is.ERROR, "SU002 - Requested script doesn't exist: %1",
                    request.scriptFile.getAbsolutePath());
            return;
        }
         
        // now process the request parameters
        parameters = webUtils.cleanParameters(rawParameters);
        for(String[] parameter : parameters){
            //request.parameters.add(parameter);
            // define what is the method that we want to run
            if(parameter[0]!= null && parameter[0].equals(is.methodExecute)){
                request.scriptMethod = utils.text.safeString(parameter[1]);
            }
        }
    // submit the request to be executed
    controller.process(request);
    }
    
    
    /**
     * Handle the case when a form is submitted
     * @param data 
     */
    private void processFormSubmit(WebRequest request, 
            HyperlinkEvent e) {
        
        FormSubmitEvent form = (FormSubmitEvent) e;
        
        String data = form.getData();
        
        // add parameters to our web request object
        ArrayList<String[]> parameters = webUtils.cleanParameters(data);
        for(String[] parameter : parameters){
            request.parameters.add(parameter);
        }
        
        
        // error checking
        if(e.getURL() == null){
            log.write(is.ERROR, "SU9R4 - getURL is invalid");
            return;
        }
        
        String targetScript = e.getURL().getPath();
                
        // if it does not have a .java extension, add one up
        if(targetScript.toLowerCase().endsWith(".java")==false){
            // this allows pretty URLs to happen
            targetScript += ".java";
        }
        // now we need to know what is the script intended to process
        request.scriptFile = new File(targetScript);
        
        if(request.scriptFile.exists() == false){
            log.write(is.ERROR, "SU002 - Requested script doesn't exist: %1",
                    request.scriptFile.getAbsolutePath());
            return;
        }
         
        // now process the request parameters
        parameters = webUtils.cleanParameters(e.getURL().getQuery());
        for(String[] parameter : parameters){
            //request.parameters.add(parameter);
            // define what is the method that we want to run
            if(parameter[0].equals(is.methodExecute)){
                request.scriptMethod = utils.text.safeString(parameter[1]);
                //System.err.println("SU007 - Found method: " 
                      //  + request.scriptMethod);
            }
        }
    // submit the request to be executed
    controller.process(request);
    }
    

    private void callFrontScreen() {
        log.write(is.INFO, Messages.CallFrontScreen);
    }
 
    
    /**
     * This method will track a given mouse click to expose what HTML element
     * was clicked upon
     * @param event
     * @return 
     * @origin http://stackoverflow.com/questions/12932089/handling-hyperlink-right-clicks-on-a-jtextpane
     * @copyright StanislavL - http://stackoverflow.com/users/301607/stanislavl
     * @license CC-BY-SA-3.0
     * @retrieved 2014-04-19
     * @retriever Nuno Brito
     * Not so sure if this code will be needed, keeping it around for the moment
     */
    private Element getHyperlinkElement(MouseEvent event) {
            JEditorPane editor = (JEditorPane) event.getSource();
            int pos = editor.getUI().viewToModel(editor, event.getPoint());
            if (pos >= 0 && editor.getDocument() instanceof HTMLDocument) {
                HTMLDocument hdoc = (HTMLDocument) editor.getDocument();
                Element elem = hdoc.getCharacterElement(pos);
                if (elem.getAttributes().getAttribute(HTML.Tag.A) != null) {
                    return elem;
                }
            }
            return null;
        }
    
    

    /**
     * Marks a file as original, modified or third-party resource
     */
    private void markFileOriginAs(FileOrigin value) {
        // create a list of nodes to process
        ArrayList<TreeNodeSPDX> selectedNodes = swingUtils.getSelectedNodes(tree);
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
            System.err.println("SU1348 - No nodes available to change");
            return;
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
        
        // now that we splitted all the fileInfo, it is time to write them
        for(ArrayList<FileInfo> fileInfoList : spdxList.values()){
            // get the SPDX object
            SPDXfile spdx = fileInfoList.get(0).getSPDX();
            // write the lines for this list
            spdx.writeLines(fileInfoList, is.tagFileOrigin, value.toString(), true);
            // after writing the changes to disk, it is time to update the nodes
            for(FileInfo fileInfo : fileInfoList){
                fileInfo.setFileOrigin(value);
            }
        }
        
        // grab the currently selected node
        TreeNodeSPDX selectedNode = swingUtils.getSelectedNode();
        // update the selected node
        log.write(is.INFO, Messages.TreeNodeChanged, selectedNode.getUID());
    }

    
    /**
     * Changes the default search text that is currently placed on the search
     * box
     * @param provider The next text. If empty, shows the default "Search..." text 
     */
    public void setSearchProvider(final SearchType provider){
        if(provider == null){
            search.setText(searchTextDefault.getSearchBoxText());
            searchProvider = searchTextDefault;
        }else{
            search.setText(provider.getSearchBoxText());
            searchProvider = provider;
        }
    }

    public SearchType getSearchProvider() {
        return searchProvider;
    }
    
    
    /**
     * Showing the dialog that permits to choose a new component for the
     * selected files
     */
    private void showDialogAddFilesToComponent(){
        log.write(is.INFO, "Opening the components dialog");
        File script = new File(engine.getPluginsFolder(), "components/choose.java");
        // now do the parameters
        ArrayList<String[]> parameters = new ArrayList();
        // fire up the request
        TreeviewUtils.doRequest(script, "showDialog", parameters);
    }
    
    
    /**
     * We want to specify to which components a specific file belongs
     * @param componentName
     */
    public void setFilesWithComponent(String componentName) {
           
        int counter = 0;
        // get the locally selected components
        HashMap<String, ArrayList<FileInfo>> spdxList = TreeviewUtils.getSelectedFiles();
        // now that we splitted all the fileInfo, it is time to write them
        for(ArrayList<FileInfo> fileInfoList : spdxList.values()){
            // get the SPDX object
            SPDXfile spdx = fileInfoList.get(0).getSPDX();
            // write the lines for this list
            spdx.writeLines(fileInfoList, is.tagFileComponent, componentName, true);
            // after writing the changes to disk, it is time to update the nodes
            for(FileInfo fileInfo : fileInfoList){
                fileInfo.setFileComponent(componentName);
                counter++;
            }
        }
        // grab the currently selected node
        TreeNodeSPDX selectedNode = swingUtils.getSelectedNode();
        // update the selected node
        log.write(is.INFO, Messages.TreeNodeChanged, selectedNode.getUID());
        // output the dialog box as feedback
        swingUtils.showMessage("Marked " + utils.text.pluralize(counter, "file") 
                + " as part of " + componentName);
    }
    
    
}
