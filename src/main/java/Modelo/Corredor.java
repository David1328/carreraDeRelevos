/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */
public class Corredor extends Thread {

    public int cantidadRecorrida = 0;
    public String nombre;
    
    public static final String ANSI_RED = "\u001B[31m";

    public Corredor() {
    }

    public Corredor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public  void run(){
        
    }
    
    public synchronized void correr(int figura) {
        while (cantidadRecorrida < 100) {
            System.out.flush();
            cantidadRecorrida += Math.round((float) Math.random() * 5);
            cantidadRecorrida = (cantidadRecorrida > 100)?100:cantidadRecorrida;
            for (int i = 0; i < cantidadRecorrida; i++) {
                System.out.print(" ");
            }
            System.out.print(ANSI_RED+(char)figura);
            //System.out.println("Metros= " + cantidadRecorrida + " corredor " + nombre);
        }
        System.out.print(" | ");
        
        notify();
    }

    public synchronized void esperarTurno(int figura) throws InterruptedException {
        //wait();
        while (cantidadRecorrida < 20) {
            System.out.flush();
            cantidadRecorrida += Math.round((float) Math.random() * 5);
            cantidadRecorrida = (cantidadRecorrida > 100)?100:cantidadRecorrida;
            for (int i = 0; i < cantidadRecorrida; i++) {
                System.out.print(" ");
            }
            System.out.print(ANSI_RED+((char)figura));
            //System.out.println("Metros= " + cantidadRecorrida + " corredor " + nombre);
        }
        System.out.print(" | ");
        //notify();
    }
}

