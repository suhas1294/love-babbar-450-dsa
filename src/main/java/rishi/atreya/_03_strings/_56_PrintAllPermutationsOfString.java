package rishi.atreya._03_strings;

import rishi.atreya._099_utils.Util;

public class _56_PrintAllPermutationsOfString {
    // way-1
    public static void permute(String str, int l, int r){
        if (l == r) {
            System.out.println(str);
        }else{
            for (int i = l; i <= r; i++){
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j){
        char[] charArray = a.toCharArray();
        Util.swapIndicesOfanArray(charArray, i, j);
        return String.valueOf(charArray);
    }

    // way-2
    static void permute(String s , String answer){
        if (s.length() == 0) {
            System.out.print(answer + "  ");
            return;
        }

        for(int i = 0 ;i < s.length(); i++){
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }

    public static void main(String[] args) {
        // way-1
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n-1);

        // way-2
        String s = "ABC";
        String answer="";
        permute(s, answer);
    }
}
