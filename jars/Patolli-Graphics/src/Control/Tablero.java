/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Enum.EnumCasilla;
import Enum.EnumDireccion;
import Graphics.Cuadrangular;
import Graphics.Forma;
import Graphics.SemiCircular;
import Graphics.Canias;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author laura
 */
public final class Tablero extends JPanel{
    
    int cantidadTablero;
    int cantidadLado;
    int cantidadCasillasCentrales;
    int cantidadSemiCirculo;
    Frame frameTablero;
    Frame frameInicio;
    int tamanioCasilla;
    Canias lanzar;
    
    public Tablero(int tamanio, Canias canias, Frame frameTablero, Frame frameInicio) {
        setLayout(new GroupLayout(this));
        setSize(900, 800);
        setBackground(new Color(105,2,5));
        this.cantidadTablero = tamanio;
        this.cantidadCasillasCentrales = 4;
        this.cantidadSemiCirculo = 8;
        this.tamanioCasilla = 40;
        this.frameTablero= frameTablero;
        this.frameInicio = frameInicio;
        this.lanzar = canias;
        calcularTablero();
    }
    
    public void calcularTablero(){
        int numeroAspas = 4;
        int numeroHileras = 2;
        this.cantidadLado = ((cantidadTablero - (cantidadCasillasCentrales + cantidadSemiCirculo))/numeroAspas)/numeroHileras;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTablero(g);
    }

    public void drawBase(Graphics2D g2d){
        Dimension tamano = getSize();
        
        
        int w = (int)tamano.getWidth();
        int h = (int)tamano.getHeight();
        
        g2d.setColor(new Color(243, 188, 39));
        g2d.fillOval(125, 75, 650, 650);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(125, 75, 650, 650);
    }
    
    public void drawTablero(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
            
        //drawBase(g2d);
        showButtons();
        showPlayersIcons();
        showBeans();
        showGemas();
        showNicknames();
        showCodigo();
        showApuestaRestante();
        
        showFichasAzules();
        showFichasRojas();
        showFichasVerdes();
        showFichasNaranja();
        
        drawBaseTablero(g);
        drawCentral(g2d);
        drawArriba(g2d);
        drawAbajo(g2d);
        
        drawDerecha(g2d);
        drawIzquierda(g2d);
        
    }
    
