package rishi.atreya._03_strings;

// ref : https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
public class _66_MinBracketsForReversal {
    static int countMinReversals(String expr){
        int len = expr.length();
        int ans;
        if (len % 2 != 0) return -1; // Expressions of odd lengths cannot be balanced
        int left_brace = 0, right_brace = 0;
        for (int i = 0; i < len; i++) {
            char ch = expr.charAt(i);
            // If we find a left bracket then we simply increment the left bracket
            if (ch == '{') {
                left_brace++;
            }else {
                // Else if left bracket is 0 then we find unbalanced right bracket and increment
                // right bracket or if the expression is balanced then we decrement left
                if (left_brace == 0) {
                    right_brace++;
                }else {
                    left_brace--;
                }
            }
        }
        ans = (int)(Math.ceil((0.0 + left_brace) / 2)
                + Math.ceil((0.0 + right_brace) / 2));
        return ans;
    }
    public static void main(String[] args) {
        String expr = "}}{{";
        System.out.println(countMinReversals(expr));
    }
}
