package rishi.atreya._05_linkedlist;

// https://www.geeksforgeeks.org/flattening-a-linked-list/
public class _150_FlattenALinkedlist {

    Node flatten(Node root){
        if (root == null || root.right == null) return root;
        root.right = flatten(root.right); // recur for list on right
        root = merge(root, root.right); // now merge
        return root; // return the root it will be in turn merged with its left
    }

    Node merge(Node a, Node b){
        if (a == null) return b;
        if (b == null) return a;
        Node result;

        // compare the data members of the two linked lists  and put the larger one in the result
        if (a.data < b.data){
            result = a;
            result.down =  merge(a.down, b);
        }else{
            result = b;
            result.down = merge(a, b.down);
        }
        result.right = null;
        return result;
    }

    Node head;
    class Node{
        int data;
        Node right, down;
        Node(int data){
            this.data = data;
            right = null;
            down = null;
        }
    }
}
