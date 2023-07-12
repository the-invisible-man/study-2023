package main.java.com.example.FinalReview.Sunday;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        HashMap<Character, List<Character>> graph = new HashMap<>();

        addEdge('C', 'A', graph);
        addEdge('C', 'B', graph);

        addEdge('B', 'D', graph);
        addEdge('A', 'D', graph);

        addEdge('E', 'A', graph);
        addEdge('E', 'D', graph);
        addEdge('E', 'F', graph);

        addEdge('D', 'H', graph);
        addEdge('D', 'G', graph);

        addEdge('F', 'K', graph);
        addEdge('F', 'J', graph);

        addEdge('H', 'I', graph);
        addEdge('H', 'J', graph);

        addEdge('J', 'L', graph);
        addEdge('J', 'M', graph);

        addEdge('G', 'I', graph);

        addEdge('I', 'L', graph);

        addEdge('K', 'J', graph);

        List<Character> result = topSort(graph);

        Collections.reverse(result);

        for (Character v: result) {
            System.out.println(v);
        }
    }

    public static List<Character> topSort(Map<Character, List<Character>> graph) {
        // For the purpose of this demo, we're going to have at most 26 nodes
        // A node for each letter of the alphabet
        boolean[] visited = new boolean[26];
        List<Character> result = new ArrayList<>();

        for (Map.Entry<Character, List<Character>> entry: graph.entrySet()) {
            if (visited[entry.getKey()-'A']) continue;
            dfs(entry.getKey(), graph, visited, result);
        }

        return result;
    }

    public static void dfs(Character node, Map<Character, List<Character>> graph, boolean[] visited, List<Character> result) {
        visited[node-'A'] = true;

        for (Character v: graph.getOrDefault(node, new ArrayList<>())) {
            if (visited[v-'A']) continue;
            dfs(v, graph, visited, result);
        }

        result.add(node);
    }

    public static void addEdge(char u, char v, HashMap<Character, List<Character>> graph) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }
}
