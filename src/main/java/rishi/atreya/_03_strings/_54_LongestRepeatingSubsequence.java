package rishi.atreya._03_strings;

import java.util.Arrays;

/**
 * substring is a continuous part or subpart of a string
 * subsequence is the part of a string or sequence, that might be
 * continuous or not but the order of the elements is maintained
 * https://stackoverflow.com/questions/15505508/what-is-the-difference-between-string-substring-and-string-subsequence
 * problem explanation: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
 */
public class _54_LongestRepeatingSubsequence {
    // dynamic  programming Top-down approach
    static int lrs(StringBuilder s1, int i, int j, int[][] dp) {
        if(i >= s1.length() || j >= s1.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(dp[i][j] == -1){
            if(s1.charAt(i) == s1.charAt(j) && i != j) {
                dp[i][j] = 1 + lrs(s1, i + 1, j + 1, dp);
            }else{
                dp[i][j] = Math.max(lrs(s1, i, j + 1, dp), lrs(s1, i + 1, j, dp));
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        String s1 = "aabb";
        StringBuilder input1 = new StringBuilder();
        input1.append(s1); // append a string into StringBuilder input1
        input1.reverse(); // reverse StringBuilder input1
        int[][] dp = new int[1000][1000];
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println("result" + lrs(input1, 0, 0, dp));
    }
}