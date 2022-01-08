package rishi.atreya._05_linkedlist;

import java.util.HashMap;

public class _144_CountTripletsInDLL {
    // using two pointer
    // function to count triplets in a sorted doubly linked list whose sum is equal to a given value 'x'
    static int countTriplets(Node head, int x){
        if (head == null) return 0;
        Node current, first, last;
        int count = 0;
        // get pointer to the last node of  the doubly linked list
        last = head;
        while (last.next != null) {
            last = last.next;
        }
        for (current = head; current != null; current = current.next) {
            first = current.next;
            // count pairs with sum(x - current.data) in the range
            // first to last and add it to the 'count' of triplets
            count += countPairs(first, last, x - current.data);
        }
        return count; // required count of triplets
    }

    static int countPairs(Node first, Node second, int value){
        int count = 0;
        // The loop terminates when either of two pointers become null, or
        // they cross each other (second.next == first), or they become same (first == second)
        while (first != null && second != null &&
                first != second && second.next != first) {
            if ((first.data + second.data) == value) { // pair found
                count++;
                first = first.next;
                second = second.prev;
            }else if ((first.data + second.data) > value) {
                // if sum is > than 'value' move second backward
                second = second.prev;
            } else { // else move first in forward direction
                first = first.next;
            }
        }
        return count; // required count of pairs
    }

    // using hashing
    static int countTripletsUsingHashing(Node head, int x){
        Node ptr, ptr1, ptr2;
        int count = 0;
        HashMap<Integer,Node> map = new HashMap<Integer,Node>();

        // insert the <node data, node pointer> tuple in 'map'
        for (ptr = head; ptr != null; ptr = ptr.next) {
            map.put(ptr.data, ptr);
        }

        // generate all possible pairs
        for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next)
            for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {

                // p_sum - sum of elements in the current pair
                int p_sum = ptr1.data + ptr2.data;

                // if 'x-p_sum' is present in 'um' and either of the two nodes
                // are not equal to the 'um[x-p_sum]' node
                if (map.containsKey(x - p_sum) && map.get(x - p_sum) != ptr1
                        && map.get(x - p_sum) != ptr2) {
                    count++;
                }
            }

        // required count of triplets
        // division by 3 as each triplet is counted 3 times
        return (count / 3);
    }


    static class Node {
        int data;
        Node next, prev;
    };
}
