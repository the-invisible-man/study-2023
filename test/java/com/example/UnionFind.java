package com.example;

import org.junit.Assert;
import org.junit.Test;
import main.java.com.example.FinalReview.UnionFind;

public class UnionFindTest {

    @Test
    public void testUnionFind() {
        UnionFind uf = new UnionFind(10);

        // Initial state assertions
        Assert.assertEquals(10, uf.totalComponents());
        Assert.assertFalse(uf.isConnected(0, 1));
        Assert.assertEquals(1, uf.componentSize(0));

        // Union item 0 and item 1
        uf.union(0, 1);

        // Assertions after union
        Assert.assertEquals(9, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(0, 1));
        Assert.assertTrue(uf.isConnected(1, 0));
        Assert.assertEquals(2, uf.componentSize(0));
        Assert.assertEquals(2, uf.componentSize(1));

        // Union item 2 and item 3
        uf.union(2, 3);

        // Assertions after union
        Assert.assertEquals(8, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(2, 3));
        Assert.assertTrue(uf.isConnected(3, 2));
        Assert.assertEquals(2, uf.componentSize(2));
        Assert.assertEquals(2, uf.componentSize(3));

        // Union item 1 and item 3
        uf.union(1, 3);

        // Assertions after union
        Assert.assertEquals(7, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(0, 2));
        Assert.assertTrue(uf.isConnected(2, 0));
        Assert.assertTrue(uf.isConnected(1, 3));
        Assert.assertTrue(uf.isConnected(3, 1));
        Assert.assertEquals(4, uf.componentSize(0));
        Assert.assertEquals(4, uf.componentSize(1));

        // Union item 4 and item 5
        uf.union(4, 5);

        // Assertions after union
        Assert.assertEquals(6, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(4, 5));
        Assert.assertTrue(uf.isConnected(5, 4));
        Assert.assertEquals(2, uf.componentSize(4));
        Assert.assertEquals(2, uf.componentSize(5));

        // Union item 2 and item 5
        uf.union(2, 5);

        // Assertions after union
        Assert.assertEquals(5, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(0, 4));
        Assert.assertTrue(uf.isConnected(4, 0));
        Assert.assertEquals(5, uf.componentSize(0));

        // Union item 6 and item 7
        uf.union(6, 7);

        // Assertions after union
        Assert.assertEquals(4, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(6, 7));
        Assert.assertTrue(uf.isConnected(7, 6));
        Assert.assertEquals(2, uf.componentSize(6));
        Assert.assertEquals(2, uf.componentSize(7));

        // Union item 7 and item 8
        uf.union(7, 8);

        // Assertions after union
        Assert.assertEquals(3, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(6, 8));
        Assert.assertTrue(uf.isConnected(8, 6));
        Assert.assertEquals(3, uf.componentSize(8));

        // Union item 9 and item 8
        uf.union(9, 8);

        // Assertions after union
        Assert.assertEquals(2, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(6, 9));
        Assert.assertTrue(uf.isConnected(9, 6));
        Assert.assertEquals(4, uf.componentSize(9));

        // Union item 0 and item 9
        uf.union(0, 9);

        // Assertions after union
        Assert.assertEquals(1, uf.totalComponents());
        Assert.assertTrue(uf.isConnected(0, 9));
        Assert.assertTrue(uf.isConnected(9, 0));
        Assert.assertEquals(10, uf.componentSize(0));
    }
}
