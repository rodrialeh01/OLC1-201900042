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
public class Osi implements Instruccion{
    private final Instruccion condicion;
    
    private LinkedList<Instruccion> listaInstrucciones;

    public Osi(Instruccion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }

    public Osi(Instruccion condicion) {
        this.condicion = condicion;
    }
    
    @Override
    public String traductorGolang(int identacion) {
        String traduccion = "else if " + this.condicion.traductorGolang(identacion) + " {\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang(identacion+1);
            }
        }
        traduccion+="\n"+OLC_Proyecto1_201900042.tabular(identacion)+"}";
        return traduccion;
    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion) + "elif " + this.condicion.traductorPython(identacion) + ":\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorPython(identacion+1);
            }
        }else{
            traduccion += OLC_Proyecto1_201900042.tabular(identacion) + "pass\n";
        }
        traduccion += "\n";
        return traduccion;
    }
    
}
