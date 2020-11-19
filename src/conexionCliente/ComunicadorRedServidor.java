package conexionCliente;

import callMessage.Mandadero;
import enumServicio.EnumServicio;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComunicadorRedServidor extends Thread {

    private Socket socket;
    private ObjectOutputStream flujoSalidaDatos;
    private ObjectInputStream flujoEntradaDatos;

    public ComunicadorRedServidor(Socket socket) throws IOException {
        this.socket = socket;
        try{
            this.flujoSalidaDatos = new ObjectOutputStream(this.socket.getOutputStream());
            this.flujoEntradaDatos = new ObjectInputStream(this.socket.getInputStream());
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

    public void enviarPeticion(Mandadero m){
        try{
            this.flujoSalidaDatos.writeObject(m);
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
//            
//            enviarPeticion();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
//    try{
//            HashMap<String, Object> lista= new HashMap<>();
//            lista.put("Jugador", "Laura");
//            Mandadero mandadero= new Mandadero(lista, EnumServicio.INGRESAR_PARTIDA);
//            
//            this.flujoSalidaDatos.writeObject(mandadero);
//            this.flujoSalidaDatos.flush();
//            this.socket.close();
//
//        }catch(ClassCastException ex){
//            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, "El objeto recibido no es un mensaje válido", ex);
//        }catch(IOException ex){
//            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
}
