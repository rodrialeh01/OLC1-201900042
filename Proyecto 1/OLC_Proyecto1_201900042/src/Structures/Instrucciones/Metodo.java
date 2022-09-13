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
    public String traductorGolang() {
        String traduccion = "";
        if (this.instrucciones != null) {
            if (this.listaParametros == null) {
                traduccion += "func " + this.identificador.traductorGolang() + "(){\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorGolang();
                }
                traduccion += "\n}\n";
            } else if (this.listaParametros != null) {
                traduccion += "func " + this.identificador.traductorGolang() + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorGolang();
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorGolang() + ",";
                }
                traduccion += "){\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorGolang();
                }
                traduccion += "\n}\n";
            } 
        }else if(this.instrucciones ==  null){
            if (this.listaParametros == null) {
                traduccion += "func " + this.identificador.traductorGolang() + "(){\n}\n";
            } else if (this.listaParametros != null) {
                traduccion += "func " + this.identificador.traductorGolang() + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorGolang();
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorGolang() + ",";
                }
                traduccion += "){\n}\n";
            } 
        }
        return traduccion;

    }

}
