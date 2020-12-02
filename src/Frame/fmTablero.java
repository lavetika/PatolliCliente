package Frame;

import Control.Tablero;
import Dominio.Jugador;
import Graphics.Canias;
import broker.Broker;
import callMessage.Mandadero;
import enumServicio.EnumServicio;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class fmTablero extends javax.swing.JFrame implements Observer {

    private int tamanio;
    private Jugador jugador;
    private Broker broker;
    private PnlChat panelChat;
    private Tablero tablero;
    private Canias canias;
    private ArrayList<JButton> botones;
    private boolean turno;

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
        this.jugador = jugador;
        this.broker = broker;
        this.broker.addObserver(this);
        this.canias = new Canias();
        this.panelChat = new PnlChat(this.jugador, this.broker);
        this.tablero = new Tablero(broker, tamanio, canias);
        this.botones = tablero.getBotones();

        initPantalla();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                Mandadero mandadero = new Mandadero(EnumServicio.ABANDONO_JUGADOR);
                broker.solicitarPedido(mandadero);
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
        add(new PanelBotones(this, broker));
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

    public void enableButtons() {
        boolean turno = this.turno;
        for (JButton boton : botones) {
            boton.setEnabled(turno);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Mandadero m = (Mandadero) arg;

        switch (m.getTipoServicio()) {

            case ENVIAR_MENSAJE:
                panelChat.setDisplay((String) m.getRespuesta().get("mensaje"));
                System.out.println(m.toString() + " viene de tablero");
                break;
            case ABANDONO_JUGADOR:
                try {
                    this.broker.getCliente().desconectar();
                    fmMenu fmMenu = new fmMenu();
                    fmMenu.setVisible(true);
                    JOptionPane.showMessageDialog(this, "Has abandonado la partida:)");
                } catch (IOException ex) {
                    Logger.getLogger(fmTablero.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case MOVIMIENTO_FICHA:
                this.turno = (boolean) m.getRespuesta().get("turno");
                this.enableButtons();
                break;//TA WORKEAND
                
            
            
                
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
