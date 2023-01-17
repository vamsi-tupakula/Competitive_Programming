package Java;

import java.util.Stack;

public class StackCollections {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.push(2);
        stack.push(4);
        System.out.println(stack.search(2)); // returns position starting from 1
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println("printing stack :");
        printStack(stack);
        System.out.println("printing reverse :");
        printStackReverse(stack);
    }

    public static void printStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        temp.addAll(st);
        while(!temp.empty()) {
            System.out.println(temp.peek());
            temp.pop();
        }
    }

    public static void printStackReverse(Stack<Integer> st) {
        if(st.empty()) return;
        Stack<Integer> temp = new Stack<>();
        temp.addAll(st);
        int top = temp.pop();
        printStackReverse(temp);
        System.out.println(top);
    }
}