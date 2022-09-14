/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures;

import java.util.LinkedList;
import olc_proyecto1_201900042.OLC_Proyecto1_201900042;
/**
 *
 * @author Rodrigo
 */
public class Arbol {
    private Nodo raiz;
    
    public Arbol(){
    }
    public String codigo = "graph G {\nsplines=false;\n";
    public void graficarAST(Nodo nodo){
        graficarNodos(nodo); 
        codigo+= "\n}";
        System.out.println(codigo);
    }
    
    public void graficarNodos(Nodo nodo){
        //ASIGNAR ID
        if(nodo.getId()==0){
            nodo.setId(OLC_Proyecto1_201900042.id_sig);
            OLC_Proyecto1_201900042.id_sig++;
        }
        if (nodo.getTipo() == "CADENA") {
            codigo+= nodo.getId() + "[label=\"" + nodo.getValor().replace("\"", "\\\"") + "\" shape=\"circle\"];\n";
        } else {
            codigo+= nodo.getId() + "[label=\"" + nodo.getValor() + "\" shape=\"circle\"];\n";
        }
        for(Nodo hijo : nodo.getHijos()){
            codigo+= nodo.getId() + " -- " + OLC_Proyecto1_201900042.id_sig  + "[headport=n];\n";
            this.graficarNodos(hijo);
        }
    }
}
