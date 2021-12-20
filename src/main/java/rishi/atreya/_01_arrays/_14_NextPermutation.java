package rishi.atreya._01_arrays;
import rishi.atreya._099_utils.Util;
import java.util.Arrays;

//credits : https://www.programcreek.com/2014/06/leetcode-next-permutation-java/
public class _14_NextPermutation {
    public static void nextPermutation(int[] nums) {
        int mark = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                mark = i - 1;
                break;
            }
        }

        if (mark == -1) {
            Util.reverseArray(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
            return;
        }

        int idx = nums.length-1;
        for (int i = nums.length-1; i >= mark+1; i--) {
            if (nums[i] > nums[mark]) {
                idx = i;
                break;
            }
        }

        Util.swapIndicesOfanArray(nums, mark, idx);
        Util.reverseArray(nums, mark + 1, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        nextPermutation( new int[]{1,2, 3}); // [1,3,2]
        nextPermutation( new int[]{3, 2, 1}); // [1,2,3]
        nextPermutation( new int[]{1, 1 ,5}); // [1,5,1]
    }

}
