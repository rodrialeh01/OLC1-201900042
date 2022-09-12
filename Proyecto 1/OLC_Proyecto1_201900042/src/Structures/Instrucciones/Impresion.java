/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

/**
 *
 * @author Rodrigo
 */
public class Impresion implements Instruccion{

    private final Tipo_Impresion tipo;

    public static enum Tipo_Impresion{
        CON_SALTO,
        SIN_SALTO
    }
    private Instruccion condicion;

    public Impresion(Tipo_Impresion tipo,Instruccion condicion) {
        this.tipo = tipo;
        this.condicion = condicion;
    }
    
    @Override
    public String traductorGolang() {
        String traduccion = "";
        if(this.tipo == Tipo_Impresion.SIN_SALTO){
            traduccion+= "fmt.Print(" + this.condicion.traductorGolang() + ")\n";
        }else if(this.tipo == Tipo_Impresion.CON_SALTO){
            traduccion+= "fmt.Println(" + this.condicion.traductorGolang() + ")\n";
        }else{
            traduccion="";
        }
        return traduccion;
    }
    
}
