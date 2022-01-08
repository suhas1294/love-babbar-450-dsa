package rishi.atreya._05_linkedlist;

// using constant space
public class _152_CloneALLWithNextAndRandomPointer {
    static class Node {

        static Node clone(Node start){
            Node curr = start, temp = null;
            // insert additional node after every node of original list
            while (curr != null) {
                temp = curr.next;
                curr.next = new Node(curr.data); // Inserting node
                curr.next.next = temp;
                curr = temp;
            }
            curr = start;
            // adjust the random pointers of the newly added nodes
            while (curr != null) {
                if (curr.next != null) {
                    curr.next.random = (curr.random != null)
                            ? curr.random.next
                            : curr.random;
                }
                // move to the next newly added node by skipping an original node
                curr = curr.next.next;
            }
            Node original = start, copy = start.next;
            temp = copy; // save the start of copied linked list

            while (original != null) { // now separate the original list and copied list
                original.next =original.next.next;
                copy.next = (copy.next != null) ? copy.next.next : copy.next;
                original = original.next;
                copy = copy.next;
            }
            return temp;
        }

        int data;
        Node next, random;
        Node(int x){
            data = x;
            next = random = null;
        }
    }
}
