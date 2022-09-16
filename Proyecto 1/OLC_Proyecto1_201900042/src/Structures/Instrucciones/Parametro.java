/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import Structures.NodoDiagrama;

/**
 *
 * @author Rodrigo
 */
public class Parametro implements Instruccion{

    @Override
    public NodoDiagrama Diagrama() {
        return null;
    }
    public static enum Tipo_Variable{
        CADENA,
        NUMERO,
        BOOLEAN,
        CARACTER
    }
    private final Operacion identificador;
    private final Tipo_Variable tipo;

    public Parametro(Operacion identificador, Tipo_Variable tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }
    @Override
    public String traductorGolang(int identacion) {
        String traduccion = "";
        if(this.tipo == Tipo_Variable.NUMERO){
            traduccion += this.identificador.traductorGolang(identacion) + " float64";
        }else if(this.tipo == Tipo_Variable.CADENA){
            traduccion += this.identificador.traductorGolang(identacion) + " string";
        }else if(this.tipo == Tipo_Variable.BOOLEAN){
            traduccion += this.identificador.traductorGolang(identacion) + " bool";
        }else if(this.tipo == Tipo_Variable.CARACTER){
            traduccion += this.identificador.traductorGolang(identacion) + " byte";
        }else{
            traduccion += "";
        }
        return traduccion;
    }
    
    @Override
    public String traductorPython(int identacion) {        
        return this.identificador.traductorPython(identacion);
    }
}
