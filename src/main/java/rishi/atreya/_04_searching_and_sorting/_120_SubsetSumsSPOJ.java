package rishi.atreya._04_searching_and_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

// question: https://www.spoj.com/problems/SUBSUMS/
// solution credits: https://chandniverma.blogspot.com/2020/07/spoj-subsums-subset-sums.html

public class _120_SubsetSumsSPOJ {
    public class Main {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();

            int arr[] = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }
            sc.close();

            System.out.println(getCountOfSubsets(arr, A, B));
        }

        private static long getCountOfSubsets(int[] arr, int a, int b) {
            Integer[] firstSubsetSums = getSubsetSums(arr, 0, arr.length/2);
            Integer[] secondSubsetSums = getSubsetSums(arr, arr.length/2+1, arr.length-1);
            Arrays.sort(secondSubsetSums);

            long count = 0;
            for(int i=0; i<firstSubsetSums.length; i++) {
                int p = findLastIdxWithFalsePredicate(secondSubsetSums, a-firstSubsetSums[i], (sum, mark)->sum>=mark);
                int q = findLastIdxWithFalsePredicate(secondSubsetSums, b-firstSubsetSums[i], (sum, mark)->sum>mark);
                count += (q-p);
            }

            return count;
        }

        private static int findLastIdxWithFalsePredicate(Integer[] sums, int val, BiPredicate<Integer, Integer> pred) {
            int min = 0;
            int max = sums.length-1;
            while (min<max) {
                int mid = min + (max-min+1)/2;
                if (pred.test(sums[mid], val)) {
                    max = mid-1;
                } else {
                    min = mid;
                }
            }
            if (pred.test(sums[min], val))
                return -1;
            return min;
        }

        private static Integer[] getSubsetSums(int[] arr, int st, int end) {
            List<Integer> sums = new ArrayList<>();
            generateSubsetSumsRecur(arr, st, end, st, 0, sums);
            return sums.toArray(new Integer[0]);
        }

        private static void generateSubsetSumsRecur(int[] arr, int st, int end, int index, int runningSum, List<Integer> sums) {
            if (index == end+1) {
                sums.add(runningSum);
                return;
            }
            generateSubsetSumsRecur(arr, st, end, index+1, runningSum+arr[index], sums);
            generateSubsetSumsRecur(arr, st, end, index+1, runningSum, sums);
        }
    }
}
/**
 * The complexity of the above code is:
 * O(2^(N/2) + 2^(N/2)*(lg (2^(N/2))))
 * = O(2^(N/2) + 2^(N/2)*N/2)
 * = O(N*2^(N/2))
 */
