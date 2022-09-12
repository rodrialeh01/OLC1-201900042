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
public class Asignacion implements Instruccion{
    
    private Instruccion valor;
    private LinkedList<Instruccion> listaidentificadores;

    public Asignacion(Instruccion valor, LinkedList<Instruccion> listaidentificadores) {
        this.valor = valor;
        this.listaidentificadores = listaidentificadores;
    }
    @Override
    public String traductorGolang() {
        String asignaciones = "";
        for (int i = 0; i < this.listaidentificadores.size(); i++) {
            asignaciones += this.listaidentificadores.get(i).traductorGolang() + " = " + this.valor.traductorGolang() + "\n";
        }
        return asignaciones;
    }
    
}
