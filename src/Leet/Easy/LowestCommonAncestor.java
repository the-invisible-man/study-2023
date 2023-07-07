package Leet.Easy;

import DataStructures.Graphs.Trees.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        do {
            // As long as we move in the same direction, we will keep finding a LCA
            // If the two nodes diverge, or if the value of the discovered ancestor
            // equals that of one of the nodes, we stop and return the value of the
            // discovered node.
            if (current.val == p.val || current.val == q.val) {
                return current;
            }

            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else if (p.val <= current.val && q.val <= current.val) {
                current = current.left;
            } else {
                return current;
            }
        } while(true);
    }
}
