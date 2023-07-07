package Leet.Easy;

import DataStructures.Graphs.Trees.TreeNode;

public class DiameterOfBinaryTree {
    private static int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        return findHeight(root)[0];
    }

    public static int[] findHeight(TreeNode root) {
        int[] out = new int[2];

        if (root == null) {
            out[0] = -1;
            return out;
        }

        int[] leftHeight = findHeight(root.left);
        int[] rightHeight = findHeight(root.right);

        out[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
        out[1] = Math.max(out[1], leftHeight[0] + rightHeight[0] + 2);

        return out;
    }
}
