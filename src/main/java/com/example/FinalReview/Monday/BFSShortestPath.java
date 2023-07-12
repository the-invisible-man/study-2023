package main.java.com.example.FinalReview.Monday;

import java.util.*;

public class BFSShortestPath {
    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    public static void testCase1()
    {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        addEdge(0, 1, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(1, 3, adjacencyList);
        addEdge(2, 4, adjacencyList);
        addEdge(3, 4, adjacencyList);
        addEdge(3, 5, adjacencyList);
        addEdge(4, 5, adjacencyList);

        int startNode = 0;
        int targetNode = 5;

        List<Integer> shortestPath = bfsShortestPath(adjacencyList, startNode, targetNode);
        System.out.println("Shortest Path from " + startNode + " to " + targetNode + ": " + shortestPath);
    }

    public static void testCase2() {
        Map<Integer, List<Integer>> adjacencyList2 = new HashMap<>();
        addEdge(0, 1, adjacencyList2);
        addEdge(0, 2, adjacencyList2);
        addEdge(1, 3, adjacencyList2);
        addEdge(1, 4, adjacencyList2);
        addEdge(2, 4, adjacencyList2);
        addEdge(3, 4, adjacencyList2);
        addEdge(3, 5, adjacencyList2);
        addEdge(4, 5, adjacencyList2);

        int startNode2 = 2;
        int targetNode2 = 3;

        List<Integer> shortestPath = bfsShortestPath(adjacencyList2, startNode2, targetNode2);
        System.out.println("Shortest Path from " + startNode2 + " to " + targetNode2 + ": " + shortestPath);
    }

    public static void testCase3() {
        Map<Integer, List<Integer>> adjacencyList3 = new HashMap<>();
        addEdge(0, 1, adjacencyList3);
        addEdge(0, 2, adjacencyList3);
        addEdge(1, 3, adjacencyList3);
        addEdge(2, 4, adjacencyList3);
        addEdge(3, 4, adjacencyList3);
        addEdge(3, 5, adjacencyList3);
        addEdge(4, 5, adjacencyList3);
        addEdge(6, 3, adjacencyList3);

        int startNode3 = 0;
        int targetNode3 = 6;

        List<Integer> shortestPath = bfsShortestPath(adjacencyList3, startNode3, targetNode3);
        System.out.println("Shortest Path from " + startNode3 + " to " + targetNode3 + ": " + shortestPath);
    }

    public static List<Integer> bfsShortestPath(Map<Integer, List<Integer>> graph, int start, int end) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        int[] prev = new int[graph.size()];
        List<Integer> result = new ArrayList<>();
        boolean found = false;

        for (int i = 0; i < graph.size(); i++) {
            prev[i] = -1;
        }

        q.add(start);
        visited[start] = true;

        mainLoop: while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int current = q.poll();

                for (int v: graph.getOrDefault(current, new ArrayList<>())) {
                    if (visited[v]) continue;
                    visited[v] = true;
                    q.add(v);
                    prev[v] = current;

                    if (v == end) {
                        found = true;
                        break mainLoop;
                    }
                }
            }
        }

        if (!found) {
            return null;
        }

        for (int at = end; at != -1; at = prev[at]) {
            result.add(at);
        }

        Collections.reverse(result);

        return result;
    }

    private static void addEdge(int u, int v, Map<Integer, List<Integer>> adjacencyList) {
        adjacencyList.putIfAbsent(u, new ArrayList<>());
        adjacencyList.putIfAbsent(v, new ArrayList<>());
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }
}
