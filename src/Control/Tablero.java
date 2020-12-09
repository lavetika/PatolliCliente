/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dominio.Ficha;
import Enumaration.EnumCasilla;
import Enumaration.EnumDireccion;
import Graphics.Canias;
import Graphics.Cuadrangular;
import Graphics.Forma;
import Graphics.SemiCircular;
import broker.Broker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author laura
 */
public final class Tablero extends JPanel {

    private int cantidadTablero;
    private int cantidadLado;
    private int cantidadCasillasCentrales;
    private int cantidadSemiCirculo;
    private int tamanioCasilla;
    private Canias lanzar;
    private Broker broker;

    private ArrayList<ImageIcon> iconosFichas;
    private ArrayList<JLabel> etiquetaJugadores;
    private ArrayList<JButton> botones;
    private ArrayList<Forma> casillas;
    private ArrayList<Ficha> fichas;
    private int[] valoresX;
    private int[] valoresY;

    public Tablero(Broker broker, int tamanio, Canias canias) {
        setLayout(new GroupLayout(this));
        setSize(900, 800);
        this.setLocation(150, 0);
        setBackground(new Color(105, 2, 5));
        this.cantidadTablero = tamanio;
        this.cantidadCasillasCentrales = 4;
        this.cantidadSemiCirculo = 8;
        this.tamanioCasilla = 40;
        this.lanzar = canias;
        this.casillas = new ArrayList<>();
        this.fichas = new ArrayList<>();
        this.botones = new ArrayList<>();
        this.etiquetaJugadores = new ArrayList<>();
        this.broker = broker;
        this.iconosFichas = new ArrayList<>();
        incializarArreglosPos();
        generarCasillas();
        calcularTablero();
        showNicknames();
        inicializarIconos();

    }

    public void incializarArreglosPos() {
        this.valoresX = new int[]{555, 555, 515, 515, 515, 595, 555, 555, 515, 515,
            515, 595, 310, 310, 350, 350, 350, 270, 310, 310, 350, 350, 350, 270};

        this.valoresY = new int[]{300, 260, 220, 260, 300, 300, 460, 500, 460, 500,
            540, 460, 300, 260, 220, 260, 300, 300, 460, 500, 460, 500, 540, 460};

    }

    public void colocarFichasTablero() {
        for (int i = 0; i < fichas.size(); i++) {
            fichas.get(i).getFicha().setSize(40, 40);
            fichas.get(i).getFicha().setLocation(this.valoresX[i], this.valoresY[i]);
            fichas.get(i).getFicha().setVisible(true);
            this.add(fichas.get(i).getFicha());
        }
    }

    public void inicializarIconos() {

        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/fichaazul32px.png")).getImage());
        this.iconosFichas.add(imageIcon1);

        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/fichaverde32px.png")).getImage());
        this.iconosFichas.add(imageIcon2);

        ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/ficharoja32px.png")).getImage());
        this.iconosFichas.add(imageIcon3);

        ImageIcon imageIcon4 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/fichanaranja32px.png")).getImage());
        this.iconosFichas.add(imageIcon4);
    }

    public ArrayList<ImageIcon> getIconosFichas() {
        return iconosFichas;
    }

    public void setIconosFichas(ArrayList<ImageIcon> iconosFichas) {
        this.iconosFichas = iconosFichas;
    }

    public ArrayList<JLabel> getEtiquetaJugadores() {
        return etiquetaJugadores;
    }

    public void limpiarNicknames() {
        etiquetaJugadores.forEach((etiquetaJugador) -> {
            etiquetaJugador.setText("");
        });
    }

