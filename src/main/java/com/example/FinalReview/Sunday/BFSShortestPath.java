package main.java.com.example.FinalReview.Sunday;

import java.util.*;

public class BFSShortestPath {
    public static void main(String[] args) {
        List<Integer>[] graph = new LinkedList[13];
        boolean[] visited = new boolean[13];
        int[] prev = new int[13];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 13; i++) {
            graph[i] = new LinkedList<>();
            prev[i] = -1;
        }

        addEdge(0, 11, graph);
        addEdge(0, 7, graph);
        addEdge(0, 9, graph);

        addEdge(1, 10, graph);
        addEdge(1, 8, graph);

        addEdge(2, 12, graph);
        addEdge(2, 3, graph);

        addEdge(3, 4, graph);
        addEdge(3, 7, graph);

        addEdge(5, 6, graph);

        addEdge(7, 6, graph);
        addEdge(7, 11, graph);

        addEdge(8, 12, graph);
        addEdge(8, 9, graph);

        addEdge(9, 10, graph);

        int source = 4;
        int destination = 12;

        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int current = q.poll();
                for (int v: graph[current]) {
                    if (visited[v]) continue;
                    visited[v] = true;
                    prev[v] = current;
                    q.add(v);
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        for (int at = destination; at != -1; at = prev[at]) {
            path.add(at);
        }

        Collections.reverse(path);

        if (path.get(0) == source) {
            System.out.println("Shortest path from " + source + " to " + destination + " is:");
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i));
            }
        }
    }

    public static void addEdge(int source, int destination, List<Integer>[] graph) {
        graph[source].add(destination);
        graph[destination].add(source);
    }
}
