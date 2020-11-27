package conexionCliente;

import java.net.Socket;
import broker.Broker;
import java.io.IOException;

public class ClienteSocket {

    private final String SERVIDOR;
    private final int PUERTO;
    private Broker broker;
    private Socket socket;

    public ClienteSocket(String servidor, int puerto) {
        this.SERVIDOR = servidor;
        this.PUERTO = puerto;
        System.out.println("Creando el cliente...");
    }

    public void iniciar() throws Exception {
        try {
            System.out.println("Conectando el cliente con el servidor");
            socket = new Socket(this.SERVIDOR, this.PUERTO);
            System.out.printf("Cliente conectado con el servidor-> %s:%d... %n", this.SERVIDOR, this.PUERTO);

            ComunicadorRedServidor hilo = new ComunicadorRedServidor(socket);
            Thread tempHilo = new Thread(hilo);
            tempHilo.start();
            broker = new Broker(hilo);
            hilo.addObserver(broker);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void cerrarSocket(){
        try {
            this.socket.close();
        } catch (IOException ex) {
            System.out.println("No se pudo cerrar");
        }
    }

    public Broker getBroker() {
        return broker;
    }

}
