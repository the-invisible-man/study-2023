package main.java.com.example.DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AdjacencyMatrix {
    /*
            An undirected, unweighted graph for representing
            friendships in a social network using an adjacency matrix.

            This type of data structure is best for dense graphs, defined as

                    E nearing V^2

            This structure is not optimal for sparse graphs as it'll store
            information of both the presence and lack of edges between nodes.

                    G(V, E) -> (V = Vertex, E = Edges)

            Asymptotic Analysis
            --------------------------------------
            Space complexity
                    O(V^2)

            Time complexity of common operations
                    Determining if a node is adjacent: O(1)
                    Finding all adjacent nodes: O(V)
     */
    public static void main(String[] args) {
        String[] names = {"Carlos", "Lidia", "Reymer", "Aaron", "Anastasia", "Sergio"};
        HashMap<String, Integer> vertex = createVertexList(names);
        HashMap<Integer, String> vertexById = reverseVertex(vertex);
        int[][] edges = createMatrix(names.length);

        Stack<String> s = new Stack<>();

        createAdjacency("Carlos", "Lidia", edges, vertex);
        createAdjacency("Carlos", "Reymer", edges, vertex);
        createAdjacency("Carlos", "Aaron", edges, vertex);
        createAdjacency("Carlos", "Sergio", edges, vertex);

        createAdjacency("Lidia", "Sergio", edges, vertex);
        createAdjacency("Lidia", "Anastasia", edges, vertex);

        createAdjacency("Sergio", "Aaron", edges, vertex);
        createAdjacency("Reymer", "Sergio", edges, vertex);

//        checkIfFriends("Reymer", "Anastasia", edges, vertex);
//        checkIfFriends("Lidia", "Anastasia", edges, vertex);

        printMatrix(edges);

        String person = "Lidia";
        System.out.println("\nFriends for " + person + "\n------------------------");
        showAllFriends(person, edges, vertex, vertexById);
    }

    public static void printMatrix(int[][] mat) {
        System.out.print("\n");
        for (int i = 0; i < mat.length; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int k = 0; k < mat.length; k++) {
                    System.out.print(k + " ");
                }
                System.out.print("\n");
            }
            System.out.print(i + " ");
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static HashMap<Integer, String> reverseVertex(HashMap<String, Integer> vertex)
    {
        HashMap<Integer, String> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry: vertex.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    public static void showAllFriends(String person, int[][] matrix, HashMap<String, Integer> vertex, HashMap<Integer, String> reversedVertex)
    {
        int personId = vertex.get(person);

        for (Integer friendId: getAllAdjacentNodes(personId, matrix)) {
            System.out.println(reversedVertex.get(friendId));
        }
    }

    public static ArrayList<Integer> getAllAdjacentNodes(int node, int[][] matrix) {
        ArrayList<Integer> adjacentNodes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1) {
                adjacentNodes.add(i);
            }
        }

        return adjacentNodes;
    }

    public static int[][] createMatrix(int size) {
        int[][] mat = new int[size][size];

        // Initialize all elements
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mat[i][j] = 0;
            }
        }

        return mat;
    }

    public static void createAdjacency(String personOne, String personTwo, int[][] matrix, HashMap<String, Integer> vertexList) {
        if (!vertexList.containsKey(personOne)) {
            throw new RuntimeException(personOne + " is an invalid entry");
        } else if (!vertexList.containsKey(personTwo)) {
            throw new RuntimeException(personTwo + " is an invalid entry");
        }

        int personOneId = vertexList.get(personOne);
        int personTwoId = vertexList.get(personTwo);

        matrix[personOneId][personTwoId] = 1;
        matrix[personTwoId][personOneId] = 1;
    }

    public static void checkIfFriends(String personOne, String personTwo, int[][] matrix, HashMap<String, Integer> vertexList)
    {
        if (isAdjacent(personOne, personTwo, matrix, vertexList)) {
            System.out.println(personOne + " and " + personTwo + " are friends");
        } else {
            System.out.println(personOne + " and " + personTwo + " are not friends");
        }
    }

    public static boolean isAdjacent(String personOne, String personTwo, int[][] matrix, HashMap<String, Integer> vertexList)
    {
        int personOneId = vertexList.get(personOne);
        int personTwoId = vertexList.get(personTwo);

        return matrix[personOneId][personTwoId] == 1;
    }

    public static HashMap<String, Integer> createVertexList(String[] people)
    {
        HashMap <String, Integer> list = new HashMap<>();
        int idCounter = 0;

        for (String person: people) {
            list.put(person, idCounter);
            idCounter++;
        }

        return list;
    }
}
