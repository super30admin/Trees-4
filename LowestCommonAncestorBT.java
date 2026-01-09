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
    // Approach: Recursion
    // TC: O(N); N = number of nodes in the tree
    // SC: O(h) for recursive stack where h = height of the tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right == null) {
            return left;
        }
        if (right != null && left == null) {
            return right;
        }
        if (left != null && right != null) {
            return root;
        }
        return null;
    }
}