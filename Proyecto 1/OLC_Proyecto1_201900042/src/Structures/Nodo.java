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
public class Nodo {
    private String valor;
    private String tipo;
    private LinkedList<Nodo> hijos;
    private int id;

    public Nodo(String valor, String tipo) {
        this.id = 0;
        this.valor = valor;
        this.tipo = tipo;
        this.hijos = new LinkedList<Nodo>();
    }

    public String getValor() {
        return valor;
    }
    public int getId() {
        return id;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(LinkedList<Nodo> hijos) {
        this.hijos = hijos;
    }
    
    public void agregarHijo(Nodo hijo){
        this.hijos.add(hijo);
    }
}
