package rishi.atreya._05_linkedlist;

public class _140_SplitLinkedListIntoTwoHalves {
    static Node head, head1, head2;

    // Function to split a list (starting with head) into two lists. head1_ref and
    // head2_ref are references to head nodes of the two resultant linked lists
    void splitList() {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head == null) return;
        // If there are odd nodes in the circular list then fast_ptr->next
        // becomes head and for even nodes fast_ptr->next->next becomes head
        while (fast_ptr.next != head && fast_ptr.next.next != head) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        if (fast_ptr.next.next == head) fast_ptr = fast_ptr.next; /* If there are even elements in list then move fast_ptr */
        head1 = head; /* Set the head pointer of first half */
        if (head.next != head) head2 = slow_ptr.next; /* Set the head pointer of second half */
        fast_ptr.next = slow_ptr.next; /* Make second half circular */
        slow_ptr.next = head;/* Make first half circular */
    }

    static class Node {
        int data;
        Node next, prev;
        Node(int d) { data = d; next = prev = null;}
    }
}
