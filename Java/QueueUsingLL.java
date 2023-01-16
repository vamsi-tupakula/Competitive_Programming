package Java;

public class QueueUsingLL {
    public static void main(String[] args) {
        LLQueue queue = new LLQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("after dequeue");
        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
    }
}

class QNode {
    int data;
    QNode next;

    public QNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LLQueue {
    QNode front;
    QNode rear;
    int size;

    LLQueue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(int val) {
        QNode node = new QNode(val);
        if(isEmpty()) {
            front = node;
            rear = node;
            size++;
            return;
        }
        rear.next = node;
        rear = rear.next;
        size++;
    }

    public void dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        front = front.next;
        size--;
        if(isEmpty()) rear = null;
    }

    private boolean isEmpty() {
        return (front == null);
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return 1;
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return size;
    }

    public int getSize() {
        return size;
    }
}
