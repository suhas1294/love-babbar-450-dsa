package rishi.atreya._04_searching_and_sorting;

import java.util.HashMap;
import java.util.Map;

public class _07_FindRepeatingAndMissing {
    public static void main(String[] args){
        int[] arr = { 4, 3, 6, 2, 1, 1 };
        Map<Integer, Boolean> numberMap= new HashMap<>();
        int max = arr.length;
        for (Integer i : arr) {
            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            }else {
                System.out.println("Repeating = " + i);
            }
        }
        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                System.out.println("Missing = " + i);
            }
        }
    }
}
