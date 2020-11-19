package conexionCliente;

import Dominio.Jugador;
import callMessage.Mandadero;
import enumServicio.EnumServicio;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComunicadorRedServidor extends Thread {

    private Socket socket;
    private ObjectOutputStream flujoSalidaDatos;
    private ObjectInputStream flujoEntradaDatos;

    public ComunicadorRedServidor(Socket socket) throws IOException {
        this.socket = socket;
        try{
            this.flujoSalidaDatos = new ObjectOutputStream(socket.getOutputStream());
            this.flujoEntradaDatos = new ObjectInputStream(socket.getInputStream());
        }catch(IOException ex){
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public void desconectar() throws IOException{
        try{
            this.socket.close();
        }catch(IOException ex){
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void enviarPeticion(String mensajeEnviar){
        try{
            
            this.flujoSalidaDatos.writeObject(mensajeEnviar);
            this.flujoSalidaDatos.flush();
            this.socket.close();

        }catch(ClassCastException ex){
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, "El objeto recibido no es un mensaje válido", ex);
        }catch(IOException ex){
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void run() {
//        try {
//            String respuesta = flujoEntradaDatos.readUTF();
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    try{
            ArrayList<Object> lista= new ArrayList<>();
            lista.add(new Jugador("LauraBb"));
            Mandadero mandadero= new Mandadero(lista, EnumServicio.INGRESAR_PARTIDA);
            
            this.flujoSalidaDatos.writeObject(mandadero);
            this.flujoSalidaDatos.flush();
            this.socket.close();

        }catch(ClassCastException ex){
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, "El objeto recibido no es un mensaje válido", ex);
        }catch(IOException ex){
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
