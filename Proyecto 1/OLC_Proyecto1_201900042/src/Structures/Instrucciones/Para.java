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
public class Para implements Instruccion{
    private final Operacion identificador;
    
    private final Instruccion operadorinicial;
    
    private final Instruccion operadorfinal;
    
    private Instruccion incremental;

    private LinkedList<Instruccion> listaInstrucciones;

    //PARA VACIO
    public Para(Operacion identificador, Instruccion operadorinicial, Instruccion operadorfinal) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
    }
    //PARA CON INSTRUCCIONES
    public Para(Operacion identificador, Instruccion operadorinicial, Instruccion operadorfinal, LinkedList<Instruccion> listaInstrucciones) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
        this.listaInstrucciones = listaInstrucciones;
    }
    //PARA CON INSTRUCCIONES Y CON INCREMENTAL
    public Para(Operacion identificador, Instruccion operadorinicial, Instruccion operadorfinal, Instruccion incremental, LinkedList<Instruccion> listaInstrucciones) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
        this.incremental = incremental;
        this.listaInstrucciones = listaInstrucciones;
    }
    //PARA VACIO Y CON INCREMENTAL
    public Para(Operacion identificador, Instruccion operadorinicial, Instruccion operadorfinal, Instruccion incremental) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
        this.incremental = incremental;
    }
    
    
    
    @Override
    public String traductorGolang(int identacion) {
        String traductor = OLC_Proyecto1_201900042.tabular(identacion) + "for " + this.identificador.traductorGolang(identacion) + ":=" + this.operadorinicial.traductorGolang(identacion) + "; "+ this.identificador.traductorGolang(identacion) + " < " + this.operadorfinal.traductorGolang(identacion) + "; ";
        if (this.incremental == null) {
            traductor+= this.identificador.traductorGolang(identacion) + "++ {\n";
            if (this.listaInstrucciones!= null) {
                for (Instruccion ins: this.listaInstrucciones) {
                    traductor+= ins.traductorGolang(identacion+1);
                }
            }
            traductor+="\n"+OLC_Proyecto1_201900042.tabular(identacion)+"}\n";
        }else if (this.incremental != null) {
            traductor+= this.identificador.traductorGolang(identacion) + "=" + this.identificador.traductorGolang(identacion) + "+" + this.incremental.traductorGolang(identacion) + " {\n" ;
            if (this.listaInstrucciones!= null) {
                for (Instruccion ins: this.listaInstrucciones) {
                    traductor+= ins.traductorGolang(identacion+1);
                }
            }
            traductor+="\n"+OLC_Proyecto1_201900042.tabular(identacion)+"}\n";
        }else{
            traductor= "";
        }
        return traductor;
    }

    @Override
    public String traductorPython(int identacion) {
        String traductor =OLC_Proyecto1_201900042.tabular(identacion) + "for " + this.identificador.traductorPython(identacion) + " in range(" + this.operadorinicial.traductorPython(identacion) + ", " + this.operadorfinal.traductorPython(identacion);
        if (this.incremental == null) {
            traductor+= "):\n";
            if (this.listaInstrucciones!= null) {
                for (Instruccion ins: this.listaInstrucciones) {
                    traductor+= ins.traductorPython(identacion+1);
                }
            }else{
                traductor+= OLC_Proyecto1_201900042.tabular(identacion)  + "pass\n";
            }
            traductor+="\n";
        }else if (this.incremental != null) {
            traductor+= ", " + this.incremental.traductorPython(identacion) + "):\n" ;
            if (this.listaInstrucciones!= null) {
                for (Instruccion ins: this.listaInstrucciones) {
                    traductor+= ins.traductorPython(identacion+1);
                }
            }else{
                traductor+= OLC_Proyecto1_201900042.tabular(identacion)  + "\n";
            }
            traductor+="\n";
        }else{
            traductor= "";
        }
        return traductor;
    }

    @Override
    public NodoDiagrama Diagrama() {
         NodoDiagrama nuevo;
        if (this.incremental == null) {
            nuevo = new NodoDiagrama("Desde: " + this.identificador.traductorGolang(0) + " = " + this.operadorinicial.traductorGolang(0) + ";\nHasta: " + this.operadorfinal.traductorGolang(0) + "\nIncremento: 1" ,"CONDICION");
        }else{
            nuevo = new NodoDiagrama("Desde: " + this.identificador.traductorGolang(0) + " = " + this.operadorinicial.traductorGolang(0) + ";\nHasta: " + this.operadorfinal.traductorGolang(0) + "\nIncremento: " + this.incremental.traductorPython(0) ,"CONDICION");
        }
        if(this.listaInstrucciones != null){
            nuevo.agregarHijosCondicion(this.listaInstrucciones.get(0).Diagrama(), "SI");
        }
        return nuevo;
    }
    
}
