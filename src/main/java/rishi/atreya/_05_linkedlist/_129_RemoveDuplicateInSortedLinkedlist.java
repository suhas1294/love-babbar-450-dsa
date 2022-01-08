package rishi.atreya._05_linkedlist;

public class _129_RemoveDuplicateInSortedLinkedlist {
     void removeDuplicates(){
        Node curr = head; /*Another reference to head*/
        while (curr != null) { /* Traverse list till the last node */
            Node temp = curr;
            /*Compare current node with the next node and keep on
            deleting them until it matches the current node data */
            while(temp!=null && temp.data==curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
    }

    // recursive approach
    static Node removeDuplicates(Node head){
        Node to_free; /* Pointer to store the pointer of a node to be deleted*/
        if (head == null) return null;
        if (head.next != null){
            if (head.data == head.next.data) { /* Compare head node with next node */
            /* The sequence of steps is important. to_free pointer stores
            the next of head pointer which is to be deleted.*/
                to_free = head.next;
                head.next = head.next.next;
                removeDuplicates(head);
            }else{ /* This is tricky: only advance if no deletion */
                removeDuplicates(head.next);
            }
        }
        return head;
    }

    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
}
