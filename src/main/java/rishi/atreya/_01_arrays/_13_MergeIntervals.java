package rishi.atreya._01_arrays;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start,end;
    Interval(int start, int end){
        this.start=start;
        this.end=end;
    }
}

public class _13_MergeIntervals {
    // optimized solution and also works for unsorted arrays
    public static int[][] merge(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start); // increasing order
        int index = 0; // Stores index of last element in output array (modified arr[])

        for (int i=1; i<intervals.length; i++){
            if (intervals[index].end >= intervals[i].start){ // overlapping with prev one
                // Merge previous and current Intervals
                intervals[index].end = Math.max(intervals[index].end, intervals[i].end);
            }else {
                index++;
                intervals[index] = intervals[i];
            }
        }
        // ans: loop from 0 to index value and print interval's start and end values.

        // optional : transferring result into new array to return it.
        int noOfMergePossible = 0;
        for (int i = 0; i < intervals.length-1; i++)
            if (intervals[i].end >= intervals[i+1].start) noOfMergePossible++;
        int[][] result = new int[intervals.length - noOfMergePossible][2];

        for (int i = 0; i <= index; i++){
            result[i][0] = intervals[i].start;
            result[i][1] = intervals[i].end;
        }
        return result;
    }

    public static void main(String[] args) {
        //int[][] input = {{1,3},{2,6},{8,10},{15,18}}; // [[1,6],[8,10],[15,18]]
        //int[][] input = {{1,3},{2,5},{4,8},{7,10}}; // {1,10}
        // int[][] input = {{1,4},{4,5}}; // {1, 5}
        //int[][] input = {{1,4},{2,3}}; // {1, 4}
        //int[][] input = {{1,4},{0,0}}; // {1, 4}
        //int[][] input = {{2,3},{4,5},{6,7},{8,9},{1,10}}; // {1, 10}
        int[][] input = {{1,3}, {4,6}, {5, 9}, {8,12}, {13,16}, {15, 20}};
        Interval[] intervals = new Interval[input.length];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval(input[i][0], input[i][1]);
        }
        int[][] result = merge(intervals);
        for (int[] row: result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
