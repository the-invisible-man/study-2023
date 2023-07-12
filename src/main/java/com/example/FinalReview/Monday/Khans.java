package main.java.com.example.FinalReview.Monday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Khans {
    public static void main(String[] args) {
        List<Integer>[] graph = new ArrayList[14];

        addEdge(9, 2, graph);
        addEdge(9, 10, graph);

        addEdge(10, 6, graph);
        addEdge(2, 6, graph);

        addEdge(6, 7, graph);
        addEdge(6, 11, graph);

        addEdge(7, 12, graph);
        addEdge(7, 4, graph);

        addEdge(11, 12, graph);

        addEdge(4, 5, graph);
        addEdge(4, 8, graph);

        addEdge(1, 4, graph);

        addEdge(3, 4, graph);
        addEdge(3, 1, graph);

        addEdge(0, 2, graph);
        addEdge(0, 6, graph);
        addEdge(0, 3, graph);

        List<Integer> res = topSort(graph);

        if (res == null) {
            System.out.println("Bro pls, there is a cycle in this graph");
            return;
        }

        for (int i: res) {
            System.out.println(i);
        }
    }

    public static List<Integer> topSort(List<Integer>[] graph) {
        int n = graph.length;
        int[] inDegrees = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (graph[i] == null) continue;
            for (int dep: graph[i]) {
                inDegrees[dep]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int current = q.poll();
                result.add(current);
                index++;

                if (graph[current] != null) {
                    for (int dep: graph[current]) {
                        inDegrees[dep]--;

                        if (inDegrees[dep] == 0) {
                            q.add(dep);
                        }
                    }
                }
            }
        }

        if (index != n) {
            return null;
        }

        return result;
    }

    public static void addEdge(int u, int v, List<Integer>[] graph) {
        if (graph[u] == null) {
            graph[u] = new ArrayList<>();
        }

        graph[u].add(v);
    }
}
