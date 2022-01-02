package rishi.atreya._03_strings;

public class _53_LongestPalindromicSubstring {
    // way-1 : space efficient algo
    static int longestPalSubstr(String str) {
        int maxLength = 1; // The result (length of LPS)
        int start = 0;
        int len = str.length();
        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i) {
            // Find the longest even length palindrome with center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low)
                    == str.charAt(high)) {
                --low;
                ++high;
            }

            // Move back to the last possible valid palindrome substring
            // as that will anyway be the longest from above loop
            ++low; --high;
            if (str.charAt(low) == str.charAt(high) && high - low + 1 > maxLength) {
                start = low;
                maxLength = high - low + 1;
            }

            // Find the longest odd length palindrome with center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low)
                    == str.charAt(high)) {
                --low;
                ++high;
            }
            // Move back to the last possible valid palindrom substring
            // as that will anyway be the longest from above loop
            ++low; --high;
            if (str.charAt(low) == str.charAt(high) && high - low + 1 > maxLength) {
                start = low;
                maxLength = high - low + 1;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);
        return maxLength;
    }

    static void printSubStr(String str, int low, int high) {
        System.out.println( str.substring( low, high + 1));
    }

    // space inefficient algo
    static int longestPalSubstr1(String str){
        int n = str.length(); // get length of input string

        // table[i][j] will be false if substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length of substring
        for (int k = 3; k <= n; ++k) {
            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from starting index i and length k
                int j = i + k - 1;
                // checking for sub-string from ith index to jth index iff
                // str.charAt(i+1) to str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start, start + maxLength - 1);
        return maxLength; // return length of LPS
    }

}

/**
 * Input: Given string :"forgeeksskeegfor",
 * Output: "geeksskeeg"
 *
 * Input: Given string :"Geeks",
 * Output: "ee"
 *
 * solution explanation: https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * solution explanation: https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 *
 */