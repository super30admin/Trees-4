// TC - O(k) -- in worst case O(n) - confirm once
// SC - O(k) -- in the worst case O(n) - confirm once

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
    int result; int count;
    public int kthSmallest(TreeNode root, int k) {
        result = 0;
        count = k; 
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        // base
        if(root == null) return;
        // logic
        helper(root.left);
        // As we want to traverse inorder we do the jingbang of count here
        // If we do it above helper(root.left) then it will cause preorder traversal
        // If we do it below helper(root.right) then it will cause postorder traversal
        count--;
        if(count == 0){
            result = root.val;
        }
        helper(root.right);
    }
}