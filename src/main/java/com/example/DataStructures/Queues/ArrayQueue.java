package main.java.com.example.DataStructures.Queues;

public class ArrayQueue {
    private int front = -1;

    private int rear = -1;

    private int[] data = new int[5];

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(5);
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(34);

        queue.enqueue(67);
        queue.enqueue(5768);
        queue.enqueue(23);
        queue.enqueue(34);
        queue.enqueue(456);
        queue.enqueue(657);
        queue.enqueue(23);
        queue.enqueue(216);
        queue.enqueue(75642);
        queue.enqueue(45);
        queue.enqueue(56);

        int i = 14;

        while (i >= 0) {
            System.out.println(queue.dequeue());
            i--;
        }

        if (queue.isEmpty()) {
            System.out.println("The queue is empty");
        }
    }

    public void enqueue(int value) {
        if (this.rear == this.data.length-1) {
            // Max elements, double data[] size to increase the size of the queue
            int[] temp = this.data;
            this.data = new int[this.data.length*2];
            System.arraycopy(temp, 0, this.data, 0, temp.length);
        }

        if (this.front == -1) {
            this.front++;
        }
        this.rear++;
        this.data[this.rear] = value;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (this.front == this.rear) {
            // Set queue as empty
            int val = this.data[this.front];
            this.front = this.rear = -1;
            return val;
        }

        int value = this.data[this.front];
        this.front++;

        return value;
    }

    public boolean isEmpty() {
        return this.front == -1 && this.rear == -1;
    }
}
