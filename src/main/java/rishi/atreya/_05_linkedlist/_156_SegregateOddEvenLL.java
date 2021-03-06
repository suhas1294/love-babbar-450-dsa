package rishi.atreya._05_linkedlist;

public class _156_SegregateOddEvenLL {
    public void segregateEvenOdd() {

        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node currentNode = head;

        while(currentNode != null) {
            int element = currentNode.data;
            if(element % 2 == 0) {
                if(evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            } else {
                if(oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            // Move head pointer one step in forward direction
            currentNode = currentNode.next;
        }

        if(oddStart == null || evenStart == null) return;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head=evenStart;
    }

    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
}
