package rishi.atreya._099_utils;

public class Util {
    public static void swapIndicesOfanArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void reverseArray(int[] arr){
        int left = 0, right = arr.length-1;
        while (left < right){
            swapIndicesOfanArray(arr, left, right);
            left++;
            right--;
        }
    }
    public static void reverseArray(int[] arr, int left, int right){
        while (left < right) {
            swapIndicesOfanArray(arr, left, right);
            left++;
            right--;
        }
    }
}
