package rishi.atreya._04_searching_and_sorting;

import rishi.atreya._099_utils.Util;

import java.util.Arrays;
import java.util.HashMap;

public class _18_MinSwapsToSortArr {
    public static int minSwaps(int[] arr){
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        HashMap<Integer, Integer> h= new HashMap<>(); // stores the indexes of the input array
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++){
            h.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++){
            // check whether the current element is at the right place
            if (arr[i] != temp[i]){
                ans++;
                int init = arr[i];
                // If not, swap this element with the index of the element which should come here
                Util.swapIndicesOfanArray(arr, i, h.get(temp[i]));
                // Update the indexes in the hashmap accordingly
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 101, 758, 315, 730, 472, 619, 460, 479 };
        System.out.println(minSwaps(a)); //5
    }
}
