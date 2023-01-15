package Java;

public class HareTortoise {
    Node head = null;
    Node tail = null;
    public void addBeginning(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void makeCycle(int pos) {
        Node curr = head;
        int i=0;
        while(i<pos-1) {
            curr = curr.next;
            i++;
        }
        tail.next = curr;
    }
    public boolean detectCycle() {
        Node fast = head;
        Node slow = head;
        while(slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                System.out.println("cycle exists..");
                return true;
            }
        }
        System.out.println("no cycle exists..");
        return false;
    }
    public void printLL() {
        Node curr = head;
        if(detectCycle()) {
            return;
        }
        while(curr!= null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        HareTortoise run = new HareTortoise();
        run.addBeginning(5);
        run.addBeginning(10);
        run.addBeginning(15);
        run.addBeginning(20);
        run.addBeginning(25);
        // run.makeCycle(3);
        run.printLL();
    }
}

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}