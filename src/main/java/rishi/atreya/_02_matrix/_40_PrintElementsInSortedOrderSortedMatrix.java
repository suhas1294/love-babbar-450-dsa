package rishi.atreya._02_matrix;

import java.util.PriorityQueue;
import java.util.Queue;

public class _40_PrintElementsInSortedOrderSortedMatrix {
    public int[][] sortMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Entry> maxPq = new PriorityQueue<>(rows);

        for (int r = 0; r < rows; r++) {
            int c = findMax(matrix[r]);
            maxPq.add(new Entry(matrix[r][c], r, c, c));
        }

        int[][] sorted = new int[rows][cols];

        for (int i = 0; !maxPq.isEmpty(); i++) {
            Entry e = maxPq.poll();
            sorted[i / cols][i % cols] = e.val;
            int c = Math.floorMod(e.c - 1, cols); // wrap around
            if (c != e.init) {
                maxPq.add(new Entry(matrix[e.r][c], e.r, c, e.init));
            }
        }
        return sorted;
    }

    private int findMax(int[] arr) { // binary search
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (arr[mid] > arr[lo]) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static class Entry implements Comparable<Entry> {
        int val, r, c, init;

        Entry(int val, int r, int c, int init) {
            this.val = val;
            this.r = r;
            this.c = c;
            this.init = init;
        }

        public int compareTo(Entry that) {
            return Integer.compare(that.val, this.val);
        }
    }
}
// Time complexity: O(rows * cols * log(rows)).
// Space complexity: O(rows * cols).