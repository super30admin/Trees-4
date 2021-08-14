// Time Complexity : O(n), n = total number of nodes
// Space Complexity : O(H), H = height of the tree
// Did this code successfully run on Leetcode : Yes

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        if(left != null)
            return left;
        else if(right != null)
            return right;
        else 
            return null;
    }
}