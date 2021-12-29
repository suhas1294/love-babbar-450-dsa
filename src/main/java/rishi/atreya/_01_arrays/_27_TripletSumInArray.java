package rishi.atreya._01_arrays;

import java.util.Arrays;

public class _27_TripletSumInArray {
    static boolean find3Numbers(int arr[], int sum){
        int left, right;
        Arrays.sort(arr);
        // Now fix the first element one by one and find the other two elements
        for (int i = 0; i < arr.length - 2; i++) {
            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each other
            left = i + 1; // index of the first element in the remaining elements
            right = arr.length - 1; // index of the last element
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] == sum) {
                    System.out.print("Triplet is " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    return true;
                } else if (arr[i] + arr[left] + arr[right] < sum) {
                    left++;
                } else{ // A[i] + A[l] + A[r] > sum
                    right--;
                }
            }
        }
        return false; // If we reach here, then no triplet was found
    }
}
