package Frame;

import Control.Tablero;
import Dominio.Ficha;
import Dominio.Jugador;
import Dominio.TipoJugador;
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
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class fmTablero extends javax.swing.JFrame implements Observer {

    private int tamanio;
    private Broker broker;
    private PnlChat panelChat;
    private Tablero tablero;
    private PanelBotones pb;
    private Canias canias;
    private ArrayList<JButton> botones;
    private boolean turno;

    /**
     * Creates new form fmTablero
     *
     * @param tamanio
     * @param broker
     */
    public fmTablero(int tamanio, Broker broker) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tablero");
        this.tamanio = tamanio;
        this.broker = broker;
        this.broker.addObserver(this);
        this.canias = new Canias();
        this.panelChat = new PnlChat(this.broker);
        this.tablero = new Tablero(this.broker, this.tamanio, canias);
        this.pb = new PanelBotones(this, broker);
//        this.botones = tablero.getBotones();

        initPantalla();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
//                int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?",
//                        "Confirmar abandono de partida", JOptionPane.OK_CANCEL_OPTION);
//                if (resp == JOptionPane.OK_OPTION) {
                    dispose();
                    Mandadero mandadero = new Mandadero(EnumServicio.ABANDONO_JUGADOR);
                    broker.solicitarPedido(mandadero);
//                }
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
        add(pb);
        add(canias);
        setSize(1350, 800);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public void posicionarJugador(List<Jugador> posicion) {
        tablero.limpiarNicknames();
        for (int i = 0; i < posicion.size(); i++) {
            this.tablero.getEtiquetaJugadores().get(i).setText(posicion.get(i).getNickname());
        }
        this.tablero.repaint();

    }

    public void posicionarFichas(List<Jugador> jugadores) {
        for (int i = 0; i < jugadores.size(); i++) {//recorrer jugador

            for (int j = 0; j < jugadores.get(i).getFichas().size(); j++) {//recorrer fichas de jugador
                jugadores.get(i).getFichas().get(j).getFicha().setIcon(this.tablero.getIconosFichas().get(i));
                this.tablero.getFichas().add(jugadores.get(i).getFichas().get(j));
            }
        }
        tablero.colocarFichasTablero();
        tablero.repaint();
    }

//    public void asignarColorFichas(Jugador jugador) {
//        for (int i = 0; i < jugador.getFichas().size(); i++) {
//            jugador.getFichas().get(i).setFicha(this.tablero.getEtiquetaFichas().get(i));
//        }
//        
//    }
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

    public List<Ficha> getFichas() {
        return this.tablero.getFichas();
    }

    @Override
    public void update(Observable o, Object arg) {
        Mandadero m = (Mandadero) arg;

        switch (m.getTipoServicio()) {

            case ENVIAR_MENSAJE:
                panelChat.setDisplay((String) m.getRespuesta().get("mensaje"));
//                System.out.println(m.toString() + " viene de tablero");
                break;
            case ABANDONO_JUGADOR: {
                try {
                    this.broker.getCliente().desconectar();
                } catch (IOException ex) {
                    System.out.println("Error en el abandono jugador de frmTablero.");
                }
            }
            fmMenu fmMenu = new fmMenu();
            fmMenu.setVisible(true);
//            JOptionPane.showMessageDialog(this, "Has abandonado la partida. :)");
            break;
            case MOVIMIENTO_FICHA:
                this.turno = (boolean) m.getRespuesta().get("turno");
                this.enableButtons();
                break;
            case POSICIONAR_JUGADOR:
                if (m.getRespuesta().containsKey("host")) {
                    Jugador jugador=(Jugador) m.getRespuesta().get("host");
                    boolean partidaIniciada= (boolean) m.getRespuesta().get("iniciado");
                    this.habilitarBoton(jugador,partidaIniciada);
                }
                this.posicionarJugador((List) m.getRespuesta().get("posiciones"));
                break;
            case ASIGNAR_TURNO:
                this.posicionarFichas((List) m.getRespuesta().get("posiciones"));
                break;

        }
    }

    public void habilitarBoton(Jugador jugadorHost, boolean partidaIniciada) {
        if (jugadorHost.getNickname().equals(this.broker.getJugador().getNickname())) {
            this.broker.getJugador().setTipoJugador(TipoJugador.HOST);
        }
        if (this.broker.getJugador().getTipoJugador().equals(TipoJugador.HOST)) {
            this.pb.getBotones().get(0).setVisible(true);
            if(partidaIniciada){
               this.pb.getBotones().get(0).setEnabled(false); 
            }
        } else {
            this.pb.getBotones().get(0).setVisible(false);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
