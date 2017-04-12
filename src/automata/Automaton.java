package automata;

public abstract class Automaton {

   public abstract boolean accept(String w);
   
   public void test(String w) {
      header(w); 
      boolean result = accept(w);
      System.out.printf("  %s", (result ? "Accept" : "Reject"));
      System.out.println();
   }
   
   static void header(String w) {
      for (int j=0; j<w.length(); j++) 
          System.out.printf("%8s", w.charAt(j));
      System.out.println();
   }
   static void test(Automaton a, String[] args) {
      if (args.length==0)  //default strings for testing
          args = new String[] {"1", "100", "111","0101","10101", "11010101","11010111"};
      for (String w: args) {
          a.test(w); System.out.println();
      }
   }
}
