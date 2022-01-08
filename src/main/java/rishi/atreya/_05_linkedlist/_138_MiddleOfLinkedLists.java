package rishi.atreya._05_linkedlist;

public class _138_MiddleOfLinkedLists {
    Node head;

    void printMiddle(){
        Node slow_ptr = head;
        Node fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        System.out.println("The middle element is [" + slow_ptr.data + "] \n");

    }

    class Node {
        int data;
        Node next;
        Node(int d){ this.data = d; this.next = null; }
    }

}
