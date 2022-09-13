/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import olc_proyecto1_201900042.OLC_Proyecto1_201900042;

/**
 *
 * @author Rodrigo
 */
public class Retornar implements Instruccion{
    public final Operacion valor;

    public Retornar(Operacion valor) {
        this.valor = valor;
    }

    @Override
    public String traductorGolang(int identacion) {
        String retorno = "return " + this.valor.traductorGolang(identacion) + "\n";
        return retorno;
    }

    @Override
    public String traductorPython(int identacion) {
        String retorno = OLC_Proyecto1_201900042.tabular(identacion) + "return " + this.valor.traductorPython(identacion) + "\n";
        return retorno;
    }
    
}
