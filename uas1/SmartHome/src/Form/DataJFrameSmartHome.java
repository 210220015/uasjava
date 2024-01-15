
package Form;
import Config.KoneksiSmartHome;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DataJFrameSmartHome extends javax.swing.JFrame {

    Connection conn;
    public DataJFrameSmartHome() {
         conn = KoneksiSmartHome.getConnection();
        initComponents();
        getData();
    }
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM tbl_smart_home ORDER BY id DESC LIMIT 10";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("id");
                String lampuDepan = rs.getString("lampu_depan");
                String lampuKamar = rs.getString("lampu_kamar");
                String lampuBelakang = rs.getString("lampu_belakang");
                String tanggalJam = rs.getString("tanggal_jam");
                
                Object [] rowData = {lampuDepan,lampuKamar,lampuBelakang,tanggalJam};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
        }catch (Exception e){
             Logger.getLogger(DataJFrameSmartHome.class.getName()).log(Level.SEVERE, null, e);
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        t_cari.setText("Pencarian");
        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "L. Depan", "L. Kamar", "L. Belakang", "Tanggal"
            }
        ));
        tbl_data.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbl_dataAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbl_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbl_dataKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_cari)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
         DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);

        String cari = t_cari.getText();

        try {
            String sql = "SELECT * FROM tbl_smart_home WHERE lampu_kamar LIKE ? OR lampu_depan LIKE ? OR lampu_belakang LIKE ? OR tanggal_jam LIKE ? ORDER BY id DESC LIMIT 10";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            st.setString(3, "%" + cari + "%");
            st.setString(4, "%" + cari + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String lampuDepan = rs.getString("lampu_depan");
                String lampuKamar = rs.getString("lampu_kamar");
                String lampuBelakang = rs.getString("lampu_belakang");
                String tanggalJam = rs.getString("tanggal_jam");

                Object [] rowData = {lampuDepan,lampuKamar,lampuBelakang,tanggalJam};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }                               
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cariMouseClicked
         t_cari.setText("");
    }//GEN-LAST:event_t_cariMouseClicked

    private void tbl_dataAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbl_dataAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_dataAncestorAdded

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariActionPerformed

    private void tbl_dataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_dataKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_dataKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        DashboardJFrameSmartHome boardJFrame = new DashboardJFrameSmartHome();
        boardJFrame.pack();
        boardJFrame.setLocationRelativeTo(null);
        boardJFrame.setVisible(true);
    }                                  

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
            java.util.logging.Logger.getLogger(DataJFrameSmartHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataJFrameSmartHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataJFrameSmartHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataJFrameSmartHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataJFrameSmartHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables
}
