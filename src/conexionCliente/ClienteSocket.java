package conexionCliente;

import Control.Partida;
import java.io.IOException;
import java.net.Socket;
import broker.Broker;

public class ClienteSocket {
    
    private final String SERVIDOR;
    private final int PUERTO;
    private Broker broker;
    //Prueba
    public ClienteSocket(String servidor, int puerto) {
        this.SERVIDOR = servidor;
        this.PUERTO = puerto;
        System.out.println("Creando el cliente...");
    }
    
    public void iniciar() throws IOException {
        try {
            System.out.println("Conectando el cliente con el servidor");
            Socket socket = new Socket(this.SERVIDOR, this.PUERTO);
            System.out.printf("Cliente conectado con el servidor-> %s:%d... %n", this.SERVIDOR, this.PUERTO);

            ComunicadorRedServidor hilo = new ComunicadorRedServidor(socket);
            Thread tempHilo = new Thread(hilo);  //yo creo que es esto, acepta uno y el siguiente ya no
            tempHilo.start();
            broker = new Broker(hilo);
            hilo.addObserver(broker);

       

            // ESTA BIEN, ENVIAR UN MENSAJE EN EL MÉTODO INICIAR?
            // ES POSIBLE ENVIAR OTRO MENSAJE DESPUÉS...?            
        } catch (IOException ex) {
            System.err.printf("Error %s %n", ex.getMessage());
            throw ex;
        }
    }

    public Broker getBroker() {
        return broker;
    }
    
    
    
}
