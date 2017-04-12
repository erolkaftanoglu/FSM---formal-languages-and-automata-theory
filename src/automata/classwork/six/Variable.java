package automata.classwork.six;
 
import java.util.TreeMap;

public class Variable implements Expression  { 
   String name; Expression exp;
   java.lang.reflect.Method met;
   private static TreeMap<String,Float> map = new TreeMap<String,Float>();
   
   /*public Variable(String fn, Expression x) { 
      name = fn; exp = x;
      try{
        met = Math.class.getMethod(fn, Double.TYPE);
      } catch (NoSuchMethodException e) {
        met = null;
      }
   }*/
   public Variable(String fn){
       name = fn;
       add(name);
   }
   public float fValue() {
      return getValue(name);
   }
   public String toPostfix() { return name; }
   public String toString() { return name; }
   public String toTree() { 
       return name;
   }

   /*static   Expression s = new Variable("sqrt", new Constant(400));
   static   Expression c = new Variable("cos", new Constant(0));
   static   Expression e = new Binary(s, Token.MINUS, c);
   public static void main(String[] args) {
      System.out.println(e.toPostfix());       // 400 sqrt 0 cos -
      System.out.println(e+" = "+e.fValue());  // sqrt(400)-cos(0) = 19.0
   }*/
   
   /*
    add(String)
    getValue(String)
    list->String();
    main(String[])
    remove(String)
    setValue(String,float);
   */
    static public void add(String s){
       map.put(s, 0.0f);
    }
   
    static public Float getValue(String s){
       return map.get(s);
    }
    static public String list(){
       return map.toString();
    }    
   
    static public void remove(String s){
        map.remove(s);
    }
    
    static public void setValue(String s, Float f){
        map.put(s, f);
    }
    
    public static void main(String[] args) {
        Expression e = new Parser("sqrt(x+1)").parse();
        System.out.println(e.fValue());
        Variable.setValue("x", 4.0f);
        System.out.println(e.fValue());
        
    }
}
