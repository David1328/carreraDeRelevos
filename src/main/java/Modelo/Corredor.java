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
public class Corredor extends Thread{
    
    public int cantidadRecorrida = 0;
    public String nombre;

    public Corredor() {
    }
    
    
    public Corredor(String nombre) {
        this.nombre = nombre;
    }
    
    public synchronized void correr(){
        while(cantidadRecorrida< 100){
                cantidadRecorrida += Math.round((float)Math.random()*10);
            }
        System.out.println("Metros= "+cantidadRecorrida+" corredor "+ nombre);
        notify();
    }
    public synchronized void esperarTurno() throws InterruptedException{
        wait();
        while(cantidadRecorrida< 100){
                cantidadRecorrida += Math.round((float)Math.random()*10);
            }
        System.out.println("Metros= "+cantidadRecorrida+" corredor "+ nombre);
        notify();
    }
}