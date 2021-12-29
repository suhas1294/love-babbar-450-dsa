package rishi.atreya._01_arrays;

public class _32_MinimumSwapsAndKTogether {
    static int minSwap(int arr[], int n, int k) {
        // Find count of elements which are less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] <= k) ++count;
        }
        // Find unwanted elements in current window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i) {
            if (arr[i] > k) ++bad;
        }
        // Initialize answer with 'bad' value of current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {
            if (arr[i] > k) --bad; // Decrement count of previous window
            if (arr[j] > k) ++bad; // Increment count of current window
            // Update ans if count of 'bad' is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.println(minSwap(arr, n, k));
    }
}
