package conexionCliente;

import Control.Partida;
import callMessage.Mandadero;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComunicadorRedServidor extends Observable implements Runnable {

    private Socket socket;
    private ObjectOutputStream flujoSalidaDatos;
    private ObjectInputStream flujoEntradaDatos;
   // Partida partida;

    public ComunicadorRedServidor(Socket socket) throws IOException {
        this.socket = socket;
       // this.partida = Partida.getInstance();
        try {
            this.flujoSalidaDatos = new ObjectOutputStream(this.socket.getOutputStream());
            this.flujoEntradaDatos = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

//    public Partida getPartida() {
//        return partida;
//    }

    public void desconectar() throws IOException {
        try {
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void enviarPeticion(Mandadero m) {
        try {
            this.flujoSalidaDatos.writeObject(m);
            this.flujoSalidaDatos.flush();
//            this.socket.close();
        } catch (ClassCastException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, "El objeto recibido no es un mandadero válido", ex);
        } catch (IOException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//waite
//intentamos de nuevo, para ver si llegan?

    public Mandadero recibirPeticion() { //espera aber
        Mandadero mandadero = null;
        try {
            // nope, suicidó
            mandadero = (Mandadero) this.flujoEntradaDatos.readObject();
//            this.partida.enviarMensaje(mandadero);
            System.out.println(mandadero.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mandadero;
    } //aqui no hay run

    //somos unos genios caidos kk
    //vamos creciendo, sí podemos
    //qué
    //sí funcionó qwq maso
    // creo que puede ser problema del server también
    @Override
    public void run() {
        Mandadero mandadero;

        do {
            mandadero = recibirPeticion();

            this.setChanged();
            this.notifyObservers(mandadero);
            this.clearChanged();

        } while (!mandadero.getRespuesta().get("mensaje").equals("Adios"));
        // estaba leyendo el otro código :c

    }//fue porque cerré al cliente
    //se va a morir toh

}
