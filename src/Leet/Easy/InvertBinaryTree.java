package Leet.Easy;

import DataStructures.Graphs.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static TreeNode invert(TreeNode root)
    {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.peek();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.right != null) {
                queue.add(current.right);
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            queue.remove();
        }

        return root;
    }
}
