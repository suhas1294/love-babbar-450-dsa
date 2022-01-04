package rishi.atreya._04_searching_and_sorting;

import java.util.Arrays;

public class _17_SortArrayCountOfSetBits {
    public static void main(String[] args){
        Integer[] arr = { 1, 2, 3, 4, 5, 6 };
        Arrays.sort(arr, (n1, n2) -> Integer.bitCount(n1) <= Integer.bitCount(n2) ? 1 : -1);
        System.out.println(Arrays.toString(arr));
    }
}
