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
public class SeleccionMultiple implements Instruccion{
    private final Instruccion condicion;
    
    private LinkedList<Instruccion> listaCasosInstrucciones;
    
    private LinkedList<Instruccion> listaInsdelocontrario;

    //SEGUN SOLO CON CASOS
    public SeleccionMultiple(Instruccion condicion, LinkedList<Instruccion> listaCasosInstrucciones) {
        this.condicion = condicion;
        this.listaCasosInstrucciones = listaCasosInstrucciones;
    }
    //SEGUN CON CASOS Y EL DE LO CONTRARIO
    public SeleccionMultiple(Instruccion condicion, LinkedList<Instruccion> listaCasosInstrucciones, LinkedList<Instruccion> listaInsdelocontrario) {
        this.condicion = condicion;
        this.listaCasosInstrucciones = listaCasosInstrucciones;
        this.listaInsdelocontrario = listaInsdelocontrario;
    }
    
    @Override
    public String traductorGolang() {
        String traduccion = "switch " + this.condicion.traductorGolang() + " {\n";
        if(listaInsdelocontrario == null){
            for (Instruccion ins: this.listaCasosInstrucciones) {
                traduccion+= ins.traductorGolang();
            }
        }else if(listaInsdelocontrario != null){
            for (Instruccion ins: this.listaCasosInstrucciones) {
                traduccion+= ins.traductorGolang();
            }
            traduccion+= OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador+1) + "default:\n";
            for(Instruccion ins: this.listaInsdelocontrario) {
                traduccion+= OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador+2) + ins.traductorGolang();
            }
        }
        traduccion+= "}\n";
        return traduccion;
    }
    
}
