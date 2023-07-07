package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();

        dfs(0, input, path, results);

        for (List<Integer> arr: results) {
            System.out.println();
            System.out.print("[");
            for (Integer n: arr) {
                System.out.print(n + " ");
            }
            System.out.print("]");
        }
    }

    public static void dfs(int i, int[] numbs, List<Integer> path, List<List<Integer>> result) {
        if (i >= numbs.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Choose
        path.add(numbs[i]);
        dfs(i + 1, numbs, path, result);

        // Un-choose
        path.remove(path.size() - 1);
        dfs(i + 1, numbs, path, result);
    }
}
