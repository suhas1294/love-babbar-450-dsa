package rishi.atreya._05_linkedlist;

public class _139_CheckIfLinkedlistIsCircular {
    static boolean isCircular( Node head){
        if (head == null) return true;
        Node node = head.next;
        // This loop would stop in both cases (1) If Circular (2) Not circular
        while (node != null && node != head) {
            node = node.next;
        }
        return (node == head); // If loop stopped because of circular condition
    }
    static class Node    {
        int data;
        Node next;
    }
}
