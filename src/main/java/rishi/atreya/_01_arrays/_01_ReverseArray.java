package rishi.atreya._01_arrays;

public class _01_ReverseArray {
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};

		int start = 0;
		int end = input.length -1 ; // -1 because 0 based indexing
		int temp;

		while (start < end){
			temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}

		for (int j : input) { System.out.print(j + "\t"); }
	}
	// recursive way
	static void reverseArray(int[] arr, int start, int end){
		int temp;
		if (start >= end)
			return;
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverseArray(arr, start+1, end-1);
	}
}