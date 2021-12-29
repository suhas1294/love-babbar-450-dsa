package rishi.atreya._01_arrays;

import rishi.atreya._099_utils.Util;

public class _31_ThreeWayPartitioning {
    public static void threeWayPartition(int[] arr, int lowVal, int highVal){
        int  n = arr.length;
        // Initialize ext available positions for
        // smaller (than range) and greater elements
        int start = 0, end = n-1;
        for(int i = 0; i <= end;){
            // If current element is smaller than range, put it on
            // next available smaller position.
            if(arr[i] < lowVal){
                Util.swapIndicesOfanArray(arr, start, i);
                start++;
                i++;
            }else if(arr[i] > highVal){
                // If current element is greater than range, put it on
                // next available greater position.
                Util.swapIndicesOfanArray(arr, end, i);
                end--;
            }else {
                i++;
            }
        }

    }
}
