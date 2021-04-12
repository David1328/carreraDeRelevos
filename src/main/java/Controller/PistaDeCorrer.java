/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Corredor;
import Modelo.Equipo;

/**
 *
 * @author David
 */
public class PistaDeCorrer {
    public static void main(String[] args) throws InterruptedException {
        Corredor corredorUnoA = new Corredor("Corredor1 Azul");
        Corredor corredorDosA = new Corredor("Corredor2 Azul");
        Corredor corredorTresA = new Corredor("Corredor3 Azul");
        
        Corredor corredorUnoR = new Corredor("Corredor1 Rojo");
        Corredor corredorDosR = new Corredor("Corredor2 Rojo");
        Corredor corredorTresR = new Corredor("David Rojo");
        
        
        Corredor corredorUnoN = new Corredor("Corredor1 Naranja");
        Corredor corredorDosN = new Corredor("Corredor2 Naranja");
        Corredor corredorTresN = new Corredor("David Naranja");
        
        Equipo equipoAzu = new Equipo("Azul",244);
        Equipo equipoRoj = new Equipo("Rojo",79);
        Equipo equipoNara = new Equipo("Naranja",219);
        
        equipoAzu.getEquipo().add(corredorUnoA);
        equipoAzu.getEquipo().add(corredorDosA);
        equipoAzu.getEquipo().add(corredorTresA);
        
        equipoRoj.getEquipo().add(corredorUnoR);
        equipoRoj.getEquipo().add(corredorDosR);
        equipoRoj.getEquipo().add(corredorTresR);
        
        
        equipoNara.getEquipo().add(corredorUnoN);
        equipoNara.getEquipo().add(corredorDosN);
        equipoNara.getEquipo().add(corredorTresN);
        
        equipoAzu.start();
        
        //equipoRoj.start();
        
        //equipoNara.start();
        
    }
}