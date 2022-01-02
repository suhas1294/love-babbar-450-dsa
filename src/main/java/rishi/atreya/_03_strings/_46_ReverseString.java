package rishi.atreya._03_strings;

import rishi.atreya._099_utils.Util;

public class _46_ReverseString {
    static void reverseString(String s[]) {
        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            Util.swapIndicesOfArray(s, i, j);
        }
    }

    static void reverseString(char s[]) {
        for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        // way-1
        String s = "hello";
        String[] stringArr = s.split("");
        reverseString(stringArr);
        System.out.println(String.join("", stringArr) );

        // way-2
        char[] charArray = s.toCharArray();
        reverseString(charArray);
        for (char c: charArray) {
            System.out.print(c);
        }
    }
}
