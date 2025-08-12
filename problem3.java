// Time Complexity : O(n)
// Space Complexity : O(height) of the tree for the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : As the base case I return as soon as I find a value - if I find it, the other one could be under it, i.e., this can be the lowest ancestor. If it is not it, I find left and right, which will return if they found any of these values. If left and right both have something, it means that the current node is the LCA so I return it. Else, if I got something from left but not right, it may contain both p and q, so I return whatever is passed along. Same for right.

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
        if(root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null) return root; // one exist on left side and one on the right
        if(left!=null) return left; // right is null, but we found something on the left
        return right; // left is null, right may have found something
    }
}