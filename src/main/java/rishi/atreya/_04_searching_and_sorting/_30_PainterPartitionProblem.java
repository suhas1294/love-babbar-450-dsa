package rishi.atreya._04_searching_and_sorting;

public class _30_PainterPartitionProblem {
    // function to calculate sum between two indices in array
    static int sum(int arr[], int from, int to){
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    // bottom up tabular dp
    static int findMax(int arr[], int k){
        int dp[][] = new int[k+1][arr.length+1]; // initialize table

        // base cases : k=1
        for (int i = 1; i <= arr.length; i++)
            dp[1][i] = sum(arr, 0, i - 1);

        // base cases  : n=1
        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        // 2 to k partitions
        for (int i = 2; i <= k; i++) { // 2 to n boards
            for (int j = 2; j <= arr.length; j++) {
                int best = Integer.MAX_VALUE; // track minimum
                // i-1 th separator before position arr[p=1..j]
                for (int p = 1; p <= j; p++) {
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            sum(arr, p, j - 1)));
                }
                dp[i][j] = best;
            }
        }
        return dp[k][arr.length]; // required
    }

    public static void main(String args[]){
        int arr[] = { 10, 20, 60, 50, 30, 40 };
        int n = arr.length;
        int k = 3;
        System.out.println(findMax(arr, k));
    }
}
