package rishi.atreya._05_linkedlist;

import java.util.Stack;

public class _141_CheckIfSingleLinkedlistIsPalindrome {
    // using stack
    static boolean isPalindrome(NodeInt head){
        NodeInt slow = head;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            int i = stack.pop();
            if (head.data == i) {
                isPalindrome = true;
            }else {
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }

    // method 2 :  reversing the list
    /**
     * 1) Get the middle of the linked list.
     * 2) Reverse the second half of the linked list.
     * 3) Check if the first half and second half are identical.
     * 4) Construct the original linked list by reversing the second half again and attaching it back to the first half
     */
    Node head; // head of list
    Node slow_ptr, fast_ptr, second_half;
    boolean isPalindrome(Node head){
        slow_ptr = head;
        fast_ptr = head;
        Node prev_of_slow_ptr = head;
        Node midnode = null; // To handle odd size list
        boolean res = true; // initialize result
        if (head != null && head.next != null) {
            // Get the middle of the list. Move slow_ptr by 1 and
            // fast_ptrr by 2, slow_ptr will have the middle node
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                // We need previous of the slow_ptr for linked lists  with odd elements
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            /* fast_ptr would become NULL when there are even elements in the list
            and not NULL for odd elements. We need to skip the middle node for odd
            case and store it somewhere so that we can restore the original list */
            if (fast_ptr != null) {
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            // Now reverse the second half and compare it with first half
            second_half = slow_ptr;
            prev_of_slow_ptr.next = null; // NULL terminate first half
            reverse(); // Reverse the second half
            res = compareLists(head, second_half); // compare

            /* Construct the original list back */
            reverse(); // Reverse the second half again

            if (midnode != null) {
                // If there was a mid node (odd size case) which  was not part of either first half or second half.
                prev_of_slow_ptr.next = midnode;
                midnode.next = second_half;
            }else {
                prev_of_slow_ptr.next = second_half;
            }
        }
        return res;
    }

    void reverse(){
        Node prev = null;
        Node current = second_half;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
    }

    boolean compareLists(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }else {
                return false;
            }
        }
        if (temp1 == null && temp2 == null) return true;
        return false; //Will reach here when one is NULL and other is not
    }

    class NodeInt {
        int data;
        NodeInt next;
        NodeInt(int d){ next = null; data = d;}
    }

    class Node {
        char data;
        Node next;
        Node(char d){ data = d; next = null;}
    }
}
