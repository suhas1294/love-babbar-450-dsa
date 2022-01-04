package rishi.atreya._04_searching_and_sorting;

import java.util.Arrays;

public class _16_ProductOfArrayPuzzle {
    public static long[] productExceptSelf(int arr[]){
        long prod = 1;
        long flag = 0;

        // product of all elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) // // counting number of elements which have value 0
                flag++;
            else
                prod *= arr[i];
        }

        // creating a new array of size n
        long result[] = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (flag > 1) {
                // if number of elements in array with value 0 is more
                // than 1 than each value in new array will be equal to 0
                result[i] = 0;
            }else if (flag == 0) {
                // if no element having value 0 than we will insert product/a[i] in new array
                result[i] = (prod / arr[i]);
            }else if (flag == 1 && arr[i] != 0) {
                // if 1 element of array having value 0 than all the
                // elements except that index value , will be equal to 0
                result[i] = 0;
            }else { // if(flag == 1 && a[i] == 0)
                result[i] = prod;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] arr = { 10, 3, 5, 6, 2 };
        long[] ans;
        ans = productExceptSelf(arr);
        System.out.println(Arrays.toString(ans));
    }
}
