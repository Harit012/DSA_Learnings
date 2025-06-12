package DSA_Learnings.LinkedList;

class DoublyNode {
    public int data;
    public DoublyNode next;
    public DoublyNode prev;
    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    public DoublyNode(int data, DoublyNode next, DoublyNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}