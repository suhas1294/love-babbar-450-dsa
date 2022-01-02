package rishi.atreya._03_strings;

import rishi.atreya._099_utils.Util;

import java.util.Arrays;

public class _60_NextGrtNoPermutation {
    static int[] nextPermutation(int[] arr){
        int n = arr.length;
        if (n == 1) return arr;
        // Start from the right most digit and find the first digit that is
        // smaller than the digit next to it.
        int i = 0;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) break;
        }

        // If there is a possibility of a next greater element
        if (i != 0){
            // Find the smallest digit on right side of (i-1)'th
            // digit that is greater than number[i-1]
            for (int j = n - 1; j >= i; j--){
                if (arr[i - 1] < arr[j]){
                    // Swap the found smallest digit i.e. arr[j] with arr[i-1]
                    Util.swapIndicesOfanArray(arr, i-1, j);
                    break;
                }
            }
        }

        // Reverse the digits after (i-1) because the digits
        // after (i-1) are in decreasing order and thus we will
        // get the smallest element possible from these digits
        int[] arr_1 = Arrays.copyOfRange(arr, 0, i);
        int[] arr_2 = Arrays.copyOfRange(arr, i, arr.length);
        Util.reverseArray(arr_2);
        int[] result = Util.concatArrays(arr_1, arr_2);
        // If i is 0 that means elements are in decreasing order Therefore, no greater
        // element possible then we just return the lowest possible order/element formed from
        // these digits by just reversing the vector
        return result;
    }
}
