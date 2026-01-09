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
    // TC: O(N); N = number of nodes in BST
    // SC: O(h); h = height of BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            // move left
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            // move right
            return lowestCommonAncestor(root.right, p, q);
        }
        // root is the lowest common ancestor
        return root;

    }
}