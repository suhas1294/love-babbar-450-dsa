package rishi.atreya._01_arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
  Code and explanation Credits : https://discuss.geeksforgeeks.org/comment/30f851909e43a632507f33bf14340809
  We know minimum value when we add k to whole array---> newMin.
  So we need to find minimum element when we subtract k from whole array
  so while searching for minimum element {arr[i]-k} we should search
  from--->[1,arr.length-1] and similarly for maximum element we should
  search from---> [0,arr.length-2] so that we can check the height
  difference between all pairs of adjacent elements because adjacent
  elements will have small height difference as the array is a sorted one.
*/

public class _09_MinimizeMaxDiffBwHeights {
    static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = (arr[n - 1] + k) - (arr[0] + k); // Maximum possible height difference
        int newMax = arr[n - 1] - k; // Maximum element when we subtract k from whole array
        int newMin = arr[0] + k; // Minimum element when we add k to whole array
        int tempMax, tempMin;
        for (int i = 0; i < n - 1; i++) {
            tempMax = Math.max(newMax, arr[i] + k);
            tempMin = Math.min(newMin, arr[i + 1] - k);
            if (tempMin >= 0) ans = Math.min(ans, tempMax - tempMin);
        }
        return ans;
    }

    public static void main(String[] args) {
        Map<int[], Integer> inputs = new HashMap<>();
        inputs.put(new int[]{1, 15, 10}, 6); // expected 5
        inputs.put(new int[]{1, 5, 8, 10}, 2); // expected 5, {3, 3, 6, 8}
        inputs.put(new int[]{1, 5, 15, 10} , 3); // expected 8, {4, 8, 12, 7}
        inputs.put(new int[]{4, 6}, 10); // expected 2, {14, 16} OR {-6, -4}
        inputs.put(new int[] {6, 10} , 3); // expected 2. {9, 7}
        inputs.put(new int[]{3, 9, 12, 16, 20}, 3); // expected 11 {6, 12, 9, 13, 17}
        inputs.put(new int[]{1, 10, 14, 14, 14, 15}, 6); // expected 5, {7, 4, 8, 8, 8, 9}
        inputs.put(new int[]{1, 2, 3}, 2); // expected 2, {3, 4, 5}
        inputs.put(new int[]{2, 6, 3, 4, 7, 2, 10, 3, 2, 1}, 5); // expected 7

        for (Map.Entry<int[], Integer> pair : inputs.entrySet()) {
            System.out.println(Arrays.toString(pair.getKey()) + "\t" + getMinDiff(pair.getKey(), pair.getValue()));
        }
    }
}
