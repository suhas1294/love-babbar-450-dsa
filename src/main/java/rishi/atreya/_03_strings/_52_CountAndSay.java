package rishi.atreya._03_strings;

import java.util.Scanner;

public class _52_CountAndSay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1) return;
        String res = "1";
        while (n > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length(); i++) {
                int count = 1;
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count).append(res.charAt(i));
            }
            res = sb.toString();
            n--;
        }
        System.out.println(res);
    }
}

/**
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 *
 * answer credits: https://github.com/imKashyap/Final450-Solutions/blob/main/string/CountAndSay.java
 * question credits: https://leetcode.com/problems/count-and-say/
 *
 */