    public void generarCasillas() {
        switch (cantidadTablero) {
            case 44:
                for (int i = 0; i < cantidadTablero; i++) {
                    if (i != 5 && i != 6
                            && i != 16 && i != 17
                            && i != 27 && i != 28
                            && i != 38 && i != 39) {
                        casillas.add(new Cuadrangular());
                    } else {
                        casillas.add(new SemiCircular());
                    }
                }
                break;
            case 36:
                for (int i = 0; i < cantidadTablero; i++) {
                    if (i != 4 && i != 5
                            && i != 13 && i != 14
                            && i != 22 && i != 23
                            && i != 31 && i != 32) {
                        casillas.add(new Cuadrangular());
                    } else {
                        casillas.add(new SemiCircular());
                    }
                }
                break;
            case 28:
                for (int i = 0; i < cantidadTablero; i++) {
                    if (i != 3 && i != 4
                            && i != 10 && i != 11
                            && i != 17 && i != 18
                            && i != 24 && i != 25) {
                        casillas.add(new Cuadrangular());
                    } else {
                        casillas.add(new SemiCircular());
                    }
                }
                break;
            case 52:
                for (int i = 0; i < cantidadTablero; i++) {
                    if (i != 6 && i != 7
                            && i != 19 && i != 20
                            && i != 32 && i != 33
                            && i != 45 && i != 46) {
                        casillas.add(new Cuadrangular());
                    } else {
                        casillas.add(new SemiCircular());
                    }
                }
                break;
        }
    }

    public void calcularTablero() {
        int numeroAspas = 4;
        int numeroHileras = 2;
        this.cantidadLado = ((cantidadTablero - (cantidadCasillasCentrales + cantidadSemiCirculo)) / numeroAspas) / numeroHileras;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTablero(g);
    }

    public void drawTablero(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        showButtons(g);
        showPlayersIcons();
        showGemas();
        
        showApuestaRestante();
        drawBaseTablero(g);
        drawCasillas(g2d);

    }

    public void drawBaseTablero(Graphics g) {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Images/CalendarioDelSolFondoNegro.png")).getImage());
        Image imagen = imageIcon.getImage();

        g.drawImage(imagen, 125, 75, null);
    }

    public int posicionar(int x, int y, EnumDireccion direccion) {

        switch (direccion) {
            case ARRIBA:
                y = y - this.tamanioCasilla;
                return y;
            case ABAJO:
                y = y + this.tamanioCasilla;
                return y;
            case IZQUIERDA:
                x = x - this.tamanioCasilla;
                return x;
            default:
                x = x + this.tamanioCasilla;
                return x;
        }
    }

