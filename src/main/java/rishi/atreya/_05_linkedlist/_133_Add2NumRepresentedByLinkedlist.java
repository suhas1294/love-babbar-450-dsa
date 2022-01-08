package rishi.atreya._05_linkedlist;

public class _133_Add2NumRepresentedByLinkedlist {
    public static Node addTwoLists(Node first, Node second) {
        Node start1 = new Node(0);
        start1.next = first;
        Node start2 = new Node(0);
        start2.next = second;
        addPrecedingZeros(start1, start2);
        Node result = new Node(0);
        if (sumTwoNodes(start1.next, start2.next, result) == 1) {
            Node dummy = new Node(1);
            dummy.next = result.next;
            result.next = dummy;
        }
        return result.next;
    }
    public static int sumTwoNodes(Node first, Node second, Node result) {
        if (first == null) {
            return 0;
        }
        int sum = 0;
        sum += first.data;
        sum += second.data;
        sum += sumTwoNodes(first.next, second.next, result);
        Node dummy = new Node(sum % 10);
        dummy.next = result.next;
        result.next = dummy;
        return sum / 10;
    }
    public static void addPrecedingZeros(Node start1, Node start2) {
        Node next1 = start1.next;
        Node next2 = start2.next;
        while (next1 != null && next2 != null) {
            next1 = next1.next;
            next2 = next2.next;
        }
        if (next1 == null) {
            if (next2 != null) {
                while (next2 != null) {
                    Node dummy = new Node(0);
                    dummy.next = start1.next;
                    start1.next = dummy;
                    next2 = next2.next;
                }
            }
        } else if (next2 == null) {
            if (next1 != null) {
                while (next1 != null) {
                    Node dummy = new Node(0);
                    dummy.next = start2.next;
                    start2.next = dummy;
                    next1 = next1.next;
                }
            }
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static Node solve(Node first, Node second) {
        Node result = addTwoLists(first, second);
        return result;
    }
}
