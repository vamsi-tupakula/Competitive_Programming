package Java;

public class HareTortoise {
    HTNode head = null;
    HTNode tail = null;
    public void addBeginning(int data) {
        HTNode newNode = new HTNode(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void makeCycle(int pos) {
        HTNode curr = head;
        int i=0;
        while(i<pos-1) {
            curr = curr.next;
            i++;
        }
        tail.next = curr;
    }
    public boolean detectCycle() {
        HTNode fast = head;
        HTNode slow = head;
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
        HTNode curr = head;
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

class HTNode {
    int data;
    HTNode next;
    HTNode(int data) {
        this.data = data;
        this.next = null;
    }
}