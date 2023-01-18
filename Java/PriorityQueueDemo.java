package Java;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new PQComparator());
        queue.add(33);
        queue.add(35);
        queue.add(1);
        queue.add(10);
        queue.add(5);
        System.out.println(queue.poll()); // poll() = peek() + remove()
        queue.remove();
        System.out.println(queue.peek());
    }
}

class PQComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}