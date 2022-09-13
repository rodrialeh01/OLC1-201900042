/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

import olc_proyecto1_201900042.OLC_Proyecto1_201900042;

/**
 *
 * @author Rodrigo
 */
public class Comentarios implements Instruccion{
    public static enum Tipo_Comentario{
        COMENTARIO_UNILINEA,
        COMENTARIO_MILTILINEA
    }
    private final Tipo_Comentario tipo;
    private String comentario;
    public Comentarios(Tipo_Comentario tipo, String comentario) {
        this.tipo = tipo;
        this.comentario = comentario;
    }
    
    

    
    @Override
    public String traductorGolang(int identacion) {
        if(tipo==Tipo_Comentario.COMENTARIO_UNILINEA){
            System.out.println(this.comentario);
            return this.comentario.toString() + "\n";
        }else if(tipo==Tipo_Comentario.COMENTARIO_MILTILINEA){
            System.out.println("multi");
            System.out.println(this.comentario);
            return this.comentario.toString() + "\n";
        }else{
            return "";
        }
    }
    
    @Override
    public String traductorPython(int identacion) {
        String traductor = OLC_Proyecto1_201900042.tabular(identacion);
        String comentario = this.comentario.toString();
        if(tipo==Tipo_Comentario.COMENTARIO_UNILINEA){
            comentario = comentario.substring(0,0) + comentario.substring(1);
            comentario = comentario.substring(0,0) + comentario.substring(1);
            return traductor + "#" + comentario + "\n";
        }else if(tipo==Tipo_Comentario.COMENTARIO_MILTILINEA){
            comentario = comentario.substring(0,0) + comentario.substring(1);
            comentario = comentario.substring(0,0) + comentario.substring(1);
            comentario = comentario.substring(0,comentario.length()-2) + comentario.substring(traductor.length());
            return traductor + "\'\'\'\n"+ comentario + "\n"+ traductor +"\'\'\'\n";
        }else{
            return "";
        }
    }
}
