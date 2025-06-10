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
    }

    public static Node CreateLinkedList(int[] arr) {
        if(arr.length == 0){
            return null;
        }else{
            Node head = new Node(arr[0]);
            Node mover = head;
            for (int i = 1; i < arr.length; i++) {
                Node node = new Node(arr[i]);
                mover.next = node;
                mover = node;
            }
            return head;
        }
    }
    public static Node addHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
    public static Node removeHead(Node head) {
        Node next = head.next;
        if(next != null){
            return next;
        }
        return null;  
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
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }
    public static Node removeTail(Node head) {
        Node current = head;
        if(head.next == null){
            return null;
        }else{
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        return head;    
    }
}
