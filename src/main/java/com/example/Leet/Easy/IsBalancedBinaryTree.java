package main.java.com.example.Leet.Easy;

import main.java.com.example.DataStructures.Graphs.Trees.TreeNode;

public class IsBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return subtreeBalanced(root) != -1;
    }

    public int subtreeBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeHeight = subtreeBalanced(root.left);

        if (leftTreeHeight == -1) {
            return -1;
        }

        int rightTreeHeight = subtreeBalanced(root.right);

        if (rightTreeHeight == -1) {
            return -1;
        }

        int heightDiff = leftTreeHeight - rightTreeHeight;

        if (Math.abs(heightDiff) > 1) {
            return -1;
        }

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
}
