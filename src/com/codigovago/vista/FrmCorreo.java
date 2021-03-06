/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codigovago.vista;

import com.codigovago.controlador.Roles;
import com.codigovago.modelo.accesoDatos.CorreoElectronico;
import com.codigovago.modelo.accesoDatos.Empleados;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandra
 */
public class FrmCorreo extends javax.swing.JFrame {

    /**
     * Creates new form FrmCorreo
     */
    CorreoElectronico correo = new CorreoElectronico();
    Empleados empleados = new Empleados();
    Roles Roles = new Roles();

    public FrmCorreo() {
        this.setUndecorated(true);
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

        txtRecibe = new javax.swing.JTextField();
        btnEnviarCorreo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        fondoCambioClave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRecibe.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtRecibe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRecibe.setBorder(null);
        txtRecibe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecibeActionPerformed(evt);
            }
        });
        getContentPane().add(txtRecibe, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 173, 290, 30));

        btnEnviarCorreo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnEnviarCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/codigovago/assets/boton.png"))); // NOI18N
        btnEnviarCorreo.setContentAreaFilled(false);
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 310, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/codigovago/assets/icons/max.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 50, 40));

        fondoCambioClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/codigovago/assets/fondo4.png"))); // NOI18N
        getContentPane().add(fondoCambioClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRecibeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecibeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecibeActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        Roles.index();
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
        ImageIcon error = new ImageIcon(getClass().getResource("../assets/icons/error.png"));
        ImageIcon mail = new ImageIcon(getClass().getResource("../assets/icons/mail.png"));
        ImageIcon alerta = new ImageIcon(getClass().getResource("../assets/icons/alerta.png"));

        if (txtRecibe.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"No puede generar una nueva contraseña,\nDebe ingresar un correo electrónico..","Alerta",JOptionPane.PLAIN_MESSAGE, alerta);
        }else{
            if (correo.existeCorreo(txtRecibe.getText()) == 1){ 
                if (correo.setCorreo(txtRecibe.getText(), "CLAVE DE RECUPERACIÓN - Gestion Ordenes Ister")) {
                    JOptionPane.showMessageDialog(null,"Correo de Confirmación\n\nSu clave nueva se a generado con exito,\n verifique su correo electrónico..","Mensaje",JOptionPane.PLAIN_MESSAGE, mail);
                    txtRecibe.setText("");
                }else{
                    JOptionPane.showMessageDialog(null,"No puede generar una nueva contraseña, Consulte a su Administrador..","Alerta",JOptionPane.PLAIN_MESSAGE, alerta);
                    txtRecibe.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error!!!\nEl correo ingresado no existe..","REINTENTE!!",JOptionPane.PLAIN_MESSAGE, error);
                txtRecibe.setText("");
            }
        }
        error = null;
        mail = null;
        alerta = null;
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fondoCambioClave;
    private javax.swing.JTextField txtRecibe;
    // End of variables declaration//GEN-END:variables
}
