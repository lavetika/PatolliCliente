
package Frame;


import Frame.panelesComoJugar.panelComoJugar1;
import Frame.panelesComoJugar.panelComoJugar2;
import Frame.panelesComoJugar.panelComoJugar3;
import Frame.panelesComoJugar.panelComoJugar4;
import Frame.panelesComoJugar.panelComoJugar5;
import Frame.panelesComoJugar.panelComoJugar6;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;


public class fmComoJugar extends javax.swing.JFrame {

    private JPanel panelSiguiente;
    private JPanel panelActual;
    private int numPagina;
    
    public fmComoJugar() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cómo jugar");
        initPanel();
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelComoJugar = new javax.swing.JPanel();
        lblComoJugar = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(502, 400));

        jPanelComoJugar.setBackground(new java.awt.Color(105, 2, 5));
        jPanelComoJugar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblComoJugar.setFont(new java.awt.Font("Herculanum", 0, 22)); // NOI18N
        lblComoJugar.setText("Cómo Jugar");
        jPanelComoJugar.add(lblComoJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, 40));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maya32px.png"))); // NOI18N
        jPanelComoJugar.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FED148.jpeg"))); // NOI18N
        lblFondo.setMaximumSize(new java.awt.Dimension(550, 280));
        lblFondo.setMinimumSize(new java.awt.Dimension(550, 280));
        lblFondo.setPreferredSize(new java.awt.Dimension(550, 280));
        jPanelComoJugar.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 550, 60));

        jPanel1.setBackground(new java.awt.Color(71, 2, 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 52));

        btnRegresar.setBackground(new java.awt.Color(243, 243, 220));
        btnRegresar.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(243, 243, 220));
        btnSiguiente.setFont(new java.awt.Font("Herculanum", 0, 14)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelComoJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelComoJugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       this.numPagina--;
       cargarSiguintePanel();  
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.numPagina++;
        cargarSiguintePanel();
    }//GEN-LAST:event_btnSiguienteActionPerformed

          @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/maya32px.png"));

        return retValue;
    }
    
    private void cargarSiguintePanel(){
     
        switch(numPagina) {
            
            case 1: panelSiguiente = new panelComoJugar1(); break;
            
            case 2: panelSiguiente = new panelComoJugar2(); break;
            
            case 3: panelSiguiente = new panelComoJugar3(); break;
            
            case 4: panelSiguiente = new panelComoJugar4(); break;
            
            case 5: panelSiguiente = new panelComoJugar5(); break;
            
            case 6: panelSiguiente = new panelComoJugar6(); break;
        }
        
        cargarNuevoPanel();
    }

    private void cargarNuevoPanel() {

        if (numPagina >= 1 && numPagina <= 6) {
            remove(this.panelActual);
            add(this.panelSiguiente);
            repaint();
            panelActual = panelSiguiente;
        } else {
            regresarMenu();
        }
    }

    public void regresarMenu() {
        Frame.fmMenu frmMenu = new Frame.fmMenu();
        frmMenu.setVisible(true);
        dispose();
    }
    
    private void initPanel(){
        this.numPagina = 1;
        this.panelActual = new panelComoJugar1();
        add(panelActual);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelComoJugar;
    private javax.swing.JLabel lblComoJugar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIcono;
    // End of variables declaration//GEN-END:variables
}
