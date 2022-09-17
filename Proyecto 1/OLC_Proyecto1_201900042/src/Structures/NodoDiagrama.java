package Structures;

import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rodrigo
 */
public class NodoDiagrama {
    private String valor;
    private LinkedList<NodoDiagrama> hijos;
    private String tipo;
    private String condicion;
    private int id;

    public NodoDiagrama(String valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
        this.hijos = new LinkedList<NodoDiagrama>();
        this.condicion = "";
        this.id = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LinkedList<NodoDiagrama> getHijos() {
        return hijos;
    }

    public void setHijos(LinkedList<NodoDiagrama> hijos) {
        this.hijos = hijos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void agregarHijos(NodoDiagrama hijo){
        this.hijos.add(hijo);
    }
    public void agregarHijosCondicion(NodoDiagrama hijo, String condicion){
        this.hijos.add(hijo);
        this.condicion = condicion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
}
