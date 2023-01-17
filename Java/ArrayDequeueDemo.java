package Java;

import java.util.*;

public class ArrayDequeueDemo {
    public static void main(String[] args) {
        // stores elements or objects in the order of their insertion and follows FIFO principle.
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(2);
        queue.add(12);
        queue.add(34);
        queue.add(21);
        queue.add(17);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
    }
}
