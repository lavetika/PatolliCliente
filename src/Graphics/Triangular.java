/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Dominio.Ficha;
import Enumaration.EnumCasilla;
import Enumaration.EnumDireccion;
import java.awt.Graphics2D;

/**
 *
 * @author laura
 */
public class Triangular extends Forma {

    public Triangular() {
        super();
    }

    
    public Triangular(EnumCasilla posicion, int positionX, int positionY, int tamanio, int position, EnumDireccion direccion) {
        super(posicion, positionX, positionY, tamanio, position, direccion);
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