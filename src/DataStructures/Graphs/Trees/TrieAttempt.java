package DataStructures.Graphs.Trees;

public class TrieAttempt {
    public static void main(String[] args) {
        Node root = new Node();

        addWord("dog", root);
        addWord("doggy", root);

        if (hasWord("dog", root)) {
            System.out.println("Word exists");
        } else {
            System.out.println("Word doesn't exists");
        }

        if (hasWord("doggy", root)) {
            System.out.println("Word exists");
        } else {
            System.out.println("Word doesn't exists");
        }

        if (hasWord("rabbit", root)) {
            System.out.println("Word exists");
        } else {
            System.out.println("Word doesn't exist");
        }
    }

    public static boolean hasWord(String word, Node root) {
        Node current = root;

        for (char c: word.toCharArray()) {
            if (current.children[c - ' '] == null) {
                return false;
            }

            current = current.children[c - ' '];
        }

        return current.isWord;
    }

    public static void addWord(String word, Node root) {
        Node current = root;

        for (char c: word.toCharArray()) {
            if (current.children[c - ' '] == null) {
                current.children[c - ' '] = new Node();
            }

            current = current.children[c - ' '];
        }

        current.isWord = true;
    }

    static class Node {
        boolean isWord;
        // Printable ASCII characters start at 32 and end at 126
        // not including extended ASCII characters. That's 94 printable
        // ASCII characters, starting with the "space" character, dec 32.
        Node[] children = new Node[94];
    }
}
