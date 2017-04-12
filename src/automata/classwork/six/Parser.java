package automata.classwork.six;
 
/** Syntax phase: read tokens and generate syntax tree. 
 * Recursive-descent parsing algorithm for arithmetic expressions
 *
 * @author M A Eyler
 */
   
public class Parser {

   Scanner lex;
   Token tok; 
   final static String sample = "sqrt(2*8)/2-cos(5-6+1)";

   public Parser(String s) { 
       lex = new Scanner(s); 
   }
   void match(Token k)  {
      if (tok == k) tok = lex.nextToken();
      else expected(k.name());
   }
   void expected(String s) {
      error("Expected: "+s+", Found: "+tok.name());
   }
   void error(String msg) {
      throw new RuntimeException(msg);
   }
   /** 
    * Returns an Expression after parsing the input.
    * May fail in case of a syntax error. 
    * Should be called once per instance.
    */   
   public Expression parse() { 
      tok = lex.nextToken();
      Expression e = expr();
      match(Token.EOF); 
      return e; 
   }
   Expression expr() {
      Expression e = term();
      Token t = tok;
      while (t == Token.PLUS || t == Token.MINUS)  {
         match(t);
         e = new Binary(e, t, term());
         t = tok;
      }
      return e;
   }
   Expression term() {
      Expression e = factor();
      Token t = tok;
      while (t == Token.STAR || t == Token.SLASH || t == Token.POW)  {
         match(t);
         e = new Binary(e, t, factor());
         t = tok;
      }
      return e;
   }
   Expression factor() {
      if (tok == Token.NUMBER)  {
         Expression c = new Constant(lex.nval);
         match(Token.NUMBER); 
         return c;
      }
      if (tok == Token.LEFT)  {
         match(Token.LEFT);
         Expression e = expr();
         match(Token.RIGHT);
         return e;
      }
      else if (tok == Token.IDENT)  {
         String f = lex.sval;
         match(Token.IDENT);
         if(tok != Token.LEFT) return new Variable(f);
         match(Token.LEFT);
         Expression e = expr();
         match(Token.RIGHT);
         return new Function(f, e);
      }
      expected("Factor"); 
      return null;
   }
   
   /** Test code for this class.
    * Makes a new instance by e = new Parser(s).parse()
    * Then invokes all methods of Expression e
    */   
   public static void main(String[] args) {
      String s = sample;
      System.out.println(s);
      Expression e = new Parser(s).parse();
      System.out.println(e.toPostfix());
      System.out.println(e+" = "+e.fValue());
   }
}
