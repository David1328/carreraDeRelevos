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
        //Creación de objetos en común para cada equipo que se va a usar
        Object equipoUno = new Object();
        Object equipoDos = new Object();
        Object equipoTres = new Object();
        //Se inicializan los objetos como Letra, objeto en comun y cantidad a recorrer
        Corredor corredorUnoA = new Corredor(79, equipoUno, 33);
        Corredor corredorDosA = new Corredor(79, equipoUno, 33);
        Corredor corredorTresA = new Corredor(79, equipoUno, 34);

        Corredor corredorUnoR = new Corredor(158, equipoDos, 33);
        Corredor corredorDosR = new Corredor(158, equipoDos, 33);
        Corredor corredorTresR = new Corredor(158, equipoDos, 34);

        Corredor corredorUnoN = new Corredor(240, equipoTres, 33);
        Corredor corredorDosN = new Corredor(240, equipoTres, 33);
        Corredor corredorTresN = new Corredor(240, equipoTres, 34);

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
        
        //Se emplea sincronización por bloques para desbloquear el primer wait que encuentre
        synchronized (equipoUno) {
            equipoUno.notify();
        }

        synchronized (equipoDos) {
            equipoDos.notify();
        }

        synchronized (equipoTres) {
            equipoTres.notify();
        }

    }
}
