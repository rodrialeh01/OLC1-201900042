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
public class Main implements Instruccion {

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
            cabecera += "import(\n";
            if (importacion_potencia == true) {
                cabecera += "\t\"math\"\n";
            }
            if (importacion_print == true) {
                cabecera += "\t\"fmt\"\n";
            }
            cabecera += ")\n\n";
        }
        String traduccion = cabecera + "func main(){\n";
        if (this.listaInstrucciones != null) {
            for (Instruccion ins : this.listaInstrucciones) {
                traduccion += ins.traductorGolang(identacion + 1);
            }
            traduccion += "\n}\n";
        } else if (this.listaInstrucciones == null) {
            traduccion += "\n}\n";
        }
        return traduccion;
    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = "def main():\n";
        if (this.listaInstrucciones != null) {
            for (Instruccion ins : this.listaInstrucciones) {
                traduccion += ins.traductorPython(identacion + 1);
            }
        } else if (this.listaInstrucciones == null) {
            traduccion += "\tpass\n";
        }
        traduccion += "\nif __name__ == \'__main__\':\n" + OLC_Proyecto1_201900042.tabular(identacion + 1) + "main()\n";
        return traduccion;
    }

    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama("INICIO\nmain", "TERMINAL");
        NodoDiagrama fin = new NodoDiagrama("FIN\nmain", "TERMINAL");
        NodoDiagrama temp;
        if (this.listaInstrucciones != null) {
            for (int i = 0; i < this.listaInstrucciones.size(); i++) {
                if (this.listaInstrucciones.get(i).Diagrama().getTipo().equals("ENTRADA/SALIDA")) {
                    if (i != this.listaInstrucciones.size() - 1) {
                        temp = this.listaInstrucciones.get(i).Diagrama();
                        temp.agregarHijos(this.listaInstrucciones.get(i + 1).Diagrama());
                    }
                } else if (this.listaInstrucciones.get(i).Diagrama().getTipo().equals("SALIDA")) {
                    if (i != this.listaInstrucciones.size() - 1) {
                        temp = this.listaInstrucciones.get(i).Diagrama();
                        temp.agregarHijos(this.listaInstrucciones.get(i + 1).Diagrama());
                    }
                } else if (this.listaInstrucciones.get(i).Diagrama().getTipo().equals("CICLO_DW")) {
                    if (i != this.listaInstrucciones.size() - 1) {
                        temp = this.listaInstrucciones.get(i).Diagrama();
                        temp.agregarHijosCondicion(this.listaInstrucciones.get(i + 1).Diagrama(),"NO");
                    }
                }
                System.out.println("YES");
            }
            if (this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama().getTipo().equals("ENTRADA/SALIDA")) {
                temp = this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama();
                temp.agregarHijos(fin);
                System.out.println("SI ENTRE :,V1");
            } else if (this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama().getTipo().equals("SALIDA")) {
                System.out.println(this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama().getValor());
                System.out.println("HIJOS: " + this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama().getHijos().size());
                temp = this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama();
                temp.agregarHijos(fin);
                System.out.println("HIJOS: " + this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama().getHijos().size());
                System.out.println("SI ENTRE :,V2");
            } else if (this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama().getTipo().equals("CICLO_DW")) {
                temp = this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama();
                temp.agregarHijosCondicion(fin,"NO");
                System.out.println("SI ENTRE :,V3");
            } else {
                temp = this.listaInstrucciones.get(this.listaInstrucciones.size() - 1).Diagrama();
                temp.agregarHijos(fin);
                System.out.println("SI ENTRE :,V4");
            }
            nuevo.agregarHijos(temp);
        } else if (this.listaInstrucciones == null) {
            nuevo.agregarHijos(new NodoDiagrama("FIN\nmain", "TERMINAL"));
        }
        return nuevo;
    }
}
