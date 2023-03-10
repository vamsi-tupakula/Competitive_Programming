package Java;

public class StackUsingLL {
    public static void main(String[] args) {
        MyLLStack stack = new MyLLStack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.pop());
    }
}

class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLLStack {
    StackNode head = null;
    int size;
    
    MyLLStack() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);
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

    public int peek() {
        if(isEmpty()) return Integer.MAX_VALUE;
        return head.data;
    }
}