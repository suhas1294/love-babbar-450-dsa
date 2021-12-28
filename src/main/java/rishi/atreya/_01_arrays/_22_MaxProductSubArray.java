package rishi.atreya._01_arrays;

public class _22_MaxProductSubArray {
    static int maxSubarrayProduct(int arr[], int n) {
        int curMax = arr[0];
        int curMin = arr[0];
        int max_so_far = arr[0];
	    /* Traverse through the array. the maximum product subarray ending at an index
        will be the maximum of the element itself, the product of element and max product
        ending previously and the min product ending previously. */
        for (int i = 1; i < n; i++){
            int temp = Math.max(arr[i], Math.max(arr[i] * curMax, arr[i] * curMin));
            curMin = Math.min(arr[i], Math.min(arr[i] * curMax, arr[i] * curMin));
            curMax = temp;
            max_so_far = Math.max(max_so_far, curMax);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        System.out.println(maxSubarrayProduct(arr, arr.length));
    }
}
