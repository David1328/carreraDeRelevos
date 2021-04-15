/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Modelo.Corredor;

/**
 *
 * @author David
 */
public class PistaDeCorrer {
    public static void main(String[] args) throws InterruptedException {
        Object equipoUno = new Object();
        Object equipoDos = new Object();
        Object equipoTres = new Object();
        
        
        Corredor corredorUnoA = new Corredor("Corredor1 Azul",equipoUno);
        Corredor corredorDosA = new Corredor("Corredor2 Azul",equipoUno);
        Corredor corredorTresA = new Corredor("Corredor3 Azul",equipoUno);
        
        Corredor corredorUnoR = new Corredor("Corredor1 Rojo",equipoDos);
        Corredor corredorDosR = new Corredor("Corredor2 Rojo",equipoDos);
        Corredor corredorTresR = new Corredor("David Rojo",equipoDos);
        
        
        Corredor corredorUnoN = new Corredor("Corredor1 Naranja",equipoTres);
        Corredor corredorDosN = new Corredor("Corredor2 Naranja",equipoTres);
        Corredor corredorTresN = new Corredor("David Naranja",equipoTres);
        
        //Equipo Uno
        corredorUnoA.start();
        corredorDosA.start();
        corredorTresA.start();
        
        //Equipo Dos
        corredorUnoR.start();
        corredorDosR.start();
        corredorTresR.start();
        
        //Equipo tres
        corredorUnoN.start();
        corredorDosN.start();
        corredorTresN.start();
        
        Thread.sleep(1000);
        synchronized(equipoUno){
            equipoUno.notify();
        }
        
        
        synchronized(equipoDos){
            equipoDos.notify();
        }
        
        synchronized(equipoTres){
            equipoTres.notify();
        }
    }
}