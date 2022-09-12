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
    public String traductorGolang() {
        String traduccion = "func ";
        if (tipo == Parametro.Tipo_Variable.NUMERO) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() float64{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") float64{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() float64{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") float64{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }
        } else if (tipo == Parametro.Tipo_Variable.CADENA) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() string{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") string{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() string{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") string{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }
        } else if (tipo == Parametro.Tipo_Variable.BOOLEAN) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() bool{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") bool{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() bool{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") bool{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }
        } else if (tipo == Parametro.Tipo_Variable.CARACTER) {
            if (this.instrucciones != null) {
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() byte{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") byte{\n";
                    for (Instruccion ins : this.instrucciones) {
                        traduccion += OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador += 1) + ins.traductorGolang();
                    }
                    traduccion += "\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }else if(this.instrucciones == null){
                if (this.listaParametros == null) {
                    traduccion += this.identificador.traductorGolang() + "() byte{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                } else if (this.listaParametros != null) {
                    traduccion += this.identificador.traductorGolang() + "(";
                    for (int i = 0; i < this.listaParametros.size(); i++) {
                        if (i == this.listaParametros.size() - 1) {
                            traduccion += this.listaParametros.get(i).traductorGolang();
                            break;
                        }
                        traduccion += this.listaParametros.get(i).traductorGolang() + ",";
                    }
                    traduccion += ") byte{\n\t" + this.valor_retorno.traductorGolang();
                    traduccion += "}\n";
                }
            }
        }
        return traduccion;
    }

}
