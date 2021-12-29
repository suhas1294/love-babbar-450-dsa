package rishi.atreya._01_arrays;

import java.util.Arrays;

public class _29_ChocolateDistribution {
    static int findMinDiff(int arr[], int noOfStudents){
        // if there are no chocolates or number of students is 0
        if (noOfStudents == 0 || arr.length == 0) return 0;
        Arrays.sort(arr);
        // Number of students cannot be more than number of packets
        if (arr.length < noOfStudents) return -1;
        int min_diff = Integer.MAX_VALUE; // Largest number of chocolates

        // Find the subarray of size m such that difference between
        // last (maximum in case of sorted) and first (minimum in case
        // of sorted) elements of subarray is minimum.
        for (int i = 0; i + noOfStudents - 1 < arr.length; i++){
            int diff = arr[i+noOfStudents-1] - arr[i];
            if (diff < min_diff) min_diff = diff;
        }
        return min_diff;
    }

    public static void main(String[] args){
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;  // Number of students
        System.out.println("Minimum difference is " + findMinDiff(arr, m));
    }
}
