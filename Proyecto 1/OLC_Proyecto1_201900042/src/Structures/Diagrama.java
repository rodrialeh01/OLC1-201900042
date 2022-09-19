/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import olc_proyecto1_201900042.OLC_Proyecto1_201900042;

/**
 *
 * @author Rodrigo
 */
public class Diagrama {

    public Diagrama() {
    }
    public String codigo = "";
    public String graficarDiagrama(NodoDiagrama nodo){
        graficarNodos(nodo);
        return codigo;
    }
    public void graficarNodos(NodoDiagrama nodo){
        if(nodo != null){
            //ASIGNAR ID
            if (nodo.getId() == 0) {
                nodo.setId(OLC_Proyecto1_201900042.is_diag);
                OLC_Proyecto1_201900042.is_diag++;
            }
            
            switch(nodo.getTipo()){
                case "TERMINAL":
                    codigo += nodo.getId() + "[shape=\"ellipse\", label=\""+nodo.getValor().replace("\"", "\\\"")+"\"];\n";
                    break;
                case "ENTRADA/SALIDA":
                    codigo+= nodo.getId() + "[shape=\"parallelogram\", label=\""+nodo.getValor().replace("\"", "\\\"")+"\"];\n";
                    break;
                case "PROCESO":
                    codigo+= nodo.getId() + "[shape=\"rectangle\", label=\""+nodo.getValor().replace("\"", "\\\"")+"\"];\n";
                    break;
                case "CONDICION":
                    codigo+= nodo.getId() + "[shape=\"diamond\", label=\""+nodo.getValor().replace("\"", "\\\"")+"\"];\n";
                    break;
                case "SALIDA":
                    codigo+= nodo.getId() + "[shape=\"parallelogram\", label=\""+nodo.getValor().replace("\"", "\\\"")+"\"];\n";
                    break;
                case "CICLO_DW":
                    codigo+= nodo.getId() + "[shape=\"diamond\", label=\""+nodo.getValor().replace("\"", "\\\"")+"\"];\n";
                    break;
                case "CICLO_W":
                    codigo+= nodo.getId() + "[shape=\"diamond\", label=\""+nodo.getValor().replace("\"", "\\\"")+"\"];\n";
                    break;
            }
            System.out.println("CANT NODOS HIJOS: " + nodo.getHijos().size());
            for (NodoDiagrama hijo : nodo.getHijos()) {
                if(nodo.getCondicion().equals("")){
                    codigo += nodo.getId() + " -> " + OLC_Proyecto1_201900042.is_diag + ";\n";
                }else{
                    codigo += nodo.getId() + " -> " + OLC_Proyecto1_201900042.is_diag + "[label=\""+nodo.getCondicion()+"\"];\n";
                }
                this.graficarNodos(hijo);
            }
        }
        
    }
    public void abrirDiagrama(){
        try
        {
            File file = new File("./Reportes/Diagrama.pdf");
            if(!Desktop.isDesktopSupported())
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists())
                desktop.open(file);
                System.out.println("XD");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
