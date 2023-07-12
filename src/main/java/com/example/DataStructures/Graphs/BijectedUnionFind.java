package main.java.com.example.DataStructures.Graphs;

import java.util.HashMap;

public class BijectedUnionFind {
    public int totalGroups;
    public static void main(String[] args) {
        char[] items = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        HashMap<Character, Integer> references = new HashMap<>();

        BijectedUnionFind solution = new BijectedUnionFind();
        solution.totalGroups = items.length;

        int[] graph = solution.buildGraph(items, references);

        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('B', 'A', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('C', 'B', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('D', 'A', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('C', 'A', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('E', 'F', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('F', 'D', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('G', 'H', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('G', 'D', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('I', 'G', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('J', 'K', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('K', 'F', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        solution.union('K', 'A', graph, references);
        System.out.println("Total groups: " + solution.totalGroups);

        int key = 0;

        for (int parent: graph) {
            System.out.println(items[key] + " is connected " + items[parent]);
            key++;
        }
    }

    public int[] buildGraph(char[] items, HashMap<Character, Integer> references) {
        int[] graph = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            references.put(items[i], i);
            graph[i] = i;
        }

        return graph;
    }

    public void union(char item1, char item2, int[] graph, HashMap<Character, Integer> references) {
        int item1Key = references.get(item1);
        int item2Key = references.get(item2);

        // Get root nodes
        int item1Root = getRoot(item1Key, graph);
        int item2Root = getRoot(item2Key, graph);

        if (item1Root != item2Root) {
            this.totalGroups--;
        }

        if (groupSize(item1Root, graph) <= groupSize(item2Root, graph)) {
            compress(item1Root, item2Root, graph);
        } else {
            compress(item2Root, item1Root, graph);
        }
    }

    public void compress(int oldKey, int newKey, int[] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == oldKey) {
                graph[i] = newKey;
            }
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

    public int groupSize(int rootVal, int[] graph) {
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            // If we reached the root, and its value doesn't refer
            // to itself, then it's pointing to another group,
            // Count that group and sum its size to this group's size
            if (rootVal == i && graph[rootVal] != rootVal) {
                count += groupSize(graph[rootVal], graph);
            }

            if (graph[i] == rootVal) {
                count++;
            }
        }

        return count;
    }
}
