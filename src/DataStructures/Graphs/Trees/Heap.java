package DataStructures.Graphs.Trees;

public class Heap {
    private static final int MIN = 896;
    private static final int MAX = 358;

    private int[] heap;

    private final int type;

    private int size = 0;

    public static void main(String[] args) {
        Heap mh = new Heap(MIN);

        mh.enqueue(5);
        mh.enqueue(4);
        mh.enqueue(20);
        mh.enqueue(2);
        mh.enqueue(3);
        mh.enqueue(1);
        mh.enqueue(-34);
        mh.enqueue(1000);

        while (!mh.isEmpty()) {
            System.out.println("-------------------------");
            System.out.println("Top is " + mh.peek());
            System.out.println("Removed " + mh.dequeue());
        }
    }

    public Heap(int type) {
        this.type = type;
        this.heap = new int[1000];
    }

    public void printHeap() {
        String output = "";
        for (int i = 0; i < this.size; i++) {
            output = output + this.heap[i];

            if (i < this.size - 1) {
                output = output + ", ";
            }
        }

        System.out.println("[" + output + "]");
    }

    public void enqueue(int val) {
        if (this.type == MAX) {
            val = -val;
        }

        // Add to the end of the heap
        this.heap[this.size] = val;

        // Make sure this new value satisfies the heap invariant.
        int currentIndex = this.size;
        int parentIndex = ((int)Math.ceil(currentIndex/2.0)) - 1;

        while (parentIndex >= 0 && this.heap[parentIndex] > this.heap[currentIndex]) {
            int swap = this.heap[currentIndex];
            this.heap[currentIndex] = this.heap[parentIndex];
            this.heap[parentIndex] = swap;

            currentIndex = parentIndex;
            parentIndex = ((int)Math.ceil(currentIndex/2.0)) - 1;
        }

        this.size++;

        if (this.size == this.heap.length - 1) {
            this.resize();
        }
    }

    public void resize() {
        int[] resized = new int[this.heap.length * 2];

        for (int i = 0; i < this.heap.length; i++) {
            resized[i] = this.heap[i];
        }

        this.heap = resized;
    }

    public int dequeue() {
        int result = this.heap[0];

        if (this.size > 0) {
            // Swap the root and the last element
            int swap;
            this.heap[0] = this.heap[this.size-1];

            this.size--;

            int currentIndex = 0;
            int leftChild = 1;
            int rightChild = 2;

            while(currentIndex < this.size - 1 && (this.heap[currentIndex] > this.heap[leftChild] || (rightChild < this.size || this.heap[currentIndex] > this.heap[rightChild]))) {
                swap = this.heap[currentIndex];

                if (rightChild < this.size && this.heap[leftChild] > this.heap[rightChild]) {
                    this.heap[currentIndex] = this.heap[rightChild];
                    this.heap[rightChild] = swap;
                    currentIndex = rightChild;
                } else {
                    this.heap[currentIndex] = this.heap[leftChild];
                    this.heap[leftChild] = swap;
                    currentIndex = leftChild;
                }

                leftChild = 2 * currentIndex + 1;
                rightChild = 2 * currentIndex + 2;
            }

            if (this.type == MAX) {
                return -result;
            }

            return result;
        }

        this.size--;

        if (this.type == MAX) {
            return -result;
        }

        return result;
    }

    public int peek() {
        if (this.type == MAX) {
            return -this.heap[0];
        }
        return this.heap[0];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
