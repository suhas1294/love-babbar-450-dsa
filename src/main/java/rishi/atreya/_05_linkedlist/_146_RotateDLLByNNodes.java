package rishi.atreya._05_linkedlist;

// asked in amazon
public class _146_RotateDLLByNNodes {

    // This function rotates a doubly linked list counter-clockwise and updates the head.
    // The function assumes that N is smaller than size of linked list. It doesn't modify the
    // list if N is greater than or equal to size
    static void rotate( int N){
        if (N == 0) return;
        Node current = head; // example N = 2 and list = a <-> b <-> c <-> d <-> e.
        // current will either point to Nth or NULL after this loop
        // Current will point to node 'b' in the above example
        int count = 1;
        while (count < N && current != null) {
            current = current.next;
            count++;
        }
        // If current is NULL, N is greater than or equal to count of nodes
        // in linked list. Don't change the list in this case
        if (current == null) return;

        // current points to Nth node. Store it in a variable. NthNode points to node 'b' in the above example
        Node NthNode = current;

        // current will point to last node after this loop current will point  to node 'e' in the above example
        while (current.next != null) {
            current = current.next;
        }

        current.next = head; // Change next of last node to previous head. Next of 'e' is now changed to node 'a'
        (head).prev = current; // Change prev of Head node to current Prev of 'a' is now changed to node 'e'
        head = NthNode.next; // Change head to (N+1)th node head is now changed to node 'c'
        (head).prev = null;// Change prev of New Head node to NULL Because Prev of Head Node in Doubly linked list is NULL
        NthNode.next = null; // change next of Nth node to NULL next of 'b' is now NULL
    }
    static Node head = null;
    static class Node{
        char data;
        Node prev;
        Node next;
    }
}

/**
 * 1. To rotate the Doubly linked list, first, we need to traverse through the linked list and find the address of the last node.
 * 2. Then make it a circular linked list.
 * 3. Then move the head as well as a temp by n nodes.
 * 4. Then make the linked list as un-circular.
 *
 * Before Rotation :
 * a-->b-->c-->d-->e-->NULL
 * After Rotation :
 * c-->d-->e-->a-->b-->NULL
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
