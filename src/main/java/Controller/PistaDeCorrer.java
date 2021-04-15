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
        
        
        Corredor corredorUnoA = new Corredor("A",equipoUno,33);
        Corredor corredorDosA = new Corredor("A",equipoUno,33);
        Corredor corredorTresA = new Corredor("A",equipoUno,34);
        
        Corredor corredorUnoR = new Corredor("R",equipoDos,33);
        Corredor corredorDosR = new Corredor("R",equipoDos,33);
        Corredor corredorTresR = new Corredor("R",equipoDos,34);
        
        
        Corredor corredorUnoN = new Corredor("V",equipoTres,33);
        Corredor corredorDosN = new Corredor("V",equipoTres,33);
        Corredor corredorTresN = new Corredor("V",equipoTres,34);
        
        //Equipo Uno
        corredorUnoA.start();
        corredorDosA.start();
        corredorTresA.start();
        
        /*
        //Equipo Dos
        corredorUnoR.start();
        corredorDosR.start();
        corredorTresR.start();
        
        /*
        //Equipo tres
        corredorUnoN.start();
        corredorDosN.start();
        corredorTresN.start();*/
        
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