package rishi.atreya._03_strings;

import rishi.atreya._099_utils.Util;

import java.util.HashMap;
import java.util.Map;

public class _48_FindDuplicateChars {

    //WAY-1 : using hashmap
    static void printDups(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        // Store duplicates present in the passed string
        for (int i = 0; i < str.length(); i++) {
            if (!count.containsKey(str.charAt(i)))
                count.put(str.charAt(i), 1);
            else
                count.put(str.charAt(i),
                        count.get(str.charAt(i)) + 1);
        }

        for (Map.Entry mapElement : count.entrySet()) {
            char key = (char)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            if (value > 1) System.out.println(key + ", count = " + value);
        }
    }

    // WAY-2 : frequency array
    static final int NO_OF_CHARS = 256;
    // Fills count array with frequency of characters
    static void fillCharCounts(String str, int[] count){
        for (int i = 0; i < str.length(); i++) count[str.charAt(i)]++;
    }

    /* Print duplicates present in the passed string */
    static void printDups1(String str){
        // Create an array of size 256 and fill count of every character in it
        int count[] = new int[NO_OF_CHARS];
        fillCharCounts(str, count);

        for (int i = 0; i < NO_OF_CHARS; i++)
            if (count[i] > 1)
                System.out.println((char)(i) + ", count = " + count[i]);
    }





    public static void main(String[] args) {
        Util.printAsciiValues("abcdefghijklmnopqrstuvwxyz");
        Util.printAsciiValues("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
}
