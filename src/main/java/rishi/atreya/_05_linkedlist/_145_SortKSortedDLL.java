package rishi.atreya._05_linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _145_SortKSortedDLL {
    Node sortAKSortedDLL( Node head, int k){
        if (head == null) return head;

        // priority_queue 'pqueue' implemented as min heap with the
        // help of 'compare' function in compare Node class
        PriorityQueue<Node> pqueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));

        Node newHead = null, last = null;
        // Create a Min Heap of first (k+1) elements from  input doubly linked list
        for (int i = 0; head != null && i <= k; i++){
            pqueue.add(head); // push the node on to 'pqueue'
            head = head.next;// move to the next node
        }

        while (!pqueue.isEmpty()){ // loop till there are elements in 'pqueue'
            // place root or top of 'pqueue' at the end of the result sorted list so far
            // having the first node pointed to by 'newHead' and adjust the required links
            if (newHead == null){
                newHead = pqueue.peek();
                newHead.prev = null;
                // 'last' points to the last node  of the result sorted list so far
                last = newHead;
            }else {
                last.next = pqueue.peek();
                pqueue.peek().prev = last;
                last = pqueue.peek();
            }
            pqueue.poll(); // remove element from 'pqueue'

            if (head != null){// if there are more nodes left in the input list
                pqueue.add(head); // push the node on to 'pqueue'
                head = head.next; // move to the next node
            }
        }

        last.next = null; // making 'next' of last node point to NULL
        return newHead; // new head of the required sorted DLL
    }

    static Node head;
    static class Node {
        int data;
        Node next, prev;
        Node(int d) {
            data = d;
            next = prev = null;
        }
    }
}

/*
    Time Complexity: O(n*log k)
    Auxiliary Space: O(k)
*/
