/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures;

import Clases.ErrorLenguaje;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class ReporteErrores {
    private final LinkedList<ErrorLenguaje> erroreslexicos;
    private final LinkedList<ErrorLenguaje> erroressintacticos;
    StringBuilder textohtml = new StringBuilder();

    public ReporteErrores(LinkedList<ErrorLenguaje> erroreslexicos, LinkedList<ErrorLenguaje> erroressintacticos) {
        this.erroreslexicos = erroreslexicos;
        this.erroressintacticos = erroressintacticos;
    }

    public void inicioHTML(){
        textohtml.append("<!doctype html>\n" +
"<html lang=\"en\">\n" +
"  <head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
"    <link rel=\"shortcut icon\" href=\"./Imagenes/logodev.png\">\n" +
"    <title>Reporte de Errores</title>\n" +
"  </head>\n" +
"  <body>\n" +
"    <div class=\"p-3 mb-2 text-white\" style=\"background-color:#636363;\">\n" +
"        <h1><center>PS-Traductor</center></h1>\n" +
"    </div>\n" +
"    <div class=\"p-3 mb-2 text-white\" style=\"background-color:#c51212\">\n" +
"        <h1><center>Reporte de Errores</center></h1>\n" +
"    </div>");
    }
    
    public void tabla_Errores(){
        textohtml.append("<table class=\"table table-dark table-hover table-bordered\">\n" +
"  <thead>\n" +
"    <tr>\n" +
"      <th scope=\"col\">#</th>\n" +
"      <th scope=\"col\">Tipo de Error</th>\n" +
"      <th scope=\"col\">Descripcion</th>\n" +
"      <th scope=\"col\">Linea</th>\n" +
"      <th scope=\"col\">Columna</th>\n" +
"    </tr>\n" +
"  </thead>\n" +
"  <tbody>");
        int contador = 1;
        for (int i = 0; i < this.erroreslexicos.size(); i++) {
            textohtml.append("<tr class=\"table-danger\">\n" +
"      <th scope=\"row\">" + contador +"</th>\n" +
"      <th>" + this.erroreslexicos.get(i).getTipo() + "</th>\n" +
"      <th>" + this.erroreslexicos.get(i).getDescripcion() + "</th>\n" +
"      <th>" + this.erroreslexicos.get(i).getLinea() + "</th>\n" +
"      <th>" + this.erroreslexicos.get(i).getColumna() + "</th>\n" +
"    </tr>");
            contador++;
        }
        for (int i = 0; i < this.erroressintacticos.size(); i++) {
            textohtml.append("<tr class=\"table-danger\">\n" +
"      <th scope=\"row\">" + contador +"</th>\n" +
"      <th>" + this.erroressintacticos.get(i).getTipo() + "</th>\n" +
"      <th>" + this.erroressintacticos.get(i).getDescripcion() + "</th>\n" +
"      <th>" + this.erroressintacticos.get(i).getLinea() + "</th>\n" +
"      <th>" + this.erroressintacticos.get(i).getColumna() + "</th>\n" +
"    </tr>");
            contador++;
        }
        textohtml.append("</tbody>\n" +
"</table>");
    }
    
    public void generarReporte(){
        inicioHTML();
        tabla_Errores();
        crearReporte();
        abrirReporte();
    }
    public void crearReporte(){
        File reporte1 = new File("Reporte_Errores.html");
        try{
            FileWriter escribir = new FileWriter(reporte1);
            escribir.write(textohtml.toString());
            escribir.close();
            JOptionPane.showMessageDialog(null, "Reporte generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void abrirReporte(){
        try
        {
            File file = new File("Reporte_Errores.html");
            if(!Desktop.isDesktopSupported())
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists())
                desktop.open(file);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
