package DataStructures.Graphs.Trees;

public class TreeNodeQueue {

    private QueueNode head;

    private QueueNode tail;

    /**
     * O(1) -> Constant time
     */
    public void enqueue(TreeNode value) {
        if (this.head == null) {
            this.head = new QueueNode();
            this.head.data = value;
            this.tail = this.head;

            return;
        }

        this.tail.next = new QueueNode();
        this.tail.next.data = value;
        this.tail = this.tail.next;
    }

    /**
     * O(1) -> Constant time
     */
    public TreeNode dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        TreeNode val = this.head.data;
        this.head = this.head.next;

        return val;
    }

    public TreeNode front() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return this.head.data;
    }

    /**
     * O(1) -> Constant time
     */
    public boolean isEmpty() {
        return this.head == null;
    }
}

class QueueNode {
    public TreeNode data;
    public QueueNode next;
}
