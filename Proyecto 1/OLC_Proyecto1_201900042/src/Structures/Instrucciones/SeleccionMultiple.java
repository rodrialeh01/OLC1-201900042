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
    public String traductorGolang(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion) + "switch " + this.condicion.traductorGolang(identacion) + " {\n";
        if(listaInsdelocontrario == null){
            for (Instruccion ins: this.listaCasosInstrucciones) {
                traduccion+= ins.traductorGolang(identacion+1);
            }
        }else if(listaInsdelocontrario != null){
            for (Instruccion ins: this.listaCasosInstrucciones) {
                traduccion+= ins.traductorGolang(identacion+1);
            }
            traduccion+=OLC_Proyecto1_201900042.tabular(identacion+1) + "default:\n";
            for(Instruccion ins: this.listaInsdelocontrario) {
                traduccion+=ins.traductorGolang(identacion+1);
            }
        }
        traduccion+= OLC_Proyecto1_201900042.tabular(identacion)+"}\n";
        return traduccion;
    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion);
        if(listaInsdelocontrario == null){
            if(this.listaCasosInstrucciones.size() == 1){
                traduccion += "if " + this.condicion.traductorPython(identacion) +  this.listaCasosInstrucciones.get(0).traductorPython(identacion);
            }else if(this.listaCasosInstrucciones.size() > 1){
                for (int i = 0; i < this.listaCasosInstrucciones.size(); i++) {
                    if(i == 0){
                        traduccion += "if " + this.condicion.traductorPython(identacion) +  this.listaCasosInstrucciones.get(i).traductorPython(identacion);
                    }else{
                        traduccion += OLC_Proyecto1_201900042.tabular(identacion) + "elif " + this.condicion.traductorPython(identacion) +  this.listaCasosInstrucciones.get(i).traductorPython(identacion);
                    }
                }
            }
        }else if(listaInsdelocontrario != null){
            if(this.listaCasosInstrucciones.size() == 1){
                traduccion += "if " + this.condicion.traductorPython(identacion) +  this.listaCasosInstrucciones.get(0).traductorPython(identacion);
            }else if(this.listaCasosInstrucciones.size() > 1){
                for (int i = 0; i < this.listaCasosInstrucciones.size(); i++) {
                    if(i == 0){
                        traduccion += "if " + this.condicion.traductorPython(identacion) +  this.listaCasosInstrucciones.get(i).traductorPython(identacion);
                    }else{
                        traduccion += OLC_Proyecto1_201900042.tabular(identacion) + "elif " + this.condicion.traductorPython(identacion) +  this.listaCasosInstrucciones.get(i).traductorPython(identacion);
                    }
                }
            }
            traduccion+= OLC_Proyecto1_201900042.tabular(identacion) + "else:\n";
            for(Instruccion ins: this.listaInsdelocontrario) {
                traduccion+=ins.traductorPython(identacion+1);
            }
        }
        traduccion+= "\n";
        return traduccion;
    }
    
}
