package Java;

public class DoublyLinkedList {
    Node head = null;
    Node tail = null;
    private int size;

    DoublyLinkedList() {
        this.size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        tail = newNode;
    }

    public void deleteFirst() {
        if(head == null) return;
        size--;
        if(head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteLast() {
        if(head == null) return;
        size--;
        if(head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next.prev = null;
        curr.next = null;
        tail = curr;
    }

    public void printList() {
        Node current = head;
        while(current!= null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printListReverse() {
        Node curr = tail;
        while(curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(15);
        list.addFirst(10);
        list.addFirst(5);
        list.addLast(20);
        list.printList();
        list.printListReverse();
        System.out.println("Size : " + list.getSize());
        list.deleteFirst();
        list.deleteLast();
        list.printList();
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}