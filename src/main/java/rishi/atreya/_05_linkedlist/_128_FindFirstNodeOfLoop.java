package rishi.atreya._05_linkedlist;

import java.util.HashSet;
import java.util.Set;

public class _128_FindFirstNodeOfLoop {
    static Node detectLoop(Node head){
        Node temp = new Node();
        while (head != null){
            if (head.next == null) return null;
            if (head.next == temp) break; // Check if next is already pointing to temp
            // Store the pointer to the next node
            // in order to get to it in the next step
            Node nex = head.next;
            head.next = temp;
            head = nex;
        }
        return head;
    }

    // using hashing
    static Node detectCycle(Node A){
        Set<Node> set = new HashSet<>();
        Node ptr = A;
        while (ptr != null){ // Default consider that no cycle is present
            // checking if address is already present in map
            if(set.contains(ptr)){
                return ptr;
            }else{ // if address not present then insert into the set
                set.add(ptr);
            }
            ptr = ptr.next;
        }
        return null;
    }

    static class Node{
        int key;
        Node next;
    };

    static Node newNode(int key){
        Node temp = new Node();
        temp.key = key;
        temp.next = null;
        return temp;
    }
}
