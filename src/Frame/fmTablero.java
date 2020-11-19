/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;



import Control.Tablero;
import Dominio.Jugador;
import Graphics.Canias;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author laura
 */
public class fmTablero extends javax.swing.JFrame {
    int tamanio;
    Jugador jugador;
    /**
     * Creates new form fmTablero
     * @param tamanio
     * @param <error>
     */
    public fmTablero(int tamanio, Jugador jugador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tablero");
       
        this.tamanio = tamanio;
        initPantalla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void initPantalla(){
        Canias canias = new Canias();
       // add(new PnlChat());
        //add(new Tablero(tamanio, canias, this, new fmMenu(), jugador));
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(canias);
    }

      @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/calendario-azteca64px.png"));

        return retValue;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
