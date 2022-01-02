package rishi.atreya._03_strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class _61_BalancedParanthesis {
    static boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < expr.length(); i++){
            char x = expr.charAt(i);
            if (x == '(' || x == '[' || x == '{'){
                stack.push(x);
                continue;
            }
            // If current character is not opening bracket, then it must be
            // closing. So stack cannot be empty at this point.
            if (stack.isEmpty()) return false;
            char check;

            switch (x) {
                case ')' -> {
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                }
                case '}' -> {
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                }
                case ']' -> {
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                }
            }
        }
        return (stack.isEmpty()); // Check Empty Stack
    }

    public static void main(String[] args) {
        String expr = "([{}])";
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
