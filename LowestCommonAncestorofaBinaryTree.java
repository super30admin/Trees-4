// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base
        if (root == null || root == p || root == q)
            return root;

        // logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null)
            return null;

        else if (left != null && right == null)
            return left;

        else if (left == null && right != null)
            return right;

        else
            return root;

    }
}