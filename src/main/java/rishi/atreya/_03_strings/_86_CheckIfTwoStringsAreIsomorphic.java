package rishi.atreya._03_strings;

public class _86_CheckIfTwoStringsAreIsomorphic {
    static final int CHAR = 26;

    static boolean isoMorphic(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        if (n != m) return false;

        int[] countChars1 = new int[CHAR];
        int[] countChars2 = new int[CHAR];

        for (int i = 0; i < n; i++) {
            countChars1[str1.charAt(i) - 'a']++;
            countChars2[str2.charAt(i) - 'a']++;

            // For string to be isomorphic the previous counts of appearances of current
            // character in both string  must be same if it is not same we  return false.
            if (countChars1[str1.charAt(i) - 'a']
                    != countChars2[str2.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isoMorphic("aab", "xxy") ? 1 : 0);
        System.out.println(isoMorphic("aab", "xyz") ? 1 : 0);
    }
}
