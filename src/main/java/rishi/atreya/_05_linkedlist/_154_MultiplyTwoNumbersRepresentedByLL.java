package rishi.atreya._05_linkedlist;

public class _154_MultiplyTwoNumbersRepresentedByLL {

    static long multiplyTwoLists(Node first, Node second){
        long N = 1000000007;
        long num1 = 0, num2 = 0;

        while (first != null || second !=  null){
            if(first != null){
                num1 = ((num1)*10)%N + first.data;
                first = first.next;
            }
            if(second != null){
                num2 = ((num2)*10)%N + second.data;
                second = second.next;
            }

        }
        return ((num1%N)*(num2%N))%N;
    }

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }
}

/**
 * 1) Initialize a variable to zero
 * 2) Start traversing the linked list
 * 3) Add the value of first node to this variable
 * 4) From the second node, multiply the variable by 10
 *    and also take modulus of this value by 10^9+7
 *    and then add the value of the node to this
 *    variable.
 * 5) Repeat step 4 until we reach the last node of the list.
 */
