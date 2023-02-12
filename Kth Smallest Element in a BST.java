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

 // Time Complexity = O(n)
 // Space Complexity = O(h)

class Solution {
    private int count;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k){
        // base
        if (root == null) {
            return;
        }
        //
        inorder(root.left, k);
        count++;
        if(count == k)
            result = root.val;
        
        inorder(root.right, k);
        
    }
}