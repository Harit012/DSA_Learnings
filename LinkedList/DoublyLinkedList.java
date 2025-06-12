package DSA_Learnings.LinkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        int[] arr = {1 , 2 ,3 , 4 , 5};
        DoublyNode head = CreateDoublyLinkedList(arr);
        System.out.println("============================= Head ====================================");
        System.out.println(head.data);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Add Head =====================");
        head = addHead(head, 50);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Remove Head =====================");
        head = removeHead(head);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Add Tail =====================");
        head = addTail(head, 22);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Remove Tail =====================");
        head = removeTail(head);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Add at K =====================");
        head = addAtPositionK(head, 2, 623);
        printList(head);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("============================= Remove At K =====================");
        head = removeAtPositionK(head,2);
        printList(head);
    }

    public static void printList(DoublyNode head) {
        while (head != null) {
            System.out.println("prev : "+head.prev+" "+"data : "+head.data + " "+"next : "+head.next);
            // System.out.print(head.data + "  ");
            head = head.next;
        }
        System.out.println();
    }

    public static DoublyNode CreateDoublyLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        DoublyNode head = new DoublyNode(arr[0]);
        DoublyNode mover = head;
        // DoublyNode prev = null;

        for(int i=1; i<arr.length; i++) {
            DoublyNode node = new DoublyNode(arr[i], null, mover);
            mover.next = node;
            mover = node;
        }
        return head;
    }

    public static DoublyNode addHead(DoublyNode head, int data) {
        if(head == null) return new DoublyNode(data);
        DoublyNode newNode = new DoublyNode(data, head, null);
        head.prev = newNode;
        return newNode;
    }

    public static DoublyNode removeHead(DoublyNode head) {
        if(head == null || head.next == null) return null;
        DoublyNode newHead = head.next;
        newHead.prev = null;
        head.next=null;
        return newHead;
    }

    public static DoublyNode addTail(DoublyNode head, int data) {
        if(head == null) return new DoublyNode(data);
        DoublyNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        DoublyNode newNode = new DoublyNode(data, null, current);
        current.next = newNode;
        return head;
    }
        

    public static DoublyNode removeTail(DoublyNode head) {
        if(head == null || head.next == null) return null;
        DoublyNode current = head;
        while(current.next.next != null) {
            current = current.next;
        }
        current.next = null;

        return head;
    }

    public static DoublyNode addAtPositionK(DoublyNode head, int k, int data) {
        if(k <= 0) return head;
        if(k == 1) return addHead(head, data);
        DoublyNode current = head;
        DoublyNode previous = null;
        int count = 1;
        while(current != null && count < k) {
            previous = current;
            current = current.next;
            count++;
        }
        DoublyNode newNode = new DoublyNode(data, current, previous);
        if(previous != null) {
            previous.next = newNode;
            if (previous != null) {
                previous.next = newNode;
            }
            if (current != null) {
                current.prev = newNode;
            }        }
        return head;
    }

    public static DoublyNode removeAtPositionK(DoublyNode head, int k) {
        if(k <= 0 || head == null) return head;
        if(k == 1) return removeHead(head);
        DoublyNode current = head;
        DoublyNode previous = null;
        int count = 1;
        while(current != null && count < k) {
            previous = current;
            current = current.next;
            count++;
        }
        if(current != null) {
            previous.next = current.next;
            if (current != null) {
                previous.next = current.next;
                if (current.next != null) {
                    current.next.prev = previous;
                }
            }
        }
        return head;
    }
}
