package rishi.atreya._05_linkedlist;

public class _147_ReverseDLLInGroupsOfGivenSize {
    static Node reverseByN(Node head, int k){
        if (head == null) return null;

        head.prev = null;
        Node temp;
        Node curr = head;
        Node newHead = null;
        int count = 0;

        while (curr != null && count < k) {
            newHead = curr;
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
            count++;
        }

        // Checking if the reversed LinkedList size is equal to K or not. If it is not equal to k that means
        // we have reversed the last set of size K and we don't need to call the recursive function
        if (count >= k) {
            Node rest = reverseByN(curr, k);
            head.next = rest;
            if (rest != null) {
                rest.prev = head; // it is required for prev link otherwise u wont be backtrack list due to broken links
            }
        }
        return newHead;
    }
    class Node {
        int data;
        Node next, prev;
    }
}

// Time Complexity: O(n).
