/*
 * SPDXVersion: SPDX-1.1
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 * Created: 2013-09-16T00:00:00Z
 * LicenseName: EUPL-1.1-without-appendix
 * FileName: StartupScreen.java  
 * FileType: SOURCE
 * FileCopyrightText: <text> 
    Copyright 2013 Nuno Brito, TripleCheck 
    Copyright (c) 2013 Alvin Alexander
</text>
 * FileComment: <text> Startup screen to permit loading the SPDX files for our
 * library. </text> 
 */

package GUI;

import definitions.is;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;
import java.util.prefs.Preferences;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import main.coreGUI;
import script.log;

/**
 * Parts of this code were based on the blog post from Alvin Alexander
 * at http://alvinalexander.com/java/java-splash-screen-with-progress-bar-1
 * 
 * @author Nuno Brito, 30th of April 2014 in Amrum, Germany.
 */
public class StartupScreen extends javax.swing.JFrame {

    final StartupScreen screen = this;
    final String counterValue = "startupcounter";
    /**
     * Creates new form StartupScreen
     */
    public StartupScreen() {
        // adopt the default user interface menus and buttons
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {} catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        // get the window icon working
        URL imgURL = this.getClass().getResource(is.defaultIcon);
        setIconImage(Toolkit.getDefaultToolkit().getImage(imgURL));
        
        initComponents();
        
        // place the frame on the middle of the screen
        setLocationRelativeTo(null);
        // change the background to full white
        getContentPane().setBackground( Color.WHITE );
        // show the current version of our software
        label.setText("Version " + coreGUI.version);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TripleCheck");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N

        label.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelLogo)
                    .addComponent(label))
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartupScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartupScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartupScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartupScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new StartupScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables

    private void setProgress(int progress){
        final int theProgress = progress;
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            progressBar.setValue(theProgress);
          }
        });
  }
    
   private void setProgress(String message, int progress){
    final int theProgress = progress;
    final String theMessage = message;
    setProgress(progress);
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        progressBar.setValue(theProgress);
        setMessage(theMessage);
      }
    });
  }
    
    public void setMessage(String message){
    if (message==null)
    {
      message = "";
      progressBar.setStringPainted(false);
    }
    else
    {
      progressBar.setStringPainted(true);
    }
    progressBar.setString(message);
  }

    
    /**
     * Makes the startup screen visible with an update of the messages
     * being displayed to the end user. It was getting difficult to
     * make the progress bar increase as we get closer to load everything.
     * The first idea was defining percentages manually but ended doing
     * this in a dynamic manner to follow more closely the reality of loading.
     */
    public void kickoff(){
        // make the window visible
        setVisible(true);

        // initialize the counters
        int counter = 40;
        
        // access the registry
        final Preferences prefs = Preferences.userNodeForPackage(StartupScreen.class);
        String counterText = prefs.get(counterValue, counter + "");
        // convert to integer
        int newValue = Integer.parseInt(counterText);
        // is it worth to upgrade the counter?
        if(newValue > counter){
            // setup the new value
            counter = newValue;
        }
        
        // what is maximum that we are expecting for our progress bar?
        progressBar.setMaximum(counter);
        
        log.write(is.INFO, "Launching the startup screen");
        
        // start a thread that will update itself with log messages
        Thread thread = new Thread(){
            @Override
            public void run(){
                    while(isVisible()){
                        setMessage(log.getLatest().getMessageSimple());
                        int count = log.getCounter();
                        setProgress(count);
                        utils.time.waitMs(150);
                    }
                    // store the real value for later reuse
                     prefs.put(counterValue, log.getCounter() + "");
                }};
         thread.start();
    }
    
}
