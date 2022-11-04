// Time Complexity : O(k)
// Space Complexity : O(h) in case of balanced tree O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    int increment = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;

        root = helper(root, k);

        return root.val;
    }

    private TreeNode helper(TreeNode root, int k) {
        if(root == null) return root;

        TreeNode left = helper(root.left, k);
        if(left != null) return left;

        increment++;
        if(increment == k) return root;

        return helper(root.right, k);
    }
}