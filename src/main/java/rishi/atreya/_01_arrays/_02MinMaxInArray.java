package rishi.atreya._01_arrays;

import java.util.Arrays;

public class _02MinMaxInArray {
	public static void main(String[] args) {
		int[] input = {1000, 11, 445, 1, 330, 3000};
		int[] output = getMinMax(input, 0, input.length-1);
		System.out.printf("min : %d : max : %d", output[0], output[1]);
	}

	private static int[] getMinMax(int[] input, int low, int high) {
		System.out.println(Arrays.toString(input) +  " low : " + low + " high : " + high);
		if (low == high) return new int[]{input[0], input[0]}; // only one element
		if (high == low + 1) return new int[]{Math.min(input[0], input[1]), Math.max(input[0], input[1])}; // only two elements

		int mid = (low + high)/2;
		int[] firstHalfResult = getMinMax(input, low, mid-1);
		int[] secondHalfResult = getMinMax(input, mid, high);
		int finalMin = Math.min(firstHalfResult[0], secondHalfResult[0]);
		int finalMax = Math.min(firstHalfResult[1], secondHalfResult[1]);
		return new int[]{finalMin, finalMax};
	}
}
