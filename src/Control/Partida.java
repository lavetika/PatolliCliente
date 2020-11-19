/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Graphics.Forma;
import broker.Broker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laura
 */
public class Partida {
    private static Partida partida;
    private List<Broker> jugadores;
    private int cantJugadores;
    private Tablero tablero;
    private int codigoPartida;
    private List<Forma> posicion;

    
    public static Partida getInstance(){
        if (partida == null) {   //KK
            partida = new Partida();
        }
        return partida;
    }
    
    private Partida(){
        this.jugadores = new ArrayList<>();
    }
    
    public void setPartida(int cantJugadores, Tablero tablero, int codigoPartida, List<Broker> jugadores, List<Forma> posicion) {
        this.cantJugadores = cantJugadores;
        this.jugadores = new ArrayList<>(cantJugadores);
        this.tablero = tablero;
        this.codigoPartida = codigoPartida;
        this.posicion = posicion;
    }
    
    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public List<Broker> getJugadores() {
        return jugadores;
    }

    public boolean addJugador(Broker jugador) {
        if (this.getJugadores().size() != Integer.MAX_VALUE) {
            return this.jugadores.add(jugador);
        }
        return false;

    }

    public void setJugadores(List<Broker> jugadores) {
        this.jugadores = jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getCodigoPartida() {
        return codigoPartida;
    }

    public void setCodigoPartida(int codigoPartida) {
        this.codigoPartida = codigoPartida;
    }

    public List<Forma> getPosicion() {
        return posicion;
    }

    public void setPosicion(List<Forma> posicion) {
        this.posicion = posicion;
    }
}
