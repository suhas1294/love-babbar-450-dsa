package rishi.atreya._099_utils;

import rishi.atreya._05_linkedlist._125_ReverseLinkedlistInKGroup;


public class Util {
    public static <T> void swapIndicesOfArray(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for primitives array
    public static void swapIndicesOfanArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void swapIndicesOfanArray(char[] arr, int a, int b){
        char temp = arr[a];
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

    public static void printAsciiValues(String s){
        char[] charArr = s.toCharArray();
        for (char c: charArr) {
            System.out.print(c + " : " + (int) c + "\t");
        }
    }

    public static int[] concatArrays(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length-1; i++) {
            result[i] = a[i];
        }
        for (int i = a.length; i < result.length-1; i++) {
            result[i] = b[i];
        }
        return result;
    }
}
