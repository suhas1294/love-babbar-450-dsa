package rishi.atreya._03_strings;

public class _64_KmpAlgoLongestPrefixSuffix {
    static int longestPrefixSuffix(String s){
        int n = s.length();
        int lps[] = new int[n];
        lps[0] = 0; // lps[0] is always 0
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        while (i < n){ // the loop calculates lps[i] for i = 1 to n-1
            if (s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{ // (pat[i] != pat[len])
                // This is tricky. Consider the example. AAACAAAA
                // and i = 7. The idea is similar to search step.
                if (len != 0){
                    len = lps[len-1];
                    // Also, note that we do not increment i here
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int res = lps[n-1];
        // Since we are looking for non overlapping parts.
        return (res > n/2)? n/2 : res;
    }

    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(longestPrefixSuffix(s)); // 6
    }

}
