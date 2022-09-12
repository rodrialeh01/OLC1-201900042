/*------------------------- Codigo de Usuario --------------------------------*/
//------------>Paquetes, importaciones
package analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;
import Clases.ErrorLenguaje;

/*------------------------- Opciones y Declaraciones ------------------------*/

%%
%{
    //CODIGO DE JAVA
    public LinkedList<ErrorLenguaje> ErroresLexicos = new LinkedList<ErrorLenguaje>();
%}

//Directivas
%public
%class Analizador_Lexico
%cupsym sym
%cup
%char
%column
%full
%ignorecase
%line
%unicode

%init{
    yyline = 1;
%init}

//------------------------EXPRESIONES REGULARES------------------------------

BLANCOS=[ \r\t]+
DIGITO=[0-9]+
DECIMAL=[0-9]+("."[0-9]+)?
CADENA=[\"](((\\\')|(\\\")|(\\n)|(\\))|[^\\\"\n])*[\"]
COMENTARIOL=("//".*\r\n*)|("//".*\n*)|("//".*\r\n*)|(\/\/(.*)*)
COMENTARIOML=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/] 
IDENTIFICADOR=("_"([A-Za-z0-9])+"_")
CARACTER=("'"([A-Za-zñÑ])"'")
CARASCCI=("'${"(((6[5-9])|([7-8][0-9])|(90))|((9[7-9])|(1[0-1][0-9])|(12[0-2]))|(164)|(165)|(32))"}'")
INTERROGACIONA = [\¿]
%%


/*------------------------- Reglas Lexicas --------------------------------*/

//PALABRAS RESERVADAS
<YYINITIAL> "mayor"             {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RMAYOR,yyline,yychar,yytext());}
<YYINITIAL> "menor"             {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RMENOR,yyline,yychar,yytext());}
<YYINITIAL> "mayor_o_igual"     {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RMAYOROIGUAL,yyline,yychar,yytext());}
<YYINITIAL> "menor_o_igual"     {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RMENOROIGUAL,yyline,yychar,yytext());}
<YYINITIAL> "es_igual"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RESIGUAL,yyline,yychar,yytext());}
<YYINITIAL> "es_diferente"      {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RESDIFERENTE,yyline,yychar,yytext());}
<YYINITIAL> "or"                {System.out.println("TOKEN: " + yytext());return new Symbol(sym.ROR,yyline,yychar,yytext());}
<YYINITIAL> "and"               {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RAND,yyline,yychar,yytext());}
<YYINITIAL> "not"               {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RNOT,yyline,yychar,yytext());}
<YYINITIAL> "verdadero"         {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RVERDADERO,yycolumn,yychar,yytext());}
<YYINITIAL> "falso"             {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFALSO,yyline,yychar,yytext());}
<YYINITIAL> "inicio"            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RINICIO,yyline,yychar,yytext());} 
<YYINITIAL> "fin"               {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFIN,yyline,yychar,yytext());}
<YYINITIAL> "ingresar"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RINGRESAR,yyline,yychar,yytext());}
<YYINITIAL> "como"              {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RCOMO,yyline,yychar,yytext());}
<YYINITIAL> "con_valor"         {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RCONVALOR,yyline,yychar,yytext());}
<YYINITIAL> "numero"            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RNUMERO,yyline,yychar,yytext());}
<YYINITIAL> "cadena"            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RCADENA,yyline,yychar,yytext());}
<YYINITIAL> "boolean"           {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RBOOLEAN,yyline,yychar,yytext());}
<YYINITIAL> "caracter"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RCARACTER,yyline,yychar,yytext());}
<YYINITIAL> "si"                {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RSI,yyline,yychar, yytext());}
<YYINITIAL> "entonces"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RENTONCES,yyline,yychar, yytext());}
<YYINITIAL> "fin_si"            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFINSI,yyline,yychar, yytext());}
<YYINITIAL> "de_lo_contrario"   {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RDELOCONTRARIO,yyline,yychar, yytext());}
<YYINITIAL> "o_si"              {System.out.println("TOKEN: " + yytext());return new Symbol(sym.ROSI,yyline,yychar, yytext());}
<YYINITIAL> "segun"             {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RSEGUN,yyline,yychar, yytext());}
<YYINITIAL> "hacer"             {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RHACER,yyline,yychar, yytext());}
<YYINITIAL> "fin_segun"         {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFINSEGUN,yyline,yychar, yytext());}
<YYINITIAL> "para"              {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RPARA,yyline,yychar, yytext());}
<YYINITIAL> "hasta"             {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RHASTA,yyline,yychar, yytext());}
<YYINITIAL> "fin_para"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFINPARA,yyline,yychar, yytext());}
<YYINITIAL> "con incremental"   {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RCONINCREMENTAL,yyline,yychar, yytext());}
<YYINITIAL> "mientras"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RMIENTRAS,yyline,yychar, yytext());}
<YYINITIAL> "fin_mientras"      {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFINMIENTRAS,yyline,yychar, yytext());}
<YYINITIAL> "repetir"           {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RREPETIR,yyline,yychar, yytext());}
<YYINITIAL> "hasta_que"         {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RHASTAQUE,yyline,yychar, yytext());}
<YYINITIAL> "retornar"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RRETORNAR,yyline,yychar, yytext());}
<YYINITIAL> "metodo"            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RMETODO,yyline,yychar, yytext());}
<YYINITIAL> "fin_metodo"        {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFINMETODO,yyline,yychar, yytext());}
<YYINITIAL> "con_parametros"    {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RCONPARAMETROS,yyline,yychar, yytext());}
<YYINITIAL> "funcion"           {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFUNCION,yyline,yychar, yytext());}
<YYINITIAL> "fin_funcion"       {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RFINFUNCION,yyline,yychar, yytext());}
<YYINITIAL> "ejecutar"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.REJECUTAR,yyline,yychar, yytext());}
<YYINITIAL> "imprimir"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RIMPRIMIR,yyline,yychar, yytext());}
<YYINITIAL> "imprimir_nl"       {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RIMPRIMIRNL,yyline,yychar, yytext());}

