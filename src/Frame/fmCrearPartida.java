package Frame;

import Dominio.Jugador;
import conexionCliente.ClienteSocket;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fmCrearPartida extends javax.swing.JFrame {

    ClienteSocket cliente;

    public fmCrearPartida() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Crear partida");
        this.llenarCmbGemas();
        this.llenarCmbJugadores();
        this.llenarCmbTablero();
        cliente = new ClienteSocket("localhost", 9090);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCrearPartida = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cbCantGemas = new javax.swing.JComboBox<>();
        lblCantGemas = new javax.swing.JLabel();
        cbNumeroMaxJugadores = new javax.swing.JComboBox<>();
        lblNumeroMaxJugadores = new javax.swing.JLabel();
        lblCrearPartida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTamanioTablero1 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        cbTamanioTablero1 = new javax.swing.JComboBox<>();
        lblNickName = new javax.swing.JLabel();
        txtNickname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(556, 314));

        jPanelCrearPartida.setBackground(new java.awt.Color(105, 2, 5));
        jPanelCrearPartida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(243, 243, 220));
        btnCancelar.setFont(new java.awt.Font("Herculanum", 0, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanelCrearPartida.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 160, -1));

        btnGuardar.setBackground(new java.awt.Color(243, 243, 220));
        btnGuardar.setFont(new java.awt.Font("Herculanum", 0, 16)); // NOI18N
        btnGuardar.setText("Crear Partida");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanelCrearPartida.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 160, -1));

        cbCantGemas.setBackground(new java.awt.Color(243, 243, 220));
        cbCantGemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCantGemasActionPerformed(evt);
            }
        });
        jPanelCrearPartida.add(cbCantGemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 60, 33));

        lblCantGemas.setBackground(new java.awt.Color(105, 2, 5));
        lblCantGemas.setFont(new java.awt.Font("PT Sans", 0, 18)); // NOI18N
        lblCantGemas.setForeground(new java.awt.Color(243, 243, 220));
        lblCantGemas.setText("Cantidad de gemas");
        jPanelCrearPartida.add(lblCantGemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 260, 33));

        cbNumeroMaxJugadores.setBackground(new java.awt.Color(243, 243, 220));
        jPanelCrearPartida.add(cbNumeroMaxJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 50, 33));

        lblNumeroMaxJugadores.setFont(new java.awt.Font("PT Sans", 0, 18)); // NOI18N
        lblNumeroMaxJugadores.setForeground(new java.awt.Color(243, 243, 220));
        lblNumeroMaxJugadores.setText("Número máximo de jugadores");
        jPanelCrearPartida.add(lblNumeroMaxJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 33));

        lblCrearPartida.setFont(new java.awt.Font("Herculanum", 0, 22)); // NOI18N
        lblCrearPartida.setText("Crear partida");
        jPanelCrearPartida.add(lblCrearPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maya.png"))); // NOI18N
        jPanelCrearPartida.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        lblTamanioTablero1.setBackground(new java.awt.Color(105, 2, 5));
        lblTamanioTablero1.setFont(new java.awt.Font("PT Sans", 0, 18)); // NOI18N
        lblTamanioTablero1.setForeground(new java.awt.Color(243, 243, 220));
        lblTamanioTablero1.setText("Tamaño del tablero");
        jPanelCrearPartida.add(lblTamanioTablero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 277, 33));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        jPanelCrearPartida.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 560, 50));

        cbTamanioTablero1.setBackground(new java.awt.Color(243, 243, 220));
        cbTamanioTablero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTamanioTablero1ActionPerformed(evt);
            }
        });
        jPanelCrearPartida.add(cbTamanioTablero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 60, 33));

        lblNickName.setFont(new java.awt.Font("PT Sans", 0, 18)); // NOI18N
        lblNickName.setForeground(new java.awt.Color(243, 243, 220));
        lblNickName.setText("Nickname*");
        jPanelCrearPartida.add(lblNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        txtNickname.setBackground(new java.awt.Color(243, 243, 220));
        txtNickname.setFont(new java.awt.Font("PT Sans", 0, 13)); // NOI18N
        txtNickname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNicknameKeyTyped(evt);
            }
        });
        jPanelCrearPartida.add(txtNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelCrearPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCrearPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCantGemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCantGemasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCantGemasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        fmMenu frameMenu = new fmMenu();
        frameMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (validarNickname()) {
            Jugador jugador = new Jugador(txtNickname.getText());
            jugador.setCodigoPartida(Integer.parseInt("12345"));
            iniciarCliente(jugador);
            fmTablero frameTablero = new fmTablero((Integer) cbTamanioTablero1.getSelectedItem(), jugador, cliente.getBroker());

            frameTablero.setVisible(true);
            this.dispose();

        } else {
            lblNickName.setText("*Ingresa tu nickname");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void iniciarCliente(Jugador jugador) {
        try {
            cliente.iniciar();
            cliente.getBroker().setJugador(jugador);
        } catch (IOException ex) {
            Logger.getLogger(fmCrearPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cbTamanioTablero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTamanioTablero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTamanioTablero1ActionPerformed

    public boolean validarNickname() {
        return !txtNickname.getText().isEmpty();
    }

    private void txtNicknameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicknameKeyTyped
        char a = evt.getKeyChar();
        if ((txtNickname.getText().length() >= 10)) {//que sea menor a 10 letras
            evt.consume();
        }
    }//GEN-LAST:event_txtNicknameKeyTyped

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/maya.png"));

        return retValue;
    }

    private void llenarCmbJugadores() {
        cbNumeroMaxJugadores.addItem(2);
        cbNumeroMaxJugadores.addItem(3);
        cbNumeroMaxJugadores.addItem(4);
    }

    private void llenarCmbGemas() {
        cbCantGemas.addItem(10);
        cbCantGemas.addItem(15);
        cbCantGemas.addItem(20);
        cbCantGemas.addItem(25);
        cbCantGemas.addItem(30);
    }

    private void llenarCmbTablero() {
        cbTamanioTablero1.addItem(28);
        cbTamanioTablero1.addItem(36);
        cbTamanioTablero1.addItem(44);
        cbTamanioTablero1.addItem(52);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Integer> cbCantGemas;
    private javax.swing.JComboBox<Integer> cbNumeroMaxJugadores;
    private javax.swing.JComboBox<Integer> cbTamanioTablero1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelCrearPartida;
    private javax.swing.JLabel lblCantGemas;
    private javax.swing.JLabel lblCrearPartida;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNickName;
    private javax.swing.JLabel lblNumeroMaxJugadores;
    private javax.swing.JLabel lblTamanioTablero1;
    private javax.swing.JTextField txtNickname;
    // End of variables declaration//GEN-END:variables
}
