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

    public int cantidadRecorrida = 0;
    public String nombre;
    public Object equipo;
    public int posicionI;
 

    public static final String ANSI_RED = "\u001B[31m";

    public Corredor() {
    }

    public Corredor(String nombre, Object team, int posicionI) {
        this.nombre = nombre;
        this.equipo = team;
        this.posicionI = posicionI;
    }

    @Override
    public void run() {
        
        synchronized (this.equipo) {
            try {
                System.out.println("Iniciando" + this.nombre);
                this.equipo.wait();

                while (cantidadRecorrida < posicionI) {

                    cantidadRecorrida += (int) (Math.random() * 3);
                    cantidadRecorrida = cantidadRecorrida > posicionI ? posicionI : cantidadRecorrida;

                    for (int i = 0; i < cantidadRecorrida; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(this.nombre + "\n");
                }

                System.out.print("|");
                
                this.equipo.notify();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