<YYINITIAL> ";"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.PTCOMA,yyline,yychar, yytext());}
<YYINITIAL> ","                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.COMA,yyline,yychar, yytext());}  
<YYINITIAL> "("                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.PARIZQ,yyline,yychar, yytext());} 
<YYINITIAL> ")"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.PARDER,yyline,yychar, yytext());} 
<YYINITIAL> "["                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.CORIZQ,yyline,yychar, yytext());} 
<YYINITIAL> "]"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.CORDER,yyline,yychar, yytext());} 
<YYINITIAL> "->"                {System.out.println("TOKEN: " + yytext());return new Symbol(sym.FLECHA,yyline,yychar, yytext());}
<YYINITIAL> {INTERROGACIONA}    {System.out.println("TOKEN: " + yytext());return new Symbol(sym.INTABRE,yyline,yychar, yytext());}
<YYINITIAL> "?"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.INTCIERRA,yyline,yychar, yytext());}

<YYINITIAL> "+"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.SUMA,yyline,yychar, yytext());} 
<YYINITIAL> "-"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.RESTA,yyline,yychar, yytext());} 
<YYINITIAL> "*"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.MULTIPLICACION,yyline,yychar, yytext());} 
<YYINITIAL> "/"                 {System.out.println("TOKEN: " + yytext());return new Symbol(sym.DIVIDIR,yyline,yychar, yytext());} 
<YYINITIAL> "potencia"          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.POTENCIA,yyline,yychar, yytext());}
<YYINITIAL> "modulo"            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.MODU,yyline,yychar, yytext());}

\n {yychar=1;}

<YYINITIAL> {BLANCOS}           {} 
<YYINITIAL> {DIGITO}            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.ENTERO,yyline,yychar, yytext());} 
<YYINITIAL> {DECIMAL}           {System.out.println("TOKEN: " + yytext());return new Symbol(sym.DECIMAL,yyline,yychar, yytext());} 
<YYINITIAL> {CADENA}            {System.out.println("TOKEN: " + yytext());return new Symbol(sym.CADENA,yyline,yychar, yytext());}
<YYINITIAL> {COMENTARIOL}       {System.out.println("TOKEN: " + yytext());return new Symbol(sym.COMENTARIOL,yyline,yychar, yytext());}
<YYINITIAL> {COMENTARIOML}      {System.out.println("TOKEN: " + yytext());return new Symbol(sym.COMENTARIOML,yyline,yychar, yytext());}
<YYINITIAL> {IDENTIFICADOR}     {System.out.println("TOKEN: " + yytext());return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
<YYINITIAL> {CARASCCI}          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.CARASCCI,yyline,yychar, yytext());}
<YYINITIAL> {CARACTER}          {System.out.println("TOKEN: " + yytext());return new Symbol(sym.CARACTER,yyline,yychar, yytext());}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
    ErroresLexicos.add(new ErrorLenguaje("Lexico","El caracter " + yytext()+ "no es válido en el lenguaje", yyline,yychar));
}