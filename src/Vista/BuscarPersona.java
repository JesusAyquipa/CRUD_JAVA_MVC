/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controladores.PersonaControlador;
import Modelos.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class BuscarPersona extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public BuscarPersona() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        txtBuscarPersona = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("CRUD con JAVA-MVC");

        btnConsultar.setText("Buscar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel10.setText("ID de usuario:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Correo", "Fecha", "Pais", "Profesion", "Rol_id"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnInicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGap(25, 25, 25)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnInicio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(txtBuscarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
       
       String idPersona = txtBuscarPersona.getText();
       if(idPersona.equals("")){
           JOptionPane.showMessageDialog(null, "Error al tratar de buscar", "Debes ingresar un ID", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       PersonaControlador controladorBuscar = new PersonaControlador();
       Persona buscarPersona = controladorBuscar.lectura(Integer.parseInt(idPersona));
       
       Object[] rowData = new Object[7];
       
       if(buscarPersona != null){
        // Llenamos el JTable con los datos de la persona
        rowData[0] = buscarPersona.getNombre();
        rowData[1] = buscarPersona.getApellido();
        rowData[2] = buscarPersona.getCorreo();
        rowData[3] = buscarPersona.getFecha_nacimiento();
        rowData[4] = buscarPersona.getPais();
        rowData[5] = buscarPersona.getProfesion();
        rowData[6] = buscarPersona.getRol_id();  

        // Crear un modelo para la tabla y agregar la fila con los datos
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        model.addRow(rowData); // Añadir la fila con los datos de la persona

       }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        String idPersona = txtBuscarPersona.getText();
        if(idPersona.equals("")){
            JOptionPane.showMessageDialog(null, "Error al tratar de eliminar", "Debes ingresar un ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonaControlador controladorEliminar = new PersonaControlador();
        controladorEliminar.eliminar(Integer.parseInt(idPersona));

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       String idPersona = txtBuscarPersona.getText().trim();
       if(idPersona.equals("")){
           JOptionPane.showMessageDialog(null, "Error al tratar de capturar ID", "Debes ingresar un ID", JOptionPane.ERROR_MESSAGE);
           return;
       }
    // Obtener la fila seleccionada de la tabla
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    // Obtener los valores de la fila seleccionada
    String nombre = jTable1.getValueAt(selectedRow, 0).toString();
    String apellido = jTable1.getValueAt(selectedRow, 1).toString();
    String correo = jTable1.getValueAt(selectedRow, 2).toString();
    String fechaString = jTable1.getValueAt(selectedRow, 3).toString();  // Obtener la fecha como String
    String pais = jTable1.getValueAt(selectedRow, 4).toString();
    String profesion = jTable1.getValueAt(selectedRow, 5).toString();
    int rol_id = Integer.parseInt(jTable1.getValueAt(selectedRow, 6).toString());

    // Convertir la fecha de String a Date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Asegúrate de que este formato coincida con la fecha en la tabla
    Date fechaNacimiento = null;

    try {
        fechaNacimiento = sdf.parse(fechaString);  // Convertir el String a Date
    } catch (ParseException e) {
        e.printStackTrace();  // Manejar el error si la fecha no se puede parsear
    }

    // Crear un nuevo objeto Persona con los datos editados
    Persona actualizarPersona = new Persona();
    actualizarPersona.setNombre(nombre);
    actualizarPersona.setApellido(apellido);
    actualizarPersona.setCorreo(correo);
    actualizarPersona.setFecha_nacimiento(fechaNacimiento);
    actualizarPersona.setPais(pais);
    actualizarPersona.setProfesion(profesion);
    actualizarPersona.setRol_id(rol_id);

    // Llamamos al controlador para actualizar la persona en la base de datos
    PersonaControlador controlador = new PersonaControlador();
    controlador.actualizar(actualizarPersona, Integer.parseInt(idPersona));
   

    JOptionPane.showMessageDialog(null, "Persona actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Inicio pr = new Inicio();
        pr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInicioActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPersona().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscarPersona;
    // End of variables declaration//GEN-END:variables
}
