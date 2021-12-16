package rishi.atreya._099_utils;

public class Util {
    public static void swapIndicesOfanArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
