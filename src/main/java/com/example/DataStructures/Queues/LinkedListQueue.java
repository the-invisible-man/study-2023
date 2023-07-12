package main.java.com.example.DataStructures.Queues;

import main.java.com.example.DataStructures.LinkedList.Node;

public class LinkedListQueue {

    private Node head;

    private Node tail;

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(56);
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

    /**
     * O(1) -> Constant time
     */
    public void enqueue(int value) {
        if (this.head == null) {
            this.head = new Node();
            this.head.data = value;
            this.tail = this.head;

            return;
        }

        this.tail.next = new Node();
        this.tail.next.data = value;
        this.tail = this.tail.next;
    }

    /**
     * O(1) -> Constant time
     */
    public int dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int val = this.head.data;
        this.head = this.head.next;

        return val;
    }

    /**
     * O(1) -> Constant time
     */
    public boolean isEmpty() {
        return this.head == null;
    }
}