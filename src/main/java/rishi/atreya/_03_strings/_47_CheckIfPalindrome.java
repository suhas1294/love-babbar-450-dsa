package rishi.atreya._03_strings;

public class _47_CheckIfPalindrome {
    static int isPalindrome(String word) {
        int result = 1;
        for (int i = 0, j = word.length()-1; i < word.length()/2; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        //String s = "MALAYALAM";
        String s = "hello";
        System.out.println(isPalindrome(s));
    }
}
