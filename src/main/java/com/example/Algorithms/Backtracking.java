package main.java.com.example.Algorithms;

import java.util.*;

public class Backtracking {
    public static void main(String[] args) {
        // Find all possible permutations of [1, 2, 3]
        // [1, 2, 3], [2, 1, 3], [3, 2, 1], [3, 1, 2], [2, 3, 1]. [1, 2, 3]
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = new ArrayList<>();
//        return dfs(nums, results);
    }

    public static List<List<Integer>> dfs(int[] nums, List<List<Integer>> results)
    {
        HashMap<Integer, List<Integer>> adjL = new HashMap<>();

        int[][] positions = {{-1, 0}, {0, 1}, {1, 0}, {-1, 0}};

        int[] pos = {0, 0};

        Set<Integer> visited = new HashSet<>();

        List<Integer> path = new ArrayList<>();
        dfs(nums, path, results, new boolean[nums.length]);
        return results;
    }

    public static void dfs(int[] nums, List<Integer> path, List<List<Integer>> results, boolean[] visited)
    {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, path, results, visited);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
