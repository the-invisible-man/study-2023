package main.java.com.example.DataStructures.Graphs.Trees;

import java.util.ArrayList;

public class BinaryTree {

    public static void main(String[] args) {
        Node root = new Node();
        root.data = 'F';

        insert(root, 'D');
        insert(root, 'J');
        insert(root, 'B');
        insert(root, 'E');
        insert(root, 'G');
        insert(root, 'K');
        insert(root, 'A');
        insert(root, 'C');
        insert(root, 'I');
        insert(root, 'H');

//        if (!search(root, 345)) {
//            System.out.println("The number 345 was not found");
//        }
//
//        System.out.println("Min val is " + findMin(root));
//        System.out.println("Max val is " + findMax(root));
//        System.out.println("Height of the tree is " + findHeight(root));

//        depthFirstPostOrder(root);

//        breadthFirst(root);

        if (isBinarySearchTree(root)) {
            System.out.println("This is a binary search tree");
        } else {
            System.out.println("This is not a binary search tree");
        }
    }

    public static void insert(Node root, char val) {
        if (val <= root.data) {
            if (root.left != null) {
                insert(root.left, val);
                return;
            }
            root.left = new Node();
            root.left.data = val;
        } else {
            if (root.right != null) {
                insert(root.right, val);
                return;
            }
            root.right = new Node();
            root.right.data = val;
        }
    }

    public static void insert(TreeNode root, int val) {
        if (val <= root.val) {
            if (root.left != null) {
                insert(root.left, val);
                return;
            }
            root.left = new TreeNode();
            root.left.val = val;
        } else {
            if (root.right != null) {
                insert(root.right, val);
                return;
            }
            root.right = new TreeNode();
            root.right.val = val;
        }
    }

    public static void delete(Node root, int val) {
        /*
         * Case 1: No children
         *      This is a lead node. Just set the pointer that points to it
         *      as null. Java will take care of the garbage collection
         *
         * Case 2: One child
         *      Point the parent to the child's subtree. Delete child
         *
         * Case 3: Two children
         *      Find the min in the right subtree. Copy the value into targeted.
         *      Delete the leaf node.
         */


    }

    public static boolean isBinarySearchTree(Node root) {
        ArrayList<Character> list = toArrayInOrder(root);

        Integer previousVal = null;

        for (int i: list){
            if (previousVal != null && i < previousVal) {
                return false;
            }

            previousVal = i;
        }

        return true;
    }

    public static ArrayList<Character> toArrayInOrder(Node root) {
        ArrayList<Character> list = new ArrayList<>();

        populateInOrder(root, list);

        return list;
    }

    public static void populateInOrder(Node root, ArrayList<Character> list) {
        if (root == null) {
            return;
        }

        populateInOrder(root.left, list);
        list.add(root.data);
        populateInOrder(root.right, list);
    }

    public static void breadthFirst(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNodeQueue queue = new TreeNodeQueue();
        TreeNode current;

        queue.enqueue(root);

        while (!queue.isEmpty()) {
            current = queue.front();
            System.out.println(current.val);

            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }
            queue.dequeue();
        }

    }

    public static void depthFirstPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        depthFirstPreOrder(root.left);
        depthFirstPreOrder(root.right);
    }

    public static void depthFirstInOrder(Node root) {
        if (root == null) {
            return;
        }
        depthFirstInOrder(root.left);
        System.out.println(root.data);
        depthFirstInOrder(root.right);
    }

    public static void depthFirstPostOrder(Node root) {
        if (root == null) {
            return;
        }
        depthFirstPostOrder(root.left);
        depthFirstPostOrder(root.right);
        System.out.println(root.data);
    }

    public static int findHeight(Node root, int d) {
        if (root == null) {
            d = 0;
            return -1;
        }

        int leftHeight = findHeight(root.left, d);
        int rightHeight = findHeight(root.right, d);

        d = leftHeight + rightHeight + 2;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int findMin(Node root) {
        Node current = root;

        while(current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public static int findMax(Node root) {
        Node current = root;

        while(current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    public static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        } else if (root.data == val) {
            return true;
        }

        if (val < root.data) {
            return search(root.left, val);
        }

        return search(root.right, val);
    }

    public static void remove(Node root, int val) {
        //
    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);



        return Math.max(left, right) + 1;
    }
}
