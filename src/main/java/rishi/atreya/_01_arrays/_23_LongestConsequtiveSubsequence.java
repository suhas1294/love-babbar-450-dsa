package rishi.atreya._01_arrays;

import java.util.HashSet;

public class _23_LongestConsequtiveSubsequence {
    static int findLongestConseqSubseq(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; ++i) set.add(arr[i]);
        // check each possible sequence from the start then update optimal length
        for (int i = 0; i < n; ++i) {
            System.out.printf("\ni = %d, a[i]= j = %d, a[i]-1 = %d, set has %d ? %b\t",
                    i, arr[i], arr[i]-1, arr[i], set.contains(arr[i]-1), ans );
            // if current element is the starting element of a sequence
            if (!set.contains(arr[i] - 1)) {
                // Then check for next elements in the sequence
                int j = arr[i];
                while (set.contains(j)) j++;
                ans = Math.max(ans, j - arr[i]);
                System.out.printf("ans = %d", ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Length of the Longest contiguous subsequence is " +
                findLongestConseqSubseq(new int[]{1, 9, 3, 10, 4, 20, 2}, 7));
    }
}
