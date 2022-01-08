package rishi.atreya._05_linkedlist;

public class _124_ReverseLinkedlist {

    private static class LinkedList{
        Node reverse(Node node){
            Node prev = null;
            Node current = node;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            node = prev;
            return node;
        }

        Node head;

        class Node {
            int data;
            Node next;
            Node(int data){
                this.data = data;
                next = null;
            }
        }
    }

}
