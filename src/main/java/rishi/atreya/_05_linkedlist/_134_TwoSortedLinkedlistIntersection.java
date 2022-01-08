package rishi.atreya._05_linkedlist;

public class _134_TwoSortedLinkedlistIntersection {
    static Node sortedIntersect(Node a, Node b){
        if (a == null || b == null) return null; // base case
        // Advance the smaller list and call recursively
        if (a.data < b.data) return sortedIntersect(a.next, b);
        if (a.data > b.data) return sortedIntersect(a, b.next);
        // Below lines are executed only when a.data == b.data
        Node temp = new Node();
        temp.data = a.data;
        // Advance both lists and call recursively
        temp.next = sortedIntersect(a.next, b.next);
        return temp;
    }

    static class Node{
        int data;
        Node next;
    };
}
