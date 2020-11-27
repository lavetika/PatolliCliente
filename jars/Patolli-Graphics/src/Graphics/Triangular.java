
package Graphics;

import Dominio.Ficha;
import Enumeration.EnumCasilla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 *
 * @author laura
 */
public class Triangular extends Forma {

    public Triangular(EnumCasilla posicion, int positionX, int positionY, int tamanio) {
        super(posicion, positionX, positionY, tamanio);
    }
    
    @Override
    public void draw(Graphics2D g2d){
        
    }
    
    @Override
    public void drawFicha(Ficha ficha) {
        
    }

    @Override
    public void deleteFicha() {
    }
}
