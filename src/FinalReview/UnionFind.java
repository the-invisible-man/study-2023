package FinalReview;

public class UnionFind {

    private final int[] graph;

    private int totalComponents;

    private final int[] groupSize;

    public UnionFind(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Union find requires size greater than 0");

        this.graph = new int[size];
        this.totalComponents = size;
        this.groupSize = new int[size];

        for (int i = 0; i < size; i++) {
            this.graph[i] = i;
            this.groupSize[i] = 1;
        }
    }

    public boolean isConnected(int item1, int item2) {
        return this.find(item1) == this.find(item2);
    }

    public int componentSize(int item) {
        return this.groupSize[this.find(item)];
    }

    public void union(int item1, int item2) {
        int root1 = this.find(item1);
        int root2 = this.find(item2);

        if (root1 == root2) {
            // These two already belong to the same group
            return;
        }

        if (this.groupSize[root1] < this.groupSize[root2]) {
            this.groupSize[root2] += this.groupSize[root1];
            this.graph[root1] = root2;
        } else {
            this.groupSize[root1] += this.groupSize[root2];
            this.graph[root2] = root1;
        }

        this.totalComponents--;
    }

    public int find(int item) {
        int rootKey = item;

        while(rootKey != this.graph[rootKey]) {
            rootKey = this.graph[rootKey];
        }

        // Compress path
        while(item != rootKey) {
            int next = this.graph[item];
            this.graph[item] = rootKey;
            item = next;
        }

        return rootKey;
    }

    public int totalComponents() {
        return this.totalComponents;
    }
}
