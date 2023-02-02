package Java.BinaryTrees;

public class BinaryTree {
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
    
    public static void printPreorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void printInorder(TreeNode root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // preorder sequence
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = buildTreePreOrder(nodes);

        System.out.println("preorder sequence : ");
        printPreorder(root);
        System.out.println();
        System.out.println("inorder sequence : ");
        printInorder(root);
    }
}
