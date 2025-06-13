package DSA_Learnings.LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = CreateLinkedList(arr);
        System.out.println("============================= Head ====================================");
        System.out.println(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Created Linked List =====================");
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Add Head ================================");
        head = addHead(head, 50);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Remove Head =============================");
        head = removeHead(head);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Add Tail ================================");
        addTail(head, 50);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Remove Tail =============================");
        head = removeTail(head);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Remove At K =============================");
        head = removeAtPositionK(head, 1);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Add At K =============================");
        head = addAtPositionK(head, 5 , 101);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Reverse LL =============================");
        head = reverseLinkedList(head);
        printList(head);
    }

    public static Node CreateLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }

        return head;
    }
    public static Node addHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
    public static Node removeHead(Node head) {
        return (head != null) ? head.next : null;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node addTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }
    public static Node removeTail(Node head) {
        if (head == null || head.next == null) {
            return null; // empty or single-element list
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }


    public static Node removeAtPositionK(Node head, int k) {
        if (k <= 0 || head == null) return head;

        if (k == 1) {
            return removeHead(head); // assume this removes and returns new head
        }

        Node current = head;
        Node previous = null;
        int count = 1;

        while (current != null && count < k) {
            previous = current;
            current = current.next;
            count++;
        }

        if (current != null) {
            previous.next = current.next; // removes the k-th node
        }

        return head;
    }

    public static Node addAtPositionK(Node head, int k, int data) {
        if (k <= 0) return head; // invalid position

        if (k == 1) {
            return addHead(head, data);
        }

        Node current = head;
        Node previous = null;
        int count = 1;

        while (current != null && count < k) {
            previous = current;
            current = current.next;
            count++;
        }

        // At this point, current is either null (end) or at position k
        Node newNode = new Node(data);
        if (previous != null) {
            previous.next = newNode;
        }

        newNode.next = current;

        return head;
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
