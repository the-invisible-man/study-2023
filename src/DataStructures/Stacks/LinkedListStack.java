package DataStructures.Stacks;

import DataStructures.LinkedList.Node;

public class LinkedListStack {
    private Node tail;
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(2);
        stack.push(5);
        stack.push(56);
        stack.push(34);
        stack.push(67);
        stack.push(5768);
        stack.push(23);
        stack.push(34);
        stack.push(456);
        stack.push(657);
        stack.push(23);
        stack.push(216);
        stack.push(75642);
        stack.push(45);
        stack.push(56);

        int i = 14;

        while (i >= 0) {
            System.out.println(stack.pop());
            i--;
        }

        if (stack.isEmpty()) {
            System.out.println("The stack is empty, fo sho");
        }
    }
    public void push(int value) {
        if (this.tail == null) {
            this.tail = new Node();
            this.tail.data = value;
            return;
        }

        Node newNode = new Node();
        newNode.data = value;
        newNode.previous = this.tail;
        this.tail = newNode;
    }

    public int top() {
        return this.tail.data;
    }

    public int pop() {
        int val = this.top();
        this.tail = this.tail.previous;

        return val;
    }

    public boolean isEmpty() {
        return this.tail == null;
    }
}
