/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.desktop.core;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author benny
 */
public class AddROIDialog extends javax.swing.JDialog {
    Controller control = new Controller();
    /**
     * Creates new form AddROIDatabaseDialog
     */
    public AddROIDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JTextArea getjTextArea1() {
        return jtaROI;
    }

    public JTextField getjTextField1() {
        return jtfROI;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlPrompt = new javax.swing.JLabel();
        jpROI = new javax.swing.JPanel();
        jlROI = new javax.swing.JLabel();
        jtfROI = new javax.swing.JTextField();
        jlDesc = new javax.swing.JLabel();
        jspROI = new javax.swing.JScrollPane();
        jtaROI = new javax.swing.JTextArea();
        jbSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add ROI");

        jlPrompt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlPrompt.setText("Please Enter ROI Information.");

        jpROI.setBackground(new java.awt.Color(204, 204, 204));

        jlROI.setText("Reason for Interest");

        jtfROI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfROIActionPerformed(evt);
            }
        });

        jlDesc.setText("Description of Reason for Interest");

        jtaROI.setColumns(20);
        jtaROI.setRows(5);
        jspROI.setViewportView(jtaROI);

        javax.swing.GroupLayout jpROILayout = new javax.swing.GroupLayout(jpROI);
        jpROI.setLayout(jpROILayout);
        jpROILayout.setHorizontalGroup(
            jpROILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpROILayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpROILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspROI, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDesc)
                    .addComponent(jlROI)
                    .addComponent(jtfROI, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jpROILayout.setVerticalGroup(
            jpROILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpROILayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlROI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfROI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspROI, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jbSubmit.setBackground(new java.awt.Color(51, 153, 0));
        jbSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jbSubmit.setText("Submit");
        jbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpROI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(108, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlPrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSubmit)
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrompt)
                    .addComponent(jbSubmit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpROI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmitActionPerformed
        // TODO add your handling code here:
        if (getjTextField1().getText().equals("") == false && getjTextArea1().getText().equals("")== false) {
            control.addROI(getjTextField1().getText(),getjTextArea1().getText() );
        }
        control.finalize();
        AddedROIDialog dialog = new AddedROIDialog(new javax.swing.JFrame(), true);
        dialog.setOpener(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jbSubmitActionPerformed

    private void jtfROIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfROIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfROIActionPerformed

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
            java.util.logging.Logger.getLogger(AddROIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddROIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddROIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddROIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddROIDialog dialog = new AddROIDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jlDesc;
    private javax.swing.JLabel jlPrompt;
    private javax.swing.JLabel jlROI;
    private javax.swing.JPanel jpROI;
    private javax.swing.JScrollPane jspROI;
    private javax.swing.JTextArea jtaROI;
    private javax.swing.JTextField jtfROI;
    // End of variables declaration//GEN-END:variables
}
