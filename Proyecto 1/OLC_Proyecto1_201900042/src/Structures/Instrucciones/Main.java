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
public class Main implements Instruccion{
    private LinkedList<Instruccion> listaInstrucciones;

    public Main(LinkedList<Instruccion> listaInstrucciones) {
        this.listaInstrucciones = listaInstrucciones;
    }

    public Main() {
    }

    @Override
    public String traductorGolang() {
        String traduccion = "func main(){\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang();
            }
            traduccion+="\n}";
        }else if(this.listaInstrucciones == null){
            traduccion+="\n}";
        }
        return traduccion;
    }
}
