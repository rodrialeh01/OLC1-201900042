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
public class Metodo implements Instruccion {
    private final Operacion identificador;
    private LinkedList<Instruccion> listaParametros;
    private LinkedList<Instruccion> instrucciones;

    public Metodo(Operacion identificador, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> instrucciones) {
        this.identificador = identificador;
        this.listaParametros = listaParametros;
        this.instrucciones = instrucciones;
    }

    public Metodo(Operacion identificador, LinkedList<Instruccion> listaParametros) {
        this.identificador = identificador;
        this.listaParametros = listaParametros;
    }

    public Metodo(LinkedList<Instruccion> instrucciones, Operacion identificador) {
        this.identificador = identificador;
        this.instrucciones = instrucciones;
    }

    public Metodo(Operacion identificador) {
        this.identificador = identificador;
    }
    

    @Override
    public String traductorGolang(int identacion) {
        String traduccion = "";
        if (this.instrucciones != null) {
            if (this.listaParametros == null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(){\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorGolang(identacion+1);
                }
                traduccion += "\n}\n";
            } else if (this.listaParametros != null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorGolang(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorGolang(identacion) + ",";
                }
                traduccion += "){\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorGolang(identacion+1);
                }
                traduccion += "\n}\n";
            } 
        }else if(this.instrucciones ==  null){
            if (this.listaParametros == null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(){\n}\n";
            } else if (this.listaParametros != null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorGolang(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorGolang(identacion) + ",";
                }
                traduccion += "){\n}\n";
            } 
        }
        return traduccion;

    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = "";
        if (this.instrucciones != null) {
            if (this.listaParametros == null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "():\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorPython(identacion+1);
                }
                traduccion += "\n";
            } else if (this.listaParametros != null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorPython(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorPython(identacion) + ",";
                }
                traduccion += "):\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorPython(identacion+1);
                }
                traduccion += "\n";
            } 
        }else if(this.instrucciones ==  null){
            if (this.listaParametros == null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "():\n\tpass\n";
            } else if (this.listaParametros != null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorPython(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorPython(identacion) + ",";
                }
                traduccion += "):\n\tpass\n";
            } 
        }
        return traduccion;
    }

}
