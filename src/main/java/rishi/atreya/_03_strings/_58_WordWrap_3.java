package rishi.atreya._03_strings;

public class _58_WordWrap_3 {
    // space efficient solution
    public static void solveWordWrap(int arr[], int arr_len, int k){
        int i, j;
        int currlen; // no of characters in a given line
        int cost; // store possible minimum cost of line

        // DP table in which dp[i] represents cost of line starting
        // with word arr[i].
        int dp[] = new int[arr_len];

        // Array in which ans[i] store index of last
        // word in line starting with word arr[i].
        int ans[] = new int[arr_len];

        // If only one word is present then only one line is required. Cost of last line is zero
        // Hence cost of this line is zero. Ending point is also n-1 as single word is present.
        dp[arr_len - 1] = 0;
        ans[arr_len - 1] = arr_len - 1;

        // Make each word first word of line by iterating over each index in arr.
        for (i = arr_len - 2; i >= 0; i--){
            currlen = -1;
            dp[i] = Integer.MAX_VALUE;
            // Keep on adding words in current line by iterating
            // from starting word upto last word in arr.
            for (j = i; j < arr_len; j++){
                // Update number of characters in current line. arr[j] is number of
                // characters in current word and 1 represents space character b/w two words.
                currlen += (arr[j] + 1);
                // If limit of characters is violated then no more
                // words can be added to current line.
                if (currlen > k) break;

                // If current word that is added to line is last word of arr then current
                // line is last line. Cost of last line is 0. Else cost is square of extra
                // spaces plus cost of putting line breaks in rest of words from j+1 to n-1.
                if (j == arr_len - 1)
                    cost = 0;
                else
                    cost = (k - currlen) *
                            (k - currlen) +
                            dp[j + 1];

                // Check if this arrangement gives minimum cost for
                // line starting with word arr[i].
                if (cost < dp[i]){
                    dp[i] = cost;
                    ans[i] = j;
                }
            }
        }

        // Print starting index and ending index of words present in each line.
        i = 0;
        while (i < arr_len){
            System.out.printf("%d %d ", (i+1), (ans[i] + 1));
            i = ans[i] + 1;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 2, 5};
        int K = 6;
        solveWordWrap(arr, arr.length, K);
    }
}
