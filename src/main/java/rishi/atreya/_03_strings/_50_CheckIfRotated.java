package rishi.atreya._03_strings;

import java.util.LinkedList;
import java.util.Queue;

public class _50_CheckIfRotated {
    static boolean areRotations(String str1, String str2){
        return (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1);
    }
    static boolean check_rotation(String s, String goal) {
        if (s.length() != goal.length());
        Queue<Character> q1 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q1.add(s.charAt(i));
        }
        Queue<Character> q2 = new LinkedList<>();
        for (int i = 0; i < goal.length(); i++) {
            q2.add(goal.charAt(i));
        }
        int k = goal.length();
        while (k > 0) {
            k--;
            char ch = q2.peek();
            q2.remove();
            q2.add(ch);
            if (q2.equals(q1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcda";
        System.out.println(areRotations(s1, s2));
        System.out.println(check_rotation(s1, s2));
    }
}
