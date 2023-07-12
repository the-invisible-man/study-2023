package main.java.com.example.DataStructures.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import main.java.com.example.DataStructures.LinkedList.Node;

public class AdjacencyList {
    public static void main(String[] args) {
        String[] names = {"Carlos", "Lidia", "Reymer", "Aaron", "Anastasia", "Sergio"};
        HashMap<String, Integer> vertex = createVertexList(names);
        HashMap<Integer, String> vertexById = reverseVertex(vertex);
        Node[] edges = new Node[names.length];

        createAdjacency("Carlos", "Lidia", edges, vertex);
        createAdjacency("Carlos", "Reymer", edges, vertex);
        createAdjacency("Carlos", "Aaron", edges, vertex);
        createAdjacency("Carlos", "Sergio", edges, vertex);

        createAdjacency("Lidia", "Sergio", edges, vertex);
        createAdjacency("Lidia", "Anastasia", edges, vertex);

        createAdjacency("Sergio", "Aaron", edges, vertex);
        createAdjacency("Reymer", "Sergio", edges, vertex);

        checkIfFriends("Reymer", "Anastasia", edges, vertex);
        checkIfFriends("Lidia", "Anastasia", edges, vertex);

        String person = "Carlos";
        System.out.println("\nFriends for " + person + "\n------------------------");
        showAllFriends(person, edges, vertex, vertexById);

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[names.length];
        Integer current;
        Node currentChild;
        int nodeLinearScan = 1;

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            current = q.peek();

            if (!visited[current]) {
                currentChild = edges[current];

                while (currentChild != null) {
                    if (!visited[currentChild.data]) {
                        q.add(currentChild.data);
                        currentChild = currentChild.next;
                    }
                }

                System.out.println(current);
                visited[current] = true;
            }

            q.poll();

            if (q.isEmpty() && nodeLinearScan < names.length) {
                q.add(nodeLinearScan);
                nodeLinearScan++;
            }
        }
    }

    public static void showAllFriends(String person, Node[] edges, HashMap<String, Integer> vertexList, HashMap<Integer, String> vertexById) {
        int personId = vertexList.get(person);
        Node current = edges[personId];

        while (current != null) {
            System.out.println(vertexById.get(current.data));
            current = current.next;
        }
    }

    public static void createAdjacency(String personOne, String personTwo, Node[] matrix, HashMap<String, Integer> vertexList) {
        int personOneId = vertexList.get(personOne);
        int personTwoId = vertexList.get(personTwo);

        createSingleAdjacency(personOneId, personTwoId, matrix);
        createSingleAdjacency(personTwoId, personOneId, matrix);
    }

    public static void createSingleAdjacency(Integer subjectId, Integer relationId, Node[] edges) {
        if (edges[subjectId] == null) {
            edges[subjectId] = new Node();
            edges[subjectId].data = relationId;
            return;
        }

        Node tail = edges[subjectId];

        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = new Node();
        tail.next.data = relationId;
    }

    public static void checkIfFriends(String personOne, String personTwo, Node[] edges, HashMap<String, Integer> vertexList) {
        int personOneId = vertexList.get(personOne);
        int personTwoId = vertexList.get(personTwo);

        Node current = edges[personOneId];

        while (current != null) {
            if (current.data == personTwoId) {
                System.out.println(personOne + " and " + personTwo + " are friends");
                return;
            }

            current = current.next;
        }

        System.out.println(personOne + " and " + personTwo + " are NOT friends");
    }

    public static HashMap<Integer, String> reverseVertex(HashMap<String, Integer> vertex)
    {
        HashMap<Integer, String> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry: vertex.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
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
