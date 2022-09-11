/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import java.util.LinkedList;

/**
 *
 * @author Rodrigo
 */
public class Si implements Instruccion{
    
    private final Operacion condicion;
    
    private final LinkedList<Instruccion> listaInstrucciones;
    
    private LinkedList<Instruccion> listaOSiInstrucciones;
    
    private LinkedList<Instruccion> listaInsdelocontrario;

    //SI
    public Si(Operacion condicion, LinkedList<Instruccion> listaInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
    }
    //SI-DE_LO_CONTRARIO
    public Si(Operacion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaInsdelocontrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaInsdelocontrario = listaInsdelocontrario;
    }
    //SI-O_SI
    public Si(LinkedList<Instruccion> listaInstrucciones,Operacion condicion, LinkedList<Instruccion> listaOSiInstrucciones) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaOSiInstrucciones = listaOSiInstrucciones;
    }
    
    //SI-O_SI-DE_LO_CONTRARIO
    public Si(Operacion condicion, LinkedList<Instruccion> listaInstrucciones, LinkedList<Instruccion> listaOSiInstrucciones, LinkedList<Instruccion> listaInsdelocontrario) {
        this.condicion = condicion;
        this.listaInstrucciones = listaInstrucciones;
        this.listaOSiInstrucciones = listaOSiInstrucciones;
        this.listaInsdelocontrario = listaInsdelocontrario;
    }
    
    
    
    @Override
    public String traductorGolang() {
        String traduccion = "\nif " + this.condicion.traductorGolang() + "{\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang();
            }
            traduccion+="\n}";
        }
        if (this.listaOSiInstrucciones != null) {
            traduccion+= "else if" + this.condicion.traductorGolang() + "{\n";
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang();
            }
            traduccion+="\n}";
        }
        if (this.listaInsdelocontrario != null) {
            traduccion+= "else{";
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang();
            }
            traduccion+="\n}\n";
        }
        return traduccion;
    }
    
}
