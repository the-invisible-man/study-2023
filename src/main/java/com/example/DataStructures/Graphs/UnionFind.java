package main.java.com.example.DataStructures.Graphs;

public class UnionFind {
    public int totalGroups;

    public int[] groupSize;
    public static void main(String[] args) {
        //             A  B  C  D  E  F  G  H  I  J  K   L
        int[] items = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        UnionFind solution = new UnionFind();
        solution.totalGroups = items.length;
        solution.groupSize = new int[items.length];

        int[] graph = solution.buildGraph(items.length);

        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(1, 0, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(2, 1, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(3, 0, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(2, 0, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(4, 5, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(5, 3, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(6, 7, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(6, 3, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(8, 6, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(9, 10, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(10, 5, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(10, 0, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union(11, 6, graph);
        System.out.println("Total groups: " + solution.totalGroups);

        int key = 0;

        for (int parent: graph) {
            System.out.println(items[key] + " is connected " + items[parent]);
            key++;
        }
    }

    public int[] buildGraph(int n) {
        int[] graph = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = i;
        }

        return graph;
    }

    public void union(int item1Key, int item2Key, int[] graph) {
        // Get root nodes
        int item1Root = getRoot(item1Key, graph);
        int item2Root = getRoot(item2Key, graph);

        if (item1Root != item2Root) {
            this.totalGroups--;
        }

        if (groupSize(item1Root) <= groupSize(item2Root)) {
            graph[item1Key] = item2Root;
            this.groupSize[item2Root]++;
        } else {
            graph[item2Key] = item1Root;
            this.groupSize[item1Root]++;
        }
    }

    public int getRoot(int key, int[] graph) {
        // Given the key, traverse through the tree
        // until you reach the root. Return the root
        // Should account for lack of path compression
        if (key != graph[key]) {
            return getRoot(graph[key], graph);
        }

        return key;
    }

    public int groupSize(int rootVal) {
        return this.groupSize[rootVal];
    }
}
