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
    // Time Complexity : O(N) N: nodes of Tree
// Space Complexity : O(logN)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

 /* 
 Recursion:
 1. Do postorder and check if p and q are present at node
 2. If present return it to its parent root untill both p and q are found at a node.
 */
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root; //it will handle the case of skewed p,q nodes also
        
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        
        if((l!=null && r!=null)) 
            return root;
        else{
            if(l!=null) return l;
            if(r!=null) return r;
        }
        
        return null;        
    }
}