package rishi.atreya._05_linkedlist;

public class _136_MergeSortForLinkedLists {
    static Node mergeSort(Node head){ // Function to merge sort
        if (head.next == null) return head;
        Node mid = findMid(head);
        Node head2 = mid.next;
        mid.next = null;
        Node newHead1 = mergeSort(head);
        Node newHead2 = mergeSort(head2);
        Node finalHead = merge(newHead1, newHead2);
        return finalHead;
    }

    static Node merge(Node head1, Node head2){ // Function to merge two linked lists
        Node merged = new Node(-1);
        Node temp = merged;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    // Find mid using The Tortoise and The Hare approach
    static Node findMid(Node head){
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class Node {
        int data;
        Node next;
        Node(int key){ this.data = key; next = null;}
    }
}
