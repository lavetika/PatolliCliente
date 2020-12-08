package Frame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class fmCreditos extends javax.swing.JFrame {

    public fmCreditos() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Créditos");
        
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                fmMenu fmMenu = new fmMenu();
                fmMenu.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanelCreditos = new javax.swing.JPanel();
        lblCreditos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblFondo1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(398, 300));

        jPanelCreditos.setBackground(new java.awt.Color(105, 2, 5));
        jPanelCreditos.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCreditos.setMinimumSize(new java.awt.Dimension(700, 405));
        jPanelCreditos.setName(""); // NOI18N
        jPanelCreditos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCreditos.setFont(new java.awt.Font("Herculanum", 0, 22)); // NOI18N
        lblCreditos.setText("Créditos");
        jPanelCreditos.add(lblCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 59));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/azteca32px.png"))); // NOI18N
        jPanelCreditos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        jPanelCreditos.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 80, 60));

        btnSalir.setBackground(new java.awt.Color(243, 243, 220));
        btnSalir.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnSalir.setText("Regresar");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanelCreditos.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 140, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tuna Development ©");
        jPanelCreditos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ChimueloDesertico.png"))); // NOI18N
        jPanelCreditos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ChimueloEstelar.png"))); // NOI18N
        jPanelCreditos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ChimueloLunaDeSangre.png"))); // NOI18N
        jPanelCreditos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ChimueloInfernal.png"))); // NOI18N
        jPanelCreditos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chimueloEspacial.png"))); // NOI18N
        jPanelCreditos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, -1));

        lblFondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        jPanelCreditos.add(lblFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 640, 60));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("<html>HAay TENGoO <br>MUCHA HAMBREeEe</html>");
        jPanelCreditos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 80, 80));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Daniel Ornelas");
        jPanelCreditos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Diana Jiménez");
        jPanelCreditos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Diana Castro");
        jPanelCreditos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Laura López");
        jPanelCreditos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ana Gámez");
        jPanelCreditos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("<html>Dios le da las peores batallas, <br>a sus mejores guerreros</html>");
        jPanelCreditos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 80, 100));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("<html>YA SUELTAME DIOSITO, <br>no quiero ser tu mejor <br>guerreroooo<br>OOhoohooo</html>");
        jPanelCreditos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, 100));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("<html>QUÉ TE DUELEE?, <br> amén</html>");
        jPanelCreditos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 80, 60));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("<html>loS HILOS,me caí, el observer...  </html>");
        jPanelCreditos.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 80, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        fmMenu frameMenu = new fmMenu();
        frameMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        this.btnSalir.setEnabled(false);
    }//GEN-LAST:event_btnSalirMouseClicked

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/azteca32px.png"));

        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelCreditos;
    private javax.swing.JLabel lblCreditos;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFondo1;
    // End of variables declaration//GEN-END:variables
}
