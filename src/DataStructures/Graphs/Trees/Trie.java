package DataStructures.Graphs.Trees;

import java.util.Stack;

public class Trie {
    public static void main(String[] args) {
        Node root = new Node();

        addWord("car", root);
        addWord("cat", root);

        if (hasWord("car", root)) {
            System.out.println("The word car exists");
        }

        if (!hasWord("cup", root)) {
            System.out.println("The word cup does not exist");
        }

        addWord("cup", root);

        if (hasWord("cup", root)) {
            System.out.println("The word cup exists");
        }

        if (hasWord("cat", root)) {
            System.out.println("The word cat exists");
        }

        removeWord("car", root);

        if (!hasWord("car", root)) {
            System.out.println("The word car has been removed");
        }

        if (hasWord("cat", root)) {
            System.out.println("The word cat exists");
        }

        addWord("", root);
    }

    public static void addWord(String word, Node root) {
        Node current = root;

        for (char c: word.toCharArray()) {
            if (current.characters[c - 'a'] == null) {
                current.characters[c - 'a'] = new Node();
            }
            current = current.characters[c - 'a'];
        }

        current.isWord = true;
    }

    public static boolean hasWord(String word, Node root) {
        Node current = root;

        for (char c: word.toCharArray()) {
            if (current.characters[c - 'a'] == null) {
                return false;
            }
            current = current.characters[c - 'a'];
        }

        return current.isWord;
    }

    public static void removeWord(String word, Node root) {
        Node current = root;
        Stack<Character> s = new Stack<>();
        Stack<Node> nodes = new Stack<>();

        for (char c: word.toCharArray()) {
            s.push(c);
            nodes.push(current);
            current = current.characters[c-'a'];
        }

        if (hasChildren(current)) {
            current.isWord = false;
            return;
        }

        while (!s.isEmpty()) {
            char currentC = s.pop();
            current = nodes.pop();

            if (hasChildren(current.characters[currentC - 'a'])) {
                return;
            }

            current.characters[currentC - 'a'] = null;
        }
    }

    public static boolean hasChildren(Node root) {
        for (Node n: root.characters) {
            if (n != null) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        Node[] characters = new Node[26];
        boolean isWord = false;
    }
}