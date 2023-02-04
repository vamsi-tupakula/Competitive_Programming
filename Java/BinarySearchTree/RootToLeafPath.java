package Java.BinarySearchTree;

import java.util.*;

public class RootToLeafPath {
    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void printPaths(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(root.data);

        if (root.left == null && root.right == null) {
            System.out.println(arr);
        } else {
            printPaths(root.left, arr);
            printPaths(root.right, arr);
        }

        arr.remove(arr.size() - 1);
    }
    
    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        TreeNode root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        printPaths(root, new ArrayList<>());
    }
}
