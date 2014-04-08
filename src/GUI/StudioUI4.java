/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2014-01-13T00:00:00Z
 * LicenseName: NOASSERTION
 * FileName: StudioUI4.java
 * FileType: SOURCE
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 * FileComment: <text> The initial GUI for the end-users </text>
 */
package GUI;

import definitions.Messages;
import definitions.is;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.FormSubmitEvent;
import javax.swing.text.html.HTMLEditorKit;
import main.actions;
import main.controller;
import main.core;
import script.RunPlugins;
import script.log;
import spdxlib.SPDXfile;
import utils.html;
import utils.internet;
import www.RequestOrigin;
import www.RequestType;
import www.WebRequest;

/**
 *
 * @author Nuno Brito, 19th of September 2013 in Darmstadt, Germany.
 */
public class StudioUI4 extends javax.swing.JFrame {

    // helps to avoid loading the same information multiple times
    TreeNodeSPDX lastNodeSelected;
    
    // what was the last product that was marked as selected?
    public SPDXfile productSelected = null;
    
    public String searchText = "Search..";
    
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
    
    private long lastTime = 0;
    
    /**
     * Creates new form StudioUI2
     */
    public StudioUI4() {
        // adopt the default user interface menus and buttons
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {} catch (IllegalAccessException ex) {
        } catch (InstantiationException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        // get the window icon working
        URL imgURL = this.getClass().getResource(is.defaultIcon);
        setIconImage(Toolkit.getDefaultToolkit().getImage(imgURL));
        
        initComponents();
        
        //doSettings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        panelWest = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        panelEast = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        text = new javax.swing.JEditorPane();
        button = new javax.swing.JButton();
        search = new javax.swing.JTextField();

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
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
        panelWest.setViewportView(tree);

        jSplitPane1.setLeftComponent(panelWest);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

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

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/arrow-180.png"))); // NOI18N
        button.setBorder(null);
        button.setBorderPainted(false);
        button.setEnabled(false);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        search.setText("Search..");
        search.setMargin(new java.awt.Insets(2, 8, 2, 2));
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

        javax.swing.GroupLayout panelEastLayout = new javax.swing.GroupLayout(panelEast);
        panelEast.setLayout(panelEastLayout);
        panelEastLayout.setHorizontalGroup(
            panelEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(panelEastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addContainerGap())
        );
        panelEastLayout.setVerticalGroup(
            panelEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEastLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(panelEast);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
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
//        int selRow = tree.getRowForLocation(evt.getX(), evt.getY());
//        //TreePath selPath = tree.getPathForLocation(evt.getX(), evt.getY());
//        if(selRow != -1) {
//            if((evt.getClickCount() == 1)){
//                   // &&isEnoughTime()) {
//                doTreeNodeChanged(false);
//            }
//            else if(evt.getClickCount() == 2) {
//                    doTreeNodeChanged(true);
//            }
//        }
//        if (isAlreadyOneClick) {
//        //System.out.println("double click");
//        doTreeNodeChanged(true);
//        isAlreadyOneClick = false;
//        return;
//        } else {
//        isAlreadyOneClick = true;
//        Timer t = new Timer("doubleclickTimer", false);
//        t.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                isAlreadyOneClick = false;
//            }
//        }, 500);
//    }
//       
//        
//                
//        int selRow = tree.getRowForLocation(evt.getX(), evt.getY());
//        if(selRow != -1) {
//            if((evt.getClickCount() == 1)){
//               if(isEnoughTime()){
//                   doTreeNodeChanged(false);
//               }
//            }  
//        }    
        
        
//        if(firstClickActive == false){
//            firstClickActive = true;
//            timeBombOneClick();
//        }
        
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
        
    }//GEN-LAST:event_treeeventTreeMouseClicked
    
    
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
    
    
    private Boolean isEnoughTime(){
        long thisTime = System.currentTimeMillis();
        long futureTime = lastTime + 1000;
        
        // are we there yet?
        if(thisTime > futureTime){
            lastTime = System.currentTimeMillis();
            return true;
        }else{
            return false;
        }
        
    }
    
    
    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged

    }//GEN-LAST:event_treeValueChanged

    private void textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusGained

    }//GEN-LAST:event_textFocusGained

