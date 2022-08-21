package analizadores;
import java_cup.runtime.Symbol; 

%% 
%class Lexico
%public 
%line 
%char 
%cup 
%unicode
%ignorecase

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 

BLANCOS=[ \r\t]+
DIGITO=[0-9]+
DECIMAL=[0-9]+("."[  |0-9]+)?
CADENA=\"([^\"]*)\"
COMENTARIOL=\/\/([^\n]*)
COMENTARIOML=\/\*([^\*\/]*)\*\/
VARIABLE=\_([A-Za-z0-9])+\_
CHARACTER=\'([A-Za-zñÑ])\'
ASCCI=\'\$\{((6[5-9]|[7-8]\d|90)|((9[7-9]|1[0-1]\d|12[0-2]))|164|165)\}\'
%%

"Verdadero" {return new Symbol(sym.VERDADERO,yyline,yychar,yytext());}
"Falso" {return new Symbol(sym.FALSO,yyline,yychar,yytext());}
"inicio" {return new Symbol(sym.REVALUAR,yyline,yychar,yytext());} 
"fin" {return new Symbol(sym.FIN,yyline,yychar,yytext());}
"ingresar" {return new Symbol(sym.INGRESAR,yyline,yychar,yytext());}
"como" {retun new Symbol(sym.COMO,yyline,yychar,yytext());}
"con_valor" {return new Symbol(sym.CONVALOR,yyline,yychar,yytext());}
"Número" {return new Symbol(sym.NUMERO,yyline,yychar,yytext());}
"Cadena" {return new Symbol(sym.CADENA,yyline,yychar,yytext());}
"Boolean" {return new Symbol(sym.BOOLEAN,yyline,yychar,yytext());}
"Carácter" {return new Symbol(sym.CARACTER,yyline,yychar,yytext());}
"si" {return new Symbol(sym.SI,yyline,yychar, yytext());}
"entonces" {return new Symbol(sym.ENTONCES,yyline,yychar, yytext());}
"fin_si" {return new Symbol(sym.FINSI,yyline,yychar, yytext());}
"de_lo_contrario" {return new Symbol(sym.DELOCONTRARIO,yyline,yychar, yytext());}
"o_si" {return new Symbol(sym.OSI,yyline,yychar, yytext());}
"segun" {return new Symbol(sym.SEGUN,yyline,yychar, yytext());}
"hacer" {return new Symbol(sym.HACER,yyline,yychar, yytext());}
"fin_segun" {return new Symbol(sym.FINSEGUN,yyline,yychar, yytext());}
"para" {return new Symbol(sym.PARA,yyline,yychar, yytext());}
"hasta" {return new Symbol(sym.HASTA,yyline,yychar, yytext());}
"fin_para" {return new Symbol(sym.FINPARA,yyline,yychar, yytext());}
"con incremental" {return new Symbol(sym.CONINCREMENTAL,yyline,yychar, yytext());}
"mientras" {return new Symbol(sym.MIENTRAS,yyline,yychar, yytext());}
"fin_mientras" {return new Symbol(sym.FINMIENTRAS,yyline,yychar, yytext());}
"repetir" {return new Symbol(sym.REPETIR,yyline,yychar, yytext());}
"hasta_que" {return new Symbol(sym.HASTAQUE,yyline,yychar, yytext());}
"retornar" {return new Symbol(sym.RETORNAR,yyline,yychar, yytext());}
"metodo" {return new Symbol(sym.METODO,yyline,yychar, yytext());}
"fin_metodo" {return new Symbol(sym.FINMETODO,yyline,yychar, yytext());}
"con_parametros" {return new Symbol(sym.CONPARAMETROS,yyline,yychar, yytext());}
"funcion" {return new Symbol(sym.FUNCION,yyline,yychar, yytext());}
"fin_funcion" {return new Symbol(sym.FINFUNCION,yyline,yychar, yytext());}
"ejecutar" {return new Symbol(sym.EJECUTAR,yyline,yychar, yytext());}
"imprimir" {return new Symbol(sym.IMPRIMIR,yyline,yychar, yytext());}
"imprimir_nl" {return new Symbol(sym.IMPRIMIRNL,yyline,yychar, yytext());}

";" {return new Symbol(sym.PTCOMA,yyline,yychar, yytext());}
"," {return new Symbol(sym.COMA,yyline,yychar, yytext());}  
"(" {return new Symbol(sym.PARIZQ,yyline,yychar, yytext());} 
")" {return new Symbol(sym.PARDER,yyline,yychar, yytext());} 
"[" {return new Symbol(sym.CORIZQ,yyline,yychar, yytext());} 
"]" {return new Symbol(sym.CORDER,yyline,yychar, yytext());} 
"->" {return new Symbol(sym.FLECHA,yyline,yychar, yytext());}

"=" {return new Symbol(sym.IGUAL,yyline,yychar, yytext());}
"+" {return new Symbol(sym.MAS,yyline,yychar, yytext());} 
"-" {return new Symbol(sym.MENOS,yyline,yychar, yytext());} 
"*" {return new Symbol(sym.POR,yyline,yychar, yytext());} 
"/" {return new Symbol(sym.DIVIDIDO,yyline,yychar, yytext());} 
"potencia" {return new Symbol(sym.POTENCIA,yyline,yychar, yytext());}
"mod" {return new Symbol(sym.MOD,yyline,yychar, yytext());}

\n {yychar=1;}

{BLANCOS} {} 
{DIGITO} {return new Symbol(sym.ENTERO,yyline,yychar, yytext());} 
{DECIMAL} {return new Symbol(sym.DECIMAL,yyline,yychar, yytext());} 
{CADENA} {return new Symbol(sym.TEXTO,yyline,yychar, yytext());}
{COMENTARIOL} {return new Symbol(sym.COMENTARIOL,yyline,yychar, yytext());}
{COMENTARIOML} {return new Symbol(sym.COMENTARIOML,yyline,yychar, yytext());}
{VARIABLE} {return new Symbol(sym.VARIABLE,yyline,yychar, yytext());}
ASCCI {return new Symbol(sym.ASCII,yyline,yychar, yytext());}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);
}