 /*Time Complexity: O(n)
 *Space Complexity: O(k) k is height of tree
 *Expln: Perform inorder traversal by decrasing the count to find the valid kth kthSmallest as its a valid BST
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
class Solution {
    int result = -1;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return result;
        count = k;
        helper(root);
        return result;
    }
    private void helper(TreeNode root)
    {
        if(root == null) return;
        
        helper(root.left);
        count--;
        if(count == 0)
        {
            result = root.val;
            return;
        }
        if(result == -1)
            helper(root.right);
    }
}