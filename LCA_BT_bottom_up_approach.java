//236. Lowest Common Ancestor of a Binary Tree: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Time Complexity : O(N)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || root == p || root == q) return root;
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        else
            return null;
    }
}