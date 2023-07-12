package main.java.com.example.FinalReview.Sunday;

import main.java.com.example.FinalReview.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskals {
    public static void main(String[] args) {
        int[][] edges = new int[18][3];
        main.java.com.example.FinalReview.UnionFind uf = new UnionFind(18);

        // 0  1  2  3  4  5  6  7  8  9
        // A  B  C  D  E  F  G  H  I  J

        // A
        addUndirectedEdge(0, 1, 5, edges, 0);
        addUndirectedEdge(0, 3, 4, edges, 1);
        addUndirectedEdge(0, 4, 1, edges, 2);

        // B
        addUndirectedEdge(1, 2, 4, edges, 3);
        addUndirectedEdge(1, 3, 2, edges, 4);

        // C
        addUndirectedEdge(2, 7, 4, edges, 5);
        addUndirectedEdge(2, 8, 1, edges, 6);
        addUndirectedEdge(2, 9, 2, edges, 7);

        // D
        addUndirectedEdge(3, 4, 2, edges, 8);
        addUndirectedEdge(3, 5, 5, edges, 9);
        addUndirectedEdge(3, 6, 11, edges, 10);
        addUndirectedEdge(3, 7, 2, edges, 11);

        // E
        addUndirectedEdge(4, 5, 1, edges, 12);

        // F
        addUndirectedEdge(5, 6, 7, edges, 13);

        // G
        addUndirectedEdge(6, 7, 1, edges, 14);
        addUndirectedEdge(6, 8, 4, edges, 15);

        // H
        addUndirectedEdge(7, 8, 6, edges, 16);

        // I
        addUndirectedEdge(8, 9, 0, edges, 17);

        java.util.Arrays.sort(edges, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });

        int weight = 0;

        for (int[] edge: edges) {
            if (uf.isConnected(edge[0], edge[1])) continue;

            uf.union(edge[0], edge[1]);

            weight += edge[2];
        }

        System.out.println("Min span tree weight: " + weight);
    }

    public static void addUndirectedEdge(int v1, int v2, int weight, int[][] edges, int key) {
        edges[key] = new int[]{v1, v2, weight};
    }
}
