package main.java.com.example.Algorithms;

import main.java.com.example.DataStructures.LinkedList.ListNode;

import java.util.*;

public class Tarjans {
    // Find strongly connected components in a graph
    //
    //    A <------ C             E                   H -----------> I
    //    \        ^             ^ \                  ^              |
    //     \      /             /   \                 |              |
    //      \    /             /     \                |              |
    //       v  /             /       v               |              v
    //        B -----------> D <------ F <----------- G <----------- J --------> K
    //
    //  DFS through the graph by picking a random node.
    //      - Assign the node an ID and a low link value equal to its ID
    //      - Add node to stack of current candidates for a component
    //      - Add node to a set of visited nodes to avoid visiting the same node again
    //  Explore its children and repeat the process
    //  Once you reach a node you have already visited, backtrack to the previous node
    //  Assign a low link value to the node you backtracked to of min(low link of "node at bottom of slack", low link of current node)
    //  Continue backtracking until you reach a node whose current low link value is equal to its ID after applying the step above
    //      - You found a strongly connect component in the graph
    //  Pop all nodes off the stack of component candidates
    //  Pick a new unvisited node, and start the process over until all nodes have been visited

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        HashMap<Character, Integer> bijections = new HashMap<>();
        ListNode[] edges = new ListNode[vertex.length];
        List<List<ListNode>> components;

        for (int i = 0; i < vertex.length; i++) {
            bijections.put(vertex[i], i);
        }

        // Component 1
        createSingleAdjacency('A', 'B', edges, bijections);
        createSingleAdjacency('B', 'C', edges, bijections);
        createSingleAdjacency('C', 'A', edges, bijections);

        // Bridge
        createSingleAdjacency('B', 'D', edges, bijections);

        // Component 2
        createSingleAdjacency('D', 'E', edges, bijections);
        createSingleAdjacency('E', 'F', edges, bijections);
        createSingleAdjacency('F', 'D', edges, bijections);

        // Bridge
        createSingleAdjacency('G', 'F', edges, bijections);

        // Component 3
        createSingleAdjacency('G', 'H', edges, bijections);
        createSingleAdjacency('H', 'I', edges, bijections);
        createSingleAdjacency('I', 'J', edges, bijections);

        // Component 4
        createSingleAdjacency('J', 'K', edges, bijections);

        components = getComponents(edges);

        for (List<ListNode> component: components) {
            System.out.println("Component");
            for (ListNode node: component) {
                System.out.println(vertex[node.val]);
            }
        }
    }

    public static List<List<ListNode>> getComponents(ListNode[] edges)
    {
        Stack<ListNode> currentlyVisiting = new Stack<>();
        boolean[] onStack = new boolean[edges.length];
        HashMap<Integer, Integer> lowLinkValues = new HashMap<>();

        Set<Integer> visitedAllNeighbors = new HashSet<>();
        List<List<ListNode>> result = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            if (visitedAllNeighbors.contains(i)) continue;
//            dfs(i, edges, currentlyVisiting, visitedAllNeighbors, lowLinkValues, onStack);
        }

        return result;
    }

//    public static void dfs(int node, ListNode[] edges, Stack<ListNode> candidates, Set<Integer> visited, HashMap<Integer, Integer> lowLinkValues, boolean[] onStack)
//    {
//        candidates.add(node);
//        lowLinkValues.put(node.val, node.val);
//        visited.add(node.val);
//
//        // Prepare to visit all neighbors
//        ListNode currentChild = edges[node.val];
//
//        // Visit all neighbors
//        while (currentChild != null) {
//            // We'll visit a neighbor as long as it hasn't already been visited
//            if (!visited.contains(currentChild.val)) {
//                visited.add(currentChild.val);
//                dfs(currentChild, edges, currentlyVisiting, visited, lowLinkValues);
//            }
//            currentChild = currentChild.next;
//        }
//
//        int bottomLowIndex = lowLinkValues.get(currentlyVisiting.get(0).val);
//        lowLinkValues.put(node.val, Math.min(lowLinkValues.get(node.val), bottomLowIndex));
//    }

    public static void createSingleAdjacency(char a, char b, ListNode[] edges, HashMap<Character, Integer> bijections) {
        int key = bijections.get(a);

        if (edges[key] == null) {
            edges[key] = new ListNode();
            edges[key].val = bijections.get(b);
            return;
        }

        ListNode tail = edges[key];

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = new ListNode();
        tail.next.val = bijections.get(b);
    }

    public static void createCyclicAdjacency(char a, char b, ListNode[] edges, HashMap<Character, Integer> bijections) {
        createSingleAdjacency(a, b, edges, bijections);
        createSingleAdjacency(b, a, edges, bijections);
    }
}
