// Time Complexity : O(H)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        helper(root, p, q);
        return result;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (p.val < root.val && q.val < root.val) {
            helper(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            helper(root.right, p, q);
        } else {
            result = root;

        }
    }
}