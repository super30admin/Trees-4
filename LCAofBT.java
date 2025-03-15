public class LCAofBT {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if root is null or equal to p or q, return root
        if (root == null || root == p || root == q) return root;

        // search for LCA in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // search for LCA in right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p or q not found in either subtree
        if (left == null && right == null) return null;

        // p and/or q found in the right subtree
        if (left == null) return right;

        // p and/or q found in the left subtree
        if (right == null) return left;

        // p and q found in left and right subtrees, means this root is LCA
        return root;
    }
}
