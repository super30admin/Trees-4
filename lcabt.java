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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // encountered p or q or null
            return root; // return as it is
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); // move left
        TreeNode right = lowestCommonAncestor(root.right, p, q); // move right
        if (left == null && right == null) { // both are null
            return null;
        }
        if (left == null && right != null) { // entire right sub tree has p or q
            return right;
        }
        if (left != null && right == null) { // entire left sub tree has q or p
            return left;
        } else {
            return root; // return root
        }
    }
}