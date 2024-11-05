/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tampilan;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import kelas.category;
import kelas.user;


/**
 *
 * @author X1 Carbon
 */
public class Framecategory extends javax.swing.JFrame {
    
    
    public Framecategory() {
        initComponents();
        loadTable();
        reset();
    }

    void loadTable() {
        DefaultTableModel model  = new DefaultTableModel();
        model.addColumn("ID KATEGORI");
        model.addColumn("KATEGORI");
        
        try {
            category cat = new category();
            ResultSet data = cat.tampilKategori();
            
            while(data.next()){
                model.addRow(new Object[]{
                    data.getString("category_id"),
                    data.getString("category_name"),
                });
                  
            }
            
           
                
            
        } catch (SQLException sQLException) {
            // Handle exception
        }
            
        dKategori.setModel(model);   
        }
    
    void reset(){
        autoID();
        bID.setEditable(false);
        bNama.setText(null);
    }
    
    void autoID(){
        
        try {
            category cat = new category();
            ResultSet id = cat.autoID();
            
            
            if (id.next()) {
                int auto = id.getInt("ID") + 1;
                bID.setText(String.valueOf(auto));
                
            } else {
                bID.setText("1");
            }
        } catch (SQLException sQLException) {
            
            // Handle exception
            
        }
    }
                
            
        
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabel1 = new javax.swing.JLabel();
        bID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bNama = new javax.swing.JTextField();
        fTambah = new javax.swing.JButton();
        fUbah = new javax.swing.JButton();
        fHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dKategori = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabel1.setText("KATEGORI");
        jlabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jlabel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setText("ID");

        jLabel3.setText("KATEGORI");

        bNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNamaActionPerformed(evt);
            }
        });

        fTambah.setText("TAMBAH");
        fTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fTambahActionPerformed(evt);
            }
        });

        fUbah.setText("UBAH");
        fUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fUbahActionPerformed(evt);
            }
        });

        fHapus.setText("HAPUS");
        fHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fHapusActionPerformed(evt);
            }
        });

        dKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dKategori);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jlabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fUbah)
                                .addGap(18, 18, 18)
                                .addComponent(fHapus))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bID)
                                    .addComponent(bNama))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jlabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(bNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fTambah)
                            .addComponent(fUbah)
                            .addComponent(fHapus)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bNamaActionPerformed

    private void jlabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jlabel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jlabel1AncestorAdded

    private void fUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fUbahActionPerformed
        // TODO add your handling code here:
        try {
            category cat = new category();
            cat.setCategory_id(Integer.parseInt(bID.getText()));
            cat.setCategory_name(bNama.getText());
            cat.ubahKategori();
        } catch (SQLException sQLException) {
            // Handle exception
        }
        
        reset();
        loadTable();
    }//GEN-LAST:event_fUbahActionPerformed

    private void fHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fHapusActionPerformed
        // TODO add your handling code here:
        try {
            
            category cat  = new category();
            cat.setCategory_id(Integer.parseInt(bID.getText()));
            cat.hapusKategori();
        } catch (SQLException sQLException) {
            // Handle exception
        }
        
        reset();
        loadTable();
    }//GEN-LAST:event_fHapusActionPerformed

    private void fTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fTambahActionPerformed
        // TODO add your handling code here:
        try {
            category cat = new category();
            cat.setCategory_id(Integer.parseInt(bID.getText()));
            cat.setCategory_name(bNama.getText());
            
            cat.tambahKategori();
        } catch (SQLException sQLException) {
            // Handle exception
        }
        
        loadTable();
        reset();
    }//GEN-LAST:event_fTambahActionPerformed

    private void dKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dKategoriMouseClicked
        int baris = dKategori.rowAtPoint(evt.getPoint());
        String username = dKategori.getValueAt(baris, 0).toString();
        String nama = dKategori.getValueAt(baris,1).toString();
        
        bID.setText(username);
        bID.setEditable(false);
        bNama.setText(nama);
    }//GEN-LAST:event_dKategoriMouseClicked

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
            java.util.logging.Logger.getLogger(Framecategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Framecategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Framecategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Framecategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Framecategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bID;
    private javax.swing.JTextField bNama;
    private javax.swing.JTable dKategori;
    private javax.swing.JButton fHapus;
    private javax.swing.JButton fTambah;
    private javax.swing.JButton fUbah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel1;
    // End of variables declaration//GEN-END:variables
}
