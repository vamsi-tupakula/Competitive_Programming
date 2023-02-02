package Java.BinaryTrees;

public class Diameter {
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

    // Approach 1 : O(n^2)
    public static int diameterApproach1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = diameterApproach1(root.left);
        int d2 = diameterApproach1(root.right);
        int d3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(d1, Math.max(d2, d3));
    }

    // Approach 2 : O(n)
    static class NodeInfo {
        int height;
        int diameter;

        NodeInfo(int h, int d) {
            this.height = h;
            this.diameter = d;
        }
    }

    public static NodeInfo diameterApproach2(TreeNode root) {
        if (root == null) {
            return new NodeInfo(0, 0);
        }
        NodeInfo left = diameterApproach2(root.left);
        NodeInfo right = diameterApproach2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int d1 = left.diameter;
        int d2 = right.diameter;
        int d3 = left.height + right.height + 1;

        return new NodeInfo(myHeight, Math.max(d3, Math.max(d1, d2)));
    }

    public static void main(String[] args) {
        // preorder sequence
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = buildTreePreOrder(nodes);

        System.out.println(diameterApproach1(root));
        System.out.println(diameterApproach2(root).diameter);
    }
}
