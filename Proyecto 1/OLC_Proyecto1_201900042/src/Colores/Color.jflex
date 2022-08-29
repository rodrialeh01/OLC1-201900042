package Colores;
import java.io.*;   
import javax.swing.text.Segment;   
   
import org.fife.ui.rsyntaxtextarea.*;   
   
%%   
   
%public   
%class Colores   
%extends AbstractJFlexCTokenMaker   
%unicode   
%type org.fife.ui.rsyntaxtextarea.Token   
   
/**   
 * A simple TokenMaker example.   
 */   
%{   
   
   /**   
    * Constructor.  This must be here because JFlex does not generate a   
    * no-parameter constructor.   
    */   
   public Colores() {   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param tokenType The token's type.   
    * @see #addToken(int, int, int)   
    */   
   private void addHyperlinkToken(int start, int end, int tokenType) {   
      int so = start + offsetShift;   
      addToken(zzBuffer, start,end, tokenType, so, true);   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param tokenType The token's type.   
    */   
   private void addToken(int tokenType) {   
      addToken(zzStartRead, zzMarkedPos-1, tokenType);   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param tokenType The token's type.   
    * @see #addHyperlinkToken(int, int, int)   
    */   
   private void addToken(int start, int end, int tokenType) {   
      int so = start + offsetShift;   
      addToken(zzBuffer, start,end, tokenType, so, false);   
   }   
   
   /**   
    * Adds the token specified to the current linked list of tokens.   
    *   
    * @param array The character array.   
    * @param start The starting offset in the array.   
    * @param end The ending offset in the array.   
    * @param tokenType The token's type.   
    * @param startOffset The offset in the document at which this token   
    *        occurs.   
    * @param hyperlink Whether this token is a hyperlink.   
    */   
   public void addToken(char[] array, int start, int end, int tokenType,   
                  int startOffset, boolean hyperlink) {   
      super.addToken(array, start,end, tokenType, startOffset, hyperlink);   
      zzStartRead = zzMarkedPos;   
   }   
   
   /**   
    * Returns the text to place at the beginning and end of a   
    * line to "comment" it in a this programming language.   
    *   
    * @return The start and end strings to add to a line to "comment"   
    *         it out.   
    */   
   public String[] getLineCommentStartAndEnd() {   
      return new String[] { "//", null };   
   }   
   
   /**   
    * Returns the first token in the linked list of tokens generated   
    * from <code>text</code>.  This method must be implemented by   
    * subclasses so they can correctly implement syntax highlighting.   
    *   
    * @param text The text from which to get tokens.   
    * @param initialTokenType The token type we should start with.   
    * @param startOffset The offset into the document at which   
    *        <code>text</code> starts.   
    * @return The first <code>Token</code> in a linked list representing   
    *         the syntax highlighted text.   
    */   
   public Token getTokenList(Segment text, int initialTokenType, int startOffset) {   
   
      resetTokenList();   
      this.offsetShift = -text.offset + startOffset;   
   
      // Start off in the proper state.   
      int state = Token.NULL;   
   
      s = text;   
      try {   
         yyreset(zzReader);   
         yybegin(state);   
         return yylex();   
      } catch (IOException ioe) {   
         ioe.printStackTrace();   
         return new TokenImpl();   
      }   
   
   }   
   
   /**   
    * Refills the input buffer.   
    *   
    * @return      <code>true</code> if EOF was reached, otherwise   
    *              <code>false</code>.   
    */   
   private boolean zzRefill() {   
      return zzCurrentPos>=s.offset+s.count;   
   }   
   
   /**   
    * Resets the scanner to read from a new input stream.   
    * Does not close the old reader.   
    *   
    * All internal variables are reset, the old input stream    
    * <b>cannot</b> be reused (internal buffer is discarded and lost).   
    * Lexical state is set to <tt>YY_INITIAL</tt>.   
    *   
    * @param reader   the new input stream    
    */   
   public final void yyreset(Reader reader) {   
      // 's' has been updated.   
      zzBuffer = s.array;   
      /*   
       * We replaced the line below with the two below it because zzRefill   
       * no longer "refills" the buffer (since the way we do it, it's always   
       * "full" the first time through, since it points to the segment's   
       * array).  So, we assign zzEndRead here.   
       */   
      //zzStartRead = zzEndRead = s.offset;   
      zzStartRead = s.offset;   
      zzEndRead = zzStartRead + s.count - 1;   
      zzCurrentPos = zzMarkedPos = zzPushbackPos = s.offset;   
      zzLexicalState = YYINITIAL;   
      zzReader = reader;   
      zzAtBOL  = true;   
      zzAtEOF  = false;   
   }   
   
%}   
   
BLANCOS=[ \r\t]+
Letter                     = [A-Za-z]   
DIGITO=[0-9]+
DECIMAL=[0-9]+("."[0-9]+)?
CADENA=[\"](((\\\')|(\\\")|(\\n))|[^\\\"\n])*[\"]
COMENTARIOL=("//".*\r\n*)|("//".*\n*)|("//".*\r\n*)|(\/\/(.*)*)
COMENTARIOML=("/""*"([^"*"]*)"*""/")
IDENTIFICADOR=("_"([A-Za-z0-9])+"_")
CARACTER=("'"([A-Za-zñÑ])"'")
CARASCCI=("'${"(((6[5-9])|([7-8][0-9])|(90))|((9[7-9])|(1[0-1][0-9])|(12[0-2]))|(164)|(165)|(32))"}'")

%state MLC
%%   
   
<YYINITIAL> {   
   
   /* Keywords */ 
   "ingresar"   
   "como" |
   "con_valor" |
   "si"|
   "entonces" |
   "fin_si" |
   "de_lo_contrario" |
   "o_si" |
   "segun" |
   "hacer" |
   "fin_segun" |
   "para" |
   "hasta" |
   "fin_para" |
   "con incremental" |
   "mientras" |
   "fin_mientras" |
   "repetir" |
   "hasta_que" |
   "ejecutar" |
   "imprimir" |
   "imprimir_nl"      { addToken(Token.RESERVED_WORD); }   
   
   /* Data types */   
   "numero" |   
   "cadena" |   
   "boolean" |   
   "caracter" { addToken(Token.DATA_TYPE); }   
   
   /* Functions */   
   "inicio" |   
   "fin" |   
   "metodo" |
   "fin_metodo" |
   "funcion" |  
   "retornar" |
   "fin_funcion" |
   "con_parametros"      { addToken(Token.FUNCTION); }   
   
   {IDENTIFICADOR}            { addToken(Token.IDENTIFIER); }   
    
   
   /* String/Character literals. */   
   {CARACTER}|{CARASCCI}            { addToken(Token.LITERAL_CHAR); }   
   {CADENA}            { addToken(Token.LITERAL_STRING_DOUBLE_QUOTE); }     
   
   /* Comment literals. */   
   {COMENTARIOL} | {COMENTARIOML}    { addToken(Token.COMMENT_MULTILINE);}   
   
   /* Operators. */   
   "mayor" | "menor" | "mayor_o_igual" | "menor_o_igual" | "es_igual" | "es_diferente" | "or" | "and" | "not" | "+" | "-" | "/" | "*" | "mod" |   
   "potencia" | "->"  { addToken(Token.OPERATOR); }   

    /* Separators. */   
   ";" | "(" | ")" | "[" | "]" | "," | "¿" | "?"  { addToken(Token.SEPARATOR); }   
   
   /* Numbers */   
   {DIGITO}|{DECIMAL}         { addToken(Token.LITERAL_NUMBER_DECIMAL_INT); }  
   
   /* Ended with a line not in a string or comment. */   
   \n |   
   <<EOF>>                  { addNullToken(); return firstToken; }   
   
   .                     { addToken(Token.ANNOTATION); }   
} 
<MLC> {    
   \n |   
   <<EOF>>            { addToken(start,zzStartRead-1,Token.NULL); return firstToken; }   
}    