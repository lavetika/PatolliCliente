
package broker;


import conexionCliente.ClienteSocket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diana Jiménez
 */
public class PrincipalBroker {

    
    public static void main(String[] args) {
        try {
            new ClienteSocket("localhost", 9090).iniciar();
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(PrincipalBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
