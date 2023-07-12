package main.java.com.example.FinalReview.Monday;

public class UnionFind {
    private int totalComponents;
    private final int[] components;
    private final int[] componentSize;

    public UnionFind(int size) {
        this.components = new int[size];
        this.componentSize = new int[size];
        this.totalComponents = size;

        for(int i = 0; i < size; i++) {
            this.componentSize[i] = 1;
            this.components[i] = i;
        }
    }

    public int find(int item) {
        int rootKey = item;

        while (rootKey != this.components[rootKey]) {
            rootKey = this.components[rootKey];
        }

        while(rootKey != item) {
            int next = this.components[item];
            this.components[item] = rootKey;
            item = next;
        }

        return rootKey;
    }

    public boolean isConnected(int item1, int item2) {
        return this.find(item1) == this.find(item2);
    }

    public int componentSize(int item) {
        return this.componentSize[this.find(item)];
    }

    public int totalComponents() {
        return this.totalComponents;
    }

    public void union(int item1, int item2) {
        int item1Root = this.find(item1);
        int item2Root = this.find(item2);

        if (item1Root == item2Root) {
            return;
        }

        if (this.componentSize[item1Root] < this.componentSize[item2Root]) {
            this.componentSize[item2Root] += this.componentSize[item1Root];
            this.components[item1Root] = item2Root;
        } else {
            this.componentSize[item1Root] += this.componentSize[item2Root];
            this.components[item2Root] = item1Root;
        }

        this.totalComponents--;
    }
}
