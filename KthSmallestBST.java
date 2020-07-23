// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(h). h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



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
    int kthElem=0;
    int count=0;
    int foundElement=0;
    
    public int kthSmallest(TreeNode root, int k) {
        kthElem=k;
         helper(root);
        return foundElement;
    }
    
    private void helper(TreeNode root){
        
        if(root==null) return;
        
        
            
        
        helper(root.left);
                count++;
        if(kthElem==count) {
            foundElement=root.val;
            return;
        }
        helper(root.right);
    }
}
