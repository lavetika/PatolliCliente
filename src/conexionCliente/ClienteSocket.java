package conexionCliente;

import java.io.IOException;
import java.net.Socket;

public class ClienteSocket {
    private final String SERVIDOR;
    private final int PUERTO;       
    
    public ClienteSocket(String servidor, int puerto) {
        this.SERVIDOR = servidor;
        this.PUERTO = puerto;
        System.out.println("Creando el cliente...");
    }
    
    public void iniciar() throws IOException{
        try{                        
            System.out.println("Conectando el cliente con el servidor");            
            Socket socket = new Socket(this.SERVIDOR, this.PUERTO);
            System.out.printf("Cliente conectado con el servidor-> %s:%d... %n", this.SERVIDOR, this.PUERTO);            
                        
            Thread hilo = new Thread(new ComunicadorRedServidor(socket));
            hilo.start();
            
            // ESTA BIEN, ENVIAR UN MENSAJE EN EL MÉTODO INICIAR?
            // ES POSIBLE ENVIAR OTRO MENSAJE DESPUÉS...?            
        }catch(IOException ex){
            System.err.printf("Error %s %n", ex.getMessage());
            throw ex;
        }        
    }
}
