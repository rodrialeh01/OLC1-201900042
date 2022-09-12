/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

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
    public String traductorGolang() {
        String retorno = "return " + this.valor.traductorGolang() + "\n";
        return retorno;
    }
    
}
