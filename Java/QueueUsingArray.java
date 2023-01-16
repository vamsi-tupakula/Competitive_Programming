package Java;

public class QueueUsingArray {
    public static void main(String[] args) {
        ArrQueue queue = new ArrQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
    }
}

class ArrQueue {
    int size, cap;
    int[] arr;
    int front = -1;
    int rear = -1;

    ArrQueue(int c) {
        this.size = 0;
        this.cap = c;
        this.arr = new int[cap];
    }

    public void enqueue(int val) {
        if(isFull()) {
            System.out.println("Queue is full, cannot add " + val);
            return;
        }
        arr[size] = val;
        size++;
    }

    public void dequeue() {
        if(isEmpty()) {
            System.out.println("no elements to dequeue");
            return;
        }
        for(int i=0;i<size-1;i++) {
            arr[i] = arr[i+1];
        }
        size--;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return 0;
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return size-1;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    boolean isFull() {
        return (size == cap);
    }

    int getSize() {
        return this.size;
    }
}