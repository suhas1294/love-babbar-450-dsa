package rishi.atreya._03_strings;

import java.util.Arrays;

// ref: https://www.geeksforgeeks.org/word-wrap-problem-dp-19/
public class _58_WordWrap_1 {
    // way-1 : Recursive Approach with memoization
    public static int solveWordWrap(int[] nums, int k) {
        int[][] memo = new int[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solveWordWrapUsingMemo(nums, nums.length, k, 0, k, memo);
    }

    public static int solveWordWrap(int[] words, int n, int length, int wordIndex,
                                    int remLength, int[][] memo) {
        //base case for last word
        if (wordIndex == n - 1) {
            memo[wordIndex][remLength] = words[wordIndex] < remLength ? 0 : square(remLength);
            return memo[wordIndex][remLength];
        }

        int currWord = words[wordIndex];
        //if word can fit in the remaining line
        if (currWord < remLength) {
            return Math.min(
                    //if word is kept on same line
                    solveWordWrapUsingMemo(words, n, length, wordIndex + 1,
                            remLength == length ? remLength - currWord : remLength - currWord - 1, memo),
                    //if word is kept on next line
                    square(remLength) + solveWordWrapUsingMemo(words, n, length, wordIndex + 1,
                            length - currWord, memo)
            );
        } else { //if word is kept on next line
            return square(remLength) + solveWordWrapUsingMemo(words, n, length, wordIndex + 1,
                    length - currWord, memo);
        }
    }

    public static int solveWordWrapUsingMemo(int[] words, int n, int length, int wordIndex, int remLength, int[][] memo) {
        if (memo[wordIndex][remLength] != -1) {
            return memo[wordIndex][remLength];
        }

        memo[wordIndex][remLength] = solveWordWrap(words, n, length, wordIndex, remLength, memo);
        return memo[wordIndex][remLength];
    }
    public static int square(int n) { return n * n; }

    public static void main(String[] args) {
        System.out.println(solveWordWrap(new int[]{3, 2, 2, 5}, 6));
    }

}
