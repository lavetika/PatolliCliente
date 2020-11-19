/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;


import conexionCliente.ClienteSocket;

import java.io.IOException;

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
        }
    }
    
}
