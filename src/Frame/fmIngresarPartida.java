/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dominio.Jugador;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author laura
 */
public class fmIngresarPartida extends javax.swing.JFrame {

    Jugador jugador;
    /**
     * Creates new form fmIngresarPartida
     */
    public fmIngresarPartida(Jugador jugador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Ingresar partida");
        this.jugador = jugador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelIngresarPartida = new javax.swing.JPanel();
        lblIngresarPartida = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        lb_codigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(558, 275));

        jPanelIngresarPartida.setBackground(new java.awt.Color(105, 2, 5));
        jPanelIngresarPartida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIngresarPartida.setFont(new java.awt.Font("Herculanum", 0, 20)); // NOI18N
        lblIngresarPartida.setText("Ingresar Partida");
        jPanelIngresarPartida.add(lblIngresarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 58));

        btnIngresar.setBackground(new java.awt.Color(243, 243, 220));
        btnIngresar.setFont(new java.awt.Font("Herculanum", 0, 16)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanelIngresarPartida.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 144, -1));

        btnCancelar.setBackground(new java.awt.Color(243, 243, 220));
        btnCancelar.setFont(new java.awt.Font("Herculanum", 0, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanelIngresarPartida.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 131, -1));

        jLabel1.setFont(new java.awt.Font("PT Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 220));
        jLabel1.setText("Código de la partida");
        jPanelIngresarPartida.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        txtCodigo.setBackground(new java.awt.Color(243, 243, 220));
        txtCodigo.setFont(new java.awt.Font("PT Sans", 0, 18)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanelIngresarPartida.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 210, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/piramide-maya.png"))); // NOI18N
        jPanelIngresarPartida.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        jPanelIngresarPartida.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 560, 60));

        lb_codigo.setForeground(new java.awt.Color(255, 255, 255));
        jPanelIngresarPartida.add(lb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 150, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIngresarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIngresarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        fmMenu frameMenu = new fmMenu();
        frameMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public boolean validarCodigo(){
        return !txtCodigo.getText().isEmpty()&&txtCodigo.getText().length()==5;
    }
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (validarCodigo()) {
            this.jugador.setCodigoPartida(Integer.parseInt(txtCodigo.getText()));
            fmTablero frameTablero = new fmTablero(44, this.jugador);
            frameTablero.setVisible(true);
            this.setVisible(false);
        } else {
            lb_codigo.setText("*Ingrese un código válido");
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char a = evt.getKeyChar();
        if ((!Character.isDigit(a) || txtCodigo.getText().length() >= 5)) {//que sean solo números
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/piramide-maya.png"));

        return retValue;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelIngresarPartida;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIngresarPartida;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
