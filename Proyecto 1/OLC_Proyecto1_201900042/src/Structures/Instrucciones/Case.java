/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import Structures.NodoDiagrama;
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
    public String traductorGolang(int identacion) {
        String traductor ="";
        if(this.listaInstrucciones!= null){
            traductor +=OLC_Proyecto1_201900042.tabular(identacion) + "case " + this.condicion.traductorGolang(identacion) + ":\n";
            for (Instruccion ins: this.listaInstrucciones) {
                traductor+= ins.traductorGolang(identacion +1);
            }
            traductor+= "\n";
        }
        return traductor;
    }

    @Override
    public String traductorPython(int identacion) {
        String traductor ="";
        if(this.listaInstrucciones!= null){
            traductor += " == " + this.condicion.traductorPython(identacion) + ":\n";
            for (Instruccion ins: this.listaInstrucciones) {
                traductor+= ins.traductorPython(identacion+1);
            }
            traductor+= "\n";
        }
        return traductor;
    }

    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama(this.traductorGolang(0), "CONDICION");
        if (this.listaInstrucciones!= null) {
            nuevo.agregarHijos(this.listaInstrucciones.get(0).Diagrama());
        }
        return nuevo;
    }
    
}
