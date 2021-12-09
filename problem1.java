// 230 Kth smalest Element in a BST
// Solved on Leetcode
// Time Complexity - O(n)
// space complexity - O(n)

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
        x=k;
      
        return   helper(root);
    }
    
    private int helper(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int left = helper(root.left);
        x--;
        if(x==0){
            return root.val;
        }
        int right = helper(root.right);
        
        return Math.min(left,right);
    }
}