    private void textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusLost

    }//GEN-LAST:event_textFocusLost

    private void textPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textPropertyChange

    }//GEN-LAST:event_textPropertyChange

    private void textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textKeyTyped

    }//GEN-LAST:event_textKeyTyped

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        doBackButton();
    }//GEN-LAST:event_buttonActionPerformed

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        doSearchMouseClicked();
        //doGainedFocusHookMessage("Search Box");
        core.searchBoxActive = true;
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        doSearchMouseClicked();
        // reset back to the default value when empty
        if(search.getText().isEmpty()){
            search.setText(searchText);
        }
        core.searchBoxActive = false;
    }//GEN-LAST:event_searchFocusLost

    private void searchdoSearchKeypress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdoSearchKeypress

    }//GEN-LAST:event_searchdoSearchKeypress

    private void searchdoSearch(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdoSearch
        performSearch(evt);
    }//GEN-LAST:event_searchdoSearch

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel panelEast;
    private javax.swing.JScrollPane panelWest;
    private javax.swing.JTextField search;
    private javax.swing.JEditorPane text;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables

    public void doSettings() {
        // the basic root node that is always needed
        swingUtils.nodeAddRoot(tree);
       // now add all reports that we can find
        actions.addTreeSPDX(tree);
    
        // get the list of RunPlugins going
        RunPlugins.listPlugins();
        log.write(is.INFO, Messages.ReadyToUse);
//        log.write(is.INFO, Messages.ReadyToUse);
        
//        Thread thread = new Thread(){
//                @Override
//                public void run(){
//                    utils.time.wait(1);
//                 log.write(is.INFO, Messages.ReadyToUse);
//                }
//                };
//            thread.start();
            
            // ensure that the search box is the selected component
            search.requestFocusInWindow();
            
            // show the startup image
//            editorPane(is.contentHTML, 
//                    false, -1, 
//                    html.div(30) 
//                    + utils.html.getCommonFolderIcon("startup.png")
//                    + html._div
//                    );
//            
            button.setEnabled(false);
            
            // solve a bug we have on the screen
            this.editorPane(is.contentHTML, true, 0, "");
            
            // do the front screen
            callFrontScreen();
            
            // capture the clicks on HTML content
            doFormInterception();
            
            // this is needed to ensure we get line-wrapping
            jScrollPane2.setViewportView(text);
           
            // change our title
            setTitle("TripleCheck");
           
//            doFrontScreen();
    }

    public JTree getTree(){
        return tree;
    }

    /**
     * React whenever the user wants to start a search
     */
    private void doSearchMouseClicked() {
        String currentTerm = search.getText();
        if(currentTerm.equals(searchText)){
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
            search.setText(searchText);
            return;
        }
        
        // ENTER means that we are serious about the current search term
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            log.write(is.COMMAND, Messages.SearchBoxPressedENTER);
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
            search.setText(searchText);
            core.key.clear();
            return;
        }
        
        
        
        // there is a bug that allows people to write over the "search" default
        if(search.getText().startsWith(searchText)){
            String temp = search.getText().replace(searchText, "");
            search.setText(temp);
        }
        
        // indicate that a key was pressed, this keeps the buffer alive
        core.key.pressedKey("x");
            
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
        
        // sometimes we don't need to save the previous page
            if(cache){
                // save settings from the current page before writing a new one
                lastPage.contentType = text.getContentType();
                lastPage.content = text.getText();
            }
            
            // set the new content, first the type and then the text
            text.setContentType(contentType);
            text.setText(content);
            // disable this box if you don't need to see the output on a file
            //utils.files.SaveStringToFile(new File("output.html"), content);
                    
            // should the button enabled?
            button.setEnabled(true);
        
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
                    File jump = new File(core.getPluginsFolder(), processedURL);
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
        button.setEnabled(false);
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
            core.temp.put(is.doubleClick, node);
            log.write(is.INFO, Messages.TreeNodeDoubleClick, node.getUID());
            return;
        }
              
         
     

    
        // do we have a script associated with this node?
        if(node.scriptFile != null){
            // launch a small thread to speed things up here
               Thread thread = new Thread(){
                   @Override
                   public void run(){
                      WebRequest newRequest = new WebRequest();
                        newRequest.requestType = RequestType.NONE;
                        newRequest.requestOrigin = RequestOrigin.GUI_tree;
                        newRequest.BaseFolder = node.scriptFolder;
                        newRequest.scriptFile = node.scriptFile;
                        newRequest.scriptFolder = node.scriptFolder;
                        newRequest.scriptMethod = node.scriptMethod;
                        newRequest.parameters = node.scriptParameters;
                        
                     
                        
                        //newRequest.addParameter("method", node.scriptMethod);
                        controller.process(newRequest);
                   }
               };
               thread.start();
            
        }
    
        // now execute the addon actions
        log.write(is.INFO, Messages.TreeNodeChanged, node.getUID());
    
    
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
            String script = temp.replace(core.getPluginsFolder().getAbsolutePath(), "");
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
            core.script.runJava(scriptFile, method, is.plugin);
            return;
        }
        
        // do a search inside our tool/library
        if(URL.startsWith("search://")){
            text = text.replace("search://", "");
            core.searchTerm = text;
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
            String script = temp.replace(core.getPluginsFolder().getAbsolutePath(), "") 
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
        ArrayList<String[]> parameters = html.cleanParameters(rawParameters);
        for(String[] parameter : parameters){
            request.parameters.add(parameter);
        }
        
        // if it does not have a .java extension, add one up
        if(targetScript.toLowerCase().endsWith(".java")==false){
            // this allows pretty URLs to happen
            targetScript += ".java";
        }
        // now we need to know what is the script intended to process
        request.scriptFile = new File(core.getPluginsFolder(), targetScript);
        
        if(request.scriptFile.exists() == false){
            log.write(is.ERROR, "SU002 - Requested script doesn't exist: %1",
                    request.scriptFile.getAbsolutePath());
            return;
        }
         
        // now process the request parameters
        parameters = html.cleanParameters(rawParameters);
        for(String[] parameter : parameters){
            //request.parameters.add(parameter);
            // define what is the method that we want to run
            if(parameter[0].equals(is.methodExecute)){
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
        ArrayList<String[]> parameters = html.cleanParameters(data);
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
        parameters = html.cleanParameters(e.getURL().getQuery());
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
 
}
