
package broker;

import Dominio.Jugador;
import callMessage.Mandadero;
import conexionCliente.ComunicadorRedServidor;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Diana Jiménez <3 Diana Castro
 */
public class Broker implements Observer{

    public Broker broker;
    ComunicadorRedServidor socket;
    private Jugador jugador;

    public Broker() { 
        
    }

    public Broker(ComunicadorRedServidor socket) {
        this.socket = socket;
    }
    
    public void recibirPedidoSHEIN(){
        //Dos meses despues
    }
    
    public void solicitarPedidoSHEIN(Mandadero mandadero){
        socket.enviarPeticion(mandadero);
    }
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void update(Observable o, Object o1) {
        
    }
}
