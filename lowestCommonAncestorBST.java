//Time complexity O(n)
//Space complexity O(logn)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Logic Iterate in preorder fashion and see where the value of p,q would lie and then recursively calling only the left or right subtree until p and q are found.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            
            return null;
        }
        
        if(p.val < root.val && q.val < root.val){
            
         return   lowestCommonAncestor(root.left, p, q);
        }
        
         if(p.val > root.val && q.val > root.val){
            
           return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
        
    }
}