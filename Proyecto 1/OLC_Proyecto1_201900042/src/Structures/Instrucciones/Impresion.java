/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import Structures.NodoDiagrama;
import olc_proyecto1_201900042.OLC_Proyecto1_201900042;

/**
 *
 * @author Rodrigo
 */
public class Impresion implements Instruccion{
    private final Tipo_Impresion tipo;
    
    public static enum Tipo_Impresion{
        CON_SALTO,
        SIN_SALTO
    }
    private Instruccion condicion;

    public Impresion(Tipo_Impresion tipo,Instruccion condicion) {
        this.tipo = tipo;
        this.condicion = condicion;
    }
    
    @Override
    public String traductorGolang(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion);
        if(this.tipo == Tipo_Impresion.SIN_SALTO){
            traduccion+= "fmt.Print(" + this.condicion.traductorGolang(identacion) + ")\n";
        }else if(this.tipo == Tipo_Impresion.CON_SALTO){
            traduccion+= "fmt.Println(" + this.condicion.traductorGolang(identacion) + ")\n";
        }else{
            traduccion="";
        }
        return traduccion;
    }
    
    @Override
    public String traductorPython(int identacion) {
        String traduccion = OLC_Proyecto1_201900042.tabular(identacion);
        if(this.tipo == Tipo_Impresion.SIN_SALTO){
            traduccion+= "print(str(" + this.condicion.traductorPython(identacion) + "), end=\" \")\n";
        }else if(this.tipo == Tipo_Impresion.CON_SALTO){
            traduccion+= "print(str(" + this.condicion.traductorPython(identacion) + "))\n";
        }else{
            traduccion="";
        }
        return traduccion;
    }
    
    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama("mostrar: " + this.condicion.traductorGolang(0),"SALIDA");
        return nuevo;
    }
}
