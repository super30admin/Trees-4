
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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
    int c = 0;
    int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        c=k;
        helper(root, k);
        return result;
    }
    
    private void helper(TreeNode root, int k){
        //base
        if(root==null){
            return;
        }
        
        //action
        helper(root.left, k);
        c--;
        if(c==0){
            result = root.val;
            return;
        }
        
        helper(root.right, k);
        
        
    }
}