package rishi.atreya._05_linkedlist;

public class _151_SortLLOf012 {

    void sortList(){
        int count[] = {0, 0, 0}; // initialise count of 0 1 and 2 as 0
        Node ptr = head;
        /* count[0] will store total number of '0's
         * count[1] will store total number of '1's
         * count[2] will store total number of '2's  */
        while (ptr != null){
            count[ptr.data]++;
            ptr = ptr.next;
        }
        int i = 0;
        ptr = head;
        /* Let say count[0] = n1, count[1] = n2 and count[2] = n3
        now start traversing list from head node,
         * 1) fill the list with 0, till n1 > 0
         * 2) fill the list with 1, till n2 > 0
         * 3) fill the list with 2, till n3 > 0  */
        while (ptr != null){
            if (count[i] == 0)
                i++;
            else
            {
                ptr.data= i;
                --count[i];
                ptr = ptr.next;
            }
        }
    }

    Node head;
    class Node{
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
}
