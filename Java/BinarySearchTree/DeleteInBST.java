package Java.BinarySearchTree;

public class DeleteInBST {
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

    public static TreeNode delete(TreeNode root, int data) {
        if (root.data > data) {
            root.left = delete(root.left, data);
        } else if (root.data < data) {
            root.right = delete(root.right, data);
        } else { // root.data == data
            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            TreeNode inorder_succ = inorderSuccessor(root.right);
            root.data = inorder_succ.data;
            root.right = delete(root.right, inorder_succ.data);
        }

        return root;
    }

    private static TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
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
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        TreeNode root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorderTraversal(root);
        System.out.println();
        root = delete(root, 5);
        inorderTraversal(root);
    }
}
