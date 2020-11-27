package cliente;
import broker.Broker;
import callMessage.Mandadero;
import conexionCliente.ClienteSocket;
import enumServicio.EnumServicio;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalCliente {

    public static void main(String[] args) {
        
        try {
            ClienteSocket c = new ClienteSocket("localhost", 9090);
            c.iniciar();
            Broker broker = c.getBroker();
            
            HashMap<String, Object> p = new HashMap<>();
            
            Mandadero mandadero = new Mandadero(EnumServicio.CREAR_PARTIDA);
            
            mandadero.addPeticion("numJugadores", 4);
            mandadero.addPeticion("cantGemas", 10);
            mandadero.addPeticion("nickname", "Ludoviquito");
            mandadero.addPeticion("Tablero", "Tablero");
            
            
            broker.solicitarPedido(mandadero);
            
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
