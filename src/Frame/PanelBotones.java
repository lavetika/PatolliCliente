package Frame;

import broker.Broker;
import callMessage.Mandadero;
import enumServicio.EnumServicio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

    fmTablero fmTablero;
    Broker b;

    public PanelBotones(fmTablero frameTablero, Broker b) {
        setLayout(new GroupLayout(this));
        this.setSize(150, 800);
        this.setBackground(new Color(105, 2, 5));
        this.fmTablero = frameTablero;
        this.b = b;
        showButtons();
        showCodigo();
    }

    public void showCodigo() {
        JLabel lblTituloCodigo = new JLabel("CÓDIGO");
        lblTituloCodigo.setFont(new Font("PT Sans", Font.BOLD, 18));
        lblTituloCodigo.setForeground(Color.BLACK);
        lblTituloCodigo.setSize(100, 40);
        lblTituloCodigo.setLocation(30, 10);
        lblTituloCodigo.setVisible(true);
        this.add(lblTituloCodigo);

        JLabel lblCodigo = new JLabel("12345");
        lblCodigo.setFont(new Font("PT Sans", Font.PLAIN, 18));
        lblCodigo.setForeground(new Color(250, 206, 71));
        lblCodigo.setSize(100, 40);
        lblCodigo.setLocation(35, 35);
        lblCodigo.setVisible(true);
        this.add(lblCodigo);
    }

    public void showButtons() {
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setSize(130, 30);
        btnIniciar.setVisible(true);
        btnIniciar.setLocation(15, 80);
        btnIniciar.setForeground(Color.BLACK);
        btnIniciar.setBackground(new Color(243, 243, 220));
        btnIniciar.setFont(new Font("Herculanum", Font.PLAIN, 12));
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Mandadero m = new Mandadero(EnumServicio.ASIGNAR_TURNO);
                b.solicitarPedido(m);
            }
        });
        this.add(btnIniciar);
        

        JButton btnSalir = new JButton("Salir");
        btnSalir.setSize(90, 30);
        btnSalir.setVisible(true);
        btnSalir.setLocation(15, 120);
        btnSalir.setForeground(Color.BLACK);
        btnSalir.setBackground(new Color(243, 255, 220));
        btnSalir.setFont(new Font("Herculanum", Font.PLAIN, 12));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fmTablero.dispose();
                Mandadero mandadero=new Mandadero(EnumServicio.ABANDONO_JUGADOR);
                b.solicitarPedido(mandadero);
                fmMenu fmMenu = new fmMenu();
                fmMenu.setVisible(true);
            }
        });
        this.add(btnSalir);
    }

}
