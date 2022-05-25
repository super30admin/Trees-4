/*
Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/
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
// TC: O(n)
// SC: O(n)
class Solution {
    Integer result;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return result;
    }
    
    private void traverse(TreeNode root) {
        if (root == null || result != null)
            return;
        
        traverse(root.left);
        --k;
        
        if (k == 0) {
            result = root.val;
            return;
        }
        
        traverse(root.right);
    }
}