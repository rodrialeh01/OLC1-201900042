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
    public String traductorGolang() {
        String traduccion = "if " + this.condicion.traductorGolang() + "{\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+= OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador+=1)+ins.traductorGolang();
            }
            traduccion+="\n}";
        }
        if (this.listaOSiInstrucciones != null) {
            traduccion+= "";
            for (Instruccion ins: this.listaOSiInstrucciones) {
                traduccion+="else "+ins.traductorGolang();
            }
            traduccion+="\n";
        }
        if (this.listaInsdelocontrario != null) {
            traduccion+= "else{\n";
            for (Instruccion ins: this.listaInsdelocontrario) {
                traduccion+=OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador+=1) + ins.traductorGolang();
            }
            traduccion+="\n}\n";
        }
        return traduccion;
    }
}