    public void drawCasillas(Graphics2D g2d) {
        Dimension tamano = getSize();
        int x = (int) tamano.getWidth();
        int y = (int) tamano.getHeight();

        //Posicionarlo en el centro
        x = x / 2;
        y = y / 2;

        int divido = cantidadTablero / 4;
        int div = divido / 2;
        int pos = div;
        int semi = div;

        for (int i = 0; i < casillas.size(); i++) {
            if (i == 0) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.CENTRAL);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.CENTRO);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.DERECHA);
            } else if (i > 0 && i < pos) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.DERECHA);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.DERECHA);
            } else if (i == semi) {
                x = x + 1;
                x = posicionar(x, y, EnumDireccion.IZQUIERDA);
                y = posicionar(x, y, EnumDireccion.ARRIBA);
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(0);
                casillas.get(i).setDireccion(EnumDireccion.DERECHA);
                casillas.get(i).draw(g2d);
            } else if (i == (semi+1)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(270);
                casillas.get(i).setDireccion(EnumDireccion.DERECHA);
                casillas.get(i).draw(g2d);
                x = x - 1;
                pos = (semi + 1);
            } else if (i > pos && i < (pos + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.DERECHA);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.IZQUIERDA);
                
            } else if (i == (pos + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.CENTRAL);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.CENTRO);
                casillas.get(i).draw(g2d);
                y = posicionar(x, y, EnumDireccion.ARRIBA);
               
            } else if (i > (pos + div) && i < ((pos + div) + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.ARRIBA);
                casillas.get(i).draw(g2d);
                y = posicionar(x, y, EnumDireccion.ARRIBA);
                
            } else if (i == ((pos + div) + div)) {

                x = posicionar(x, y, EnumDireccion.IZQUIERDA);
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(360);
                casillas.get(i).setDireccion(EnumDireccion.ARRIBA);
                casillas.get(i).draw(g2d);
            } else if (i == (((pos + div) + div))+1) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(90);
                casillas.get(i).setDireccion(EnumDireccion.DERECHA);
                casillas.get(i).draw(g2d);
                y = posicionar(x, y, EnumDireccion.ABAJO);
            } else if (i > (((pos + div) + div))+1 && i < ((((pos + div) + div))+1 + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.DERECHA);
                casillas.get(i).draw(g2d);
                y = posicionar(x, y, EnumDireccion.ABAJO);
            } else if (i == ((((pos + div) + div))+1 + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.CENTRAL);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.CENTRO);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.IZQUIERDA);
            } else if (i > ((((pos + div) + div))+1 + div) && i < (((((pos + div) + div))+1 + div) + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.IZQUIERDA);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.IZQUIERDA);
            } else if (i == (((((pos + div) + div))+1 + div) + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(90);
                casillas.get(i).setDireccion(EnumDireccion.IZQUIERDA);
                casillas.get(i).draw(g2d);
                semi = semi + 1;
            } else if (i == ((((((pos + div) + div))+1 + div) + div))+1) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(180);
                casillas.get(i).setDireccion(EnumDireccion.IZQUIERDA);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.DERECHA);
                y = posicionar(x, y, EnumDireccion.ABAJO);
            } else if (i > ((((((pos + div) + div))+1 + div) + div))+1 && i < ((((((((pos + div) + div))+1 + div) + div))+1) + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.IZQUIERDA);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.DERECHA);
            } else if (i == ((((((((pos + div) + div))+1 + div) + div))+1) + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.CENTRAL);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.CENTRO);
                casillas.get(i).draw(g2d);
                y = posicionar(x, y, EnumDireccion.ABAJO);
               
            } else if (i > ((((((((pos + div) + div))+1 + div) + div))+1) + div) && i < ((((((((((pos + div) + div))+1 + div) + div))+1) + div)) + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.ABAJO);
                casillas.get(i).draw(g2d);
                y = posicionar(x, y, EnumDireccion.ABAJO);
            } else if (i == ((((((((((pos + div) + div))+1 + div) + div))+1) + div)) + div)) {
                y = y + 1;
                y = posicionar(x, y, EnumDireccion.ARRIBA);
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(180);
                casillas.get(i).setDireccion(EnumDireccion.IZQUIERDA);
                casillas.get(i).draw(g2d);
            } else if (i == (((((((((((pos + div) + div))+1 + div) + div))+1) + div)) + div))+1) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.ESQUINA);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setRotacion(270);
                casillas.get(i).setDireccion(EnumDireccion.IZQUIERDA);
                casillas.get(i).draw(g2d);
                x = posicionar(x, y, EnumDireccion.DERECHA);
                y = y - 1;
            } else if (i > (((((((((((pos + div) + div))+1 + div) + div))+1) + div)) + div))+1 && i < (((((((((((((pos + div) + div))+1 + div) + div))+1) + div)) + div))+1) + div)) {
                casillas.get(i).setPosition(i);
                casillas.get(i).setForma(EnumCasilla.INICIO);
                casillas.get(i).setPositionX(x);
                casillas.get(i).setPositionY(y);
                casillas.get(i).setTamanio(tamanioCasilla);
                casillas.get(i).setDireccion(EnumDireccion.IZQUIERDA);
                casillas.get(i).draw(g2d);
                y = posicionar(x, y, EnumDireccion.ARRIBA);
            }

        }
    }

    public void showButtons(Graphics g) {
//        JButton btnIniciar = new JButton("Iniciar");
//
//        btnIniciar.setSize(150, 35);
//        btnIniciar.setVisible(true);
//        btnIniciar.setLocation(740, 585);
//        btnIniciar.setForeground(Color.BLACK);
//        btnIniciar.setBackground(new Color(250, 206, 71));
//        btnIniciar.setFont(new Font("Herculanum", Font.BOLD, 14));
//        btnIniciar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                posicionarFichas();
//            }
//        });
//        this.add(btnIniciar);
//        botones.add(btnIniciar);

        //Falta hacer dinamica esta parte con la cantidad de jugadores en la partida
//        this.add(fichas.get(0).getFicha());
//        this.add(fichas.get(6).getFicha());
//        this.add(fichas.get(12).getFicha());
//        this.add(fichas.get(18).getFicha());
        JButton btnLanzar = new JButton("Lanzar cañas");

        botones.add(btnLanzar);
        btnLanzar.setSize(150, 35);
        btnLanzar.setVisible(true);
        btnLanzar.setLocation(740, 635);
        btnLanzar.setForeground(Color.BLACK);
        btnLanzar.setBackground(new Color(250, 206, 71));
        btnLanzar.setFont(new Font("Herculanum", Font.BOLD, 14));
        btnLanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int numero = lanzar.calcular();
                lanzar.mostrarCanias();
                moverFicha(numero, fichas.get(0));

            }
        });
        this.add(btnLanzar);
