/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures.Instrucciones;

/**
 *
 * @author Rodrigo
 */
public class Operacion implements Instruccion{
    public static enum Tipo_operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        NUMERO,
        NEGATIVO,
        MODULAR,
        POTENCIA,
        CADENA,
        DECIMAL,
        BOOLEANO,
        CARACTER,
        IDENTIFICADOR,
        MAYORQUE,
        MENORQUE,
        IGUAL,
        DIFERENTE,
        MAYOROIGUAL,
        MENOROIGUAL,
        AND,
        OR,
        NOT
    }
    
    private final Tipo_operacion tipo;
    
    private Operacion operadorizq;
    
    private Operacion operadorder;
    
    private Object valor;

    public Operacion(Tipo_operacion tipo, Operacion operadorizq, Operacion operadorder) {
        this.tipo = tipo;
        this.operadorizq = operadorizq;
        this.operadorder = operadorder;
    }

    public Operacion(Tipo_operacion tipo, Operacion operadorizq) {
        this.tipo = tipo;
        this.operadorizq = operadorizq;
    }

    public Operacion(Tipo_operacion tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    
    
    @Override
    public String traductorGolang() {
        //OPERADORES ARITMETICOS
        if(tipo == Tipo_operacion.DIVISION){
            return operadorizq.traductorGolang() + "/" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.MULTIPLICACION){
            return operadorizq.traductorGolang() + "*" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.SUMA){
            return operadorizq.traductorGolang() + "+" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.RESTA){
            return operadorizq.traductorGolang() + "-" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.NEGATIVO){
            return "-" + operadorizq.traductorGolang();
        }else if(tipo == Tipo_operacion.MODULAR){
            return operadorizq.traductorGolang() + "%" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.POTENCIA){
            return "math.Pow(float64(" + operadorizq.traductorGolang() + "),float64(" + operadorder.traductorGolang() + "))";
        }
        //EXPRESIONES LITERALES
        else if(tipo == Tipo_operacion.NUMERO){
            return valor.toString();
        }else if(tipo == Tipo_operacion.DECIMAL){
            return valor.toString();
        }else if(tipo == Tipo_operacion.CADENA){
            return valor.toString();
        }else if(tipo == Tipo_operacion.BOOLEANO){
            return valor.toString();
        }else if(tipo == Tipo_operacion.CARACTER){
            return valor.toString();
        }else if(tipo == Tipo_operacion.IDENTIFICADOR){
            return valor.toString();
        }
        //OPERADORES RELACIONALES
        else if(tipo == Tipo_operacion.MAYORQUE){
            return operadorizq.traductorGolang() + ">" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.MENORQUE){
            return operadorizq.traductorGolang() + "<" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.MAYOROIGUAL){
            return operadorizq.traductorGolang() + ">=" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.MENOROIGUAL){
            return operadorizq.traductorGolang() + "<=" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.IGUAL){
            return operadorizq.traductorGolang() + "==" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.DIFERENTE){
            return operadorizq.traductorGolang() + "!=" + operadorder.traductorGolang();
        }
        //OPERADORES LOGICOS
        else if(tipo == Tipo_operacion.AND){
            return operadorizq.traductorGolang() + "&&" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.OR){
            return operadorizq.traductorGolang() + "||" + operadorder.traductorGolang();
        }else if(tipo == Tipo_operacion.NOT){
            return operadorizq.traductorGolang() + "!" + operadorder.traductorGolang();
        }else{
            return "";
        }
    }
        
}