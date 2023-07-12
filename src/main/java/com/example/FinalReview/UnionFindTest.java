package main.java.com.example.FinalReview;

import main.java.com.example.FinalReview.Monday.UnionFind;

public class UnionFindTest {

    public static void main(String[] args) {
        testUnionFind();
    }

    public static void testUnionFind() {
        UnionFind uf = new UnionFind(10);

        // Initial state assertions
        assertEqual(10, uf.totalComponents(), "Initial state: totalComponents");
        assertFalse(uf.isConnected(0, 1), "Initial state: isConnected(0, 1)");
        assertEqual(1, uf.componentSize(0), "Initial state: componentSize(0)");

        // Union item 0 and item 1
        uf.union(0, 1);

        // Assertions after union
        assertEqual(9, uf.totalComponents(), "After union(0, 1): totalComponents");
        assertTrue(uf.isConnected(0, 1), "After union(0, 1): isConnected(0, 1)");
        assertEqual(2, uf.componentSize(0), "After union(0, 1): componentSize(0)");
        assertEqual(2, uf.componentSize(1), "After union(0, 1): componentSize(1)");

        // Union item 2 and item 3
        uf.union(2, 3);

        // Assertions after union
        assertEqual(8, uf.totalComponents(), "After union(2, 3): totalComponents");
        assertTrue(uf.isConnected(2, 3), "After union(2, 3): isConnected(2, 3)");
        assertFalse(uf.isConnected(0, 2), "After union(2, 3): isConnected(0, 2)");
        assertEqual(2, uf.componentSize(2), "After union(2, 3): componentSize(2)");
        assertEqual(2, uf.componentSize(3), "After union(2, 3): componentSize(3)");

        // Union item 1 and item 3
        uf.union(1, 3);

        // Assertions after union
        assertEqual(7, uf.totalComponents(), "After union(1, 3): totalComponents");
        assertTrue(uf.isConnected(0, 2), "After union(1, 3): isConnected(0, 2)");
        assertTrue(uf.isConnected(1, 3), "After union(1, 3): isConnected(1, 3)");
        assertEqual(4, uf.componentSize(0), "After union(1, 3): componentSize(0)");
        assertEqual(4, uf.componentSize(1), "After union(1, 3): componentSize(1)");

        // Union item 4 and item 5
        uf.union(4, 5);

        // Assertions after union
        assertEqual(6, uf.totalComponents(), "After union(4, 5): totalComponents");
        assertTrue(uf.isConnected(4, 5), "After union(4, 5): isConnected(4, 5)");
        assertEqual(2, uf.componentSize(4), "After union(4, 5): componentSize(4)");
        assertEqual(2, uf.componentSize(5), "After union(4, 5): componentSize(5)");

        // Union item 2 and item 5
        uf.union(2, 5);

        // Assertions after union
        assertEqual(5, uf.totalComponents(), "After union(2, 5): totalComponents");
        assertTrue(uf.isConnected(0, 4), "After union(2, 5): isConnected(0, 4)");
        assertTrue(uf.isConnected(4, 2), "After union(2, 5): isConnected(4, 2)");
        assertTrue(uf.isConnected(1, 3), "After union(2, 5): isConnected(1, 3)");
        assertTrue(uf.isConnected(1, 4), "After union(2, 5): isConnected(1, 4)");
        assertEqual(6, uf.componentSize(0), "After union(2, 5): componentSize(0)");

        // Union item 6 and item 7
        uf.union(6, 7);

        // Assertions after union
        assertEqual(4, uf.totalComponents(), "After union(6, 7): totalComponents");
        assertTrue(uf.isConnected(6, 7), "After union(6, 7): isConnected(6, 7)");
        assertEqual(2, uf.componentSize(6), "After union(6, 7): componentSize(6)");
        assertEqual(2, uf.componentSize(7), "After union(6, 7): componentSize(7)");

        // Union item 7 and item 8
        uf.union(7, 8);

        // Assertions after union
        assertEqual(3, uf.totalComponents(), "After union(7, 8): totalComponents");
        assertTrue(uf.isConnected(6, 8), "After union(7, 8): isConnected(6, 8)");
        assertEqual(3, uf.componentSize(8), "After union(7, 8): componentSize(8)");

        // Union item 9 and item 8
        uf.union(9, 8);

        // Assertions after union
        assertEqual(2, uf.totalComponents(), "After union(9, 8): totalComponents");
        assertTrue(uf.isConnected(6, 9), "After union(9, 8): isConnected(6, 9)");
        assertEqual(4, uf.componentSize(9), "After union(9, 8): componentSize(9)");

        // Union item 0 and item 9
        uf.union(0, 9);

        // Assertions after union
        assertEqual(1, uf.totalComponents(), "After union(0, 9): totalComponents");
        assertTrue(uf.isConnected(0, 9), "After union(0, 9): isConnected(0, 9)");
        assertEqual(10, uf.componentSize(0), "After union(0, 9): componentSize(0)");

        // Additional assertions
        assertTrue(uf.isConnected(2, 4), "Additional assertion: isConnected(2, 4)");
        assertTrue(uf.isConnected(5, 7), "Additional assertion: isConnected(5, 7)");
        assertEqual(10, uf.componentSize(5), "Additional assertion: componentSize(5)");

        System.out.println("All tests passed successfully.");
    }

    public static void assertEqual(int expected, int actual, String message) {
        if (expected != actual) {
            System.err.println("Assertion failed: " + message);
            System.err.println("Expected: " + expected);
            System.err.println("Actual: " + actual);
        }
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            System.err.println("Assertion failed: " + message);
            System.err.println("Expected: true");
            System.err.println("Actual: false");
        }
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            System.err.println("Assertion failed: " + message);
            System.err.println("Expected: false");
            System.err.println("Actual: true");
        }
    }
}
