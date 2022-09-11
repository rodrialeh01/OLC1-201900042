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
public class Repetir implements Instruccion{

    private final Operacion condicion;
    
    private LinkedList<Instruccion> listaInstrucciones;

    //REPETIR VACIO
    public Repetir(Operacion condicion) {
        this.condicion = condicion;
    }
    //REPETIR CON INSTRUCCIONES
    public Repetir(Operacion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    
    @Override
    public String traductorGolang() {
        String traduccion = "for true {\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+= OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador+=1)+ins.traductorGolang();
            }
        }
        traduccion+="\n\tif(" + this.condicion.traductorGolang() + "){\n\t\tbreak\n\t}\n}";
        return traduccion;
    }
        
}
