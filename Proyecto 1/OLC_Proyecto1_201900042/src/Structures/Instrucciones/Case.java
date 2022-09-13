/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import java.util.LinkedList;
import olc_proyecto1_201900042.OLC_Proyecto1_201900042;

/**
 *
 * @author Rodrigo
 */
public class Case implements Instruccion{
    private final Instruccion condicion;
    
    private final LinkedList<Instruccion> listaInstrucciones;

    public Case(Instruccion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    @Override
    public String traductorGolang() {
        String traductor ="";
        if(this.listaInstrucciones!= null){
            traductor += "case " + this.condicion.traductorGolang() + ":\n";
            for (Instruccion ins: this.listaInstrucciones) {
                traductor+= ins.traductorGolang();
            }
            traductor+= "\n";
        }
        return traductor;
    }
    
}
