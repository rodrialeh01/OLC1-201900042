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
public class Repetir implements Instruccion{
    private final Instruccion condicion;
    
    private LinkedList<Instruccion> listaInstrucciones;

    //REPETIR VACIO
    public Repetir(Instruccion condicion) {
        this.condicion = condicion;
    }
    //REPETIR CON INSTRUCCIONES
    public Repetir(Instruccion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    
    
    @Override
    public String traductorGolang(int identacion) {
        String traduccion =OLC_Proyecto1_201900042.tabular(identacion) + "for true {\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion += ins.traductorGolang(identacion+1);
            }
        }
        traduccion+="\n"+OLC_Proyecto1_201900042.tabular(identacion)+"if(" + this.condicion.traductorGolang(identacion) + "){\n"+OLC_Proyecto1_201900042.tabular(identacion+1)+"\tbreak\n"+OLC_Proyecto1_201900042.tabular(identacion+1)+"}\n}";
        return traduccion;
    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion) + "while True:\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion += ins.traductorPython(identacion+1);
            }
        }
        traduccion += OLC_Proyecto1_201900042.tabular(identacion) + "if " + this.condicion.traductorPython(identacion) + ":\n" + OLC_Proyecto1_201900042.tabular(identacion+1) + "break\n";
        return traduccion;
    }

    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama("repetir mientras" + this.condicion.traductorGolang(0), "CICLO_DW");
        if(this.listaInstrucciones != null){
            nuevo.agregarHijos(this.listaInstrucciones.get(0).Diagrama());
            int finallista = this.listaInstrucciones.size()-1;
            this.listaInstrucciones.get(finallista).Diagrama().agregarHijosCondicion(nuevo,"SI");
        }
        return nuevo;
    }
        
}
