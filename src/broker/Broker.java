
package broker;

import callMessage.Mandadero;
import conexionCliente.ComunicadorRedServidor;
import java.util.HashMap;

/**
 *
 * @author Diana Jiménez <3 Diana Castro
 */
public class Broker {

    public Broker broker;
    ComunicadorRedServidor socket;

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
}
