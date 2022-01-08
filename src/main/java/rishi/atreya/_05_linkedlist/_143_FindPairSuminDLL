package rishi.atreya._05_linkedlist;

public class _143_FindPairSuminDLL {
    static void pairSum( Node head, int targetNo) {
        // Set two pointers, first  to the beginning of DLL  and second to the end of DLL.
        Node first = head;
        Node second = head;
        while (second.next != null) {
            second = second.next;
        }
        boolean found = false;
        // The loop terminates when  they cross each other (second.next
        // == first), or they become same (first == second)
        while ( first != second && second.next != first){
            if ((first.data + second.data) == targetNo){
                found = true;
                System.out.println( "(" + first.data + ", "+ second.data + ")" );
                first = first.next; // move first in forward direction
                second = second.prev; // move second in backward direction
            } else {
                if ((first.data + second.data) < targetNo)
                    first = first.next;
                else
                    second = second.prev;
            }
        }

        if (found == false) System.out.println("No pair found");
    }
    static class Node{
        int data;
        Node next, prev;
    };
}
