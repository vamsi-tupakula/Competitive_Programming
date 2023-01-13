package Java;

public class StackUsingArray {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peak());
        stack.pop();
        System.out.println(stack.peak());
        System.out.println("Size : " + stack.getSize());
    }
}

/*
 * Problems with Array Implementation
 * 1. No dynamic resizing
 * 2. to add dynamic resizing we can implement stack with arraylist which can grow itself.
 */

class MyStack {
    int[] arr;
    int cap;
    int top;

    MyStack(int c) {
        this.top = -1;
        this.cap = c;
        this.arr = new int[cap];
    }

    public void push(int data) {
        if(top == cap - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int res = arr[top];
        top--;
        return res;
    }

    public int peak() {
        return arr[top];
    }

    public int getSize() {
        return top+1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}