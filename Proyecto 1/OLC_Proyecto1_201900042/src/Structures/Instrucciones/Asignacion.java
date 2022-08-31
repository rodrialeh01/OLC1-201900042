/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

/**
 *
 * @author Rodrigo
 */
public class Asignacion implements Instruccion{
    private Operacion valor;

    public Asignacion(Operacion valor) {
        this.valor = valor;
    }
    
    @Override
    public String traductorGolang() {
        return "(" + valor.traductorGolang() + ")";
    }
    
}
