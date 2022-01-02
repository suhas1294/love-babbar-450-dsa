package rishi.atreya._03_strings;

/*
    1XY2 is a valid shuffle of XY and 12
    Y1X2 is a valid shuffle of XY and 12
    Y21XX is not a valid shuffle of XY and 12
    Note : length of result string should be equal to sum of two strings
*/

import java.util.Arrays;

public class _51_IsValidShuffle {
    // string to char array -> sort -> back to string and return
    static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    // this method compares each character of the result with
    // individual characters of the first and second string
    static boolean shuffleCheck(String first, String second, String result) {
        if (first.length() + second.length() != result.length()) return false;
        // sort each string to make comparison easier
        first = sortString(first);
        second = sortString(second);
        result = sortString(result);

        int i = 0, j = 0, k = 0;
        while (k != result.length()) {
            if (i < first.length() && first.charAt(i) == result.charAt(k)) i++;
            else if (j < second.length() && second.charAt(j) == result.charAt(k)) j++;
            else return false;
            k++;
        }
        // after accessing all characters of result
        // if either first or second has some characters left
        if(i < first.length() || j < second.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        String[][] inputs = {
                {"XY", "12", "1XY2"},
                {"XY", "12", "Y1X2"},
                {"XY", "12", "Y21XX"}
        };
        for (String[] input : inputs) {
            System.out.println(shuffleCheck(input[0], input[1], input[2]) ?
                    "valid shuffle" : "invalid shuffle" );
        }
    }
}
