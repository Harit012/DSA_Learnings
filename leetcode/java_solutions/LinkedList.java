package DSA_Learnings.leetcode.java_solutions;
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            mover.next = node;
            mover = node;
        }

        // Traverse and print the linked list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}