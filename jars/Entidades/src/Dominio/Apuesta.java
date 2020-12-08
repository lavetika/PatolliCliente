
package Dominio;

import java.io.Serializable;


public class Apuesta implements Serializable{
    private static final long serialVersionUID = 2L;
     private int cantApuesta;
    private int montoTotal;
    
      public Apuesta(int total, int cantApuesta) {
        this.montoTotal = total;
        this.cantApuesta = cantApuesta;
    }

    public Apuesta(int cantApuesta) {
        this.cantApuesta = cantApuesta;
    }

    
    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public int getCantApuesta() {
        return cantApuesta;
    }

    public void setCantApuesta(int cantApuesta) {
        this.cantApuesta = cantApuesta;
    }
}
