package rishi.atreya._04_searching_and_sorting;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

public class _15_AllSubArrayWithZeroSum {
    @AllArgsConstructor
    private static class Pair{ int first, second;}

    static ArrayList<Pair> findSubArrays(int[] arr, int n){
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        // arraylist to store subarray starting and ending index
        ArrayList<Pair> result = new ArrayList<>();
        int sum = 0; // Maintains sum of elements so far
        for (int i = 0; i < n; i++){
            sum += arr[i]; // add current element to sum

            // if sum is 0, we found a subarray starting from index 0 and ending at index i
            if (sum == 0) {
                result.add(new Pair(0, i));
            }
            ArrayList<Integer> list = new ArrayList<>();

            // If sum already exists in the map there exists at-least
            // one subarray ending at index i with 0 sum
            if (map.containsKey(sum)){
                // map[sum] stores starting index of all subarrays
                list = map.get(sum);
                for (int it = 0; it < list.size(); it++){
                    result.add(new Pair(list.get(it) + 1, i));
                }
            }
            list.add(i);
            map.put(sum, list);
        }
        return result;
    }

    // Utility function to print all subarrays with sum 0
    static void print(ArrayList<Pair> out){
        for (int i = 0; i < out.size(); i++){
            Pair p = out.get(i);
            System.out.printf("Subarray found from Index %d to %d\n", p.first, p.second);
        }
    }

    public static void main(String args[]){
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        ArrayList<Pair> out = findSubArrays(arr, arr.length);
        // if we did not find any subarray with 0 sum, then subarray does not exists
        if (out.size() == 0)
            System.out.println("No subarray exists");
        else
            print(out);
    }
}
