/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Time complexity - O(n)
 // Space complexity - O(n)
 // Solved on leetcode - yes
 // Faced any issues - no
 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return the non-null one
        return left != null ? left : right;
    }
}
