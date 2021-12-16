package rishi.atreya._01_arrays;

import java.util.Arrays;

public class _04_Sort012 {
    public static void main(String[] args) {
        int[] input = {0, 2, 1, 2, 0};
        int lo = 0;
        int hi = input.length - 1;
        int mid = 0;

        while (mid <= hi) {
            switch (input[mid]) {
                case 0: {
                    swapIndicesOfanArray(input, lo, mid);
                    lo++; mid++; break;
                }
                case 1:
                    mid++; break;
                case 2: {
                    swapIndicesOfanArray(input, mid, hi);
                    hi--; break;
                }
            }
        }
        System.out.println(Arrays.toString(input));

        // sorting 0's and 1's
        int[] arr = {0, 1, 0, 1, 1, 1};
        sort01(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swapIndicesOfanArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sort01(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 1) {
                swapIndicesOfanArray(arr, left, right);
                right--;
            } else {
                left++;
            }
        }
    }
}
