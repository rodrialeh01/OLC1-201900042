/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures;

import Structures.Instrucciones.Instruccion;
import java.util.LinkedList;
/**
 *
 * @author Rodrigo
 */
public class Produccion {
    private Nodo nodo;
    private Instruccion ins;
    private LinkedList<Instruccion> instrucciones;

    public Produccion() {
    }

    public Produccion(Nodo nodo) {
        this.nodo = nodo;
    }
    

    public Produccion(Nodo nodo, Instruccion ins) {
        this.nodo = nodo;
        this.ins = ins;
    }

    public Produccion(Nodo nodo, LinkedList<Instruccion> instrucciones) {
        this.nodo = nodo;
        this.instrucciones = instrucciones;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public Instruccion getIns() {
        return ins;
    }

    public void setIns(Instruccion ins) {
        this.ins = ins;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(LinkedList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public void agregarIns(Instruccion ins){
        this.instrucciones.add(ins);
    }
    
    public void agregarHijo(String valor){
        this.nodo.agregarhijo(valor);
    }
    
    public void agregarHijo(Produccion valor){
        this.nodo.agregarhijo(valor.getNodo());
    }
    
}
