package main.java.com.example.FinalReview.Tuesday;

public class LinkedList {
    private Node head, tail;
    private int size = 0;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(3);
        list.add(4);
        list.add(334);
        list.add(34);
        list.add(567);
        list.add(12);

        if (list.has(3)) {
            System.out.println("has 3");
        }

        System.out.println("Size is " + list.size());

        list.remove(12);

        System.out.println("Size is " + list.size());

        list.remove(3);

        System.out.println("Size is " + list.size());

        list.remove(334);

        System.out.println("Size is " + list.size());

        if (!list.has(3)) {
            System.out.println("List doesn't have 3");
        }

        if (list.has(567)) {
            System.out.println("List has 567");
        }

        list.remove(4);

        System.out.println("Size is " + list.size());

        list.add(99);

        if (list.has(99)) {
            System.out.println("List has 99");
        }

        list.remove(567);

        System.out.println("Size is " + list.size());

        if (list.has(4)) {
            System.out.println("List has 4");
        }

        list.remove(4);

        System.out.println("Size is " + list.size());

        list.remove(99);

        System.out.println("Size is " + list.size());
    }

    public void add(int val) {
        if (this.has(val)) {
            throw new IllegalArgumentException("This value already exists. Values should be unique.");
        }

        this.size++;

        if (this.head == null || this.tail == null) {
            this.head = new Node(val);
            this.tail = this.head;
            return;
        }

        Node current = new Node(val);
        this.head.next = current;
        current.prev = this.head;
        this.head = current;
    }

    public void remove(int val) {
        if (this.size == 0) {
            throw new IllegalArgumentException("The list is empty. Nothing to remove.");
        }
        // We could be removing the head
        if (this.head.val == val) {
            if (this.size == 1) {
                this.dropAll();
            } else {
                this.head = this.head.prev;
            }
            this.size--;
            return;
        }

        // We could be removing the tail
        if (this.tail.val == val) {
            if (this.size == 1) {
                this.dropAll();
            } else {
                this.tail = this.tail.next;
            }
            this.size--;
            return;
        }

        // Something in between
        Node target = this.head;

        while (target != null && target.val != val) {
            target = target.prev;
        }

        if (target == null) {
            throw new IllegalArgumentException("Value " + val + " does not exist");
        }

        target.prev.next = target.next;
        target.next.prev = target.prev;

        this.size--;
    }

    public void dropAll() {
        this.head = null;
        this.tail = null;
    }

    public boolean has(int val) {
        Node current = this.head;

        while (current != null && current.val != val) {
            current = current.prev;
        }

        return current != null;
    }

    public int size() {
        return this.size;
    }

    static class Node {
        Node prev, next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
}
