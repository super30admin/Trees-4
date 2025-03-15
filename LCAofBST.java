/*
 * TC: O (h)
 * SC: O (h)
 */
public class LCAofBST {
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
        if (root == null) return null;

        if (p.val > root.val && q.val > root.val) {
            // both p & q are greater than the root, check on the right
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            // both p & q are less than the root, check on the left
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // p & q are in different subtrees, this is the LCA
            return root;
        }
    }
}
