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
    private Operacion valor;
    private Object identificador;
    private LinkedList<Instruccion> listaidentificadores;
    public Declaracion(Tipo_Variable tipo, Operacion identificador, Operacion valor) {
        this.tipo = tipo;
        this.identificador = identificador;
        this.valor = valor;
    }

    public Declaracion(Tipo_Variable tipo, Operacion identificador) {
        this.tipo = tipo;
        this.identificador = identificador;
    }

    public Declaracion(Tipo_Variable tipo, LinkedList<Instruccion> listaidentificadores) {
        this.tipo = tipo;
        this.listaidentificadores = listaidentificadores;
    }

    public Declaracion(Tipo_Variable tipo, Operacion valor, LinkedList<Instruccion> listaidentificadores) {
        this.tipo = tipo;
        this.valor = valor;
        this.listaidentificadores = listaidentificadores;
    }

    
    
    
    @Override
    public String traductorGolang() {
        String ids = "";
        if(listaidentificadores == null){
            if(tipo== Tipo_Variable.RNUMERO){
                if(valor != null){
                    return "var "+ identificador.toString() + " int = " + valor.traductorGolang() + "\n";
                }
                return "var "+ identificador.toString() + " int\n";
            }else if(tipo== Tipo_Variable.RCADENA){
                if(valor != null){
                    return "var "+ identificador.toString() + " string = " + valor.traductorGolang() + "\n";
                }
                return "var "+ identificador.toString() + " string\n";
            }else if(tipo== Tipo_Variable.RBOOLEAN){
                if(valor!=null){
                    return "var "+ identificador.toString() + " bool = " + valor.traductorGolang() + "\n";
                }
                return "var "+ identificador.toString() + " bool\n";
            }else if(tipo== Tipo_Variable.RCARACTER){
                if(valor != null){
                    return "var "+ identificador.toString() + " byte = " + valor.traductorGolang() + "\n";
                }
                return "var "+ identificador.toString() + " byte\n";
            }else{
                return "";
            }
        }else{
            String declaraciones="";
            for (int i = 0; i < listaidentificadores.size(); i++) {
                if(tipo== Tipo_Variable.RNUMERO){
                    if(valor != null){
                        declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " int = " + valor.traductorGolang() + "\n";
                    }
                    declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " int\n";
                }else if(tipo== Tipo_Variable.RCADENA){
                    if(valor != null){
                        declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " string = " + valor.traductorGolang() + "\n";
                    }
                    declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " string\n";
                }else if(tipo== Tipo_Variable.RBOOLEAN){
                    if(valor!=null){
                        declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " bool = " + valor.traductorGolang() + "\n";
                    }
                    declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " bool\n";
                }else if(tipo== Tipo_Variable.RCARACTER){
                    if(valor != null){
                        declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " byte = " + valor.traductorGolang() + "\n";
                    }
                    declaraciones+= "var "+ listaidentificadores.get(i).traductorGolang() + " byte\n";
                }else{
                    declaraciones+= "";
                }
            }
            return declaraciones;
        }
    }
    
}
