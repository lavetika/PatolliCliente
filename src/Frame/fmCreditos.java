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
public class fmCreditos extends javax.swing.JFrame {

    /**
     * Creates new form fmCreditos
     */
    public fmCreditos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Créditos");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCreditos = new javax.swing.JPanel();
        lblCreditos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(398, 300));

        jPanelCreditos.setBackground(new java.awt.Color(105, 2, 5));
        jPanelCreditos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCreditos.setFont(new java.awt.Font("Herculanum", 0, 22)); // NOI18N
        lblCreditos.setText("Créditos");
        jPanelCreditos.add(lblCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 59));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/azteca32px.png"))); // NOI18N
        jPanelCreditos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        jPanelCreditos.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, 60));

        btnSalir.setBackground(new java.awt.Color(243, 243, 220));
        btnSalir.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanelCreditos.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                getImage(ClassLoader.getSystemResource("Images/azteca32px.png"));

        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelCreditos;
    private javax.swing.JLabel lblCreditos;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}