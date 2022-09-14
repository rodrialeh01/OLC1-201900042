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

    public void graficarAST(Nodo nodo){
        String codigo = "";
        //ASIGNAR ID
        if(nodo.getId()==0){
            nodo.setId(OLC_Proyecto1_201900042.id_sig);
            OLC_Proyecto1_201900042.id_sig++;
        }
        if (nodo.getTipo() == "CADENA") {
            System.out.println(nodo.getId() + "[label=" + nodo.getValor() + " shape=\"circle\"];");
        } else {
            System.out.println(nodo.getId() + "[label=\"" + nodo.getValor() + "\" shape=\"circle\"];");
        }
        for(Nodo hijo : nodo.getHijos()){
            System.out.println(nodo.getId() + "->" + OLC_Proyecto1_201900042.id_sig + ";");
            this.graficarAST(hijo);
        }
    }
    
}
