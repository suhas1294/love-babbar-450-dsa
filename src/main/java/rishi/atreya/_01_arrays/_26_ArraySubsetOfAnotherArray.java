package rishi.atreya._01_arrays;

import java.util.Arrays;
import java.util.HashMap;

public class _26_ArraySubsetOfAnotherArray {
    // note :  {1, 4, 4, 2} is NOT a subset of {1, 4, 2},

    // below method uses sorting and merging technique and works well if arr contains duplicates
    static boolean isSubset(int arr1[], int arr2[]){
        int i = 0, j = 0;
        if (arr1.length < arr2.length) return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (i < arr2.length && j < arr1.length) {
            if (arr1[j] < arr2[i]) j++;
            else if (arr1[j] == arr2[i]) {
                j++; i++;
            } else if (arr1[j] > arr2[i]) return false;
        }
        return i < arr2.length;
    }

    // using hashmap
    static boolean isSubset2(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();
        // Increase the frequency of each element in the frequency table.
        for(int i = 0; i < arr1.length; i++)
            map.put(arr1[i], map.getOrDefault( arr1[i], 0) + 1);
        // Decrease the frequency if the element was found in the frequency table with the
        // frequency more than 0. else return 0 and if loop is completed return 1.
        for(int i = 0; i < arr2.length; i++){
            if (map.getOrDefault(arr2[i], 0) > 0) {
                map.put(arr2[i], map.get(arr1[i]) - 1);
            }else {
                return false;
            }
        }
        return true;
    }
}
