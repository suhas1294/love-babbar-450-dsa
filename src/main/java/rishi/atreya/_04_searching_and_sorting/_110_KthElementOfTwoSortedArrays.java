package rishi.atreya._04_searching_and_sorting;

import java.util.Arrays;

public class _110_KthElementOfTwoSortedArrays {
    static int kth(int arr1[], int arr1_len, int arr2[], int arr2_len, int k){
        if (k > (arr1_len + arr2_len) || k < 1) return -1;
        if (arr1_len > arr2_len) return kth(arr2, arr2_len, arr1, arr1_len, k);

        // Check if arr1 is empty returning k-th element of arr2
        if (arr1_len == 0) return arr2[k - 1];

        // Check if k = 1 return minimum of first two elements of both arrays
        if (k == 1) return Math.min(arr1[0], arr2[0]);

        // Now the divide and conquer part
        int i = Math.min(arr1_len, k / 2);
        int j = Math.min(arr2_len, k / 2);

        if (arr1[i - 1] > arr2[j - 1]) {
            // Now we need to find only k-j th element since we have found out the lowest j
            int temp[] = Arrays.copyOfRange(arr2, j, arr2_len);
            return kth(arr1, arr1_len, temp, arr2_len - j, k - j);
        }

        // Now we need to find only k-i th element since we have found out the lowest i
        int temp[] = Arrays.copyOfRange(arr1, i, arr1_len);
        return kth(temp, arr1_len - i, arr2, arr2_len, k - i);
    }

    public static void main(String[] args){
        int arr1[] = { 2, 3, 6, 7, 9 };
        int arr2[] = { 1, 4, 8, 10 };
        int k = 5;
        int ans = kth(arr1, arr1.length, arr2, arr2.length, k);
        if (ans == -1)
            System.out.println("Invalid query");
        else
            System.out.println(ans);
    }
}
