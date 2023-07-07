package FinalReview;

public class UnionFindTest {

    public static void main(String[] args) {
        testUnionFind();
    }

    public static void testUnionFind() {
        UnionFind uf = new UnionFind(10);

        // Initial state assertions
        assert uf.totalComponents() == 10;
        assert !uf.isConnected(0, 1);
        assert uf.componentSize(0) == 1;

        // Union item 0 and item 1
        uf.union(0, 1);

        // Assertions after union
        assert uf.totalComponents() == 9;
        assert uf.isConnected(0, 1);
        assert uf.isConnected(1, 0);
        assert uf.componentSize(0) == 2;
        assert uf.componentSize(1) == 2;

        // Union item 2 and item 3
        uf.union(2, 3);

        // Assertions after union
        assert uf.totalComponents() == 8;
        assert uf.isConnected(2, 3);
        assert uf.isConnected(3, 2);
        assert uf.componentSize(2) == 2;
        assert uf.componentSize(3) == 2;

        // Union item 1 and item 3
        uf.union(1, 3);

        // Assertions after union
        assert uf.totalComponents() == 7;
        assert uf.isConnected(0, 2);
        assert uf.isConnected(2, 0);
        assert uf.isConnected(1, 3);
        assert uf.isConnected(3, 1);
        assert uf.componentSize(0) == 4;
        assert uf.componentSize(1) == 4;

        // Union item 4 and item 5
        uf.union(4, 5);

        // Assertions after union
        assert uf.totalComponents() == 6;
        assert uf.isConnected(4, 5);
        assert uf.isConnected(5, 4);
        assert uf.componentSize(4) == 2;
        assert uf.componentSize(5) == 2;

        // Union item 2 and item 5
        uf.union(2, 5);

        // Assertions after union
        assert uf.totalComponents() == 5;
        assert uf.isConnected(0, 4);
        assert uf.isConnected(4, 0);
        assert uf.componentSize(0) == 5;

        // Union item 6 and item 7
        uf.union(6, 7);

        // Assertions after union
        assert uf.totalComponents() == 4;
        assert uf.isConnected(6, 7);
        assert uf.isConnected(7, 6);
        assert uf.componentSize(6) == 2;
        assert uf.componentSize(7) == 2;

        // Union item 7 and item 8
        uf.union(7, 8);

        // Assertions after union
        assert uf.totalComponents() == 3;
        assert uf.isConnected(6, 8);
        assert uf.isConnected(8, 6);
        assert uf.componentSize(8) == 3;

        // Union item 9 and item 8
        uf.union(9, 8);

        // Assertions after union
        assert uf.totalComponents() == 2;
        assert uf.isConnected(6, 9);
        assert uf.isConnected(9, 6);
        assert uf.componentSize(9) == 4;

        // Union item 0 and item 9
        uf.union(0, 9);

        // Assertions after union
        assert uf.totalComponents() == 1;
        assert uf.isConnected(0, 9);
        assert uf.isConnected(9, 0);
        assert uf.componentSize(0) == 10;
    }
}
