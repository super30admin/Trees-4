// Time Complexity : O(h) height of the binary tree
// Space Complexity : O(h)

/*
 * go to left and right of the root. when we find the element p or w
 * we return from there and whichever side returns it we return that value.
 */

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
        if(root == null || p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null  && right == null) return null;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return root;
    }
}