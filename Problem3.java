// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We recurse through left and right subtree untill we find q or p or node is null
//We then pass the value given out by child node to its parent
//If both left and right node gives null then parent node takes null node
//if one of the node gives null and other non null then parent takes non null value
//if both child node gives non null value then parent node is the LCA
//This is a bottom up approach

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
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) {
            return null;
        } else if(left != null && right == null) {
            return left;
        } else if(left == null && right != null) {
            return right;
        } else {
            //both are non null values
            return root;
        }
        
    }
}
