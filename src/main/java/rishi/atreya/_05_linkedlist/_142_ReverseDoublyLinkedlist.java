package rishi.atreya._05_linkedlist;

import java.util.Stack;

public class _142_ReverseDoublyLinkedlist {
    void reverse(){
        Node temp = null;
        Node current = head;
        /* swap next and prev for all nodes of doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        /* Before changing head, check for the cases like empty list and list with only one node */
        if (temp != null) head = temp.prev;
    }

    // using stack
    void reverseUsingStack(){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        // added all the elements sequence wise in the stack
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        // popped all the elements and the added in the linked list,  which are in the reversed order.
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
