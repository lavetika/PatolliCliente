
package broker;

import Dominio.Jugador;
import callMessage.Mandadero;

import java.net.ServerSocket;

/**
 *
 * @author Diana Jiménez <3 Diana Castro
 */

public class Broker{
    
    public static Broker broker;
    ServerSocket socket;
    
    public static Broker getInstance() {
        if (broker == null) {
            broker = new Broker();
        } else {
            System.out.println("Ya se instanció");
        }
        return broker;
    }
        
    }
    
    
    

