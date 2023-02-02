package Java.BinaryTrees;

public class HeightOfTheTree {
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

    public static int heightOfTree(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public static void main(String[] args) {
        // preorder sequence
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = buildTreePreOrder(nodes);

        System.out.println(heightOfTree(root));
    }
}
