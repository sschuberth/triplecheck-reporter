/**
 * SPDXVersion: SPDX-1.1 
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (http://triplecheck.de) 
 * Created: 2014-04-25T00:00:00Z 
 * LicenseName: EUPL-1.1-without-appendix 
 * FileName: AddLicense.java 
 * FileType: SOURCE 
 * FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
 * FileComment: <text> Allows an end-user to select a license for a given file </text>
 */

package GUI;

import definitions.Messages;
import definitions.is;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLEditorKit;
import main.core;
import script.log;
import spdxlib.License;
import utils.html;
import utils.time;

/**
 *
 * @author Nuno Brito, 25th of April 2014 in Darmstadt, Germany.
 */
public final class LicenseNavigator extends javax.swing.JFrame {

    public String searchText = "Search..";
    
    long lastKeypress = System.currentTimeMillis();
    public long sensitivity = 350;
    
    private String
            buffer = "" ; // the buffer of keys being typed very quickly
    
    // we have different reactions to running standalone or as part of a dialog
    public boolean isDialog = false;
    
    /**
     * Creates new form AddLicense
     */
    public LicenseNavigator() {
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
        
        doSettings();
    }

   

    /**
     * Initial settings when launching the UI
     */
    void doSettings(){

        // only look for licenses if nobody else has done it yet
        if(core.licenses.hasNotProcessed()){
            core.licenses.find();
        }
        // bring up the default text box
        textDefault();
        
        text.requestFocusInWindow();
        // monitor key presses on the search box
        launchThread();
        // capture the clicks on HTML content
        doFormInterception();
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
     * The main point entry for actions that take place on the Swing GUI
     * component where the HTML text is displayed
     * @param e 
     */ 
    private void processActionGUI(HyperlinkEvent e){
         // react to hyperlinks being clicked
        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            processSelection(e.getDescription());
        }
    }
    
    /**
     * When a license is selected, carry with the remaining actions
     * @param selectedLicense   License id of the selected license
     */
    private void processSelection(String selectedLicense){
         // close this menu
        setVisible(false);
        dispose();
        // return to the main UI
        showMainWindow();
        // a license was chosen, fireup the event on the main window
        log.write(is.ACCEPTED, "License was chosen: %1", selectedLicense);
        core.studio.licenseMarkSelectedNodes(selectedLicense);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Choose a license");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        text.setEditable(false);
        text.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(text);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        doSearchMouseClicked();
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        doSearchMouseClicked();
        // reset back to the default value when empty
        if(search.getText().isEmpty()){
            search.setText(searchText);
        }
    }//GEN-LAST:event_searchFocusLost

    private void searchdoSearchKeypress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdoSearchKeypress

    }//GEN-LAST:event_searchdoSearchKeypress

    private void searchdoSearch(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdoSearch
        performSearch(evt);
    }//GEN-LAST:event_searchdoSearch

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.out.println("Closing License window");
        showMainWindow();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LicenseNavigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LicenseNavigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LicenseNavigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LicenseNavigator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LicenseNavigator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JEditorPane text;
    // End of variables declaration//GEN-END:variables



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
        // people expect to press "ESC" to clearKeypresses the whole bar
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            search.transferFocus();
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
            textDefault();
            return;
        }
        
        
        // there is a bug that allows people to write over the "search" default
        if(search.getText().isEmpty()){
            search.setText(searchText);
            clearKeypresses();
            return;
        }
        
        
        
        // there is a bug that allows people to write over the "search" default
        if(search.getText().startsWith(searchText)){
            String temp = search.getText().replace(searchText, "");
            search.setText(temp);
        }
        
        // indicate that a key was pressed, this keeps the buffer alive
        pressedKey("x");
            
    }
    
   
   
    /**
     * The default text that should appear on 
     */
    void textDefault(){
        String result = core.popularity.getPopularitySummary();
        
          // go through each found license
        result += html.h3("Available licenses");
        for(License license : core.licenses.getList()){
            result += license.getPrettyText("Choose", license.getId());
        }
        
        // give a left-side margin on the output
        result = html.div()
                + result
                + html._div;
        
        
        text.setText(result);
        text.setCaretPosition(0);
    }
    
    
     /**
     * The user has pressed a key, let's store this key on our buffer
     * @param key the key that was pressed by the user
     */
    public void pressedKey(final String key){
        buffer = buffer.concat(key);
        lastKeypress = System.currentTimeMillis();
    }
    
     /**
     * Launch the thread to keep this thing active
     */
    void launchThread(){
         Thread thread = new Thread(){
                    @Override
                    public void run() {
                        while(true){
                            // hold on this thread for a second
                            time.waitMs(sensitivity);
                            // no need to process anything if buffer is empty
                            if(buffer.isEmpty()){
                                continue;
                            }
                            long timeNow = System.currentTimeMillis();
                            // we keep a buffer of 1 second between keys
                            long waitingTime = lastKeypress + sensitivity;
                            // has more than one second passed without pressing?
                            if(timeNow > waitingTime){                
                                String searchTerm = search.getText();
                                String result = core.licenses.search(searchTerm, "");
                                text.setText(result);
                                buffer = "";
                            }
                        }
                    }
                };
               // launch it up, fire and forget
               thread.start();
    }

    /**
     * Cleans up the buffer
     */
    public void clearKeypresses() {
        buffer = "";
    }

    /**
     * Show the main window again
     */
    private void showMainWindow() {
        // we are likely running as standalone
        if(core.studio == null){
            System.exit(9992);
            return;
        }
        core.studio.setEnabled(true);
        core.studio.setVisible(true);
    }
    
}
