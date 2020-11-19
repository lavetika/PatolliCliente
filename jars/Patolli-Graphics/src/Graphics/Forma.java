
package Graphics;

import Enum.EnumCasilla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;


public abstract class Forma {
    
    EnumCasilla posicion;
    int positionX;
    int positionY;
    static Color colorHuesito = new Color(243, 243, 220);
    int tamanio;

    public Forma(EnumCasilla posicion, int positionX, int positionY, int tamanio) {
        this.posicion = posicion;
        this.positionX = positionX;
        this.positionY = positionY;
        this.tamanio = tamanio;
    }
    
    public abstract void draw(Graphics2D g2d);
}
