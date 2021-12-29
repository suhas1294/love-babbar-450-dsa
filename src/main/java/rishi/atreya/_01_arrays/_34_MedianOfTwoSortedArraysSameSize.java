package rishi.atreya._01_arrays;

import rishi.atreya._099_utils.Util;

import java.util.Arrays;

public class _34_MedianOfTwoSortedArraysSameSize {
    // log(N) solution
    static int getMedian( int[] a, int[] b, int startA, int startB, int endA, int endB) {
        if (endA - startA == 1) {
            return (
                    Math.max(a[startA], b[startB]) +
                    Math.min(a[endA], b[endB])
            ) / 2;
        }
        int m1 = median(a, startA, endA); //median of the first array
        int m2 = median(b, startB, endB); // median of the second array
        if (m1 == m2) return m1;
        if (m1 < m2) { /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
            return getMedian(
                    a, b, (endA + startA + 1) / 2,
                    startB, endA,
                    (endB + startB + 1) / 2);
        }else { /*if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...]*/
            return getMedian(
                    a, b, startA,
                    (endB + startB + 1) / 2,
                    (endA + startA + 1) / 2, endB);
        }
    }
    static int median( int[] arr, int start, int end){
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (
                    arr[start + (n / 2)]
                    + arr[start + (n / 2 - 1)]
            )/ 2;
        }else {
            return arr[start + n / 2];
        }
    }

    // NlogN solution :  By taking union w/o extra space
    public static int getMedian(int arr1[], int arr2[]){
        int left = 0;
        int right = arr1.length - 1;
        while (arr1[right] > arr2[left] && left < arr1.length && right > -1){
            int temp = arr1[right];
            arr1[right] = arr2[left];
            arr2[left] = temp;
            right--; left++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return (arr1[arr1.length - 1] + arr2[0]) / 2;
    }
}
