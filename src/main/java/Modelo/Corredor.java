/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Corredor extends Thread {

    //Se inicializa cantidad recorrida, la cual guarda la cantidad recorrida en el run
    private int cantidadRecorrida = 1;
    //se declara caracteristicas del corredor como nombre, equipo y posicion de inicio
    private int figura;
    private Object equipo;
    private int posicionI;

    public Corredor() {
    }

    public Corredor(int figura, Object team, int posicionI) {
        this.figura = figura;
        this.equipo = team;
        this.posicionI = posicionI;
    }

    @Override
    public void run() {

        synchronized (this.getEquipo()) {
            /*if (Thread.currentThread().getName().equals("Thread-2")) {
                System.out.println("ok");
            }*/
            try {
                System.out.println("Inicializar" + ((char) this.getFigura()));

                this.getEquipo().wait();

                while (getCantidadRecorrida() < getPosicionI()) {

                    setCantidadRecorrida(getCantidadRecorrida() + (int) (Math.random() * 2));
                    setCantidadRecorrida(getCantidadRecorrida() > getPosicionI() ? getPosicionI() : getCantidadRecorrida());

                    for (int i = 1; i < getCantidadRecorrida(); i++) {

                        System.out.print(" ");
                    }
                    //System.out.print(((char) this.getFigura()));
                    System.out.print(((char) this.getFigura()) + "\n");
                    Thread.sleep(500);
                }

                System.out.print(" llegada-" + ((char) this.getFigura()) + "\n");

                this.getEquipo().notify();

            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * @return the cantidadRecorrida
     */
    public int getCantidadRecorrida() {
        return cantidadRecorrida;
    }

    /**
     * @param cantidadRecorrida the cantidadRecorrida to set
     */
    public void setCantidadRecorrida(int cantidadRecorrida) {
        this.cantidadRecorrida = cantidadRecorrida;
    }

    /**
     * @return the nombre
     */
    public int getFigura() {
        return figura;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(int figura) {
        this.figura = figura;
    }

    /**
     * @return the equipo
     */
    public Object getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(Object equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the posicionI
     */
    public int getPosicionI() {
        return posicionI;
    }

    /**
     * @param posicionI the posicionI to set
     */
    public void setPosicionI(int posicionI) {
        this.posicionI = posicionI;
    }

}
