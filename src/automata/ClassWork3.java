/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author erol
 */
public class ClassWork3 {
    /*
    public State delta(State q, char c) {
      if (q==State.A && c=='0') return State.E; 
      if (q==State.A && c=='1') return State.C;
      if (q==State.B && c=='0') return State.C; 
      if (q==State.B && c=='1') return State.B;
      if (q==State.C && c=='0') return State.B; 
      if (q==State.C && c=='1') return State.D;
      if (q==State.D && c=='0') return State.D;
      if (q==State.D && c=='1') return State.C;
      return null;  //default is null -- no transition
    } 
    */
    public static void main(String[] args) {
        Automaton dfa = new DFA();
        String REG_EXP = "1((01*0)|(10*1))*";
        Set<Integer> a = new TreeSet<>();
        Set<Integer> r = new TreeSet<>(); 
        for (int n = 1; n < 50; n++) {
               String w = Integer.toBinaryString(n);
               if (dfa.accept(w)) {a.add(n);}
               if (w.matches(REG_EXP)) {r.add(n);}
        }
        System.out.println("");
        System.out.println("a: " + a);
        System.out.println("r: " + r);

        
    }
}
