package rishi.atreya._01_arrays;

import java.util.HashSet;
import java.util.Set;

public class _06_UnionOfTwoUnsortedArrays {
	public static void main(String[] args) {
			int[] a = {1, 2, 3, 4, 5};
			int[] b = {6,7};
			System.out.println(doUnion(a, a.length, b, b.length));
	}
	// Using hashset, alternatively hashmap can also be used.
	public static int doUnion(int[] a, int[] b){
		Set<Integer> set1 = new HashSet<>();
		for (int element : a)
			set1.add(element);
		for (int element : b)
			set1.add(element);
		return (set1.size());
	}
	// time complexity : O(N) space complexity increases with this approach
	// using array index as hash value
	public static int doUnion(int a[], int n, int b[], int m){
		int highestInArr1 = Integer.MIN_VALUE;
		int highestInArr2 = Integer.MIN_VALUE;

		for(int i = 0; i < n; i++)
			if (a[i] > highestInArr1) highestInArr1 = a[i];
		for(int i = 0; i < m; i++)
			if (b[i] > highestInArr2) highestInArr2 = b[i];

		boolean[] presenceArray = new boolean[Integer.max(highestInArr1, highestInArr2) + 1];

		for (int i = 0; i < n; i++)
			presenceArray[a[i]] = true;

		for (int i = 0; i < m; i++)
			presenceArray[b[i]] = true;

		int count = 0;
		for (boolean value : presenceArray) if (value) count++;
		return count;
	}
}
