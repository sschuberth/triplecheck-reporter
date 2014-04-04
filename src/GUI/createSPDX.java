/*
 * SPDXVersion: SPDX-1.1
 *
 * Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
 *
 * Creator: Organization: TripleCheck (contact@triplecheck.de)
 *
 * Created: 2013-09-13T00:00:00Z
 *
 * LicenseName: NOASSERTION
 *
 * FileName: createSPDX.java
 *
 * FileType: SOURCE
 *
 * FileCopyrightText: <text> Copyright 2013 Nuno Brito, TripleCheck </text>
 *
 * FileComment: <text> Simple GUI to create SPDX skeletons </text>
 */
package GUI;

import definitions.is;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.swing.JTextField;
import javax.swing.UIManager;
import main.actions;
import main.core;

public class createSPDX extends javax.swing.JFrame {

    /**
     * Creates new form createSPDX
     */
    public createSPDX() {
        
        // adopt the default user interface menus and buttons
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {}
        
        // get the window icon working
        URL imgURL = this.getClass().getResource(is.defaultIcon);
        setIconImage(Toolkit.getDefaultToolkit().getImage(imgURL));
        
        initComponents();
        
        doSettings();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textSourceFolder = new javax.swing.JTextField();
        buttonSettingsChooseBaseFolder = new javax.swing.JButton();
        buttonGo = new javax.swing.JButton();
        textStoreSPDX = new javax.swing.JTextField();
        buttonChooseFolderSPDXfileLocation = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textStoreSPDX1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create SPDX");
        setLocationByPlatform(true);

        jLabel1.setText("Folder where source files are located");

        textSourceFolder.setEditable(false);
        textSourceFolder.setText(" ");

        buttonSettingsChooseBaseFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder-horizontal-open.png"))); // NOI18N
        buttonSettingsChooseBaseFolder.setText("Choose folder");
        buttonSettingsChooseBaseFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSettingsChooseBaseFolderActionPerformed(evt);
            }
        });

        buttonGo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wand.png"))); // NOI18N
        buttonGo.setText("Create");
        buttonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGoActionPerformed(evt);
            }
        });

        textStoreSPDX.setEditable(false);
        textStoreSPDX.setText(" ");

        buttonChooseFolderSPDXfileLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder-horizontal-open.png"))); // NOI18N
        buttonChooseFolderSPDXfileLocation.setText("Choose folder");
        buttonChooseFolderSPDXfileLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseFolderSPDXfileLocationActionPerformed(evt);
            }
        });

        jLabel2.setText("Folder where SPDX file will be created");

        jLabel3.setText("Folder where SPDX file will be created");

        textStoreSPDX1.setEditable(false);
        textStoreSPDX1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textSourceFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSettingsChooseBaseFolder, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonGo, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textStoreSPDX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonChooseFolderSPDXfileLocation))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 266, Short.MAX_VALUE))
                    .addComponent(textStoreSPDX1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(133, 133, 133)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSourceFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSettingsChooseBaseFolder))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStoreSPDX, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChooseFolderSPDXfileLocation))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textStoreSPDX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(buttonGo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSettingsChooseBaseFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSettingsChooseBaseFolderActionPerformed
        // TODO add your handling code here:
        chooseSettingsFolder();
    }//GEN-LAST:event_buttonSettingsChooseBaseFolderActionPerformed

    private void buttonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGoActionPerformed
        doCreateSPDX();
    }//GEN-LAST:event_buttonGoActionPerformed

    private void buttonChooseFolderSPDXfileLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseFolderSPDXfileLocationActionPerformed
       chooseSPDXFolder();
    }//GEN-LAST:event_buttonChooseFolderSPDXfileLocationActionPerformed

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
            java.util.logging.Logger.getLogger(createSPDX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createSPDX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createSPDX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createSPDX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new createSPDX().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseFolderSPDXfileLocation;
    private javax.swing.JButton buttonGo;
    private javax.swing.JButton buttonSettingsChooseBaseFolder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textSourceFolder;
    private javax.swing.JTextField textStoreSPDX;
    private javax.swing.JTextField textStoreSPDX1;
    // End of variables declaration//GEN-END:variables

    
    
    
    /**
     * Choose from where the source code files are processed
     */
    private void chooseSettingsFolder() {
        GUI.swingUtils.chooseFolder(textSourceFolder, is.settings);        
    }

    /**
     * Choose where to store the resulting SPDX file
     */
     private void chooseSPDXFolder() {
        GUI.swingUtils.chooseFolder(textStoreSPDX, is.folderSPDX);
    }
    
    /**
     * used during initialisation of this GUI to fill up the proper
     * values that were saved before
     */
    private void doSettings() {
        textSourceFolder.setText(core.settings.read(is.settings));
        textStoreSPDX.setText(core.settings.read(is.folderSPDX));
    }

    /**
     * create a new SPDX document based on basic information that
     * we have available
     */
    private void doCreateSPDX() {
        // get the base folder that was selected
        String source = core.settings.read(is.settings);

        // if no base folder is chosen, do nothing here
        if((source == null)||(source.isEmpty())){
            return;
        }
        
        // get the selected folder and run the SPDX creation
//        File baseFolder = new File(source);
//        actions.findFiles(baseFolder);
    }

   
}
