package Frame;

import broker.Broker;
import callMessage.Mandadero;
import enumServicio.EnumServicio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

    private fmTablero fmTablero;
    private Broker b;
    private List<JButton> botones;

    public PanelBotones(fmTablero frameTablero, Broker b) {
        setLayout(new GroupLayout(this));
        this.setSize(150, 800);
        this.setBackground(new Color(105, 2, 5));
        this.fmTablero = frameTablero;
        this.b = b;
        botones = new ArrayList<>();
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
//        btnIniciar.setVisible(true);
        btnIniciar.setLocation(15, 80);
        btnIniciar.setForeground(Color.BLACK);
        btnIniciar.setBackground(new Color(243, 243, 220));
        btnIniciar.setFont(new Font("Herculanum", Font.PLAIN, 12));
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Mandadero m = new Mandadero(EnumServicio.ASIGNAR_TURNO);
                m.addPeticion("fichas", fmTablero.getFichas());
                b.solicitarPedido(m);
                btnIniciar.setEnabled(false);//cuando cambia de host no está inhabilitado
            }
        });
        //deberíamos añadir un mouseClick listener)? o manejarlo en el mismo actionPerformed
        this.botones.add(btnIniciar);
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
//                int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?",
//                        "Confirmar abandono de partida", JOptionPane.OK_CANCEL_OPTION);
//                if (resp == JOptionPane.OK_OPTION) {
                    fmTablero.dispose();
                    Mandadero mandadero = new Mandadero(EnumServicio.ABANDONO_JUGADOR);
                    b.solicitarPedido(mandadero);
//                }
            }
        });
        this.botones.add(btnSalir);
        this.add(btnSalir);

//        
//        
//        JButton btnPrueba = new JButton("Prueba");
//        btnPrueba.setSize(90, 30);
//        btnPrueba.setVisible(true);
//        btnPrueba.setLocation(15, 160); 
//        btnPrueba.setForeground(Color.BLACK);
//        btnPrueba.setBackground(new Color(243, 255, 220));
//        btnPrueba.setFont(new Font("Herculanum", Font.PLAIN, 12));
//        btnPrueba.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Mandadero mandadero=new Mandadero(EnumServicio.MOVIMIENTO_FICHA);
//                b.solicitarPedido(mandadero);
//            }
//        });
//        this.add(btnPrueba);
    }

    public List<JButton> getBotones() {
        return this.botones;
    }

}
