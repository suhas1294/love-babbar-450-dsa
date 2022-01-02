package rishi.atreya._03_strings;

import java.util.Arrays;

public class _77_SmallestDistinctWindow {
    static final int MAX_CHARS = 256;

    static String findSubString(String str){
        int n = str.length();
        if (n <= 1) return str; // if string is empty or having one char
        int dist_count = 0; // initial value
        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
                dist_count++;
            }
        }

        // Now follow the algorithm discussed in below post. We basically maintain a
        // window of characters that contains all characters of given string.
        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;

        int count = 0;
        int[] curr_count = new int[MAX_CHARS];
        for (int j = 0; j < n; j++) {
            curr_count[str.charAt(j)]++; // Count occurrence of characters of string

            // If any distinct character matched, then increment count
            if (curr_count[str.charAt(j)] == 1) count++;

            // if all the characters are matched
            if (count == dist_count) {
                // Try to minimize the window i.e., check if any character is occurring
                // more no. of times than its occurrence in pattern, if yes then remove
                // it from starting and also remove the useless characters.
                while (curr_count[str.charAt(start)] > 1) {
                    if (curr_count[str.charAt(start)] > 1)
                        curr_count[str.charAt(start)]--;
                    start++;
                }
                int len_window = j - start + 1; // Update window size
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
        return str.substring(start_index, start_index + min_len);
    }

    public static void main(String args[]){
        String str = "aabcbcdbca";
        System.out.println(findSubString(str));
    }
}
