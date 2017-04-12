
package automata.assignment;
import java.util.regex.*;
public class Assignment1 {

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        String[] arrayValues = {
          "cat cat cat X","X test Z","aaab","hello","#222fff"
        };
        String[] pattern ={
            "X|Z", // x ve z 
            "a*b", //aaab
            "^[a-z0-9_-]{3,15}$",
            "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"
        };
        for (String p : pattern) {
            for (String s : arrayValues) {
                match(p, s);
            }
        }
    }
    private static void match(String p1, String m1) {
        Pattern p = Pattern.compile(p1);
        Matcher m = p.matcher(m1);
        if (m.find()) {
            System.out.println("match: pattern: " + p1 + " & value: " + m1);
        }else{
            System.out.println("unmatch: pattern: " + p1 + " & value: " + m1);
        }
    }
}
