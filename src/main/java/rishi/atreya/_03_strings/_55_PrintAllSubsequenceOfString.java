package rishi.atreya._03_strings;

import java.util.ArrayList;
import java.util.List;

public class _55_PrintAllSubsequenceOfString {
    // way-1 : recursive way
    static List<String> al = new ArrayList<>();
    public static void findsubsequences(String s, String ans) {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }
        // We add adding 1st character in string
        findsubsequences(s.substring(1), ans + s.charAt(0));
        // Not adding first character of the string because the concept
        // of subsequence either character will present or not
        findsubsequences(s.substring(1), ans);
    }

    // way-2 : One by one fix characters and recursively generates all subsets starting from them.
    // After every recursive call, we remove last character so that the next permutation can be generated.
    static void printSubSeqRec(String str, int n, int index, String curr){
        if (index == n) return; // base case
        if (curr != null && !curr.trim().isEmpty()) System.out.println(curr);
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            printSubSeqRec(str, n, i, curr);
            curr = curr.substring(0, curr.length() - 1); // backtracking
        }
    }

    // Generates power set in lexicographic order.
    static void printSubSeq(String str){
        int index = -1;
        String curr = "";
        printSubSeqRec(str, str.length(), index, curr);
    }

    public static void main(String[] args) {
        // wya-1
        String s = "abcd";
        findsubsequences(s, ""); // Calling a function
        System.out.println(al);

        // way-2
        String str = "cab";
        printSubSeq(str);
    }
}
