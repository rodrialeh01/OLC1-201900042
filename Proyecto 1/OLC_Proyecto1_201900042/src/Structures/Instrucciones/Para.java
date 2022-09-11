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
public class Para implements Instruccion{
    private final Operacion identificador;
    
    private final Operacion operadorinicial;
    
    private final Operacion operadorfinal;
    
    private Operacion incremental;

    private LinkedList<Instruccion> listaInstrucciones;

    //PARA VACIO
    public Para(Operacion identificador, Operacion operadorinicial, Operacion operadorfinal) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
    }
    //PARA CON INSTRUCCIONES
    public Para(Operacion identificador, Operacion operadorinicial, Operacion operadorfinal, LinkedList<Instruccion> listaInstrucciones) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
        this.listaInstrucciones = listaInstrucciones;
    }
    //PARA CON INSTRUCCIONES Y CON INCREMENTAL
    public Para(Operacion identificador, Operacion operadorinicial, Operacion operadorfinal, Operacion incremental, LinkedList<Instruccion> listaInstrucciones) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
        this.incremental = incremental;
        this.listaInstrucciones = listaInstrucciones;
    }
    //PARA VACIO Y CON INCREMENTAL
    public Para(Operacion identificador, Operacion operadorinicial, Operacion operadorfinal, Operacion incremental) {
        this.identificador = identificador;
        this.operadorinicial = operadorinicial;
        this.operadorfinal = operadorfinal;
        this.incremental = incremental;
    }
    
    
    
    @Override
    public String traductorGolang() {
        String traductor = "for " + this.identificador.traductorGolang() + ":=" + this.operadorinicial.traductorGolang() + "; "+ this.identificador.traductorGolang() + " < " + this.operadorfinal.traductorGolang() + "; ";
        if (this.incremental == null) {
            traductor+= this.identificador.traductorGolang() + "++ {\n";
            if (this.listaInstrucciones!= null) {
                for (Instruccion ins: this.listaInstrucciones) {
                    traductor+= OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador+=1) + ins.traductorGolang();
                }
            }
            traductor+="\n}\n";
        }else if (this.incremental != null) {
            traductor+= this.identificador.traductorGolang() + "=" + this.identificador.traductorGolang() + "+" + this.incremental.traductorGolang() + " {\n" ;
            if (this.listaInstrucciones!= null) {
                for (Instruccion ins: this.listaInstrucciones) {
                    traductor+= OLC_Proyecto1_201900042.tabular(OLC_Proyecto1_201900042.contador+=1) + ins.traductorGolang();
                }
            }
            traductor+="\n}\n";
        }else{
            traductor= "";
        }
        return traductor;
    }
    
}
