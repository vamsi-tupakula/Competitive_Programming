package Java.BinaryTrees;

public class SubtreeOfOtherTree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if subroot is null
        if (subRoot == null)
            return true;
        
        if (root == null)
            return false;

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        
        if (root == null || subRoot == null)
            return false;

        if (root.data == subRoot.data)
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode subRoot = new TreeNode(2);
        subRoot.left = new TreeNode(4);
        subRoot.right = new TreeNode(5);

        System.out.println(isSubtree(root, subRoot));
    }
}

/**
 * root :
 *       1
 *     /   \
 *    2     3
 *   / \   /  \
 *  4   5 6    7
 * 
 * subRoot :
 *       2
 *     /   \
 *   4       5
 */