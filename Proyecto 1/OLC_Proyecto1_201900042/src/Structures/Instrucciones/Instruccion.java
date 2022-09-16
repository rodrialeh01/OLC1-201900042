/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Structures.Instrucciones;

import Structures.NodoDiagrama;

/**
 *
 * @author Rodrigo
 */
public interface Instruccion {
    public String traductorGolang(int identacion);
    public String traductorPython(int identacion);
    public NodoDiagrama Diagrama();
}
