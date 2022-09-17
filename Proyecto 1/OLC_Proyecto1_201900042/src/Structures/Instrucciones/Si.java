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
public class Si implements Instruccion{
    private final Instruccion condicion;
    
    private final LinkedList<Instruccion> listaInstrucciones;
    
    private LinkedList<Instruccion> listaOSiInstrucciones;
    
    private LinkedList<Instruccion> listaInsdelocontrario;

    //SI
    public Si(Instruccion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    //SI-DE_LO_CONTRARIO
    public Si(Instruccion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaInsdelocontrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaInsdelocontrario = listaInsdelocontrario;
    }
    //SI-O_SI
    public Si(LinkedList<Instruccion> listaInstrucciones,Instruccion condicion, LinkedList<Instruccion> listaOSiInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaOSiInstrucciones = listaOSiInstrucciones;
    }
    
    //SI-O_SI-DE_LO_CONTRARIO
    public Si(Instruccion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaOSiInstrucciones, LinkedList<Instruccion> listaInsdelocontrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaOSiInstrucciones = listaOSiInstrucciones;
        this.listaInsdelocontrario = listaInsdelocontrario;
    }
    
    
    
    @Override
    public String traductorGolang(int identacion) {
        String traduccion ="\n" +OLC_Proyecto1_201900042.tabular(identacion) + "if " + this.condicion.traductorGolang(identacion) + "{\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang(identacion+1);
            }
            traduccion+="\n"+OLC_Proyecto1_201900042.tabular(identacion)+"}";
        }
        if (this.listaOSiInstrucciones != null) {
            traduccion+= "";
            for (Instruccion ins: this.listaOSiInstrucciones) {
                traduccion+=ins.traductorGolang(identacion);
            }
        }
        if (this.listaInsdelocontrario != null) {
            traduccion+="else{\n";
            for (Instruccion ins: this.listaInsdelocontrario) {
                traduccion+= ins.traductorGolang(identacion+1);
            }
            traduccion+="\n"+OLC_Proyecto1_201900042.tabular(identacion)+"}\n";
        }
        return traduccion +"\n";
    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion) + "if " + this.condicion.traductorPython(identacion) + ":\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorPython(identacion+1);
            }
            traduccion+="\n";
        }
        if (this.listaOSiInstrucciones != null) {
            for (Instruccion ins: this.listaOSiInstrucciones) {
                traduccion+= ins.traductorPython(identacion);
            }
            traduccion+="\n";
        }
        if (this.listaInsdelocontrario != null) {
            traduccion+= OLC_Proyecto1_201900042.tabular(identacion) +"else:\n";
            for (Instruccion ins: this.listaInsdelocontrario) {
                traduccion+= ins.traductorPython(identacion+1);
            }
            traduccion+="\n";
        }
        return traduccion;
    }

    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama(this.condicion.traductorGolang(0), "CONDICION");
        NodoDiagrama temp = this.listaInstrucciones.get(0).Diagrama();
        if(this.listaInstrucciones != null){
            nuevo.agregarHijosCondicion(temp, "SI");
        }
        if(this.listaOSiInstrucciones != null){
            nuevo.agregarHijosCondicion(this.listaOSiInstrucciones.get(0).Diagrama(), "NO");
        }
        if(this.listaInsdelocontrario != null){
            nuevo.agregarHijosCondicion(this.listaInsdelocontrario.get(0).Diagrama(), "NO");
        }
        return nuevo;
    }
}
