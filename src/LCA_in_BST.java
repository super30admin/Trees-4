// Time Complexity : O(log n)
// Space Complexity : recursive - O(h), iterative- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
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
        
        return helperIterative(root, p, q);
    }
    
    private TreeNode helperIterative(TreeNode root, TreeNode p, TreeNode q) {
        
        while(true) {
           if( p.val < root.val && q.val < root.val){
            root = root.left;
        }else if (p.val > root.val && q.val > root.val){
            root= root.right;
        }else {
           return root;
       } 
        }
        
    }
    
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        //base - we dont need a base case since its a binary search tree and p&q are different
       
        //logic
       if( p.val < root.val && q.val < root.val){
            return helper(root.left, p, q);
        }else if (p.val > root.val && q.val > root.val){
             return helper(root.right, p, q);
        }else {
           return root;
       }
    }
}