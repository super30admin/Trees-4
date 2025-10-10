// Time Complexity : O(h) -> balanced tree h = log n , skewed tree h = n.
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We use BST concept and recurse on left if p and q are on left to root
//we recurse on right if p and q are on right of node
//if p and q lies on two sides of root then our LCA is root
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
        if(root == null || p == null || q == null) return null;
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
