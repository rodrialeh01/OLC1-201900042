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
    public String traductorGolang(int identacion) {
        String traduccion =OLC_Proyecto1_201900042.tabular(identacion) + "for true {\n"+OLC_Proyecto1_201900042.tabular(identacion+1)+"if!("+this.condicion.traductorGolang(identacion)+"){\n"+OLC_Proyecto1_201900042.tabular(identacion+1)+"\tbreak\n"+OLC_Proyecto1_201900042.tabular(identacion+1)+"}\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang(identacion+1);
            }
        }
        traduccion += "\n"+OLC_Proyecto1_201900042.tabular(identacion)+"}\n";
        return traduccion;
    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion) + "while " + this.condicion.traductorPython(identacion) + ":\n";
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

    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama("mientras " + this.condicion.traductorGolang(0),"CICLO_W");
        if(this.listaInstrucciones != null){
            nuevo.agregarHijosCondicion(this.listaInstrucciones.get(0).Diagrama(), "SI");
            int finallista = this.listaInstrucciones.size()-1;
            this.listaInstrucciones.get(finallista).Diagrama().agregarHijos(nuevo);
        }
        return nuevo;
    }
    
}
