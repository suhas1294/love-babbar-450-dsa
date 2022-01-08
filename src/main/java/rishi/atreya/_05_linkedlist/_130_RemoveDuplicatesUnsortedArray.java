package rishi.atreya._05_linkedlist;

import java.util.HashSet;

public class _130_RemoveDuplicatesUnsortedArray {
    static void removeDuplicate(node head){
        HashSet<Integer> hs = new HashSet<>(); // Hash to store seen values
        node current = head;
        node prev = null;
        while (current != null) {
            int curval = current.data;
            if (hs.contains(curval)) {
                prev.next = current.next;
            }else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    // n^2 solution
    void remove_duplicates(){
        node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            /* Compare the picked element with rest of the elements */
            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) { /* If duplicate then delete it */
                    ptr2.next = ptr2.next.next; // sequence of steps is important here
                    System.gc();
                }else{ /* This is tricky */
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }
    static node head;

    static class node {
        int data;
        node next;
        public node(int data) { this.data = data; }
    }
}
