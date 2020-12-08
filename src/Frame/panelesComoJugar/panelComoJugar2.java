
package Frame.panelesComoJugar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class panelComoJugar2 extends javax.swing.JPanel {

 
    public panelComoJugar2() {
        initComponents();
        setLocation(0, 80);
        setSize(550, 254);
        establecerElementos();
    }
    
    private void establecerElementos(){
         ImageIcon imageTuna = new ImageIcon(new ImageIcon(getClass().getResource("/Images/tunaTablero.png")).getImage());
          
        JLabel tuna = new JLabel();
        tuna.setIcon(imageTuna);
        tuna.setSize(150, 250);
        tuna.setLocation(0, 0);
        tuna.setVisible(true);
        this.add(tuna);

        JLabel titulo = new JLabel();
        titulo.setSize(350, 250);
        titulo.setLocation(180, -100);
        titulo.setFont(new Font("PT Sans", Font.BOLD, 14));
        titulo.setForeground(new Color(243, 243, 220));
        titulo.setText("Numero de jugadores");
        titulo.setVisible(true);
        this.add(titulo);

        JLabel textoGeneral = new JLabel();
        textoGeneral.setSize(350, 250);
        textoGeneral.setLocation(180, -45);
        textoGeneral.setFont(new Font("PT Sans", Font.PLAIN, 14));
        textoGeneral.setForeground(new Color(243, 243, 220));
        textoGeneral.setText("<html>En una partida de patolli se permite jugar desde<br> "
                + "2 a 4 jugadores.</html>");
        textoGeneral.setVisible(true);
        this.add(textoGeneral);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(105, 2, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
