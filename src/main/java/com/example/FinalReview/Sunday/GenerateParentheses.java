package main.java.com.example.FinalReview.Sunday;

import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int leftCount, int rightCount, StringBuilder current, List<String> result) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(current.toString());
            return;
        }

        if (leftCount > 0) {
            current.append("(");
            backtrack(leftCount - 1, rightCount, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        if (rightCount > leftCount) {
            current.append(")");
            backtrack(leftCount, rightCount - 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);
        System.out.println(combinations);
    }
}
