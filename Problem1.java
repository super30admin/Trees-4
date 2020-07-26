// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


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
    int count = 0, result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root, k);
        return result; 
    }
    
    private void helper(TreeNode root, int k){
        if(root == null) return;
        
        helper(root.left, k);

        count--;        
        if(count==0){ 
            result = root.val;
            return;
        }
        
        helper(root.right, k);
    }
}