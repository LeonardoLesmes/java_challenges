package challenges.parentheses;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesBalanced {

   public static void main(String[] args) {
        System.out.println("Output:");
        String[] inputs = inputString.split("\n");
        for (String input : inputs) {            ;
            boolean isBalanced = isBalanced(input);
            System.out.println(isBalanced);
        }
   }

    private static boolean isBalanced(String input) {
        List<String> lifo = new ArrayList<>();
        if (input.isEmpty()) {
            return true;
        }
        String[] strs = input.split("");
        if (strs.length % 2 != 0) {
            return false;
        }
        for (String str : strs) {
            if (lifo.isEmpty()) {
                lifo.add(str);
                continue;
            }
            String first = lifo.getLast();
            if (first.equals("{") && str.equals("}")) {
                lifo.removeLast();
            }
            else if (first.equals("(") && str.equals(")")) {
                lifo.removeLast();
            }
            else if (first.equals("[") && str.equals("]")) {
                lifo.removeLast();
            }
            else {
                lifo.add(str);
            }
        }
        return lifo.isEmpty();
    }

    private static final String inputString =
            """
            [({})(())]
            (({()})))[[
            ({(){}()})()({(){}()})(){()}{}((()))
            {}()))(()()({}}{}
            }}}}
            ))))
            {{{
            (((
            {}(){()}((())){{{}}}{()()}{{}{}}
            {{{{{{{)))))))))))))))))))
            {}{}(
            {}}}{}
            ()()()())))
            (((((()()()
            (){}{{}}()(()){{()()}}
            {}{{{}}}{{{((()))}}}
            ((()))[]
            {{}}(()[])
            """;
}
