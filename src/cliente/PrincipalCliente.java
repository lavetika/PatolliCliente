package cliente;

import Control.Tablero;
import broker.Broker;
import callMessage.Mandadero;
import conexionCliente.ClienteSocket;
import enumServicio.EnumServicio;

import java.io.IOException;
import java.util.HashMap;

public class PrincipalCliente {

    public static void main(String[] args) {
        
        try {
            ClienteSocket c = new ClienteSocket("localhost", 9090);
            c.iniciar();
            Broker broker = c.getBroker();
            
            HashMap<String, Object> p = new HashMap<>();
            
            Mandadero mandadero = new Mandadero(p, EnumServicio.CREAR_PARTIDA);
            
            mandadero.addParams("numJugadores", 4);
            mandadero.addParams("cantGemas", 10);
            mandadero.addParams("nickname", "Ludoviquito");
            mandadero.addParams("Tablero", "Tablero");
            
            
            broker.solicitarPedidoSHEIN(mandadero);
            
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
        }
        
        
    }

}
