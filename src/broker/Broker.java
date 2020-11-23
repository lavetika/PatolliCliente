
package broker;

import Dominio.Jugador;
import callMessage.Mandadero;
import conexionCliente.ComunicadorRedServidor;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Diana Jiménez <3 Diana Castro
 */
public class Broker extends Observable implements Observer{

    public Broker broker;
    ComunicadorRedServidor socket;
    private Jugador jugador;

    public Broker() {         
    }

    public Broker(ComunicadorRedServidor socket) {
        this.socket = socket;
    }
    
    public Mandadero recibirPedido(){        
        return socket.recibirPeticion();        
    }
    
    public void solicitarPedido(Mandadero mandadero){
        socket.enviarPeticion(mandadero);
    }
        
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    @Override
    public void update(Observable o, Object o1) {
        Mandadero m = (Mandadero)o1;
        this.setChanged();
        this.notifyObservers(m);
        this.clearChanged();
        
    }
}