//        if (fichas.get(18) != null) {
//            this.add(fichas.get(18).getFicha());
//        }
    }

    public void showPlayersIcons() {
        JLabel lblPlayerIcon1 = new JLabel();
        lblPlayerIcon1.setSize(40, 40);
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/mascara32px.png")).getImage());
        lblPlayerIcon1.setIcon(imageIcon1);
        lblPlayerIcon1.setVisible(true);
        lblPlayerIcon1.setLocation(680, 635);
        this.add(lblPlayerIcon1);

        JLabel lblPlayerIcon2 = new JLabel();
        lblPlayerIcon2.setSize(40, 40);
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/mictlantecuhtli32px.png")).getImage());
        lblPlayerIcon2.setIcon(imageIcon2);
        lblPlayerIcon2.setVisible(true);
        lblPlayerIcon2.setLocation(680, 125);
        this.add(lblPlayerIcon2);

        JLabel lblPlayerIcon3 = new JLabel();
        lblPlayerIcon3.setSize(40, 40);
        ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/estatua32px.png")).getImage());
        lblPlayerIcon3.setIcon(imageIcon3);
        lblPlayerIcon3.setVisible(true);
        lblPlayerIcon3.setLocation(185, 125);
        this.add(lblPlayerIcon3);

        JLabel lblPlayerIcon4 = new JLabel();
        lblPlayerIcon4.setSize(40, 40);
        ImageIcon imageIcon4 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/quetzalcoatl32px.png")).getImage());
        lblPlayerIcon4.setIcon(imageIcon4);
        lblPlayerIcon4.setVisible(true);
        lblPlayerIcon4.setLocation(185, 635);
        this.add(lblPlayerIcon4);
    }

    public void showGemas() {
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(getClass().getResource("/Images/diamante32px.png")).getImage());

        JLabel lblGema1 = new JLabel();
        lblGema1.setSize(40, 40);
        lblGema1.setIcon(imageIcon1);
        lblGema1.setVisible(true);
        lblGema1.setLocation(790, 90);
        this.add(lblGema1);

        JLabel lblGema2 = new JLabel();
        lblGema2.setSize(40, 40);
        lblGema2.setIcon(imageIcon1);
        lblGema2.setVisible(true);
        lblGema2.setLocation(790, 50);
        this.add(lblGema2);

        JLabel lblGema3 = new JLabel();
        lblGema3.setSize(40, 40);
        lblGema3.setIcon(imageIcon1);
        lblGema3.setVisible(true);
        lblGema3.setLocation(750, 90);
        this.add(lblGema3);

        JLabel lblGema4 = new JLabel();
        lblGema4.setSize(40, 40);
        lblGema4.setIcon(imageIcon1);
        lblGema4.setVisible(true);
        lblGema4.setLocation(750, 50);
        this.add(lblGema4);

        JLabel lblGema5 = new JLabel();
        lblGema5.setSize(40, 40);
        lblGema5.setIcon(imageIcon1);
        lblGema5.setVisible(true);
        lblGema5.setLocation(830, 90);
        this.add(lblGema5);

        JLabel lblGema6 = new JLabel();
        lblGema6.setSize(40, 40);
        lblGema6.setIcon(imageIcon1);
        lblGema6.setVisible(true);
        lblGema6.setLocation(830, 50);
        this.add(lblGema6);
    }

    public void showApuestaRestante() {
        JLabel lblMontoApuesta = new JLabel();
        lblMontoApuesta.setText(String.valueOf(this.broker.getJugador().getApuesta().getMontoTotal()));
        lblMontoApuesta.setFont(new Font("PT Sans", Font.BOLD, 18));
        lblMontoApuesta.setForeground(new Color(243, 243, 220));
        lblMontoApuesta.setSize(100, 40);
        lblMontoApuesta.setLocation(795, 20);
        lblMontoApuesta.setVisible(true);
        this.add(lblMontoApuesta);
    }

    public void showNicknames() {
        JLabel lblNickname1 = new JLabel();
        lblNickname1.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname1.setForeground(new Color(243, 243, 220));
        lblNickname1.setSize(100, 40);
        lblNickname1.setLocation(650, 90);
        lblNickname1.setVisible(true);
        this.add(lblNickname1);
        this.etiquetaJugadores.add(lblNickname1);

        JLabel lblNickname2 = new JLabel();
        lblNickname2.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname2.setForeground(new Color(243, 243, 220));
        lblNickname2.setSize(100, 40);
        lblNickname2.setLocation(650, 675);
        lblNickname2.setVisible(true);
        this.add(lblNickname2);
        this.etiquetaJugadores.add(lblNickname2);

        JLabel lblNickname3 = new JLabel();
        lblNickname3.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname3.setForeground(new Color(243, 243, 220));
        lblNickname3.setSize(100, 40);
        lblNickname3.setLocation(190, 90);
        lblNickname3.setVisible(true);
        this.add(lblNickname3);
        this.etiquetaJugadores.add(lblNickname3);

        JLabel lblNickname4 = new JLabel();
        lblNickname4.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname4.setForeground(new Color(243, 243, 220));
        lblNickname4.setSize(100, 40);
        lblNickname4.setLocation(190, 675);
        lblNickname4.setVisible(true);
        this.add(lblNickname4);
        this.etiquetaJugadores.add(lblNickname4);

    }

    public void moverFicha(int numero, Ficha ficha) {

        int pos = ficha.getPosicionActual();
        if (pos != -1) {
            pos = pos + numero;
            for (Forma casilla : casillas) {
                /*
                Solo estoy validando con la ficha azul que esa va a la derecha, en el EnumDireccion.Derecha es solo para el azul
                aqui deberia de ir la direccion especifica que le toca al jugador que esta jugando.
                 */

                if (pos == casilla.getPosition()) {
                    casilla.drawFicha(ficha);
                    break;
                }
            }
        } else if (numero == 1) {
            pos = 0;//ficha verde posición inicial
            for (Forma casilla : casillas) {
                /*
                Solo estoy validando con la ficha azul que esa va a la derecha, en el EnumDireccion.Derecha es solo para el azul
                aqui deberia de ir la direccion especifica que le toca al jugador que esta jugando.
                 */

                if (pos == casilla.getPosition()) {
                    casilla.drawFicha(ficha);
                    break;
                }
            }
        }
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public Canias getLanzar() {
        return lanzar;
    }

    public ArrayList<JButton> getBotones() {
        return botones;
    }
}
