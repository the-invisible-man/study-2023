package main.java.com.example.Leet.Easy;

import main.java.com.example.DataStructures.Graphs.Trees.Trie;

import java.util.ArrayList;
import java.util.List;

public class FloodFill {
    public int[][] floodFill(int[][] image, int row, int column, int color) {
        int maxRow = image.length - 1;
        int maxColumn = image[0].length - 1;
        int startingColor = image[row][column];

        List<Trie.Node> s = new ArrayList<>();

        if (startingColor == color) {
            return image;
        }

        image[row][column] = color;

        if (row > 0 && (image[row-1][column] == startingColor)) {
            floodFill(image, row - 1, column, color);
        }

        if (row <= maxRow - 1 && (image[row+1][column] == startingColor)) {
            floodFill(image, row + 1, column, color);
        }

        if (column > 0 && (image[row][column-1] == startingColor)) {
            floodFill(image, row, column - 1, color);
        }

        if (column <= maxColumn - 1 && (image[row][column+1] == startingColor)) {
            floodFill(image, row, column + 1, color);
        }

        return image;
    }
}
