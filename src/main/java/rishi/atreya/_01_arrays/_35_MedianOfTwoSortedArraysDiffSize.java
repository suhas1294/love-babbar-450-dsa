package rishi.atreya._01_arrays;

public class _35_MedianOfTwoSortedArraysDiffSize {
    static double getMedian(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        if (m > n) return getMedian(arr2, arr1); // Swapping to make A smaller

        int start = 0;
        int end = m;
        int realMidInMergedArr = (m + n + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realMidInMergedArr - mid;
            int leftA
                    = (leftAsize > 0)
                    ? arr1[leftAsize - 1]
                    : Integer.MIN_VALUE; // checking overflow of indices
            int leftB
                    = (leftBsize > 0) ? arr2[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA
                    = (leftAsize < m) ? arr1[leftAsize] : Integer.MAX_VALUE;
            int rightB
                    = (leftBsize < n) ? arr2[leftBsize] : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB)
                    ) / 2.0;
                }
                return Math.max(leftA, leftB);
            }else if (leftA > rightB) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return 0.0;
    }
}
