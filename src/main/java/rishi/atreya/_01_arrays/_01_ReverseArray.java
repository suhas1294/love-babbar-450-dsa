package rishi.atreya._01_arrays;

import rishi.atreya._099_utils.Util;

public class _01_ReverseArray {
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};

		int start = 0;
		int end = input.length -1 ; // -1 because 0 based indexing

		while (start < end){
			Util.swapIndicesOfanArray(input, start, end);
			start++;
			end--;
		}

		for (int j : input) { System.out.print(j + "\t"); }
	}

	// alternate solution using recursive way
	static void reverseArray(int[] arr, int start, int end){
		if (start >= end)
			return;
		Util.swapIndicesOfanArray(arr, start, end);
		reverseArray(arr, start+1, end-1);
	}
}