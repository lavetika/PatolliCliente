package conexionCliente;

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

    public ComunicadorRedServidor(Socket socket) throws IOException {
        this.socket = socket;

        try {
            this.flujoSalidaDatos = new ObjectOutputStream(this.socket.getOutputStream());
            this.flujoEntradaDatos = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException ex) {
            throw ex;
        }
    }

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

        } catch (ClassCastException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, "El objeto recibido no es un mandadero válido", ex);
        } catch (IOException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mandadero recibirPeticion() {
        Mandadero mandadero = null;
        try {
            mandadero = (Mandadero) this.flujoEntradaDatos.readObject();
            System.out.println(mandadero.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComunicadorRedServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mandadero;
    }

    @Override
    public void run() {
        Mandadero mandadero;
        do {

            mandadero = recibirPeticion();
            if (mandadero != null) {
                this.setChanged();
                this.notifyObservers(mandadero);
                this.clearChanged();
            }

        } while (mandadero != null);
    }

}
