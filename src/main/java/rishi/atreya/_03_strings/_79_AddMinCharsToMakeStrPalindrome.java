package rishi.atreya._03_strings;

// KMP Algo
public class _79_AddMinCharsToMakeStrPalindrome {
    static int getMinCharToAddedToMakeStringPalin(String str){
        StringBuilder s = new StringBuilder();
        s.append(str);

        // Get concatenation of string, special character and reverse string
        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);

        // Get LPS array of this concatenated string
        int lps[] = computeLPSArray(s.toString());
        return str.length() - lps[s.length() - 1];
    }

    public static int[] computeLPSArray(String str){
        int n = str.length();
        int lps[] = new int[n];
        int i = 1, len = 0;
        lps[0] = 0; // lps[0] is always 0

        while (i < n){
            if (str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                // This is tricky. Consider the example. AAACAAAA and i = 7.
                // The idea is similar to search step.
                if (len != 0){
                    len = lps[len - 1]; // Also, note that we do not increment i here
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String str = "AACECAAAA";
        System.out.println(getMinCharToAddedToMakeStringPalin(str));
    }
}
