package rishi.atreya._05_linkedlist;

public class _125_ReverseLinkedlistInKGroup {

    private static class LinkedList{
        Node reverseInKGroup(Node head, int k){
            if(head == null) return null;
            Node current = head;
            Node next = null;
            Node prev = null;
            int count = 0;
            /* Reverse first k nodes of linked list */
            while (count < k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
            // next is now a pointer to (k+1)th node Recursively call for the list starting
            // from current. And make rest of the list as next of first node
            if (next != null) head.next = reverseInKGroup(next, k);
            return prev; // prev is now head of input list
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

        /* Inserts a new Node at front of the list. */
        public void push(int new_data) {
            Node new_node = new Node(new_data);
            new_node.next = head;
            head = new_node;
        }

        void printList(){
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        for (int i = 9; i > 0; i--) {
            llist.push(i);
        }
        llist.head = llist.reverseInKGroup(llist.head, 3);
        llist.printList();
    }

}
