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
public class Declaracion implements Instruccion{
    private final Parametro.Tipo_Variable tipo;
    private Instruccion valor;
    private Object identificador;
    private LinkedList<Instruccion> listaidentificadores;

    public Declaracion(Parametro.Tipo_Variable tipo, Instruccion valor, LinkedList<Instruccion> listaidentificadores) {
        this.tipo = tipo;
        this.valor = valor;
        this.listaidentificadores = listaidentificadores;
    }
    
    @Override
    public String traductorGolang(int identacion) {
        String declaraciones="";
        for (int i = 0; i < this.listaidentificadores.size(); i++) {
            if(tipo== Parametro.Tipo_Variable.NUMERO){
                if(valor != null){
                    declaraciones+=OLC_Proyecto1_201900042.tabular(identacion) + "var "+ this.listaidentificadores.get(i).traductorGolang(identacion) + " float64 = " + valor.traductorGolang(identacion) + "\n";
                }
            }else if(tipo== Parametro.Tipo_Variable.CADENA){
                if(valor != null){
                    declaraciones+=OLC_Proyecto1_201900042.tabular(identacion) +  "var "+ this.listaidentificadores.get(i).traductorGolang(identacion) + " string = " + valor.traductorGolang(identacion) + "\n";
                }
            }else if(tipo== Parametro.Tipo_Variable.BOOLEAN){
                if(valor!=null){
                    declaraciones+=OLC_Proyecto1_201900042.tabular(identacion) +  "var "+ this.listaidentificadores.get(i).traductorGolang(identacion) + " bool = " + valor.traductorGolang(identacion) + "\n";
                }
            }else if(tipo== Parametro.Tipo_Variable.CARACTER){
                if(valor != null){
                    declaraciones+=OLC_Proyecto1_201900042.tabular(identacion) + "var "+ this.listaidentificadores.get(i).traductorGolang(identacion) + " byte = " + valor.traductorGolang(identacion) + "\n";
                }
            }else{
                declaraciones+= "";
            }
        }
        return declaraciones;
    }

    @Override
    public String traductorPython(int identacion) {
        String declaraciones="";
        for (int i = 0; i < this.listaidentificadores.size(); i++) {
            declaraciones += OLC_Proyecto1_201900042.tabular(identacion) + this.listaidentificadores.get(i).traductorPython(identacion) + " = " + valor.traductorPython(identacion) + "\n";
        }
        return declaraciones;
    }
    
}
