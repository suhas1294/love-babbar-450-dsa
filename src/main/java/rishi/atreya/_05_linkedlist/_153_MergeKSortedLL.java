package rishi.atreya._05_linkedlist;

// Divide and Conquer
// using minHeap: https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/

public class _153_MergeKSortedLL {
    // Takes two lists sorted in increasing order, and merge their nodes together to
    // make one big sorted list. Below function takes O(Log n) extra space for recursive calls,
    // but it can be easily modified to work with same time and O(1) extra space
    public static Node SortedMerge(Node a, Node b){
        Node result = null;
        if (a == null) return b;
        else if (b == null) return a;

        // recurring case
        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return result;
    }

    // The main function that takes an array of lists
    // arr[0..last] and generates the sorted output
    public static Node mergeKLists(Node arr[], int last){
        while (last != 0) { // repeat until only one list is left
            int i = 0, j = last;

            while (i < j) { // (i, j) forms a pair
                // merge List i with List j and store merged list in List i
                arr[i] = SortedMerge(arr[i], arr[j]);
                // consider next pair
                i++;
                j--;
                if (i >= j) last = j; // If all pairs are merged, update last
            }
        }
        return arr[0];
    }

    class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
}
/*
Time Complexity: O(N*log k) or O(n*k*log k)
Auxiliary Space: O(N) or O(n*k)
 */
