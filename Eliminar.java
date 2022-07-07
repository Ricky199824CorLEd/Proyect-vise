
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Eliminar extends javax.swing.JFrame {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    ConexionBD conectar = new ConexionBD();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Eliminar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEliminarElemento = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mAgregar = new javax.swing.JMenu();
        mModificar = new javax.swing.JMenu();
        mEliminar = new javax.swing.JMenu();
        mBuscar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Escriba un nombre");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Correo", "Comentario"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnEliminarElemento.setText("Eliminar");
        btnEliminarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarElementoActionPerformed(evt);
            }
        });

        jMenu1.setText("Inicio");
        jMenuBar1.add(jMenu1);

        mAgregar.setText("Agregar");
        jMenuBar1.add(mAgregar);

        mModificar.setText("Modificar");
        jMenuBar1.add(mModificar);

        mEliminar.setText("Eliminar");
        jMenuBar1.add(mEliminar);

        mBuscar.setText("Buscar");
        jMenuBar1.add(mBuscar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarElemento))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminarElemento))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            con = conectar.GetConnection();
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM comentarios WHERE nombre = '"+txtBuscarNombre.getText()+"'");
            rs = ps.executeQuery();

            modelo = (DefaultTableModel) tabla.getModel();
            tabla.setModel(modelo);

            Object[] objeto = new Object[3];

            tabla.setRowHeight(35);
            tabla.setRowMargin(10);
            
            while(rs.next()) {
                objeto[0] = rs.getString(1);
                objeto[1] = rs.getString(2);
                objeto[2] = rs.getString(3);
                modelo.addRow(objeto);
            }

        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        }

        private void btnListarTodoActionPerformed(java.awt.event.ActionEvent evt) {
            try {
                con = conectar.GetConnection();
                ps = (PreparedStatement) con.prepareStatement("select * from comentarios");
                rs = ps.executeQuery();

                modelo = (DefaultTableModel) tabla.getModel();
                tabla.setModel(modelo);

                Object[] objeto = new Object[3];

                tabla.setRowHeight(35);
                tabla.setRowMargin(10);

                while (rs.next()) {
                    objeto[0] = rs.getString(1);
                    objeto[1] = rs.getString(2);
                    objeto[2] = rs.getString(3);

                    modelo.addRow(objeto);
                }
            } catch (Exception e) {
            }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarElementoActionPerformed
            try {
                con = conectar.GetConnection();
                String prueba = "DELETE FROM comentarios WHERE nombre = '"+txtBuscarNombre.getText()+"';";
                int eliminacion = ps.executeUpdate(prueba);
                JOptionPane.showMessageDialog(null, " REGISTRO ELIMINADO CON ÉXITO");
                
                modelo = (DefaultTableModel) tabla.getModel();
                tabla.setModel(modelo);

                Object[] objeto = new Object[3];

                tabla.setRowHeight(35);
                tabla.setRowMargin(10);

                while (rs.next()) {
                    objeto[0] = rs.getString(1);
                    objeto[1] = rs.getString(2);
                    objeto[2] = rs.getString(3);

                    modelo.addRow(objeto);
                }
            } catch (Exception e) {
                System.out.println(e);
            };
    }//GEN-LAST:event_btnEliminarElementoActionPerformed

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
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarElemento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mAgregar;
    private javax.swing.JMenu mBuscar;
    private javax.swing.JMenu mEliminar;
    private javax.swing.JMenu mModificar;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscarNombre;
    // End of variables declaration//GEN-END:variables
}
