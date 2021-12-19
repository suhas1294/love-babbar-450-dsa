package rishi.atreya._01_arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 1 <= n <= 105
 nums.length == n + 1
 1 <= nums[i] <= n
 All the integers in nums appear only once except for precisely one integer which
 appears two or more times.
 How can we prove that at least one duplicate number must exist in nums?

 */
public class _11_FindDuplicateNumberInArray {
    public static void main(String[] args) {
        Map<int[], Integer> inputs = new HashMap<>();
        inputs.put(new int[]{1,3,4,2,2}, 2);
        inputs.put(new int[]{3,1,3,4,2}, 3);
        inputs.put(new int[]{1,1}, 1);
        inputs.put(new int[]{1,1, 2}, 1);
        Iterator<Map.Entry<int[], Integer>> iterator = inputs.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<int[], Integer> pair = iterator.next();
            int answer = getDuplicateNumber(pair.getKey());
            if (answer != pair.getValue()) System.out.println("failed for input :" + Arrays.toString(pair.getKey()));
        }
    }

    static int getDuplicateNumber(int[] nums){
        int maxNo = nums.length-1;
        int total = (maxNo * nums.length)/2;
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if (total < 0) return nums[i-1];
            if (total == 0) return nums[i+1];
        }
        return 0;
    }
}
