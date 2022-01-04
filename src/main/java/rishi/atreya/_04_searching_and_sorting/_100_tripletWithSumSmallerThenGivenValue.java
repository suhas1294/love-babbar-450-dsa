package rishi.atreya._04_searching_and_sorting;

import java.util.Arrays;

public class _100_tripletWithSumSmallerThenGivenValue {
    static int countTriplets(int[] arr, int sum){
        Arrays.sort(arr);
        int ans = 0;
        // Every iteration of loop counts triplet with first element as arr[i].
        for (int i = 0; i < arr.length - 2; i++){
            // Initialize other two elements as corner elements  of subarray arr[j+1..k]
            int j = i + 1, k = arr.length - 1;
            while (j < k){ // Use Meet in the Middle concept
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                }else{ // Else move left corner
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    ans += (k - j);
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int arr[] = new int[]{5, 1, 3, 4, 7};
        int sum = 12;
        System.out.println(countTriplets(arr, sum));
    }
}
