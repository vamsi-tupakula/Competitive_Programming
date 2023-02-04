package Java.BinarySearchTree;

public class SearchInBST {
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

    public static boolean searchInBST(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data > key) {
            return searchInBST(root.left, key);
        } else if (root.data < key) {
            return searchInBST(root.right, key);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        TreeNode root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.println(searchInBST(root, 6));
        System.out.println(searchInBST(root, 7));
    }
}
