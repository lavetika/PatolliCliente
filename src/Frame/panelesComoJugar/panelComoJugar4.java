
package Frame.panelesComoJugar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class panelComoJugar4 extends javax.swing.JPanel {

    public panelComoJugar4() {
        initComponents();
        setLocation(0, 80);
        setSize(550, 254);
        establecerElementos();
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
        titulo.setText("Entiende el tablero.");
        titulo.setVisible(true);
        this.add(titulo);

        JLabel textoGeneral = new JLabel();
        textoGeneral.setSize(350, 250);
        textoGeneral.setLocation(180, 18);
        textoGeneral.setFont(new Font("PT Sans", Font.PLAIN, 13));
        textoGeneral.setForeground(new Color(243, 243, 220));
        textoGeneral.setText("<html><ul><li><b>Fichas e íconos.</b><br>El juego te asignará un color de fichas y  un ícono de forma aleatoria.</li>"
                + "<li><b>Cómo tirar las cañas.</b><br>En tu turno da click al botón que dice “lanzar cañas” ¡y checa cuánto te toca avanzar!</li>"
                + "<li><b>Mover  una ficha.</b><br>Cuando sea tu turno y hayas tirado las cañas da click en la ficha que desees mover.</li>"
                + "<li><b>Seleccionar apuesta.</b><br>seleccionas la cantidad que deseas apostar y comienzas a jugar.</li></ul></html>");
        textoGeneral.setVisible(true);
        this.add(textoGeneral);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
