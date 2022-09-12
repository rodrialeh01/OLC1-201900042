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
public class Declaracion implements Instruccion{

    public static enum Tipo_Variable{
        RNUMERO,
        RCADENA,
        RBOOLEAN,
        RCARACTER
    }
    
   
    private final Tipo_Variable tipo;
    private Instruccion valor;
    private Object identificador;
    private LinkedList<Instruccion> listaidentificadores;

    public Declaracion(Tipo_Variable tipo, Instruccion valor, LinkedList<Instruccion> listaidentificadores) {
        this.tipo = tipo;
        this.valor = valor;
        this.listaidentificadores = listaidentificadores;
    }
    
    @Override
    public String traductorGolang() {
        String declaraciones="";
        for (int i = 0; i < this.listaidentificadores.size(); i++) {
            if(tipo== Tipo_Variable.RNUMERO){
                if(valor != null){
                    declaraciones+= "var "+ this.listaidentificadores.get(i).traductorGolang() + " float64 = " + valor.traductorGolang() + "\n";
                }
            }else if(tipo== Tipo_Variable.RCADENA){
                if(valor != null){
                    declaraciones+= "var "+ this.listaidentificadores.get(i).traductorGolang() + " string = " + valor.traductorGolang() + "\n";
                }
            }else if(tipo== Tipo_Variable.RBOOLEAN){
                if(valor!=null){
                    declaraciones+= "var "+ this.listaidentificadores.get(i).traductorGolang() + " bool = " + valor.traductorGolang() + "\n";
                }
            }else if(tipo== Tipo_Variable.RCARACTER){
                if(valor != null){
                    declaraciones+= "var "+ this.listaidentificadores.get(i).traductorGolang() + " byte = " + valor.traductorGolang() + "\n";
                }
            }else{
                declaraciones+= "";
            }
        }
        return declaraciones;
    }
    
}
