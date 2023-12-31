/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.desktop.core;

import javax.swing.JTextField;

/**
 *
 * @author benny
 */
public class AddMakeModelDialog extends javax.swing.JDialog {
    Controller control = new Controller();
    /**
     * Creates new form AddMakeModelDatabaseDialog
     */
    public AddMakeModelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JTextField getjTextField1() {
        return jtfMake;
    }

    public JTextField getjTextField2() {
        return jtfModel;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlMakeModel = new javax.swing.JLabel();
        jpMakeModel = new javax.swing.JPanel();
        jlMake = new javax.swing.JLabel();
        jtfMake = new javax.swing.JTextField();
        jlModel = new javax.swing.JLabel();
        jtfModel = new javax.swing.JTextField();
        jbSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Make/Model");
        setPreferredSize(new java.awt.Dimension(275, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlMakeModel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlMakeModel.setText("Please Enter Make/Model Information");
        getContentPane().add(jlMakeModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jpMakeModel.setBackground(new java.awt.Color(204, 204, 204));
        jpMakeModel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlMake.setText("Make");
        jpMakeModel.add(jlMake, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));
        jpMakeModel.add(jtfMake, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 156, -1));

        jlModel.setText("Model");
        jpMakeModel.add(jlModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jtfModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfModelActionPerformed(evt);
            }
        });
        jpMakeModel.add(jtfModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 156, -1));

        jbSubmit.setBackground(new java.awt.Color(51, 153, 0));
        jbSubmit.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jbSubmit.setText("Submit");
        jbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubmitActionPerformed(evt);
            }
        });
        jpMakeModel.add(jbSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        getContentPane().add(jpMakeModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModelActionPerformed

    private void jbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmitActionPerformed
        // TODO add your handling code here:
        if (getjTextField1().getText().equals("") == false && getjTextField2().getText().equals("")== false) {
            control.addMakeModel(getjTextField1().getText(),getjTextField2().getText() );
        }
        else {
            if (getjTextField1().getText().equals("") && getjTextField2().getText().equals("")) {
            System.out.println("Missing parameters");
        }
            if (getjTextField2().getText().equals("")) {
                 control.addMake(getjTextField1().getText());
            }
        }  
        control.finalize();
        AddedMakeModelDialog dialog = new AddedMakeModelDialog(new javax.swing.JFrame(), true);
        dialog.setOpener(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jbSubmitActionPerformed

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
            java.util.logging.Logger.getLogger(AddMakeModelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMakeModelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMakeModelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMakeModelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddMakeModelDialog dialog = new AddMakeModelDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbSubmit;
    private javax.swing.JLabel jlMake;
    private javax.swing.JLabel jlMakeModel;
    private javax.swing.JLabel jlModel;
    private javax.swing.JPanel jpMakeModel;
    private javax.swing.JTextField jtfMake;
    private javax.swing.JTextField jtfModel;
    // End of variables declaration//GEN-END:variables
}
