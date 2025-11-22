// Time Complexity :O(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
we are calling the function recusively on left tree and right tree
using we find the both node, bottom up approach
we return once we find either p or q or node is null
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left == null && right != null)
            return right;
        else if (left != null && right == null)
            return left;
        else
            return null;
    }
}