package Java;

public class DoublyCircularLL {
    Node head = null;
    Node tail = null;
    
    public void addBeginningNode(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.prev = head;
            return;            
        }
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        head = newNode;
    }

    public void addEnd(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.prev = head;
            return;            
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail = newNode;
    }

    public void deleteBeginning() {
        if(head == null) return;
        if(head.next == head) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    public void deleteEnd() {
        if(head == null) return;
        if(head.next == head) {
            head = null;
            tail = null;
            return;
        }
        head.prev = tail.prev;
        tail.prev.next = head;
        tail = tail.prev;
    }

    public void printLL() {
        Node curr = head;
        while(curr.next != head) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println(curr.data + " <-> head");
    }

    public static void main(String[] args) {
        DoublyCircularLL dc = new DoublyCircularLL();
        dc.addBeginningNode(3);
        dc.addBeginningNode(2);
        dc.addBeginningNode(1);
        dc.printLL();
        dc.addEnd(4);
        dc.addEnd(5);
        dc.addEnd(6);
        dc.printLL();
        dc.deleteBeginning();
        dc.deleteBeginning();
        dc.printLL();
        dc.deleteEnd();
        dc.deleteEnd();
        dc.printLL();
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}