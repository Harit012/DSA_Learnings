package DSA_Learnings.leetcode.java_solutions;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    // Helper method to convert an array to a linked list
    public static ListNode arrayToList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        int[] num1 = {2, 4, 3, 5 , 9, 1, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465

        ListNode l1 = arrayToList(num1);
        // System.out.println("l1: " + l1);
        ListNode l2 = arrayToList(num2);
        // System.out.println("l2: " + l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Result:");
        printList(result); // Output: 7 -> 0 -> 8
    }
}
