package Java;

public class SinglyCircularLL {
    ScNode head = null;
    ScNode tail = null;

    public void addBeginning(int data) {
        ScNode newNode = new ScNode(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    public void addEnd(int data) {
        ScNode newNode = new ScNode(data);
        if(tail == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    public void deleteBeginning() {
        if(head == null) return;
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    public void deleteEnd() {
        if(head == null) return;
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        ScNode curr = head;
        while(curr.next.next != head) {
            curr = curr.next;
        }
        curr.next = head;
        tail = curr;
    }

    public void printLL() {
        ScNode curr = head;
        System.out.print("head -> ");
        while(curr.next != head) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println(curr.data + " -> head");
    }

    public static void main(String[] args) {
        SinglyCircularLL list = new SinglyCircularLL();
        list.addBeginning(4);
        list.addBeginning(3);
        list.addBeginning(2);
        list.addBeginning(1);
        list.printLL();
        list.addEnd(5);
        list.addEnd(6);
        list.addEnd(7);
        list.addEnd(8);
        list.printLL();
        list.deleteBeginning();
        list.deleteBeginning();
        list.printLL();
        list.deleteEnd();
        list.deleteEnd();
        list.printLL();
    }
}

class ScNode {
    int data;
    ScNode next;

    public ScNode(int data) {
        this.data = data;
        this.next = null;
    }
}