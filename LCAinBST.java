class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// TC: O(n) as all the nodes are touched.
// SC: O(1) No extra space is used
public class LCAinBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(lowestCommonAncestorRecursive(root, root.left.left, root.left.right).val); // 2
        System.out.println(lowestCommonAncestorIterative(root, root.left.right.right, root.right.left).val); // 6
    }

    // Recursive approach
    public static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode left, TreeNode right) {
        if (left.val > root.val && right.val > root.val)
            return lowestCommonAncestorRecursive(root.right, left, right);
        else if (left.val < root.val && right.val < root.val)
            return lowestCommonAncestorRecursive(root.left, left, right);
        return root;
    }

    // Iterative Approach
    public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return null;
        while (true) {
            if (root.val > left.val && root.val > right.val) {
                root = root.left;
            } else if (root.val < left.val && root.val < right.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

}