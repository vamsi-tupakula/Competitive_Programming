package Java;

public class StackUsingLL {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peak());
        stack.pop();
        stack.pop();
        System.out.println(stack.peak());
        stack.pop();
        System.out.println(stack.pop());
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

class MyStack {
    Node head = null;
    int size;
    
    MyStack() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if(isEmpty()) return Integer.MAX_VALUE;
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int peak() {
        if(isEmpty()) return Integer.MAX_VALUE;
        return head.data;
    }
}