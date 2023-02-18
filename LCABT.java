// Time Complexity : O(n)
// Space Complexity : O(h) //memory stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//go through entire tree
//check if exists p/q/null return that
// othervise expand 
//once done with expansion, if the left is null return right
//if left exists and right null return left
//other wise root

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}