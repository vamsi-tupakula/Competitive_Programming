package Java;

public class SinglyLinkedList {
    Node head = null;
    Node tail = null;
    private int size = 0;
    public void addBeginning(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addEnd(int data) {
        Node newNode = new Node(data);
        size++;
        if(tail == null) {
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void deleteBeginning() {
        if(head == null) return;
        size--;
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
    }

    public void deleteEnd() {
        if(tail == null) return;
        size--;
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
    }

    public void printList() {
        Node current = head;
        while(current!= null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addBeginning(4);
        list.addBeginning(3);
        list.addBeginning(2);
        list.addBeginning(1);
        list.printList();
        list.addEnd(5);
        list.addEnd(6);
        list.addEnd(7);
        list.printList();
        list.deleteBeginning();
        list.printList();
        System.out.println("Size : " + list.getSize());
        list.deleteEnd();
        list.printList();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}