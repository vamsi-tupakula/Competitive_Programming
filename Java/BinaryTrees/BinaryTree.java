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
    
    public static void main(String[] args) {
        // preorder sequence
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = BinaryTree.buildTreePreOrder(nodes);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
    }
}
