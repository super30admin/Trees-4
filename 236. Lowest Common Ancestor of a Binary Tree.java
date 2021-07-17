class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // one more checking step then bst
        if(left != null && right != null)
            return root;
        return left == null? right:left;
    }
}