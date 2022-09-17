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
public class Metodo implements Instruccion {
    private final Operacion identificador;
    private LinkedList<Instruccion> listaParametros;
    private LinkedList<Instruccion> instrucciones;

    public Metodo(Operacion identificador, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> instrucciones) {
        this.identificador = identificador;
        this.listaParametros = listaParametros;
        this.instrucciones = instrucciones;
    }

    public Metodo(Operacion identificador, LinkedList<Instruccion> listaParametros) {
        this.identificador = identificador;
        this.listaParametros = listaParametros;
    }

    public Metodo(LinkedList<Instruccion> instrucciones, Operacion identificador) {
        this.identificador = identificador;
        this.instrucciones = instrucciones;
    }

    public Metodo(Operacion identificador) {
        this.identificador = identificador;
    }
    

    @Override
    public String traductorGolang(int identacion) {
        String traduccion = "";
        if (this.instrucciones != null) {
            if (this.listaParametros == null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(){\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorGolang(identacion+1);
                }
                traduccion += "\n}\n";
            } else if (this.listaParametros != null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorGolang(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorGolang(identacion) + ",";
                }
                traduccion += "){\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorGolang(identacion+1);
                }
                traduccion += "\n}\n";
            } 
        }else if(this.instrucciones ==  null){
            if (this.listaParametros == null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(){\n}\n";
            } else if (this.listaParametros != null) {
                traduccion += "func " + this.identificador.traductorGolang(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorGolang(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorGolang(identacion) + ",";
                }
                traduccion += "){\n}\n";
            } 
        }
        return traduccion;

    }

    @Override
    public String traductorPython(int identacion) {
        String traduccion = "";
        if (this.instrucciones != null) {
            if (this.listaParametros == null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "():\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorPython(identacion+1);
                }
                traduccion += "\n";
            } else if (this.listaParametros != null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorPython(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorPython(identacion) + ",";
                }
                traduccion += "):\n";
                for (Instruccion ins : this.instrucciones) {
                    traduccion += ins.traductorPython(identacion+1);
                }
                traduccion += "\n";
            } 
        }else if(this.instrucciones ==  null){
            if (this.listaParametros == null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "():\n\tpass\n";
            } else if (this.listaParametros != null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorPython(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorPython(identacion) + ",";
                }
                traduccion += "):\n\tpass\n";
            } 
        }
        return traduccion;
    }

    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama("INICIO\nmetodo:" + this.identificador.traductorGolang(0),"TERMINAL");
        NodoDiagrama temp;
        if(this.listaParametros == null){
            if(this.instrucciones!= null){
                for (int i = 0; i < this.instrucciones.size(); i++) {
                    if(this.instrucciones.get(i).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            temp = this.instrucciones.get(i).Diagrama();
                            temp.agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            temp = this.instrucciones.get(i).Diagrama();
                            temp.agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("CICLO_DW")){
                        if(i != this.instrucciones.size()-1){
                            temp = this.instrucciones.get(i).Diagrama();
                            temp.agregarHijosCondicion(this.instrucciones.get(i+1).Diagrama(),"NO");
                        }
                    }
                }
                if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("SALIDA")){
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("CICLO_DW")){
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijosCondicion(new NodoDiagrama("FIN\nmetodo","TERMINAL"),"NO");
                }else{
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
                }
                nuevo.agregarHijos(temp);
            }else{
                nuevo.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
            }
        }else{
            String variables="";
            for (int i = 0; i < this.listaParametros.size(); i++) {
                if(i == this.listaParametros.size()-1){
                    variables+= this.listaParametros.get(i).traductorGolang(0);
                    break;
                }
                variables+= this.listaParametros.get(i).traductorGolang(0) + ",";
            }
            NodoDiagrama nuevo2 = new NodoDiagrama(variables,"ENTRADA/SALIDA");
            nuevo.agregarHijos(nuevo2);
            if(this.instrucciones!= null){
                for (int i = 0; i < this.instrucciones.size(); i++) {
                    if(this.instrucciones.get(i).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            temp = this.instrucciones.get(i).Diagrama();
                            temp.agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            temp = this.instrucciones.get(i).Diagrama();
                            temp.agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("CICLO_DW")){
                        if(i != this.instrucciones.size()-1){
                            temp = this.instrucciones.get(i).Diagrama();
                            temp.agregarHijosCondicion(this.instrucciones.get(i+1).Diagrama(),"NO");
                        }
                    }
                }
                if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("SALIDA")){
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("CICLO_DW")){
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijosCondicion(new NodoDiagrama("FIN\nmetodo","TERMINAL"),"NO");
                }else{
                    temp = this.instrucciones.get(this.instrucciones.size()-1).Diagrama();
                    temp.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
                }
                nuevo2.agregarHijos(temp);
            }else{
                nuevo2.agregarHijos(new NodoDiagrama("FIN\nmetodo","TERMINAL"));
            }
        }
        return nuevo;
    }

}
