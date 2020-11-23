package Frame;

import Dominio.Jugador;
import java.awt.Image;
import java.awt.Toolkit;

public class fmMenu extends javax.swing.JFrame {

    public fmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Patolli Plustl");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanelMenuPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        btnCrearPartida = new javax.swing.JButton();
        btnIngresarPartida = new javax.swing.JButton();
        btnComoJugar = new javax.swing.JButton();
        btnCreditos = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();
        lb_nickname = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanelMenuPrincipal.setBackground(new java.awt.Color(105, 2, 5));
        jPanelMenuPrincipal.setMaximumSize(new java.awt.Dimension(356, 418));
        jPanelMenuPrincipal.setMinimumSize(new java.awt.Dimension(356, 418));
        jPanelMenuPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Herculanum", 0, 24)); // NOI18N
        lblTitulo.setText("Patolli");
        jPanelMenuPrincipal.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 30));

        lblTitulo1.setFont(new java.awt.Font("Herculanum", 0, 18)); // NOI18N
        lblTitulo1.setText("Plustl");
        jPanelMenuPrincipal.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, 20));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/calendario-azteca64px.png"))); // NOI18N
        jPanelMenuPrincipal.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        btnCrearPartida.setBackground(new java.awt.Color(243, 243, 220));
        btnCrearPartida.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnCrearPartida.setText("Crear Partida");
        btnCrearPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPartidaActionPerformed(evt);
            }
        });
        jPanelMenuPrincipal.add(btnCrearPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 176, 49));

        btnIngresarPartida.setBackground(new java.awt.Color(243, 243, 220));
        btnIngresarPartida.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnIngresarPartida.setText("Ingresar Partida");
        btnIngresarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPartidaActionPerformed(evt);
            }
        });
        jPanelMenuPrincipal.add(btnIngresarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 176, 52));

        btnComoJugar.setBackground(new java.awt.Color(243, 243, 220));
        btnComoJugar.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnComoJugar.setText("Cómo Jugar");
        btnComoJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComoJugarActionPerformed(evt);
            }
        });
        jPanelMenuPrincipal.add(btnComoJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 176, 45));

        btnCreditos.setBackground(new java.awt.Color(243, 243, 220));
        btnCreditos.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnCreditos.setText("Créditos");
        btnCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditosActionPerformed(evt);
            }
        });
        jPanelMenuPrincipal.add(btnCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 176, 46));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        jPanelMenuPrincipal.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 360, 90));

        lb_nickname.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMenuPrincipal.add(lb_nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 120, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ajolotito.png"))); // NOI18N
        jPanelMenuPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 110, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPartidaActionPerformed

        fmCrearPartida framePersonalizarPartida = new fmCrearPartida();
        framePersonalizarPartida.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearPartidaActionPerformed

    private void btnComoJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComoJugarActionPerformed
        fmComoJugar frameComoJugar = new fmComoJugar();
        frameComoJugar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnComoJugarActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        fmCreditos frameCreditos = new fmCreditos();
        frameCreditos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCreditosActionPerformed

    private void btnIngresarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPartidaActionPerformed
        fmIngresarPartida frameIngresar = new fmIngresarPartida();
        frameIngresar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnIngresarPartidaActionPerformed

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
            java.util.logging.Logger.getLogger(fmIngresarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmIngresarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmIngresarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmIngresarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmMenu().setVisible(true);
            }
        });
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/calendario-azteca64px.png"));

        return retValue;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComoJugar;
    private javax.swing.JButton btnCrearPartida;
    private javax.swing.JButton btnCreditos;
    private javax.swing.JButton btnIngresarPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanelMenuPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_nickname;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    // End of variables declaration//GEN-END:variables
}
