package rishi.atreya._01_arrays;

import java.util.HashSet;
import java.util.Set;

public class _20_SubArrayWithSumZero {
    static boolean checkSum(int arr[]) {
        int n = arr.length;
        Set<Integer> list = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0)
                return true;
            boolean add = list.add(sum);
            if (!add)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkSum(new int[]{4, 2, -3, 1, 6}));
    }
}
