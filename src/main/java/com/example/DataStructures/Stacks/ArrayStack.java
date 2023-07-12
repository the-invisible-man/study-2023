package main.java.com.example.DataStructures.Stacks;

public class ArrayStack {
    private int top = -1;

    private int[] data = new int[5];

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

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
            System.out.println("The stack is empty");
        }
    }

    public void push(int value) {
        if (this.top == this.data.length - 1) {
            int[] temp = this.data;
            this.data = new int[this.data.length*2];
            System.arraycopy(temp, 0, this.data, 0, temp.length);
        }
        this.top++;
        this.data[top] = value;
    }

    public int top() {
        return this.data[this.top];
    }

    public int pop() {
        int val = this.top();
        this.top--;

        return val;
    }

    public boolean isEmpty() {
        return top < 0;
    }
}
