/*------------------------- Codigo de Usuario --------------------------------*/
//------------>Paquetes, importaciones
package analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;
import Clases.Error;

/*------------------------- Opciones y Declaraciones ------------------------*/

%%
%{
    //CODIGO DE JAVA
    public LinkedList<Error> ErroresLexicos = new LinkedList<Error>();
%}

//Directivas
%public
%class Analizador_Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//------------------------EXPRESIONES REGULARES------------------------------

BLANCOS=[ \r\t]+
DIGITO=[0-9]+
DECIMAL=[0-9]+("."[0-9]+)?
CADENA=[\"](((\\\')|(\\\")|(\\n))|[^\\\"\n])*[\"]
COMENTARIOL=("//".*\r\n*)|("//".*\n*)|("//".*\r\n*)|(\/\/(.*)*)
COMENTARIOML=("/""*"([^"*"]*)"*""/")
IDENTIFICADOR=("_"([A-Za-z0-9])+"_")
CARACTER=("'"([A-Za-zñÑ])"'")
CARASCCI=("'${"(((6[5-9])|([7-8][0-9])|(90))|((9[7-9])|(1[0-1][0-9])|(12[0-2]))|(164)|(165)|(32))"}'")

%%

/*------------------------- Reglas Lexicas --------------------------------*/

//PALABRAS RESERVADAS
<YYINITIAL> "mayor"             {return new Symbol(Simbolos.RMAYOR,yyline,yychar,yytext());}
<YYINITIAL> "menor"             {return new Symbol(Simbolos.RMENOR,yyline,yychar,yytext());}
<YYINITIAL> "mayor_o_igual"     {return new Symbol(Simbolos.RMAYOROIGUAL,yyline,yychar,yytext());}
<YYINITIAL> "menor_o_igual"     {return new Symbol(Simbolos.RMENOROIGUAL,yyline,yychar,yytext());}
<YYINITIAL> "es_igual"          {return new Symbol(Simbolos.RESIGUAL,yyline,yychar,yytext());}
<YYINITIAL> "es_diferente"      {return new Symbol(Simbolos.RESDIFERENTE,yyline,yychar,yytext());}
<YYINITIAL> "or"                {return new Symbol(Simbolos.ROR,yyline,yychar,yytext());}
<YYINITIAL> "and"               {return new Symbol(Simbolos.RAND,yyline,yychar,yytext());}
<YYINITIAL> "not"               {return new Symbol(Simbolos.RNOT,yyline,yychar,yytext());}
<YYINITIAL> "verdadero"         {return new Symbol(Simbolos.RVERDADERO,yycolumn,yychar,yytext());}
<YYINITIAL> "falso"             {return new Symbol(Simbolos.RFALSO,yyline,yychar,yytext());}
<YYINITIAL> "inicio"            {return new Symbol(Simbolos.RINICIO,yyline,yychar,yytext());} 
<YYINITIAL> "fin"               {return new Symbol(Simbolos.RFIN,yyline,yychar,yytext());}
<YYINITIAL> "ingresar"          {return new Symbol(Simbolos.RINGRESAR,yyline,yychar,yytext());}
<YYINITIAL> "como"              {return new Symbol(Simbolos.RCOMO,yyline,yychar,yytext());}
<YYINITIAL> "con_valor"         {return new Symbol(Simbolos.RCONVALOR,yyline,yychar,yytext());}
<YYINITIAL> "numero"            {return new Symbol(Simbolos.RNUMERO,yyline,yychar,yytext());}
<YYINITIAL> "cadena"            {return new Symbol(Simbolos.RCADENA,yyline,yychar,yytext());}
<YYINITIAL> "boolean"           {return new Symbol(Simbolos.RBOOLEAN,yyline,yychar,yytext());}
<YYINITIAL> "caracter"          {return new Symbol(Simbolos.RCARACTER,yyline,yychar,yytext());}
<YYINITIAL> "si"                {return new Symbol(Simbolos.RSI,yyline,yychar, yytext());}
<YYINITIAL> "entonces"          {return new Symbol(Simbolos.RENTONCES,yyline,yychar, yytext());}
<YYINITIAL> "fin_si"            {return new Symbol(Simbolos.RFINSI,yyline,yychar, yytext());}
<YYINITIAL> "de_lo_contrario"   {return new Symbol(Simbolos.RDELOCONTRARIO,yyline,yychar, yytext());}
<YYINITIAL> "o_si"              {return new Symbol(Simbolos.ROSI,yyline,yychar, yytext());}
<YYINITIAL> "segun"             {return new Symbol(Simbolos.RSEGUN,yyline,yychar, yytext());}
<YYINITIAL> "hacer"             {return new Symbol(Simbolos.RHACER,yyline,yychar, yytext());}
<YYINITIAL> "fin_segun"         {return new Symbol(Simbolos.RFINSEGUN,yyline,yychar, yytext());}
<YYINITIAL> "para"              {return new Symbol(Simbolos.RPARA,yyline,yychar, yytext());}
<YYINITIAL> "hasta"             {return new Symbol(Simbolos.RHASTA,yyline,yychar, yytext());}
<YYINITIAL> "fin_para"          {return new Symbol(Simbolos.RFINPARA,yyline,yychar, yytext());}
<YYINITIAL> "con incremental"   {return new Symbol(Simbolos.RCONINCREMENTAL,yyline,yychar, yytext());}
<YYINITIAL> "mientras"          {return new Symbol(Simbolos.RMIENTRAS,yyline,yychar, yytext());}
<YYINITIAL> "fin_mientras"      {return new Symbol(Simbolos.RFINMIENTRAS,yyline,yychar, yytext());}
<YYINITIAL> "repetir"           {return new Symbol(Simbolos.RREPETIR,yyline,yychar, yytext());}
<YYINITIAL> "hasta_que"         {return new Symbol(Simbolos.RHASTAQUE,yyline,yychar, yytext());}
<YYINITIAL> "retornar"          {return new Symbol(Simbolos.RRETORNAR,yyline,yychar, yytext());}
<YYINITIAL> "metodo"            {return new Symbol(Simbolos.RMETODO,yyline,yychar, yytext());}
<YYINITIAL> "fin_metodo"        {return new Symbol(Simbolos.RFINMETODO,yyline,yychar, yytext());}
<YYINITIAL> "con_parametros"    {return new Symbol(Simbolos.RCONPARAMETROS,yyline,yychar, yytext());}
<YYINITIAL> "funcion"           {return new Symbol(Simbolos.RFUNCION,yyline,yychar, yytext());}
<YYINITIAL> "fin_funcion"       {return new Symbol(Simbolos.RFINFUNCION,yyline,yychar, yytext());}
<YYINITIAL> "ejecutar"          {return new Symbol(Simbolos.REJECUTAR,yyline,yychar, yytext());}
<YYINITIAL> "imprimir"          {return new Symbol(Simbolos.RIMPRIMIR,yyline,yychar, yytext());}
<YYINITIAL> "imprimir_nl"       {return new Symbol(Simbolos.RIMPRIMIRNL,yyline,yychar, yytext());}

<YYINITIAL> ";"                 {return new Symbol(Simbolos.PTCOMA,yyline,yychar, yytext());}
<YYINITIAL> ","                 {return new Symbol(Simbolos.COMA,yyline,yychar, yytext());}  
<YYINITIAL> "("                 {return new Symbol(Simbolos.PARIZQ,yyline,yychar, yytext());} 
<YYINITIAL> ")"                 {return new Symbol(Simbolos.PARDER,yyline,yychar, yytext());} 
<YYINITIAL> "["                 {return new Symbol(Simbolos.CORIZQ,yyline,yychar, yytext());} 
<YYINITIAL> "]"                 {return new Symbol(Simbolos.CORDER,yyline,yychar, yytext());} 
<YYINITIAL> "->"                {return new Symbol(Simbolos.FLECHA,yyline,yychar, yytext());}
<YYINITIAL> "¿"                 {return new Symbol(Simbolos.INTABRE,yyline,yychar, yytext());}
<YYINITIAL> "?"                 {return new Symbol(Simbolos.INTCIERRA,yyline,yychar, yytext());}

<YYINITIAL> "+"                 {return new Symbol(Simbolos.SUMA,yyline,yychar, yytext());} 
<YYINITIAL> "-"                 {return new Symbol(Simbolos.RESTA,yyline,yychar, yytext());} 
<YYINITIAL> "*"                 {return new Symbol(Simbolos.MULTIPLICACION,yyline,yychar, yytext());} 
<YYINITIAL> "/"                 {return new Symbol(Simbolos.DIVIDIR,yyline,yychar, yytext());} 
<YYINITIAL> "potencia"          {return new Symbol(Simbolos.POTENCIA,yyline,yychar, yytext());}
<YYINITIAL> "mod"               {return new Symbol(Simbolos.MODU,yyline,yychar, yytext());}

\n {yychar=1;}

<YYINITIAL> {BLANCOS}           {} 
<YYINITIAL> {DIGITO}            {return new Symbol(Simbolos.ENTERO,yyline,yychar, yytext());} 
<YYINITIAL> {DECIMAL}           {return new Symbol(Simbolos.DECIMAL,yyline,yychar, yytext());} 
<YYINITIAL> {CADENA}            {return new Symbol(Simbolos.CADENA,yyline,yychar, yytext());}
<YYINITIAL> {COMENTARIOL}       {return new Symbol(Simbolos.COMENTARIOL,yyline,yychar, yytext());}
<YYINITIAL> {COMENTARIOML}      {return new Symbol(Simbolos.COMENTARIOML,yyline,yychar, yytext());}
<YYINITIAL> {IDENTIFICADOR}     {return new Symbol(Simbolos.IDENTIFICADOR,yyline,yychar, yytext());}
<YYINITIAL> {CARASCCI}          {return new Symbol(Simbolos.CARASCCI,yyline,yychar, yytext());}
<YYINITIAL> {CARACTER}          {return new Symbol(Simbolos.CARACTER,yyline,yychar, yytext());}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
    ErroresLexicos.add(new Error("Lexico","El caracter " + yytext()+ "no es válido en el lenguaje", yyline,yychar));
}