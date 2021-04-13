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
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

/**
 *
 * @author David
 */
public class Equipo extends Thread{

    private List<Corredor> equipo = new ArrayList<>();
    private String colorDelEquipo;
    private int figuraAscii;

    public Equipo() {
    }

    public Equipo(String colorDelEquipo, int figuraAscii) {
        this.colorDelEquipo = colorDelEquipo;
        this.figuraAscii = figuraAscii;
    }
    
    @Override
    public void run() {
        
        for (Corredor corredor : getEquipo()) {
            corredor.start();
            if(corredor.nombre.equals(getEquipo().get(0).nombre)){
                corredor.correr(getFiguraAscii());
            }else{
                try {
                    corredor.esperarTurno(getFiguraAscii());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.print("Termino el equipo"+ getColorDelEquipo());
    }
    
    /**
     * @return the equipo
     */
    public List<Corredor> getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(List<Corredor> equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the nombreDelEquipo
     */
    public String getColorDelEquipo() {
        return colorDelEquipo;
    }

    /**
     * @param nombreDelEquipo the nombreDelEquipo to set
     */
    public void setNombreDelEquipo(String nombreDelEquipo) {
        this.colorDelEquipo = nombreDelEquipo;
    }

    /**
     * @return the figuraAscii
     */
    public int getFiguraAscii() {
        return figuraAscii;
    }

    /**
     * @param figuraAscii the figuraAscii to set
     */
    public void setFiguraAscii(int figuraAscii) {
        this.figuraAscii = figuraAscii;
    }
    
}