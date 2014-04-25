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
import main.core;
import script.log;

/**
 *
 * @author Nuno Brito, 25th of April 2014 in Darmstadt, Germany.
 */
public final class AddLicense extends javax.swing.JFrame {

    public String searchText = "Search..";
    
    /**
     * Creates new form AddLicense
     */
    public AddLicense() {
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
        // bring up the default text box
        textDefault();
        
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
        text = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose a license");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);

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

        text.setContentType("text/html"); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search)
                    .addComponent(text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusGained

    }//GEN-LAST:event_textFocusGained

    private void textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusLost

    }//GEN-LAST:event_textFocusLost

    private void textPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textPropertyChange

    }//GEN-LAST:event_textPropertyChange

    private void textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textKeyTyped

    }//GEN-LAST:event_textKeyTyped

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
            java.util.logging.Logger.getLogger(AddLicense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLicense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLicense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLicense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddLicense().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
        // people expect to press "ESC" to clear the whole bar
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
     * The default text that should appear on 
     */
    void textDefault(){
        String result = "test";
        
        text.setText(result);
    }
    
}
