package rishi.atreya._01_arrays;

public class _30_SmallestSubArrayWithSumGTK {

    // does not work with negative numbers
    static int smallestSubWithSum(int[] arr, int x) {
        int curr_sum = 0, min_len = arr.length + 1;
        int start = 0, end = 0;
        while (end < arr.length) {
            // Keep adding array elements while current sum is smaller than or equal to x
            while (curr_sum <= x && end < arr.length) {
                curr_sum += arr[end++];
            }
            // If current sum becomes greater than x.
            while (curr_sum > x && start < arr.length) {
                // Update minimum length if needed
                if (end - start < min_len) min_len = end - start;
                curr_sum -= arr[start++]; // remove starting elements
            }
        }
        return min_len;
    }

    // solution for negative numbers using constant space
    static void subArraySum(int arr[], int n, int sum){
        int minEle = Integer.MAX_VALUE;
        // Find minimum element in the array
        for (int i = 0; i < n; i++) {
            minEle = Math.min(arr[i], minEle);
        }

        // Initialize curr_sum as value of
        // first element and starting point as 0
        int curr_sum = arr[0] + Math.abs(minEle);
        int start = 0, i;

        // Starting window length will be 1, For generating new target sum,
        // add abs(minEle) to sum only 1 time
        int targetSum = sum;

        // Add elements one by one to curr_sum
        // and if the curr_sum exceeds the
        // updated sum, then remove starting element
        for (i = 1; i <= n; i++){
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum - (i - start) *
                    Math.abs(minEle) > targetSum &&
                    start < i)
            {
                curr_sum = curr_sum - arr[start] - Math.abs(minEle);
                start++;
            }

            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum - (i - start) *
                    Math.abs(minEle) == targetSum)
            {
                System.out.println("Sum found between indexes " + start + " and " + (i - 1));
                return;
            }

            // Add this element to curr_sum
            if (i < n){
                curr_sum = curr_sum + arr[i] +  Math.abs(minEle);
            }
        }

        // If we reach here, then no subarray
        System.out.println("No subarray found");
    }

    // naive solution
    int smallestSubWithSum(int arr[], int n, int x) {
        //  Initialize length of smallest subarray as n+1
        int min_len = n + 1;

        // Pick every element as starting point
        for (int start=0; start<n; start++){
            // Initialize sum starting with current start
            int curr_sum = arr[start];

            // If first element itself is greater
            if (curr_sum > x) return 1;

            // Try different ending points for current start
            for (int end=start+1; end<n; end++){
                curr_sum += arr[end]; // add last element to current sum
                // If sum becomes more than x and length of this subarray is smaller than
                // current smallest length, update the smallest length (or result)
                if (curr_sum > x && (end - start + 1) < min_len) {
                    min_len = (end - start + 1);
                }
            }
        }

        return min_len;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 45, 6, 10, 19 };
        int x = 51;
        int res1 = smallestSubWithSum(arr1, x);
        if (res1 == arr1.length + 1)
            System.out.println("Not Possible");
        else
            System.out.println(res1);
    }
}
