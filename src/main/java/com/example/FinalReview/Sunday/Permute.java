package main.java.com.example.FinalReview.Sunday;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> tempList = new ArrayList<>();
        dfs(nums, visited, tempList, result);
        return result;
    }

    private static void dfs(int[] nums, boolean[] visited, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempList.add(nums[i]);
                dfs(nums, visited, tempList, result);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
