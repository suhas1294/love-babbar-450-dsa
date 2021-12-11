package rishi.atreya._01_arrays;

public class _01ReverseArray {
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		int start = 0;
		int end = input.length -1 ; // -1 because 0 based indexing
		int temp;
		while (start < end)
		{
			temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "\t");
		}
	}
}