package rishi.atreya._01_arrays;

public class _12_MergeWithoutExtraSpace {
    public static void main(String[] args) {
        /*int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        // expected : 0 1 2 3 5 6 7 8 9*/
        /*int[] arr1 = {10, 12};
        int[] arr2 = {5, 18, 20};
        // expected : 5 10 12 18 20*/
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        // expected : 0 1 2 3 5 6 7 8 9
        merge(arr1, arr2);
    }
    public static void merge(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        while(i < Integer.min(n,m) && j < Integer.min(n,m) ) {
            if (arr1[i] <= arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            }else{
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
        if (i < n){
            for (int k = i; k < n; k++) {
                System.out.print(arr1[k] + " ");
            }
        }else {
            for (int k = j; k < m; k++) {
                System.out.print(arr2[k] + " ");
            }
        }
    }
}
