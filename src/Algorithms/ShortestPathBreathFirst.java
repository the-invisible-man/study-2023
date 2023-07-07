package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In this algorithm, we count the distance of the shortest path
 * from one node to another given a grid/adjacency matrix and exploring it
 * breadth first. We do this by moving in layers and counting the total layers
 * that we've moved every time. If we reach our destination, we return the total
 * layers that we moved through;
 */
public class ShortestPathBreathFirst {
    public static void main(String[] args) {
        // 0 = walkable path
        // 1 = obstacle
        // 2 = exit
        int[][] grid = {{0, 0, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0},
                        {1, 0, 1, 2, 0, 1, 0}};

        // Direction vectors
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Visited node tracker
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean reachedEnd = false;
        visited[0][0] = true;

        int moveCount = 0;
        int nodesLeftInLayer = 1;
        int nodesInNextLayer = 0;

        // Coordinate queues
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();

        int currentRow, currentCol, newRow, newCol;

        // Starting point
        rq.add(0);
        cq.add(0);

        while(!rq.isEmpty()) {
            currentRow = rq.poll();
            currentCol = cq.poll();

            if (grid[currentRow][currentCol] == 2) {
                // We found our destination
                reachedEnd = true;
                break;
            }

            // Explore neighbors
            for (int[] direction: directions) {
                newRow = currentRow + direction[0];
                newCol = currentCol + direction[1];

                if (newCol < 0 || newRow < 0 || newRow >= grid.length || newCol >= grid[0].length) continue;
                if (visited[newRow][newCol]) continue;
                if (grid[newRow][newCol] == 1) continue;

                visited[newRow][newCol] = true;
                nodesInNextLayer++;
                rq.add(newRow);
                cq.add(newCol);
            }

            nodesLeftInLayer--;

            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                // Basically counts how many layers we've gone through
                moveCount++;
            }
        }

        if (reachedEnd) {
            System.out.println("We reached the end of the maze in " + moveCount + " moves");
        } else {
            System.out.println("Could not reach the end of the maze");
        }
    }
}
