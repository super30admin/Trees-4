// TC : O(h)
// SC : O(h) recursive stack
// Runs on LeetCode: YES
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        //logic
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right == null) {
            return null;
        }

        return root;
    }
}