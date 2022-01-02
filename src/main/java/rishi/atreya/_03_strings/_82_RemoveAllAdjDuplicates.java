package rishi.atreya._03_strings;

import java.util.Arrays;

public class _82_RemoveAllAdjDuplicates {
    static void removeDuplicates(char[] charArr){
        int n = charArr.length;
        if (n < 2) return;
        // j is used to store index of current distinct character
        int j = 0;
        for (int i = 1; i < n; i++){
            if (charArr[j] != charArr[i]){
                j++;
                charArr[j] = charArr[i];
            }
        }
        System.out.println(Arrays.copyOfRange(charArr, 0, j + 1));
    }

    public static void main(String[] args){
        char S1[] = "geeksforgeeks".toCharArray();
        removeDuplicates(S1);

        char S2[] = "aabcca".toCharArray();
        removeDuplicates(S2);
    }
}
