package rishi.atreya._05_linkedlist;

//Floyd’s Cycle-Finding Algorithm
//Approach: This is the fastest method and has been described below:
public class _126_DetectLoopInLinkedlist {
    Node head;

    void detectLoop(){
        Node slowPointer = head, fastPointer = head;
        int flag = 0;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop found");
        else
            System.out.println("Loop not found");
    }

    private class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

}
