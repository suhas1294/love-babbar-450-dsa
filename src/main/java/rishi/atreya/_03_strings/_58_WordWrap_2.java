package rishi.atreya._03_strings;

// ref: https://www.geeksforgeeks.org/word-wrap-problem-dp-19/
public class _58_WordWrap_2 {
    // dynamic solution approach in  Cormen book
    static final int MAX = Integer.MAX_VALUE;
    static int printSolution (int p[], int n){
        int k;
        if (p[n] == 1) k = 1;
        else k = printSolution (p, p[n]-1) + 1;
        System.out.println("Line number" + " " + k + ": " +
                "From word no." +" "+ p[n] + " " + "to" + " " + n);
        return k;
    }
    static void solveWordWrap (int arr[], int arr_len, int K){
        // For simplicity, 1 extra space is used in all below arrays
        // extras[i][j] will have number of extra spaces if words from i
        // to j are put in a single line
        int extras[][] = new int[arr_len+1][arr_len+1];

        // lc[i][j] will have cost of a line which has words from i to j
        int lc[][]= new int[arr_len+1][arr_len+1];
        // c[i] will have total cost of optimal arrangement of words from 1 to i
        int c[] = new int[arr_len+1];
        int p[] =new int[arr_len+1]; // p[] is used to print the solution.

        // calculate extra spaces in a single line. The value extra[i][j]
        // indicates extra spaces if words from word number i to j are
        // placed in a single line
        for (int i = 1; i <= arr_len; i++){
            extras[i][i] = K - arr[i-1];
            for (int j = i+1; j <= arr_len; j++)
                extras[i][j] = extras[i][j-1] - arr[j-1] - 1;
        }

        // Calculate line cost corresponding to the above calculated extra
        // spaces. The value lc[i][j] indicates cost of putting words from
        // word number i to j in a single line
        for (int i = 1; i <= arr_len; i++){
            for (int j = i; j <= arr_len; j++){
                if (extras[i][j] < 0)
                    lc[i][j] = MAX;
                else if (j == arr_len && extras[i][j] >= 0)
                    lc[i][j] = 0;
                else
                    lc[i][j] = extras[i][j]*extras[i][j];
            }
        }

        // Calculate minimum cost and find minimum cost arrangement.
        // The value c[j] indicates optimized cost to arrange words
        // from word number 1 to j.
        c[0] = 0;
        for (int j = 1; j <= arr_len; j++){
            c[j] = MAX;
            for (int i = 1; i <= j; i++){
                if (c[i-1] != MAX && lc[i][j] != MAX &&
                        (c[i-1] + lc[i][j] < c[j]))
                {
                    c[j] = c[i-1] + lc[i][j];
                    p[j] = i;
                }
            }
        }
        printSolution(p, arr_len);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 2, 5};
        int K = 6;
        solveWordWrap (arr, arr.length, K);
    }
}
