package rishi.atreya._05_linkedlist;

public class _132_Add1ToNumberAsLinkedlist {
    static Node addOneUtil(Node head){
        Node res = head; // res is head node of the resultant list
        Node temp = null, prev = null;
        int carry = 1, sum;
        while (head != null){ // while both lists exist
            // Calculate value of next digit in resultant list. The next digit is sum of following
            // things (i) Carry (ii) Next digit of head list (if there is a next digit)
            sum = carry + head.data;
            carry = (sum >= 10) ? 1 : 0; // update carry for next calculation
            sum = sum % 10; // update sum if it is greater than 10
            head.data = sum; // Create a new node with sum as data
            temp = head; // Move head and second pointers to next nodes
            head = head.next;
        }
        // if some carry is still there, add a new node to result list.
        if (carry > 0) temp.next = newNode(carry);
        return res; // return head of the resultant list
    }

    static Node addOne(Node head){
        head = reverse(head); // Reverse linked list
        head = addOneUtil(head); // Add one from left to right of reversed list
        return reverse(head); // Reverse the modified list
    }

    static class Node {
        int data;
        Node next;
    }

    static Node newNode(int data){
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static void printList(Node node){
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(9);
        head.next.next = newNode(9);
        head.next.next.next = newNode(9);

        System.out.print("List is ");
        printList(head);

        head = addOne(head);
        System.out.println();
        System.out.print("Resultant list is ");
        printList(head);
    }

}

/**
 * Reverse given linked list. For example, 1-> 9-> 9 -> 9 is converted to 9-> 9 -> 9 ->1.
 * Start traversing linked list from leftmost node and add 1 to it. If there is a carry, move to the next node. Keep moving to the next node while there is a carry.
 * Reverse modified linked list and return head.
 */