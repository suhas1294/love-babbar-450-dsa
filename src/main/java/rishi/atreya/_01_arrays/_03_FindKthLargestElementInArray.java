package rishi.atreya._01_arrays;

import java.util.Arrays;

public class _03_FindKthLargestElementInArray {
	public static void main(String[] args) {
		int[] input = { 12, 3, 5, 7, 19 };
		int k = 2;
		Arrays.sort(input);
		System.out.println(input[input.length - k]);
	}
}
