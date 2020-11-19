
package broker;

import Dominio.Jugador;
import callMessage.Mandadero;
import conexionCliente.ComunicadorRedServidor;

import java.net.ServerSocket;
import java.util.HashMap;

/**
 *
 * @author Diana Jiménez <3 Diana Castro
 */
public class Broker {

    public Broker broker;
    ComunicadorRedServidor socket;
    HashMap<String, Object> parametros;

    public Broker() {
        
    }

    public Broker(ComunicadorRedServidor socket) {
        this.socket = socket;
        this.parametros = new HashMap<>();
    }
    
    
    
    public void enviarMensaje(){
        
    }
    
    public void recibirMensaje(){
        
    }
    
    public void addParametro(String key, Object parametro){
        parametros.put(key, parametro);
    }
}
