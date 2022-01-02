package rishi.atreya._03_strings;

// https://www.geeksforgeeks.org/edit-distance-dp-using-memoization/
public class _59_EditDistanceStr1ToStr2 {
    // way-1 DP using Memoization
    static int editDist(String str1, String str2, int m, int n){
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing much to do.
        // Ignore last characters and get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDist(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all three operations on last
        // character of first string, recursively compute minimum cost for all three
        // operations and take minimum of three values.
        return 1 + getMin(editDist(str1, str2, m, n - 1), // Insert
                editDist(str1, str2, m - 1, n), // Remove
                editDist(str1, str2, m - 1, n - 1) // Replace
        );
    }

    // way-2 : space efficient
    static void EditDistDP(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        // Create a DP array to memoize result of previous computations
        int[][] dp = new int[2][len1 + 1];
        // Base condition when second String is empty then we remove all characters
        for (int i = 0; i <= len1; i++)
            dp[0][i] = i;

        // Start filling the DP This loop run for every character in second String
        for (int i = 1; i <= len2; i++){
            // This loop compares the char from second String with first String characters
            for (int j = 0; j <= len1; j++){
                // if first String is empty then we have to perform add character
                // operation to get second String
                if (j == 0) {
                    dp[i % 2][j] = i;
                }else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    // if character from both String is same then we do not perform any
                    // operation . here i % 2 is for bound the row number.
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                }else {
                    // if character from both String is not same then we
                    // take the minimum from three specified operation
                    dp[i % 2][j] = 1 + Math.min(dp[(i - 1) % 2][j],
                            Math.min(dp[i % 2][j - 1],
                                    dp[(i - 1) % 2][j - 1]));
                }
            }
        }

        // after complete fill the DP array if the len2 is even then we end up in
        // the 0th row else we end up in the 1th row so we take len2 % 2 to get row
        System.out.print(dp[len2 % 2][len1] +"\n");
    }

    static int getMin(int x, int y, int z){
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String[] args) {
        // way-1
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
        // way-2
        String str3 = "food";
        String str4 = "money";
        EditDistDP(str3, str4);
    }

}
