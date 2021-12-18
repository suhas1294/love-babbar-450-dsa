package rishi.atreya._01_arrays;

import rishi.atreya._099_utils.Util;

import java.util.Arrays;

public class _07_RotateArrayByOne {
	public static void main(String[] args) {
		int[] arr = {9, 8, 7, 6, 4, 2, 1, 3};
		rotate2(arr); // expected : 3 9 8 7 6 4 2 1
	}
	static  void rotate(int[] arr){
		int n = arr.length;
		int lastElement = arr[n-1];
		for (int i = n-1; i > 0; i--)
			arr[i] = arr[i-1];
		arr[0] = lastElement;
		System.out.println(Arrays.toString(arr));
	}

	static void rotate2(int[] arr){
		int i = 0, j = arr.length - 1;
		while(i != j){
			Util.swapIndicesOfanArray(arr, i, j);
			i++;
		}
	}
}
