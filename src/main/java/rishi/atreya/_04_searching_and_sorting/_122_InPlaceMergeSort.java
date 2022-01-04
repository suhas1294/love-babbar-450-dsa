package rishi.atreya._04_searching_and_sorting;

import rishi.atreya._099_utils.Util;

import java.util.Arrays;

public class _122_InPlaceMergeSort {
    // Calculating next gap
    private static int nextGap(int gap){
        if (gap <= 1) return 0;
        return (int)Math.ceil(gap / 2.0);
    }

    // Merging the subarrays using shell sorting Time Complexity: O(nlog n)  Space Complexity: O(1)
    private static void inPlaceMerge(int[] nums, int start, int end){
        int gap = end - start + 1;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
                int j = i + gap;
                if (nums[i] > nums[j]) {
                    Util.swapIndicesOfanArray(nums, i, j);
                }
            }
        }
    }

    // merge sort makes log n recursive calls and each time calls merge()
    // which takes nlog n steps Time Complexity: O(n*log n + 2((n/2)*log(n/2)) + 4((n/4)*log(n/4)) +.....+ 1)
    // Time Complexity: O(logn*(n*log n)) i.e. O(n*(logn)^2)  Space Complexity: O(1)
    private static void mergeSort(int[] nums, int s, int e){
        if (s == e) return;
        int mid = (s + e) / 2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid + 1, e);
        inPlaceMerge(nums, s, e);
    }

    public static void main(String[] args){
        int[] nums = new int[] { 12, 11, 13, 5, 6, 7 };
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
