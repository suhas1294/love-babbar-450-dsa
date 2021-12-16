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
    }
    static void swapIndicesOfanArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
