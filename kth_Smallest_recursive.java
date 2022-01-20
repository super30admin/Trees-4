// Time complexity : O(n)
// Space complexity : O(n) - Recursive Stack

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
    int x;
    
    public int kthSmallest(TreeNode root, int k) {
        
        // Reccursive approach
        x = k; 
        return helper(root , x);
    }
    
    private int helper(TreeNode root , int k){
        
        
        if (root == null){
            return Integer.MAX_VALUE;
        }
        // Inorder traversal 
        // left subtree
        int left = helper(root.left , x);
        
        // indicating one node is traversed
        x--;
        
        // Stop the traversal and return the root
        if (x == 0){
            
            return root.val;
        }
        
        // Right sub tree
        int right = helper(root.right , x);
        
        
        return Math.min(left, right);
        
    }
}