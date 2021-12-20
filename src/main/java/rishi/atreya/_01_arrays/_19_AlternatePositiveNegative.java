package rishi.atreya._01_arrays;

import rishi.atreya._099_utils.Util;
import java.util.Arrays;

public class _19_AlternatePositiveNegative {
    public static void fill(int[] arr, int pos) {
        if (pos % 2 == 1) {
            for (int i = 1; i < pos; i += 2)
                Util.swapIndicesOfanArray(arr, i, i + pos);
        }
        else {
            for (int i = 1; i <= pos; i += 2)
                Util.swapIndicesOfanArray(arr, i, (i+ pos -1));
        }
    }

    public static void main(String[] args) {
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int neg = 0, pos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                neg++;
            else
                pos++;
        }

        Arrays.sort(arr);

        if (neg <= pos) {
            fill(arr, neg);
        }
        else {
            Util.reverseArray(arr);
            fill(arr, pos);
        }
        System.out.println(Arrays.toString(arr));
    }
}
