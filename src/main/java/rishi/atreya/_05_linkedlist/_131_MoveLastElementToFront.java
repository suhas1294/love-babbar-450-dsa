package rishi.atreya._05_linkedlist;

public class _131_MoveLastElementToFront {
    void moveToFront(){
        if(head == null || head.next == null) return;
        Node secLast = null;
        Node last = head;
        /* After this loop secLast contains address of second last  node
        and last contains address of last node in Linked List */
        while (last.next != null){
            secLast = last;
            last = last.next;
        }
        secLast.next = null; /* Set the next of second last as null */
        last.next = head; /* Set the next of last as head */
        head = last; /* Change head to point to last node. */
    }

    Node head;
    class Node{
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public void push(int new_data){ // Inserts a new Node at front of the list
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        _131_MoveLastElementToFront llist = new _131_MoveLastElementToFront();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before moving last to front ");
        llist.printList();

        llist.moveToFront();

        System.out.println("Linked List after moving last to front ");
        llist.printList();
    }
}
