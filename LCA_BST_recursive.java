//235. Lowest Common Ancestor of a Binary Search Tree: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Time Complexity : O(Height)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//without using helper method

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
        if(root == null) return root;
        
        if(p.val < root. val && q.val < root.val){
           return lowestCommonAncestor(root.left, p, q);
            
        } else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q); 
        } 
        
        return root;
    }
}