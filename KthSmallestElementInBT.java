// TC: O(n)
// SC: O(h) recursive stack
// Runs on LeetCode: YES
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
    int count = 0;
    int result = Integer.MAX_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        helper(root.right);
    }
}