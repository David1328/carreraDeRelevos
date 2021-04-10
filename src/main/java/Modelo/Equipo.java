/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Equipo extends Thread{
    public List<Corredor> equipo = new ArrayList<>();
    public String nombreDelEquipo;

    public Equipo() {
    }
    
    public Equipo(String nombreDelEquipo) {
        this.nombreDelEquipo = nombreDelEquipo;
    }
    
    @Override
    public void run() {
        for (Corredor corredor : equipo) {
            corredor.start();
            if(corredor.nombre.equals(equipo.get(0).nombre)){
                corredor.correr();
            }else{
                try {
                    corredor.esperarTurno();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Termino el equipo"+ nombreDelEquipo);
    }
    
}