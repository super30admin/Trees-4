TC:O(h)- h height of the tree
SC:O(1)
Successfully run on leetcode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int value;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return value;
    }
    private void helper(TreeNode root, int k){
        //base
        if(root==null) return;
        
            
        //logic
        helper(root.left,k);
        k--;
        if(k==0){
            
            value=root.val;
            return;
           
        } 
        helper(root.right,k);
        
    }
}