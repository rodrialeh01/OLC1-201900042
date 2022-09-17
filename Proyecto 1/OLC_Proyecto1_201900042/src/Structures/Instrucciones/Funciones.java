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
public class Funciones implements Instruccion {
    private final Operacion identificador;
    private final Parametro.Tipo_Variable tipo;
    private LinkedList<Instruccion> listaParametros;
    private LinkedList<Instruccion> instrucciones;
    private Retornar valor_retorno;

    public Funciones(Operacion identificador, Parametro.Tipo_Variable tipo, LinkedList<Instruccion> listaParametros, LinkedList<Instruccion> instrucciones, Retornar valor_retorno) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.listaParametros = listaParametros;
        this.instrucciones = instrucciones;
        this.valor_retorno = valor_retorno;
    }

    public Funciones(Operacion identificador, Parametro.Tipo_Variable tipo, LinkedList<Instruccion> listaParametros, Retornar valor_retorno) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.listaParametros = listaParametros;
        this.valor_retorno = valor_retorno;
    }

    public Funciones(Operacion identificador, Parametro.Tipo_Variable tipo, Retornar valor_retorno, LinkedList<Instruccion> instrucciones) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.instrucciones = instrucciones;
        this.valor_retorno = valor_retorno;
    }

    public Funciones(Operacion identificador, Parametro.Tipo_Variable tipo, Retornar valor_retorno) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.valor_retorno = valor_retorno;
    }

    @Override
    public String traductorGolang(int identacion) {
        String traduccion = "func ";
        if (tipo == Parametro.Tipo_Variable.NUMERO) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() float64{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") float64{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() float64{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") float64{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
            }
        } else if (tipo == Parametro.Tipo_Variable.CADENA) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() string{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") string{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() string{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") string{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
            }
        } else if (tipo == Parametro.Tipo_Variable.BOOLEAN) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() bool{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") bool{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() bool{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") bool{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
            }
        } else if (tipo == Parametro.Tipo_Variable.CARACTER) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() byte{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") byte{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += ins.traductorGolang(identacion+1);
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "() byte{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang(identacion) + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang(identacion);
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang(identacion) + ",";
                    }
                    traduccion += ") byte{\n\t" + this.valor_retorno.traductorGolang(identacion);
                    traduccion += "}\n";
                }
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
                traduccion += "\n" + this.valor_retorno.traductorPython(identacion+1);
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
                traduccion += "\n"+ this.valor_retorno.traductorPython(identacion+1);
            } 
        }else if(this.instrucciones ==  null){
            if (this.listaParametros == null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "():\n" + this.valor_retorno.traductorPython(identacion+1);
            } else if (this.listaParametros != null) {
                traduccion += "def " + this.identificador.traductorPython(identacion) + "(";
                for (int i = 0; i < this.listaParametros.size(); i++) {
                    if(i == this.listaParametros.size()-1){
                        traduccion+= this.listaParametros.get(i).traductorPython(identacion);
                        break;
                    }
                    traduccion+= this.listaParametros.get(i).traductorPython(identacion) + ",";
                }
                traduccion += "):\n" + this.valor_retorno.traductorPython(identacion+1);
            } 
        }
        return traduccion;
    }

    @Override
    public NodoDiagrama Diagrama() {
        NodoDiagrama nuevo = new NodoDiagrama("INICIO\nfuncion:" + this.identificador.traductorGolang(0),"TERMINAL");
        if(this.listaParametros == null){
            if(this.instrucciones!= null){
                nuevo.agregarHijos(this.instrucciones.get(0).Diagrama());
                for (int i = 0; i < this.instrucciones.size(); i++) {
                    if(this.instrucciones.get(i).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            this.instrucciones.get(i).Diagrama().agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            this.instrucciones.get(i).Diagrama().agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("CICLO_DW")){
                        if(i != this.instrucciones.size()-1){
                            this.instrucciones.get(i).Diagrama().agregarHijosCondicion(this.instrucciones.get(i+1).Diagrama(), "NO");
                        }
                    }
                }
                if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijos(this.valor_retorno.Diagrama());
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("SALIDA")){
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijos(this.valor_retorno.Diagrama());
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("CICLO_DW")){
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijosCondicion(this.valor_retorno.Diagrama(),"NO");
                }else{
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijos(this.valor_retorno.Diagrama());
                }
                this.valor_retorno.Diagrama().agregarHijos(new NodoDiagrama("FIN\nfuncion","TERMINAL"));
            }else{
                nuevo.agregarHijos(this.valor_retorno.Diagrama());
                this.valor_retorno.Diagrama().agregarHijos(new NodoDiagrama("FIN\nfuncion","TERMINAL"));
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
                nuevo2.agregarHijos(this.instrucciones.get(0).Diagrama());
                for (int i = 0; i < this.instrucciones.size(); i++) {
                    if(this.instrucciones.get(i).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            this.instrucciones.get(i).Diagrama().agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("SALIDA")){
                        if(i != this.instrucciones.size()-1){
                            this.instrucciones.get(i).Diagrama().agregarHijos(this.instrucciones.get(i+1).Diagrama());
                        }
                    }else if(this.instrucciones.get(i).Diagrama().getTipo().equals("CICLO_DW")){
                        if(i != this.instrucciones.size()-1){
                            this.instrucciones.get(i).Diagrama().agregarHijosCondicion(this.instrucciones.get(i+1).Diagrama(), "NO");
                        }
                    }
                }
                
                if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("ENTRADA/SALIDA")){
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijos(this.valor_retorno.Diagrama());
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("SALIDA")){
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijos(this.valor_retorno.Diagrama());
                }else if(this.instrucciones.get(this.instrucciones.size()-1).Diagrama().getTipo().equals("CICLO_DW")){
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijosCondicion(this.valor_retorno.Diagrama(),"NO");
                }else{
                    this.instrucciones.get(this.instrucciones.size()-1).Diagrama().agregarHijos(this.valor_retorno.Diagrama());
                }
                this.valor_retorno.Diagrama().agregarHijos(new NodoDiagrama("FIN\nfuncion","TERMINAL"));
            }else{
                nuevo.agregarHijos(this.valor_retorno.Diagrama());
                this.valor_retorno.Diagrama().agregarHijos(new NodoDiagrama("FIN\nfuncion","TERMINAL"));
            }
        }
        return nuevo;
    }

}
