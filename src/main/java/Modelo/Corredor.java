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
    
    public static final String ANSI_RED = "\u001B[31m";

    public Corredor() {
    }

    public Corredor(String nombre,Object team) {
        this.nombre = nombre;
        this.equipo = team;
    }

    @Override
    public  void run(){
        
        synchronized(this.equipo){
            try {
                System.out.println("Antes");
                this.equipo.wait();
                System.out.println("Despues");
                this.equipo.notify();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}

