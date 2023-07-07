package DataStructures.Graphs.Trees;

public class AVL {
    // A self-balancing binary search tree that uses
    // tree rotations based on the balance factor of
    // all subtrees.
    //
    // The balance factor (BF) can be calculated as
    //          BF = height(node.right) - height (node.left)
    //
    // If the BF is -1, 0, or 1, then the tree satisfies
    // the AVL invariant. If the tree is >=+-2 then we must
    // perform rotations to rebalance the tree so that the
    // BF satisfies the invariant.
    //
    //

    public Node insert(int value, Node root) {
        if (!this.contains(value, root)) {
            return this.doInsert(value, root);
        }
        return null;
    }

    public Node doInsert(int value, Node root) {
        if (root == null) return new Node(value);

        if (value < root.value){
            this.doInsert(value, root.left);
        } else {
            this.doInsert(value, root.right);
        }

        this.update(root);

        return this.balance(root);
    }

    // Balances the tree and returns the root node
    public Node balance(Node node) {
        // Because the balance factor is -2,
        // then that means that the height of the left subtree
        // is greater than the height of the right subtree
        if (node.bf == -2) {
            if (node.left.bf <= 0) {
                return this.leftLeftCase(node);
            } else {
                return this.leftRightCase(node);
            }
        // Because the balance factor is 2, then
        // the height of the right subtree is greater
        // than the height of the left subtree
        } else if (node.bf == 2) {
            if (node.right.bf >= 0) {
                return this.rightRightCase(node);
            } else {
                return this.rightLeftCase(node);
            }
        }

        return node;
    }

    public Node leftLeftCase(Node node) {
        return this.rotateRight(node);
    }

    public Node leftRightCase(Node node) {
        node.left = this.leftLeftCase(node.left);
        return this.leftLeftCase(node);
    }

    public Node rightRightCase(Node node) {
        return this.rotateLeft(node);
    }

    public Node rightLeftCase(Node node) {
        node.right = this.rightRightCase(node);
        return this.rotateRight(node);
    }

    public Node rotateLeft(Node node) {
        Node b = node.left;
        node.left = b.right;
        b.right = node;

        this.update(node);
        this.update(b);

        return b;
    }

    public Node rotateRight(Node node) {
        Node b = node.right;
        node.right = b.left;
        b.left = node;

        this.update(node);
        this.update(b);

        return b;
    }

    // Updates the balance factor and height of a node
    public void update(Node root) {
        // Starting point for the balance factor
        // for both subtrees
        int lH = -1, rH = -1;

        // Keep height at -1 for null children
        lH = root.left == null ? lH : root.left.height;
        rH = root.right == null ? rH : root.right.height;

        // Get taller tree, cancel out -1 with +1
        root.height = 1 + Math.max(lH, rH);

        // Determine the balance factor by subtracting
        // the height of the left tree from the height
        // of the right subtree.
        root.bf = rH - lH;
    }

    public boolean contains(int value, Node root) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        // log(n) lookups
        return value < root.value ? this.contains(value, root.left) : this.contains(value, root.right);
    }

    public int getHeight(Node root) {
        if (root == null) {
            return -1;
        }

        return Math.max(this.getHeight(root.left), this.getHeight(root.right)) + 1;
    }

    static class Node {
        Node left, right;
        int height;
        int value;
        int bf;

        public Node(int value) {
            this.value = value;
        }
    }
}
