package rishi.atreya._04_searching_and_sorting;

public class _92_MaxAndMinInArrUsingMinComparisons {
    private static class Pair {
        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int arr_len) {
        Pair minMax = new Pair();
        int i;
        // If array has even number of elements then initialize
        // the first two elements as minimum and maximum
        if (arr_len % 2 == 0) {
            if (arr[0] > arr[1]) {
                minMax.max = arr[0];
                minMax.min = arr[1];
            } else {
                minMax.min = arr[0];
                minMax.max = arr[1];
            }
            i = 2; // set the starting index for loop
        } else { // If array has odd no of elements then initialize the first element as min and max
            minMax.min = arr[0];
            minMax.max = arr[0];
            i = 1; // set the starting index for loop
        }

        // In the while loop, pick elements in pair and compare the pair with max and min so far
        while (i < arr_len - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minMax.max)  minMax.max = arr[i];
                if (arr[i + 1] < minMax.min) minMax.min = arr[i + 1];
            } else {
                if (arr[i + 1] > minMax.max) minMax.max = arr[i + 1];
                if (arr[i] < minMax.min) minMax.min = arr[i];
            }
            i += 2; // Increment the index by 2 as two elements are processed in loop
        }
        return minMax;
    }

    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        Pair minmax = getMinMax(arr, arr.length);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }

}
