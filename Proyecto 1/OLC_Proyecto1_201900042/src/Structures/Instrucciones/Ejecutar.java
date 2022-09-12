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
public class Ejecutar implements Instruccion{
    public static enum Tipo_Variable{
        EJECUTAR,
        EXPRESION
    }
    private final Operacion identificador;
    private final Tipo_Variable tipo;
    private LinkedList<Instruccion> listaParametros;

    public Ejecutar(Operacion identificador, Tipo_Variable tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public Ejecutar(Operacion identificador, Tipo_Variable tipo, LinkedList<Instruccion> listaParametros) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.listaParametros = listaParametros;
    }
    
    @Override
    public String traductorGolang() {
        if (this.tipo == Tipo_Variable.EJECUTAR) {
            String traduccion = "";
            if (this.listaParametros == null) {
                traduccion += this.identificador.traductorGolang() + "()\n";
            } else if (this.listaParametros != null) {
                traduccion += this.identificador.traductorGolang() + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if (i == this.listaParametros.size() - 1) {
                        traduccion += this.listaParametros.get(i).traductorGolang();
                        break;
                    }
                    traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                }
                traduccion += ")\n";
            }
            return traduccion;
        }else if(this.tipo == Tipo_Variable.EXPRESION){
            String traduccion = "";
            if (this.listaParametros == null) {
                traduccion += this.identificador.traductorGolang() + "()";
            } else if (this.listaParametros != null) {
                traduccion += this.identificador.traductorGolang() + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if (i == this.listaParametros.size() - 1) {
                        traduccion += this.listaParametros.get(i).traductorGolang();
                        break;
                    }
                    traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                }
                traduccion += ")";
            }
            return traduccion;
        }else{
            return "";
        }
    }
    
}
