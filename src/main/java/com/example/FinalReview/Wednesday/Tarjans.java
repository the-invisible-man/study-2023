package main.java.com.example.FinalReview.Wednesday;

import java.util.*;

public class Tarjans {
    /*
        Time complexity: O(V + E), where V is the number of vertices and E is the number of
        edges in the graph. Tarjan's algorithm performs a depth-first search (DFS) traversal
        of the graph, visiting each vertex and edge once. The algorithm uses a stack to keep
        track of the visited vertices and their descendants, resulting in a linear time complexity.

        Space complexity: O(V), where V is the number of vertices. The space complexity is
        determined by the stack used during the DFS traversal. The maximum space required is
        proportional to the maximum depth of the recursion stack, which can be at most V.
     */
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();

        // Component 1
        addEdge('a', 'b', graph);
        addEdge('b', 'a', graph);

        // Component 2
        addEdge('c', 'd', graph);
        addEdge('d', 'e', graph);
        addEdge('e', 'c', graph);

        // Component 3
        addEdge('f', 'h', graph);
        addEdge('h', 'g', graph);
        addEdge('g', 'f', graph);

        // Component 4
        addEdge('h', 'i', graph);

        HashMap<Integer, List<Character>> components = getComponents(graph);

        for (Map.Entry<Integer, List<Character>> entry: components.entrySet()) {
            System.out.println("Component");
            for (char n: entry.getValue()) {
                System.out.println(n);
            }
        }
    }

    public static HashMap<Integer, List<Character>> getComponents(Map<Character, List<Character>> graph) {
        Set<Character> visited = new HashSet<>();
        HashMap<Character, Node> lowLinkValTracker = new HashMap<>();
        HashMap<Integer, List<Character>> components = new HashMap<>();

        for (Map.Entry<Character, List<Character>> entry: graph.entrySet()) {
            Deque<Node> stack = new ArrayDeque<>();
            Set<Integer> stackTracker = new HashSet<>();

            if (visited.contains(entry.getKey())) continue;

            Node n = dfs(entry.getKey(), graph, visited, lowLinkValTracker, stack, stackTracker);

            if (n != null && n.lowLinkValue == n.id) {
                // This started a strongly connected component
                while (!stack.isEmpty()) {
                    Node cu = stack.pop();
                    components.computeIfAbsent(cu.lowLinkValue, k -> new ArrayList<>()).add(cu.value);
                }
            }
        }

        return components;
    }

    public static Node dfs(char v, Map<Character, List<Character>> graph, Set<Character> visited, HashMap<Character, Node> lowLinkValTracker, Deque<Node> stack, Set<Integer> stackTracker) {
        if (visited.contains(v)) return lowLinkValTracker.get(v);

        visited.add(v);

        Node currentNode = new Node(v);
        currentNode.id = lowLinkValTracker.size();
        currentNode.lowLinkValue = currentNode.id;

        lowLinkValTracker.put(v, currentNode);

        // Tack nodes
        stackTracker.add(currentNode.id);
        stack.add(currentNode);

        for (char node: graph.getOrDefault(v, new ArrayList<>())) {
            Node prev = dfs(node, graph, visited, lowLinkValTracker, stack, stackTracker);
            if (prev != null && stackTracker.contains(prev.id)) {
                currentNode.lowLinkValue = Integer.min(currentNode.lowLinkValue, prev.lowLinkValue);
            }
        }

        return currentNode;
    }

    public static void addEdge(char u, char v, Map<Character, List<Character>> graph) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    static class Node {
        public int id, lowLinkValue;
        public char value;

        public Node(char v) {
            this.value = v;
        }
    }
}
