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
public class Ejecutar implements Instruccion{
    public static enum Tipo_Variable{
        EJECUTAR,
        EXPRESION
    }
    private final Operacion identificador;
    private final Tipo_Variable tipo;
    private LinkedList<Instruccion> listaParametros;

    public Ejecutar(Operacion identificador, Tipo_Variable tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public Ejecutar(Operacion identificador, Tipo_Variable tipo, LinkedList<Instruccion> listaParametros) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.listaParametros = listaParametros;
    }
    
    @Override
    public String traductorGolang(int identacion) {
        if (this.tipo == Tipo_Variable.EJECUTAR) {
            String traduccion = OLC_Proyecto1_201900042.tabular(identacion);
            if (this.listaParametros == null) {
                traduccion += this.identificador.traductorGolang(identacion) + "()\n";
            } else if (this.listaParametros != null) {
                traduccion += this.identificador.traductorGolang(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if (i == this.listaParametros.size() - 1) {
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                        break;
                    }
                    traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                }
                traduccion += ")\n";
            }
            return traduccion;
        }else if(this.tipo == Tipo_Variable.EXPRESION){
            String traduccion = "";
            if (this.listaParametros == null) {
                traduccion += this.identificador.traductorGolang(identacion) + "()";
            } else if (this.listaParametros != null) {
                traduccion += this.identificador.traductorGolang(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if (i == this.listaParametros.size() - 1) {
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                        break;
                    }
                    traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                }
                traduccion += ")";
            }
            return traduccion;
        }else{
            return "";
        }
    }
    
    @Override
    public String traductorPython(int identacion) {
        if (this.tipo == Tipo_Variable.EJECUTAR) {
            String traduccion = OLC_Proyecto1_201900042.tabular(identacion);
            if (this.listaParametros == null) {
                traduccion += this.identificador.traductorPython(identacion) + "()\n";
            } else if (this.listaParametros != null) {
                traduccion += this.identificador.traductorPython(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if (i == this.listaParametros.size() - 1) {
                        traduccion += this.listaParametros.get(i).traductorPython(identacion);
                        break;
                    }
                    traduccion += this.listaParametros.get(i).traductorPython(identacion) + ",";
                }
                traduccion += ")\n";
            }
            return traduccion;
        }else if(this.tipo == Tipo_Variable.EXPRESION){
            String traduccion = "";
            if (this.listaParametros == null) {
                traduccion += this.identificador.traductorPython(identacion) + "()";
            } else if (this.listaParametros != null) {
                traduccion += this.identificador.traductorPython(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if (i == this.listaParametros.size() - 1) {
                        traduccion += this.listaParametros.get(i).traductorPython(identacion);
                        break;
                    }
                    traduccion += this.listaParametros.get(i).traductorPython(identacion) + ",";
                }
                traduccion += ")";
            }
            return traduccion;
        }else{
            return "";
        }
    }
    
    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo;
        if (this.listaParametros == null) {
            nuevo = new NodoDiagrama("llamar al algoritmo"  + this.identificador.traductorGolang(0),"PROCESO");
            return nuevo;
        } else if (this.listaParametros != null) {
            String params = "";
            for (int i = 0; i < this.listaParametros.size(); i++) {
                if (i == this.listaParametros.size() - 1) {
                    params += this.listaParametros.get(i).traductorGolang(0);
                    break;
                }
                params += this.listaParametros.get(i).traductorGolang(0) + ",";
            }
            nuevo = new NodoDiagrama("llamar al algoritmo"  + this.identificador.traductorGolang(0) + "\ncon parametros:\n" + params,"PROCESO");
            return nuevo;
        }
        return null;
    }
}
