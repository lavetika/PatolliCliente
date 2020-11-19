/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author laura
 */
public class fmComoJugar extends javax.swing.JFrame {

    /**
     * Creates new form fmComoJugar
     */
    public fmComoJugar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cómo jugar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelComoJugar = new javax.swing.JPanel();
        lblComoJugar = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(502, 400));
        setMinimumSize(new java.awt.Dimension(502, 400));

        jPanelComoJugar.setBackground(new java.awt.Color(105, 2, 5));
        jPanelComoJugar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblComoJugar.setFont(new java.awt.Font("Herculanum", 0, 22)); // NOI18N
        lblComoJugar.setText("Cómo Jugar");
        jPanelComoJugar.add(lblComoJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, 40));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maya32px.png"))); // NOI18N
        jPanelComoJugar.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        jPanelComoJugar.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 530, 60));

        btnSalir.setBackground(new java.awt.Color(243, 243, 220));
        btnSalir.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanelComoJugar.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelComoJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelComoJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        fmMenu frameMenu = new fmMenu();
        frameMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed


          @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/maya32px.png"));

        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelComoJugar;
    private javax.swing.JLabel lblComoJugar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIcono;
    // End of variables declaration//GEN-END:variables
}
