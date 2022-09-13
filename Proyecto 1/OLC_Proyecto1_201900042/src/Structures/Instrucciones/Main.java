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
public class Main implements Instruccion{
    private LinkedList<Instruccion> listaInstrucciones;

    public static boolean importacion_potencia = false;
    public static boolean importacion_print = false;
    public Main(LinkedList<Instruccion> listaInstrucciones) {
        this.listaInstrucciones = listaInstrucciones;
    }

    public Main() {
    }

    @Override
    public String traductorGolang(int identacion) {
        String cabecera = "package main\n\n";
        if (importacion_potencia == true || importacion_print == true) {
            cabecera+= "import(\n";
            if(importacion_potencia == true){
                cabecera += "\t\"math\"\n";
            }
            if(importacion_print == true){
                cabecera += "\t\"fmt\"\n";
            }
            cabecera+=")\n\n";
        }
        String traduccion = cabecera + "func main(){\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorGolang(identacion +1);
            }
            traduccion+="\n}\n";
        }else if(this.listaInstrucciones == null){
            traduccion+="\n}\n";
        }
        return traduccion;
    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = "def main():\n";
        if(this.listaInstrucciones != null){
            for (Instruccion ins: this.listaInstrucciones) {
                traduccion+=ins.traductorPython(identacion+1);
            }
        }else if(this.listaInstrucciones == null){
            traduccion+="\tpass\n";
        }
        traduccion += "\nif __name__ == \'__main__\':\n" + OLC_Proyecto1_201900042.tabular(identacion+1) + "main()\n";
        return traduccion;
    }
}
