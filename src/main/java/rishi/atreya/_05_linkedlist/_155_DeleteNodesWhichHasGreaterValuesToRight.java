package rishi.atreya._05_linkedlist;

public class _155_DeleteNodesWhichHasGreaterValuesToRight {

    // Deletes nodes which have a node with greater value node on left side
    void delLesserNodes(){
        reverseList();
        // In the reversed list, delete nodes which have a node with greater value node on left
        // side. Note that head node is never deleted because it is the leftmost node.
        _delLesserNodes();
        // Reverse the linked list again to retain the original order
        reverseList();
    }

    // Deletes nodes which have greater value node(s) on left side
    void _delLesserNodes(){
        Node current = head;
        Node maxnode = head; /* Initialise max */
        Node temp;

        while (current != null && current.next != null) {
            /* If current is smaller than max, then delete current */
            if (current.next.data < maxnode.data) {
                temp = current.next;
                current.next = temp.next;
                temp = null;
            }
            else { // If current is greater than max, then update max and move current
                current = current.next;
                maxnode = current;
            }
        }
    }

    void reverseList(){
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    Node head;
    class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
}
