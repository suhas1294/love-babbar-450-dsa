package rishi.atreya._01_arrays;

import rishi.atreya._099_utils.Util;

import java.util.Arrays;

public class _05_SeggregatePositiveNegative {
    public static void main(String[] args) {
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        segregate(arr);
    }
    // alternatively you can use two pointer technique
    static void segregate(int[] arr){
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) Util.swapIndicesOfanArray(arr, i, j);
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
