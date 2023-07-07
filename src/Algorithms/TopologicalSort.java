package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {
    public static void main(String[] args) {
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        List<Character> result;

        addEdge('c', 'a', adjacencyList);
        addEdge('c', 'b', adjacencyList);

        addEdge('a', 'd', adjacencyList);
        addEdge('b', 'd', adjacencyList);

        addEdge('d', 'h', adjacencyList);
        addEdge('d', 'g', adjacencyList);

        addEdge('e', 'a', adjacencyList);
        addEdge('e', 'd', adjacencyList);
        addEdge('e', 'f', adjacencyList);

        addEdge('f', 'k', adjacencyList);
        addEdge('f', 'j', adjacencyList);

        addEdge('g', 'i', adjacencyList);

        addEdge('h', 'j', adjacencyList);
        addEdge('h', 'i', adjacencyList);

        addEdge('i', 'l', adjacencyList);

        addEdge('j', 'l', adjacencyList);
        addEdge('j', 'm', adjacencyList);

        addEdge('k', 'j', adjacencyList);

        result = topSort(adjacencyList);

        System.out.println("Topological sort result");

        for (int i = result.size() - 1; i >= 0; i--){
            System.out.println(result.get(i));
        }
    }

    public static List<Character> topSort(Map<Character, List<Character>> adjacencyList) {
        // For the purpose of this demo, we're going to have at most 26 nodes
        // A node for each letter of the alphabet
        boolean[] visited = new boolean[26];
        List<Character> result = new ArrayList<>();

        for (Map.Entry<Character, List<Character>> entry: adjacencyList.entrySet()) {
            if (!visited[entry.getKey() - 'a']) {
                System.out.println("Processing at character " + entry.getKey());
                dfs(entry.getKey(), adjacencyList, visited, result);
            } else {
                System.out.println("Skipped char " + entry.getKey());
            }
        }

        return result;
    }

    public static void dfs(char u, Map<Character, List<Character>> adjacencyList, boolean[] visited, List<Character> result) {
        visited[u-'a'] = true;

        for (char v: getNeighbors(u, adjacencyList)) {
            if (!visited[v-'a']) {
                dfs(v, adjacencyList, visited, result);
            }
        }

        result.add(u);
    }

    public static void addEdge(char u, char v, Map<Character, List<Character>> adjacencyList) {
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public static List<Character> getNeighbors(char u, Map<Character, List<Character>> adjacencyList) {
        return adjacencyList.getOrDefault(u, new ArrayList<>());
    }
}
