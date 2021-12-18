package rishi.atreya._01_arrays;

import rishi.atreya._099_utils.MaxSubArrResult;

import java.util.Arrays;

public class _08_KadanesAlgo {
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		MaxSubArrResult result = maxSubArraySumWithArray(arr);
		System.out.println("Sub Array: " + Arrays.toString(result.subArray()));
		System.out.println("Max sum: " + result.maxSum());
	}

	static int maxSubArraySum(int[] arr){
		int maxSum = Integer.MIN_VALUE, curSum = 0;
		for (int num : arr) {
			curSum += num;
			if (maxSum < curSum) maxSum = curSum;
			if (curSum < 0) curSum = 0;
		}
		return maxSum;
	}

	// this handles when array is full of negative integers
	static int maxSubArraySum2(int[] arr){
		int maxSum = arr[0];
		int curSum = arr[0];
		for (int i = 1; i < arr.length; i++){
			curSum = Math.max(arr[i], curSum+arr[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}

	// this will return array indices as well i.e., start and end of sub array with max sum
	static MaxSubArrResult maxSubArraySumWithArray(int[] arr){
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0, start = 0, end = 0, s = 0;
		for (int i = 0; i < arr.length; i++){
			curSum += arr[i];
			if (maxSum < curSum) {
				maxSum = curSum;
				start = s;
				end = i;
			}
			if (curSum < 0) {
				curSum = 0;
				s = i+1;
			}
		}
		return new MaxSubArrResult(Arrays.copyOfRange(arr, start, end+1), maxSum);
	}
}


/*

array = {1,2,3,-2,5}
all sub arrays (of contiguous block):

{1}
{1,2}			{2}
{1,2,3}			{2,3}		{3}
{1,2,3,-2}		{2,3,-2}	{3,-2}		{-2}
{1,2,3,-2,5}	{2,3,-2,5}	{3,-2,5}	{-2,5}	{5}

*/