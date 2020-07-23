// Time complexity - O(n)
// Space complexity - O(h)

// Recursive solution

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
    int result;
    int c = 0;
    public int kthSmallest(TreeNode root, int k) {
        result = -1;
        helper(root,k);
        return result;
    }
    
    private void helper(TreeNode root, int k){
        if(root == null) return;
        helper(root.left,k);
        c++;
        if(c == k){
            result = root.val;
        }
        helper(root.right,k);
        
    }
}
