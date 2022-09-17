/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import Structures.NodoDiagrama;
import java.util.LinkedList;
import olc_proyecto1_201900042.OLC_Proyecto1_201900042;

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
    public String traductorGolang(int identacion) {
        String asignaciones = "";
        for (int i = 0; i < this.listaidentificadores.size(); i++) {
            asignaciones += OLC_Proyecto1_201900042.tabular(identacion) + this.listaidentificadores.get(i).traductorGolang(identacion) + " = " + this.valor.traductorGolang(identacion) + "\n";
        }
        return asignaciones;
    }

    @Override
    public String traductorPython(int identacion) {
        String asignaciones = "";
        for (int i = 0; i < this.listaidentificadores.size(); i++) {
            asignaciones += OLC_Proyecto1_201900042.tabular(identacion) + this.listaidentificadores.get(i).traductorPython(identacion) + " = " + this.valor.traductorPython(identacion) + "\n";
        }
        return asignaciones;
    }

    @Override
    public NodoDiagrama Diagrama() {
        String ids = "Asignar:\n";
        for (Instruccion ins: this.listaidentificadores) {
            ids+= ins.traductorGolang(0) + " = " + valor.traductorGolang(0) + "\n";
        }
        NodoDiagrama nuevo = new NodoDiagrama(ids,"ENTRADA/SALIDA");
        return nuevo;
    }
}
