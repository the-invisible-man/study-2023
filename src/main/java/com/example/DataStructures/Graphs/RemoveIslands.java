package main.java.com.example.DataStructures.Graphs;

import java.util.HashSet;
import java.util.Set;

public class RemoveIslands {
    public static int[][] positions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        // Find all 1s on the edges
        //      Use dfs to look for neighbors
        //      If zero return
        //      If 1 then change to two
        int[][] input = {   {1, 0, 0, 0, 0, 0},
                            {0, 1, 0, 1, 1, 1},
                            {0, 0, 1, 0, 1, 0},
                            {1, 1, 0, 0, 1, 0},
                            {1, 0, 1, 1, 0, 0},
                            {1, 0, 0, 0, 0, 1}};

        input = removeIslands(input);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] removeIslands(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        // Process top edge
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(0, i, matrix, visited);
        }

        // Process bottom edge
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix.length - 1, i, matrix, visited);
        }

        // Process left edge
        for (int i = 1; i < matrix.length -1; i++) {
            dfs(i, 0, matrix, visited);
        }

        // Process right edge
        for (int i = 1; i < matrix.length -1; i++) {
            dfs(i, matrix[0].length - 1, matrix, visited);
        }

        // We've now marked everything we should have marked
        // Eliminate all 1s, change 2s to 1s, skip 0
        // O(m*n);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) continue;

                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }

                if (matrix[i][j] == 2) {
                    matrix[i][j] = 1;
                }
            }
        }

        Set<Integer> s = new HashSet<>();

        return matrix;
    }

    public static void dfs(int r, int c, int[][] matrix, boolean[][] visited) {
        if (matrix[r][c] == 0 || visited[r][c]) return;

        int newC, newR;
        matrix[r][c] = 2;
        visited[r][c] = true;

        for (int[] position: positions) {
            newR = r + position[0];
            newC = c + position[1];

            // Check that we're not outside the bounds of the matrix
            if (newR < 0 || newC < 0 || newR >= matrix.length || newC >= matrix[0].length) {
                continue;
            }

            dfs(newR, newC, matrix, visited);
        }
    }
}