    public int posicionar(int x, int y, EnumDireccion direccion){
        
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
    
    public void drawCentral(Graphics2D g2d){
        Dimension tamano = getSize();
        int x = (int)tamano.getWidth();
        int y = (int)tamano.getHeight();
        
        //Posicionarlo en el centro
        x = x/2;
        y = y/2;
        
        Forma casilla = new Cuadrangular(EnumCasilla.CENTRAL, x, y, tamanioCasilla);
        casilla.draw(g2d);
        
        //Posicionarlo
        x = posicionar(x, y, EnumDireccion.IZQUIERDA);
        
        Forma casilla2 = new Cuadrangular(EnumCasilla.CENTRAL, x, y, tamanioCasilla);
        casilla2.draw(g2d);

        //Posicionarlo
        y = posicionar(x, y, EnumDireccion.ARRIBA);
        
        Forma casilla3 = new Cuadrangular(EnumCasilla.CENTRAL, x, y, tamanioCasilla);
        casilla3.draw(g2d);

        //Posicionarlo
        x = posicionar(x, y, EnumDireccion.DERECHA);
        
        Forma casilla4 = new Cuadrangular(EnumCasilla.CENTRAL, x, y, tamanioCasilla);
        casilla4.draw(g2d);
        
    }
    
    public void drawArriba(Graphics2D g2d){
        Dimension tamano = getSize();
        int x = (int)tamano.getWidth();
        int y = (int)tamano.getHeight();
        
        //Posicion inicial
        x = x/2;
        y = y/2;
        
        y = posicionar(x, y, EnumDireccion.ARRIBA);
        
        for (int i = 0; i < cantidadLado; i++) {
            y = posicionar(x, y, EnumDireccion.ARRIBA);
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
        }
        
        x = posicionar(x, y, EnumDireccion.IZQUIERDA);
        for (int i = 1; i <= cantidadLado; i++) {
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
            y = posicionar(x, y, EnumDireccion.ABAJO);
        }
        
        drawSemiCircular(g2d, EnumDireccion.ARRIBA);
    }
    
    public void drawAbajo(Graphics2D g2d){
        Dimension tamano = getSize();
        int x = (int)tamano.getWidth();
        int y = (int)tamano.getHeight();
        
        //Posicion inicial
        x = x/2;
        y = y/2;
        
        for (int i = 1; i <= cantidadLado; i++) {
            y = posicionar(x, y, EnumDireccion.ABAJO);
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
        }
        
        x = posicionar(x, y, EnumDireccion.IZQUIERDA);
        for (int i = 1; i <= cantidadLado; i++) {
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
            y = posicionar(x, y, EnumDireccion.ARRIBA);
        }
        
        drawSemiCircular(g2d, EnumDireccion.ABAJO);
    }
    
    public void drawIzquierda(Graphics2D g2d){
        Dimension tamano = getSize();
        int x = (int)tamano.getWidth();
        int y = (int)tamano.getHeight();
        
        //Posicion inicial
        x = x/2;
        y = y/2;
        
        x = posicionar(x, y, EnumDireccion.IZQUIERDA);
        
        for (int i = 0; i < cantidadLado; i++) {
            x = posicionar(x, y, EnumDireccion.IZQUIERDA);
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
        }
        
        y = posicionar(x, y, EnumDireccion.ARRIBA);
        
        for (int i = 0; i < cantidadLado; i++) {
            
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
            x = posicionar(x, y, EnumDireccion.DERECHA);
        }
        
        drawSemiCircular(g2d, EnumDireccion.IZQUIERDA);
    }
    
    public void drawDerecha(Graphics2D g2d){
        Dimension tamano = getSize();
        int x = (int)tamano.getWidth();
        int y = (int)tamano.getHeight();
        
        //Posicion inicial
        x = x/2;
        y = y/2;
        
        for (int i = 1; i <= cantidadLado; i++) {
            x = posicionar(x, y, EnumDireccion.DERECHA);
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
        }
        
        y = posicionar(x, y, EnumDireccion.ARRIBA);
        
        for (int i = 1; i <= cantidadLado; i++) {
            
            Forma casilla = new Cuadrangular(EnumCasilla.INICIO, x, y, tamanioCasilla);
            casilla.draw(g2d);
            x = posicionar(x, y, EnumDireccion.IZQUIERDA);
        }
        
        drawSemiCircular(g2d, EnumDireccion.DERECHA);
    }
    
    public void drawSemiCircular(Graphics2D g2d, Enum direccion) {
        
        Dimension tamano = getSize();
        int x = (int)tamano.getWidth();
        int y = (int) tamano.getHeight();
        
        //Posicion inicial
        x = x/2;
        y = y/2;

        if (direccion == EnumDireccion.IZQUIERDA) {
            for (int i = 0; i < cantidadLado+2; i++) {
                x = posicionar(x, y, EnumDireccion.IZQUIERDA); 
            }
            
            y = posicionar(x, y, EnumDireccion.ARRIBA);
            Forma mediaLuna1 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 90);
            mediaLuna1.draw(g2d);
            Forma mediaLuna2 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 180);
            mediaLuna2.draw(g2d);
            
        } else if (direccion == EnumDireccion.DERECHA) {
            
            for (int i = 0; i < cantidadLado; i++) {
                x = posicionar(x, y, EnumDireccion.DERECHA); 
            }
            
            //Para que no tape la rayita
            x = x + 1;
            
            y = posicionar(x, y, EnumDireccion.ARRIBA);
            Forma mediaLuna1 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 0);
            mediaLuna1.draw(g2d);
            Forma mediaLuna2 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 270);
            mediaLuna2.draw(g2d);

        }else if (direccion == EnumDireccion.ARRIBA){
           for (int i = 0; i < cantidadLado+2; i++) {
                y = posicionar(x, y, EnumDireccion.ARRIBA); 
           }
            x = posicionar(x, y, EnumDireccion.IZQUIERDA);
            Forma mediaLuna1 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 90);
            mediaLuna1.draw(g2d);
            
            Forma mediaLuna2 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 360);
            mediaLuna2.draw(g2d);

        } else {
            for (int i = 0; i < cantidadLado; i++) {
                y = posicionar(x, y, EnumDireccion.ABAJO);
            }   

            //Para que no tape la rayita
            y = y + 1;
            
            x = posicionar(x, y, EnumDireccion.IZQUIERDA);
            Forma mediaLuna1 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 180);
            mediaLuna1.draw(g2d);
            
            Forma mediaLuna2 = new SemiCircular(EnumCasilla.ESQUINA, x, y, tamanioCasilla, 270);
            mediaLuna2.draw(g2d);
        }   
    }
    
    public void drawBaseTablero(Graphics g){
        ImageIcon imageIcon = new ImageIcon (new ImageIcon(getClass().getResource("/Images/CalendarioDelSolFondoNegro.png")).getImage());
        Image imagen = imageIcon.getImage();
        
        g.drawImage(imagen, 125, 75, null);
    }
    
    public void showButtons(){
        JButton btnSalir = new JButton ("Salir");
        btnSalir.setSize(90,30);
        btnSalir.setVisible(true);
        btnSalir.setLocation(15, 105);
        btnSalir.setForeground(Color.BLACK);
        btnSalir.setBackground(new Color(243,243,220));
        btnSalir.setFont(new Font("Herculanum", Font.PLAIN, 12));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frameTablero.dispose();
                frameInicio.setVisible(true);
                
            }
        });
        this.add(btnSalir);
        
        JButton btnIniciar = new JButton ("Iniciar partida");
        btnIniciar.setSize(130,30);
        btnIniciar.setVisible(true);
        btnIniciar.setLocation(15, 70);
        btnIniciar.setForeground(Color.BLACK);
        btnIniciar.setBackground(new Color(243,243,220));
        btnIniciar.setFont(new Font("Herculanum", Font.PLAIN, 12));
        this.add(btnIniciar);
    
        JButton btnLanzar = new JButton ("Lanzar cañas");
        btnLanzar.setSize(150,35);
        btnLanzar.setVisible(true);
        btnLanzar.setLocation(740, 635);
        btnLanzar.setForeground(Color.BLACK);
        btnLanzar.setBackground(new Color (250,206,71));
        btnLanzar.setFont(new Font("Herculanum", Font.BOLD, 14));
        btnLanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lanzar.calcular();
                lanzar.mostrarCanias();
            }
        });
        this.add(btnLanzar);
        
        JButton btnApostar = new JButton ("Apostar");
        btnApostar.setSize(110,35);
        btnApostar.setVisible(true);
        btnApostar.setLocation(780, 685);
        btnApostar.setForeground(Color.BLACK);
        btnApostar.setBackground(new Color (250,206,71));
        btnApostar.setFont(new Font("Herculanum", Font.BOLD, 14));
        this.add(btnApostar);
    }
    
    public void showPlayersIcons(){
        JLabel lblPlayerIcon1 = new JLabel();
        lblPlayerIcon1.setSize(40,40);
        ImageIcon imageIcon1 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/mascara32px.png")).getImage());
        lblPlayerIcon1.setIcon(imageIcon1);
        lblPlayerIcon1.setVisible(true);
        lblPlayerIcon1.setLocation(680, 635);
        this.add(lblPlayerIcon1);
        
        JLabel lblPlayerIcon2 = new JLabel();
        lblPlayerIcon2.setSize(40,40);
        ImageIcon imageIcon2 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/mictlantecuhtli32px.png")).getImage());
        lblPlayerIcon2.setIcon(imageIcon2);
        lblPlayerIcon2.setVisible(true);
        lblPlayerIcon2.setLocation(680, 125);
        this.add(lblPlayerIcon2);
        
        JLabel lblPlayerIcon3 = new JLabel();
        lblPlayerIcon3.setSize(40,40);
        ImageIcon imageIcon3 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/estatua32px.png")).getImage());
        lblPlayerIcon3.setIcon(imageIcon3);
        lblPlayerIcon3.setVisible(true);
        lblPlayerIcon3.setLocation(185, 125);
        this.add(lblPlayerIcon3);
        
        JLabel lblPlayerIcon4 = new JLabel();
        lblPlayerIcon4.setSize(40,40);
        ImageIcon imageIcon4 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/quetzalcoatl32px.png")).getImage());
        lblPlayerIcon4.setIcon(imageIcon4);
        lblPlayerIcon4.setVisible(true);
        lblPlayerIcon4.setLocation(185, 635);
        this.add(lblPlayerIcon4);
    }
    
    public void showBeans(){
        ImageIcon frijolActivado = new ImageIcon (new ImageIcon(getClass().getResource("/Images/frijol activado32px.png")).getImage());
        ImageIcon frijolDesactivado = new ImageIcon (new ImageIcon(getClass().getResource("/Images/frijol desactivado32px.png")).getImage());
        
        JLabel lblBean1 = new JLabel();
        lblBean1.setSize(40,40);
        lblBean1.setLocation(25, 600);
        lblBean1.setIcon(frijolActivado);
        lblBean1.setVisible(true);
        this.add(lblBean1);
        
        JLabel lblBean2 = new JLabel();
        lblBean2.setSize(40,40);
        lblBean2.setLocation(25, 640);
        lblBean2.setIcon(frijolActivado);
        lblBean2.setVisible(true);
        this.add(lblBean2);
        
        JLabel lblBean3 = new JLabel();
        lblBean3.setSize(40,40);
        lblBean3.setLocation(65, 620);
        lblBean3.setIcon(frijolDesactivado);
        lblBean3.setVisible(true);
        this.add(lblBean3);
        
        JLabel lblBean4 = new JLabel();
        lblBean4.setSize(40,40);
        lblBean4.setLocation(65, 660);
        lblBean4.setIcon(frijolActivado);
        lblBean4.setVisible(true);
        this.add(lblBean4);
        
        JLabel lblBean5 = new JLabel();
        lblBean5.setSize(40,40);
        lblBean5.setLocation(105, 640);
        lblBean5.setIcon(frijolDesactivado);
        lblBean5.setVisible(true);
        this.add(lblBean5);
    }
    
    public void showGemas(){
        ImageIcon imageIcon1 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/diamante32px.png")).getImage());
        
        JLabel lblGema1 = new JLabel();
        lblGema1.setSize(40,40);
        lblGema1.setIcon(imageIcon1);
        lblGema1.setVisible(true);
        lblGema1.setLocation(790, 90);
        this.add(lblGema1);
        
        JLabel lblGema2 = new JLabel();
        lblGema2.setSize(40,40);
        lblGema2.setIcon(imageIcon1);
        lblGema2.setVisible(true);
        lblGema2.setLocation(790, 50);
        this.add(lblGema2);
        
        JLabel lblGema3 = new JLabel();
        lblGema3.setSize(40,40);
        lblGema3.setIcon(imageIcon1);
        lblGema3.setVisible(true);
        lblGema3.setLocation(750, 90);
        this.add(lblGema3);
        
        JLabel lblGema4 = new JLabel();
        lblGema4.setSize(40,40);
        lblGema4.setIcon(imageIcon1);
        lblGema4.setVisible(true);
        lblGema4.setLocation(750, 50);
        this.add(lblGema4);
        
        JLabel lblGema5 = new JLabel();
        lblGema5.setSize(40,40);
        lblGema5.setIcon(imageIcon1);
        lblGema5.setVisible(true);
        lblGema5.setLocation(830, 90);
        this.add(lblGema5);
        
        JLabel lblGema6 = new JLabel();
        lblGema6.setSize(40,40);
        lblGema6.setIcon(imageIcon1);
        lblGema6.setVisible(true);
        lblGema6.setLocation(830, 50);
        this.add(lblGema6);
    }

    public void showNicknames(){
        JLabel lblNickname1 = new JLabel("El Chino");
        lblNickname1.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname1.setForeground(new Color(243,243,220));
        lblNickname1.setSize(100,40);
        lblNickname1.setLocation(650, 90);
        lblNickname1.setVisible(true);
        this.add(lblNickname1);
        
        JLabel lblNickname2 = new JLabel("GalloOro");
        lblNickname2.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname2.setForeground(new Color(243,243,220));
        lblNickname2.setSize(100,40);
        lblNickname2.setLocation(650, 675);
        lblNickname2.setVisible(true);
        this.add(lblNickname2);
        
        JLabel lblNickname3 = new JLabel("LudoVico");
        lblNickname3.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname3.setForeground(new Color(243,243,220));
        lblNickname3.setSize(100,40);
        lblNickname3.setLocation(190, 90);
        lblNickname3.setVisible(true);
        this.add(lblNickname3);
        
        JLabel lblNickname4 = new JLabel("Bebelin");
        lblNickname4.setFont(new Font("PT Sans", Font.PLAIN, 14));
        lblNickname4.setForeground(new Color(243,243,220));
        lblNickname4.setSize(100,40);
        lblNickname4.setLocation(190, 675);
        lblNickname4.setVisible(true);
        this.add(lblNickname4);
    }
    
    public void showCodigo(){
        JLabel lblTituloCodigo = new JLabel("CÓDIGO");
        lblTituloCodigo.setFont(new Font("PT Sans", Font.BOLD, 18));
        lblTituloCodigo.setForeground(Color.BLACK);
        lblTituloCodigo.setSize(100,40);
        lblTituloCodigo.setLocation(30, 5);
        lblTituloCodigo.setVisible(true);
        this.add(lblTituloCodigo);
        
        JLabel lblCodigo = new JLabel("18364");
        lblCodigo.setFont(new Font("PT Sans", Font.PLAIN, 18));
        lblCodigo.setForeground(new Color(250, 206, 71));
        lblCodigo.setSize(100,40);
        lblCodigo.setLocation(35, 30);
        lblCodigo.setVisible(true);
        this.add(lblCodigo);
    }
    
    public void showApuestaRestante(){
        JLabel lblTituloCodigo = new JLabel("12");
        lblTituloCodigo.setFont(new Font("PT Sans", Font.BOLD, 18));
        lblTituloCodigo.setForeground(new Color(243,243,220));
        lblTituloCodigo.setSize(100,40);
        lblTituloCodigo.setLocation(795, 20);
        lblTituloCodigo.setVisible(true);
        this.add(lblTituloCodigo);
    }
    
    public void showFichasAzules(){
        ImageIcon imageIcon1 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/fichaazul32px.png")).getImage());
        JLabel lblFichaAzul1 = new JLabel();        
        lblFichaAzul1.setIcon(imageIcon1);        
        lblFichaAzul1.setSize(40,40);
        lblFichaAzul1.setLocation(310, 300);
        lblFichaAzul1.setVisible(true);
        this.add(lblFichaAzul1);
        
        JLabel lblFichaAzul2 = new JLabel();        
        lblFichaAzul2.setIcon(imageIcon1);        
        lblFichaAzul2.setSize(40,40);
        lblFichaAzul2.setLocation(310, 260);
        lblFichaAzul2.setVisible(true);
        this.add(lblFichaAzul2);
        
        JLabel lblFichaAzul3 = new JLabel();        
        lblFichaAzul3.setIcon(imageIcon1);        
        lblFichaAzul3.setSize(40,40);
        lblFichaAzul3.setLocation(350, 220);
        lblFichaAzul3.setVisible(true);
        this.add(lblFichaAzul3);
        
        JLabel lblFichaAzul6 = new JLabel();        
        lblFichaAzul6.setIcon(imageIcon1);        
        lblFichaAzul6.setSize(40,40);
        lblFichaAzul6.setLocation(350, 260);
        lblFichaAzul6.setVisible(true);
        this.add(lblFichaAzul6);
        
        JLabel lblFichaAzul4 = new JLabel();        
        lblFichaAzul4.setIcon(imageIcon1);        
        lblFichaAzul4.setSize(40,40);
        lblFichaAzul4.setLocation(350, 300);
        lblFichaAzul4.setVisible(true);
        this.add(lblFichaAzul4);
        
        JLabel lblFichaAzul5 = new JLabel();        
        lblFichaAzul5.setIcon(imageIcon1);        
        lblFichaAzul5.setSize(40,40);
        lblFichaAzul5.setLocation(270, 300);
        lblFichaAzul5.setVisible(true);
        this.add(lblFichaAzul5);         
    }
    
    public void showFichasRojas(){
        ImageIcon imageIcon1 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/ficharoja32px.png")).getImage());
        JLabel lblFichaRoja1 = new JLabel();        
        lblFichaRoja1.setIcon(imageIcon1);        
        lblFichaRoja1.setSize(40,40);
        lblFichaRoja1.setLocation(555, 300);
        lblFichaRoja1.setVisible(true);
        this.add(lblFichaRoja1);
        
        JLabel lblFichaRoja2 = new JLabel();        
        lblFichaRoja2.setIcon(imageIcon1);        
        lblFichaRoja2.setSize(40,40);
        lblFichaRoja2.setLocation(555, 260);
        lblFichaRoja2.setVisible(true);
        this.add(lblFichaRoja2);
        
        JLabel lblFichaRoja3 = new JLabel();        
        lblFichaRoja3.setIcon(imageIcon1);        
        lblFichaRoja3.setSize(40,40);
        lblFichaRoja3.setLocation(515, 220);
        lblFichaRoja3.setVisible(true);
        this.add(lblFichaRoja3);
        
        JLabel lblFichaRoja4 = new JLabel();        
        lblFichaRoja4.setIcon(imageIcon1);        
        lblFichaRoja4.setSize(40,40);
        lblFichaRoja4.setLocation(515, 260);
        lblFichaRoja4.setVisible(true);
        this.add(lblFichaRoja4);
        
        JLabel lblFichaRoja5 = new JLabel();        
        lblFichaRoja5.setIcon(imageIcon1);        
        lblFichaRoja5.setSize(40,40);
        lblFichaRoja5.setLocation(515, 300);
        lblFichaRoja5.setVisible(true);
        this.add(lblFichaRoja5);
        
        JLabel lblFichaRoja6 = new JLabel();        
        lblFichaRoja6.setIcon(imageIcon1);        
        lblFichaRoja6.setSize(40,40);
        lblFichaRoja6.setLocation(595, 300);
        lblFichaRoja6.setVisible(true);
        this.add(lblFichaRoja6);
    }
    
    public void showFichasVerdes(){
        ImageIcon imageIcon1 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/fichaverde32px.png")).getImage());
        
        JLabel lblFichaVerde1 = new JLabel();        
        lblFichaVerde1.setIcon(imageIcon1);        
        lblFichaVerde1.setSize(40,40);
        lblFichaVerde1.setLocation(555, 460);
        lblFichaVerde1.setVisible(true);
        this.add(lblFichaVerde1);
        
        JLabel lblFichaVerde2 = new JLabel();        
        lblFichaVerde2.setIcon(imageIcon1);        
        lblFichaVerde2.setSize(40,40);
        lblFichaVerde2.setLocation(555, 500);        
        lblFichaVerde2.setVisible(true);
        this.add(lblFichaVerde2);
        
        JLabel lblFichaVerde3 = new JLabel();        
        lblFichaVerde3.setIcon(imageIcon1);        
        lblFichaVerde3.setSize(40,40);        
        lblFichaVerde3.setLocation(515, 460);
        lblFichaVerde3.setVisible(true);
        this.add(lblFichaVerde3);
        
        JLabel lblFichaVerde4 = new JLabel();        
        lblFichaVerde4.setIcon(imageIcon1);        
        lblFichaVerde4.setSize(40,40);        
        lblFichaVerde4.setLocation(515, 500);
        lblFichaVerde4.setVisible(true);
        this.add(lblFichaVerde4);
        
        JLabel lblFichaVerde5 = new JLabel();        
        lblFichaVerde5.setIcon(imageIcon1);        
        lblFichaVerde5.setSize(40,40);
        lblFichaVerde5.setLocation(515, 540);        
        lblFichaVerde5.setVisible(true);
        this.add(lblFichaVerde5);
        
        JLabel lblFichaVerde6 = new JLabel();        
        lblFichaVerde6.setIcon(imageIcon1);        
        lblFichaVerde6.setSize(40,40);
        lblFichaVerde6.setLocation(595, 460);
        
        lblFichaVerde6.setVisible(true);
        this.add(lblFichaVerde6);
    }
    
    public void showFichasNaranja(){
        ImageIcon imageIcon1 = new ImageIcon (new ImageIcon(getClass().getResource("/Images/fichanaranja32px.png")).getImage());
        
        JLabel lblFichaNaranja1 = new JLabel();        
        lblFichaNaranja1.setIcon(imageIcon1);        
        lblFichaNaranja1.setSize(40,40);        
        lblFichaNaranja1.setLocation(310, 460);
        lblFichaNaranja1.setVisible(true);
        this.add(lblFichaNaranja1);
        
        JLabel lblFichaNaranja2 = new JLabel();        
        lblFichaNaranja2.setIcon(imageIcon1);        
        lblFichaNaranja2.setSize(40,40);
        lblFichaNaranja2.setLocation(310, 500);
        lblFichaNaranja2.setVisible(true);
        this.add(lblFichaNaranja2);
        
        JLabel lblFichaNaranja3 = new JLabel();        
        lblFichaNaranja3.setIcon(imageIcon1);        
        lblFichaNaranja3.setSize(40,40);
        lblFichaNaranja3.setLocation(350, 460);
        lblFichaNaranja3.setVisible(true);
        this.add(lblFichaNaranja3);
        
        JLabel lblFichaNaranja4 = new JLabel();        
        lblFichaNaranja4.setIcon(imageIcon1);        
        lblFichaNaranja4.setSize(40,40);
        lblFichaNaranja4.setLocation(350, 500);
        lblFichaNaranja4.setVisible(true);
        this.add(lblFichaNaranja4);
        
        JLabel lblFichaNaranja5 = new JLabel();        
        lblFichaNaranja5.setIcon(imageIcon1);        
        lblFichaNaranja5.setSize(40,40);
        lblFichaNaranja5.setLocation(350, 540);
        lblFichaNaranja5.setVisible(true);
        this.add(lblFichaNaranja5);
        
        JLabel lblFichaNaranja6 = new JLabel();        
        lblFichaNaranja6.setIcon(imageIcon1);        
        lblFichaNaranja6.setSize(40,40);
        lblFichaNaranja6.setLocation(270, 460);
        lblFichaNaranja6.setVisible(true);
        this.add(lblFichaNaranja6);
    }

    public Canias getLanzar() {
        return lanzar;
    }
    
    
    
}
