/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Enum.EnumCasilla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 *
 * @author laura
 */
public class SemiCircular extends Forma {

    private int rotacion;   
    
    public SemiCircular(EnumCasilla posicion, int positionX, int positionY, int tamanio, int rotacion) {
        super(posicion, positionX, positionY, tamanio);
        this.rotacion = rotacion;
    }
    
    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(colorHuesito);
        g2d.fillArc(positionX, positionY, tamanio*2, tamanio*2, rotacion, 90);
        g2d.setColor(Color.BLACK);
        g2d.drawArc(positionX, positionY, tamanio*2, tamanio*2, rotacion, 90);
    }
}
