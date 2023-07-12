package main.java.com.example.Leet.Easy;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class QueueUsingStacks {
    Stack<Integer> read;
    Stack<Integer> write;

    public QueueUsingStacks() {
        read = new Stack<>();
        write = new Stack<>();
    }

    public void push(int x) {
        write.push(x);
    }

    public int pop() {
        if (read.empty()) {
            this.moveStacks();
        }

        return read.pop();
    }

    private void moveStacks() {
        while (!write.empty()) {
            read.push(write.pop());
        }
    }

    public int peek() {
        if (read.empty()) {
            this.moveStacks();
        }

        return read.peek();
    }

    public boolean empty() {
        return read.empty() && write.empty();
    }
}
