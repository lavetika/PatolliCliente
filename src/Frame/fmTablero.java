/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Control.Tablero;
import Dominio.Jugador;
import Graphics.Canias;
import broker.Broker;
import callMessage.Mandadero;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author laura
 */
public class fmTablero extends javax.swing.JFrame implements Observer{

    
    int tamanio;
    Jugador jugador;
    Broker broker;
    PnlChat panelChat; 
    Tablero tablero;
    Canias canias;

    /**
     * Creates new form fmTablero
     *
     * @param tamanio
     * @param jugador
     * @param broker
     */
    public fmTablero(int tamanio, Jugador jugador, Broker broker) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tablero");     
        this.tamanio = tamanio;
        this.jugador=jugador;
        this.broker=broker;
        this.broker.addObserver(this);
        this.canias = new Canias();
        this.panelChat = new PnlChat(this.jugador, this.broker);
        this.tablero = new Tablero(tamanio, canias, this, new fmMenu());
        
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
        setBackground(new java.awt.Color(105, 2, 5));
        setIconImage(getIconImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initPantalla() {
        
        add(panelChat);
        add(tablero);
        add(new PanelBotones(this));
        add(canias);
        setSize(1350, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);                
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/calendario-azteca64px.png"));

        return retValue;
    }

    @Override
    public void update(Observable o, Object arg) {
        Mandadero m = (Mandadero)arg;
        switch(m.getTipoServicio()){
            //este sí lo necesitamos, aquí le llega
            case ENVIAR_MENSAJE:
                
                panelChat.setDisplay((String)m.getRespuesta().get("mensaje"));
                //sí lo necesita, sí
                System.out.println(m.toString()+" viene de tablero");
                break;
       
        }
        
    
    }
    
    
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
