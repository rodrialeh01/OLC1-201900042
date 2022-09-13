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
public class Mientras implements Instruccion{
    
    private final Instruccion condicion;
    
    private LinkedList<Instruccion> listaInstrucciones;

    //MIENTRAS VACIO
    public Mientras(Instruccion condicion) {
        this.condicion = condicion;
    }
    //MIENTRAS CON INSTRUCCIONES
    public Mientras(Instruccion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    

    @Override
    public String traductorGolang() {
        String traduccion = "for true {\n\tif!("+this.condicion.traductorGolang()+"){\n\t\tbreak\n\t}\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang();
            }
        }
        traduccion += "\n}\n";
        return traduccion;
    }
    
}
