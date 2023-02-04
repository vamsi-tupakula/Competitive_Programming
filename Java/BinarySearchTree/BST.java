package Java.BinarySearchTree;

public class BST {
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

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 3, 4, 2, 7 };
        TreeNode root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorderTraversal(root);
        System.out.println();
    }
}
