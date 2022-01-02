package rishi.atreya._03_strings;

public class _67_AllPalindromicSubsequence {
    static int countPS(String str){
        int N = str.length();
        // 2D array to store the count of palindromic subsequence
        int[][] cps = new int[N][N];

        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++)
            cps[i][i] = 1;

        // check subsequence of length L is palindrome or not
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i <= N-L; i++) {
                int k = L + i - 1;
                if (str.charAt(i) == str.charAt(k)) {
                    cps[i][k] = cps[i][k - 1] + cps[i + 1][k] + 1;
                }else{
                    cps[i][k] = cps[i][k - 1]
                            + cps[i + 1][k]
                            - cps[i + 1][k - 1];
                }
            }
        }
        return cps[0][N - 1];
    }

    public static void main(String[] args) {
        String str = "abcb";
        System.out.println(countPS(str));
    }
}
