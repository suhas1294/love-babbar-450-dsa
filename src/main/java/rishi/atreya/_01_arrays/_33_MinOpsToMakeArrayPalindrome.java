package rishi.atreya._01_arrays;

public class _33_MinOpsToMakeArrayPalindrome {
    static int findMinOps(int[] arr, int n) {
        int ans = 0;
        for (int i=0,j=n-1; i<=j;){ // Start from two corners
            // If corner elements are same,
            // problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j]) {
                i++; j--;
            }
            // If left element is greater, then
            // we merge right two elements
            else if (arr[i] > arr[j]){ // need to merge from tail.
                j--;
                arr[j] += arr[j+1] ;
                ans++;
            }else{ // Else we merge left two elements
                i++;
                arr[i] += arr[i-1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 4, 5, 9, 1} ;
        System.out.println("Count of minimum operations is "+ findMinOps(arr, arr.length));
    }
}
