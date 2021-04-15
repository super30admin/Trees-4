// Time Complexity : O(n) where n - height of the tree
// Space Complexity : O(n) height of the tree which occupies the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        if(root == null) return null;
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        if(root.val>p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}
