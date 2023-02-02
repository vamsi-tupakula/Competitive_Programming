package Java.BinaryTrees;

import java.util.*;

public class LevelOrderTraversal {
    static int idx = -1;

    public static TreeNode buildTreePreOrder(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[idx]);
        root.left = buildTreePreOrder(nodes);
        root.right = buildTreePreOrder(nodes);

        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return;
        }

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public static void printLevelOrderNewLine(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        // preorder sequence
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = buildTreePreOrder(nodes);

        System.out.println("normal level order traversal : ");
        printLevelOrder(root);
        System.out.println();
        System.out.println("Level order in which each level is in new line : ");
        printLevelOrderNewLine(root);
    }
}
