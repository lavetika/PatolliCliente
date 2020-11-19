package cliente;

import conexionCliente.ClienteSocket;

import java.io.IOException;

public class PrincipalCliente {

    public static void main(String[] args) {
        try {
            new ClienteSocket("localhost", 9090).iniciar();
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
        }
        
        
    }

}
