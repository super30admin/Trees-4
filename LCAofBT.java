/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : Add : O(N),
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || root == p || root == q)
            return root;
        
        //logic  // T.C - O(N), S.C - O(1)
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        
        if(left == null && right == null) return null;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return root;
    }
}
