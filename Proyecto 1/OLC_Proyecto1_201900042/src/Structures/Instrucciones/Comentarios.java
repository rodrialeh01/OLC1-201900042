/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

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
    public String traductorGolang() {
        if(tipo==Tipo_Comentario.COMENTARIO_UNILINEA){
            System.out.println("uni");
            System.out.println(this.comentario);
            return this.comentario.toString();
        }else if(tipo==Tipo_Comentario.COMENTARIO_MILTILINEA){
            System.out.println("multi");
            System.out.println(this.comentario);
            return this.comentario.toString();
            
        }else{
            return "";
        }
    }
    
}
